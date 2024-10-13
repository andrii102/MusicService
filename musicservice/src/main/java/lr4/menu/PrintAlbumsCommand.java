package lr4.menu;

import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintAlbumsCommand implements Command {
    private MusicService musicService;
    private static final Logger logger = LoggerFactory.getLogger(PrintAlbumsCommand.class);

    public PrintAlbumsCommand(MusicService musicService) {
        this.musicService = musicService;
    }
    
    @Override 
    public void execute() {
        logger.info("Printing albums: ");
        musicService.printAlbums();
    }

    @Override
    public String description() {
        return "Print albums";
    }
}

