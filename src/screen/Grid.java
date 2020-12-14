package screen;

import component.Case;
import component.Cell;
import component.Wall;

import javax.swing.*;

public class Grid {

    Case[][] grid;
    JPanel panel;

    public void setGrid(Case[][] grid) {
        this.grid = grid;
    }

    public Case[][] getGrid() {
        return grid;
    }

    int difficulty;

    public Grid(){};

    public Grid(int size, int difficulty) {
        this.grid = grid;
        this.difficulty = difficulty;
        int newHeight = size;
        int newWidth = size;
        if (newHeight % 2 == 0) {
            newHeight += 1;
        }

        if (newWidth % 2 == 0) {
            newWidth += 1;
        }

        grid = new Case[newHeight][newWidth];
        fillGrid();
        madeMaze();
    }

    public void fillGrid() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int y = 0; y < this.grid[i].length; y++) {
                if ((i % 2 != 0 && y % 2 == 0) || i % 2 == 0 || i == 0 || y == 0 || i == this.grid.length - 1 || y == this.grid[i].length - 1) {
                    this.grid[i][y] = new Wall();
                } else {
                    this.grid[i][y] = new Cell(this.difficulty);
                }
            }

        }
        this.grid[0][1].setValue(this.grid[1][1].getValue());
        this.grid[this.grid.length - 1][this.grid[this.grid.length - 1].length - 2].setValue(this.grid[this.grid.length - 2][this.grid[this.grid.length - 1].length - 2].getValue());
    }

    public String toString() {
        String ret = "";

        for (int i = 0; i < this.grid.length; i++) {
            for (int y = 0; y < this.grid[i].length; y++) {
                if (this.grid[i][y].getValue() == -1) {
                    ret += "⬛";
                } else {
                    ret += " " + this.grid[i][y].getValue();
                    //ret += 	"⬜";
                }
                ret += " ";
            }
            ret += "\n";
        }
        return ret;
    }

    public void madeMaze() {
        int x = 0;
        while (isFinish()) {
            int i;
            int y;
            do {
                i = (int) (Math.random() * this.grid.length - 1);
                y = (int) (Math.random() * this.grid[i].length - 1);
            } while (i == 0 || y == 0 || i == this.grid.length - 1 || y == this.grid[i].length - 1 || this.grid[i][y].getValue() != -1);

            if (this.grid[i - 1][y].getValue() != -1 && this.grid[i + 1][y].getValue() != -1 && this.grid[i - 1][y].getValue() != this.grid[i + 1][y].getValue()) {
                this.grid[i + 1][y].setValue(this.grid[i - 1][y].getValue());
                this.grid[i][y].setValue(this.grid[i - 1][y].getValue());
                checkCase(i + 1, y);

            } else if (this.grid[i][y - 1].getValue() != -1 && this.grid[i][y + 1].getValue() != -1 && this.grid[i][y - 1].getValue() != this.grid[i][y + 1].getValue()) {

                this.grid[i][y + 1].setValue(this.grid[i][y - 1].getValue());
                this.grid[i][y].setValue(this.grid[i][y - 1].getValue());
                checkCase(i, y + 1);

            }


            x++;
        }
        setCaseToZero();

    }

    public void checkCase(int i, int y) {
        //left
        try {
            if (this.grid[i - 1][y].getValue() != -1 && this.grid[i - 1][y].getValue() != this.grid[i][y].getValue()) {
                this.grid[i - 1][y].setValue(this.grid[i][y].getValue());
                checkCase(i - 1, y);

            }
        } catch (Exception e) {
        }
        ;
        //top-left
        try {
            if (this.grid[i - 1][y - 1].getValue() != -1 && this.grid[i - 1][y - 1].getValue() != this.grid[i][y].getValue()) {
                this.grid[i - 1][y - 1].setValue(this.grid[i][y].getValue());
                checkCase(i - 1, y - 1);

            }
        } catch (Exception e) {
        }
        ;
        //top
        try {
            if (this.grid[i][y - 1].getValue() != -1 && this.grid[i][y - 1].getValue() != this.grid[i][y].getValue()) {
                this.grid[i][y - 1].setValue(this.grid[i][y].getValue());
                checkCase(i, y - 1);

            }
        } catch (Exception e) {
        }
        ;
        //top-right
        try {
            if (this.grid[i + 1][y - 1].getValue() != -1 && this.grid[i + 1][y - 1].getValue() != this.grid[i][y].getValue()) {
                this.grid[i + 1][y - 1].setValue(this.grid[i][y].getValue());
                checkCase(i + 1, y - 1);

            }
        } catch (Exception e) {
        }
        ;
        //right
        try {
            if (this.grid[i + 1][y].getValue() != -1 && this.grid[i + 1][y].getValue() != this.grid[i][y].getValue()) {
                this.grid[i + 1][y].setValue(this.grid[i][y].getValue());
                checkCase(i + 1, y);

            }
        } catch (Exception e) {
        }
        ;
        //bot-right
        try {
            if (this.grid[i + 1][y + 1].getValue() != -1 && this.grid[i + 1][y + 1].getValue() != this.grid[i][y].getValue()) {
                this.grid[i + 1][y + 1].setValue(this.grid[i][y].getValue());
                checkCase(i + 1, y + 1);

            }
        } catch (Exception e) {
        }
        ;
        //bot
        try {
            if (this.grid[i][y + 1].getValue() != -1 && this.grid[i][y + 1].getValue() != this.grid[i][y].getValue()) {
                this.grid[i][y + 1].setValue(this.grid[i][y].getValue());
                checkCase(i, y + 1);

            }
        } catch (Exception e) {
        }
        ;
        //bot-left
        try {
            if (this.grid[i - 1][y + 1].getValue() != -1 && this.grid[i - 1][y + 1].getValue() != this.grid[i][y].getValue()) {
                this.grid[i - 1][y + 1].setValue(this.grid[i][y].getValue());
                checkCase(i - 1, y + 1);

            }
        } catch (Exception e) {
        }
        ;

    }

    public boolean isFinish(){
        int lastValue = this.grid[1][1].getValue();

        for (int i = 0; i < this.grid.length; i++) {
            for (int y = 0; y < this.grid[i].length; y++) {
                if(this.grid[i][y].getValue() != -1 && this.grid[i][y].getValue() != lastValue ){
                    return true;
                }
            }

        }
        return false;
    }

    public void setCaseToZero(){
        for (int i = 0; i < this.grid.length; i++) {
            for (int y = 0; y < this.grid[i].length; y++) {
                if(this.grid[i][y].getValue() != -1){
                    this.grid[i][y].setValue(0);
                }
            }

        }
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void findWay(int i, int y, int index){
        if(index == 1){
            this.grid[i][y].setValue(index);
        }
        //left
        try {
            if (this.grid[i - 1][y].getValue() != -1 && this.grid[i - 1][y].getValue() == 0) {
                this.grid[i - 1][y].setValue(index+1);
                findWay(i - 1, y,index+1);

            }
        } catch (Exception e) {
        }

        //top
        try {
            if (this.grid[i][y - 1].getValue() != -1 && this.grid[i][y - 1].getValue() == 0) {
                this.grid[i][y - 1].setValue(index+1);
                findWay(i, y - 1,index+1);

            }
        } catch (Exception e) {
        }

        //right
        try {
            if (this.grid[i + 1][y].getValue() != -1 && this.grid[i + 1][y].getValue() == 0) {
                this.grid[i + 1][y].setValue(index+1);
                findWay(i + 1, y,index+1);

            }
        } catch (Exception e) {
        }

        //bot
        try {
            if (this.grid[i][y + 1].getValue() != -1 && this.grid[i][y + 1].getValue() == 0) {
                this.grid[i][y + 1].setValue(index+1);
                findWay(i, y + 1,index+1);

            }
        } catch (Exception e) {
        }
    }

    public void traceWay(int i, int y){
        boolean find = false;
        int little = this.grid[i][y].getValue();
        int x = i;
        int j = y;
        this.grid[x][j].setValue(-2);

        //left
        try {
            if (this.grid[i - 1][y].getValue() != -1 && this.grid[i - 1][y].getValue() != -2 && this.grid[i - 1][y].getValue() < little) {
                little = this.grid[i - 1][y].getValue();
                x = i-1;
                j = y;
                find = true;

            }
        } catch (Exception e) {
        }

        //top
        try {
            if (this.grid[i][y - 1].getValue() != -1 && this.grid[i][y - 1].getValue() != -2 && this.grid[i][y - 1].getValue() < little) {
                little = this.grid[i][y - 1].getValue();
                x = i;
                j = y-1;
                find = true;
            }
        } catch (Exception e) {
        }
        //right
        try {
            if (this.grid[i + 1][y].getValue() != -1 && this.grid[i + 1][y].getValue() != -2 && this.grid[i + 1][y].getValue() < little) {
                little = this.grid[i + 1][y].getValue();
                x = i+1;
                j = y;
                find = true;
            }
        } catch (Exception e) {
        }
        //bot
        try {
            if (this.grid[i][y + 1].getValue() != -1 && this.grid[i][y + 1].getValue() != -2 &&  this.grid[i][y + 1].getValue() < little) {
                little = this.grid[i][y + 1].getValue();
                x = i;
                j = y+1;
                find = true;
            }
        } catch (Exception e) {
        }

        if(find){
            traceWay(x,j);
        }
    }
}
