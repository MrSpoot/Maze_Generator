package screen;

import java.awt.*;
import java.util.Random;

public class Cube {

    private Color caseColor;
    private int value;

    public Cube(int color){
        this.value = color;
        if(color == -1) {
            caseColor = new Color(0, 0, 0);
        }else if(color == -2){
            caseColor = Color.GREEN;
        }else{
            /*Random rand = new Random(color);
            caseColor = new Color(
                    (rand.nextInt(255)),
                    (rand.nextInt(255)),
                    (rand.nextInt(255))
            );*/
            caseColor = Color.WHITE;
        }
    }

    public Color getCaseColor() {
        return caseColor;
    }

    public int getValue() {
        return value;
    }
}
