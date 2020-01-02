import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lollipop {

    private static final Logger log = Logger.getLogger(FilePath.class);


    public ArrayList<String> getLollipop(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        Path file = Paths.get(filePath);
        try {
            lines = (ArrayList<String>) Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Info wasn`t collected to array " + e);
        }
        log.info("Info was collected to array from " + filePath);
        return lines;
    }
}
