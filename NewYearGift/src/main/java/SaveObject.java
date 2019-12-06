import java.io.Serializable;

public class SaveObject implements Serializable {

    private static final long serialVersionUID = 1L;

    public String[] candyOne;
    public String[] candyTwo;

    public SaveObject (String[] candyOne, String[] candyTwo) {
        this.candyOne = candyOne;
        this.candyTwo = candyTwo;
    }

    public String[] getCandyOne(){
        return candyOne;
    }

    public void setCandyOne(String[] candyOne) {
        this.candyOne = candyOne;
    }

    public String[] getCandyTwo(){
        return candyTwo;
    }

    public void setCandyTwo(String[] candyTwo) {
        this.candyTwo = candyTwo;
    }
}
