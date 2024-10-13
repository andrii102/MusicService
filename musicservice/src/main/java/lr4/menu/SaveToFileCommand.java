package lr4.menu;

import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveToFileCommand implements Command {
    private MusicService musicService;
    private String filePath;
    private InputHandler inputHandler;
    private static final Logger logger = LoggerFactory.getLogger(SaveToFileCommand.class);

    public SaveToFileCommand(MusicService musicService, InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.musicService = musicService;
    }

    @Override
    public void execute() {
        try{
            filePath = inputHandler.getString("Enter file path: ");
            musicService.saveToFile(filePath);
            logger.info("Albums saved to file: " + filePath);
            System.out.println("Albums saved to file: " + filePath);            
        }catch(Exception e){
            logger.info("Failed to save albums to file: " + filePath, e);
            System.out.println("Failed to save albums to file: " + filePath);
        }
    }

    @Override
    public String description() {
        return "Save albums to file";
    }
}