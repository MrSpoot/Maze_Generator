package component;

public class Cell extends Case {

    int value;

    public Cell(int difficulty){
        value = (int) (1+Math.random()*difficulty-1);
    }

    public void setValue(int newValue){
     this.value = newValue;
    }

    public int getValue(){
        return this.value;
    }

}
