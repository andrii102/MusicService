package lr4;

import lr4.music.MusicService;
import lr4.menu.Menu;
import lr4.menu.InputHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static InputHandler inputHandler = InputHandler.getInstance();
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        main.startApp();
    }

    public void startApp() {
        try {
            logger.info("Application started");
            MusicService musicService = new MusicService();
            Menu menu = new Menu(musicService, inputHandler);
            menu.run();

            logger.info("Application finished successfully");
        } catch (Exception e) {
            logger.error("Failed to start the application", e);
        }

    }
}
