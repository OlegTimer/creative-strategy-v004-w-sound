import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sol3 extends JFrame
{
    Sol3(){

        Sol.contents2 = new JFrame("set_depth ew ns (Space_separates)_of_brush_and_press_Enter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Sol.smallField2 = new JTextField(50);

        Sol.smallField2.setText(Sol.brsz+" "+Sol.brsy+" "+Sol.brsx);

        Sol.smallField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sol.mebrushsizwmet();
            }
        });
        Sol.contents2.add(Sol.smallField2);

        Sol.contents2.setBounds(250,250,250,250);
        Sol.contents2.setSize(500, 60);
        Sol.contents2.setResizable(false);
        Sol.contents2.setVisible(true);
    }
}