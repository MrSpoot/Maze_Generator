package component;

public class Wall extends Case{

    int value;

    public Wall(){
        value = -1;
    }

    public void setValue(int newValue){
        this.value = newValue;
    }

    public int getValue(){
        return this.value;
    }
}
