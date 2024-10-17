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
        }catch(Exception e){
            logger.error("Failed to save albums to file: " + filePath, e);
        }
    }

    @Override
    public String description() {
        return "Save albums to file";
    }
}