/*
path C:\Program Files (x86)\java\jdk1.7.0\bin
cd c:\1
javac -Xlint:unchecked *.java
jar cmf manif.txt  Sol.jar *.class
*/
//1024*768 or 800*600 resolution is recommended. coord. z,y,x. From Windows XP. Best wishes, OlegTim.

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

public class Sol extends JPanel implements MouseWheelListener, MouseMotionListener {
    public static Timer3 tim = null;
    public static int soundsleep = 300;
    public static int sounditem = 0;
    public static boolean issoundplayingnow = false;
    public static int soundplay = 0;
    public static TestThread task = null;
    public static Sequencer player = null;
    public static Sequence seq = null;
    public static Track track = null;
    public static double nspossiom =0.0;
    public static double ewpossiom =0.0;
    public static   int  isomShowBlocksOnly = 0;
    public static   int  specialview=0; //0 - no, 1 ns, 2 ew;
    public static   int vside =0;
    public static   int hegihtpix=0;
    public static   int widthpix=0;
    public static   int vertsliceall = 1;
    public static   JTextField  smallField3;
    public static   int mpexit =0;
    public static String servbye="wait";
    public static   int servgo =0;
    public static   Socket clientSocket= null;
    public static   ServerSocket server = null;
    public static BufferedReader in = null;
    public static  BufferedWriter out = null;

    public static int   mpgamerunning = 0;
    public static String localip="127.0.0.1";
    public static String ipserver = "127.0.0.1";
    public static int portnum = 26000;
    public static int timersleep = 40; //1 cycle ms delay
    public static  int    iampl2=0;
    public static  int mp =0;
    public static  String menutimer="";
    public static  int action=-1;
    public static  int actz=-1;
    public static  int acty=-1;
    public static  int actx=-1;
    public static  int actdigtype=-1;
    public static  int actdigdir=-1;
    public static  int aipl2 = 1;
    public static  int headtail = 0;//both head and tail visible
    public static  int tail = 0; //the arr 4-6, actually the first on move (but head arr1-3 on stop)
    public static  int dif = 0;
    public static  int game_end = 0;
    public static  int aihard =50;
    public static  int bigmenuon =0;
    public static  int mb_block_menu_z =0;
    public static  int mb_block_menu_y =0;
    public static  int mb_block_menu_x =0;
    public static  int  aipl2_zepp_count = 0;//1
    public static  int  aipl2_eng_count = 0;//2
    public static  int  aipl2_air_def_car_count = 0;//1
    public static  int  aipl2_barracks_count = 0;//5?
    public static  int  aipl2dist = 999_999;
    public static  int hqgoal=1;
    public static  int hqnump1 = 0;
    public static  int hqnump2 = 0;
    public static  int dummy = -1;
    public static  int  engswitch = 0; //0 dig, 1 build
    public static  int  engspeedbuild = 4;
    public static  int engprice=9;
    public static  int mapdot=3;
    public static int  mapposy =-1;
    public static int  mapposx =-1;
    public static int  singleselect=666; //no selection
    public static int mineincomestep = 10; //income at bottom lvl
    public static int minedelaypl1 = 9;
    public static int minedelaypl2 = 9;
    public static int moneypl1 = 300;
    public static int moneypl2 = 300;
    public static int resrich=-9999; //-9999 for infinity. how much res contains
    public static int grselectfag=0;
    public static int loading=0;
    public static int unitsnum = 24;//max unit number 24? for one pl is divede by 2
    public static int  unitscountpl1 =0;
    public static int  unitscountpl2 =0;

    public static int  unitscount_procpl1 =0;

    public static int  unitscount_procpl2 =0;
    public static int buildnum = 56;
    public static int buildcount = 0;
    public static int  buildcountpl1 =0;
    public static int  buildcountpl2 =0;
    public static int  shootingbuildforone =8;
    public static int  buildshootcountpl1 =0;
    public static int  buildshootcountpl2 =0;
    public static int  mindistmortandhowit=3;
    public static int   mortardmg = 1;
    public static int  airdef_dist=10;
    public static int  how_dist=7;
    public static int  gun_dist=4;
    public static int  car_hp=10;
    public static int  eng_hp=20;
    public static int zeppfiredaly = 3;
    public static int zepp_step_time=unitsnum*1; //24?
    public static int tria_step_time=unitsnum*2; // engineer tracks
    public static int car_step_time=unitsnum*1;
    static TestPane pane = null;
    static TestPane2 pane2 = null;
    public static int askaddp1 = 0;
    public static int addp1flag = 0;
    public static  int countt = 0;
    public static  int countt2 = 0;
    public static int timeron = 0;
    public static int mapdev = 0;

    public static List <int[]> unitlist = new ArrayList<int[]>();
    public static List <int[]>  buildlist = new ArrayList<int[]>();;
    public static List <int[]>  flashlist = new ArrayList<int[]>();;
    public static List<int[]> reslist = new ArrayList<int[]>();;

    public static int unitscount = 0;
    public static int xclick = 0;
    public static int yclick = 0;
    public static int xrel = 0;
    public static int yrel = 0;
    public static String filep = "./map.txt";
    public static String filep2 = "./options.txt";
    // public static String filep = "C:\\Users\\1\\IdeaProjects\\test1.8index\\src\\map.txt";
    public static String mapname = "mapname";
    public static JTextField smallField;
    public static JTextField smallField2;
    public static JPanel panel;
    public static JFrame contents;
    static JFrame contents2;
    static JFrame contents3;
    public static int fscr = 1; //fullscreen
    public static int xres = 1024;
    public static int yres = 768;
    public static int brush = -1;
    public static int brsz = 1;
    public static int brsy = 1;
    public static int brsx = 1;

    public static int brsz2 = 1;
    public static int brsy2 = 1;
    public static int brsx2 = 1;
    public static int mb = 0;
    public static int transparentview = 0;
    public static int[] mouseblock;
    public static int drawborders = 1;
    public static int xabs = 0;
    public static int yabs = 0;
    public static int roll = 315; //for isom. 315 shows west-south corner of top at center in isom
    public static int blocksmumwidth = 12;//
    public static int unitcountwaydepth = blocksmumwidth*2;
    public static int mapheight = 12;// n blocks +ground+air (12)
    public static int mapwidth = 12;//inverted to ns
    public static int maplength = 12;//inverted to ew
    public static int ewpos = 0;
    public static int nspos = 0;
    public static int zpos = mapheight;
    public static int d = 64; //block side
    public static   int st = (int)((d*2.1)+ (d/3.4));
    public static int xd = 0;
    public static int yd = 0;
    public static int globalz = 0;
    public static int grawelwidth = 2;
    public static int bordheight = 10; // d/bordheight  (10)
    public static int pause = 0;
    public static int map4[][][]; //for undo
    public static int map3[][][]; //to compare phcal
    public static int map2[][][]; //all map
    public static int map[][][]; //map on screen
    public static int hmapf[][];
    public static int hmap[][];

    public static int hmapblocks[][];
    public static int mapsmallpre[][][];
    public static int col1, col2, col3;

    public static int phflag = 1;
    public static JFrame jFrame;
    public static JLabel text1;
    public static JLabel text2;
    public static String text1s = "Strategy by OlegTim";
    public static String text2s = "New data";
    public static String newmapstr = "";
    public static BufferedImage dest = new BufferedImage(d * blocksmumwidth, d * blocksmumwidth, BufferedImage.TYPE_3BYTE_BGR);

    public static int f3;

    static {//start field
        optionsread();
        InetAddress ip1; try {ip1 = InetAddress.getLocalHost();
            localip=  ip1.getHostAddress();
        } catch (UnknownHostException e) {
            System.err.println(e);}
        //   System.out.println(localip);
        //  reslist = new ArrayList<int[]>();
        //   flashlist = new ArrayList<int[]>();
        //   unitlist = new ArrayList<int[]>();
        //    buildlist = new ArrayList<int[]>();
        mouseblock = new int[3];
        int mouseblock[] = {0, 0, 0};

        hmap = new int[blocksmumwidth][blocksmumwidth];
        hmapf = new int[blocksmumwidth][blocksmumwidth];
        hmapblocks = new int[blocksmumwidth][blocksmumwidth];
        for (int ip2 = 0; ip2 < blocksmumwidth; ip2++) {
            for (int ip = 0; ip < blocksmumwidth; ip++) {
                hmapf[ip2][ip] = -1;
                hmap[ip2][ip] = -1;
            }
        }
        map4 = new int[mapheight][mapwidth][maplength];
        map3 = new int[mapheight][mapwidth][maplength];
        map2 = new int[mapheight][mapwidth][maplength];
        map = new int[mapheight][blocksmumwidth][blocksmumwidth];
        mapsmallpre = new int[mapheight][blocksmumwidth][blocksmumwidth];
        mapsmallpre[0][0][0] = -2;
        f3 = (int) d / bordheight;
        int i, j, k;
        for (i = 0; i < mapheight; i++)
            for (j = 0; j < mapwidth; j++)
                for (k = 0; k < maplength; k++)
                    if (i == mapheight - 1 || i == mapheight - 2) {
                        map2[i][j][k] = 0;
                    } else {
                        map2[i][j][k] = 0; //0-9 z blocks
                    }//

    }//

    static {
        int i, j, k;//1 & 2 to rock and stone start
        for (i = 0; i < mapheight; i++)
            for (j = 0; j < mapwidth; j++)
                for (k = 0; k < maplength; k++) {
                    if (map2[i][j][k] == 1) {
                        map2[i][j][k] = 998000;
                    }
                    if (map2[i][j][k] == 2) {
                        map2[i][j][k] = 999000;
                    }
                }
    }//1 & 2 to rock and stone end

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (specialview!=3){
        if (notches < 0) {
            zpos++;
            fmove();
        } else {
            zpos--;
            transparentview = 0;
            fmove();
        }}
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (specialview!=3){
        if (pause != 1) {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            int x = (int) b.getX();
            int y = (int) b.getY();


            int h = hegihtpix;
            int w = widthpix;

            if (x < 2 && y > 0 && y < h - 3) {
                ewpos--;
                fmove();
            }
            if (x > w - 2 && y > 0 && y < h - 3) {
                ewpos++;
                fmove();
            }
            if (y < 1 && x > 1 && x < w - 3) {
                nspos--;
                fmove();
            }
            if (y > h - 2 && x > 1 && x < w - 3) {
                nspos++;
                fmove();
            }
        }
        }
    }

    public static class TestPane extends JPanel {


        public TestPane() {

        }

        public void drawf() {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            if (specialview==0){
                xd = 0;
                yd = 0;
                for (int i2 = 0; i2 < blocksmumwidth; i2++) {
                    for (int i = 0; i < blocksmumwidth; i++) {

                        int z = 0;
                        for (int i3 = mapheight - 3; i3 > -1; i3--) {
                            z = i3;
                            if (map[i3][i2][i] > 997_999)
                                break;
                        }

                        if (zpos != mapheight) {
                            z = zpos;
                        }

                        globalz = z;
                        colormet();

                        if (z == 0 && map[0][i2][i] >= 998000) {
                            col1 = 0;
                            col2 = 20;
                            col3 = 255; //blue
                        }
                        hmap[i2][i] = z;
                        if (z == 0 && map[0][i2][i] < 998000) {
                            col1 = 163;
                            col2 = 73;
                            col3 = 164; //violet
                            Polygon p = new Polygon(); //counter-clock
                            p.addPoint(0 * d + xd, 0 * d + yd);
                            p.addPoint(0 * d + xd, 1 * d + yd);
                            p.addPoint(1 * d + xd, 1 * d + yd);
                            p.addPoint(1 * d + xd, yd);
                            g.setColor(new Color(col1, col2, col3));
                            g.fillPolygon(p);

                            hmap[i2][i] = -1;
                        }
                        hmapf[i2][i] = hmap[i2][i];
                        if (map[z][i2][i] > 997_999 && transparentview < 1) {
                            Polygon p = new Polygon();
                            p.addPoint(0 * d + xd, 0 * d + yd);
                            p.addPoint(0 * d + xd, 1 * d + yd);
                            p.addPoint(1 * d + xd, 1 * d + yd);
                            p.addPoint(1 * d + xd, yd);
                            g.setColor(new Color(col1, col2, col3));
                            g.fillPolygon(p);
                        }

                        if (transparentview == 1) {

                            for (int r = z; r - 1 > -1; r--) {
                                if (r - 1 > -1 && map[r - 1][i2][i] <= 997_99) {
                                    Polygon p = new Polygon(); //counter-clock
                                    p.addPoint(0 * d + xd, 0 * d + yd);
                                    p.addPoint(0 * d + xd, 1 * d + yd);
                                    p.addPoint(1 * d + xd, 1 * d + yd);
                                    p.addPoint(1 * d + xd, yd);
                                    Color c = new Color(0f, 1f, 0f, .2f);
                                    g.setColor(c);
                                    g.fillPolygon(p);
                                }
                            }
                        }

                        if (map[z][i2][i] >= 999_000 && transparentview < 1) {//gravel draw start
                            //     Graphics2D g2d = (Graphics2D) g;
                            int w = (int) d / 6;
                            int w2 = 0;
                            int y2 = 0;
                            for (int i5 = 0; i5 < 3; i5++) {
                                for (int i4 = 0; i4 < 3; i4++) {
                                    g2d.setColor(new Color(0, 0, 0));
                                    g2d.fillOval(w2 + xd, y2 + yd, 2 * w, 2 * w);
                                    g2d.setColor(new Color(col1, col2, col3));
                                    g2d.fillOval(w2 + xd + grawelwidth, y2 + yd + grawelwidth, 2 * w - 2 * grawelwidth,
                                            2 * w - 2 * grawelwidth);
                                    w2 = w2 + 2 * w;
                                }
                                y2 = y2 + 2 * w;
                                w2 = 0;
                            }
                        }//gravel draw end
                        if (map[z][i2][i] > 997_999 && map[z][i2][i] != 998_000 && map[z][i2][i] != 999_000
                                && transparentview < 1) {//if non-stnd block start
                            int z2 = map[z][i2][i];
                            int r3 = z2 % 1000;
                            //     Graphics2D g2d = (Graphics2D) g;
                            if (r3 == 1) {
                                g.setColor(new Color(200, 200, 0));
                                g.drawRect(xd+d/10+3 , yd+d/10 +3, 4*d/5 -6, 4*d/5-6 );
                                g.setColor(new Color(150, 150, 0));
                                g.drawRect(xd+d/10+4 , yd+d/10 +4, 4*d/5 -8, 4*d/5-8 );
                            }

                        }//if non-stnd block end
                        xd = xd + d;
                    }
                    xd = 0;
                    yd = yd + d;
                }//blocks draw end

                if (transparentview < 1) {
                    xd = -f3;
                    yd = 0;
                    if (zpos == mapheight && drawborders == 1) {
                        for (int j2 = 0; j2 < hmap.length; j2++) {//height connectors draw start
                            for (int j = 0; j < hmap[j2].length; j++) {
                                int f = 777;
                                int f2 = 777;
                                try {
                                    f = hmap[j2][j - 1];
                                } catch (Exception e) {
                                }
                                try {
                                    f2 = hmap[j2 - 1][j];
                                } catch (Exception e) {
                                }
                                if (f != 777) {//left-right connectors start
                                    if (hmap[j2][j] - f > 1) {//tall r start
                                        int z = hmap[j2][j];
                                        if (hmap[j2][j] > 0 && map[z][j2][j] > 997_999 && map[z][j2][j] < 999_000 && map[z - 1][j2][j] < 998000) {
                                            //  Graphics2D g2d = (Graphics2D) g;
                                            g2d.setColor(new Color(255, 255, 255));
                                            g2d.fillOval(xd, yd + f3, 2 * f3, 8 * f3);
                                            g.setColor(new Color(0, 0, 0));
                                            g.drawOval(xd, yd + f3, 2 * f3, 8 * f3);
                                        } else {
                                            Polygon p = new Polygon();
                                            p.addPoint(2 * f3 + xd, yd + f3);
                                            p.addPoint(xd, 5 * f3 + yd);
                                            p.addPoint(2 * f3 + xd, d + yd - f3);
                                            g.setColor(new Color(0, 0, 0));
                                            g.fillPolygon(p);
                                        }
                                    }//tallr end

                                    if (f - hmap[j2][j] > 1) {//tall l start
                                        int z = hmap[j2][j - 1];

                                        if (hmap[j2][j - 1] > 0 && map[z][j2][j - 1] > 997_999 && map[z][j2][j - 1] < 999_000 && map[z - 1][j2][j - 1] < 998000) {
                                            //    Graphics2D g2d = (Graphics2D) g;
                                            g2d.setColor(new Color(255, 255, 255));
                                            g2d.fillOval(xd, yd + f3, 2 * f3, 8 * f3);
                                            g.setColor(new Color(0, 0, 0));
                                            g.drawOval(xd, yd + f3, 2 * f3, 8 * f3);
                                        } else {
                                            Polygon p = new Polygon();
                                            p.addPoint(xd, yd + f3);
                                            p.addPoint(xd, d + yd - f3);
                                            p.addPoint(2 * f3 + xd, 5 * f3 + yd);
                                            g.setColor(new Color(0, 0, 0));
                                            g.fillPolygon(p);
                                        }
                                    }//tall l end

                                    if ((hmap[j2][j] - f) == 1) {// r start
                                        Polygon p = new Polygon();
                                        p.addPoint(2 * f3 + xd, yd + f3);
                                        p.addPoint(xd, 5 * f3 + yd);
                                        p.addPoint(2 * f3 + xd, d + yd - f3);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillPolygon(p);
                                    } //r end

                                    if (f - hmap[j2][j] == 1) {//l start
                                        Polygon p = new Polygon();
                                        p.addPoint(xd, yd + f3);
                                        p.addPoint(xd, d + yd - f3);
                                        p.addPoint(2 * f3 + xd, 5 * f3 + yd);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillPolygon(p);
                                    }//l end
                                }//left-right connectors end

                                if (f2 != 777) {//north-south connectors start
                                    xd = xd + f3;
                                    yd = yd - f3;
                                    if (hmap[j2][j] - f2 > 1) {//tall n start
                                        int z = hmap[j2][j];
                                        if (hmap[j2][j] > 0 && map[z][j2][j] > 997_999 && map[z][j2][j] < 999_000 && map[z - 1][j2][j] < 998000) {
                                            //    Graphics2D g2d = (Graphics2D) g;
                                            g2d.setColor(new Color(255, 255, 255));
                                            g2d.fillOval(xd + f3, yd, 8 * f3, 2 * f3);
                                            g.setColor(new Color(0, 0, 0));
                                            g.drawOval(xd + f3, yd, 8 * f3, 2 * f3);
                                        } else {
                                            Polygon p = new Polygon();
                                            p.addPoint(5 * f3 + xd, yd);
                                            p.addPoint(xd + f3, 2 * f3 + yd);
                                            p.addPoint(d + xd - f3, 2 * f3 + yd);
                                            g.setColor(new Color(0, 0, 0));
                                            g.fillPolygon(p);
                                        }
                                    }//tall n end

                                    if (f2 - hmap[j2][j] > 1) {//tall s start
                                        int z = hmap[j2 - 1][j];
                                        if (hmap[j2 - 1][j] > 0 && map[z][j2 - 1][j] > 997_999 && map[z][j2 - 1][j] < 999_000 && map[z - 1][j2 - 1][j] < 998000) {
                                            //  Graphics2D g2d = (Graphics2D) g;
                                            g2d.setColor(new Color(255, 255, 255));
                                            g2d.fillOval(xd + f3, yd, 8 * f3, 2 * f3);
                                            g.setColor(new Color(0, 0, 0));
                                            g.drawOval(xd + f3, yd, 8 * f3, 2 * f3);
                                        } else {
                                            Polygon p = new Polygon();
                                            p.addPoint(xd + f3, yd);
                                            p.addPoint(5 * f3 + xd, 2 * f3 + yd);
                                            p.addPoint(d - f3 + xd, yd);
                                            g.setColor(new Color(0, 0, 0));
                                            g.fillPolygon(p);
                                        }
                                    }//tall s end

                                    if (hmap[j2][j] - f2 == 1) {// n start
                                        Polygon p = new Polygon();
                                        p.addPoint(5 * f3 + xd, yd);
                                        p.addPoint(xd + f3, 2 * f3 + yd);
                                        p.addPoint(d - f3 + xd, 2 * f3 + yd);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillPolygon(p);
                                    }//n end

                                    if (f2 - hmap[j2][j] == 1) {// s start
                                        Polygon p = new Polygon();
                                        p.addPoint(xd + f3, yd);
                                        p.addPoint(5 * f3 + xd, 2 * f3 + yd);
                                        p.addPoint(d - f3 + xd, yd);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillPolygon(p);
                                    }//s end
                                    xd = xd - f3;
                                    yd = yd + f3;
                                }//north-south connectors end

                                xd = xd + d;
                            }
                            xd = -f3;
                            yd = yd + d;

                        }
                    }//height connectors draw end

                    if (zpos > mapheight - 2) {
                        if (zpos == mapheight - 1) {
                            g.setColor(new Color(240, 240, 255));
                            g.fillRect(0, 0, d * blocksmumwidth, d * blocksmumwidth);
                        }
                    }

                    xd = 0;
                    yd = 0;
                    for (int i2 = 0; i2 < blocksmumwidth; i2++) {//gaia start
                        for (int i = 0; i < blocksmumwidth; i++) {
                            int htemp=0;
                            if (zpos!=mapheight){htemp=zpos;}else{
                                for (int i3 = mapheight - 3; i3 > -1; i3--) {//block lv
                                    htemp = i3;
                                    if (map[i3][i2][i] > 4000&&map[i3][i2][i] < 6000)
                                        break;
                                }}
                            int go=0; int hdes=1; int ga = map[htemp][i2][i];
                            if (ga> 4000&&ga<6000){go=1;}
                            if (go>0&&zpos==mapheight)   {
                                try{for (int n = htemp+1; n <mapheight-1; n++){//till the sky
                                    if (map[htemp+1][i2][i]!=0){hdes=0;break;}}} catch (Exception ef){}}
                            if (hdes!=1){go=0;}
                            if (go>0){//
                                if (ga==4007 ){ //gaia car
                                    int  xsr=xd; int yscr = yd;
                                    g.setColor(new Color(0, 0, 0));
                                    Polygon p = new Polygon();
                                    int xd2, yd2, xd22; xd2= yd2=xd22=0;
                                    xd2=d/2;yd2=d/10;
                                    p.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=2*d/10;yd2=2*d/10;
                                    p.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d/10;yd2=d/2-d/10;
                                    p.addPoint(xd2 + xsr,  yd2 + yscr);
                                    xd2=d/10;yd2=d/2+d/10;
                                    p.addPoint(xd2 + xsr,  yd2 + yscr);
                                    xd2=2*d/10;yd2=8*d/10;
                                    p.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d/2;yd2=d-d/10;
                                    p.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d-d/10;yd2=d-d/10;
                                    p.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d-d/10;yd2=d/10;
                                    p.addPoint( xd2 + xsr, yd2 + yscr);
                                    g.fillPolygon(p);
                                    g.setColor(new Color(0, 150, 0));
                                    Polygon p2 = new Polygon(); //counter-clock
                                    xd2=d/2;yd2=2*d/10;
                                    p2.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=3*d/10;yd2=2*d/10;
                                    p2.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d/5;yd2=d/2-d/10;
                                    p2.addPoint(xd2 + xsr,  yd2 + yscr);
                                    xd2=d/5;yd2=d/2+d/10;
                                    p2.addPoint(xd2 + xsr,  yd2 + yscr);
                                    xd2=3*d/10;yd2=8*d/10;
                                    p2.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d/2;yd2=d-d/5;
                                    p2.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d-d/5;yd2=d-d/5;
                                    p2.addPoint( xd2 + xsr, yd2 + yscr);
                                    xd2=d-d/5;yd2=d/5;
                                    p2.addPoint( xd2 + xsr, yd2 + yscr);
                                    g.fillPolygon(p2);
                                }

                                if (ga==4001 ){//gaia medic
                                    g.setColor(new Color(255, 255, 255));
                                    g.fillRect(xd+d/10,yd+d/10,d*4/5,d*4/5);
                                    g.setColor(new Color(255, 0, 0));
                                    g.fillRect(xd+d/10,yd+d*9/20-2,d*4/5,d/5);
                                    g.fillRect(xd+d*9/20-2,yd+d/10,d/5,d*4/5);
                                    g.setColor(new Color(0, 0, 0));
                                    g.drawRect(xd+d/10,yd+d/10,d*4/5,d*4/5);
                                }

                            }//
                            xd = xd + d;
                        }
                        xd = 0;
                        yd = yd + d;
                    }//gaia end

                    if (buildlist!=null) {// build start
                        int arr[];
                        int xsr=-1; int yscr = -1;
                        for (int i = 0; i < buildlist.size(); i++) {
                            arr = (int[]) buildlist.get(i);

                            xsr = (arr[3] - ewpos); //
                            yscr = (arr[2] - nspos);
                            if (xsr * d < d * blocksmumwidth && yscr * d < d * blocksmumwidth) { //if bld on yx screen
                                int hdes = 0;
                                if (zpos!=mapheight) {  if (zpos==arr[1]){hdes=1;}}else {//if top view start
                                    int hdes1, hdes2, hdes3;
                                    hdes1 = hdes2 = hdes3 = 1;
                                    for (int n = arr[1] + 1; n < mapheight - 1; n++) {//till the sky
                                        if (map2[n][arr[2]][arr[3]] != 0) {
                                            hdes1 = 0;
                                            break;
                                        }
                                    }

                                    hdes = hdes1;}

                                if (hdes > 0) {
                                    xsr = xsr * d;
                                    yscr = yscr * d;

             if (soundplay>0)   {  if (arr[21]>0) {soundplay(arr[14]);}else{if(arr[22]>0) {soundplay(-arr[14]);}}}

                                    if (arr[14] == 1003 || arr[14] == 3003) {
                                        if (arr[14] == 1003) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                    }

                                    if (arr[14] == 1005 || arr[14] == 3005) {
                                        if (arr[14] == 1005) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);

                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{ //fire
                                            g.setColor(new Color(255, 255, 255));}
                                        int xd2;
                                        Polygon p3 = new Polygon(); //counter-clock
                                        xd=d-3*d/10;yd=7*d/10;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-7*d/10;yd=7*d/10;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-7*d/10;yd=3*d/10;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-3*d/10;yd=3*d/10;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p3);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                    }

                                    if (arr[14] == 1006 || arr[14] == 3006) {
                                        if (arr[14] == 1006) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);

                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{ //fire
                                            g.setColor(new Color(255, 255, 255));}
                                        int xd2;
                                        xd=9*d/20;yd=9*d/20;
                                        g.fillOval(xsr+xd, yscr+yd, 3*d/20, 3*d/20);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                    }

                                    if (arr[14] == 1007 || arr[14] == 3007) {
                                        if (arr[14] == 1007) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);

                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{ //fire
                                            g.setColor(new Color(255, 255, 255));}
                                        int xd2;
                                        Polygon p3 = new Polygon(); //counter-clock
                                        xd=d-2*d/10;yd=9*d/20;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-8*d/10;yd=9*d/20;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-8*d/10;yd=11*d/20;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-2*d/10;yd=11*d/20;
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p3);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                    }

                                    if (arr[14] == 1001 || arr[14] == 3001) { //mine
                                        if (arr[14] == 1001) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                        if (arr[19]==0) {//if mine ineffective
                                            if (arr[14]==1001){g.setColor(new Color(0, 0, 0));}else
                                            {g.setColor(new Color(200, 50, 0));}
                                        }
                                        else{g.setColor(new Color(255, 255, 255));}
                                        Polygon p3 = new Polygon(); //counter-clock
                                        p3.addPoint( d-3*d/10+  xsr,  yscr+4*d/10);
                                        p3.addPoint( d-5*d/10+  xsr,  yscr+4*d/10);
                                        p3.addPoint( d/10 + xsr, d-d/10  + yscr);
                                        p3.addPoint( d*3/10 + xsr, d-d/10  + yscr);
                                        g.fillPolygon(p3);
                                        Polygon p4 = new Polygon(); //counter-clock
                                        p4.addPoint( 5*d/10+  xsr,  yscr+2*d/10);
                                        p4.addPoint( 3*d/10+  xsr,  yscr+3*d/10);
                                        p4.addPoint( d-d/5 + xsr, d/2+d/10  + yscr);
                                        p4.addPoint( d-d/5 + xsr, d/2-d/10  + yscr);
                                        g.fillPolygon(p4);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                    }

                                    if (arr[14] == 1008 || arr[14] == 3008) { //barracks
                                        if (arr[14] == 1008) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);

                                        g.setColor(new Color(255, 255, 255));
                                        Polygon p3 = new Polygon();
                                        p3.addPoint( d/10+5+  xsr,  d/10+5+ yscr);
                                        p3.addPoint( 6*d/10+  xsr,  6*d/10+ yscr);
                                        p3.addPoint( 6*d/10 + xsr, 4*d/10  + yscr);
                                        g.fillPolygon(p3);
                                        Polygon p4 = new Polygon();
                                        p4.addPoint( 7*d/10+  xsr,  3*d/10+ yscr);
                                        p4.addPoint( 3*d/10+  xsr,  7*d/10+ yscr);
                                        p4.addPoint( 5*d/10+  xsr,  7*d/10+ yscr);
                                        p4.addPoint( 9*d/10+  xsr,  3*d/10+ yscr);
                                        g.fillPolygon(p4);

                                        Polygon p5 = new Polygon();
                                        //  g.setColor(new Color(255, 0, 0));
                                        p5.addPoint( 8*d/10+  xsr,  8*d/10+ yscr);
                                        p5.addPoint( 9*d/10+  xsr,  7*d/10+ yscr);
                                        p5.addPoint( 6*d/10+  xsr,  4*d/10+ yscr);
                                        p5.addPoint( 6*d/10+  xsr,  6*d/10+ yscr);
                                        g.fillPolygon(p5);

                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr+d/10, yscr+d/10, 4*d/5, 4*d/5);
                                    }

                                    if (arr[14] == 1010 || arr[14] == 3010) { //dummy
                                        if (arr[14] == 1010) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr + d / 10, yscr + d / 10, 4 * d / 5, 4 * d / 5);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillRect(xsr + 6*d / 10, yscr + d / 10,  1*d / 10, 8 * d / 10);
                                        g.fillRect(xsr + 1*d / 10, yscr + 2*d / 10,  8*d / 10, 1 * d / 10);
                                        g.fillRect(xsr + 7*d / 10+2, yscr + 2*d / 10,  2*d / 10-2, 3* d / 10);
                                        g.fillRect(xsr + 3*d / 10, yscr + 2*d / 10,  2, 3 * d / 10);
                                        g.fillRect(xsr + 2*d / 10, yscr + 4*d / 10,  2*d/10, 2 * d / 10);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr + d / 10, yscr + d / 10, 4 * d / 5, 4 * d / 5);
                                    }

                                    if (arr[14] == 1011 || arr[14] == 3011) { //dynamite
                                        if (arr[14] == 1011) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        g.fillRect(xsr + d / 10, yscr + d / 10, 4 * d / 5, 4 * d / 5);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillRect(xsr + 9*d / 20, yscr + d / 10,  1*d / 10, 7 * d / 10);
                                        g.fillRect(xsr + 6*d / 20, yscr + d / 10,  4*d / 10, 1 * d / 10);
                                        g.fillRect(xsr + 6*d / 20, yscr + 4*d / 10,  4*d / 10, 4 * d / 10);
                                        g.setColor(new Color(0, 0, 0));
                                        g.drawRect(xsr + d / 10, yscr + d / 10, 4 * d / 5, 4 * d / 5);
                                    }

                                    //====================
                                    xsr = (arr[3] - ewpos) * d;
                                    yscr = (arr[2] - nspos) * d;
                                    if (arr[22] == 1) {// bld under fire
                                        Color c = new Color(1f, 0f, 0f, .5f);
                                        g.setColor(c);
                                        g.fillOval(xsr, yscr, d, d);
                                    }
                                    int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                                    if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
                                    if (arr[10] == 1&&arr[14]>bldmin&&arr[14]<bldmax) {//bld sel
                                        g.setColor(new Color(175, 65, 175));
                                        g.drawOval(xsr, yscr, d, d);
                                        g.drawOval(xsr - 1, yscr - 1, d + 2, d + 2);
                                        g.setColor(new Color(255, 0, 0));
                                        g.drawOval(xsr - 3, yscr - 3, d + 6, d + 6);
                                        g.drawOval(xsr - 4, yscr - 4, d + 8, d + 8);
                                        g.setColor(new Color(255, 255, 255));
                                        g.drawOval(xsr - 2, yscr - 2, d + 4, d + 4);
                                    }
                                    if (arr[14] != 4 && arr[14] != 2004) {
                                        int hp = arr[18];//hp
                                        int healthtotal = getunithp(arr[14]);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillRect(xsr + d / 10 - 2, yscr + 8 * d / 10 - 2, 4 * d / 5 + 4, d / 10 + 4);
                                        if (arr[14] < 2000) {
                                            g.setColor(new Color(175, 65, 175));
                                        } else {
                                            g.setColor(new Color(0, 0, 0));
                                        }
                                        double wdth = 1.0 * hp / healthtotal * (4 * d / 5);
                                        int w = (int) wdth;
                                        g.fillRect(xsr + d / 10, yscr + 8 * d / 10, w, d / 10);
                                    }//hp end

                                }   }}}//building end


                    if (unitlist!=null) {// gr unit start
                        int arr[];
                        int xsr=-1; int yscr = -1;
                        for (int i = 0; i < unitlist.size(); i++) {
                            arr = (int[]) unitlist.get(i); headtail=0;
                            dif = (arr[15]-getunitspeed(arr[14]))*((d+d/10)/getunitspeed(arr[14]))-d/20;//time. diff is zero or negative
                            if (arr[15]<0){dif=0;}
                            if ( arr[1] == arr[4]&&arr[2] == arr[5]&&arr[3] == arr[6]){{dif=0;}}
                            //System.out.println(dif);

                            xsr = (arr[3] - ewpos); //head start
                            yscr = (arr[2] - nspos);
                            if (xsr * d < d * blocksmumwidth && yscr * d < d * blocksmumwidth) { //if unit on yx screen
                                int hdes = 0;
                                if (zpos!=mapheight) {  if (zpos==arr[1]){hdes=1;}}else {//if top view start
                                    int hdes1,hdes2,hdes3; hdes1=hdes2=hdes3=1;
                                    for (int n = arr[1]+1; n <mapheight-1; n++){//till the sky
                                        if (map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                                    hdes=hdes1;
                                }//if top view end
                                if (hdes>0){headtail=1;}
                                //
                                if (arr[1] != arr[4]||arr[2] != arr[5] || arr[3] != arr[6]) {//tail check
                                    int   xsrt = (arr[6] - ewpos);
                                    int   yscrt = (arr[5] - nspos);
                                    if (xsrt * d < d * blocksmumwidth && yscrt * d < d * blocksmumwidth) { //if tail on yx screen check
                                        int     hdest = 0;
                                        if (zpos != mapheight) {
                                            if (zpos == arr[4]) {
                                                hdest = 1;
                                            }
                                        } else {//if top view start
                                            int hdes1, hdes2, hdes3;
                                            hdes1 = hdes2 = hdes3 = 1;

                                            for (int n = arr[4] + 1; n < mapheight - 1; n++) {
                                                if (map2[n][arr[5]][arr[6]] != 0) {
                                                    hdes2 = 0;
                                                    break;
                                                }
                                            }

                                            hdest = hdes2;
                                        }//if top view end
                                        if (hdest>0){headtail=headtail+2;}
                                    }}
                                //
                                //   System.out.println(headtail);
                                if (hdes>0) {
                                    xsr = xsr * d;
                                    yscr = yscr * d;

                 if (soundplay>0)   {  if (arr[21]>0) {soundplay(arr[14]);}else{if(arr[22]>0) {soundplay(-arr[14]);}}}

                                    if (arr[14] == 3||arr[14] == 2003) {//engineer tria

                                        if (arr[11] != -1) {
                                            g.setColor(new Color(255, 255, 255));}//if move
                                        else{if (arr[29]!=0){g.setColor(new Color(255, 255, 0));}//if sel build
                                        else{g.setColor(new Color(0, 0, 0));}}
                                        if (arr[30] >0) {g.setColor(new Color(0, 0, 255));}//dig

                                        Polygon p = new Polygon(); //counter-clock
                                        int xd, yd, xd2; xd= yd=xd2=0;
                                        xd=d/2;yd=d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p);

                                        if (arr[14]==3){
                                            g.setColor(new Color(175, 65, 175));}
                                        else {g.setColor(new Color(0, 0, 0));}

                                        Polygon p2 = new Polygon(); //counter-clock
                                        xd=d/2;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=2*d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-2*d/10;yd=d-2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-2*d/10;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p2);
                                    }//if unit num3 end

                                    if (arr[14] == 5||arr[14] == 2005) {
                                        if (arr[11] != -1) {//if moving
                                            g.setColor(new Color(255, 255, 255));}
                                        else{g.setColor(new Color(0, 0, 0));}
                                        Polygon p = new Polygon(); //counter-clock
                                        int xd, yd, xd2; xd= yd=xd2=0;
                                        xd=d/2;yd=d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=2*d/10;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/10;yd=d/2-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/10;yd=d/2+d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=2*d/10;yd=8*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2;yd=d-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p);
                                        if (arr[14]==5){//which side
                                            g.setColor(new Color(175, 65, 175));}
                                        else {g.setColor(new Color(0, 0, 0));}
                                        Polygon p2 = new Polygon(); //counter-clock
                                        xd=d/2;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=3*d/10;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/5;yd=d/2-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/5;yd=d/2+d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=3*d/10;yd=8*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p2);
                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{ //fire
                                            g.setColor(new Color(255, 255, 255));}
                                        Polygon p3 = new Polygon(); //counter-clock
                                        xd=d-3*d/10;yd=7*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-7*d/10;yd=7*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-7*d/10;yd=3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-3*d/10;yd=3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p3);
                                        // g.fillOval(xd+xsr,yd+ yscr, d/5, d/5);
                                    }//if unit num5 end

                                    if (arr[14] == 6||arr[14] == 2006) {
                                        if (arr[11] != -1) {
                                            g.setColor(new Color(255, 255, 255));}
                                        else{g.setColor(new Color(0, 0, 0));}
                                        Polygon p = new Polygon(); //counter-clock
                                        int xd, yd, xd2; xd= yd=xd2=0;
                                        xd=d/2;yd=d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p);
                                        if (arr[14]==6){
                                            g.setColor(new Color(175, 65, 175));}
                                        else {g.setColor(new Color(0, 0, 0));}
                                        Polygon p2 = new Polygon(); //counter-clock
                                        xd=d/2;yd=3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/5;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p2);
                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{
                                            g.setColor(new Color(255, 255, 255));}
                                        xd=9*d/20;yd=9*d/20;
                                        Polygon pov = new Polygon();
                                        xd=d/2;yd=4*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2-d/10;yd=5*d/10-1; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2;yd=6*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2+d/10;yd=5*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(pov);
                                        // g.fillOval(xsr+xd, yscr+yd, 3*d/20, 3*d/20);
                                    }//if unit num6 end

                                    if (arr[14] == 7||arr[14] == 2007) {
                                        if (arr[11] != -1) {//if moving
                                            g.setColor(new Color(255, 255, 255));}
                                        else{g.setColor(new Color(0, 0, 0));}
                                        Polygon p = new Polygon(); //counter-clock
                                        int xd, yd, xd2; xd= yd=xd2=0;
                                        xd=d/2;yd=d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=2*d/10;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/10;yd=d/2-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/10;yd=d/2+d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=2*d/10;yd=8*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2;yd=d-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p);
                                        if (arr[14]==7){//which side
                                            g.setColor(new Color(175, 65, 175));}
                                        else {g.setColor(new Color(0, 0, 0));}
                                        Polygon p2 = new Polygon(); //counter-clock
                                        xd=d/2;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=3*d/10;yd=2*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/5;yd=d/2-d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/5;yd=d/2+d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=3*d/10;yd=8*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/2;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p2);
                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{ //fire
                                            g.setColor(new Color(255, 255, 255));}
                                        Polygon p3 = new Polygon(); //counter-clock
                                        xd=d-2*d/10;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-8*d/10;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-8*d/10;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-2*d/10;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p3);
                                        // g.fillOval(xd+xsr,yd+ yscr, d/5, d/5);

                                    }//if unit num7 end

                                    if (arr[14] == 8||arr[14] == 2008) {
                                        if (arr[11] != -1) {
                                            g.setColor(new Color(255, 255, 255));}
                                        else{g.setColor(new Color(0, 0, 0));}
                                        Polygon p = new Polygon(); //counter-clock
                                        int xd, yd, xd2; xd= yd=xd2=0;
                                        xd=d/2;yd=d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p);
                                        if (arr[14]==8){
                                            g.setColor(new Color(175, 65, 175));}
                                        else {g.setColor(new Color(0, 0, 0));}
                                        Polygon p2 = new Polygon(); //counter-clock
                                        xd=d/2;yd=3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/5;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p2);
                                        if (arr[21]==1){ g.setColor(new Color(255, 0, 0));}else{
                                            g.setColor(new Color(255, 255, 255));}
                                        Polygon p3 = new Polygon(); //counter-clock
                                        xd=d-2*d/10;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-8*d/10;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-8*d/10;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        xd=d-2*d/10;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p3.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p3);

                                    }//if unit num8 end

                                    if (arr[14] == 9||arr[14] == 2009) {
                                        if (arr[11] != -1) {
                                            g.setColor(new Color(255, 255, 255));}//in move
                                        else{     if (arr[25] == 0) {
                                            g.setColor(new Color(255, 255, 0));}//attacking ground
                                        else{g.setColor(new Color(0, 0, 0));}}
                                        Polygon p = new Polygon(); //counter-clock
                                        int xd, yd, xd2; xd= yd=xd2=0;
                                        xd=d/2;yd=d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-d/5; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/10;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p);
                                        if (arr[14]==9){
                                            g.setColor(new Color(175, 65, 175));}
                                        else {g.setColor(new Color(0, 0, 0));}
                                        Polygon p2 = new Polygon(); //counter-clock
                                        xd=d/2;yd=3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d/5;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint(xd + xsr,  yd + yscr);
                                        xd=d/2;yd=d-3*d/10; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        xd=d-d/5;yd=d/2; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        p2.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(p2);
                                        if (arr[21]==1){ g.setColor(new Color(255, 255, 0));}else{
                                            g.setColor(new Color(255, 255, 255));}
                                        xd=7*d/20;yd=7*d/20;
                                        Polygon pov = new Polygon();
                                        xd=11*d/20;yd=7*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=9*d/20;yd=7*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=7*d/20;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=7*d/20;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=9*d/20;yd=13*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=11*d/20;yd=13*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=d-7*d/20;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        xd=d-7*d/20;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                        pov.addPoint( xd + xsr, yd + yscr);
                                        g.fillPolygon(pov);
                                    }//if unit num9 end

                                    xsr = (arr[3] - ewpos)*d;
                                    yscr = (arr[2] - nspos)*d;
                                    if (headtail==1){
                                        if (arr[22] == 1) {// unit under fire
                                            Color c = new Color(1f, 0f, 0f, .5f);
                                            g.setColor(c);
                                            g.fillOval(xsr, yscr, d, d);}

                                        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                                        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
                                        if (arr[10] == 1&&arr[14]>unmin&&arr[14]<unmax) {//gr unit sel
                                            g.setColor(new Color(175, 65, 175));
                                            g.drawOval(xsr, yscr, d, d);
                                            g.drawOval(xsr - 1, yscr - 1, d + 2, d + 2);
                                            g.setColor(new Color(255, 0, 0));
                                            g.drawOval(xsr - 3, yscr - 3, d + 6, d + 6);
                                            g.drawOval(xsr - 4, yscr - 4, d + 8, d + 8);
                                            g.setColor(new Color(255, 255, 255));
                                            g.drawOval(xsr - 2, yscr - 2, d + 4, d + 4);
                                        }
                                        if (arr[14]!=4&&arr[14]!=2004){
                                            int hp = arr[18];//hp
                                            int healthtotal = getunithp(arr[14]);
                                            g.setColor(new Color(255, 255, 255));
                                            g.fillRect(xsr+d/10-2,yscr+8*d/10-2,4*d/5+4,d/10+4);
                                            if (arr[14]<2000)   {  g.setColor(new Color(175, 65, 175));}
                                            else{ g.setColor(new Color(0, 0, 0));}
                                            double wdth = 1.0*hp/healthtotal*(4*d/5);
                                            int w = (int)wdth;
                                            g.fillRect(xsr+d/10,yscr+8*d/10,w,d/10);}//hp end
                                    }

                                    if (headtail==3){
                                        if   (arr[16]==0){xsr=xsr+dif;}
                                        if   (arr[16]==2){xsr=xsr-dif;}
                                        if   (arr[16]==1){yscr=yscr+dif;}
                                        if   (arr[16]==3){yscr=yscr-dif;}
                                        if (arr[22] == 1) {// unit under fire
                                            Color c = new Color(1f, 0f, 0f, .5f);
                                            g.setColor(c);
                                            g.fillOval(xsr, yscr, d, d);}

                                        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                                        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
                                        if (arr[10] == 1&&arr[14]>unmin&&arr[14]<unmax) {//gr unit sel
                                            g.setColor(new Color(175, 65, 175));
                                            g.drawOval(xsr, yscr, d, d);
                                            g.drawOval(xsr - 1, yscr - 1, d + 2, d + 2);
                                            g.setColor(new Color(255, 0, 0));
                                            g.drawOval(xsr - 3, yscr - 3, d + 6, d + 6);
                                            g.drawOval(xsr - 4, yscr - 4, d + 8, d + 8);
                                            g.setColor(new Color(255, 255, 255));
                                            g.drawOval(xsr - 2, yscr - 2, d + 4, d + 4);
                                        }
                                        if (arr[14]!=4&&arr[14]!=2004){
                                            int hp = arr[18];//hp
                                            int healthtotal = getunithp(arr[14]);
                                            g.setColor(new Color(255, 255, 255));
                                            g.fillRect(xsr+d/10-2,yscr+8*d/10-2,4*d/5+4,d/10+4);
                                            if (arr[14]<2000)   {  g.setColor(new Color(175, 65, 175));}
                                            else{ g.setColor(new Color(0, 0, 0));}
                                            double wdth = 1.0*hp/healthtotal*(4*d/5);
                                            int w = (int)wdth;
                                            g.fillRect(xsr+d/10,yscr+8*d/10,w,d/10);}//hp end
                                    }
                                }//hdes end
                            }//if unit on yx screen  head end

                            if (headtail==2){
                                if (arr[1] != arr[4]||arr[2] != arr[5] || arr[3] != arr[6]) {//tail start
                                    tail = 1;
                                    xsr = (arr[6] - ewpos);
                                    yscr = (arr[5] - nspos);
                                    if (xsr * d < d * blocksmumwidth && yscr * d < d * blocksmumwidth) { //if unit on yx screen
                                        int hdes = 0;
                                        if (zpos != mapheight) {
                                            if (zpos == arr[4]) {
                                                hdes = 1;
                                            }
                                        } else {//if top view start
                                            int hdes1, hdes2, hdes3;
                                            hdes1 = hdes2 = hdes3 = 1;

                                            for (int n = arr[4] + 1; n < mapheight - 1; n++) {
                                                if (map2[n][arr[5]][arr[6]] != 0) {
                                                    hdes2 = 0;
                                                    break;
                                                }
                                            }

                                            hdes = hdes2;
                                        }//if top view end
                                        if (hdes > 0) {
                                            xsr = xsr * d;
                                            yscr = yscr * d;

                                            if (arr[14] == 3 || arr[14] == 2003) {
                                                if (arr[11] != -1) {
                                                    g.setColor(new Color(255, 255, 255));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                if (arr[30] > 0) {
                                                    g.setColor(new Color(0, 0, 255));
                                                }//dig
                                                Polygon p = new Polygon(); //counter-clock
                                                int xd, yd, xd2;
                                                xd = yd = xd2 = 0;
                                                xd = d / 2;
                                                yd = d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p);

                                                if (arr[14] == 3) {
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p2 = new Polygon(); //counter-clock
                                                xd = d / 2;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = 2 * d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 2 * d / 10;
                                                yd = d - 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 2 * d / 10;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p2);
                                            }//if unit num3 end

                                            if (arr[14] == 5 || arr[14] == 2005) {
                                                if (arr[11] != -1) {//if moving
                                                    g.setColor(new Color(255, 255, 255));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p = new Polygon(); //counter-clock
                                                int xd, yd, xd2;
                                                xd = yd = xd2 = 0;
                                                xd = d / 2;
                                                yd = d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = 2 * d / 10;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2 - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2 + d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = 2 * d / 10;
                                                yd = 8 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p);
                                                if (arr[14] == 5) {//which side
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p2 = new Polygon(); //counter-clock
                                                xd = d / 2;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = 3 * d / 10;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2 - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2 + d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = 3 * d / 10;
                                                yd = 8 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p2);
                                                if (arr[21] == 1) {
                                                    g.setColor(new Color(255, 0, 0));
                                                } else {
                                                    g.setColor(new Color(255, 255, 255));
                                                }
                                                Polygon p3 = new Polygon(); //counter-clock
                                                xd = d - 3 * d / 10;
                                                yd = 7 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 7 * d / 10;
                                                yd = 7 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 7 * d / 10;
                                                yd = 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 3 * d / 10;
                                                yd = 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p3);
                                                // g.fillOval(xd+xsr,yd+ yscr, d/5, d/5);
                                            }//if unit num5 end

                                            if (arr[14] == 6 || arr[14] == 2006) {
                                                if (arr[11] != -1) {
                                                    g.setColor(new Color(255, 255, 255));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p = new Polygon(); //counter-clock
                                                int xd, yd, xd2;
                                                xd = yd = xd2 = 0;
                                                xd = d / 2;
                                                yd = d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p);
                                                if (arr[14] == 6) {
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p2 = new Polygon(); //counter-clock
                                                xd = d / 2;
                                                yd = 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p2);
                                                g.setColor(new Color(255, 255, 255));
                                                xd = 9 * d / 20;
                                                yd = 9 * d / 20;
                                                Polygon pov = new Polygon();
                                                xd=d/2;yd=9*d/20-1; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=d/2-d/20-2;yd=10*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=d/2;yd=11*d/20+1; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=d/2+d/20+1;yd=10*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                g.fillPolygon(pov);
                                            }//if unit num6 end

                                            if (arr[14] == 7 || arr[14] == 2007) {
                                                if (arr[11] != -1) {//if moving
                                                    g.setColor(new Color(255, 255, 255));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p = new Polygon(); //counter-clock
                                                int xd, yd, xd2;
                                                xd = yd = xd2 = 0;
                                                xd = d / 2;
                                                yd = d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = 2 * d / 10;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2 - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2 + d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = 2 * d / 10;
                                                yd = 8 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p);
                                                if (arr[14] == 7) {//which side
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p2 = new Polygon(); //counter-clock
                                                xd = d / 2;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = 3 * d / 10;
                                                yd = 2 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2 - d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2 + d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = 3 * d / 10;
                                                yd = 8 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p2);
                                                if (arr[21] == 1) {
                                                    g.setColor(new Color(255, 0, 0));
                                                } else { //fire
                                                    g.setColor(new Color(255, 255, 255));
                                                }
                                                Polygon p3 = new Polygon(); //counter-clock
                                                xd = d - 2 * d / 10;
                                                yd = 9 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 8 * d / 10;
                                                yd = 9 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 8 * d / 10;
                                                yd = 11 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 2 * d / 10;
                                                yd = 11 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p3);
                                                // g.fillOval(xd+xsr,yd+ yscr, d/5, d/5);
                                            }//if unit num7 end

                                            if (arr[14] == 8 || arr[14] == 2008) {
                                                if (arr[11] != -1) {
                                                    g.setColor(new Color(255, 255, 255));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p = new Polygon(); //counter-clock
                                                int xd, yd, xd2;
                                                xd = yd = xd2 = 0;
                                                xd = d / 2;
                                                yd = d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p);
                                                if (arr[14] == 8) {
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p2 = new Polygon(); //counter-clock
                                                xd = d / 2;
                                                yd = 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p2);
                                                if (arr[21] == 1) {
                                                    g.setColor(new Color(255, 0, 0));
                                                } else {
                                                    g.setColor(new Color(255, 255, 255));
                                                }
                                                Polygon p3 = new Polygon(); //counter-clock
                                                xd = d - 2 * d / 10;
                                                yd = 9 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 8 * d / 10;
                                                yd = 9 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 8 * d / 10;
                                                yd = 11 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                xd = d - 2 * d / 10;
                                                yd = 11 * d / 20;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p3.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p3);

                                            }//if unit num8 end

                                            if (arr[14] == 9 || arr[14] == 2009) {
                                                if (arr[11] != -1) {
                                                    g.setColor(new Color(255, 255, 255));
                                                }//in move
                                                else {
                                                    if (arr[25] == 0) {
                                                        g.setColor(new Color(255, 255, 0));
                                                    }//attacking ground
                                                    else {
                                                        g.setColor(new Color(0, 0, 0));
                                                    }
                                                }
                                                Polygon p = new Polygon(); //counter-clock
                                                int xd, yd, xd2;
                                                xd = yd = xd2 = 0;
                                                xd = d / 2;
                                                yd = d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - d / 5;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 10;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p);
                                                if (arr[14] == 9) {
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                Polygon p2 = new Polygon(); //counter-clock
                                                xd = d / 2;
                                                yd = 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 5;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d / 2;
                                                yd = d - 3 * d / 10;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                xd = d - d / 5;
                                                yd = d / 2;
                                                xd2 = xd;
                                                xd = mirrorx(arr[16], xd, yd);
                                                yd = mirrory(arr[16], xd2, yd);
                                                p2.addPoint(xd + xsr, yd + yscr);
                                                g.fillPolygon(p2);
                                                if (arr[21] == 1) {
                                                    g.setColor(new Color(255, 255, 0));
                                                } else {
                                                    g.setColor(new Color(255, 255, 255));
                                                }
                                                xd = 7 * d / 20;
                                                yd = 7 * d / 20;
                                                Polygon pov = new Polygon();
                                                xd=11*d/20;yd=7*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=9*d/20;yd=7*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=7*d/20;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=7*d/20;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=9*d/20;yd=13*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=11*d/20;yd=13*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=d-7*d/20;yd=11*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                xd=d-7*d/20;yd=9*d/20; xd2 =xd; xd=mirrorx(arr[16],xd,yd); yd=mirrory(arr[16],xd2,yd);
                                                pov.addPoint( xd + xsr, yd + yscr);
                                                g.fillPolygon(pov);
                                            }//if unit num9 end

                                            xsr = (arr[6] - ewpos) * d;
                                            yscr = (arr[5] - nspos) * d;

                                            if (arr[22] == 1) {// unit under fire
                                                Color c = new Color(1f, 0f, 0f, .5f);
                                                g.setColor(c);
                                                g.fillOval(xsr, yscr, d, d);
                                            }

                                            int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                                            if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
                                            if (arr[10] == 1&&arr[14]>unmin&&arr[14]<unmax) {//gr unit sel
                                                g.setColor(new Color(175, 65, 175));
                                                g.drawOval(xsr, yscr, d, d);
                                                g.drawOval(xsr - 1, yscr - 1, d + 2, d + 2);
                                                g.setColor(new Color(255, 0, 0));
                                                g.drawOval(xsr - 3, yscr - 3, d + 6, d + 6);
                                                g.drawOval(xsr - 4, yscr - 4, d + 8, d + 8);
                                                g.setColor(new Color(255, 255, 255));
                                                g.drawOval(xsr - 2, yscr - 2, d + 4, d + 4);
                                            }
                                            if (arr[14] != 4 && arr[14] != 2004) {
                                                int hp = arr[18];//hp
                                                int healthtotal = getunithp(arr[14]);
                                                g.setColor(new Color(255, 255, 255));
                                                g.fillRect(xsr + d / 10 - 2, yscr + 8 * d / 10 - 2, 4 * d / 5 + 4, d / 10 + 4);
                                                if (arr[14] < 2000) {
                                                    g.setColor(new Color(175, 65, 175));
                                                } else {
                                                    g.setColor(new Color(0, 0, 0));
                                                }
                                                double wdth = 1.0 * hp / healthtotal * (4 * d / 5);
                                                int w = (int) wdth;
                                                g.fillRect(xsr + d / 10, yscr + 8 * d / 10, w, d / 10);
                                            }//hp end

                                        }
                                    }}}//if unit on yx screen  tail end
                            tail=0;

                        }//cycle all units end
                    }// if unit list is not empty end

                    if (flashlist!=null&&zpos==mapheight) {
                        int arr[];
                        for (int i = 0; i < flashlist.size(); i++) {
                            arr = (int[]) flashlist.get(i);
                            int xsr = (arr[1] - ewpos);
                            int  yscr = (arr[0] - nspos);
                            if (xsr  <  blocksmumwidth && yscr  < blocksmumwidth) {
                                Color c = new Color(1f, 1f, 0f, .9f);
                                g.setColor(c);
                                g.fillOval(xsr*d, yscr*d, d, d);
                            }
                        }
                    }

                    if (zpos>=mapheight-1) {//air unit start =================
                        if (unitlist!=null) {// unit start
                            for (int i = 0; i < unitlist.size(); i++) {
                                int arr[]; int xsr, yscr;
                                arr = (int[]) unitlist.get(i);
                                xsr = (arr[3] - ewpos); //
                                yscr = (arr[2] - nspos);
                                if (xsr * d < d * blocksmumwidth && yscr * d < d * blocksmumwidth) {
                                    xsr = xsr * d;
                                    yscr = yscr * d;
                                    if (arr[14] == 4||arr[14] == 2004) {//air unit num4

                                        dif = (arr[15]-getunitspeed(arr[14]))*((d+d/10)/getunitspeed(arr[14]))-d/20;    //time. diff is zero or negative
                                        if (arr[15]<0){dif=0;}
                                        if ( arr[1] == arr[4]&&arr[2] == arr[5]&&arr[3] == arr[6]){{dif=0;}}

                                        if   (arr[16]==0){xsr=xsr+dif;}
                                        if   (arr[16]==2){xsr=xsr-dif;}
                                        if   (arr[16]==1){yscr=yscr+dif;}
                                        if   (arr[16]==3){yscr=yscr-dif;}

                                        if (arr[21] == 1) {//  fires
                                            Color c = new Color(1f, 1f, 0f, .9f);
                                            g.setColor(c);
                                            g.fillOval(xsr, yscr, d, d);}

                                        if (arr[11] != -1) {
                                            g.setColor(new Color(255, 255, 255));}//in move
                                        else{     if (arr[25] == 0) {
                                            g.setColor(new Color(255, 255, 0));}//attacking ground
                                        else{g.setColor(new Color(0, 0, 0));}}

                                        if (arr[16]==2||arr[16]==0)//ew
                                        {g.fillOval(xsr + d / 10, yscr + (d / 2 - 3*d / 10), 8 * d / 10, d / 2);
                                            if (arr[14]==4){
                                                g.setColor(new Color(175, 65, 175));}
                                            else {g.setColor(new Color(0, 0, 0));}
                                            g.fillOval(xsr + 2*d / 10, yscr + d /2-d/5, 6 * d / 10, d / 3);}
                                        else{
                                            g.fillOval(xsr + (d / 2 - 3*d / 10), yscr + ( d / 10),  d / 2, 8 * d / 10);
                                            if (arr[14]==4){
                                                g.setColor(new Color(175, 65, 175));}
                                            else {g.setColor(new Color(0, 0, 0));}
                                            g.fillOval(xsr +  d /2-d/5, yscr + 2*d / 10, d / 3, 6*d / 10);}
                                        if (arr[22] == 1) {// unit under fire
                                            Color c = new Color(1f, 0f, 0f, .5f);
                                            g.setColor(c);
                                            g.fillOval(xsr, yscr, d, d);}

                                        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                                        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
                                        if (arr[10] == 1&&arr[14]>unmin&&arr[14]<unmax) {//air unit sel
                                            g.setColor(new Color(175, 65, 175));
                                            g.drawOval(xsr, yscr, d, d);
                                            g.drawOval(xsr - 1, yscr - 1, d + 2, d + 2);
                                            g.setColor(new Color(255, 255, 255));
                                            g.drawOval(xsr - 2, yscr - 2, d + 4, d + 4);
                                        }

                                        int hp = arr[18];//hp
                                        int healthtotal = getunithp(arr[14]);
                                        g.setColor(new Color(255, 255, 255));
                                        g.fillRect(xsr+d/10-2,yscr+7*d/10-2,4*d/5+4,d/10+4);
                                        if (arr[14]<2000)   {  g.setColor(new Color(175, 65, 175));}
                                        else{ g.setColor(new Color(0, 0, 0));}
                                        double wdth = 1.0*hp/healthtotal*(4*d/5);
                                        int w = (int)wdth;
                                        g.fillRect(xsr+d/10,yscr+7*d/10,w,d/10);//hp end


                                    }//air unit num4 end
                                }  //if air unit is in screen xy
                            }//cycle all units end
                        }//if units num not zero
                    }// if air zpos view sky or top end

                    if (reslist!=null) {
                        int arr[];
                        for (int i = 0; i < reslist.size(); i++) {
                            arr = (int[]) reslist.get(i);
                            int xsr = (arr[1] - ewpos);
                            int  yscr = (arr[0] - nspos);
                            if (xsr  <  blocksmumwidth && yscr  < blocksmumwidth) {
                                Color c = new Color(0f, 1f, 0f, .5f);
                                g.setColor(c);
                                g.fillOval(xsr*d+d/4, yscr*d+d/4, d/2, d/2);
                                g.setColor(new Color(255, 255, 255));
                                g.drawRect(xsr*d+d/10 , yscr*d+d/10 , 4*d/5 , 4*d/5 );
                                g.setColor(new Color(0, 0, 0));
                                g.drawRect(xsr*d+d/10+1 , yscr*d+d/10 +1, 4*d/5 -2, 4*d/5-2 );
                                g.setColor(new Color(0, 255, 0));
                                g.drawRect(xsr*d+d/10+2 , yscr*d+d/10 +2, 4*d/5 -4, 4*d/5-4 );
                            }
                        }
                    }
                }
                g2d.dispose();
            }//if   specialview ==0 end
            else{
                if (specialview==1)//ns
                {
                    int z, i3, i2; z=i3=i2=0;
                    int xpix, ypix; xpix=ypix=0;
                    i2=nspos; i3=ewpos;

                    g.setColor(new Color(255, 255, 255));
                    g.fillRect(0 , 0, d*blocksmumwidth, d*blocksmumwidth);
                    for ( z=mapheight-1; z>-1; z--){
                        for (int i=0; i <blocksmumwidth; i++){
                            if (map2[z][i2][i3] >= 998_000 ){
                                g.setColor(new Color(190, 190, 190));
                                g.fillRect(xpix , ypix, d, d);
                                if (map2[z][i2][i3] >= 999_000 ) {//gravel draw start

                                    int w = (int) d / 6;
                                    int w2 = 0;
                                    int y2 = 0;
                                    for (int i5 = 0; i5 < 3; i5++) {
                                        for (int i4 = 0; i4 < 3; i4++) {
                                            g.setColor(new Color(0, 0, 0));
                                            g.fillOval(w2 + xpix, y2 + ypix, 2 * w, 2 * w);
                                            g.setColor(new Color(190, 190, 190));
                                            g.fillOval(w2 + xpix + grawelwidth, ypix+y2  + grawelwidth, 2 * w - 2 * grawelwidth,
                                                    2 * w - 2 * grawelwidth);
                                            w2 = w2 + 2 * w;
                                        }
                                        y2 = y2 + 2 * w;
                                        w2 = 0;
                                    }
                                }//gravel draw end
                                globalz = z;  colormet();
                                if (z==0){col1 = 0; col2 = 20; col3 = 255; }
                                g.setColor(new Color(col1, col2, col3));
                                g.fillRect(xpix , ypix-5, d, 5);
                            }
                            if (map2[z][i2][i3] > 2 && map2[z][i2][i3]<2000 ){
                                g.setColor(new Color(165, 75, 165));
                                g.fillOval(xpix , ypix, d, d);}
                            if (map2[z][i2][i3] > 2000 && map2[z][i2][i3]<4000 ){
                                g.setColor(new Color(0, 0, 0));
                                g.fillOval(xpix , ypix, d, d);}
                            if (map2[z][i2][i3] > 4000 && map2[z][i2][i3]<6000 ){
                                g.setColor(new Color(25, 125, 55));
                                g.fillOval(xpix , ypix, d, d);}
                            xpix+=d; i2++;
                        }
                        ypix+=d;   i2=nspos; i3=ewpos; xpix=0;
                    }
                    g.setColor(new Color(175, 65, 175));
                    g.fillRect(0 , ypix-5, d*blocksmumwidth, 5);
                    if(reslist!=null){
                        for (int i = 0; i <reslist.size(); i++)
                        {
                            int arr[]; arr = (int[]) reslist.get(i);
                            int tempy = nspos+blocksmumwidth;
                            if(arr[1]==ewpos&&arr[0]>=nspos&&arr[0]<=tempy){
                                g.setColor(new Color(0, 255, 0));
                                g.fillRect(Math.abs(nspos-arr[0])*d+8 , 0,2 , d*blocksmumwidth);
                                g.fillRect(Math.abs(nspos-arr[0])*d-8 +d, 0,2 , d*blocksmumwidth);
                            }
                        }
                    }
                    redrawmainfield();
                } //ns specialv end
                else{
                    if (specialview==2){//ew
                        int z, i3, i2; z=i3=i2=0;
                        int xpix, ypix; xpix=ypix=0;
                        i2=nspos; i3=ewpos;

                        g.setColor(new Color(255, 255, 255));
                        g.fillRect(0 , 0, d*blocksmumwidth, d*blocksmumwidth);
                        for ( z=mapheight-1; z>-1; z--){
                            for (int i=0; i <blocksmumwidth; i++){
                                if (map2[z][i2][i3] >= 998_000 ){
                                    g.setColor(new Color(190, 190, 190));
                                    g.fillRect(xpix , ypix, d, d);
                                    if (map2[z][i2][i3] >= 999_000 ) {//gravel draw start

                                        int w = (int) d / 6;
                                        int w2 = 0;
                                        int y2 = 0;
                                        for (int i5 = 0; i5 < 3; i5++) {
                                            for (int i4 = 0; i4 < 3; i4++) {
                                                g.setColor(new Color(0, 0, 0));
                                                g.fillOval(w2 + xpix, y2 + ypix, 2 * w, 2 * w);
                                                g.setColor(new Color(190, 190, 190));
                                                g.fillOval(w2 + xpix + grawelwidth, ypix+y2  + grawelwidth, 2 * w - 2 * grawelwidth,
                                                        2 * w - 2 * grawelwidth);
                                                w2 = w2 + 2 * w;
                                            }
                                            y2 = y2 + 2 * w;
                                            w2 = 0;
                                        }
                                    }//gravel draw end
                                    globalz = z;  colormet();
                                    if (z==0){col1 = 0; col2 = 20; col3 = 255; }
                                    g.setColor(new Color(col1, col2, col3));
                                    g.fillRect(xpix , ypix-5, d, 5);
                                }
                                if (map2[z][i2][i3] > 2 && map2[z][i2][i3]<2000 ){
                                    g.setColor(new Color(165, 75, 165));
                                    g.fillOval(xpix , ypix, d, d);}
                                if (map2[z][i2][i3] > 2000 && map2[z][i2][i3]<4000 ){
                                    g.setColor(new Color(0, 0, 0));
                                    g.fillOval(xpix , ypix, d, d);}
                                if (map2[z][i2][i3] > 4000 && map2[z][i2][i3]<6000 ){
                                    g.setColor(new Color(25, 125, 55));
                                    g.fillOval(xpix , ypix, d, d);}
                                xpix+=d; i3++;
                            }
                            ypix+=d;   i2=nspos; i3=ewpos; xpix=0;
                        }
                        g.setColor(new Color(175, 65, 175));
                        g.fillRect(0 , ypix-5, d*blocksmumwidth, 5);
                        if(reslist!=null){
                            for (int i = 0; i <reslist.size(); i++)
                            {
                                int arr[]; arr = (int[]) reslist.get(i);
                                int tempx = ewpos+blocksmumwidth;
                                if(arr[0]==nspos&&arr[1]>=ewpos&&arr[1]<=tempx){
                                    g.setColor(new Color(0, 255, 0));
                                    g.fillRect(Math.abs(ewpos-arr[1])*d+8 , 0,2 , d*blocksmumwidth);
                                    g.fillRect(Math.abs(ewpos-arr[1])*d-8 +d, 0,2 , d*blocksmumwidth);
                                }
                            }
                        }
                        redrawmainfield();
                    }  //ew end
                    else{//specialv not 1 or 2 start
                        int map5[][][] = null; int mpw, mpl; mpw=mpl=0;

                        if (roll==0||roll==315){
                         mpw=mapwidth;   //ns
                         mpl=maplength;//ew
                        map5 = new int[mapheight][mpw][mpl];
                        for (int i = 0; i < mapheight; i++){
                            for (int j = 0; j < mpw; j++){
                                for (int k = 0; k < mpl; k++) {
                                    map5[i][j][k] = map2[i][j][k];}}}
}
                        if (roll==270||roll==225){
                            mpw= maplength;
                            mpl=mapwidth;
                            map5 = new int[mapheight][mpw][mpl];
                            for (int i = 0; i < mapheight; i++){
                                for (int j = 0; j < mapwidth; j++){
                                    for (int k = 0; k < maplength; k++) {
                                        map5[i][maplength-k-1][j] = map2[i][j][k];}}}
                        }

                        if (roll==90||roll==45){
                            mpw= maplength;
                            mpl=mapwidth;
                            map5 = new int[mapheight][mpw][mpl];
                            for (int i = 0; i < mapheight; i++){
                                for (int j = 0; j < mapwidth; j++){
                                    for (int k = 0; k < maplength; k++) {
                                        map5[i][k][mapwidth-j-1] = map2[i][j][k];}}}
                        }

                        if (roll==180||roll==135){
                            mpw= mapwidth;
                            mpl=maplength;
                            map5 = new int[mapheight][mpw][mpl];
                            for (int i = 0; i < mapheight; i++){
                                for (int j = 0; j < mapwidth; j++){
                                    for (int k = 0; k < maplength; k++) {
                                        map5[i][mapwidth-j-1][maplength-k-1] = map2[i][j][k];}}}
                        }

                        int i;int j;int k; i=j=k=0;
                        int d2=d/4;
                        int d3 = 2*d2/3;
                        int xstart =0;
                        int ystart=0;

 if (roll==0||roll==90||roll==180||roll==270){
  xstart=(int)(mpl*d2*2 -d2*2 +maplength/2*d-d/2  -ewpossiom *d2*2);
   ystart=(int) (mapheight*d2*2 -d2 -nspossiom *d2*2);   }

  if (roll==315||roll==45||roll==135||roll==225){
 xstart =(int) (mpl*d2*2 -d2*2   -ewpossiom *d2*2);
 ystart =(int) ((22*d2 -d2*(mpl-blocksmumwidth)) -nspossiom *d2*2); }

                        xd=xstart;
                        yd=ystart ;

                        g.setColor(new Color(175, 65, 165));
                        g.fillRect(0,0,d*(blocksmumwidth+1),d*(blocksmumwidth+1));

                        for (i = 0;i  <mapheight; i++){
                            globalz = i;  colormet();
                            if (i==0){col1 = 0; col2 = 20; col3 = 255; }
                            for (j = 0;j  <mpw; j++){
                                for (k = mpl-1; k >-1; k--){
                                    int t= -666;
                                    try {t = map5[i][j][k];} catch (Exception e){}

                                    if (t!=-666){
                                        if (t>997999) {
                                            Polygon p= new Polygon(); //counter-clock
                                            if (roll==315||roll==45||roll==135||roll==225){
                                            p.addPoint(0*d2+xd, 1*d2+yd);
                                            p.addPoint(2*d2+xd, 2*d2+yd);
                                            p.addPoint(4*d2+xd, 1*d2+yd);
                                            p.addPoint(2*d2+xd, yd);
                                            }else{
                                                p.addPoint(xd, yd);
                                                p.addPoint(xd, 2*d2+yd);
                                                p.addPoint(4*d2+xd, 2*d2+yd);
                                                p.addPoint(4*d2+xd, yd);
                                            }
                                            g.setColor(new Color(col1, col2, col3));
                                            g.fillPolygon(p);

                                            if (roll==315||roll==45||roll==135||roll==225){
                                            Polygon p2= new Polygon();
                                            p2.addPoint(0*d2+xd, 1*d2+yd);
                                            p2.addPoint(0*d2+xd, 3*d2+yd);
                                            p2.addPoint(2*d2+xd, 4*d2+yd);
                                            p2.addPoint(2*d2+xd, 2*d2+yd);
                                            g.setColor(new Color(120, 120, 120));
                                            g.fillPolygon(p2);}

                                            Polygon p3= new Polygon();
                                            if (roll==315||roll==45||roll==135||roll==225){
                                            p3.addPoint(2*d2+xd, 2*d2+yd);
                                            p3.addPoint(2*d2+xd, 4*d2+yd);
                                            p3.addPoint(4*d2+xd, 3*d2+yd);
                                            p3.addPoint(4*d2+xd, 1*d2+yd);
                                            }else{
                                                p3.addPoint(xd, 2*d2+yd);
                                                p3.addPoint(xd, 4*d2+yd);
                                                p3.addPoint(4*d2+xd, 4*d2+yd);
                                                p3.addPoint(4*d2+xd,2*d2+ yd);
                                            }
                                            g.setColor(new Color(220, 220, 220));
                                            g.fillPolygon(p3);

                                            if (t>998999) {
                                                g.setColor(new Color(0, 0, 0));
                                                g.drawOval(xd+3*d2/4,yd+3*d2/5,d3,d3);
                                                g.drawOval(xd+3*d2/4+d2+d2/2,yd+3*d2/5,d3,d3);
                                                g.drawOval(xd,yd+2*d2,d3,d3);
                                                g.drawOval(xd+d2,yd+2*d2,d3,d3);
                                                g.drawOval(xd+2*d2+d3/3,yd+2*d2+d3/3,d3,d3);
                                                g.drawOval(xd+3*d2+d3/3,yd+2*d2+d3/3,d3,d3);
                                            }
                                        }

                                        if (isomShowBlocksOnly==1){
                                            if (map5[i][j][k] > 2 && map5[i][j][k]<2000 ){
                                                g.setColor(new Color(165, 75, 165));
                                                g.fillOval(xd+4*d2/4 , yd+d2+d2/4, d2*2, d2*2);}
                                            if (map5[i][j][k] > 2000 && map5[i][j][k]<4000 ){
                                                g.setColor(new Color(0, 0, 0));
                                                g.fillOval(xd+4*d2/4 , yd+d2+d2/4, d2*2, d2*2);}
                                            if (map5[i][j][k] > 4000 && map5[i][j][k]<6000 ){
                                                g.setColor(new Color(25, 125, 55));
                                                g.fillOval(xd+4*d2/4 , yd+d2+d2/4, d2*2, d2*2);}
                                            if (map5[i][j][k] > 2 && map5[i][j][k]<6000 ){
                                                g.setColor(new Color(255, 255, 255));
                                                g.drawOval(xd+4*d2/4 , yd+d2+d2/4, d2*2, d2*2);}
                                        }
                                    }
                                    if (roll==315||roll==45||roll==135||roll==225){
                                    xd=xd-d2*2;
                                    yd=yd+d2*1;}else{
                                        xd=xd-d2*4;
                                    }
                                }
                                if (roll==315||roll==45||roll==135||roll==225){
                                xd=xstart+d2*2*(j+1);
                                yd=ystart+d2*(j+1) - 2*d2*i;}else{
                                    xd=xstart;
                                    yd+=d2*2 ;
                                }
                            }
                            if (roll==315||roll==45||roll==135||roll==225){
                            xd=xstart;
                            yd=ystart- 2*d2*(i+1);}else{
                                xd=xstart;
                                yd=ystart- 2*d2*(i+1);
                            }
                        }

                    }//specialv not 1 or 2 end
                }
            }//if   specialview!=0 end

        }
    }//


    public static class TestPane2 extends JPanel {//menu
        public TestPane2() {
        }
        public void drawf2() {
            repaint();
        }
        @Override
        protected void paintComponent(Graphics g) {//menu draw
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            if (vertsliceall==0){
                g.setColor(new Color(0, 0, 0));
                g.fillRect(0, 0, d-5,(blocksmumwidth+1)*d);
            }else{//draw vertsliceall
                int y = mb_block_menu_y; int x = mb_block_menu_x;
                int sty=4;   int stx=4;
                int ybord=2; int yslice_blocknum=5;
                int ewdelta=x-yslice_blocknum/2;//for 5 it will be -2
                int ewpixdelta=stx;
                int nsdelta=y-yslice_blocknum/2;//for 5 it will be -2
                int nspixdelta=sty;

                g.setColor(new Color(0, 0, 0));
                g.fillRect(0, 0, d-5,(blocksmumwidth+1)*d);
                g.setColor(new Color(255, 255, 255));
                g.fillRect(0, 0, 1,(blocksmumwidth+1)*d);

                for (int i3 = mapheight-1; i3 >-1; i3--){
                    if (i3==zpos){
                        g.setColor(new Color(165, 75, 165));
                        if (zpos==0){g.setColor(new Color(0, 0, 0));}
                        g.fillRect(0, nspixdelta, 4,vside);
                        g.fillRect(0, nspixdelta+2*vside, 4,vside);
                        g.fillRect(0, nspixdelta+4*vside, 4,vside);
                        g.setColor(new Color(220, 220, 220));
                        g.fillRect(0, nspixdelta+1*vside, 4,vside);
                        g.fillRect(0, nspixdelta+3*vside, 4,vside);
                    }

                    if (i3==mapheight-1){g.setColor(new Color(240, 240, 255));}//sky blue
                    if (i3==0){ col1 = 163;   col2 = 73;    col3 = 164; //violet
                        g.setColor(new Color(col1, col2, col3));}
                    if  (i3!=mapheight-1&&i3!=0)
                    { g.setColor(new Color(255, 255, 255));}
                    g.fillRect(ewpixdelta, nspixdelta,vside*yslice_blocknum ,(yslice_blocknum)*vside);
                    globalz = i3;
                    colormet();
                    if (i3==0){ col1 = 0; col2 = 20; col3 = 255; }
                    g.setColor(new Color(col1, col2, col3));
                    for (int i2 = 0; i2 <yslice_blocknum; i2++){
                        for (int i = 0; i <yslice_blocknum; i++){
                            int t=-1; try {t=map2[i3][nsdelta][ewdelta];}catch (Exception e){}
                            if (t>997999)     {g.fillRect(ewpixdelta, nspixdelta, vside,vside);}
                            ewdelta++; ewpixdelta =ewpixdelta+vside;
                        }
                        ewdelta=x-yslice_blocknum/2; ewpixdelta=stx;
                        nsdelta++; nspixdelta = nspixdelta+vside;
                    }
                    nspixdelta = (mapheight-i3)*d+(d-vside*yslice_blocknum)/2;
                    ewdelta=x-yslice_blocknum/2; ewpixdelta=stx; nsdelta=y-yslice_blocknum/2;
                }
                if (zpos==mapheight){
                    g.setColor(new Color(165, 75, 165));
                    g.fillRect(stx, 0, vside,4);
                    g.fillRect(stx+2*vside, 0, vside,4);
                    g.fillRect(stx+4*vside, 0, vside,4);
                    g.setColor(new Color(255, 255, 225));
                    g.fillRect(stx+1*vside, 0, vside,4);
                    g.fillRect(stx+3*vside, 0, vside,4);
                }
            }//draw vertsliceall end

            g.setFont(new Font("Arial", Font.BOLD, 14));
            int   ds =(int) (d/3.4); //if d=64, ds = 18; if d = 51 ds =15 pix
            st = (int)((d*2.1)+ (d/3.4));
            int ys = ds;

            int mon =moneypl1; if (iampl2>0){mon =moneypl2;}

            g.setColor(new Color(100, 100, 100));
            g.fillRect(d-3, ds-3, 2*d+6,ds+6);

            if (mp==0){
                if (mapdev==1){g.setColor(new Color(0, 0, 255));} else{
                    g.setColor(new Color(0, 0, 0));}
                g.fillRect(d, ds, 2*d,ds+2);
                g.setColor(new Color(255, 255, 255));
            }
            else{
                g.setColor(new Color(200, 190, 230));
                g.fillRect(d, ds, 2*d,ds+2);
                g.setColor(new Color(0, 0, 0));
            }
            g.drawString("MENU", 7*d/4, 2*ds-2);

            if (bigmenuon!=0){
                if (mp==0){
                    if (mapdev==1){g.setColor(new Color(0, 0, 255));} else{
                        g.setColor(new Color(0, 0, 0));}}else{
                    g.setColor(new Color(200, 190, 230));
                }
                g.fillRect(d-3, ds-3, 2*d+6,ds+6);}

            g.setColor(new Color(0, 0, 0));
            ys=ys+2*ds;     g.drawString(text1s, d, ys);

            g.setFont(new Font("Arial", Font.PLAIN, 12));
            //  String   text3= mapname+" h: "+mapheight+" ns: "+mapwidth+" ew: "+maplength;
            String text3=unitscountpl1+"/"+unitsnum/2+" "+buildcountpl1 +"/"+buildnum/2+" "
                    +buildshootcountpl1+"/" +shootingbuildforone+" "+hqnump1+"/2";
            if (iampl2>0){
                text3=unitscountpl2+"/"+unitsnum/2+" "+buildcountpl2 +"/"+buildnum/2+" "
                        +buildshootcountpl2+"/" +shootingbuildforone+" "+hqnump2+"/2";
            }

            ys=ys+ds; g.drawString(text3, d, ys);

            String t1 = "777";  String t2 = "777";
            if (transparentview==0){
                if (zpos==mapheight){t1="top. ";}
                if (zpos==mapheight-1){t1="sky. ";}
                if (zpos==mapheight-2){t1="peak. ";}
                if (zpos<mapheight-2){t1="slice. ";}
                if (zpos==0){t1="bottom. ";}
            }else{t1="tunn. ";}
            if (specialview==1){t1="v_ns ";}
            if (specialview==2){t1="v_ew ";}
            if (specialview==3){t1="A_"+roll+" ";}

            String text4 ="";
            text4 = t1+" m_pos: "+ zpos+ " "+nspos+" "+ewpos+"_ph"+phflag;
            if (specialview==1||specialview==2||specialview==3){ text4 = t1+" m_pos: "+ "all"+ " "+nspos+" "+ewpos+"_ph"+phflag;}
            ys=ys+ds; g.drawString(text4, d, ys);

            if (brush>2000&&brush<4000){t2="pl2 ";}else{t2="";}
            if (brush==-1){t2="sele. ";}
            if (brush>=998000&&brush<999000){t2="rock. ";}
            if (brush>=999000){t2="grav. ";}

            if (brush>998000&&brush!=999000) {
                String name = getname(brush);
                t2 = t2 + name;
            }

            if (brush>2&&brush<6000) {
                String name = getname(brush);
                t2 = t2 + name;
            }

            if (brush==0){t2="void. ";}
            text2s = "_bl: "+mb_block_menu_z+" "+mb_block_menu_y+" "+mb_block_menu_x+" br: "+t2+brsz+" "+brsy+" "+brsx;
            ys=ys+ds; g.drawString(text2s, d, ys);

            //  ys=ys+ds; g.drawString(xclick+"_"+yclick+" "+xrel+"_"+yrel, d, ys);

            if ( menutimer.equals("maybe net problems")){}else{
                if (mp==0){
                    if   (timeron>0)
                    {  menutimer=   "<time is on> 'n' to stop";}
                    else{  menutimer=  "<paused> 'n' to go";}}else{
                    if   (mpgamerunning>0){ menutimer= "multipl runs";}    else{
                        menutimer=  "multipl waits";
                    }}}
            ys=ys+ds; g.drawString(   menutimer, d, ys);
            //


            g.setFont(new Font("Arial", Font.PLAIN, 14));
            int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
            if (iampl2>0){        unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}

            int arr[] = new int[40]; int countsingle=0;
            for (int i = 0; i < unitlist.size(); i++) {
                arr = (int[]) unitlist.get(i);
                if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){singleselect=i;countsingle++;}
            }
            for (int i = 0; i < buildlist.size(); i++) {
                arr = (int[]) buildlist.get(i);
                if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){singleselect=-i; countsingle++;
                    if (i==0){singleselect=-777;}
                }
            }
            if (countsingle!=1){singleselect=666;}else{
                int sel = singleselect;
                if (singleselect>=0){
                    arr = (int[]) unitlist.get(sel);
                }
                else{
                    if (singleselect==-777){sel=0;}else{sel=-sel;}
                    arr = (int[]) buildlist.get(sel);
                }
            }//
            int descr = 666;
            String selectionone = null;
            String bonus = "";
            if (countsingle==1){
                ys=st; int yscr = st; int xsr = d+2;
                descr=arr[14];

                if (arr[14]==1010||arr[14]==3010) {//dummy
                    bonus=": "+getname(arr[29]);
                }

                if (arr[14]==1001||arr[14]==3001) {//mine
                    if (arr[19]==0){bonus="offline";}
                    else{
                        bonus ="$"+ (-arr[19]);
                        if (arr[1]!=0){bonus=bonus+" . not max";}
                    }
                }

                int unitc = unitscountpl1; if (iampl2>0){unitc = unitscountpl2;}

                if (arr[14]==1003||arr[14]==3003) {
                    if (arr[26]!=0) {
                        double db1 = 1.0*arr[26];
                        double db2 = 1.0*getpspeedbuild(arr[14]);
                        double db = (db2-db1)/db2*100;
                        bonus =" .w: "+ (int)db+"%";

                        if (arr[26]==1||arr[26]==2){bonus=bonus+" check space";}
                    }

                    if (unitc  <unitsnum/2&& mon>=getprice(3)&&arr[26]==0){//eng in hq
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}

                    g.fillRect(d+2, st, d,d);

                    g.setColor(new Color(0, 0, 0));
                    Polygon p = new Polygon(); //counter-clock
                    int xd, yd, xd2;
                    xd=d/2;yd=d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    xd=d/10;yd=d/2;
                    p.addPoint(xd + xsr,  yd + yscr);
                    xd=d/2;yd=d-d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d-d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    g.fillPolygon(p);

                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("engin", d+2, ys);
                    ys=ys+ds; g.drawString(getprice(3)+"", d+2, ys);
                }//hq end

                if (arr[14]==1008||arr[14]==3008) {//barracks
                    if (arr[26]!=0) {
                        double db1 = 1.0*arr[26];
                        double db2 = 1.0*getpspeedbuild(arr[29]);
                        double db = (db2-db1)/db2*100;
                        //   System.out.println(db1+" "+db2);
                        bonus =" .w: "+ (int)db+"%";

                        if (arr[26]==1||arr[26]==2){bonus=bonus+" check space";}
                    }

                    if (unitc  <unitsnum/2&&mon>=getprice(3)&&arr[26]==0){//eng in barracks
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    g.fillRect(d+2, st, d,d);
                    g.setColor(new Color(0, 0, 0));
                    Polygon p = new Polygon();
                    int xd, yd, xd2;
                    xd=d/2;yd=d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    xd=d/10;yd=d/2;
                    p.addPoint(xd + xsr,  yd + yscr);
                    xd=d/2;yd=d-d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d-d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d/10;
                    p.addPoint( xd + xsr, yd + yscr);
                    g.fillPolygon(p);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("engin", d+2, ys);
                    ys=ys+ds; g.drawString(getprice(3)+"", d+2, ys);

                    int nm = 4;  ys=ys+5; //zepp
                    if (unitc  <unitsnum/2&&mon>=getprice(nm)&&arr[26]==0){
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    int hdzep=1;   try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky
                        if (Sol.map2[n][arr[2]][arr[3]]!=0){hdzep=0;break;}}} catch (Exception ef){}
                    if (hdzep==0){ g.setColor(new Color(150, 150, 150));}

                    g.fillRect(d+2, ys, d,d);
                    g.setColor(new Color(0, 0, 0));
                    g.fillOval(d+2+d/10, ys+d/4, 4*d/5,d/2);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("zepp.", d+2, ys);
                    ys=ys+ds; g.drawString(getprice(nm)+"", d+2, ys);

                    nm = 5;  ys=ys+5; //air def
                    if (unitc  <unitsnum/2&&mon>=getprice(nm)&&arr[26]==0){
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    g.fillRect(d+2, ys, d,d);
                    xsr=d+2;  yscr = ys;
                    g.setColor(new Color(0, 0, 0));
                    Polygon p5 = new Polygon();
                    int yd2;
                    xd2=d/2;yd2=d/10;
                    p5.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=2*d/10;yd2=2*d/10;
                    p5.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d/10;yd2=d/2-d/10;
                    p5.addPoint(xd2 + xsr,  yd2 + yscr);
                    xd2=d/10;yd2=d/2+d/10;
                    p5.addPoint(xd2 + xsr,  yd2 + yscr);
                    xd2=2*d/10;yd2=8*d/10;
                    p5.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d/2;yd2=d-d/10;
                    p5.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d-d/10;yd2=d-d/10;
                    p5.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d-d/10;yd2=d/10;
                    p5.addPoint( xd2 + xsr, yd2 + yscr);
                    g.fillPolygon(p5);
                    g.setColor(new Color(255, 255, 255));
                    g.fillRect(d+2+d/3, ys+d/3, 8*d/20,8*d/20);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("air de", d+2, ys);
                    ys=ys+ds; g.drawString(getprice(nm)+"", d+2, ys);

                    nm = 6;  ys=ys+5; //mortar
                    if (unitc  <unitsnum/2&&mon>=getprice(nm)&&arr[26]==0){
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    g.fillRect(d+2, ys, d,d);
                    xsr=d+2;  yscr = ys;
                    g.setColor(new Color(0, 0, 0));
                    Polygon p6 = new Polygon();
                    xd=d/2;yd=d/5;
                    p6.addPoint( xd + xsr, yd + yscr);
                    xd=d/10;yd=d/2;
                    p6.addPoint(xd + xsr,  yd + yscr);
                    xd=d/2;yd=d-d/5;
                    p6.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d/2;
                    p6.addPoint( xd + xsr, yd + yscr);
                    g.fillPolygon(p6);
                    g.setColor(new Color(255, 255, 255));
                    xd=9*d/20;yd=9*d/20;
                    g.fillOval(xsr+xd, yscr+yd, 3*d/20, 3*d/20);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("morta", d+2, ys-3);
                    ys=ys+ds; g.drawString(getprice(nm)+"", d+2, ys-3);

                    nm = 7;  ys=st; //car gun
                    if (unitc  <unitsnum/2&&mon>=getprice(nm)&&arr[26]==0){
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    xsr=2*d+2;  yscr = ys;
                    g.fillRect(xsr, ys, d,d);
                    g.setColor(new Color(0, 0, 0));
                    Polygon p7 = new Polygon();
                    xd2=d/2;yd2=d/10;
                    p7.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=2*d/10;yd2=2*d/10;
                    p7.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d/10;yd2=d/2-d/10;
                    p7.addPoint(xd2 + xsr,  yd2 + yscr);
                    xd2=d/10;yd2=d/2+d/10;
                    p7.addPoint(xd2 + xsr,  yd2 + yscr);
                    xd2=2*d/10;yd2=8*d/10;
                    p7.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d/2;yd2=d-d/10;
                    p7.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d-d/10;yd2=d-d/10;
                    p7.addPoint( xd2 + xsr, yd2 + yscr);
                    xd2=d-d/10;yd2=d/10;
                    p7.addPoint( xd2 + xsr, yd2 + yscr);
                    g.fillPolygon(p7);
                    g.setColor(new Color(255, 255, 255));
                    g.fillRect(d/4+xsr, ys+9*d/20, 3*d/5,d/10);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("car gu", 2*d+4, ys);
                    ys=ys+ds; g.drawString(getprice(nm)+"", 2*d+4, ys);

                    nm = 8;  ys=ys+5; //tank
                    if (unitc  <unitsnum/2&&mon>=getprice(nm)&&arr[26]==0){
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    g.fillRect(2*d+4, ys, d,d);
                    xsr=2*d+4;  yscr = ys;
                    g.setColor(new Color(0, 0, 0));
                    Polygon p8 = new Polygon();
                    xd=d/2;yd=d/5;
                    p8.addPoint( xd + xsr, yd + yscr);
                    xd=d/10;yd=d/2;
                    p8.addPoint(xd + xsr,  yd + yscr);
                    xd=d/2;yd=d-d/5;
                    p8.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d/2;
                    p8.addPoint( xd + xsr, yd + yscr);
                    g.fillPolygon(p8);
                    g.setColor(new Color(255, 255, 255));
                    g.fillRect(d/5+xsr, ys+9*d/20, 3*d/5,d/10);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString(getname(nm), 2*d+4, ys);
                    ys=ys+ds; g.drawString(getprice(nm)+"", 2*d+4, ys);

                    nm = 9;  ys=ys+5; //heavy howitzer
                    if (unitc  <unitsnum/2&&mon>=getprice(nm)&&arr[26]==0){
                        g.setColor(new Color(0, 150, 0));}
                    else{ g.setColor(new Color(150, 150, 150));}
                    g.fillRect(2*d+4, ys, d,d);
                    xsr=2*d+4;  yscr = ys;
                    g.setColor(new Color(0, 0, 0));
                    Polygon p9 = new Polygon();
                    xd=d/2;yd=d/5;
                    p9.addPoint( xd + xsr, yd + yscr);
                    xd=d/10;yd=d/2;
                    p9.addPoint(xd + xsr,  yd + yscr);
                    xd=d/2;yd=d-d/5;
                    p9.addPoint( xd + xsr, yd + yscr);
                    xd=d-d/10;yd=d/2;
                    p9.addPoint( xd + xsr, yd + yscr);
                    g.fillPolygon(p9);
                    g.setColor(new Color(255, 255, 255));
                    g.fillOval (xsr+d/3, yscr+d/3,d/3,d/3);
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(0, 0, 0));
                    ys=(int)(ys+d+ds-5);  g.drawString("howit", 2*d+4, ys);
                    ys=ys+ds; g.drawString(getprice(nm)+"", 2*d+4, ys);

                }//barracks end

                if (arr[14]==3&&arr[11]==-1||arr[14]==2003&&arr[11]==-1) { //eng
                    int frh = (int) (d * 2.1) - 2;
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(new Color(150, 150, 150));
                    g.fillRect(5 * d / 2, frh, 3 * ds, 1 * ds + 2);
                    if (engswitch == 0) {
                        g.setColor(new Color(0, 0, 0));
                        g.drawRect(5 * d / 2 + 1, frh + 1, 3 * ds - 2, 1 * ds + 2 - 2);
                    } else {
                        g.setColor(new Color(200, 200, 200));
                    }
                    g.drawString("dig", 5 * d / 2 + 2, frh + ds);
                    g.setColor(new Color(150, 150, 150));
                    g.fillRect(5 * d / 2 + 3 * ds, frh, 3 * ds, 1 * ds + 2);
                    if (engswitch == 1) {
                        g.setColor(new Color(0, 0, 0));
                        g.drawRect(5 * d / 2 + 3 * ds + 1, frh + 1, 3 * ds - 2, 1 * ds + 2 - 2);
                    } else {
                        g.setColor(new Color(200, 200, 200));
                    }
                    g.drawString("build", 5 * d / 2 + 3 * ds + 2, frh + ds);

                    if (engswitch>0){ //building eng start
                        int hqcount=hqnump1;
                        int bdcount=buildcountpl1;
                        int buildshootcount =buildshootcountpl1;
                        if (iampl2>0){hqcount=hqnump2; bdcount=buildcountpl2; buildshootcount =buildshootcountpl2;}
                        int nm = 1003; //hq
                        if (hqcount<2&&bdcount<buildnum/2&&mon >= getprice(nm) && arr[26] == 0) {//
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(d + 2, st, d, d);
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(d + 2+d/10, st+d/10, 8*d/10, 8*d/10);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("HQ", d + 2, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", d + 2, ys);

                        nm = 1001;
                        ys = ys + 5; //mine
                        if (bdcount <buildnum/2&&mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(d + 2, ys, d, d);
                        yscr=ys;
                        g.setColor(new Color(255, 255, 255));
                        Polygon p3 = new Polygon(); //counter-clock
                        p3.addPoint( d-3*d/10+  xsr,  yscr+4*d/10);
                        p3.addPoint( d-5*d/10+  xsr,  yscr+4*d/10);
                        p3.addPoint( d/10 + xsr, d-d/10  + yscr);
                        p3.addPoint( d*3/10 + xsr, d-d/10  + yscr);
                        g.fillPolygon(p3);
                        Polygon p4 = new Polygon(); //counter-clock
                        p4.addPoint( 5*d/10+  xsr,  yscr+2*d/10);
                        p4.addPoint( 3*d/10+  xsr,  yscr+3*d/10);
                        p4.addPoint( d-d/5 + xsr, d/2+d/10  + yscr);
                        p4.addPoint( d-d/5 + xsr, d/2-d/10  + yscr);
                        g.fillPolygon(p4);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("mine", d + 2, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", d + 2, ys);

                        nm = 1005;
                        ys = ys + 5; //b air def
                        if (buildshootcount  <shootingbuildforone&& bdcount <buildnum/2&&mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(d + 2, ys, d, d);
                        xsr = d + 2;
                        yscr = ys;
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(d + 2+d/10, ys+d/10, 8*d/10, 8*d/10);
                        g.setColor(new Color(255, 255, 255));
                        g.fillRect(d + 2 + 6*d / 20, ys + 6*d / 20, 8 * d / 20, 8 * d / 20);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("b.air d", d + 2, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", d + 2, ys);

                        nm = 1006;
                        ys = ys + 5; //b mortar
                        if (buildshootcount  <shootingbuildforone&&bdcount <buildnum/2&&mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(d + 2, ys, d, d);
                        xsr = d + 2;
                        yscr = ys;
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(d + 2+d/10, ys+d/10, 8*d/10, 8*d/10);
                        g.setColor(new Color(255, 255, 255));
                        xd = 9 * d / 20;
                        yd = 9 * d / 20;
                        g.fillOval(xsr + xd, yscr + yd, 3 * d / 20, 3 * d / 20);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("b.mort", d + 2, ys - 3);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", d + 2, ys - 3);

                        nm = 1007;
                        ys = st; //b gun
                        if (buildshootcount  <shootingbuildforone&&bdcount <buildnum/2&& mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        xsr = 2 * d + 2;
                        yscr = ys;
                        g.fillRect(xsr, ys, d, d);
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(3*d / 20 + xsr, ys+d/10, 8*d/10, 8*d/10);
                        g.setColor(new Color(255, 255, 255));
                        g.fillRect(d / 4 + xsr, ys + 9 * d / 20, 3 * d / 5, d / 10);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("b.gun", 2 * d + 4, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", 2 * d + 4, ys);

                        nm = 1008;
                        ys = ys + 5; //barracks
                        if (bdcount <buildnum/2&& mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(2 * d + 4, ys, d, d);
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(2 * d + 4+d/10, ys+d/10, 8*d/10, 8*d/10);
                        xsr = 2 * d + 4;
                        yscr = ys;
                        g.setColor(new Color(255, 255, 255));
                        Polygon pb3 = new Polygon();
                        pb3.addPoint( d/10+5+  xsr,  d/10+5+ yscr);
                        pb3.addPoint( 6*d/10+  xsr,  6*d/10+ yscr);
                        pb3.addPoint( 6*d/10 + xsr, 4*d/10  + yscr);
                        g.fillPolygon(pb3);
                        Polygon pb = new Polygon();
                        pb.addPoint( 7*d/10+  xsr,  3*d/10+ yscr);
                        pb.addPoint( 3*d/10+  xsr,  7*d/10+ yscr);
                        pb.addPoint( 5*d/10+  xsr,  7*d/10+ yscr);
                        pb.addPoint( 9*d/10+  xsr,  3*d/10+ yscr);
                        g.fillPolygon(pb);
                        Polygon p5 = new Polygon();
                        //  g.setColor(new Color(255, 0, 0));
                        p5.addPoint( 8*d/10+  xsr,  8*d/10+ yscr);
                        p5.addPoint( 9*d/10+  xsr,  7*d/10+ yscr);
                        p5.addPoint( 6*d/10+  xsr,  4*d/10+ yscr);
                        p5.addPoint( 6*d/10+  xsr,  6*d/10+ yscr);
                        g.fillPolygon(p5);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("barra", 2 * d + 4, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", 2 * d + 4, ys);

                        nm = 4001;
                        ys = ys + 5; //medic
                        if (mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(2 * d + 4, ys, d, d);
                        xsr = 2 * d + 4;
                        yscr = ys; xd=xsr; yd = yscr;
                        g.setColor(new Color(255, 0, 0));
                        g.fillRect(xd+d/10,yd+d*9/20-2,d*4/5,d/5);
                        g.fillRect(xd+d*9/20-2,yd+d/10,d/5,d*4/5);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("medic", 2 * d + 4, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", 2 * d + 4, ys);

                        nm = 1011;
                        ys = ys + 5; //dynamite
                        if (mon >= getprice(nm) && arr[26] == 0) {
                            g.setColor(new Color(0, 150, 0));
                        } else {
                            g.setColor(new Color(150, 150, 150));
                        }
                        g.fillRect(2 * d + 4, ys, d, d);
                        xsr = 2 * d + 4;
                        yscr = ys; xd=xsr; yd = yscr;
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(xsr + 9*d / 20, yscr + d / 10,  1*d / 10, 7 * d / 10);
                        g.fillRect(xsr + 6*d / 20, yscr + d / 10,  4*d / 10, 1 * d / 10);
                        g.fillRect(xsr + 6*d / 20, yscr + 4*d / 10,  4*d / 10, 4 * d / 10);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("dynam", 2 * d + 4, ys);
                        ys = ys + ds;
                        g.drawString(getprice(nm) + "", 2 * d + 4, ys);
                    }//build eng end
                    else{//dig eng start
                        g.setColor(new Color(0, 0, 255));
                        g.fillRect(d + 2, st, d, d);
                        g.setColor(new Color(200, 200, 255));
                        g.fillRect(d + 2+d/10, st+d/10, 8*d/10, 8*d/10);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("1 void", d + 2, ys);

                        ys = (int) (ys + 4*ds/3 );
                        g.setColor(new Color(200, 200, 255));
                        g.fillRect(d + 2, ys, d, d);
                        g.setColor(new Color(0, 0, 255));
                        g.fillRect(d + 2+d/10, ys+d/10, 8*d/10, 8*d/10);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("1 rock", d + 2, ys);

                        ys = (int) (ys + 4*ds/3 );
                        g.setColor(new Color(200, 200, 255));
                        g.fillRect(d + 2, ys, d, d);
                        g.setColor(new Color(0, 0, 255));
                        g.fillRect(d + 2+d/10, ys+d/10, 8*d/10, 3*d/10);
                        g.fillRect(d + 2+d/10, ys+4*d/10, 3*d/10, 3*d/10);
                        g.fillRect(d +2 +6*d/10, ys+4*d/10, 3*d/10, 3*d/10);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("tunn", d + 2, ys);

                        ys = (int) (ys + 7*ds/5  ); //6 dig down
                        g.setColor(new Color(0, 0, 255));
                        g.fillRect(d + 2, ys, d, d);
                        g.setColor(new Color(200, 200, 255));
                        Polygon p5 = new Polygon();
                        g.fillRect(d + 2+d/4, ys, d/2, d/2);
                        p5.addPoint( 10*d/10+d,  5*d/10+ ys);
                        p5.addPoint( 0*d/10+d,  5*d/10+ ys);
                        p5.addPoint( 5*d/10+d,  10*d/10+ ys);
                        g.fillPolygon(p5);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + d + ds - 5);
                        g.drawString("down", d + 2, ys);

                        g.setColor(new Color(200, 200, 255));//7 d-l turn en
                        g.fillRect(2*d + 4, st, d, d);
                        g.setColor(new Color(0, 0, 255));
                        g.setFont(new Font("Arial", Font.BOLD, 18));
                        g.drawString("^", 2*d + 2*ds, st+2*ds);
                        g.drawString("|", 2*d + 2*ds+3, st+2*ds+3);
                        g.drawString("<-", 2*d + ds, st+3*ds);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        g.drawString("e<>n", 2*d + 4, st+d+ds-5);

                        ys =st+d+ds;
                        ys = (int) (ys + 4*ds/3 -5 );
                        g.setColor(new Color(200, 200, 255));//8 turn ru se
                        g.fillRect(2*d + 4, ys, d, d);
                        g.setColor(new Color(0, 0, 255));
                        g.setFont(new Font("Arial", Font.BOLD, 18));
                        g.drawString("^", 2*d + 1*ds, ys+2*ds);
                        g.drawString("|", 2*d + 1*ds+3, ys+2*ds+3);
                        g.drawString("->", 2*d + 2*ds, ys+3*ds);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        g.drawString("s<>e", 2*d + 4, ys+d+ds-5);

                        ys = (int) (ys + 5*ds/3 +d +5);
                        g.setColor(new Color(200, 200, 255));//9 turn ur ne
                        g.fillRect(2*d + 4, ys, d, d);
                        g.setColor(new Color(0, 0, 255));
                        g.setFont(new Font("Arial", Font.BOLD, 18));
                        g.drawString("->", 2*d + 2*ds, ys+1*ds);
                        g.drawString("|", 2*d + 1*ds+3, ys+2*ds+3);
                        g.drawString("v", 2*d + 1*ds, ys+3*ds);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        g.drawString("n<>e", 2*d + 4, ys+d+ds-5);

                        ys = (int) (ys + 5*ds/3 +d +5);
                        g.setColor(new Color(200, 200, 255));//10 turn es
                        g.fillRect(2*d + 4, ys, d, d);
                        g.setColor(new Color(0, 0, 255));
                        g.setFont(new Font("Arial", Font.BOLD, 18));
                        g.drawString("<-", 2*d + 1*ds, ys+1*ds);
                        g.drawString("|", 2*d + 2*ds+3, ys+2*ds+3);
                        g.drawString("v", 2*d + 2*ds, ys+3*ds);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        g.drawString("e<>s", 2*d + 4, ys+d+ds-5);

                        ys = (int) (st  ); //11 dig up
                        g.setColor(new Color(0, 0, 255));
                        g.fillRect(3*d + 6, ys, d, d);
                        g.setColor(new Color(200, 200, 255));
                        Polygon p6 = new Polygon();
                        g.fillRect(3*d +d/4+6, ys+d/2, d/2, d/2);
                        p6.addPoint( 10*d/10+3*d+6,  5*d/10+ ys);
                        p6.addPoint( 0*d/10+3*d+6,  5*d/10+ ys);
                        p6.addPoint( 5*d/10+3*d+6,  0*d/10+ ys);
                        g.fillPolygon(p6);
                        g.setFont(new Font("Arial", Font.BOLD, 14));
                        g.setColor(new Color(0, 0, 0));
                        ys = (int) (ys + 1*d + ds - 5);
                        g.drawString("up", 3*d + 6, ys);

                    }//dig eng end
                }//eng end

            }//count single end

            if (descr==666){selectionone="";}//not a single selection
            else {selectionone= getname(descr);}

            int frh = (int)(d*2.1)-2; //frame for single one
            int fh = (int)(8.59*d-7*ds)-5;
            g.setColor(new Color(175, 65, 175));
            // g.setColor(new Color(150, 150, 150));
            ys = frh+ds+3;
            g.drawLine(d,ys,7*d,ys);
            ys=(int) (ys+d*1.5625);  g.drawLine(d,ys,7*d,ys);
            ys=(int) (ys+d*1.5625);  g.drawLine(d,ys,7*d,ys);
            ys=(int) (ys+d*1.5625);  g.drawLine(d,ys,7*d,ys);
            ys = frh+ds+3; int dm = 2*d+2;
            g.drawLine(dm,frh+ds+3,dm,fh+frh);
            dm=dm+d+2;    g.drawLine(dm,frh+ds+3,dm,fh+frh);
            g.setColor(new Color(175, 65, 175));
            g.drawRect(d, frh, 7*d,fh);
            if (arr[29]!=0&&arr[14]==3||arr[29]!=0&&arr[14]==2003){//eng has chosen smth bld
                Color c = new Color(1f, 1f, 0f, .3f);
                g.setColor(c);
                g.fillRect(d, frh, 7*d,fh);}
            if (iampl2>0&&actdigtype!=-1&&arr[14]==2003){//eng has chosen smth bld
                Color c = new Color(1f, 1f, 0f, .3f);
                g.setColor(c);
                g.fillRect(d, frh, 7*d,fh);}
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.setColor(new Color(175, 65, 175));
            //   ys=(int)(d*2.875);
            if (arr[14]==4||arr[14]==2004||arr[14]==5||arr[14]==2005||arr[14]==6||arr[14]==2006||arr[14]==7||arr[14]==2007
                    ||arr[14]==8||arr[14]==8||arr[14]==9||arr[14]==2009
                    ||arr[14]==1005||arr[14]==3005||arr[14]==1006||arr[14]==3006||arr[14]==1007||arr[14]==3007){
                if (arr[25]==0){
                    if (arr[14]==4||arr[14]==2004||arr[14]==9||arr[14]==2009)
                    { bonus=bonus+" g";} else{bonus=bonus+" f";}
                }else{
                    if (arr[17]==0){bonus=bonus+" f";}else{bonus=bonus+" h";}
                }
            }
            if (descr==666){bonus="";}
            g.drawString(selectionone+" "+bonus, d+5, frh+ds); //single selection descr
            ys= (int)(8.59*d+ds);

            mapposx=d-2;  mapposy = ys+2;//minimap 200*200 pixels by default in 1024*768. 150*150 800*600
 /*

            int w = widthpix; w=(w/4)-d;
          if  (maplength>mapwidth){mapdot = (int)( w/maplength)+1;}else
          {mapdot = (int) (w/(mapwidth))+1;}
          if (maplength>blocksmumwidth&&mapwidth>blocksmumwidth){
            mapposx=mapposx-mapdot;       mapposy=mapposy-mapdot;}

 */
            g.setColor(new Color(0, 0, 0));
            if (iampl2>0){   g.setColor(new Color(140, 140, 140));}

            g.fillRect(mapposx, mapposy, maplength*mapdot,mapwidth*mapdot); //maplength ns. mapwidth es
            int xu=-1; int yu=-1;
            for (int i = 0; i < unitlist.size(); i++) {
                arr = (int[]) unitlist.get(i);


                if (arr[14]<1000&&iampl2==0){//if pl1
                    yu = arr[2];   xu=arr[3];

                    if (arr[21]>0){  g.setColor(new Color(255, 255, 0));}else{ //is firing
                        if (arr[22]>0){  g.setColor(new Color(255, 0, 0));}//under fire
                        else{ g.setColor(new Color(175, 65, 175));}    }

                    g.fillRect(mapposx+xu*mapdot, mapposy+yu*mapdot, mapdot,mapdot);
                }

                if (arr[14]>2000&&arr[14]<3000&&iampl2==1){//if pl2
                    yu = arr[2];   xu=arr[3];

                    if (arr[21]>0){  g.setColor(new Color(255, 255, 0));}else{ //is firing
                        if (arr[22]>0){  g.setColor(new Color(255, 0, 0));}//under fire
                        else{ g.setColor(new Color(0, 0, 0));}    }

                    g.fillRect(mapposx+xu*mapdot, mapposy+yu*mapdot, mapdot,mapdot);
                }
            }

            for (int i = 0; i < reslist.size(); i++) {
                arr = (int[]) reslist.get(i);
                yu = arr[0];   xu=arr[1];
                g.setColor(new Color(0, 255, 0));
                g.fillRect(mapposx+xu*mapdot, mapposy+yu*mapdot, mapdot,mapdot);
            }

            for (int i = 0; i < buildlist.size(); i++) {
                arr = (int[]) buildlist.get(i);
                if (arr[14]==1003){//if pl1 HQ
                    yu = arr[2];   xu=arr[3];
                    g.setColor(new Color(255, 255, 255));
                    if (iampl2>0){   g.setColor(new Color(0, 0, 255));}
                    g.fillRect(mapposx+xu*mapdot, mapposy+yu*mapdot, mapdot,mapdot);
                }
                if (arr[14]==3003){//if pl2 HQ
                    yu = arr[2];   xu=arr[3];
                    g.setColor(new Color(0, 0, 255));
                    if (iampl2>0){  g.setColor(new Color(255, 255, 255));}
                    g.fillRect(mapposx+xu*mapdot, mapposy+yu*mapdot, mapdot,mapdot);
                }
            }

  g.setColor(new Color(0, 0, 255));//scr on minimap
 if (specialview==0){
  g.drawRect(mapposx+ewpos*mapdot, mapposy+nspos*mapdot, mapdot*blocksmumwidth,mapdot*blocksmumwidth);}
  if (specialview==2){
  g.drawRect(mapposx+ewpos*mapdot, mapposy+nspos*mapdot, mapdot*blocksmumwidth,mapdot);}
 if (specialview==1){
  g.drawRect(mapposx+ewpos*mapdot, mapposy+nspos*mapdot, mapdot,mapdot*blocksmumwidth);}
 if (specialview==3){
                int ns = nspos; if (ns<0) {ns=0;} if (ns>mapwidth-blocksmumwidth){ns=mapwidth-blocksmumwidth;}
                int ew = ewpos; if (ew<0) {ew=0;} if (ew>maplength-blocksmumwidth){ew=maplength-blocksmumwidth;}

     if (roll==0)  {
         Polygon p = new Polygon();
         p.addPoint(mapposx+ew*mapdot+2, mapposy+ns*mapdot);
         p.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot);
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2+2, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         g.fillPolygon(p);
         Polygon p2 = new Polygon();
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth+2, mapposy+ns*mapdot);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2+2, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         g.fillPolygon(p2);
     }
            if (roll==315)  {
   g.fillRect(mapposx+ew*mapdot, mapposy+ns*mapdot,2, mapdot*blocksmumwidth);
  g.fillRect(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth,mapdot*blocksmumwidth, 2);
            }

     if (roll==270)  {
         Polygon p = new Polygon();
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth+2);
         p.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth/2+2);
         p.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth/2);
         g.fillPolygon(p);
         Polygon p2 = new Polygon();
         p2.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth/2+2);
         p2.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth/2);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+2);
         g.fillPolygon(p2);
     }

     if (roll==225)  {
         g.fillRect(mapposx+ew*mapdot, mapposy+ns*mapdot,2, mapdot*blocksmumwidth);
         g.fillRect(mapposx+ew*mapdot, mapposy+ns*mapdot,mapdot*blocksmumwidth, 2);
     }

     if (roll==180)  {
         Polygon p = new Polygon();
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2+2, mapposy+ns*mapdot);
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2, mapposy+ns*mapdot);
         p.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         p.addPoint(mapposx+ew*mapdot+2, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         g.fillPolygon(p);
         Polygon p2 = new Polygon();
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2+2, mapposy+ns*mapdot);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth/2, mapposy+ns*mapdot);
         p2.addPoint(mapposx+ew*mapdot +mapdot*blocksmumwidth-2, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth);
         g.fillPolygon(p2);
     }

     if (roll==135)  {
         g.fillRect(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot,2, mapdot*blocksmumwidth);
         g.fillRect(mapposx+ew*mapdot, mapposy+ns*mapdot,mapdot*blocksmumwidth, 2);
     }

     if (roll==90)  {
         Polygon p = new Polygon();
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth/2);
         p.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth/2-2);
         p.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot);
         p.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot+2);
         g.fillPolygon(p);
         Polygon p2 = new Polygon();
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth/2);
         p2.addPoint(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot+mapdot*blocksmumwidth/2-2);
         p2.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot +mapdot*blocksmumwidth-2);
         p2.addPoint(mapposx+ew*mapdot, mapposy+ns*mapdot +mapdot*blocksmumwidth);
         g.fillPolygon(p2);
     }

     if (roll==45)  {
         g.fillRect(mapposx+ew*mapdot+mapdot*blocksmumwidth, mapposy+ns*mapdot,2, mapdot*blocksmumwidth);
         g.fillRect(mapposx+ew*mapdot, mapposy+ns*mapdot+mapdot*blocksmumwidth-2,mapdot*blocksmumwidth, 2);
     }
 }//specialview3 end

            ys= (int)(8.59*d-5);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.setColor(new Color(240, 240, 240));
            g.fillRect(d+2, ys+5, d,ds-5);
            g.setColor(new Color(34, 177, 76));
            g.drawString(   "$: "+mon, d+3, ys+ds); //upper minimap $
            g2d.dispose();
        }
    }

    Sol() {
        jFrame = new JFrame("Creative Strategy Java7 by OlegTim");
        jFrame.setFocusTraversalKeysEnabled(false);
        //     jFrame.setLayout(null);
        jFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;


        pane =      new TestPane();
        c.weightx = 0.75;
        c.weighty = 1;
        jFrame.add(pane, c);

        pane2= new TestPane2();
        c.weightx = 0.25;
        c.weighty = 1;
        jFrame.add(pane2,c);


        jFrame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
                    pause = 1; System.exit(0);
                    // menugo();
                }

                if (specialview!=3) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        ewpos--;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        ewpos++;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        nspos--;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        //   JOptionPane.showMessageDialog(null, "d", "w", JOptionPane.PLAIN_MESSAGE);
                        nspos++;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_TAB) {
                        zpos++;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
                        zpos--;
                        transparentview = 0;
                        specialview = 0;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
                        zpos++;
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
                        zpos--;
                        transparentview = 0;
                        specialview = 0;
                        fmove();
                    }
                }
//
                if (specialview==3) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        leftisom();
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        rightisom();
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                      upisom();
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                      downisom();
                        fmove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_TAB) {
  roll+=45; if  (roll>359){roll=0;} redrawmenu();
                        nspossiom =0.0;
                        ewpossiom =0.0;
                        isomviewmet();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
roll-=45; if  (roll<-1){roll=315;} redrawmenu();
                        nspossiom =0.0;
                        ewpossiom =0.0;
                        isomviewmet();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
                        roll+=45; if  (roll>359){roll=0;} redrawmenu();
                        nspossiom =0.0;
                        ewpossiom =0.0;
                        isomviewmet();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
                        roll-=45; if  (roll<-1){roll=315;} redrawmenu();
                        nspossiom =0.0;
                        ewpossiom =0.0;
                        isomviewmet();
                    }
                }

                if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                    zpos=mapheight;
                    cleanviewmet();
                    fmove();
                }

                if (e.getKeyCode()==KeyEvent.VK_INSERT) {
                    specialview=0;
                    zpos=mapheight;
                    if (transparentview>0){transparentview=0;}else{transparentview=1;}
                    fmove();
                }

                if (e.getKeyCode()==KeyEvent.VK_SPACE) {
                    transparentview=0;
                    specialview=0;
                    zpos = 0;    fmove();}

                if (specialview==0){
                    if (e.getKeyCode()==KeyEvent.VK_0) {
                        zpos = 0;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_1) {
                        zpos = 1;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_2) {
                        zpos = 2;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_3) {
                        zpos = 3;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_4) {
                        zpos = 4;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_5) {
                        zpos = 5;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_6) {
                        zpos = 6;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_7) {
                        zpos = 7;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_8) {
                        zpos = 8;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_9) {
                        zpos = 9;    fmove();}
                    if (e.getKeyCode()==KeyEvent.VK_MINUS) {
                        zpos = mapheight-2;    fmove();
                    }
                    if (e.getKeyCode()==KeyEvent.VK_EQUALS) {
                        zpos = mapheight-1;    fmove();
                    }
                }

                if (e.getKeyCode()==KeyEvent.VK_P&&mapdev==1) {
                    if (phflag>0){phflag=0;}else{phflag=1;}
                    redrawmainfield();
                }

                if (e.getKeyCode()==KeyEvent.VK_O) {
                    if (drawborders>0){drawborders=0;}else{drawborders=1;}
                    addp1();
                }

                if (e.getKeyCode()==KeyEvent.VK_F1&&mapdev==1) {
                    brush = 998000;
                    redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_F2&&mapdev==1) {
                    brush = 999000;
                    redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_F3&&mapdev==1) {
                    brush = 3;
                    redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_F4&&mapdev==1) {
                    brush = 4;
                    redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_F5&&mapdev==1) {
                    brush = 0;
                    redrawmenu();
                }

                if (e.getKeyCode()==KeyEvent.VK_F6&&mapdev==1) {
                    fillall();
                }

                if (e.getKeyCode()==KeyEvent.VK_F7&&mapdev==1) {
                    if (brsz==1&&brsx==1&&brsy==1){
                        brsz=brsz2;brsy=brsy2;brsx=brsx2;
                        redrawmenu();
                    }
                    else{
                        makebrush1();
                    }

                }
                if (e.getKeyCode()==KeyEvent.VK_F8&&mapdev==1) {
                    crbrsizemet();
                }

                if (e.getKeyCode()==KeyEvent.VK_F9&&mapdev==1) {
                    crmet();
                }
                if (e.getKeyCode()==KeyEvent.VK_F10&&mp==0) {
                    filep = "./map.txt";
                    loadm();
                }
                if (e.getKeyCode()==KeyEvent.VK_F11) {
                    menugo();
                }
                if (e.getKeyCode()==KeyEvent.VK_F12) {
                    filep = "./map.txt";
                    savem();
                }
                if (e.getKeyCode()==KeyEvent.VK_Z&&mapdev==1) {
                    undo();
                }
                if (e.getKeyCode()==KeyEvent.VK_X) {//select brush
                    brush = -1;
                    redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_C) {
                    Unit unit = new Unit();
                    unit.zeroselect();
                    addp1();
                }

                if (e.getKeyCode()==KeyEvent.VK_V) {//
                    testout();
                }
                if (e.getKeyCode()==KeyEvent.VK_S) {
                    Unit unit = new Unit();
                    unit.unitstop();
                }
                if (e.getKeyCode()==KeyEvent.VK_B) {//
                    if (mp==0) {
                        timerstep();}
                }

                if (e.getKeyCode()==KeyEvent.VK_N) {//test timer switch
                    if (mp==0) {
                        if (timeron > 0) {
                            timeron = 0;
                            redrawmenu();
                            //    JOptionPane.showMessageDialog(null, "timeron: "+timeron, "t", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            //   JOptionPane.showMessageDialog(null, "timeron: "+timeron, "t", JOptionPane.PLAIN_MESSAGE);
                            timeron = 1;
                            timergo();
                            redrawmenu();
                        }
                    }
                }
                if (e.getKeyCode()==KeyEvent.VK_A) {//
                    Unit unit = new Unit();
                    unit.unitselectall();
                }
                if (e.getKeyCode()==KeyEvent.VK_DELETE) {
                    deleteselectedunits();
                }
                if (e.getKeyCode()==KeyEvent.VK_G) {
                    groundattack();  redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_H) {
                    holdfire();  redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_F) {
                    fireatwiil();  redrawmenu();
                }
                if (e.getKeyCode()==KeyEvent.VK_D) {
                    Sol.actdigtype=-1; Sol.actdigdir=-1;
                    if (engswitch==0){engswitch=1;}else{engswitch=0;}
                    redrawmenu();
                }

                if (e.getKeyCode()==KeyEvent.VK_Q) {
                    transparentview=0;
                    if (specialview==2){specialview=1;}else{specialview=2;}
                    zpos=mapheight;
                    fmove();
                    redrawmenu();
                }

                if (e.getKeyCode()==KeyEvent.VK_W) {
                    if (isomShowBlocksOnly==0){isomShowBlocksOnly=1;}else{isomShowBlocksOnly=0;}
                    transparentview=0;
                    calcisomposmet();
                    specialview=3;
                    zpos=mapheight;

                    nspossiom =0.0;
                    ewpossiom =0.0;
                    isomviewmet();
                }

                if (e.getKeyCode()==KeyEvent.VK_SHIFT) {
                    selectdyn();
                }

                if (e.getKeyCode()==KeyEvent.VK_CONTROL) {
                    detonate();
                }

            }});//key pressed end

        jFrame.addMouseMotionListener(this);
        jFrame.addMouseWheelListener(this);
        jFrame.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) {
                int dx = me.getX();
                xclick = dx;
                int dy = me.getY();
                yclick = dy;
            }
            public void mouseReleased(MouseEvent me) {
                int dx = me.getX();
                xrel=dx;
                int dy = me.getY();
                yrel = dy;

                if (transparentview < 1&& specialview ==0) {
                    if (me.getButton() == MouseEvent.BUTTON1) {
                        mb = 1;
                        PointerInfo a = MouseInfo.getPointerInfo();
                        Point b = a.getLocation();
                        int x = (int) b.getX();
                        int y = (int) b.getY();
                        xabs = x;
                        yabs = y;
                        mclick();
                    }
                    if (me.getButton() == MouseEvent.BUTTON3) {
                        mb = 3;
                        PointerInfo a = MouseInfo.getPointerInfo();
                        Point b = a.getLocation();
                        int x = (int) b.getX();
                        int y = (int) b.getY();
                        xabs = x;
                        yabs = y;
                        mclick();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "press <Backspace> to quit special view",
                            "w", JOptionPane.PLAIN_MESSAGE);
                }
            }
            public void mouseEntered(MouseEvent me) { }
            public void mouseExited(MouseEvent me) { }
            public void mouseClicked(MouseEvent me) {
            }
        });

        if (fscr>0){

            jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jFrame.setUndecorated(true);}
        else{
            jFrame.setSize(xres, yres);
        }
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);


    }


    public static void main(String[] args) {maingo();}

    public static void fmove(){
 //       System.out.println("isom: "+nspossiom +" "+ewpossiom+"  top: "+nspos+" "+ewpos );

        if (zpos!=mapheight){transparentview=0;}

        if (specialview==0) {
            if (zpos < 0) {
                zpos = 0;
            }
            if (zpos > mapheight) {
                zpos = mapheight;
            }
        }else{zpos = mapheight;}

        if (specialview!=3&&  ewpos<0)
            ewpos=0;
        if (specialview==0||specialview==2){
            if (ewpos>maplength-blocksmumwidth)
                ewpos=maplength-blocksmumwidth;}
        if (specialview==1){
            if (ewpos>maplength-1)
                ewpos=maplength-1;}
        if (specialview!=3&&nspos<0)
            nspos=0;
        if (specialview==0||specialview==1){
            if (nspos>mapwidth-blocksmumwidth)
                nspos=mapwidth-blocksmumwidth;}
        if (specialview==2){
            if (nspos>mapwidth-1)
                nspos=mapwidth-1;}

        if (specialview==3){
            int ml = maplength; int mw = mapwidth;//change map width/length
          //  if (roll==270||roll==225||roll==90||roll==45)
      //      {ml=mapwidth; mw=maplength;}
            if (ewpos>ml-blocksmumwidth/2){ewpos=ml-blocksmumwidth/2;}
            if (ewpos<-blocksmumwidth/2){ewpos=-blocksmumwidth/2;}
            if (nspos>mw-blocksmumwidth/2){nspos=mw-blocksmumwidth/2;}
            if (nspos<-blocksmumwidth/2){nspos=-blocksmumwidth/2;}
        }

        addp1();
        //  Unit unit = new Unit();
        //  unit.checkunitcount();
        pane.drawf();
    }
    public static void redrawmainfield(){
        if (phflag==0){addp1();}
        if (phflag==1){phcal();}
    }

    public static void redrawmenu(){
        pane2.drawf2();
        jFrame.revalidate();
        addp1flag =0;
    }
    public static void addp1(){
        if (addp1flag==0) {
            // System.out.println("addp1 really go");
            addp1flag=1;
            askaddp1=0;
            xd = 0;
            yd = 0;
            try{
                for (int i0 = 0; i0 < mapheight; i0++){
                    for (int j0 = 0; j0 < blocksmumwidth; j0++){
                        for (int k0 = 0; k0 < blocksmumwidth; k0++) {
                            map[i0][j0][k0] =map2[i0][j0+nspos][k0+ewpos];
                        }}}
            } catch (Exception e) {}
            pane.drawf();
            redrawmenu();
        }
        else{askaddp1++;
            //  System.out.println("addp1 asked to go"+askaddp1);
        }
    }


    public static void colormet(){
        int z = globalz;

        if (z==9){
            col1=129;col2=0;col3=0;
        }
        if (z==8){
            col1=247;col2=15;col3=15;
        }
        if (z==7){
            col1=255;col2=157;col3=0;
        }
        if (z==6){
            col1=255;col2=245;col3=0;
        }
        if (z==5){
            col1=84;col2=255;col3=0;
        }
        if (z==4){
            col1=123;col2=144;col3=0;
        }
        if (z==3){
            col1=105;col2=185;col3=159;
        }
        if (z==2){
            col1=42;col2=247;col3=245;
        }
        if (z==1){
            col1=0;col2=151;col3=255;
        }
    }
    public static void phcalcomp(){
        int compare=0;
        for (int i = 0; i < mapheight; i++)
            for (int j = 0; j < mapwidth; j++)
                for (int k = 0; k < maplength; k++) {
                    if (map3[i][j][k] != map2[i][j][k]){
                        compare++; break;
                    }
                }
        if (compare!=0){
            phcal();
        }
        else{
            Unit unit = new Unit();
            unit.checkunitcount();
            addp1();
            pane.drawf();}
    }

    public static void phcal(){//phcal start
        Cal cal = new Cal();
        cal.calc();
    }//phcal end

    public static   void   mclick(){
        if (xabs<blocksmumwidth*d) {
            if (mp==0){
                for (int i = 0; i < mapheight; i++)
                    for (int j = 0; j < mapwidth; j++)
                        for (int k = 0; k < maplength; k++) {
                            map4[i][j][k] = map2[i][j][k];}
            }

            int x = (int)xabs/d;
            int y = (int)yabs/d;
            int z=-1;
            try         {    z = hmapf[y][x];} catch (Exception e){}
            x=x+ewpos; y=y+nspos;

            mouseblock[0]=z;   mouseblock[1]=y;   mouseblock[2]=x;
            mb_block_menu_z =z; mb_block_menu_y = y; mb_block_menu_x = x;
            if (mb==1){
                grselectfag=0;
                for (int i = 0; i <unitlist.size(); i++){
                    int arr [];
                    arr = (int[]) unitlist.get(i);
                    if (arr[29]!=0){arr[29]=0; unitlist.set(i,arr);}
                }
                Unit unit = new Unit();
                unit.checkunitcount();
                lmclick();}
            if (mb==3){rmclick();}
            mb=0;
        }
        else{
            menuclick();
        }
    }// click end

    public static   void   menuclick(){

        int h = hegihtpix ;
        int w = widthpix ;
        w = d+(int)(3*w/4);

        int  ds = (int) (d/3.4);
        if (fscr==0){yrel=yrel-15;}//if window mode

// JOptionPane.showMessageDialog(null, yrel+" "+h+"_"+w, "w", JOptionPane.PLAIN_MESSAGE);
        if (yrel>mapposy&&xrel>w-mapdot){mapgo();}
        if (yrel<(int) (ds*2)&&xrel>w){menugo();}
        //   redrawmenu();

        if (singleselect!=666&&xrel>w&&yrel<mapposy-d/3.4&&yrel>st-d/3.4){//inter menu start
            int arr [];
            int sel = singleselect;
            if (singleselect>=0){
                arr = (int[]) unitlist.get(sel);
            }
            else{
                if (singleselect==-777){sel=0;}else{sel=-sel;}
                arr = (int[]) buildlist.get(sel);
            }

            int xm=w;
            int nm=-1;
//first column
            if (xrel<xm+d&&yrel<st+d&&yrel>st){//if clicked on eng icon and bl if not building now
                nm=3;
            }// eng end
            if (xrel<xm+d&&yrel<st+d+1.5625*d&&yrel>st+1.5625*d){nm=4;}//zepp
            if (xrel<xm+d&&yrel<st+d+1.5625*d*2&&yrel>st+1.5625*d*2){nm=5;}//air def
            if (xrel<xm+d&&yrel<st+d+1.5625*d*3&&yrel>st+1.5625*d*3){nm=6;}//mortar
//second column
            if (xrel>xm+d&&xrel<xm+2*d+2&&yrel<st+d&&yrel>st){nm=7;}//car gun
            if (xrel>xm+d&&xrel<xm+2*d+2&&yrel<st+d+1.5625*d&&yrel>st+1.5625*d){nm=8;}//tank
            if (xrel>xm+d&&xrel<xm+2*d+2&&yrel<st+d+1.5625*d*2&&yrel>st+1.5625*d*2){nm=9;}//how
            if (xrel>xm+d&&xrel<xm+2*d+2&&yrel<st+d+1.5625*d*3&&yrel>st+1.5625*d*3){nm=10;}//smth 10
//third column
            if (xrel>xm+2*d+2&&xrel<xm+3*d+4&&yrel<st+d&&yrel>st){nm=11;}//smth 11
            if (xrel>xm+2*d+2&&xrel<xm+3*d+4&&yrel<st+d+1.5625*d&&yrel>st+1.5625*d){nm=12;}//smth 12
            if (xrel>xm+2*d+2&&xrel<xm+3*d+4&&yrel<st+d+1.5625*d*2&&yrel>st+1.5625*d*2){nm=13;}//smth 13
            if (xrel>xm+2*d+2&&xrel<xm+3*d+4&&yrel<st+d+1.5625*d*3&&yrel>st+1.5625*d*3){nm=14;}//smth 14

            int mon =moneypl1; if (iampl2>0){mon =moneypl2;}
            int    smtcount=unitscountpl1; if (iampl2>0){smtcount =unitscountpl2;}
            //  JOptionPane.showMessageDialog(null, nm, "w", JOptionPane.PLAIN_MESSAGE);
            if (arr[14]==1003&&arr[26]==0&&nm==3||arr[14]==3003&&arr[26]==0&&nm==3)//hq if not building now and sel is eng
            {
                if (smtcount<unitsnum/2 ){//
                    if (mon>=getprice(nm)){//
                        if (iampl2>0){moneypl2=moneypl2-getprice(nm);}else{ moneypl1=moneypl1-getprice(nm);}
                        arr[26] = getpspeedbuild(nm);
                        arr[29] = nm;
                        buildlist.set(sel, arr);
                        if (Sol.iampl2>0){Sol.action=8; Sol.actz = sel; Sol.acty = nm; Sol.actx = getprice(nm);  }
                        Unit unit = new Unit();
                        unit.checkunitcount();
                    }
                }
            }//hq for both end

            if (arr[14]==1008&&arr[26]==0||arr[14]==3008&&arr[26]==0){//barracks if not building now
                if (smtcount<unitsnum/2 ){//
                    if (mon>=getprice(nm)){//
                        if (nm>=3&&nm<=9) {//units only
                            int hdzep=1;
                            if (nm==4) {   try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky
                                if (Sol.map2[n][arr[2]][arr[3]]!=0){hdzep=0;break;}}} catch (Exception ef){}}
                            if (hdzep!=0){
                                if (iampl2>0){moneypl2=moneypl2-getprice(nm);}else{ moneypl1=moneypl1-getprice(nm);}
                                arr[26] = getpspeedbuild(nm);
                                arr[29] = nm;
                                buildlist.set(sel, arr);
                                if (Sol.iampl2>0){Sol.action=8; Sol.actz = sel; Sol.acty = nm; Sol.actx = getprice(nm);  }
                                Unit unit = new Unit();
                                unit.checkunitcount();
                            }}}
                }//pl eng in barracks end
            }//barracks for both end

            if (arr[14]==3&&arr[26]==0&&arr[11]==-1&&arr[29]==0||arr[14]==2003&&arr[26]==0&&arr[11]==-1&&arr[29]==0){//eng not building and not moving
                if (xrel>xm+5*d/2-d&&xrel<xm+5*d/2+3*ds-d&&yrel<st&&yrel>st-ds)
                {engswitch=0;
                    //   JOptionPane.showMessageDialog(null, "dig", "w", JOptionPane.PLAIN_MESSAGE);
                }//dig
                if (xrel>xm+5*d/2-d+3*ds&&yrel<st&&yrel>st-ds)
                {engswitch=1;
                    // JOptionPane.showMessageDialog(null, "build", "w", JOptionPane.PLAIN_MESSAGE);
                }//dig

                if (nm>0) {//if chosen smth in table
                    //  JOptionPane.showMessageDialog(null, "eng go", "w", JOptionPane.PLAIN_MESSAGE);
                    if (engswitch==1) {//eng build start
                        if (arr[14] == 3) {//pl1

                            switch (nm){
                                case 3: if (nm==3 &&hqnump1<2 &&buildcountpl1<buildnum/2){nm=1003;}else{nm=-1;} break;//hq<2
                                case 4: if (nm==4 &&buildcountpl1<buildnum/2){nm=1001;}else{nm=-1;}break;//mine
                                case 5: if (nm==5 &&buildcountpl1<buildnum/2 &&buildshootcountpl1<shootingbuildforone){nm=1005;} else{nm=-1;}break;//b. air def
                                case 6:if (nm==6 &&buildcountpl1<buildnum/2&&buildshootcountpl1<shootingbuildforone){nm=1006;}else{nm=-1;}break;//b. mortar
                                case 7: if (nm==7&&buildcountpl1<buildnum/2&&buildshootcountpl1<shootingbuildforone){nm=1007;}else{nm=-1;}break;//b. gun
                                case 8:if (nm==8&&buildcountpl1<buildnum/2){nm=1008;}else{nm=-1;}break;//barracks
                                case 9: if (nm==9){nm=4001;}else{nm=-1;}break;//medic gaia (neutral)
                                case 10: if (nm==10&&buildcountpl1<buildnum/2){nm=1011;}else{nm=-1;}break;//dynamite
                                default: nm=-1;break; //if not bld
                            }

                            if (nm>0&&mon >= getprice(nm)) {//
                                if (nm!=4001)       {  buildcountpl1++;}
                                if (nm==1005||nm==1006||nm==1007){buildshootcountpl1++;}
                                if (nm==1003){hqnump1++;}

                                // moneypl1=moneypl1-getprice(nm);
                                arr[29] = nm;
                                unitlist.set(sel, arr);
                                grselectfag=1;
                            }
                        }//pl1 build end
                        if (arr[14] == 2003){//pl2 build start
                            switch (nm){
                                case 3: if (nm==3 &&hqnump2<2 &&buildcountpl2<buildnum/2){nm=3003;}else{nm=-1;} break;//hq<2
                                case 4: if (nm==4 &&buildcountpl2<buildnum/2){nm=3001;}else{nm=-1;}break;//mine
                                case 5: if (nm==5 &&buildcountpl2<buildnum/2 &&buildshootcountpl2<shootingbuildforone){nm=3005;} else{nm=-1;}break;//b. air def
                                case 6:if (nm==6 &&buildcountpl2<buildnum/2&&buildshootcountpl2<shootingbuildforone){nm=3006;}else{nm=-1;}break;//b. mortar
                                case 7: if (nm==7&&buildcountpl2<buildnum/2&&buildshootcountpl2<shootingbuildforone){nm=3007;}else{nm=-1;}break;//b. gun
                                case 8:if (nm==8&&buildcountpl2<buildnum/2){nm=3008;}else{nm=-1;}break;//barracks
                                case 9: if (nm==9){nm=4001;}else{nm=-1;}break;//medic gaia (neutral)
                                case 10: if (nm==10&&buildcountpl2<buildnum/2){nm=3011;}else{nm=-1;}break;//dynamite
                                default: nm=-1;break; //if not bld
                            }

                            if (nm>0&&mon >= getprice(nm)) {//
                                if (nm!=4001)       {  buildcountpl2++;}
                                if (nm==3005||nm==3006||nm==3007){buildshootcountpl2++;}
                                if (nm==3003){hqnump2++;}

                                // moneypl2=moneypl2-getprice(nm);
                                arr[29] = nm;
                                if (iampl2>0){actdigtype=nm;}
                                unitlist.set(sel, arr);
                                grselectfag=1;
                            }
                        }//pl2 build end
                    }//eng build end

                    if (engswitch==0) {//eng dig start
                        if (arr[14] == 3||arr[14] == 2003) {//pl
                            //    JOptionPane.showMessageDialog(null, "d", "w", JOptionPane.PLAIN_MESSAGE);
                            arr[30]=nm; Sol.actdigtype = nm;
                            unitlist.set(sel, arr);
                            final JDialog modelDialog = createDialog(jFrame);
                            modelDialog.setVisible(true);
                        }//pl1 dig end
                    }//eng dig end

                }//chosen smth end
            }//eng end

            redrawmenu();
        }//inter menu end

    }

    public static   void   menugo(){
        if (bigmenuon==0){
            if (mp==0){timeron = 0;}

            //   JOptionPane.showMessageDialog(null, "menu", "w", JOptionPane.PLAIN_MESSAGE);
            bigmenuon=1;
            redrawmenu();
            final JDialog modelDialog = createDialog2(jFrame);
            modelDialog.setVisible(true);
        }}
    public static   void   mapgo(){

        int w = widthpix ;
        int h = hegihtpix;
        w = (int)(3*w/4);

        nspos=((yrel-mapposy)/mapdot)-blocksmumwidth/2;
        ewpos=((xrel-w-d)/mapdot)-blocksmumwidth/2;
        fmove();
    }

    public static    void   lmclick(){
        if (brsz>1&&brush>997999||brsy>1&&brush>997999||brsx>1&&brush>997999) {blocksmulticlickmet();}else {
            int z = mouseblock[0];
            int y = mouseblock[1];
            int x = mouseblock[2];

            if (brush > 4000) {//for blocks and gaia?
                if (z == -1 && mapheight > 2) {//if bottom zlvl empty and height>2
                    map2[0][y][x] = brush;
                }
                if (z != -1 && z < mapheight - 3) {//if bottom zlvl is NOT empty and z < top block lvl
                    if (zpos != mapheight) {//if NOT top view -> place on z level
                        map2[z][y][x] = brush;
                    } else {
                        map2[z + 1][y][x] = brush;
                    } //if  top view -> place on z+1 level
                }
                if (z != -1 && z == mapheight - 3) {//if bottom zlvl is NOT empty and z is top block lvl
                    map2[z][y][x] = brush;
                }
            }

            if (brush>2&&brush<4000){//unit create start
                Unit unit = new Unit();
                unit.go();
            }//unit create end

            if (brush==0) {
                empty1();
            }
            else {

                if (brush!=-1){//if not selection LMB - put new blocks and update field
                    if (brush==998001||brush==999001){//res generation
                        int count=0;  int arr[];
                        for (int i = 0; i <reslist.size(); i++){
                            arr = (int[]) Sol.reslist.get(i);
                            if (arr[0]==y&&arr[1]==x){count++;break;}//if res exist in this coord
                        }
                        if (count==0) {
                            int arrv[] = new int[4];
                            arrv[0]=y;    arrv[1]=x;    arrv[2]=resrich ;
                            reslist.add(arrv);
                        }}//res gen end
                    redrawmainfield();
                }
                else{
                    unitselectedmet();
                }
            }
        }}
    public static  void   rmclick(){
        if (brush!=-1&&mapdev==1){
            empty1();}
        else{
            moveselectedunits();
        }
    }

    public static  void   empty1(){
        int z = mouseblock[0];  int y = mouseblock[1];  int x = mouseblock[2];
        if (z==-1){z=0;}
        if (brsz==mapheight){z=mapheight-1;}//delete air units
        map2[z][y][x] = 0;

        if (brsz>1||brsy>1||brsx>1) {

            for (int k = z; k > z - brsz; k--) {
                for (int k2 = brsy; k2 >0; k2--) {
                    for (int k3 = brsx; k3 >0; k3--) {
                        try {
                            map2[k][y+k2-1][x+k3-1] = 0;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        redrawmainfield();
    }

    static void loadm(){
        brush=0;    fillall();
        moneypl1 =100;  moneypl2 =100;
        unitlist.clear();   buildlist.clear();  reslist.clear();      timeron=0; loading =1;
        try{
            File myFile = new File(filep);
            Scanner scan = new Scanner(myFile);
            String str=scan.nextLine();

            String[] temp = str.split(" ");
            mapname = temp [0];

            int t=12;
            try {t = Integer.parseInt(temp [1]);} catch (Exception e){}
            if (t>1&&t<13){mapheight=t;}else
            {JOptionPane.showMessageDialog(null, "error: mheight", "w", JOptionPane.PLAIN_MESSAGE);}
            try {t = Integer.parseInt(temp [2]);} catch (Exception e){}
            if (t>=blocksmumwidth){mapwidth=t;}else
            {JOptionPane.showMessageDialog(null, "error: mwidth", "w", JOptionPane.PLAIN_MESSAGE);}
            try {t = Integer.parseInt(temp [3]);} catch (Exception e){}
            if (t>=blocksmumwidth){maplength=t;}else
            {JOptionPane.showMessageDialog(null, "error: mlength", "w", JOptionPane.PLAIN_MESSAGE);}

            try {ewpos = Integer.parseInt(temp [4]);} catch (Exception e){}
            try {nspos = Integer.parseInt(temp [5]);} catch (Exception e){}

            map4 = new int[mapheight][mapwidth][maplength];
            map3 = new int[mapheight][mapwidth][maplength];
            map2 = new int[mapheight][mapwidth][maplength];

            unitscount=0;
            for (int i = mapheight-1; i >-1; i--) {
                for (int j = 0; j < mapwidth; j++) {
                    str=scan.nextLine();
                    String[]  temp2 = str.split(" ");

                    for (int k = 0; k < maplength; k++) {
                        int v2=777;
                        try { v2 = Integer.parseInt(temp2 [k]);} catch (Exception e){}
                        if (v2==1) {v2=998000;}
                        if (v2==2) {v2=999000;}
                        map2[i][j][k] = v2 ;
                    }
                }
            }

            str=scan.nextLine();
            int zp = 0;
            try {zp=Integer.parseInt(str);} catch (NumberFormatException e) {}
            if (zp!=0){
                for (int i = 0; i <zp; i++){
                    str=scan.nextLine();
                    String[]  temp2 = str.split(" ");
                    int arr[] =  new int [40];
                    for (int i2 = 0; i2 <40; i2++) {
                        int ff=-6666;
                        try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
                        //    System.out.print(ff+" ");
                        if (ff!=-6666){arr[i2]=ff;}
                    }
                    unitlist.add(arr);
                }
            }

            str=scan.nextLine();
            zp = 0;
            try {zp=Integer.parseInt(str);} catch (NumberFormatException e) {}
            if (zp!=0){
                for (int i = 0; i <zp; i++){
                    str=scan.nextLine();
                    String[]  temp2 = str.split(" ");
                    int arr[] =  new int [40];
                    for (int i2 = 0; i2 <40; i2++) {
                        int ff=-6666;
                        try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
                        //    System.out.print(ff+" ");
                        if (ff!=-6666){arr[i2]=ff;}
                    }
                    buildlist.add(arr);
                }
            }

            str=scan.nextLine();
            zp = 0;
            try {zp=Integer.parseInt(str);} catch (NumberFormatException e) {}
            if (zp!=0){
                for (int i = 0; i <zp; i++){
                    str=scan.nextLine();
                    String[]  temp2 = str.split(" ");
                    int arr[] =  new int [4];
                    for (int i2 = 0; i2 <4; i2++) {
                        int ff=-6666;
                        try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
                        //    System.out.print(ff+" ");
                        if (ff!=-6666){arr[i2]=ff;}
                    }
                    reslist.add(arr);
                }
            }

            str=scan.nextLine();
            try {zp=Integer.parseInt(str);} catch (NumberFormatException e) {}
            moneypl1 = zp;
            str=scan.nextLine();
            try {zp=Integer.parseInt(str);} catch (NumberFormatException e) {}
            moneypl2 = zp;

            brush0();
            zpos = mapheight;  transparentview=0; brush=-1; unitcountwaydepth = blocksmumwidth*2; loading = 0;
            if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
            text1s="map loaded. click";

            scan.close();
        }
        catch(Exception e)
        {System.out.println(e);
            text1s="err_map";
            JOptionPane.showMessageDialog(null, "no map.txt", "w", JOptionPane.PLAIN_MESSAGE);
        }
        redrawmainfield();
    }

    static void savem(){
        if (mp==0){   timeron = 0;}
        String temp = mapname+" "+mapheight+" "+mapwidth+" "+maplength+" "+ewpos+" "+nspos;
        String nl = "\r\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filep))) {
            writer.write(temp);
            writer.write(nl);

            for (int i = mapheight-1; i >-1; i--) {
                for (int j = 0; j < mapwidth; j++) {
                    for (int k = 0; k < maplength; k++) {
                        int tem=map2[i][j][k];
                        if (tem==998000) {tem=1;}
                        if (tem==999000) {tem=2;}
                        writer.write(tem + " ");
                    }
                    writer.write(nl);
                }
                //  writer.write("_"+nl);
            }

            int zp = unitlist.size();
            writer.write(zp+"");
            writer.write(nl);
            if (zp!=0){
                for (int i = 0; i <zp; i++){
                    int arr[]; arr = (int[]) unitlist.get(i);
                    for (int i2 = 0; i2 <40; i2++) {
                        String u =arr[i2]+" ";
                        writer.write(u);
                    }
                    writer.write(nl);
                }
            }

            zp = buildlist.size();
            writer.write(zp+"");
            writer.write(nl);
            if (zp!=0){
                for (int i = 0; i <zp; i++){
                    int arr[]; arr = (int[]) buildlist.get(i);
                    for (int i2 = 0; i2 <40; i2++) {
                        String u =arr[i2]+" ";
                        writer.write(u);
                    }
                    writer.write(nl);
                }
            }

            zp = reslist.size();
            writer.write(zp+"");
            writer.write(nl);
            if (zp!=0){
                for (int i = 0; i <zp; i++){
                    int arr[]; arr = (int[]) reslist.get(i);
                    for (int i2 = 0; i2 <4; i2++) {
                        String u =arr[i2]+" ";
                        writer.write(u);
                    }
                    writer.write(nl);
                }
            }
            writer.write(moneypl1+"");
            writer.write(nl);
            writer.write(moneypl2+"");

            if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
            text1s="map saved. click here";
            writer.close();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        redrawmenu();
        //   redrawmainfield();
    }

    static void crmet() {
        Sol2    sol2 = new Sol2();
    }

    void crbrsizemet(){
        Sol3    sol3 = new Sol3();
    }
    static void mewmapmet(){
        brush=0;    fillall();         timeron=0;
        unitlist.clear();  buildlist.clear();  reslist.clear();
        newmapstr  =smallField.getText();
        smallField.setText("");
        contents.dispose();

        String[] temp = newmapstr.split(" ");
        mapname = temp [0];

        int t=12;
        try {t = Integer.parseInt(temp [1]);} catch (Exception e){}
        if (t>1&&t<13){mapheight=t;}else
        {JOptionPane.showMessageDialog(null, "error: mheight", "n", JOptionPane.PLAIN_MESSAGE);}
        try {t = Integer.parseInt(temp [2]);} catch (Exception e){}
        if (t>=blocksmumwidth){mapwidth=t;}else
        {JOptionPane.showMessageDialog(null, "error: mwidth", "n", JOptionPane.PLAIN_MESSAGE);}
        try {t = Integer.parseInt(temp [3]);} catch (Exception e){}
        if (t>=blocksmumwidth){maplength=t;}else
        {JOptionPane.showMessageDialog(null, "error: mlength", "n", JOptionPane.PLAIN_MESSAGE);}

        map4 = new int[mapheight][mapwidth][maplength];
        map3 = new int[mapheight][mapwidth][maplength];
        map2 = new int[mapheight][mapwidth][maplength];
        for (int i = mapheight-1; i >-1; i--) {
            for (int j = 0; j < mapwidth; j++) {
                for (int k = 0; k < maplength; k++) {
                    map2[i][j][k] = 0 ;
                }
            }
        }
        zpos = mapheight; ewpos=0;nspos=0; transparentview=0; brush = -1;
        text1s="map created.";
        if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
        JOptionPane.showMessageDialog(null, "Click on menu", "map created", JOptionPane.PLAIN_MESSAGE);
    }

    void undo(){
        for (int i = 0; i < mapheight; i++)
            for (int j = 0; j < mapwidth; j++)
                for (int k = 0; k < maplength; k++) {
                    map2[i][j][k] = map4[i][j][k]; }
        redrawmainfield(); //let physics calc
    }

    static void  mebrushsizwmet(){
        String s  =smallField2.getText();
        smallField2.setText("");
        contents2.dispose();

        String[] temp = s.split(" ");

        int t=1;
        try {t = Integer.parseInt(temp [0]);} catch (Exception e){makebrush1();}//zbrush not higher than zmap

        if (t < 0) {//for units and buildings
            brush=-t;
        }
        else {
            if (t <= 12) {
                brsz = t;
            } else {
                JOptionPane.showMessageDialog(null, "error: bheight", "b", JOptionPane.PLAIN_MESSAGE);
                makebrush1();
            }
            try {
                t = Integer.parseInt(temp[1]);
            } catch (Exception e) {
                makebrush1();
            }
            if (t > 0) {
                brsy = t;
            } else {
                JOptionPane.showMessageDialog(null, "error: bwidth", "b", JOptionPane.PLAIN_MESSAGE);
                makebrush1();
            }
            try {
                t = Integer.parseInt(temp[2]);
            } catch (Exception e) {
                makebrush1();
            }
            if (t > 0) {
                brsx = t;
            } else {
                JOptionPane.showMessageDialog(null, "error: blength", "b", JOptionPane.PLAIN_MESSAGE);
                makebrush1();
            }
            brsz2 = brsz;
            brsy2 = brsy;
            brsx2 = brsx;
        }
        redrawmenu();
    }
    static void  makebrush1(){
        brsz=1;brsy=1;brsx=1;
        redrawmenu();
    }

    static void  blocksmulticlickmet(){
        // JOptionPane.showMessageDialog(null, "blocks more 1", "", JOptionPane.PLAIN_MESSAGE);
        int z = mouseblock[0];  int y = mouseblock[1];  int x = mouseblock[2];
        if (zpos==mapheight&&z!=-1){z=z+brsz-1;}
        if (zpos==mapheight&&z==-1){z=0+brsz-1;}
        if (zpos!=mapheight&&z==-1){z=0;}

        if (z>mapheight-3){z=mapheight-3;}

        for (int k = z; k > z - brsz; k--) {
            for (int k2 = brsy; k2 >0; k2--) {
                for (int k3 = brsx; k3 >0; k3--) {
                    try {
                        map2[k][y+k2-1][x+k3-1] = brush;
                    } catch (Exception e) {
                    }
                }
            }
        }
        redrawmainfield();
    }//blocksmulticlickmet end

    static void optionsread(){
        try{
            File myFile2 = new File(filep2);
            Scanner scan2 = new Scanner(myFile2);
            String str=scan2.nextLine();
            String[] temp = str.split(" ");

            int t=0;
            try {t = Integer.parseInt(temp [0]);} catch (Exception e){}
            blocksmumwidth =t; unitcountwaydepth = blocksmumwidth*2;

            mapwidth = t;
            maplength = t;
            try {t = Integer.parseInt(temp [1]);} catch (Exception e){}
            d=t;
            try {t = Integer.parseInt(temp [2]);} catch (Exception e){}
            fscr=t;
            try {t = Integer.parseInt(temp [3]);} catch (Exception e){}
            xres=t;
            try {t = Integer.parseInt(temp [4]);} catch (Exception e){}
            yres=t;
            try {t = Integer.parseInt(temp [5]);} catch (Exception e){}
            aihard=t;
            try {t = Integer.parseInt(temp [6]);} catch (Exception e){}
            mapdot=t;
            try {t = Integer.parseInt(temp [7]);} catch (Exception e){}
            timersleep=t;
            try {t = Integer.parseInt(temp [8]);} catch (Exception e){}
            portnum=t;

            ipserver = temp [9];

            try {t = Integer.parseInt(temp [10]);} catch (Exception e){}
            vertsliceall = t;
            try {t = Integer.parseInt(temp [11]);} catch (Exception e){}
            soundplay = t;
            scan2.close();
        }
        catch(Exception e)
        {System.out.println(e);
            optionswrite();
            //  JOptionPane.showMessageDialog(null, "no options.txt", "w", JOptionPane.PLAIN_MESSAGE);
        }
    }//options read end

    public static void  unitselectedmet(){
        //    JOptionPane.showMessageDialog(null, "smth  sel", "w", JOptionPane.PLAIN_MESSAGE);
        int z = mouseblock[0];  int y = mouseblock[1];  int x = mouseblock[2]; //last released map2 coord
        if (z==-1){z=0;}

        int a1 = (int) xclick/d; //relative coord
        int b1 = (int) yclick/d;
        int a2 = (int) xrel/d;
        int b2 = (int) yrel/d;

        Unit unit = new Unit();
        unit.zeroselect();
        singleselect=0;

        int xbl = 0; int ybl =0;      int xbl2 = 0; int ybl2 =0;
        if (a1<a2){  xbl += a1; xbl2+=a2;}else {xbl += a2; xbl2+=a1;}//xbl is start and not the biggest (may eq)
        if (b1<b2){  ybl += b1; ybl2+=b2;}else {ybl += b2; ybl2+=b1;}

        xbl+=ewpos; ybl+=nspos;
        xbl2+=ewpos; ybl2+=nspos;

        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}

        if (zpos>=mapheight-1) {//air unit start
            if (unitlist!=null){
                int arr[];
                int cc;
                int leftscrcorner = xbl;
                int rightscrcorner = xbl2;
                int upscrcorner = ybl;
                int downscrcorner = ybl2;
                for (int i = 0; i < unitlist.size(); i++) {
                    arr = (int[]) unitlist.get(i);

                    if (arr[1]==mapheight-1&&arr[14] > unmin && arr[14] < unmax) {//air unit
                        cc=0;
                        if (arr[2] >= upscrcorner && arr[2] <= downscrcorner && arr[3] >= leftscrcorner && arr[3] <= rightscrcorner) {cc++;}
                        if (arr[5] >= upscrcorner && arr[5] <= downscrcorner && arr[6] >= leftscrcorner && arr[6] <= rightscrcorner) {cc++;}
                        if (arr[8] >= upscrcorner && arr[8] <= downscrcorner && arr[9] >= leftscrcorner && arr[9] <= rightscrcorner) {cc++;}
                        if (cc > 0) {
                            arr[10]=1;
                            unitlist.set(i, arr);

                        }}}
            }}//air unit end

        if (zpos==mapheight) {//gr unit top start
            if (unitlist!=null){
                int arr[];
                int cc;
                int leftscrcorner = xbl;
                int rightscrcorner = xbl2;
                int upscrcorner = ybl;
                int downscrcorner = ybl2;
                for (int i = 0; i < unitlist.size(); i++) {
                    arr = (int[]) unitlist.get(i);

                    ArrayList templ = new ArrayList();
                    templ.add(arr[1]);  templ.add(arr[4]); templ.add(arr[7]);
                    Collections.sort(templ);
                    int temph=(int)templ.get(templ.size()-1);

                    if (temph<mapheight-1&&arr[14] > unmin && arr[14] < unmax) {//gr unit
                        cc=0;
                        if (arr[2] >= upscrcorner && arr[2] <= downscrcorner && arr[3] >= leftscrcorner && arr[3] <= rightscrcorner) {cc++;}
                        if (arr[5] >= upscrcorner && arr[5] <= downscrcorner && arr[6] >= leftscrcorner && arr[6] <= rightscrcorner) {cc++;}
                        if (arr[8] >= upscrcorner && arr[8] <= downscrcorner && arr[9] >= leftscrcorner && arr[9] <= rightscrcorner) {cc++;}
                        if (cc > 0) {
                            int hdes=0;
                            int hdes1,hdes2,hdes3; hdes1=hdes2=hdes3=1;
                            for (int n = arr[1]+1; n <mapheight-1; n++){//till the sky
                                if (map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                            for (int n = arr[4]+1; n <mapheight-1; n++){
                                if (map2[n][arr[2]][arr[3]]!=0){hdes2=0;break;}}
                            for (int n = arr[7]+1; n <mapheight-1; n++){
                                if (map2[n][arr[2]][arr[3]]!=0){hdes3=0;break;}}
                            hdes=hdes1+hdes2+hdes3;

                            if (hdes>0) {
                                arr[10] = 1;
                                unitlist.set(i, arr);
                            }}
                    }}
            }}//gr unit top end

        if (zpos<mapheight-1) {//gr unit NOT top start
            if (unitlist!=null){
                int arr[];
                int cc;
                int leftscrcorner = xbl;
                int rightscrcorner = xbl2;
                int upscrcorner = ybl;
                int downscrcorner = ybl2;
                for (int i = 0; i < unitlist.size(); i++) {
                    arr = (int[]) unitlist.get(i);
                    if (arr[14] > unmin && arr[14] < unmax){
                        int temph=0;
                        if (arr[1]==zpos||arr[4]==zpos||arr[7]==zpos){temph=1;}//if unit exist on such slice with any part (block)

                        if (temph>0&&arr[14] > 2 && arr[14] < 99800) {//gr unit
                            cc=0;
                            if (arr[2] >= upscrcorner && arr[2] <= downscrcorner && arr[3] >= leftscrcorner && arr[3] <= rightscrcorner) {cc++;}
                            if (arr[5] >= upscrcorner && arr[5] <= downscrcorner && arr[6] >= leftscrcorner && arr[6] <= rightscrcorner) {cc++;}
                            if (arr[8] >= upscrcorner && arr[8] <= downscrcorner && arr[9] >= leftscrcorner && arr[9] <= rightscrcorner) {cc++;}
                            if (cc > 0) {
                                arr[10] = 1;
                                unitlist.set(i, arr);
                            }
                        }}}
            }}//gr unit NOT top end

        if (zpos==mapheight) {//bld top start
            if (buildlist!=null){
                int arr[];
                int cc;
                int leftscrcorner = xbl;
                int rightscrcorner = xbl2;
                int upscrcorner = ybl;
                int downscrcorner = ybl2;
                for (int i = 0; i < buildlist.size(); i++) {
                    arr = (int[]) buildlist.get(i);

                    ArrayList templ = new ArrayList();
                    templ.add(arr[1]);  templ.add(arr[4]); templ.add(arr[7]);
                    Collections.sort(templ);
                    int temph=(int)templ.get(templ.size()-1);

                    if (temph<mapheight-1&&arr[14] > bldmin && arr[14] < bldmax) {//bld
                        cc=0;
                        if (arr[2] >= upscrcorner && arr[2] <= downscrcorner && arr[3] >= leftscrcorner && arr[3] <= rightscrcorner) {cc++;}
                        if (arr[5] >= upscrcorner && arr[5] <= downscrcorner && arr[6] >= leftscrcorner && arr[6] <= rightscrcorner) {cc++;}
                        if (arr[8] >= upscrcorner && arr[8] <= downscrcorner && arr[9] >= leftscrcorner && arr[9] <= rightscrcorner) {cc++;}
                        if (cc > 0) {
                            int hdes=0;
                            int hdes1,hdes2,hdes3; hdes1=hdes2=hdes3=1;
                            for (int n = arr[1]+1; n <mapheight-1; n++){//till the sky
                                if (map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                            for (int n = arr[4]+1; n <mapheight-1; n++){
                                if (map2[n][arr[2]][arr[3]]!=0){hdes2=0;break;}}
                            for (int n = arr[7]+1; n <mapheight-1; n++){
                                if (map2[n][arr[2]][arr[3]]!=0){hdes3=0;break;}}
                            hdes=hdes1+hdes2+hdes3;

                            if (hdes>0) {
                                arr[10] = 1;
                                buildlist.set(i, arr);
                                singleselect++;
                            }}
                    }}
            }}//bld top end

        if (zpos<mapheight-1) {//bld NOT top start
            if (buildlist!=null){
                int arr[];
                int cc;
                int leftscrcorner = xbl;
                int rightscrcorner = xbl2;
                int upscrcorner = ybl;
                int downscrcorner = ybl2;
                for (int i = 0; i < buildlist.size(); i++) {
                    arr = (int[]) buildlist.get(i);
                    if (arr[14] > bldmin && arr[14] < bldmax){
                        int temph=0;
                        if (arr[1]==zpos||arr[4]==zpos||arr[7]==zpos){temph=1;}//if bld exist on such slice with any part (block)

                        if (temph>0&&arr[14] > 2 && arr[14] < 99800) {//gr unit
                            cc=0;
                            if (arr[2] >= upscrcorner && arr[2] <= downscrcorner && arr[3] >= leftscrcorner && arr[3] <= rightscrcorner) {cc++;}
                            if (arr[5] >= upscrcorner && arr[5] <= downscrcorner && arr[6] >= leftscrcorner && arr[6] <= rightscrcorner) {cc++;}
                            if (arr[8] >= upscrcorner && arr[8] <= downscrcorner && arr[9] >= leftscrcorner && arr[9] <= rightscrcorner) {cc++;}
                            if (cc > 0) {
                                arr[10] = 1;
                                buildlist.set(i, arr);
                            }
                        }}}
            }}//bldt NOT top end

        pane.drawf();
        redrawmenu();
    }

    public static void testout2(){
        Unit unit = new Unit();
        unit.checkunitcount();

        // System.out.println(singleselect);
        //    try {scrshot();} catch (AWTException e) {throw new RuntimeException(e);}
        System.out.println();
        System.out.print("money_pl1: "+moneypl1);
        System.out.println(" _ money_pl2: "+moneypl2);
        int arr3[];
        for (int i = 0; i <Sol.unitlist.size(); i++) {
            arr3 = (int[]) Sol.unitlist.get(i);
            //    Ai ai = new Ai(); ai.go(i);
            for (int i2 = 0; i2 <40; i2++) {
                System.out.print(arr3[i2]+" ");
            }
            System.out.println();
        }
        System.out.println("_");

        for (int i = 0; i <Sol.buildlist.size(); i++) {
            arr3 = (int[]) Sol.buildlist.get(i);
            for (int i2 = 0; i2 <40; i2++) {
                System.out.print(arr3[i2]+" ");
            }
            System.out.println();
        }
        System.out.println("__");

        for (int i = 0; i <Sol.reslist.size(); i++) {
            arr3 = (int[]) Sol.reslist.get(i);
            for (int i2 = 0; i2 <4; i2++) {
                System.out.print(arr3[i2]+" ");
            }
            System.out.println();
        }
        System.out.println("_=_");
    }

    public static void moveselectedunits(){
        if (grselectfag==0){
            Unit unit = new Unit();
            unit.unitgo();}
        else{
            grselectfag=0;
            dogroundattackhow();
        }
    }

    public static void fillall(){
        if (brush==0||brush>=99800){
            for (int i = 0; i < mapheight; i++)
                for (int j = 0; j < mapwidth; j++)
                    for (int k = 0; k < maplength; k++) {
                        map4[i][j][k] = map2[i][j][k];}

            for (int i = mapheight-3; i >-1; i--) {
                for (int j = 0; j < mapwidth; j++) {
                    for (int k = 0; k < maplength; k++) {
                        map2[i][j][k] = brush ;
                    }}}
            if (brush==0){
                unitlist.clear();
                buildlist.clear();
                reslist.clear();
                for (int i = mapheight-1; i >mapheight-3; i--) {
                    for (int j = 0; j < mapwidth; j++) {
                        for (int k = 0; k < maplength; k++) {
                            map2[i][j][k] = brush ;
                        }}}
            }
            redrawmainfield();
        }
    }
    public static void timergo(){
        Timer2 timer = new Timer2();
        timer.go();
    }

    public static void timerstep(){

        if (countt >= unitsnum) {countt=0;}else{countt++;}
        if (countt2 >= buildnum) {countt2=0;}else{countt2++;}
        if (mp==0){
            Unit unit = new Unit();
            unit.unitgo2();
        }else{
            if (iampl2==0){//server start
                //   System.out.println("go serv");

                if (server==null){
                    Server serv = new Server();
                    new Thread(serv).start();}else{
                    servgo=1;
                }
            }//server end
            else
            {//client start

            }//client end
        }
    }

    public static void scrshot() throws AWTException {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = null;
        try {
            capture = new Robot().createScreenCapture(screenRect);
        } catch (Exception e){}
        dest = capture.getSubimage(0, 0, d*blocksmumwidth, d*blocksmumwidth);
        //  dest = capture.getSubimage(0, 0, 300, 300);

    }

    public static void  deleteselectedunits(){
        if (Sol.iampl2>0){Sol.action=3; }
        // ArrayList list2 = new ArrayList<>();
        int arr[];
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i <unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){unitlist.remove(i); deleteselectedunits();}
        }

        for (int i = 0; i <buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i);
            if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){buildlist.remove(i); deleteselectedunits();}
        }

        phcal();
    }

    public static int   getunitspeed(int b){
        int result=0;
        if (b==3||b==2003){result=tria_step_time;}
        if (b==4||b==2004){result=zepp_step_time;}
        if (b==5||b==2005){result=car_step_time;}
        if (b==6||b==2006){result=tria_step_time;}
        if (b==7||b==2007){result=car_step_time;}
        if (b==8||b==2008){result=tria_step_time;}
        if (b==9||b==2009){result=car_step_time*3;}

        result=zepp_step_time/2; if (b==9||b==2009||b==8||b==2008){result=result*2;} //for test
        if (aipl2>0&&b!=2009&&b!=2007&&b!=2004&&b!=2008){result=result*2;}
        //  System.out.println(result);
        return result;
    }

    public static int   getunitrange(int b){
        int result=0;
        if (b==5||b==2005){result=airdef_dist;}
        if (b==6||b==2006){result=how_dist;}
        if (b==7||b==2007){result=gun_dist;}
        if (b==8||b==2008){result=gun_dist;}
        if (b==9||b==2009){result=how_dist-2;}

        if (b==1005||b==3005){result=airdef_dist;}
        if (b==1006||b==3006){result=how_dist-2;}
        if (b==1007||b==3007){result=gun_dist;}
        return result;
    }

    public static int   getunithp(int b){
        int result=0;
        if (b==3||b==2003){result=car_hp;}
        if (b==4||b==2004){result=car_hp;}
        if (b==5||b==2005){result=car_hp;}
        if (b==6||b==2006){result=eng_hp*2;}
        if (b==7||b==2007){result=car_hp;}
        if (b==8||b==2008){result=eng_hp*3;}
        if (b==9||b==2009){result=car_hp;}

        if (b==1001||b==3001){result=eng_hp*3;}
        if (b==1003||b==3003){result=eng_hp*3;}
        if (b==1005||b==3005){result=eng_hp*3;}
        if (b==1006||b==3006){result=eng_hp*3;}
        if (b==1007||b==3007){result=eng_hp*3;}
        if (b==1008||b==3008){result=eng_hp*3;}
        //dummy
        // if (b==1010||b==3010){result=4;}
        if (b==1010||b==3010){result=eng_hp;}
        if (b==1011||b==3011){result=1;}
        return result;
    }

    public static int   getunitdmg(int b){
        int result=0;
        if (b==5||b==2005){result=mortardmg;}
        if (b==6||b==2006){result=mortardmg;}
        if (b==7||b==2007){result=mortardmg;}
        if (b==8||b==2008){result=(int)(mortardmg*2.0);}//tank has 2 guns

        if (b==1005||b==3005){result=(int)(mortardmg*3.0);}
        if (b==1006||b==3006){result=(int)(mortardmg*5.0);}
        if (b==1007||b==3007){result=(int)(mortardmg*5.0);}//cos bld = 56 and units 24, coeff. is 2.3 (double 4.6=5)
        return result;
    }

    public static int   getfiredelay(int b){//reload
        int result=0;
        if (b==4||b==2004){result=zeppfiredaly;}
        if (b==9||b==2009){result=zeppfiredaly*2;}

        if (b==1001){result=minedelaypl1;}
        if (b==3001){result=minedelaypl2;}

        return result;
    }
    public static int mirrorx (int dir,int x,  int y){
        if (dir==2){x=-x+d;}
        if (dir==1){x=y;}
        if (dir==3){x=y;}

        if   (headtail==3){
            if   (dir==0){x=x+dif;}
            if   (dir==2){x=x-dif;}
        }
        else{
            if (tail==0){
                if   (dir==0){x=x+dif;}
                if   (dir==2){x=x-dif;}
                if (x<0){x=0;}
                if (x>d){x=d;}
            }else{
                if   (dir==0){x=x+dif+d;}
                if   (dir==2){x=x-dif-d;}
                if (x<0){x=0;}
                if (x>d){x=d;}
            }}
        return x;
    }

    public static int mirrory (int dir,int x,  int y){
        if (dir==1){y=x;}
        if (dir==3){y=d-x;}

        if   (headtail==3){
            if   (dir==1){y=y+dif;}
            if   (dir==3){y=y-dif;}
        }
        else{
            if (tail==0){
                if   (dir==1){y=y+dif;}
                if   (dir==3){y=y-dif;}
                if (y<0){y=0;}
                if (y>d){y=d;}
            }else{
                if   (dir==1){y=y+dif+d;}
                if   (dir==3){y=y-dif-d;}
                if (y<0){y=0;}
                if (y>d){y=d;}
            }}
        return y;
    }

    public static void groundattack(){
        if (Sol.iampl2>0){Sol.action=4; }
        int[] arr; grselectfag=1;
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i < unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                arr[17]=0;
                arr[25]=0; // gr attack for heavy
                arr [27]=-1; arr [28]=-1; //to evade false fire
                Sol.unitlist.set(i, arr);
            }}
        for (int i = 0; i < buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i);
            if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                arr[17]=0;
                arr[25]=0; // gr attack for heavy
                Sol.buildlist.set(i, arr);
            }}
    }
    public static void holdfire(){
        if (Sol.iampl2>0){Sol.action=5; }
        int[] arr; grselectfag=0;
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i < unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                arr[17]=1;//no shoot at will
                arr[25]=1; //no gr attack for heavy
                arr [27]=-1; arr [28]=-1; //not gr trg coord
                Sol.unitlist.set(i, arr);
            }}
        for (int i = 0; i < buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i);
            if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                arr[17]=1;//no shoot at will
                arr[25]=1; //no gr attack for heavy
                arr [27]=-1; arr [28]=-1; //not gr trg coord
                Sol.buildlist.set(i, arr);
            }}
    }

    public static void fireatwiil(){
        if (Sol.iampl2>0){Sol.action=6; }
        int[] arr; grselectfag=0;
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i < unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                arr[17]=0;// shoot at will
                Sol.unitlist.set(i, arr);
            }}
        for (int i = 0; i < buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i);
            if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                arr[17]=0;// shoot at will
                Sol.buildlist.set(i, arr);
            }}
    }

    public static void dogroundattackhow(){
        int zc = mouseblock[0];
        int yc = mouseblock[1];
        int xc = mouseblock[2];
        int[] arr=null;
        if (singleselect!=666){
            try{ arr = (int[]) Sol.unitlist.get(singleselect);}catch(Exception e){}
            if (arr[14]==3||arr[14]==2003){//if eng is single selected
                engsologroundsel();
            }else{//if not eng, so howitzer start
                for (int i = 0; i < unitlist.size(); i++) {
                    arr = (int[]) Sol.unitlist.get(i);
                    if (arr[10]==1){//if selected
                        if (arr[14]==9||arr[14]==2009){
                            int   range = arr[19]+(int) (arr[1]/3);
                            double dist1 = Math.sqrt((yc - arr[2]) * (yc - arr[2]) + (xc - arr[3]) * (xc - arr[3]));
                            if (range>=dist1&&dist1>Sol.mindistmortandhowit){
                                arr[25]=0;    arr[27] = yc;        arr[28] = xc;
                                if (Sol.iampl2>0){Sol.action=7; Sol.actz=0; Sol.acty=yc; Sol.actx=xc;}
                                unitlist.set(i, arr);}
                            else{
                                arr[25]=1;    arr[27] = -1;        arr[28] = -1;
                                if (Sol.iampl2>0){Sol.action=7; Sol.actz=1; Sol.acty=-1; Sol.actx=-1;}
                                unitlist.set(i, arr);
                            }
                        }}}
            }//if not eng, so howitzer end
        }}

    public static void   minego(int i){
        int income=mineincomestep;
        int[] arr;   arr = (int[]) buildlist.get(i);
        int count=0;    int[] arr2; int ir;
        for ( ir = 0; ir <reslist.size(); ir++){
            arr2 = (int[]) reslist.get(ir);
            if (arr2[0]==arr[2]&&arr2[1]==arr[3]){count++;break;}}//if res exist in this coord
        if (count!=0){//if res exist in such coord
            int hdes=1;  try{for (int n = arr[1]-1; n >-1; n--){//till the botton
                if (map2[n][arr[2]][arr[3]]<997999){hdes=0;break;}}} catch (Exception ef){}
            if (hdes!=0) {//if down only rock or gravel - NO void, units, buildings (including mines)
                arr2 = (int[]) reslist.get(ir);
                if (arr2[2]<=0&&arr2[2]!=-9999){reslist.remove(ir);}//if mine is dry - remove
                else {
                    double depthcharge = 0.1*mineincomestep*arr[1];
                    income = (int) (income - depthcharge);
                    if (income>0){
                        arr[19]=-income; buildlist.set(i, arr);
                        if (arr2[2]!=-9999){arr2[2]=arr2[2]-income;   reslist.set(ir, arr2);}//if res finite, take from source
                        if (arr[14]==1001){moneypl1=moneypl1+income;} else
                        {moneypl2=moneypl2+income;}
                        redrawmenu();
                    }}}else{income=0;}
        } else{income=0;}
        if (income<=0&&arr[19]!=0){ arr[19]=0; buildlist.set(i, arr);}//mine is ineffective
    }// minego end

    public static String getname(int n) {
        String res = "name";

        if (n>2000&&n<4000) {n=n-2000;}

        if (n==3){res = "engineer ";}
        if (n==4){res = "zeppelin ";}
        if (n==5){res = "air defence";}
        if (n==6){res = "mortar";}
        if (n==7){res = "car gun";}
        if (n==8){res = "tank";}
        if (n==9){res = "heavy howitzer";}

        if (n==1001){res = "mine";}
        if (n==1003){res = "HQ";}
        if (n==1005){res = "bld. air defence";}
        if (n==1006){res = "bld. mortar";}
        if (n==1007){res = "bld. gun";}
        if (n==1008){res = "barracks";}
        if (n==1010){res = "in process";}
        if (n==1011){res = "dynamite";}

        if (n==4001){res = "neutr. medic";}
        if (n==4007){res = "neutr. car";}

        if (n>998000){
            int r3 = n % 1000;
            if (r3==1){res="resource";}
        }

        return res;
    }

    public static int getprice (int b){
        int res=engprice;
        if (b==3||b==2003){res=engprice*2;}
        if (b==4||b==2004){res=engprice*7;}
        if (b==5||b==2005){res=engprice*3;}
        if (b==6||b==2006){res=engprice*3;}
        if (b==7||b==2007){res=engprice;}
        if (b==8||b==2008){res=engprice*4;}
        if (b==9||b==2009){res=engprice*5;}

        if (b==1001||b==3001){res=engprice*6;}
        if (b==1003||b==3003){res=engprice*33+1;}
        if (b==1005||b==3005||b==1006||b==3006 ||b==1007||b==3007){res=engprice*5;}
        if (b==1008||b==3008){res=engprice*10;}
        if (b==1011||b==3011){res=engprice*2;}

        if (b==4001){res=engprice*8+1;}
        return res;
    }

    public static int getpspeedbuild (int b){
        int res=engspeedbuild;
        if (b==8||b==2008){res=engspeedbuild*2;}
        if (b==9||b==2009){res=engspeedbuild*2;}
        if (b==4||b==2004){res=engspeedbuild*4;}//zepp is slow built. no zepp rush at start

        return res;
    }

    public static void   hqgo(int i){//build engineers in hq
        int[] arr;   arr = (int[]) buildlist.get(i);
        int ie, iw, in, is;
        ie = iw = in = is  = -1;
        int m = 0;
        int zt=arr[1]; int yt = arr[2]; int xt = arr[3];
        try {
            iw = Sol.map2[zt][yt][xt - 1]; if (iw!=m){iw=-1;}
        } catch (Exception e2) {
        }
        try {
            ie = Sol.map2[zt][yt][xt + 1]; if (ie!=m){ie=-1;}
        } catch (Exception e2) {
        }
        try {
            in = Sol.map2[zt][yt - 1][xt]; if (in!=m){in=-1;}
        } catch (Exception e2) {
        }
        try {
            is = Sol.map2[zt][yt + 1][xt]; if (is!=m){is=-1;}
        } catch (Exception e2) {
        }//

        //     System.out.println(iw +" "+ie+" "+in+" "+is);

        m=998000; int cannotgo = 0;
        if (zt==0){
            if (iw==0){ mouseblock[1] =yt;mouseblock[2]=xt-1;}
            if (ie==0){ mouseblock[1] =yt;mouseblock[2]=xt+1;}
            if (in==0){ mouseblock[1] =yt-1;mouseblock[2]=xt;}
            if (is==0){ mouseblock[1] =yt+1;mouseblock[2]=xt;}

            if(iw+ie+in+is>-4){
                mouseblock[0]=zt; loading = 1;
                brush = 3;
                if (arr[14]>2000){brush=brush+2000;}
                arr[29]=0;      buildlist.set(i,arr);
                Unit unit = new Unit();
                unit.go();
                brush=-1; loading =0;
            }else{cannotgo=1;}
        }//zt=0 end
        if (zt!=0){
            if (iw==0){  try {iw = Sol.map2[zt-1][yt][xt - 1]; if (iw<m){iw=-1;}else{iw=1;}} catch (Exception e2) {}
                if (iw!=-1){ mouseblock[1] =yt;mouseblock[2]=xt-1;}   }
            if (ie==0){  try {ie = Sol.map2[zt-1][yt][xt + 1]; if (ie<m){ie=-1;}else{ie=1;}} catch (Exception e2) {}
                if (ie!=-1){ mouseblock[1] =yt;mouseblock[2]=xt+1;}   }
            if (in==0){  try {in = Sol.map2[zt-1][yt-1][xt ]; if (in<m){in=-1;}else{in=1;}} catch (Exception e2) {}
                if (in!=-1){ mouseblock[1] =yt-1;mouseblock[2]=xt;}   }
            if (is==0){  try {is = Sol.map2[zt-1][yt+1][xt ]; if (is<m){is=-1;}else{is=1;}} catch (Exception e2) {}
                if (is!=-1){ mouseblock[1] =yt+1;mouseblock[2]=xt;}   }
// System.out.println("iw:"+iw+" ie:"+ie+" in:"+in+" is:"+is);
            if(iw+ie+in+is>-4){
                mouseblock[0]=zt; loading = 1;
                brush = 3;
                if (arr[14]>2000){brush=brush+2000;}
                arr[29]=0;      buildlist.set(i,arr);
                Unit unit = new Unit();
                unit.go();
                brush=-1; loading =0;
            }else{cannotgo=1;}}

        if (cannotgo>0){arr[26]++;buildlist.set(i,arr);}
    }//hq go end

    public static void   bargo(int i){//build in barracks
        int[] arr;   arr = (int[]) buildlist.get(i);
        int nm = arr[29];
        int ie, iw, in, is;
        ie = iw = in = is  = -1;
        int m = 0;
        int zt=arr[1]; int yt = arr[2]; int xt = arr[3];
        if (nm==4||nm==2004){zt=mapheight-1;}

        try {
            iw = Sol.map2[zt][yt][xt - 1]; if (iw!=m){iw=-1;}
        } catch (Exception e2) {
        }
        try {
            ie = Sol.map2[zt][yt][xt + 1]; if (ie!=m){ie=-1;}
        } catch (Exception e2) {
        }
        try {
            in = Sol.map2[zt][yt - 1][xt]; if (in!=m){in=-1;}
        } catch (Exception e2) {
        }
        try {
            is = Sol.map2[zt][yt + 1][xt]; if (is!=m){is=-1;}
        } catch (Exception e2) {
        }//

        m=998000; int cannotgo = 0;
        if (zt==0||zt==mapheight-1){
            if (iw==0){ mouseblock[1] =yt;mouseblock[2]=xt-1;}
            if (ie==0){ mouseblock[1] =yt;mouseblock[2]=xt+1;}
            if (in==0){ mouseblock[1] =yt-1;mouseblock[2]=xt;}
            if (is==0){ mouseblock[1] =yt+1;mouseblock[2]=xt;}

            if(iw+ie+in+is>-4){
                brush = nm;
                mouseblock[0]=zt; loading = 1;
                if (arr[14]>2000){brush=brush+2000;}
                arr[29]=0;      buildlist.set(i,arr);
                Unit unit = new Unit();
                unit.go();
                brush=-1; loading =0;
            }else{cannotgo=1;}
        }//zt=0 or zt sky end
        if (zt!=0&&zt!=mapheight-1){//not bottom and not sky
            if (iw==0){  try {iw = Sol.map2[zt-1][yt][xt - 1]; if (iw<m){iw=-1;}else{iw=1;}} catch (Exception e2) {}
                if (iw!=-1){ mouseblock[1] =yt;mouseblock[2]=xt-1;}   }
            if (ie==0){  try {ie = Sol.map2[zt-1][yt][xt + 1]; if (ie<m){ie=-1;}else{ie=1;}} catch (Exception e2) {}
                if (ie!=-1){ mouseblock[1] =yt;mouseblock[2]=xt+1;}   }
            if (in==0){  try {in = Sol.map2[zt-1][yt-1][xt ]; if (in<m){in=-1;}else{in=1;}} catch (Exception e2) {}
                if (in!=-1){ mouseblock[1] =yt-1;mouseblock[2]=xt;}   }
            if (is==0){  try {is = Sol.map2[zt-1][yt+1][xt ]; if (is<m){is=-1;}else{is=1;}} catch (Exception e2) {}
                if (is!=-1){ mouseblock[1] =yt+1;mouseblock[2]=xt;}   }
// System.out.println("iw:"+iw+" ie:"+ie+" in:"+in+" is:"+is);
            if(iw+ie+in+is>-4){
                brush = nm;
                mouseblock[0]=zt; loading = 1;
                if (arr[14]>2000){brush=brush+2000;}
                arr[29]=0;      buildlist.set(i,arr);
                Unit unit = new Unit();
                unit.go();
                brush=-1; loading =0;
            }else{cannotgo=1;}}

        if (cannotgo>0){arr[26]++;buildlist.set(i,arr);}
    }//bargo end

    public static void    engsologroundsel(){
        int[] arr;   arr = (int[]) unitlist.get(singleselect);
        int bz =  arr[29]; arr[29]=0;
        unitlist.set(singleselect,arr);
        int  ze=arr[1];  int  ye=arr[2]; int xe = arr[3];
        int yc = mouseblock[1];       int xc = mouseblock[2];
        int go=0;
        double dist = Math.sqrt((ye - yc) * (ye - yc) + (xe - xc) * (xe - xc));
        if (dist>0.9&&dist<1.1){go=1;}//if in close blocks
        int pt=-1;
        try {pt = map2[ze][yc][xc];} catch (Exception e2) {}
        if (ze>0){
            if (pt!=0){go=0;}else{//if free space
                try {pt = map2[ze-1][yc][xc];} catch (Exception e2) {}
                if (pt<998000){go=0;}//if no solid ground
            }
        }else{
            if (pt!=0){go=0;}
        }

        if (go>0)    {
            if (arr[14]==3){//pl
                if (bz==4001){// medic
                    if (moneypl1>=getprice(bz)) {// is not on peak
                        if (ze<mapheight-2) {
                            moneypl1 = moneypl1 - getprice(bz);
                            map2[ze][yc][xc] = bz;//for blocks through create unit is optional
                            redrawmainfield();
                        }
                        else{redrawmenu();}
                    }}else{
                    if (moneypl1>=getprice(bz)) {
                        moneypl1 = moneypl1 - getprice(bz);
                        mouseblock[0] = ze - 1;

                        if (zpos<mapheight){mouseblock[0]++;}

                        // if (mouseblock[0] < 0) {mouseblock[0] = 0;}
                        brush = 1010; dummy=bz;
                        Unit unit = new Unit();
                        unit.go();
                        brush=-1;
                    }}
            }

            if (arr[14]==2003){//pl2////////////////////////////
                if (bz==4001){// medic
                    if (moneypl2>=getprice(bz)) {// is not on peak
                        if (ze<mapheight-2) {
                            moneypl2 = moneypl2 - getprice(bz);
                            map2[ze][yc][xc] = bz;//for blocks through create unit is optional

                            redrawmainfield();
                        }
                        else{redrawmenu();}
                    }}else{
                    if (moneypl2>=getprice(bz)) {
                        moneypl2 = moneypl2 - getprice(bz);
                        mouseblock[0] = ze - 1;

                        if (zpos<mapheight){mouseblock[0]++;}

                        // if (mouseblock[0] < 0) {mouseblock[0] = 0;}


                        brush = 3010; dummy=bz;
                        Unit unit = new Unit();
                        unit.go();
                        brush=-1;
                    }}
                if (Sol.iampl2>0){Sol.action=10; Sol.actz=ze; Sol.acty=yc; Sol.actx=xc; Sol.actdigdir=getprice(Sol.actdigtype);}
            }
        }else{//if cannot build, zero to counters
            if (Sol.iampl2>0){Sol.action=-1;  Sol.actdigtype=-1; Sol.actdigdir=-1;
                buildcountpl2--;
                if (bz==3003){hqnump2--;}
                if (bz==3005||bz==3006||bz==3007){buildshootcountpl2 --;} }
            buildcountpl1--;
            if (bz==1003){hqnump1--;}
            if (bz==1005||bz==1006||bz==1007){buildshootcountpl1 --;}
        }
    }//engsologroundsel end

    public static void    dummygo(int i){
        int[] arr;   arr = (int[]) buildlist.get(i);
        arr[0]=arr[29];
        arr[14]=arr[29];
        arr[29]=0;
        arr[18] = Sol.getunithp(arr[14]);
        arr[19] = Sol.getunitrange(arr[14]);
        arr[20] = Sol.getunitdmg(arr[14]);
        buildlist.set(i,arr);
        map2[arr[1]][arr[2]][arr[3]] =arr[14];
        pane.drawf();
    }

    public static JDialog createDialog(final JFrame frame){
        final  int arr [];
        arr = (int[]) unitlist.get(singleselect); //we already know it's eng


        int h = hegihtpix;
        int w = widthpix;
        w=3*w/4+d;
        final JDialog modelDialog = new JDialog(frame, "dig direction",
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(w-4, (int)(2.1*d), (int)(3.2*d)+15, (int)(6.5*d));
        Container dialogContainer = modelDialog.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(8,3,1,1));

        JLabel text0 = new JLabel("engin.");
        text0.setFont(new Font("Arial", Font.BOLD, 14));
        text0.setForeground(new Color(175, 65, 175));
        panel1.add(text0);
        JLabel text01 = new JLabel("dig");
        text01.setFont(new Font("Arial", Font.BOLD, 14));
        text01.setForeground(new Color(175, 65, 175));
        panel1.add(text01);
        JLabel text02 = new JLabel("direct.");
        text02.setFont(new Font("Arial", Font.BOLD, 14));
        text02.setForeground(new Color(175, 65, 175));
        panel1.add(text02);

        JLabel text1 = new JLabel("");
        panel1.add(text1);
        JButton un = new JButton(" NO ");
        un.setBackground(new Color(255, 255, 100));
        un.setBounds(0,0,d/2,d/2);
        un.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[30]=0; arr[31]=0;
                unitlist.set(singleselect,arr);
                //   JOptionPane.showMessageDialog(null, "un dig", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(un);
        JLabel text3 = new JLabel("");
        panel1.add(text3);

        JLabel text4 = new JLabel("select");
        panel1.add(text4);
        JLabel text5 = new JLabel("direction");
        panel1.add(text5);
        JLabel text6 = new JLabel("1 step:");
        panel1.add(text6);

        JLabel text7 = new JLabel("");
        panel1.add(text7);
        JButton ub = new JButton("^");
        ub.setBackground(new Color(200, 200, 200));
        ub.setBounds(0,0,d/2,d/2);
        ub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=1; Sol.actdigdir =  arr[31];  unitlist.set(singleselect,arr); engdig(singleselect);
                // JOptionPane.showMessageDialog(null, "u", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(ub);
        JLabel text12 = new JLabel("");
        panel1.add(text12);

        JButton lb = new JButton("<");
        lb.setBackground(new Color(200, 200, 200));
        lb.setBounds(0,0,d/2,d/2);
        lb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=0;  Sol.actdigdir =  arr[31]; unitlist.set(singleselect,arr); engdig(singleselect);
                // JOptionPane.showMessageDialog(null, "l", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(lb);
        JButton db = new JButton("v");
        db.setBackground(new Color(200, 200, 200));
        db.setBounds(0,0,d/2,d/2);
        db.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=3;   Sol.actdigdir =  arr[31]; unitlist.set(singleselect,arr); engdig(singleselect);
                // JOptionPane.showMessageDialog(null, "d", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(db);
        JButton rb = new JButton(">");
        rb.setBackground(new Color(200, 200, 200));
        rb.setBounds(0,0,d/2,d/2);
        rb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=2; Sol.actdigdir =  arr[31];  unitlist.set(singleselect,arr); engdig(singleselect);
                //  JOptionPane.showMessageDialog(null, "r", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(rb);

        JLabel text16 = new JLabel("select");
        panel1.add(text16);
        JLabel text17 = new JLabel("direction");
        panel1.add(text17);
        JLabel text21 = new JLabel("unlim:");
        panel1.add(text21);

        JLabel text22 = new JLabel("");
        panel1.add(text22);
        JButton ub2 = new JButton("^");
        ub2.setBackground(new Color(175, 65, 175));
        ub2.setBounds(0,0,d/2,d/2);
        ub2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=5;  Sol.actdigdir =  arr[31]; unitlist.set(singleselect,arr); engdig(singleselect);
                // JOptionPane.showMessageDialog(null, "u2", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(ub2);
        JLabel text24 = new JLabel("");
        panel1.add(text24);

        JButton lb2 = new JButton("<");
        lb2.setBackground(new Color(175, 65, 175));
        lb2.setBounds(0,0,d/2,d/2);
        lb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=4;  Sol.actdigdir =  arr[31]; unitlist.set(singleselect,arr); engdig(singleselect);
                // JOptionPane.showMessageDialog(null, "l2", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(lb2);
        JButton db2 = new JButton("v");
        db2.setBackground(new Color(175, 65, 175));
        db2.setBounds(0,0,d/2,d/2);
        db2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=7; Sol.actdigdir =  arr[31];  unitlist.set(singleselect,arr); engdig(singleselect);
                //JOptionPane.showMessageDialog(null, "d2", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(db2);
        JButton rb2 = new JButton(">");
        rb2.setBackground(new Color(175, 65, 175));
        rb2.setBounds(0,0,d/2,d/2);
        rb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                arr[31]=6; Sol.actdigdir =  arr[31]; unitlist.set(singleselect,arr); engdig(singleselect);
                //  JOptionPane.showMessageDialog(null, "r2", "w", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel1.add(rb2);

        dialogContainer.add(panel1);
        modelDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        modelDialog.setUndecorated(true);
        return modelDialog;
    }

    public static void engdig(int i){
        int arr []; arr = (int[]) unitlist.get(i);
        double k = 1.0;
        if (arr[30]==3){k=1.0;}//for 1 void block time is 1 coeff
        if (arr[30]==4){k=1.0;}//1 rock
        if (arr[30]==5){k=2.0;}//tunnel 2.0

        if (arr[30]>=7&&arr[30]<=10){k=2.0; //turns coeff 2.0
            if (arr[31]>3){arr[31]=arr[31]-4;}} //turns only once

        if (arr[30]==6||arr[30]==11){k=2.0;}//up down coeff 2.0

        k = 1.0; //for test
        int k2 =(int) ((k*4));
        arr[32]=k2; //dig counter

        unitlist.set(i,arr);
        if (Sol.iampl2>0){Sol.action=9; Sol.actz=i; }
//JOptionPane.showMessageDialog(null, arr[30]+" "+arr[31], "dig", JOptionPane.PLAIN_MESSAGE);
    }

    public static void engdig2(int i){
        int arr []; arr = (int[]) unitlist.get(i);
        int dot=-1;

        if (arr[30]==3){//if void1
            if (arr[31]==0||arr[31]==4) {try { dot = map2[arr[1]][arr[2]][(arr[3]-1)];
                if (dot>997999){map2[arr[1]][arr[2]][(arr[3]-1)]=0;}} catch (Exception e2) {}}//w
            if (arr[31]==1||arr[31]==5) {try {  dot =map2[arr[1]][(arr[2]-1)][arr[3]];
                if (dot>997999) {map2[arr[1]][(arr[2]-1)][arr[3]]=0;}} catch (Exception e2) {}}//n
            if (arr[31]==2||arr[31]==6) {try { dot = map2[arr[1]][arr[2]][(arr[3]+1)];
                if (dot>997999){map2[arr[1]][arr[2]][(arr[3]+1)]=0;}} catch (Exception e2) {}}//e
            if (arr[31]==3||arr[31]==7) {try { dot = map2[arr[1]][(arr[2]+1)][arr[3]];
                if (dot>997999){map2[arr[1]][(arr[2]+1)][arr[3]]=0;}} catch (Exception e2) {}}//s
        }

        if (arr[30]==4){//if rock1 - rock is behind! (opposite dir)
            int r = 998000; if (arr[1]<mapheight-2){// not sky , not peak
                if (arr[31]==0||arr[31]==4) {try { dot = map2[arr[1]][arr[2]][(arr[3]+1)];
                    if (dot>997999||dot==0){map2[arr[1]][arr[2]][(arr[3]+1)]=r;}} catch (Exception e2) {}}//w
                if (arr[31]==1||arr[31]==5) {try {  dot =map2[arr[1]][(arr[2]+1)][arr[3]];
                    if (dot>997999||dot==0) {map2[arr[1]][(arr[2]+1)][arr[3]]=r;}} catch (Exception e2) {}}//n
                if (arr[31]==2||arr[31]==6) {try { dot = map2[arr[1]][arr[2]][(arr[3]-1)];
                    if (dot>997999||dot==0){map2[arr[1]][arr[2]][(arr[3]-1)]=r;}} catch (Exception e2) {}}//e
                if (arr[31]==3||arr[31]==7) {try { dot = map2[arr[1]][(arr[2]-1)][arr[3]];
                    if (dot>997999||dot==0){map2[arr[1]][(arr[2]-1)][arr[3]]=r;}} catch (Exception e2) {}}//s
            }}

        if (arr[30]==5){//if tunnel
            int r = 998000;if (arr[1]<mapheight-3){//no roof for tunnel -1 lvl down peak, only deeper
                if (arr[31]==0||arr[31]==4) {try {map2[arr[1]][arr[2]][(arr[3]-1)]=0;
                    map2[arr[1]+1][arr[2]][(arr[3]-1)]=r;
                    map2[arr[1]+1][arr[2]-1][(arr[3]-1)]=r;
                    map2[arr[1]+1][arr[2]+1][(arr[3]-1)]=r;
                } catch (Exception e2) {}}//west

                if (arr[31]==2||arr[31]==6) {try {map2[arr[1]][arr[2]][(arr[3]+1)]=0;
                    map2[arr[1]+1][arr[2]][(arr[3]+1)]=r;
                    map2[arr[1]+1][arr[2]-1][(arr[3]+1)]=r;
                    map2[arr[1]+1][arr[2]+1][(arr[3]+1)]=r;
                } catch (Exception e2) {}}//east

                if (arr[31]==1||arr[31]==5) {try {map2[arr[1]][arr[2]-1][(arr[3])]=0;
                    map2[arr[1]+1][arr[2]-1][(arr[3])]=r;
                    map2[arr[1]+1][arr[2]-1][(arr[3]-1)]=r;
                    map2[arr[1]+1][arr[2]-1][(arr[3]+1)]=r;
                } catch (Exception e2) {}}//north

                if (arr[31]==3||arr[31]==7) {try {map2[arr[1]][arr[2]+1][(arr[3])]=0;
                    map2[arr[1]+1][arr[2]+1][(arr[3])]=r;
                    map2[arr[1]+1][arr[2]+1][(arr[3]-1)]=r;
                    map2[arr[1]+1][arr[2]+1][(arr[3]+1)]=r;
                } catch (Exception e2) {}}//south
            }}

        if (arr[30]==7){//if l-d turn
            int r = 998000;if (arr[1]<mapheight-3) {//no roof for turn -1 lvl down peak, only deeper
                int z =arr[1]; int y =arr[2]; int x =arr[3];
                if (arr[31]==2) {try {
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x+1]=r;
                    map2[z+1][y-1][x+2]=r;
                    map2[z+1][y-1][x+3]=r;
                    map2[z+1][y-2][x+1]=r;
                    map2[z+1][y][x+1]=r;
                    map2[z+1][y+1][x+1]=r;
                    map2[z][y][x+1]=0;
                    map2[z][y-1][x+1]=0;
                    map2[z][y-1][x+2]=0;
                } catch (Exception e2) {}}//east

                if (arr[31]==3) {try {
                    x=x-2; y = y+2;
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x+1]=r;
                    map2[z+1][y-1][x+2]=r;
                    map2[z+1][y-1][x+3]=r;
                    map2[z+1][y-2][x+1]=r;
                    map2[z+1][y][x+1]=r;
                    map2[z+1][y+1][x+1]=r;
                    map2[z][y][x+1]=0;
                    map2[z][y-1][x+1]=0;
                    map2[z][y-1][x+2]=0;
                } catch (Exception e2) {}}//south

            }}

        if (arr[30]==8){//if r-u turn
            int r = 998000;if (arr[1]<mapheight-3) {//no roof for turn -1 lvl down peak, only deeper
                int z =arr[1]; int y =arr[2]; int x =arr[3];
                if (arr[31]==0) {try {
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x-1]=r;
                    map2[z+1][y-1][x-2]=r;
                    map2[z+1][y-1][x-3]=r;
                    map2[z+1][y-2][x-1]=r;
                    map2[z+1][y][x-1]=r;
                    map2[z+1][y+1][x-1]=r;
                    map2[z][y][x-1]=0;
                    map2[z][y-1][x-1]=0;
                    map2[z][y-1][x-2]=0;
                } catch (Exception e2) {}}//west

                if (arr[31]==3) {try {
                    x=x+2; y = y+2;
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x-1]=r;
                    map2[z+1][y-1][x-2]=r;
                    map2[z+1][y-1][x-3]=r;
                    map2[z+1][y-2][x-1]=r;
                    map2[z+1][y][x-1]=r;
                    map2[z+1][y+1][x-1]=r;
                    map2[z][y][x-1]=0;
                    map2[z][y-1][x-1]=0;
                    map2[z][y-1][x-2]=0;
                } catch (Exception e2) {}}//south
            }}

        if (arr[30]==9){//if u-r turn
            int r = 998000;if (arr[1]<mapheight-3) {//no roof for turn -1 lvl down peak, only deeper
                int z =arr[1]; int y =arr[2]; int x =arr[3];
                if (arr[31]==1) {try {
                    map2[z+1][y][x+1]=r;
                    map2[z+1][y-1][x+1]=r;
                    map2[z+1][y-2][x+1]=r;
                    map2[z+1][y-3][x+1]=r;//
                    map2[z+1][y-1][x+2]=r;
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x-1]=r;
                    map2[z][y-1][x]=0;
                    map2[z][y-1][x+1]=0;
                    map2[z][y-2][x+1]=0;
                } catch (Exception e2) {}}//north

                if (arr[31]==0) {try {
                    x=x-2; y = y+2;
                    map2[z+1][y][x+1]=r;
                    map2[z+1][y-1][x+1]=r;
                    map2[z+1][y-2][x+1]=r;
                    map2[z+1][y-3][x+1]=r;//
                    map2[z+1][y-1][x+2]=r;
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x-1]=r;
                    map2[z][y-1][x]=0;
                    map2[z][y-1][x+1]=0;
                    map2[z][y-2][x+1]=0;
                } catch (Exception e2) {}}//west
            }}

        if (arr[30]==10){//if r-d turn
            int r = 998000;if (arr[1]<mapheight-3) {//no roof for turn -1 lvl down peak, only deeper
                int z =arr[1]; int y =arr[2]; int x =arr[3];

                if (arr[31]==1) {try {
                    map2[z+1][y][x-1]=r;
                    map2[z+1][y-1][x-1]=r;
                    map2[z+1][y-2][x-1]=r;
                    map2[z+1][y-3][x-1]=r;//
                    map2[z+1][y-1][x-2]=r;
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x+1]=r;
                    map2[z][y-1][x]=0;
                    map2[z][y-1][x-1]=0;
                    map2[z][y-2][x-1]=0;
                } catch (Exception e2) {}}//north

                if (arr[31]==2) {try {
                    x=x+2; y = y+2;
                    map2[z+1][y][x-1]=r;
                    map2[z+1][y-1][x-1]=r;
                    map2[z+1][y-2][x-1]=r;
                    map2[z+1][y-3][x-1]=r;//
                    map2[z+1][y-1][x-2]=r;
                    map2[z+1][y-1][x]=r;
                    map2[z+1][y-1][x+1]=r;
                    map2[z][y-1][x]=0;
                    map2[z][y-1][x-1]=0;
                    map2[z][y-2][x-1]=0;
                } catch (Exception e2) {}}//east
            }}

        if (arr[30]==6){//dig down
            int r = 998000;if (arr[1]<mapheight-1) {//from peak
                int z =arr[1]; int y =arr[2]; int x =arr[3];

                if (arr[31]==0||arr[31]==0+4) {try {
                    if (arr[1]<mapheight-3) {//no roof for peak and lvl down
                        map2[z+1][y-1][x-1]=r;
                        map2[z+1][y][x-1]=r;
                        map2[z+1][y+1][x-1]=r;}//
                    if (arr[1]<mapheight-2) {//no blocks on same lvl as peak
                        map2[z][y-1][x-1]=r;
                        map2[z][y+1][x-1]=r;
                        map2[z][y][x-2]=r;}
                    map2[z][y][x-1]=0;
                    map2[z-1][y][x-1]=0;
                } catch (Exception e2) {}}//west

                if (arr[31]==2||arr[31]==2+4) {try {
                    if (arr[1]<mapheight-3) {//no roof for peak and lvl down
                        map2[z+1][y-1][x+1]=r;
                        map2[z+1][y][x+1]=r;
                        map2[z+1][y+1][x+1]=r;}//
                    if (arr[1]<mapheight-2) {//no blocks on same lvl as peak
                        map2[z][y-1][x+1]=r;
                        map2[z][y+1][x+1]=r;
                        map2[z][y][x+2]=r;}
                    map2[z][y][x+1]=0;
                    map2[z-1][y][x+1]=0;
                } catch (Exception e2) {}}//east

                if (arr[31]==1||arr[31]==1+4) {try {
                    if (arr[1]<mapheight-3) {//no roof for peak and lvl down
                        map2[z+1][y-1][x-1]=r;
                        map2[z+1][y-1][x]=r;
                        map2[z+1][y-1][x+1]=r;}//
                    if (arr[1]<mapheight-2) {//no blocks on same lvl as peak
                        map2[z][y-1][x-1]=r;
                        map2[z][y-1][x+1]=r;
                        map2[z][y-2][x]=r;}
                    map2[z][y-1][x]=0;
                    map2[z-1][y-1][x]=0;
                } catch (Exception e2) {}}//north

                if (arr[31]==3||arr[31]==3+4) {try {
                    if (arr[1]<mapheight-3) {//no roof for peak and lvl down
                        map2[z+1][y+1][x-1]=r;
                        map2[z+1][y+1][x]=r;
                        map2[z+1][y+1][x+1]=r;}//
                    if (arr[1]<mapheight-2) {//no blocks on same lvl as peak
                        map2[z][y+1][x-1]=r;
                        map2[z][y+1][x+1]=r;
                        map2[z][y+2][x]=r;}
                    map2[z][y+1][x]=0;
                    map2[z-1][y+1][x]=0;
                } catch (Exception e2) {}}//south

            }}//dig down end

        if (arr[30]==11){//dig up
            int r = 998000;if (arr[1]<mapheight-1) {//from peak
                int z =arr[1]; int y =arr[2]; int x =arr[3];

                if (arr[31]==0||arr[31]==0+4) {try {
                    if (arr[1]<mapheight-4) {//no roof for peak and lvl down
                        map2[z+2][y-1][x-1]=r;
                        map2[z+2][y][x-1]=r;
                        map2[z+2][y+1][x-1]=r;
                        map2[z+2][y-1][x-2]=r;
                        map2[z+2][y][x-2]=r;
                        map2[z+2][y+1][x-2]=r;}
                    if (arr[1]<mapheight-3) {//no blocks on same lvl as peak
                        map2[z+1][y-1][x-1]=r;
                        map2[z+1][y-1][x-2]=r;
                        map2[z+1][y+1][x-1]=r;
                        map2[z+1][y+1][x-2]=r;}
                    map2[z][y][x-1]=0;
                    map2[z+1][y][x-1]=0;
                    map2[z+1][y][x-2]=0;
                } catch (Exception e2) {}}//west

                if (arr[31]==2||arr[31]==2+4) {try {
                    if (arr[1]<mapheight-4) {//no roof for peak and lvl down
                        map2[z+2][y-1][x+1]=r;
                        map2[z+2][y][x+1]=r;
                        map2[z+2][y+1][x+1]=r;
                        map2[z+2][y-1][x+2]=r;
                        map2[z+2][y][x+2]=r;
                        map2[z+2][y+1][x+2]=r;}
                    if (arr[1]<mapheight-3) {//no blocks on same lvl as peak
                        map2[z+1][y-1][x+1]=r;
                        map2[z+1][y-1][x+2]=r;
                        map2[z+1][y+1][x+1]=r;
                        map2[z+1][y+1][x+2]=r;}
                    map2[z][y][x+1]=0;
                    map2[z+1][y][x+1]=0;
                    map2[z+1][y][x+2]=0;
                } catch (Exception e2) {}}//east

                if (arr[31]==1||arr[31]==1+4) {try {
                    if (arr[1]<mapheight-4) {//no roof for peak and lvl down
                        map2[z+2][y-1][x-1]=r;
                        map2[z+2][y-1][x]=r;
                        map2[z+2][y-1][x+1]=r;
                        map2[z+2][y-2][x-1]=r;
                        map2[z+2][y-2][x]=r;
                        map2[z+2][y-2][x+1]=r;}
                    if (arr[1]<mapheight-3) {//no blocks on same lvl as peak
                        map2[z+1][y-1][x-1]=r;
                        map2[z+1][y-2][x-1]=r;
                        map2[z+1][y-1][x+1]=r;
                        map2[z+1][y-2][x+1]=r;}
                    map2[z][y-1][x]=0;
                    map2[z+1][y-1][x]=0;
                    map2[z+1][y-2][x]=0;
                } catch (Exception e2) {}}//north

                if (arr[31]==3||arr[31]==3+4) {try {
                    if (arr[1]<mapheight-4) {//no roof for peak and lvl down
                        map2[z+2][y+1][x-1]=r;
                        map2[z+2][y+1][x]=r;
                        map2[z+2][y+1][x+1]=r;
                        map2[z+2][y+2][x-1]=r;
                        map2[z+2][y+2][x]=r;
                        map2[z+2][y+2][x+1]=r;}
                    if (arr[1]<mapheight-3) {//no blocks on same lvl as peak
                        map2[z+1][y+1][x-1]=r;
                        map2[z+1][y+2][x-1]=r;
                        map2[z+1][y+1][x+1]=r;
                        map2[z+1][y+2][x+1]=r;}
                    map2[z][y+1][x]=0;
                    map2[z+1][y+1][x]=0;
                    map2[z+1][y+2][x]=0;
                } catch (Exception e2) {}}//south

            }}
        phcal();
        pane.drawf();
        //JOptionPane.showMessageDialog(null, arr[30]+" "+arr[31], "dig", JOptionPane.PLAIN_MESSAGE);
    }

    public static void engdig3(int i){//eng go if unlim
        int arr []; arr = (int[]) unitlist.get(i);
        if (arr[31]<4){arr[30]=0;arr[31]=0;arr[32]=0;}
        unitlist.set(i, arr);
        if (arr[31]<4){}else{//cont dig

            if(arr[30]!=6&&arr[30]!=11){//if not up/down start
                int step=-1; int step2=-1; int step3=-1;
                if (arr[31]==4){{try {step= map2[arr[1]][arr[2]][(arr[3]-1)];
                    step3= map2[arr[1]+1][arr[2]][(arr[3]-1)];
                    step2= map2[arr[1]-1][arr[2]][(arr[3]-1)];
                } catch (Exception e2) {}} }//west

                if (arr[31]==5){{try {step= map2[arr[1]][arr[2]-1][(arr[3])];
                    step3= map2[arr[1]+1][arr[2]-1][(arr[3])];
                    step2= map2[arr[1]-1][arr[2]-1][(arr[3])];
                } catch (Exception e2) {}} }//north

                if (arr[31]==6){{try {step= map2[arr[1]][arr[2]][(arr[3]+1)];
                    step3= map2[arr[1]+1][arr[2]][(arr[3]+1)];
                    step2= map2[arr[1]-1][arr[2]][(arr[3]+1)];
                } catch (Exception e2) {}} }//east

                if (arr[31]==7){{try {step= map2[arr[1]][arr[2]+1][(arr[3])];
                    step3= map2[arr[1]+1][arr[2]+1][(arr[3])];
                    step2= map2[arr[1]-1][arr[2]+1][(arr[3])];
                } catch (Exception e2) {}} }//south

                if (step2==-1){step2= 998000;}         //if bottom
                if (arr[30]==3||arr[30]==4)//if void1 or rock 1 rock roof doesn't matter
                {step3= 998000;}

                if (step==0&&step2>997999&&step3>997999){
                    if (arr[31]==4) {arr[11]=arr[1]; arr[12]=arr[2]; arr[13]=arr[3]-1;}
                    if (arr[31]==5) {arr[11]=arr[1]; arr[12]=arr[2]-1; arr[13]=arr[3];}
                    if (arr[31]==6) {arr[11]=arr[1]; arr[12]=arr[2]; arr[13]=arr[3]+1;}
                    if (arr[31]==7) {arr[11]=arr[1]; arr[12]=arr[2]+1; arr[13]=arr[3];}
                }else{
                    // arr[30]=0;arr[31]=0;arr[32]=0;
                    engdig(i);
                }
                unitlist.set(i, arr);
            }//if not up/down  end
            else {//up down start
                int step=-1; int step2=-1; int step3=-1; int step4=-1;

                if (arr[30]==6){
                    if (arr[31]==4){{try {step= map2[arr[1]-1][arr[2]][(arr[3]-1)];
                        step3= map2[arr[1]][arr[2]][(arr[3]-1)];
                        step2= map2[arr[1]-2][arr[2]][(arr[3]-1)];
                    } catch (Exception e2) {}} }//west

                    if (arr[31]==6){{try {step= map2[arr[1]-1][arr[2]][(arr[3]+1)];
                        step3= map2[arr[1]][arr[2]][(arr[3]+1)];
                        step2= map2[arr[1]-2][arr[2]][(arr[3]+1)];
                    } catch (Exception e2) {}} }//east

                    if (arr[31]==5){{try {step= map2[arr[1]-1][arr[2]-1][(arr[3])];
                        step3= map2[arr[1]][arr[2]-1][(arr[3])];
                        step2= map2[arr[1]-2][arr[2]-1][(arr[3])];
                    } catch (Exception e2) {}} }//north

                    if (arr[31]==7){{try {step= map2[arr[1]-1][arr[2]+1][(arr[3])];
                        step3= map2[arr[1]][arr[2]+1][(arr[3])];
                        step2= map2[arr[1]-2][arr[2]+1][(arr[3])];
                    } catch (Exception e2) {}} }//south
                }
                else{//if up look
                    if (arr[31]==4){{try {step= map2[arr[1]+1][arr[2]][(arr[3]-2)];
                        step3= map2[arr[1]][arr[2]][(arr[3]-1)];
                        step4= map2[arr[1]+1][arr[2]][(arr[3]-1)];
                        step2= map2[arr[1]][arr[2]][(arr[3]-2)];
                    } catch (Exception e2) {}} }//west

                    if (arr[31]==6){{try {step= map2[arr[1]+1][arr[2]][(arr[3]+2)];
                        step3= map2[arr[1]][arr[2]][(arr[3]+1)];
                        step4= map2[arr[1]+1][arr[2]][(arr[3]+1)];
                        step2= map2[arr[1]][arr[2]][(arr[3]+2)];
                    } catch (Exception e2) {}} }//east

                    if (arr[31]==5){{try {step= map2[arr[1]+1][arr[2]-2][(arr[3])];
                        step3= map2[arr[1]][arr[2]-1][(arr[3])];
                        step4= map2[arr[1]+1][arr[2]-1][(arr[3])];
                        step2= map2[arr[1]][arr[2]-2][(arr[3])];
                    } catch (Exception e2) {}} }//north

                    if (arr[31]==7){{try {step= map2[arr[1]+1][arr[2]+2][(arr[3])];
                        step3= map2[arr[1]][arr[2]+1][(arr[3])];
                        step4= map2[arr[1]+1][arr[2]+1][(arr[3])];
                        step2= map2[arr[1]][arr[2]+2][(arr[3])];
                    } catch (Exception e2) {}} }//south
                }//if up look end

                if (step2==-1){step2= 998000;}         //if bottom
                if (arr[30]==6){step4=0;}//for down step4 does not matter

                if (step==0&&step2>997999&&step3==0&&step4==0){
                    if (arr[30]==6){
                        if (arr[31]==4) {arr[11]=arr[1]-1; arr[12]=arr[2]; arr[13]=arr[3]-1;}
                        if (arr[31]==6) {arr[11]=arr[1]-1; arr[12]=arr[2]; arr[13]=arr[3]+1;}
                        if (arr[31]==5) {arr[11]=arr[1]-1; arr[12]=arr[2]-1; arr[13]=arr[3];}
                        if (arr[31]==7) {arr[11]=arr[1]-1; arr[12]=arr[2]+1; arr[13]=arr[3];}
                    }else{//if up go
                        if (arr[31]==4) {arr[11]=arr[1]+1; arr[12]=arr[2]; arr[13]=arr[3]-2;}
                        if (arr[31]==6) {arr[11]=arr[1]+1; arr[12]=arr[2]; arr[13]=arr[3]+2;}
                        if (arr[31]==5) {arr[11]=arr[1]+1; arr[12]=arr[2]-2; arr[13]=arr[3];}
                        if (arr[31]==7) {arr[11]=arr[1]+1; arr[12]=arr[2]+2; arr[13]=arr[3];}
                    }//if up go end

                }else{
                    // arr[30]=0;arr[31]=0;arr[32]=0;
                    engdig(i);
                }
                unitlist.set(i, arr);

            }//up down end
        }//cont dig end
    }//eng unlim end

    private static JDialog createDialog2(final JFrame frame){ //big menu start


        int h = hegihtpix;
        int w = widthpix;
        w=3*w/4+d;
        final JDialog modelDialog = new JDialog(frame, "menu",
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(w-4, (int)(2.1*d), (int)(3.2*d)+15, (int)(6.4*d));
        Container dialogContainer = modelDialog.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(13,1,1,1));

        JButton un = new JButton(" cancel ");
        un.setBackground(new Color(255, 255, 100));
        un.setBounds(0,0,2*d,d/2);
        un.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
                bigmenuon=0;
                modelDialog.setVisible(false);
                redrawmenu();
            }
        });
        panel1.add(un);

        JLabel text0 = new JLabel("   MENU");
        text0.setFont(new Font("Arial", Font.BOLD, 14));
        text0.setForeground(new Color(175, 65, 175));
        panel1.add(text0);

        if (mpgamerunning==0) {
            JButton un11 = new JButton(" fast battle ");
            un11.setBackground(new Color(255, 0, 0));
            un11.setForeground(new Color(0, 0, 0));
            un11.setBounds(0,0,2*d,d/2);
            un11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,
                            new String[] {"Current process terminated, running in new game mode.",
                                    "You may click on menu area, when loaded. info in menu can help."},
                            "fast battle",
                            JOptionPane.PLAIN_MESSAGE);
                    bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                    fastbattle();
                }
            });
            panel1.add(un11);

            JButton un7 = new JButton(" create new map ");
            un7.setBackground(new Color(0, 0, 255));
            un7.setForeground(new Color(255, 255, 255));
            un7.setBounds(0,0,2*d,d/2);
            un7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                    crmet();
                }
            });
            panel1.add(un7);

            JButton un8 = new JButton(" creative mode ");
            un8.setBackground(new Color(0, 0, 255));
            un8.setForeground(new Color(255, 255, 255));
            un8.setBounds(0,0,2*d,d/2);
            un8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (mapdev==0){
                        if (mp==0){
//
                            FileDialog dialog = new FileDialog((Frame)null, "Select map");
                            dialog.setFile("*.txt");
                            dialog.setMode(FileDialog.LOAD);
                            dialog.setVisible(true);
                            String file = dialog.getFile();

                            if (file==null){
                                JOptionPane.showMessageDialog(null, " current game terminated, running in new creative mode", "i", JOptionPane.PLAIN_MESSAGE);
                                mapdev=1; bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                                if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
                            }else{
                                //   System.out.println(file);
                                if (file.equals("options.txt")){
                                    JOptionPane.showMessageDialog(null, "options.txt is not a map!", "e", JOptionPane.PLAIN_MESSAGE);
                                }else{
                                    JOptionPane.showMessageDialog(null, " current game terminated, running in new creative mode", "i", JOptionPane.PLAIN_MESSAGE);
                                    filep = "./"+file;
                                    mapdev=1; bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                                    loadm();
                                    //    System.out.println(filep);
                                }
                            }
                            //
                        }else{
                            JOptionPane.showMessageDialog(null, "no creative mode in multiplayer", "e", JOptionPane.PLAIN_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "you are already in creative mode", "e", JOptionPane.PLAIN_MESSAGE);
                    }

                }//
            });
            panel1.add(un8);

            JButton un10 = new JButton(" extra ");
            un10.setBackground(new Color(200, 200, 200));
            un10.setBounds(0,0,2*d,d/2);
            un10.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    extrago();
                }
            });
            panel1.add(un10);

            JButton un9 = new JButton(" game mode ");
            un9.setBackground(new Color(0, 0, 0));
            un9.setForeground(new Color(255, 255, 255));
            un9.setBounds(0,0,2*d,d/2);
            un9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (mapdev==1){
                        if (mp==0){
//
                            brush=-1;
                            FileDialog dialog = new FileDialog((Frame)null, "Select map");
                            dialog.setFile("*.txt");
                            dialog.setMode(FileDialog.LOAD);
                            dialog.setVisible(true);
                            String file = dialog.getFile();

                            if (file==null){
                                mapdev=0; bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                                if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
                                // JOptionPane.showMessageDialog(null, " current process terminated, running in new game mode", "i", JOptionPane.PLAIN_MESSAGE);
                            }else{
                                //   System.out.println(file);
                                if (file.equals("options.txt")){
                                    JOptionPane.showMessageDialog(null, "options.txt is not a map!", "e", JOptionPane.PLAIN_MESSAGE);
                                }else{
                                    filep = "./"+file;
                                    mapdev=0; bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                                    loadm();
// JOptionPane.showMessageDialog(null, " current process terminated, running in new game mode", "i", JOptionPane.PLAIN_MESSAGE);
                                    //    System.out.println(filep);
                                }
                            }
                            //
                        }else{
                            JOptionPane.showMessageDialog(null, "strange. no game mode in multiplayer", "error", JOptionPane.PLAIN_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "you are already in game mode", "e", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            });
            panel1.add(un9);

            JButton un4 = new JButton(" load ");
            un4.setBackground(new Color(200, 200, 200));
            un4.setBounds(0,0,2*d,d/2);
            un4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FileDialog dialog = new FileDialog((Frame)null, "Select map");
                    dialog.setFile("*.txt");
                    dialog.setMode(FileDialog.LOAD);
                    dialog.setVisible(true);
                    String file = dialog.getFile();

                    if (file==null){
                        //  System.out.println("zero");
                    }else{
                        //   System.out.println(file);
                        if (file.equals("options.txt")){
                            JOptionPane.showMessageDialog(null, "options.txt is not a map!", "e", JOptionPane.PLAIN_MESSAGE);
                        }else{
                            filep = "./"+file;
                            bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                            loadm();
                            //    System.out.println(filep);
                        }
                    }

                    // if (mp==0){timeron = 1;timergo();} bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                }
            });
            panel1.add(un4);
        }

        JButton un3 = new JButton(" info ");
        un3.setBackground(new Color(200, 200, 200));
        un3.setBounds(0,0,2*d,d/2);
        un3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sol4 sol4 = new Sol4();
                // if (mp==0){timeron = 1;timergo();} bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
            }
        });
        panel1.add(un3);

        JButton un5 = new JButton(" save as");
        un5.setBackground(new Color(200, 200, 200));
        un5.setBounds(0,0,2*d,d/2);
        un5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dialog = new FileDialog((Frame)null, "Save map as *.txt");
                dialog.setFile("*.txt");
                dialog.setMode(FileDialog.SAVE);
                dialog.setVisible(true);
                String file = dialog.getFile();

                if (file==null){
                    //  System.out.println("zero");
                }else{
                    //   System.out.println(file);
                    if (file.equals("options.txt")||file.equals("options")){
                        JOptionPane.showMessageDialog(null, "options.txt is not a map!", "e", JOptionPane.PLAIN_MESSAGE);
                    }else{
                        if (file.equals("map.txt")||file.equals("map")){
                            JOptionPane.showMessageDialog(null, "map.txt is for quick save/load, try another name", "e", JOptionPane.PLAIN_MESSAGE);
                        }else {
                            filep = "./" + file;
                            if (filep.contains(".txt")){}else{filep=filep+".txt";}
                            bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                            savem();
                            //  System.out.println(filep);
                        }
                    }
                }
            }//
        });
        panel1.add(un5);

        JButton un12 = new JButton(" options ");
        un12.setBackground(new Color(200, 200, 200));
        // un12.setForeground(new Color(0, 0, 0));
        un12.setBounds(0,0,2*d,d/2);
        un12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                Sol5 sol5 = new Sol5();
            }
        });
        panel1.add(un12);

        JButton un6 = new JButton(" multiplayer ");
        un6.setBackground(new Color(200, 190, 230));
        un6.setBounds(0,0,2*d,d/2);
        un6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigmenuon=0; modelDialog.setVisible(false); redrawmenu();
                final JDialog modelDialog = createDialog3(jFrame);
                modelDialog.setVisible(true);
            }
        });
        panel1.add(un6);

        JButton un2 = new JButton(" quit to OS");
        un2.setBackground(new Color(0, 255, 0));
        un2.setForeground(new Color(0, 0, 0));
        un2.setBounds(0,0,2*d,d/2);
        un2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigmenuon=0;
                modelDialog.setVisible(false);
                redrawmenu();
                pause = 1; System.exit(0);
            }
        });
        panel1.add(un2);

        dialogContainer.add(panel1);
        modelDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        modelDialog.setUndecorated(true);
        return modelDialog;
    }//big menu end


    public static void   extrago(){
        JOptionPane.showMessageDialog(null, "by OlegTim", "extra", JOptionPane.PLAIN_MESSAGE);
    }

    public static void   fastbattle(){
        mapdev=0;
        brush=0;    fillall();         timeron=0;
        unitlist.clear();  buildlist.clear();  reslist.clear();

        mapname = "fast";
        mapheight =12;
        mapwidth = 40;
        maplength = 40;

        moneypl1=300;     moneypl2=300;

        map4 = new int[mapheight][mapwidth][maplength];
        map3 = new int[mapheight][mapwidth][maplength];
        map2 = new int[mapheight][mapwidth][maplength];
        for (int i = mapheight-1; i >-1; i--) {
            for (int j = 0; j < mapwidth; j++) {
                for (int k = 0; k < maplength; k++) {
                    map2[i][j][k] = 0 ;
                }
            }
        }

        for (int i = 0; i < mapheight; i++){
            for ( int j = 0; j < mapwidth; j++){
                for ( int k = 0; k < maplength; k++){
                    if (i == mapheight - 1 || i == mapheight - 2) {
                        map2[i][j][k] = 0;
                    } else {
                        map2[i][j][k] = 998000; //0-9 z blocks
                    }}}}

        map2[9][0][0] = 0 ;  map2[9][0][1] = 0 ;
        map2[9][1][0] = 0 ;  map2[9][1][1] = 0 ; map2[9][2][0] = 0 ;
        map2[9][13][13] = 0 ;  map2[9][13][14] = 0 ;
        map2[9][14][13] = 0 ;  map2[9][14][14] = 0 ;
        map2[9][15][13] = 0 ;  map2[9][15][14] = 0 ;

        int arrv[] = new int[4];  int arrv2[] = new int[4]; int arrv3[] = new int[4];
        arrv[0]=0;    arrv[1]=0;    arrv[2]=resrich ;
        reslist.add(arrv);
        arrv2[0]=0;    arrv2[1]=13;    arrv2[2]=resrich ;
        reslist.add(arrv2);
        arrv3[0]=13;    arrv3[1]=13;    arrv3[2]=resrich ;
        reslist.add(arrv3);

        loading = 1;
        Unit unit = new Unit();

        brush = 1001; unit.z = 9; unit.y = 0; unit.x = 0;
        unit.go();
        brush = 1003; unit.z = 9; unit.y = 0; unit.x = 1;
        unit.go();
        brush = 3001; unit.z = 9; unit.y = 13; unit.x = 13;
        unit.go();
        brush = 3003; unit.z = 9; unit.y = 13; unit.x = 14;
        unit.go();

        brush = 3; unit.z = 10; unit.y = 0; unit.x = 2;
        unit.go();
        brush = 1005; unit.z = 10; unit.y = 2; unit.x = 2;
        unit.go();
        brush = 1006; unit.z = 10; unit.y = 3; unit.x = 1;
        unit.go();
        brush = 1008; unit.z = 9; unit.y = 1; unit.x = 0;
        unit.go();
        brush = 4001; unit.z = 9; unit.y = 2; unit.x = 1;
        unit.go();

        brush = 2003; unit.z = 10; unit.y = 13; unit.x = 11;
        unit.go();
        brush = 3005; unit.z = 10; unit.y = 13; unit.x = 12;
        unit.go();
        brush = 3006; unit.z = 10; unit.y = 12; unit.x = 13;
        unit.go();
        brush = 3008; unit.z = 9; unit.y = 14; unit.x = 13;
        unit.go();
        brush = 4001; unit.z = 9; unit.y = 15; unit.x = 14;
        unit.go();

        brush=-1;
        loading = 0;

        phcal();
        zpos = mapheight; ewpos=0;nspos=0; transparentview=0; brush = -1;   brush0();
        if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
        text1s = "GO! click here";
        redrawmainfield();
    }//fast end

    public   static void  getai(){
        String s  =smallField2.getText();
        smallField2.setText("");
        contents2.dispose();
        int t=-1;
        try {t =    Integer.parseInt(s);} catch (Exception e){}
        if (t!=-1){
            if (t>1&&t<51)     {
                aihard=t;

                optionswrite();

                if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
            }
            else{ JOptionPane.showMessageDialog(null, "AI level is not from 2 to 50", "e", JOptionPane.PLAIN_MESSAGE);}
        }
    }//get Ai end

    public   static void   gamefin(){
        if(mpexit==1||mpexit==0){//for mp and single
            Sol8 sol8 = new Sol8();
            try{  Thread.sleep(5000);} catch (Exception e){}
            System.exit(0);}

        int   game_end2 = game_end;
        int   game_end3=iampl2;

        game_end=0;
        mapdev=0;

        brush=0;    fillall();         timeron=0;
        unitlist.clear();  buildlist.clear();  reslist.clear();

        mapname = "m";
        mapheight =12;
        mapwidth = 12;
        maplength = 12;

        moneypl1=100;     moneypl2=100;

        map4 = new int[mapheight][mapwidth][maplength];
        map3 = new int[mapheight][mapwidth][maplength];
        map2 = new int[mapheight][mapwidth][maplength];
        for (int i = mapheight-1; i >-1; i--) {
            for (int j = 0; j < mapwidth; j++) {
                for (int k = 0; k < maplength; k++) {
                    map2[i][j][k] = 0 ;
                }
            }
        }
        brush=-1;
        loading = 0;

        phcal();
        zpos = mapheight; ewpos=0;nspos=0; transparentview=0; brush = -1;
        if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
        text1s = "";

        finmsg(game_end2,game_end3);
        menutimer="";
        //  System.out.println(mpexit);
        menugo();
    }
    public static void testout(){
        Sol6 sol6 = new Sol6();
    }

    public static void finmsg(int i,int b){
        if (i==1||i==2){//which of pl lost all hq (for example, "1" pl1 has zero hq and pl2 has 1-2 hq
            if (b==0){//if pl on this computer is pl1
                if (i==1){fail();}
                if (i==2){win();}
            }else{
                if (i==2){fail();}
                if (i==1){win();}
            }
        }}

    public static void win(){
        JOptionPane.showMessageDialog(null, "victory", "game final", JOptionPane.INFORMATION_MESSAGE );
    }

    public static void fail(){
        JOptionPane.showMessageDialog(null, "fail!", "game final", JOptionPane.WARNING_MESSAGE);
    }

    public static void terminatemp(){
        System.exit(0);
    }

    public static void newserv(){
        // JOptionPane.showMessageDialog(null, "newserv", "w", JOptionPane.PLAIN_MESSAGE);
        aipl2=0;  mp=1; iampl2=0; singleselect=666; mapdev=0;
        timerstep();
    }

    public static void connectserv(){
        // JOptionPane.showMessageDialog(null, "connectserv", "w", JOptionPane.PLAIN_MESSAGE);
        aipl2=0;   mp=1; iampl2=1; phflag=0; singleselect=666; mapdev=0;
        if (clientSocket==null){
            Client client = new Client();
            new Thread(client).start();}
        redrawmenu();
    }

    public   static void   gamefinmp(){
        if (iampl2==0){//if I am server
            servbye="bye"+game_end;
        }}

    private static JDialog createDialog3(final JFrame frame){ //mp menu start

        int h = hegihtpix;
        int w = widthpix;
        w=3*w/4+d;
        final JDialog modelDialog = new JDialog(frame, "mp menu",
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(w-8, 0, (int)(3.2*d)+15, (int)(8.5*d));
        Container dialogContainer = modelDialog.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(10,1,1,1));

        JButton un = new JButton(" cancel ");
        un.setBackground(new Color(255, 255, 100));
        un.setBounds(0,0,2*d,d/2);
        un.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
                bigmenuon=0;
                modelDialog.setVisible(false);
                redrawmenu();
            }
        });
        panel1.add(un);

        String mpstat="";
        if (mpgamerunning>0){ if (iampl2>0){mpstat="client";}else{mpstat="server";}}else{ mpstat=""; }
        JLabel text0 = new JLabel(" MP  MENU "+mpstat);
        text0.setFont(new Font("Arial", Font.BOLD, 14));
        text0.setForeground(new Color(175, 65, 175));
        panel1.add(text0);

        if (Sol.iampl2==0){
            JLabel text1= new JLabel(" local ip:");
            panel1.add(text1);
            //
            JTextArea display = new JTextArea ( 1,20 );
            display.setEditable ( false );
            display.append(" "+Sol.localip);
            panel1.add ( display );}

        if (mpgamerunning==0) {
            JButton button1 = new JButton("create mp game");
            button1.setBackground(new Color(200, 200, 200));
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    bigmenuon = 0;
                    modelDialog.setVisible(false);
                    redrawmenu();
                    Sol.newserv();
                }
            });
            panel1.add(button1);

            JButton button2 = new JButton("join mp game");
            button2.setBackground(new Color(200, 200, 200));
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    bigmenuon = 0;
                    modelDialog.setVisible(false);
                    redrawmenu();
                    Sol.connectserv();
                }
            });
            panel1.add(button2);

            JLabel text2= new JLabel(" connect to ip:");
            panel1.add(text2);

            smallField3 = new JTextField(16);
            smallField3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            smallField3.setText(ipserver);
            panel1.add(smallField3);

            JButton button3 = new JButton("change ip to connect");
            button3.setBackground(new Color(200, 200, 200));
            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ipserver =smallField3.getText();
                    ipserver=     ipserver.replaceAll("\\s+","");
                    smallField3.setText(ipserver);

                    optionswrite();

                    //     bigmenuon = 0; modelDialog.setVisible(false);
                    redrawmenu();
                }
            });
            panel1.add(button3);

        }//if mp game running end

        JButton un2 = new JButton(" terminate mp session");
        un2.setBackground(new Color(0, 255, 0));
        un2.setForeground(new Color(0, 0, 0));
        un2.setBounds(0,0,2*d,d/2);
        un2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigmenuon=0;
                modelDialog.setVisible(false);
                redrawmenu();
                pause = 1; System.exit(0);
            }
        });
        panel1.add(un2);

        dialogContainer.add(panel1);
        modelDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        modelDialog.setUndecorated(true);
        return modelDialog;
    }//mp menu end

    public static void  optionswrite(){
        String nl = "\r\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filep2))) {
            String s = blocksmumwidth+" "+d+" "+fscr+" "+xres+" "+yres+" "+aihard+" "+mapdot+" "
                    +timersleep+" " +portnum +" " +ipserver +" "+vertsliceall +" "+soundplay;
            writer.write(s);
            writer.write(nl);
            s = "blocks_num_screen "+"block_side(pix) "+"fullscreen(1yes;0no) "+"x_resolution y_resolution "+"AI_lvl "+"map_dot "
                    +"step(ms) " +"port "+"ipserver "+"vsliceall "+"soundplay ";
            writer.write(s);
            writer.write(nl);
            s="SPACE for params separation";
            writer.write(s);
            writer.close();
        }
        catch (IOException e2) {
            //     e.printStackTrace();
        }
    }//optionswrite end

    public static void vertsliceallmet(){
        smallField2.setText("");
        contents2.dispose();
        if (vertsliceall==1){vertsliceall=0;}else{vertsliceall=1;}
        optionswrite();
        redrawmenu();
        if (mp==0){if (mapdev==0){timeron = 1;timergo();}else{timeron = 0;}}
    }

    public static void soundmet(){
        smallField2.setText("");
        contents2.dispose();
        if (Sol.soundplay==1){Sol.soundplay=0;}else{Sol.soundplay=1;}
        optionswrite();
        redrawmenu();
 JOptionPane.showMessageDialog(null, "restart the program after OK",
         "sound options has changed", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
    public static void countscreenpix(){
        Rectangle r = jFrame.getBounds();
        hegihtpix  = r.height;
        widthpix  = r.width;
        vside = (hegihtpix/(blocksmumwidth*5))-2;
    }

    public static void brush0()    {xclick = 0; yclick = 0; xrel = 0; yrel = 0;
        mb_block_menu_z =0; mb_block_menu_y =0; mb_block_menu_x =0;}

    public static void cleanviewmet(){
        if (  specialview==3){
        }

        transparentview=0;
        specialview=0;
        isomShowBlocksOnly=0;
      //  nspossiom =0.0; ewpossiom =0.0;
    }

    public static void calcisomposmet(){
        if (  specialview==0){
        }
    }

    public static void upisom(){
        int ml = maplength; int mw = mapwidth;//change map width/length

        if (roll==315||roll==0){nspos-=1;}
        if (roll==135||roll==180){nspos+=1;}
        if (roll==225||roll==270){ewpos+=1;}
        if (roll==45||roll==90){ewpos-=1;}

 if  (nspos>=-blocksmumwidth/2&&nspos<=mw-blocksmumwidth/2&&ewpos>=-blocksmumwidth/2&&ewpos<=ml-blocksmumwidth/2){
        if (roll==315||roll==45||roll==135||roll==225){
        nspossiom-=0.5;
        ewpossiom -= 1.0;} else{
                nspossiom-=1;
        }}
    }
    public static void downisom(){
        int ml = maplength; int mw = mapwidth;//change map width/length

        if (roll==315||roll==0){nspos+=1;}
        if (roll==135||roll==180){nspos-=1;}
        if (roll==225||roll==270){ewpos-=1;}
        if (roll==45||roll==90){ewpos+=1;}

  if  (nspos>=-blocksmumwidth/2&&nspos<=mw-blocksmumwidth/2&&ewpos>=-blocksmumwidth/2&&ewpos<=ml-blocksmumwidth/2){
        if (roll==315||roll==45||roll==135||roll==225){
        nspossiom+=0.5;
        ewpossiom += 1.0;}else{
                nspossiom+=1;}}
    }
    public static void leftisom(){
        int ml = maplength; int mw = mapwidth;//change map width/length

        if (roll==315||roll==0){ewpos--;}
        if (roll==135||roll==180){ewpos++;}
        if (roll==225||roll==270){nspos-=1;}
        if (roll==45||roll==90){nspos+=1;}

 if  (nspos>=-blocksmumwidth/2&&nspos<=mw-blocksmumwidth/2&&ewpos>=-blocksmumwidth/2&&ewpos<=ml-blocksmumwidth/2){
        if (roll==315||roll==45||roll==135||roll==225){
        ewpossiom--;
        nspossiom +=0.5;}else{
                ewpossiom-=2.0;
                }}
    }
    public static void rightisom(){
        int ml = maplength; int mw = mapwidth;//change map width/length

        if (roll==315||roll==0){ewpos++;}
        if (roll==135||roll==180){ewpos--;}
        if (roll==225||roll==270){nspos+=1;}
        if (roll==45||roll==90){nspos-=1;}

 if  (nspos>=-blocksmumwidth/2&&nspos<=mw-blocksmumwidth/2&&ewpos>=-blocksmumwidth/2&&ewpos<=ml-blocksmumwidth/2){
        if (roll==315||roll==45||roll==135||roll==225){
        ewpossiom++;
        nspossiom -=0.5;}else{
                ewpossiom+=2.0;
                }}
    }

    public static void isomviewmet(){
        int n = nspos;   int e = ewpos;
        nspos = ewpos=0;

        int mw = mapwidth; //ns
        int ml = maplength; //ew

        if (roll==45){
            for (int i = 0; i <     mw-blocksmumwidth; i++){
                rightisom();   nspos = ewpos=0;}}

        if (roll==225){
            for (int i = 0; i <ml -blocksmumwidth; i++){
                downisom();   nspos = ewpos=0;}}

        if (maplength==mapwidth){
        if (roll==90){
            for (int i = 0; i <     mw-blocksmumwidth; i++){
rightisom();   nspos = ewpos=0;}}

        if (roll==135||roll==180){
            for (int i = 0; i <mw-blocksmumwidth; i++){
             rightisom();   nspos = ewpos=0;}
            for (int i = 0; i <ml-blocksmumwidth; i++){
                downisom();      nspos = ewpos=0;}}

        if (roll==270){
            for (int i = 0; i <ml -blocksmumwidth; i++){
                downisom();   nspos = ewpos=0;}}
}else{// if map not sqr
            if (roll==90){
                if   (mw<ml){
                    for (int i = 0; i <  (ml-mw)/2 +(mw-blocksmumwidth); i++){
                       rightisom();   nspos = ewpos=0;}
                }else{
                    for (int i = 0; i <  (mw-ml)/2 +(ml-blocksmumwidth); i++){
                        rightisom();   nspos = ewpos=0; }}
            }//90 end

            if (roll==270){
                if   (mw<ml){
                    for (int i = 0; i <  ml -blocksmumwidth; i++){
                        downisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  (ml-blocksmumwidth)/2 ; i++){
                       rightisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  (mw-blocksmumwidth)/2 ; i++){
                        leftisom(); nspos = ewpos=0;}
                }else{
                  //  System.out.println((mw-blocksmumwidth)/2);
                    for (int i = 0; i <  (mw-blocksmumwidth)/2 ; i++){
                        leftisom();   nspos = ewpos=0; }
                    for (int i = 0; i <  ml -blocksmumwidth; i++){
                        downisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  (ml -blocksmumwidth)/2; i++){
                        rightisom(); nspos = ewpos=0;}
                }
            }//270 end

            if (roll==180){
                if   (mw<ml){
                    for (int i = 0; i <  ml -blocksmumwidth; i++){
                        rightisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  mw -blocksmumwidth; i++){
                        downisom(); nspos = ewpos=0;}
                }else{
                    for (int i = 0; i <  ml -blocksmumwidth; i++){
                        rightisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  mw -blocksmumwidth; i++){
                        downisom(); nspos = ewpos=0;}
                }}//180 end

            if (roll==135){
                if   (mw<ml){
                    for (int i = 0; i <  ml -blocksmumwidth; i++){
                        rightisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  mw -blocksmumwidth; i++){
                        downisom(); nspos = ewpos=0;}
                }else{
                    for (int i = 0; i <  ml -blocksmumwidth; i++){
                        rightisom(); nspos = ewpos=0;}
                    for (int i = 0; i <  mw -blocksmumwidth; i++){
                        downisom(); nspos = ewpos=0;}
                }}//135 end
}//if map not sqr end

 //start point at 00 is ok (including non-sq map). scroll to coord
        if (roll==315||roll==0){
            for (int i = 0; i <n; i++){downisom();}
            for (int i = 0; i <e; i++){rightisom();}
            }

        if (roll==45||roll==90){
            for (int i = 0; i <n; i++){leftisom();}
            for (int i = 0; i <e; i++){downisom();}
        }

        if (roll==135||roll==180){
            for (int i = 0; i <n; i++){ upisom(); }
            for (int i = 0; i <e; i++){ leftisom(); }
        }

        if (roll==225||roll==270){
            for (int i = 0; i <n; i++){ rightisom(); }
            for (int i = 0; i <e; i++){ upisom(); }
        }

        fmove();
        redrawmenu();
    }// isomviewmet end

    public static void selectdyn(){
     //   JOptionPane.showMessageDialog(null, "select dyn", "w", JOptionPane.PLAIN_MESSAGE);
        Unit unit = new Unit();
        unit.zeroselect();
        int arr[]; int pl = 1011;
        if (iampl2!=0){   pl+=2000; }
            for (int i = 0; i <buildlist.size(); i++){
                    arr = (int[]) buildlist.get(i);
                    if (arr[14]==pl){arr[10] = 1; buildlist.set(i, arr);}
                }
        addp1();
    }

    public static void detonate(){
       // JOptionPane.showMessageDialog(null, "boom", "w", JOptionPane.PLAIN_MESSAGE);
        int arr[];
        if (iampl2==0){
            for (int i = 0; i <buildlist.size(); i++){
                arr = (int[]) buildlist.get(i);
                if (arr[14]==1011&&arr[10] == 1){
                    detonatedel(arr[1],arr[2],arr[3]);
                    if (soundplay>0) {     soundplay(1011);}
                }
            }
        }else{
            action = 11;
            if (soundplay>0) {//
                for (int i = 0; i <buildlist.size(); i++){
                    arr = (int[]) buildlist.get(i);
                    if (arr[14]==3011&&arr[10] == 1){
                          soundplay(1011);
                    }
                }
            }//
        }
        phcal();
    }//detonate end

    public static void detonatedel(int z, int y, int x){
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                for ( int k = -1; k < 2; k++) {
                    try {
                        map2[i+z][j+y][k+x] = 0;
                    } catch (Exception e) {
                    }
                }}}
    }// detonatedel end

    public static void soundplay(int item){
        if (soundplay>0&&!player.isRunning()&&!issoundplayingnow){
           if (item>0) {soundplay2( item);}
           else{
               if (iampl2==0){if (item>-2000){soundplay2( item);}}
               else{if (item<-2000){soundplay2( item);}}
           }
    }}

    public static void soundplay2(int item){
        sounditem = item;
    }

    public static void maingo(){
        if (soundplay >0){
            task = new TestThread();
            new Thread(task).start();
            tim = new Timer3();
            tim.go();
        }
        new Sol();
        countscreenpix();
        fmove(); //to draw a screen
        menugo();
        // JOptionPane.showMessageDialog(null, "click on screen to start", "start", JOptionPane.PLAIN_MESSAGE);
    }

}