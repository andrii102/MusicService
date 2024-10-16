package lr4.filemanager;
import lr4.music.Album;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManager {
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class.getName());
    // Serialize a list of albums
    public static void serializeAlbums(List<Album> albums, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(albums);
            logger.info("Albums serialized successfully.");
            logger.info("Albums saved to file: " + filePath);
        } catch (IOException e) {
            logger.error("Failed to serialize albums: " + e.getMessage(), e);
        }
    }

    // Deserialize a list of albums
    public static List<Album> deserializeAlbums(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<Album> albums = new ArrayList<>();
                for (Object element : (List<?>) obj) {
                    if (element instanceof Album) {
                        albums.add((Album) element);
                    } else {
                        logger.warn("Element is not of type Album");
                        throw new ClassCastException("Element is not of type Album");
                    }
                }
                logger.info("Albums deserialized successfully.");
                return albums;
            } else {
                logger.warn("Object is not of type List");
                throw new ClassCastException("Object is not of type List");
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            logger.error("Failed to deserialize albums: " + e.getMessage(), e);
        }
        return null;
    }
}
