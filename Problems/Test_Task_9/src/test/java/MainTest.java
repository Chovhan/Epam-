import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testCreateDeck() {
        Random rnd = new Random();
        Main mn = new Main();
        ArrayList<String> ar = new ArrayList<>();
        ar.add("1");
        ar.add("2");
        ar.add("3");
        ar.add("4");
        assertNotNull(Main.createDeck(ar));
        ArrayList<String> ex = new ArrayList<>();
        for (int i = 0; i < 36; i++){
            String num = ar.get(rnd.nextInt(ar.size())).toString();
            ex.add(num);
        }
        assertEquals(ex.size(), Main.createDeck(ar).size());
//        assertNotNull(ar);
    }

    @Ignore
    public void testDeckScribble() {
    }

    @Test
    public void testGiveCard() {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("1");
        ar.add("2");
        ar.add("3");
        ar.add("4");
        assertNotNull(Main.giveCard(ar));
    }

    @Test
    public void testDeleteCard() {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("1");
        ar.add("2");
        ar.add("3");
        ar.add("4");
        ar.remove(ar.size()-1);
        assertEquals(ar, Main.deleteCard(ar, ar.size()-1));
    }

    @Test
    public void testCounting() {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("1");
        ar.add("2");
        ar.add("3");
        ar.add("4");
        ArrayList<String> us = new ArrayList<>();
        ar.add("1");
        ar.add("3");
        ar.add("4");
        assertNotNull(Main.counting(us, ar));
    }

    @Ignore
    public void testGiveRate() {
//        String q = "y";
//        String w = "n";
        assertNotNull(Main.giveRate());
//        assertEquals(q, Main.giveRate());
    }

    @Ignore
    public void testNewGame() {
        String q = "y";
        String w = "n";
        assertNotNull(Main.newGame());
        assertEquals(q, Main.newGame());
    }
}