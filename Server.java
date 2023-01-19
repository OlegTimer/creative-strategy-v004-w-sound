import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

  public void  run(){
    try {
      try  {
        Sol.server = new ServerSocket(Sol.portnum);
        //System.out.println("Server ready");
          Sol.text1s = "server wait for client";
          Sol.redrawmenu();
        Sol.clientSocket = Sol.server.accept();
        try {

      //    System.out.println("client has connected");
            Sol.text1s = "client has connected";
            Sol.redrawmenu();
          Sol.in = new BufferedReader(new InputStreamReader(Sol.clientSocket.getInputStream()));
          Sol.out = new BufferedWriter(new OutputStreamWriter(Sol.clientSocket.getOutputStream()));
          String word="";
          String clientWord="";
int mapchanged=1;

          while (Sol.mp>0) {//cycle start
           // System.out.println("cycle b start");
            if (Sol.servgo>0) {
             // System.out.println("cycle s start");
if (Sol.servbye.equals("wait")) {
    String servline = "";
    String nl = "\r\n";

    Sol.out.write("attention" + "\r\n");
    Sol.out.flush();
    Sol.out.write(Sol.mapname + " " + Sol.mapheight + " " + Sol.mapwidth + " " + Sol.maplength + "\r\n");
    Sol.out.flush();

    if (Sol.countt==1){
        for (int i = Sol.mapheight - 1; i > -1; i--) {
            for (int j = 0; j < Sol.mapwidth; j++) {
                for (int k = 0; k < Sol.maplength; k++) {
                    int tem = Sol.map2[i][j][k];
                    servline = servline + tem + " ";
        if (Sol.map2[i][j][k]!=Sol.map4[i][j][k]) {
            if(Sol.map2[i][j][k]>997999||Sol.map4[i][j][k]>997999){mapchanged++; }}
                    Sol.map4[i][j][k]=Sol.map2[i][j][k];
}
                servline = servline + nl;
                Sol.out.write(servline);
                Sol.out.flush();
                servline = "";
            }}
        if (mapchanged!=0){
            mapchanged=0;
    Sol.out.write("redraw" + "\r\n");
    Sol.out.flush();
}
}

    if (Sol.unitlist.size() > 0) {
        Sol.out.write("unit" + "\r\n");
        Sol.out.flush();
        servline = "";
        int zp = Sol.unitlist.size();
        if (zp != 0) {
            for (int i = 0; i < zp; i++) {
                int arr[];
                arr = (int[]) Sol.unitlist.get(i);
                for (int i2 = 0; i2 < 40; i2++) {
                    servline = servline + arr[i2] + " ";
                }
                servline = servline + nl;
                Sol.out.write(servline);
                Sol.out.flush();
                servline = "";
            }
        }
    }

    if (Sol.buildlist.size() > 0) {
        Sol.out.write("build" + "\r\n");
        Sol.out.flush();
        servline = "";
        int zp = Sol.buildlist.size();
        if (zp != 0) {
            for (int i = 0; i < zp; i++) {
                int arr[];
                arr = (int[]) Sol.buildlist.get(i);
                for (int i2 = 0; i2 < 40; i2++) {
                    servline = servline + arr[i2] + " ";
                }
                servline = servline + nl;
                Sol.out.write(servline);
                Sol.out.flush();
                servline = "";
            }
        }
    }

    int zp = Sol.reslist.size();
    if (zp != 0) {
        Sol.out.write("res" + "\r\n");
        Sol.out.flush();
        for (int i = 0; i < zp; i++) {
            int arr[];
            arr = (int[]) Sol.reslist.get(i);
            for (int i2 = 0; i2 < 4; i2++) {
                servline = servline + arr[i2] + " ";
            }
            servline = servline + nl;
            Sol.out.write(servline);
            Sol.out.flush();
            servline = "";
        }
    }

    Sol.out.write("cash" + "\r\n");
    Sol.out.flush();
    Sol.out.write(Sol.moneypl1 + "\r\n");
    Sol.out.flush();
    Sol.out.write(Sol.moneypl2 + "\r\n");
    Sol.out.flush();

    zp = Sol.flashlist.size();
    if (zp != 0) {
        Sol.out.write("flash" + "\r\n");
        Sol.out.flush();
        for (int i = 0; i < zp; i++) {
            int arr[];
            arr = (int[]) Sol.flashlist.get(i);
            for (int i2 = 0; i2 < 2; i2++) {
                servline = servline + arr[i2] + " ";
            }
            servline = servline + nl;
            Sol.out.write(servline);
            Sol.out.flush();
            servline = "";
        }
    }

    Sol.out.write("fin" + "\r\n");
    Sol.out.flush();
}
else{
    Sol.out.write(Sol.servbye + "\r\n");
    Sol.out.flush();
}
              clientWord =  Sol.in.readLine();
            //  System.out.println(clientWord);

                if (clientWord.equals("bye")) {
                    Sol.servbye="wait";
 //  JOptionPane.showMessageDialog(null, "bye s", "w", JOptionPane.PLAIN_MESSAGE);
                    Sol.mpexit=1;
                    Sol.gamefin();
                    break;}

              // If users send 	quit (To end conversation).
              if (word.equals("quit") || clientWord.equals("quit")) {
                Sol.out.write(">> OKserv");
                Sol.out.newLine();
                Sol.out.flush();
                break;}

                String[]  temp2 = clientWord.split(" ");
              if (temp2[0].equals("7")){
//same
              }
              else{//smth new
                  int start=40; int num=-1;
                  for (int i = 0; i <Sol.unitsnum/2; i++){//unit start
                      num=-1;
 int ff=-6;try { ff = Integer.parseInt(temp2 [start]);} catch (Exception e){}
   if (ff>-1){num=ff;}else{break;}
   start++;
  ff=-6;try { ff = Integer.parseInt(temp2 [start]);} catch (Exception e){}
  if (ff>-1){int arr[] = (int[]) Sol.unitlist.get(num);  arr[10]=ff;   Sol.unitlist.set(num, arr); start++;}
                  }//unit end

                  start=40+Sol.unitsnum;
                  for (int i = 0; i <Sol.buildnum/2; i++){//bld start
                      num=-1;
                      int ff=-6;try { ff = Integer.parseInt(temp2 [start]);} catch (Exception e){}
                      if (ff>-1){num=ff;}else{break;}
                      start++;
                      ff=-6;try { ff = Integer.parseInt(temp2 [start]);} catch (Exception e){}
   if (ff>-1){int arr[] = (int[]) Sol.buildlist.get(num);  arr[10]=ff;   Sol.buildlist.set(num, arr); start++;}
                  }        //bld end

                  if (temp2[1].equals("1")){//if action is move
                       int z = -1;
 int ff=-6;try { ff = Integer.parseInt(temp2 [7]);} catch (Exception e){} if (ff>-1){z=ff;}
                       int y = -1;
    ff=-6;try { ff = Integer.parseInt(temp2 [8]);} catch (Exception e){} if (ff>-1){y=ff;}
                      int x = -1;
  ff=-6;try { ff = Integer.parseInt(temp2 [9]);} catch (Exception e){} if (ff>-1){x=ff;}
      if (z>-1&&y>-1&&x>-1){
                      int arr[];
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
                      for (int i = 0; i <Sol.unitlist.size(); i++) {
                          arr = (int[]) Sol.unitlist.get(i);
                          if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){//set selected unit move coord
 arr[11] = z;  arr[12] = y; arr[13] = x;
 if (arr[14]==9||arr[14]==2009)     {arr [27]=-1; arr [28]=-1; arr [25]=1;}//drop gr attack coord if moved
 Sol.unitlist.set(i, arr);
                          }}}
                  }//action move end

     if (temp2[1].equals("2")) {//if action is   stop
         int arr[];
         int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
         for (int i = 0; i <Sol.unitlist.size(); i++) {
             arr = (int[]) Sol.unitlist.get(i);
             if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                 arr[11] = -1;  arr[12] = -1; arr[13] = -1;//no move
                 arr[30]=0;arr[31]=0;arr[32]=0;//no dig
                 Sol.unitlist.set(i, arr);
             }
         }
     }//stop end

                  if (temp2[1].equals("3")) {//if action is   delete
                      int arr[];
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
                      for (int i = 0; i <Sol.unitlist.size(); i++){
                          arr = (int[]) Sol.unitlist.get(i);
                          if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){Sol.unitlist.remove(i); Sol.deleteselectedunits();}
                      }

                      for (int i = 0; i <Sol.buildlist.size(); i++){
                          arr = (int[]) Sol.buildlist.get(i);
                          if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){Sol.buildlist.remove(i); Sol.deleteselectedunits();}
                      }

                      Sol.phcal();
                  }        //delete end

                  if (temp2[1].equals("4")) {//if action is   ground attack
                      int arr[];
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
                      for (int i = 0; i < Sol.unitlist.size(); i++){
                          arr = (int[]) Sol.unitlist.get(i);
                          if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                              arr[17]=0;
                              arr[25]=0; // gr attack for heavy
                              arr [27]=-1; arr [28]=-1; //to evade false fire
                              Sol.unitlist.set(i, arr);
                          }}
                      for (int i = 0; i < Sol.buildlist.size(); i++){
                          arr = (int[]) Sol.buildlist.get(i);
                          if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                              arr[17]=0;
                              arr[25]=0; // gr attack for heavy
                              Sol.buildlist.set(i, arr);
                          }}
                  }//if action is   ground attack end

                  if (temp2[1].equals("5")) {//if action is   hold fire
                      int arr[];
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
                      for (int i = 0; i < Sol.unitlist.size(); i++){
                          arr = (int[]) Sol.unitlist.get(i);
                          if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                              arr[17]=1;//no shoot at will
                              arr[25]=1; //no gr attack for heavy
                              arr [27]=-1; arr [28]=-1; //not gr trg coord
                              Sol.unitlist.set(i, arr);
                          }}
                      for (int i = 0; i < Sol.buildlist.size(); i++){
                          arr = (int[]) Sol.buildlist.get(i);
                          if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                              arr[17]=1;//no shoot at will
                              arr[25]=1; //no gr attack for heavy
                              arr [27]=-1; arr [28]=-1; //not gr trg coord
                              Sol.buildlist.set(i, arr);
                          }}
                  }//hold fire end

                  if (temp2[1].equals("6")) {//if action is   fire at will
                      int arr[];
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
                      for (int i = 0; i < Sol.unitlist.size(); i++){
                          arr = (int[]) Sol.unitlist.get(i);
                          if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                              arr[17]=0;// shoot at will
                              Sol.unitlist.set(i, arr);
                          }}
                      for (int i = 0; i < Sol.buildlist.size(); i++){
                          arr = (int[]) Sol.buildlist.get(i);
                          if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                              arr[17]=0;// shoot at will
                              Sol.buildlist.set(i, arr);
                          }}
                  }// fire at will end

                  if (temp2[1].equals("7")){//if action is howitzer fire at ground
                      int z = -1;
                      int ff=-6;try { ff = Integer.parseInt(temp2 [7]);} catch (Exception e){} if (ff>-1){z=ff;}
                      int y = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [8]);} catch (Exception e){} if (ff>-1){y=ff;}
                      int x = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [9]);} catch (Exception e){} if (ff>-1){x=ff;}

                          int arr[];
                          int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                          unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;
                          for (int i = 0; i <Sol.unitlist.size(); i++) {
                              arr = (int[]) Sol.unitlist.get(i);
  if (arr[14]==2009&&arr[10]==1&& arr[25]==0&&arr[14]>unmin&&arr[14]<unmax){//if howitzer is selected and ready
if (z==0){
    arr[25]=0;    arr[27] = y;        arr[28] = x;
    Sol.unitlist.set(i, arr);
}
else{
    arr[25]=1;    arr[27] = -1;        arr[28] = -1;
    Sol.unitlist.set(i, arr);
}
                              }}
                  }      //if action is howitzer fire at ground end

                  if (temp2[1].equals("8")) {//if action is   train unit
                      int z = -1;
                      int ff=-6;try { ff = Integer.parseInt(temp2 [7]);} catch (Exception e){} if (ff>-1){z=ff;}
                      int y = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [8]);} catch (Exception e){} if (ff>-1){y=ff;}
                      int x = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [9]);} catch (Exception e){} if (ff>-1){x=ff;}
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;

                      int arr[];
                      arr = (int[]) Sol.buildlist.get(z);
                      if (arr[10]==1&&arr[14]>bldmin&&arr[14]<bldmax){
                      arr[26] = Sol.getpspeedbuild(y);
                      arr[29] = y;
                      Sol.buildlist.set(z, arr);
                      Sol.moneypl2 =  Sol.moneypl2- x;
                 }}//if action is   train unit end

                  if (temp2[1].equals("9")) {//if action is   engineer dig
                      int z = -1;
                      int ff=-6;try { ff = Integer.parseInt(temp2 [7]);} catch (Exception e){} if (ff>-1){z=ff;}
                      int y = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [8]);} catch (Exception e){} if (ff>-1){y=ff;}
                      int x = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [9]);} catch (Exception e){} if (ff>-1){x=ff;}
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;

                      int arr[];
                      arr = (int[]) Sol.unitlist.get(z);
                      if (arr[14]==2003&&arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                          arr[30] = y;
                          arr[31] = x;
                          Sol.unitlist.set(z, arr);
                          Sol.engdig(z);
                      }}//dig end

                  if (temp2[1].equals("10")) {//if action is   engineer build
                      int type=-1;
                      int ff=-6;try { ff = Integer.parseInt(temp2 [5]);} catch (Exception e){} if (ff>-1){type=ff;}
                      int price = -1;
                       ff=-6;try { ff = Integer.parseInt(temp2 [6]);} catch (Exception e){} if (ff>-1){price=ff;}
                      int z = -1;
                       ff=-6;try { ff = Integer.parseInt(temp2 [7]);} catch (Exception e){} if (ff>-1){z=ff;}
                      int y = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [8]);} catch (Exception e){} if (ff>-1){y=ff;}
                      int x = -1;
                      ff=-6;try { ff = Integer.parseInt(temp2 [9]);} catch (Exception e){} if (ff>-1){x=ff;}
                      int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
                      unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;

                      if (type==4001) {// medic
                          Sol.moneypl2 = Sol.moneypl2 - price;
                          Sol.map2[z][y][x] =type;
                      }
                      else{
                          Sol.moneypl2 = Sol.moneypl2 - price;
                          Sol.mouseblock[0]=z;  Sol.mouseblock[1]=y;  Sol.mouseblock[2]=x;
                          Sol.brush = 3010; Sol.dummy=type;
                          Sol.loading=1;
                          Unit unit = new Unit();
                          unit.go();
                          Sol.loading=0;
                          Sol.brush=-1;
                      }
                      Sol.redrawmenu();
                      }//if action is   engineer build end

                  if (temp2[1].equals("11")) {//if action is   detonate
                      int arr[];
                      for (int i = 0; i <Sol.buildlist.size(); i++){
                          arr = (int[]) Sol.buildlist.get(i);
                          if (arr[14]==3011&&arr[10] == 1){
                              Sol.detonatedel(arr[1],arr[2],arr[3]);
                          }
                      }
                      Sol.phcal();
                  }//if action is   detonate end

              }// smth new end

               Unit unit = new Unit();
               unit.unitgo2();
             Sol.servgo=0;

            }//
            else{
 try{Thread.sleep(1);}catch(InterruptedException e){}
            }
          //  System.out.println("cycle b end");
              if (Sol.mpgamerunning==0)  {
                  Sol.mpgamerunning=1;
                  if (Sol.timeron<1){
                      Sol.timeron = 1;
                      Sol.timergo();
                  }
              }
          }//cycle end

        } finally {
        try{  Sol.clientSocket.close();
          Sol.in.close();
          Sol.out.close(); } catch (IOException e) {}
        }
      } finally {
        System.out.println("Server is closed");
      try{  Sol.server.close(); } catch (IOException e) {}

      }
    } catch (IOException e) {
      System.err.println(e);
 //JOptionPane.showMessageDialog(null, "maybe connection lost", "e", JOptionPane.PLAIN_MESSAGE);
        Sol.menutimer    = "maybe net problems"; Sol.redrawmenu();
    }
    }


}
