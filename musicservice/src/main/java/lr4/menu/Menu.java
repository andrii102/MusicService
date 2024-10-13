package lr4.menu;

import java.util.*;
import java.util.Map.Entry;

import lr4.music.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {
    private MusicService musicService;
    private Map<Integer, Command> commandMap;
    private InputHandler inputHandler;
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);

    public Menu(MusicService musicService, InputHandler inputHandler) {
        this.musicService = musicService;
        this.inputHandler = inputHandler;
        this.commandMap = new HashMap<>();
        initializeCommands();
    }

    // Initialize the command map with all available commands
    public void initializeCommands() {
        commandMap.put(1, new CreateAlbumCommand(musicService, inputHandler)); 
        commandMap.put(2, new AddCompositionCommand(musicService, inputHandler)); 
        commandMap.put(3, new SortByStyleCommand(musicService));
        commandMap.put(4, new GetCompsWithinBoundsCommand(musicService, inputHandler));
        commandMap.put(5, new SaveToFileCommand(musicService, inputHandler)); 
        commandMap.put(6, new LoadFromFileCommand(musicService, inputHandler)); 
        commandMap.put(7, new PrintAlbumsCommand(musicService));
        commandMap.put(8, new PrintAlbumsCompsCommand(musicService));
        commandMap.put(9, new ExitCommand());
    }

    public void printCommands(){
        Set<Entry<Integer, Command>> entrySet = commandMap.entrySet();
        for (Entry<Integer, Command> entry : entrySet) {
            System.out.println(entry.getKey() + ". " + entry.getValue().description());
        }
    }

    public void run() {
        try{
            int choice;
            while (true) {
                printCommands();
                choice = inputHandler.getInt("Choose an option: ");
                System.out.println();
                Command command = commandMap.get(choice);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            logger.error("Failed to run Menu", e);
        }
    
    }
    public Map<Integer, Command> getCommandMap() {
        return commandMap;
    }
}

