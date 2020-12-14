import screen.Grid;
import screen.Panel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    Grid grid1;
    JPanel panel;

    public MainFrame(int height, int width){

        long startTime = System.nanoTime();

        this.grid1 = new Grid(10,500);

        long totalTime = System.nanoTime()-startTime;

        System.out.println("Temps : \n"
                +"Nano-secondes : "+totalTime+"\n"
                +"Micro-secondes : "+(double)(totalTime/1000)+"\n"
                +"Milli-secondes : "+(double)(totalTime/1000000)+"\n"
                +"Secondes : "+(double)(totalTime/1000000000));

        /*this.grid1.findWay(grid1.getGrid().length-1,grid1.getGrid()[0].length-2,1);
        this.grid1.traceWay(0,1);*/

        this.panel = new Panel(grid1.getGrid());
        this.setPreferredSize(new Dimension(width,height));
        this.setLayout(new BorderLayout());

        this.setResizable(true);
        this.setDefaultCloseOperation(3);
        this.add(this.panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new MainFrame(855,830);
    }
}
