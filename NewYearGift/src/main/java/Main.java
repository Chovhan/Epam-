import java.io.IOException;
import java.util.logging.Logger;

public class Main {

//    private static final Logger log = Logger.getLogger(Packager.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Packager packager = new Packager();
        packager.print();
    }
}
