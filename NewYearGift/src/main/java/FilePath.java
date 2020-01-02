import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilePath {
    private static final Logger log = Logger.getLogger(FilePath.class);

    public String filePath = "./src/main/resources/Path";

    public ArrayList<String> getPath() {
        ArrayList<String> lines = new ArrayList<>();
        Path file = Paths.get(filePath);
        try {
            lines = (ArrayList<String>) Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Files pathes is not collected " + e);
        }
        log.info("Collect file pathes to array");
        return lines;
    }
}
