import screen.Grid;
import screen.Panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

    Grid grid1;
    Panel panel;

    public MainFrame(int height, int width){

        long startTime = System.nanoTime();

        this.grid1 = new Grid(150,500);

        long totalTime = System.nanoTime()-startTime;

        System.out.println("Temps : \n"
                +"Nano-secondes : "+totalTime+"\n"
                +"Micro-secondes : "+(double)(totalTime/1000)+"\n"
                +"Milli-secondes : "+(double)(totalTime/1000000)+"\n"
                +"Secondes : "+(double)(totalTime/1000000000));

        //this.grid1.findPath();

        this.panel = new Panel(grid1.getGrid());
        this.setPreferredSize(new Dimension(width,height));
        this.setLayout(new BorderLayout());

        SaveMaze();


        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.add(this.panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new MainFrame(855,830);
    }

    public void SaveMaze(){
        JWindow f = new JWindow();
        f.getContentPane().add(this.panel);
        f.pack();

        f.doLayout();
        f.validate();

        BufferedImage im = new BufferedImage(this.panel.getSize().width, this.panel
                .getSize().height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = im.createGraphics();
        f.getContentPane().paint(g2d);
        g2d.dispose();
        f.dispose();

        File file = new File("C:/Users/Tom/Desktop/Maze/" + (int)(Math.random()*10000) + ".png");

        try {
            ImageIO.write(im, "PNG", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
