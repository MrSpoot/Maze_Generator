package screen;

import component.Case;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    Cube[][] gridCube;

    public Panel(Case[][] grid){
        this.setPreferredSize(new Dimension(805,805));
        gridCube = new Cube[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int y = 0; y < grid[i].length;y++){
                gridCube[i][y] = new Cube(grid[i][y].getValue());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int cubeSize = this.getHeight()/gridCube.length;
        int offsetX = 0;
        int offsetY = 0;

        int x = 0;
        int y = 0;

        for(Cube[] cb : gridCube){
            for(Cube cb2 : cb){
                g2d.setColor(cb2.getCaseColor());
                g2d.fillRect(offsetX,offsetY,cubeSize,cubeSize);
                offsetX += cubeSize;
                x++;
            }
            x = 0;
            y++;
            offsetX = 0;
            offsetY += cubeSize;
        }

    }
}
