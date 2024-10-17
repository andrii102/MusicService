package lr4.menu;

import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadFromFileCommand implements Command {
    private MusicService musicService;
    private String filePath;
    private InputHandler inputHandler;
    private static final Logger logger = LoggerFactory.getLogger(LoadFromFileCommand.class);

    public LoadFromFileCommand(MusicService musicService, InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.musicService = musicService;
    }

    @Override
    public void execute() {
        try {
            filePath = inputHandler.getString("Enter file path: ");
            logger.info("Loading albums from file: " + filePath);
            musicService.loadFromFile(filePath);            
        }catch(Exception e){
            logger.error("Failed to load albums from file: " + filePath, e);
        }
    }

    @Override
    public String description() {
        return "Load from file";
    }
}
