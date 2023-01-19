import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Sol5 extends JFrame{
    Sol5(){

        Sol.contents2 = new JFrame("options");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8,1,1,1));

        JLabel text0 = new JLabel("set AI skill hard(2-50)easy and press Enter");
        panel.add(text0);

        Sol.smallField2 = new JTextField(50);
        Sol.smallField2.setText(Sol.aihard+"");

        Sol.smallField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sol.getai();
            }
        });
        panel.add(Sol.smallField2);

        String st2 = " show vertsliceall  is on";
        if (Sol.vertsliceall==0){st2 = " show vertsliceall  is off";}
        JButton un = new JButton(st2);
        if (Sol.vertsliceall==0)
        {  un.setBackground(new Color(200, 200, 200));
            un.setForeground(new Color(0, 0, 0));}
        else{un.setBackground(new Color(0, 0, 0));
            un.setForeground(new Color(255, 255, 255));}
        un.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sol.vertsliceallmet();
            }
        });
        panel.add(un);

        String st = "sound is off";
        if (Sol.soundplay!=0){st = "sound is on";}
        JButton un2 = new JButton(st);
        if (Sol.soundplay==0)
        {  un2.setBackground(new Color(200, 200, 200));
            un2.setForeground(new Color(0, 0, 0));}
        else{un2.setBackground(new Color(0, 0, 0));
            un2.setForeground(new Color(255, 255, 255));}
        un2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sol.soundmet();
            }
        });
        panel.add(un2);

        Sol.contents2.add(panel);
        Sol.contents2.setBounds(250,250,250,250);
        Sol.contents2.setSize(500, 250);
        Sol.contents2.setResizable(false);
        Sol.contents2.setVisible(true);
    }
}
