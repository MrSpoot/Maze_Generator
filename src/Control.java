import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control extends JPanel {

    private JButton genMaze = new JButton("Generate");
    private JButton findWay = new JButton("Find Way");
    private JTextField size = new JTextField();
    private JPanel valid = new JPanel();
    private JPanel config = new JPanel();

    public Control(MainFrame frame){
        /*genMaze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.createMaze(Integer.valueOf(size.getText()));
                }catch (NumberFormatException f){};
            }
        });
        findWay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.findWay();
            }
        });

        this.size.setPreferredSize(new Dimension(100,25));

        this.setLayout(new BorderLayout());
        this.valid.setOpaque(false);
        this.config.setOpaque(false);
        //this.setLayout(new GridLayout(2,1));
        this.config.add(Box.createRigidArea(new Dimension(100,10)));
        this.config.add(size);
        this.config.add(Box.createRigidArea(new Dimension(100,10)));
        this.config.add(findWay);

        this.valid.add(genMaze);

        this.add(this.valid, BorderLayout.SOUTH);
        this.add(this.config, BorderLayout.NORTH);*/

    }


}
