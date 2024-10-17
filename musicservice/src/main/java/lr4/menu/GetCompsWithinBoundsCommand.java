package lr4.menu;

import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCompsWithinBoundsCommand implements Command {
    private MusicService musicService;
    private int bound1;
    private int bound2;
    private InputHandler inputHandler;
    private static final Logger logger = LoggerFactory.getLogger(GetCompsWithinBoundsCommand.class);

    public GetCompsWithinBoundsCommand(MusicService musicService, InputHandler inputHandler) {
        this.musicService = musicService;
        this.inputHandler = inputHandler;
    }

    @Override
    public void execute() {
        try {
            bound1 = inputHandler.getInt("Enter lower bound: ");
            bound2 = inputHandler.getInt("Enter upper bound: ");
            if (bound1 <0 || bound2 < 0) {
                logger.warn("Invalid bounds");
                return;
            } 
            if (bound1 > bound2) {
                int temp = bound1;
                bound1 = bound2;
                bound2 = temp;
            }          
            logger.info("Getting compositions within bounds");
            musicService.getCompsWithinBounds(bound1, bound2);            
        }catch(Exception e){
            logger.error("Failed to get compositions within bounds", e);
        }
    }

    @Override
    public String description() {
        return "Get compositions within bounds";
    }
}
