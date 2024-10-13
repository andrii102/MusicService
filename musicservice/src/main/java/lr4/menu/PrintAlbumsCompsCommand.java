package lr4.menu;

import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintAlbumsCompsCommand implements Command {
    private MusicService musicService;
    private static final Logger logger = LoggerFactory.getLogger(PrintAlbumsCompsCommand.class);

    public PrintAlbumsCompsCommand(MusicService musicService) {
        this.musicService = musicService;
    }   

    @Override 
    public void execute() {
        logger.info("Printing albums and compositions...");
        musicService.printAlbumsAndCompositions();
    }

    @Override
    public String description() {
        return "Print albums and compositions";
    }
}