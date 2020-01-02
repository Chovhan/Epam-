import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {

    public void serializePresent(ArrayList<ArrayList<String>> myPresent, String filePath){
        try{
            FileOutputStream fos= new FileOutputStream(filePath);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(myPresent);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
