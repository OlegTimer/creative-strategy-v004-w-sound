import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sol4 extends JFrame
{
    Sol4(){
        JFrame fr = new JFrame("Info creative strategy by OlegTim");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fr.setBounds(Sol.d,Sol.d,Sol.d*15,Sol.d*11-5);
        JPanel panel = new JPanel();

        JTextArea display = new JTextArea ( 25,55 );
        display.setEditable ( false ); // set textArea non-editable

      String s =        "Hi! It's a 3-d cube-based strategy. You can build map in creative mode or try game mode."+System.lineSeparator()+
                        "Since v002 multiplayer is added."+System.lineSeparator()+
                        "In game mode you can win, protecting your HQ and defeating opponent's HQ."+System.lineSeparator()+
                        "Units can receive orders to move to location, but they attack on their own will."+System.lineSeparator()+
                        "You can load the same map in different modes, but you cannot win/loose in creative."+System.lineSeparator()+
                        "You can add new maps, adding them to game's folder. Maybe you would like to copy an orig. map."+System.lineSeparator()+
                        "1024*768 or 800*600 resol. is good. Requires JRE7+, Windows XP+. (Coord. are displayed z,y,x)."+System.lineSeparator()+
                        "Physics: rock arch 1-2 (block) wide, columns 1-2 tall or becomes gravel, which slides and falls."+System.lineSeparator()+
                        "__ F9 - new map; height 2-12; width&length 15 - 40 (?). No blocks in sky and peak z (height) lvl."+System.lineSeparator()+
                        "__ F10 - quick load, F12 - quick save. may require click on menu after done. F11 - menu."+System.lineSeparator()+
                        "Save/load from map.txt in the same folder (will create new if absent)."+System.lineSeparator()+
                        "NOTE! While quick saving, it will create/rewrite map.txt with current map."+System.lineSeparator()+
                        "To save map and start new, try 'save as in options'."+System.lineSeparator()+
                        "__Esc - quit. Left, Right, Up, Down or Mouse move close to screen borders - scroll x&y."+System.lineSeparator()+
                        "Tab/Caps Lock or PgUp/Down or Mouse Scroll - scroll height. Backspace - top. Space - bottom slice."+System.lineSeparator()+
                        "0-9 show slice levels. |-| (minus) peak lvl (top for gr. units). |=| (equals) sky lvl."+System.lineSeparator()+
                        "(vertsliceall in options), mouseclick is the center, shows block's column between menu and field."+System.lineSeparator()+
                        "w - switch angled view (Tab/Capslock - rotate; Backspace - quit special view). "+System.lineSeparator()+
                        "Insert - tunnel view. q - vert. slice view. z - undo. o - switch borders. p - switch physics."+System.lineSeparator()+
                        "F1 - set brush rock . F2 - gravel. (1 and 2 in save map). F3 - engineer pl1. F4- zeppelin pl1. "+System.lineSeparator()+
                        "F5 - brush void. F6 - fill map with brush. F7 - switch brush between 1*1*1 and custom."+System.lineSeparator()+
                        "F8 - set new brush size. zyx not more 12, and single minus index for set a unit/bld."+System.lineSeparator()+
                        "In creative mode single minus index for deploying units via brush. For example, -3 pl1 engineer"+System.lineSeparator()+
                        "Pl2 units are index+2000, 2003 for engineer pl2. Buildings pl1 start from 1000,  from 3000 to pl2"+System.lineSeparator()+
                        "3 - engineer, 4 zeppelin, 5 air def, 6 mortar, 7 gun car, 8 tank, 9 heavy howitzer for pl1"+System.lineSeparator()+
                        "1003 and 3003 HQ for pl1 and pl2. 1005 air def, 1006 mortar, 1007 gun bld, 1008 barracks pl1."+System.lineSeparator()+
                        "1011 pl1 dynamite: Shift - select all dynamite; Ctrl - detonate."+System.lineSeparator()+
                        "Mortars and howitzer units and bld have +1 range for every 3 blocks height."+System.lineSeparator()+
                        "Mortars and howitzer can shoot (parabolic) if target and shooter don't have blocks upwards."+System.lineSeparator()+
                        "Guns shoot directly, so they can shoot underground, but not in big elevation (+/-1)."+System.lineSeparator()+
                        "4001 for neutral medic (not on peak), heals all close units. Engineer repairs close allied buildings."+System.lineSeparator()+
                        "4007 for neutral car (all gaia are not on peak)."+System.lineSeparator()+
                        "For engineer select building or dig with LMB or RMB, and RMB on close blocks on map to build."+System.lineSeparator()+
                        "1001/3001 mine on resource site (small transp. green oval). The deeper - the greater income."+System.lineSeparator()+
                        "One mine for one source only, if hammer is white, mine is working."+System.lineSeparator()+
                        "998000+ for rock types, 999000+for gravel types."+System.lineSeparator()+
                        " Last 3 nums - special block, (i.e. 998001/999001 - gives recourses in this coordinates.)"+System.lineSeparator()+
                        "Left mouse button (LMB) - use selected brush; Right MB (RMB) - erase (void, delete)."+System.lineSeparator()+
                        "__In windowed mode MouseMove scroll the map may not work."+System.lineSeparator()+
                        "x - brush select (-1) (when units selected, Right Mouse button to move to the point on screen)."+System.lineSeparator()+
                        "When brush is <select> (-1), drag LMB for box selection. Only zeppelins are selected in sky slice."+System.lineSeparator()+
                        "c - deselect (or click non-unit blocks with Left Mouse button). d - dig/build switch to engineer."+System.lineSeparator()+
                        "rock 1 digs behind the engineer's direction."+System.lineSeparator()+
                        "v - units/bld list with coord. s - stop selected units. a - select all units."+System.lineSeparator()+
                        "b - test step cycle. n - switch on|off timer. Delete - erase selected units."+System.lineSeparator()+
                        "h - hold fire, f - fire at will for selected units and buildings."+System.lineSeparator()+
                        "g - ground attack permission for selected units (zeppelins and (RMB -target of heavy howitzers))."+System.lineSeparator()+
                        "Upper the map money is shown, under menu button - quantity of units, buildings, fire bld, HQ."+System.lineSeparator()+
                        "options.txt will be created in the same folder. If need, adjust it before starting program."+System.lineSeparator()+
                        "Minimap dot is 3pix by default and you can change it (and some more) in the options.txt "+System.lineSeparator()+
                        "12 blocks on screen row; for 1024*786 d =64 (768/12) (block size in pix); for 800*600 d = 50."+System.lineSeparator()+
                        "__For multiplayer, select a map in creative mode, then in the options select multiplayer"+System.lineSeparator()+
                        "and in it 'create mp game' ."+System.lineSeparator()+
                        "Then run the game on another computer and select 'join mp game' from the multiplayer menu."+System.lineSeparator()+
                        "If necessary, you can configure the port and ip of the desired server."+System.lineSeparator()+
              "_Best, OlegTim";

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