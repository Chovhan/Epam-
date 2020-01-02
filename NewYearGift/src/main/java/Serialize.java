import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {
    private static final Logger log = Logger.getLogger(FilePath.class);

    public void serializePresent(ArrayList<ArrayList<String>> myPresent, String filePath){
        try{
            FileOutputStream fos= new FileOutputStream(filePath);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(myPresent);
            oos.close();
            fos.close();
            log.info("Present was Serialized");
        }catch(IOException ioe){
            ioe.printStackTrace();
            log.error("Present wasn`t Serialized, IOExceprion");
        }
    }
}
