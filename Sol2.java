import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sol2 extends JFrame
{
    Sol2(){
        Sol.contents = new JFrame("set_name h ns ew (Space_separates)_of_new_map_and_press_Enter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,1,1,1));

        Sol.smallField = new JTextField(50);

        if (Sol.newmapstr.equals("")){
            Sol.smallField.setText(Sol.mapname+" "+Sol.mapheight+" "+Sol.mapwidth+" "+Sol.maplength);}
        else{Sol.smallField.setText(Sol.newmapstr);}

        Sol.smallField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sol.mewmapmet();
            }
        });

        String s = "";
        if (Sol.mapdev==0)
        { s =  "current game terminated, running in new creative mode";}
        Sol.mapdev=1;

        JLabel text0 = new JLabel(s);
        panel1.add(text0);
        panel1.add(Sol.smallField);
        Sol.contents.add(panel1);

        Sol.contents.setBounds(250,250,250,250);
        Sol.contents.setSize(500, 90);
        Sol.contents.setResizable(false);
        Sol.contents.setVisible(true);
    }
}