import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Packager {

    private Collections collections;

    public String[] getNutterCandy () {
        NutterCandy nutterCandy = new NutterCandy();
        String[] str = {nutterCandy.getCandyName(), nutterCandy.getCandyType(), nutterCandy.getCandyStuffing(), String.valueOf(nutterCandy.getCandyWeight())};
        System.out.println(Arrays.toString(str));
        return str;
    }

    public String[] getJollyRancherCandy () {
        JollyRancher jollyRancher = new JollyRancher();
        String[] str = {jollyRancher.getCandyName(), jollyRancher.getCandyType(), jollyRancher.getCandyTaste(), String.valueOf(jollyRancher.getCandyWeight())};
        return str;
    }

    public void packageCandies() throws IOException {
        SaveObject saveObject = new SaveObject(getNutterCandy(), getJollyRancherCandy());
        FileOutputStream outputStream = new FileOutputStream("E:\\SHIT\\Epam\\NewYearGift\\src\\main\\resources\\Save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(saveObject);

        objectOutputStream.close();
    }

    public void print() throws IOException, ClassNotFoundException {
        packageCandies();
        FileInputStream fileInputStream = new FileInputStream("E:\\SHIT\\Epam\\NewYearGift\\src\\main\\resources\\Save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SaveObject savedGame = (SaveObject) objectInputStream.readObject();

        System.out.println(savedGame.toString());
    }
}
