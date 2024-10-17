package lr4.menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ExitCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(ExitCommand.class);
    @Override
    public void execute() {
        try{
            logger.info("Exiting the application...");
            System.exit(0);            
        }catch(Exception e){
            logger.error("Failed to exit the application", e);
        }
    }

    @Override
    public String description() {    
        return "Exit";
    }
}

