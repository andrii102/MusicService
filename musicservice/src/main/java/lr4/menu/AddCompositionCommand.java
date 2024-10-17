package lr4.menu;

import lr4.music.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddCompositionCommand implements Command {
    private MusicService musicService;
    private Album album;
    private Composition composition;
    private InputHandler inputHandler;
    private Logger logger = LoggerFactory.getLogger(AddCompositionCommand.class);

    public AddCompositionCommand(MusicService musicService, InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.musicService = musicService;
    }

    public Album findAlbum(String name) {
        for (Album album : musicService.getAlbums()) {
            if (album.getName().equalsIgnoreCase(name)) {
                return album;
            }
        }
        return null; // Return null if not found
    }

    @Override
    public void execute() {
        try {
            // Get the album name from the input
            String albumName = inputHandler.getString("Enter album name: ");
            
            // Find the album using the name
            album = findAlbum(albumName);
            if (album == null) {
                logger.warn("Album not found");
                return; // Exit if the album is not found
            }

            logger.info("Adding composition to album");

            // Create a new composition with user inputs
            composition = new Composition(
                inputHandler.getString("Enter composition title: "),
                inputHandler.getString("Enter author: "),
                inputHandler.getInt("Enter duration: "),
                inputHandler.getString("Enter style: ")
            ); 

            // Add the composition to the album using musicService
            musicService.addComposition(album, composition);

            logger.info("Composition added successfully");
        } catch (Exception e) {
            logger.error("Unexpected error occurred while adding composition to album", e);
        }
    }

    @Override
    public String description(){
        return "Add composition to album";
    }
}
