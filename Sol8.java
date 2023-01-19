import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Sol8 extends JFrame{
    Sol8(){

        Sol.contents3 = new JFrame(" finish");
        Sol.contents3.setUndecorated(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Sol.contents3.setBounds(0,0,Sol.d*30,Sol.d*12);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1,1,1));

        JLabel text1= new JLabel(" finish - game exit");
        panel.add(text1);

        int i =Sol.game_end; int b=Sol.iampl2;  String s="";

        if (b==0){//if pl on this computer is pl1
            if (i==1){s=" FAIL";}
            if (i==2){s=" WIN!";}
        }else{
            if (i==2){s=" FAIL";}
            if (i==1){s=" WIN!";}
        }

            JLabel text0= new JLabel(s);
        text0.setFont(new Font("Arial", Font.BOLD, 150));
        if (s.equals(" WIN!")) {
            text0.setForeground(new Color(100, 255, 100));
        }else {
            text0.setForeground(new Color(255, 0, 0));
        }
            panel.add(text0);


        Sol.contents3.add(panel);
        //  Sol.contents2.setSize(500, 60);
        Sol.contents3.setResizable(false);
        Sol.contents3.setVisible(true);
    }
}
