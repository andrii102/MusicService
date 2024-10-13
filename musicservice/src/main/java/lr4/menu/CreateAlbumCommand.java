package lr4.menu;

import lr4.music.Album;
import lr4.music.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAlbumCommand implements Command {
    private MusicService musicService;
    private String albumName;
    private String author;
    InputHandler inputHandler;
    Logger logger = LoggerFactory.getLogger(CreateAlbumCommand.class);

    public CreateAlbumCommand(MusicService musicService, InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.musicService = musicService;
    }

    @Override
    public void execute() {
        try{
            albumName = inputHandler.getString("Enter album name: ");
            author = inputHandler.getString("Enter album author: ");            
            Album album = new Album(albumName, author);
            musicService.addAlbum(album);
            logger.info("Album created successfully");           
        }catch(Exception e){
            logger.error("Unexpected error occurred while creating album", e);
            System.out.println("An unexpected error occurred. Please try again.");
        }

    }

    @Override
    public String description() {
        return "Create an album";
    }
}
