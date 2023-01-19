import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client implements Runnable{
    public void  run(){
        try {

                Sol.clientSocket = new Socket(Sol.ipserver, Sol.portnum);
                try {
                    Sol.in = new BufferedReader(new InputStreamReader(Sol.clientSocket.getInputStream()));
                    Sol.out = new BufferedWriter(new OutputStreamWriter(Sol.clientSocket.getOutputStream()));
                    if (Sol.mpgamerunning==0)  {
                        Sol.mpgamerunning=1;}


int phase = 0; int mapknown=0;
int maphread = 0; int mapnsread=0;
  List<int[]> unitlist2 = new ArrayList<int[]>();
 List<int[]> unitlist3 = new ArrayList<int[]>();
  List<int[]> blist2 = new ArrayList<int[]>();
  List<int[]> blist3 = new ArrayList<int[]>();
int clientanswersize = (40+((Sol.unitsnum/2 )+(Sol.buildnum/2 ))*2);//40+(12+28)*2=120
 int clientanswer[] = new int[clientanswersize];
                    while (Sol.mp>0) {//cycle start
                        // System.out.println("cycle b start");
                            String word = Sol.in.readLine(); // wait serv
                       //    System.out.println(word);
   if (word.equals("bye1")||word.equals("bye2")) {
                            Sol.out.write("bye");
                            Sol.out.newLine();
                            Sol.out.flush();
     //  JOptionPane.showMessageDialog(null, "bye c", "w", JOptionPane.PLAIN_MESSAGE);
       if (word.equals("bye1")){Sol.game_end=1;}
       if (word.equals("bye2")){Sol.game_end=2;}
       Sol.mpexit=1;
       Sol.gamefin();
                            break;
                        }

                        if (word.equals("quit")) {
                            Sol.out.write(">> OK");
                            Sol.out.newLine();
                            Sol.out.flush();
                            break;
                        }
 if (word.equals("attention"))   {phase = 0; Sol.flashlist.clear(); mapnsread=0; if (mapknown==1){maphread = Sol.mapheight-1;}}
 if (word.equals("redraw"))   {Sol.redrawmainfield();}
 if (word.equals("unit"))   {phase = 4;
      unitlist2.clear();
      unitlist3.clear();
      int arr[];
      for (int i = 0; i <Sol.unitlist.size(); i++){
          arr = (int[]) Sol.unitlist.get(i);
          unitlist2.add( arr);
       //   if (arr[0]>2000){arr[0]=i;  unitlist3.add(arr);}//arr0 for num in list for pl2 only
      }
          Sol.unitlist.clear();  }//plus 1 will be 5 for first time
  if (word.equals("build"))   {phase = 7;
      blist2.clear();
      blist3.clear();
      int arr[];
      for (int i = 0; i <Sol.buildlist.size(); i++){
          arr = (int[]) Sol.buildlist.get(i);
          blist2.add( arr);
      }
      Sol.buildlist.clear();  }//8 for first time, pass. 9 will do
   if (word.equals("res"))   {phase = 10; Sol.reslist.clear();  }
  if (word.equals("cash"))   {phase = 50;  }
   if (word.equals("flash"))   {phase = 60;  }

  if (word.equals("fin"))   {phase = 0;
      for (int i = 0; i <clientanswersize; i++){
          clientanswer[i]=-1;}

      int compareunits=0;
      if (Sol.unitlist.size()!=unitlist2.size()){compareunits++;}
   //   System.out.println(compareunits+"size");
      if (compareunits==0){
          for (int i = 0; i <Sol.unitlist.size(); i++){
              int[]    arr = (int[]) Sol.unitlist.get(i);
              int[]    arr2 = (int[]) unitlist2.get(i);
              if (arr[14]!=arr2[14]){compareunits++;
                //  System.out.println(arr[0]+" "+arr2[0]);
              }
          }
      }

    // System.out.println(compareunits);
      if (compareunits==0){
          for (int i = 0; i <unitlist2.size(); i++){
              int[]  arr = (int[]) unitlist2.get(i);
              if (arr[0]>2000){arr[0]=i;  unitlist3.add(arr);}//arr0 for num in list for pl2 only
          }
          if (unitlist3.size()>0){
              int start=40;
          for (int i = 0; i <unitlist3.size(); i++){
              int[]    arr = (int[]) unitlist3.get(i);
              clientanswer[start]=arr[0];
 int arrc[] = (int[]) Sol.unitlist.get(arr[0]);  arrc[10]=arr[10];   Sol.unitlist.set(arr[0], arrc);
              start++;
              clientanswer[start]=arr[10];
              start++;
          }}}

      int compareb=0;
      if (Sol.buildlist.size()!=blist2.size()){compareb++;}
      if (compareb==0){
          for (int i = 0; i <Sol.buildlist.size(); i++){
              int[]    arr = (int[]) Sol.buildlist.get(i);
              int[]    arr2 = (int[]) blist2.get(i);
              if (arr[14]!=arr2[14]){compareb++;
  }}}
      if (compareb==0){
          for (int i = 0; i <blist2.size(); i++){
              int[]  arr = (int[]) blist2.get(i);
              if (arr[0]>2000){arr[0]=i;  blist3.add(arr);}//arr0 for num in list for pl2 only
          }
          if (blist3.size()>0){
              int start=40+Sol.unitsnum;
              for (int i = 0; i <blist3.size(); i++){
                  int[]    arr = (int[]) blist3.get(i);
                  clientanswer[start]=arr[0];
                  int arrc[] = (int[]) Sol.buildlist.get(arr[0]);  arrc[10]=arr[10];   Sol.buildlist.set(arr[0], arrc);
                  start++;
                  clientanswer[start]=arr[10];
                  start++;
              }}}

      if (compareb!=0||compareunits!=0){
          Unit unit = new Unit();
          unit.checkunitcount();
          Sol.redrawmenu();
      }

      clientanswer[0]=5;//if 7 server skips
      clientanswer[1]=Sol.action;

      if (Sol.action==1){//move
          clientanswer[7]=Sol.actz;
          clientanswer[8]=Sol.acty;
          clientanswer[9]=Sol.actx;
      }

      if (Sol.action==7){//howitz fire ground
          clientanswer[7]=Sol.actz;
          clientanswer[8]=Sol.acty;
          clientanswer[9]=Sol.actx;
      }

      if (Sol.action==8&&compareb!=0){clientanswer[1]=-1;}
      if (Sol.action==8&&compareb==0){//train units in bld
          clientanswer[7]=Sol.actz; //sel. build serial num
          clientanswer[8]=Sol.acty; //nm type of unit to train
          clientanswer[9]=Sol.actx; //price for unit
      }

      if (Sol.action==9&&compareunits!=0){clientanswer[1]=-1;}
      if (Sol.action==9&&compareunits==0){//engineer dig
          clientanswer[7]=Sol.actz; //sel. build serial num
          clientanswer[8]=Sol.actdigtype; //type dig
          clientanswer[9]=Sol.actdigdir; //direction dig
          Sol.actdigtype=-1; Sol.actdigdir=-1;
  //System.out.println(clientanswer[7]+" "+clientanswer[8]+" "+clientanswer[9]);
      }

      if (Sol.action==10&&compareunits!=0){clientanswer[1]=-1;}
      if (Sol.action==10&&compareunits==0){//engineer build
          if (Sol.actdigtype==4001&&Sol.actz>Sol.mapheight-3){clientanswer[1]=-1;}
          clientanswer[5]=Sol.actdigtype; //type bld
          clientanswer[6]=Sol.actdigdir; //price bld
         // if (Sol.zpos==Sol.mapheight){Sol.actz++;}
          clientanswer[7]=Sol.actz;
          clientanswer[8]=Sol.acty;
          clientanswer[9]=Sol.actx;
          Sol.actdigtype=-1; Sol.actdigdir=-1;
// System.out.println(clientanswer[5]+" "+clientanswer[6]+" "+clientanswer[7]+" "+clientanswer[8]+" "+clientanswer[9]);
      }

String      cleientline ="";
      for (int i2 = 0; i2 <clientanswersize; i2++) {
          cleientline = cleientline+clientanswer[i2]+" ";}
 //     System.out.println(Sol.action);
 // System.out.println(cleientline);

       Sol.out.write(cleientline + "\r\n");
      Sol.out.flush();
      Sol.action=-1; Sol.actz=-1; Sol.acty=-1; Sol.actx=-1;

      int arr3[];
      for (int i = 0; i <Sol.unitlist.size(); i++) {
          arr3 = (int[]) Sol.unitlist.get(i);
          if (arr3[14]>2000){
         Sol.map2[arr3[1]][arr3[2]][arr3[3]]=arr3[14]; //update map on units
         Sol.map2[arr3[4]][arr3[5]][arr3[6]]= arr3[14];}
      }

      Sol.pane.drawf();
      Sol.redrawmenu();
  }//fin end

 phase++;//!!!
  if (phase==4){phase=3;}//3 for map
    if (phase==7){phase=6;}//6 for unit
 if (phase==10){phase=9;}//9 for bld
 if (phase==13){phase=12;}
  if (phase==63){phase=62;}
// System.out.println(phase);

if (phase==2) {
    if (mapknown == 0) {
        mapknown = 1;
        String[] temp = word.split(" ");
        int changed = 0;
        if (Sol.mapname != temp[0]) {
            Sol.mapname = temp[0];
            changed++;
        }
        int t = 12;
        try {
            t = Integer.parseInt(temp[1]);
        } catch (Exception e) {
        }
        if (t > 1 && t < 13) {
            if (Sol.mapheight != t) {
                Sol.mapheight = t;
                changed++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "error: mheight", "w", JOptionPane.PLAIN_MESSAGE);
        }
        try {
            t = Integer.parseInt(temp[2]);
        } catch (Exception e) {
        }
        if (t >= Sol.blocksmumwidth) {
            if (Sol.mapwidth != t) {
                Sol.mapwidth = t;
                changed++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "error: mwidth", "w", JOptionPane.PLAIN_MESSAGE);
        }
        try {
            t = Integer.parseInt(temp[3]);
        } catch (Exception e) {
        }
        if (t >= Sol.blocksmumwidth) {
            if (Sol.maplength != t) {
                Sol.maplength = t;
                changed++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "error: mlength", "w", JOptionPane.PLAIN_MESSAGE);
        }
        if (changed != 0) {
            Sol.map4 = new int[Sol.mapheight][Sol.mapwidth][Sol.maplength];
            Sol.map3 = new int[Sol.mapheight][Sol.mapwidth][Sol.maplength];
            Sol.map2 = new int[Sol.mapheight][Sol.mapwidth][Sol.maplength];
            Sol.zpos = Sol.mapheight;
            Sol.ewpos = 0;
            Sol.nspos = 0;
            Sol.transparentview = 0;
            Sol.brush = -1;
        }
        if (mapknown==1){maphread = Sol.mapheight-1;}
    }
}//phase 2 end

   if (phase==3) {
       String[]  temp2 = word.split(" ");
       for (int k = 0; k < Sol.maplength; k++) {
           int v2=777;
           try { v2 = Integer.parseInt(temp2 [k]);} catch (Exception e){}
 if (v2!=777)   {       Sol.map2[maphread][mapnsread][k] = v2 ;}
       }
       mapnsread++;
 if (mapnsread>Sol.mapwidth-1)   {mapnsread=0;maphread--;}
   }//phase 3 end

  if (phase==6) {//unit
      String[]  temp2 = word.split(" ");
      int arr[] =  new int [40];
      for (int i2 = 0; i2 <40; i2++) {
          int ff=-6666;
          try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
          //    System.out.print(ff+" ");
          if (ff!=-6666){arr[i2]=ff;}
      }
      Sol.unitlist.add(arr);
  }//phase 6 end

                        if (phase==9) {
                            String[]  temp2 = word.split(" ");
                            int arr[] =  new int [40];
                            for (int i2 = 0; i2 <40; i2++) {
                                int ff=-6666;
                                try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
                                //    System.out.print(ff+" ");
                                if (ff!=-6666){arr[i2]=ff;}
                            }
                            Sol.buildlist.add(arr);
                        }//phase 9 end
  if (phase==12) {
      String[]  temp2 = word.split(" ");
      int arr[] =  new int [4];
      for (int i2 = 0; i2 <4; i2++) {
          int ff=-6666;
          try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
          //    System.out.print(ff+" ");
          if (ff!=-6666){arr[i2]=ff;}
      }
      Sol.reslist.add(arr);
  } //phase 12 end

 if (phase==52) {int ff=-6666;  try { ff = Integer.parseInt(word);} catch (Exception e){}
     if (ff!=-6666){Sol.moneypl1=ff;}}
  if (phase==53) {int ff=-6666;  try { ff = Integer.parseInt(word);} catch (Exception e){}
   if (ff!=-6666){Sol.moneypl2=ff;}}

   if (phase==62) {
       String[]  temp2 = word.split(" ");
       int arr[] =  new int [2];
       for (int i2 = 0; i2 <2; i2++) {
           int ff=-6666;
           try { ff = Integer.parseInt(temp2 [i2]);} catch (Exception e){}
           //    System.out.print(ff+" ");
           if (ff!=-6666){arr[i2]=ff;}
       }
       Sol.flashlist.add(arr);
   }
                        //  System.out.println("cycle b end");
                    }//cycle end

                } finally {
             try{       Sol.clientSocket.close();
                    Sol.in.close();
                    Sol.out.close(); } catch (IOException e) {}
                }

        } catch (IOException e) {
            System.err.println(e);
 //JOptionPane.showMessageDialog(null, "maybe connection lost", "e", JOptionPane.PLAIN_MESSAGE);
            Sol.menutimer    = "maybe net problems"; Sol.redrawmenu();
        }
    }
}
