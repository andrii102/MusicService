package lr4.menu;

import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortByStyleCommand implements Command {
    private MusicService musicService;
    private InputHandler inputHandler;
    private static final Logger logger = LoggerFactory.getLogger(SortByStyleCommand.class);

    public SortByStyleCommand(MusicService musicService) {
        this.musicService = musicService;
        this.inputHandler = InputHandler.getInstance();
    }

    @Override
    public void execute() {
        try{
            logger.info("In ascending - a | In descending - d");
            String order = inputHandler.getString("Enter choice: ");
            musicService.sortByStyle(order);
            logger.info("Albums sorted by style.");           
        }catch(Exception e){
            logger.error("Failed to sort albums by style", e);
        }
    }

    @Override
    public String description() {
        return "Sort albums by style.";        
    }
}
