import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sol6 extends JFrame{
    Sol6(){
        int plnum=1;if (Sol.iampl2>0){plnum=2;}
        JFrame fr = new JFrame("Units and buildings pl "+plnum);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fr.setBounds(Sol.d,Sol.d,Sol.d*12,Sol.d*11-5);
        JPanel panel = new JPanel();

        JTextArea display = new JTextArea ( 25,55 );
        display.setEditable ( false ); // set textArea non-editable

        String s =  "";
        int arr[];

        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (Sol.iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}

        for (int i = 0; i < Sol.unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[14]>unmin&&arr[14]<unmax) {
                s = s+ Sol.getname(arr[14]) + " "+arr[1]+ " "+arr[2]+ " "+arr[3]+System.lineSeparator();
            }}
        s=s+"___"+System.lineSeparator();
        for (int i = 0; i < Sol.buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i);
            if (arr[14]>bldmin&&arr[14]<bldmax) {
       s = s+ Sol.getname(arr[14]) + " "+arr[1]+ " "+arr[2]+ " "+arr[3]+System.lineSeparator();
            }}

            JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        DefaultCaret caret = (DefaultCaret) display.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        display.append(s);
        panel.add ( scroll );

        fr.add(panel);

        fr.setResizable(true);
        fr.setVisible(true);
    }
}
