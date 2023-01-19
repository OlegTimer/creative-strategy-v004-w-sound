import java.util.ArrayList;
import java.util.Collections;

public class GrwayD {
    public static int z=-1;
    public static int y=-1;
    public static int x=-1;

    public static int z2=-1;//target
    public static int y2=-1;
    public static int x2=-1;
    public static int n=2*Sol.unitcountwaydepth;

    public static int resz=-1;
    public static int res1=-1;
    public static int res2=-1;

    public static int ystart =-1;
    public static int xstart = -1;
    public static int done=0;
    public static int explored[][][];
    public static int reachable[][][];
    public static int prevstep[][][][]; //last arr to contain coord of prev step
    public static int field [][][]; //only obstacles as -1, solid blocks -5
    public static int cost [][][];

    public static void gofirst(){
        reachable =new int [Sol.mapheight][n][n];//cos quantity of arrs starts from 1 (and index from zero)
        explored =new int [Sol.mapheight][n][n];
        prevstep =new int [Sol.mapheight][n][n][3];
        field =new int [Sol.mapheight] [n][n];
        cost =new int [Sol.mapheight][n][n];
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
                cost[f][i][j]=999999999;
                for (int k = 0; k < 3; k++){
                    prevstep[f][i][j][k] = -1;}
            }}}
        reachable[z][y][x]=1;//start
        cost [z][y][x]=0;
        prevstep[z][y][x][0]=-2;
        prevstep[z][y][x][1]=-2;
        prevstep[z][y][x][2]=-2;

        int zb=-1;
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                field[f][i][j]=-1;
            }}}

        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                zb=-1;
                try { zb=Sol.map2[f][ystart+i][xstart+j];} catch (Exception e){}
                if (zb==0){field[f][i][j]=0;}
                if (zb>997999){field[f][i][j]=-5;}
            }}}
        field[z][Sol.unitcountwaydepth][Sol.unitcountwaydepth]=0; //start if not obstacle (but finish maybe)

        go();

    }

    public static void go(){
        int firstreach[]= {-1,-1,-1};
        ArrayList<Integer> list = new ArrayList<>();
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++){//all reachable cells
            for (int j = 0; j < n; j++){
                if (reachable [f][i][j]>0&&explored[f][i][j]<1){
                    firstreach[0]= f; firstreach[1]= i;firstreach[2]= j;
                    list.add(cost[f][i][j]);
                }}}}
        Collections.sort(list);
        int min=-1;
        if (list.size()>0){
            min =  list.get(0);}

        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++){//all reachable cells
            for (int j = 0; j < n; j++){
                if (reachable [f][i][j]>0&&explored[f][i][j]<1&&cost[f][i][j]==min){
                    firstreach[0]= f; firstreach[1]= i;firstreach[2]= j;
                }}}}
        if (firstreach[0]>-1&&firstreach[1]>-1&&firstreach[2]>-1){
          z= firstreach[0];  y=firstreach[1]; x=firstreach[2];

            if (z==z2&&y==y2&&x==x2){done=1;}

            int  l,l0,l1,r,r0,r1,u,u0,u1,d,d0,d1;
            l=r=u=d=l0=l1=r0=r1=u0=u1=d0=d1=-1;//end of field

if (z!=0){try{if(field[z][y][x-1]==0&&field[z-1][y][x-1]==-5){l=0;}} catch (Exception e){}}//left non zero
else{try{if(field[z][y][x-1]==0){l=0;}} catch (Exception e){}}//left zero
if(z!=1){try{if(field[z][y][x-1]==0&&field[z-1][y][x-1]==0&&field[z-2][y][x-1]==-5){l0=0;}}catch(Exception e){}}//l down, not1
else{try{if(field[z][y][x-1]==0&&field[z-1][y][x-1]==0){l0=0;}}catch(Exception e){}}//l down
try{if(field[z][y][x-1]==-5 && field[z+1][y][x-1]==0 && field[z+1][y][x]==0 ){l1=0;}} catch (Exception e){}//left up

            if (z!=0){try{if(field[z][y][x+1]==0&&field[z-1][y][x+1]==-5){r=0;}} catch (Exception e){}}//
            else{try{if(field[z][y][x+1]==0){r=0;}} catch (Exception e){}}//
            if(z!=1){try{if(field[z][y][x+1]==0&&field[z-1][y][x+1]==0&&field[z-2][y][x+1]==-5){r0=0;}}catch(Exception e){}}//
            else{try{if(field[z][y][x+1]==0&&field[z-1][y][x+1]==0){r0=0;}}catch(Exception e){}}//
try{if(field[z][y][x+1]==-5 && field[z+1][y][x+1]==0 && field[z+1][y][x]==0 ){r1=0;}} catch (Exception e){}//r up
//up for north
            if (z!=0){try{if(field[z][y-1][x]==0&&field[z-1][y-1][x]==-5){u=0;}} catch (Exception e){}}//
            else{try{if(field[z][y-1][x]==0){u=0;}} catch (Exception e){}}//
            if(z!=1){try{if(field[z][y-1][x]==0&&field[z-1][y-1][x]==0&&field[z-2][y-1][x]==-5){u0=0;}}catch(Exception e){}}//
            else{try{if(field[z][y-1][x]==0&&field[z-1][y-1][x]==0){u0=0;}}catch(Exception e){}}//
            try{if(field[z][y-1][x]==-5 && field[z+1][y-1][x]==0 && field[z+1][y][x]==0 ){u1=0;}} catch (Exception e){}//up up
//down for south
            if (z!=0){try{if(field[z][y+1][x]==0&&field[z-1][y+1][x]==-5){d=0;}} catch (Exception e){}}//
            else{try{if(field[z][y+1][x]==0){d=0;}} catch (Exception e){}}//
            if(z!=1){try{if(field[z][y+1][x]==0&&field[z-1][y+1][x]==0&&field[z-2][y+1][x]==-5){d0=0;}}catch(Exception e){}}//
            else{try{if(field[z][y+1][x]==0&&field[z-1][y+1][x]==0){d0=0;}}catch(Exception e){}}//
            try{if(field[z][y+1][x]==-5 && field[z+1][y+1][x]==0 && field[z+1][y][x]==0 ){d1=0;}} catch (Exception e){}//down up

//System.out.println("l:"+l+" l0:"+l0+" l1:"+l1+" r:"+r+" r0:"+r0+" r1:"+r1+" u:"+u+" u0:"+u0+" u1:"+u1+" d:"+d+" d0:"+d0+" d1:"+d1);
            int lrudsum = l+r+u+d+l0+l1+r0+r1+u0+u1+d0+d1;

            if (lrudsum!=-12){
                if (l==0){if (explored [z][y][x-1]<1){
                        if (cost [z][y][x-1]>cost [z][y][x]+1){
                            cost [z][y][x-1]=cost [z][y][x]+1;
                            prevstep[z][y][x-1][0] =z;
                            prevstep[z][y][x-1][1] =y;
                            prevstep[z][y][x-1][2] =x;
                            reachable [z][y][x-1]=1;
                        }}}
                if (l0==0){if (explored [z-1][y][x-1]<1){
                    if (cost [z-1][y][x-1]>cost [z][y][x]+1){
                        cost [z-1][y][x-1]=cost [z][y][x]+1;
                        prevstep[z-1][y][x-1][0] =z;
                        prevstep[z-1][y][x-1][1] =y;
                        prevstep[z-1][y][x-1][2] =x;
                        reachable [z-1][y][x-1]=1;
                    }}}
                if (l1==0){if (explored [z+1][y][x-1]<1){
                    if (cost [z+1][y][x-1]>cost [z][y][x]+1){
                        cost [z+1][y][x-1]=cost [z][y][x]+1;
                        prevstep[z+1][y][x-1][0] =z;
                        prevstep[z+1][y][x-1][1] =y;
                        prevstep[z+1][y][x-1][2] =x;
                        reachable [z+1][y][x-1]=1;
                    }}}

                if (r==0){if (explored [z][y][x+1]<1){
                    if (cost [z][y][x+1]>cost [z][y][x]+1){
                        cost [z][y][x+1]=cost [z][y][x]+1;
                        prevstep[z][y][x+1][0] =z;
                        prevstep[z][y][x+1][1] =y;
                        prevstep[z][y][x+1][2] =x;
                        reachable [z][y][x+1]=1;
                    }}}
                if (r0==0){if (explored [z-1][y][x+1]<1){
                    if (cost [z-1][y][x+1]>cost [z][y][x]+1){
                        cost [z-1][y][x+1]=cost [z][y][x]+1;
                        prevstep[z-1][y][x+1][0] =z;
                        prevstep[z-1][y][x+1][1] =y;
                        prevstep[z-1][y][x+1][2] =x;
                        reachable [z-1][y][x+1]=1;
                    }}}
                if (r1==0){if (explored [z+1][y][x+1]<1){
                    if (cost [z+1][y][x+1]>cost [z][y][x]+1){
                        cost [z+1][y][x+1]=cost [z][y][x]+1;
                        prevstep[z+1][y][x+1][0] =z;
                        prevstep[z+1][y][x+1][1] =y;
                        prevstep[z+1][y][x+1][2] =x;
                        reachable [z+1][y][x+1]=1;
                    }}}

                if (u==0){if (explored [z][y-1][x]<1){
                    if (cost [z][y-1][x]>cost [z][y][x]+1){
                        cost [z][y-1][x]=cost [z][y][x]+1;
                        prevstep[z][y-1][x][0] =z;
                        prevstep[z][y-1][x][1] =y;
                        prevstep[z][y-1][x][2] =x;
                        reachable [z][y-1][x]=1;
                    }}}
                if (u0==0){if (explored [z-1][y-1][x]<1){
                    if (cost [z-1][y-1][x]>cost [z][y][x]+1){
                        cost [z-1][y-1][x]=cost [z][y][x]+1;
                        prevstep[z-1][y-1][x][0] =z;
                        prevstep[z-1][y-1][x][1] =y;
                        prevstep[z-1][y-1][x][2] =x;
                        reachable [z-1][y-1][x]=1;
                    }}}
                if (u1==0){if (explored [z+1][y-1][x]<1){
                    if (cost [z+1][y-1][x]>cost [z][y][x]+1){
                        cost [z+1][y-1][x]=cost [z][y][x]+1;
                        prevstep[z+1][y-1][x][0] =z;
                        prevstep[z+1][y-1][x][1] =y;
                        prevstep[z+1][y-1][x][2] =x;
                        reachable [z+1][y-1][x]=1;
                    }}}

                if (d==0){if (explored [z][y+1][x]<1){
                    if (cost [z][y+1][x]>cost [z][y][x]+1){
                        cost [z][y+1][x]=cost [z][y][x]+1;
                        prevstep[z][y+1][x][0] =z;
                        prevstep[z][y+1][x][1] =y;
                        prevstep[z][y+1][x][2] =x;
                        reachable [z][y+1][x]=1;
                    }}}
                if (d0==0){if (explored [z-1][y+1][x]<1){
                    if (cost [z-1][y+1][x]>cost [z][y][x]+1){
                        cost [z-1][y+1][x]=cost [z][y][x]+1;
                        prevstep[z-1][y+1][x][0] =z;
                        prevstep[z-1][y+1][x][1] =y;
                        prevstep[z-1][y+1][x][2] =x;
                        reachable [z-1][y+1][x]=1;
                    }}}
                if (d1==0){if (explored [z+1][y+1][x]<1){
                    if (cost [z+1][y+1][x]>cost [z][y][x]+1){
                        cost [z+1][y+1][x]=cost [z][y][x]+1;
                        prevstep[z+1][y+1][x][0] =z;
                        prevstep[z+1][y+1][x][1] =y;
                        prevstep[z+1][y+1][x][2] =x;
                        reachable [z+1][y+1][x]=1;
                    }}}

                reachable [z][y][x]=0;
                explored [z][y][x]=1;
            }
            else{
                reachable [z][y][x]=0;
                explored [z][y][x]=1;
                //   System.out.println(lrudsum+" nowhere to move from this cell");//but maybe another cells will work
            }
            go();
        }
        else//all accessible cell ended
        {
            fin();
        }
    }//

    public static void fin(){
        if (done>0) {
            int    ypre,xpre,ypre2,xpre2, zpre,zpre2;
            ypre = xpre = ypre2=xpre2=zpre=zpre2=-1;
            zpre =  prevstep[z2][y2][x2][0];
            ypre =  prevstep[z2][y2][x2][1];
            xpre =  prevstep[z2][y2][x2][2];

         int reszpre=-66666;   int res1pre=-66666;  int res2pre=-66666;
            int whilelisten=0;

            while (true){
                if (zpre==-2){break;}
                resz =reszpre; res1=res1pre;  res2=res2pre;
                reszpre = zpre;  res1pre=ypre;  res2pre=xpre;
                //    System.out.println(ypre + " " + xpre);
                zpre2 = prevstep[zpre][ypre][xpre][0];
                ypre2 = prevstep[zpre][ypre][xpre][1];
                xpre2 = prevstep[zpre][ypre][xpre][2];
               zpre = zpre2;
                ypre = ypre2;
                xpre = xpre2;
                whilelisten++;
            }
            //   System.out.println(whilelisten);
            if (whilelisten==1){
                resz=z2; res1=y2;res2=x2;
            }
        }
        else
        {
            //   System.out.println("Reachable cell absent");
        }
    }

    public int returnres(){
        return res1;
    }
    public int returnres2(){
        return res2;
    }
    public int returnresz(){
        return resz;
    }

    public static void bigout() {
        //big out start====================================================================
        //field out start
        System.out.println("Obstacles (-1) field table:");
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[f][i][j] > -1) {
                    System.out.print(" ");
                }
                System.out.print(field[f][i][j] + " ");
            }
            System.out.println();
        }
            System.out.println("_");
        }
//field out end
// prevstep out start
        System.out.println("Prestep table:");
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(");
                for (int k = 0; k < 3; k++) {
                    if (prevstep[f][i][j][k] > -1) {
                        System.out.print(" ");
                    }
                    System.out.print(prevstep[f][i][j][k] + "");
                    System.out.print(" ");
                }
                System.out.print(")");
            }
            System.out.println();
        }
            System.out.println("_");
        }
        //prevstep out end
        //Reachable out start
        System.out.println("Reachable table:");
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(reachable[f][i][j] + " ");
            }
            System.out.println();
        }
            System.out.println("_");
        }
//Reachable out end
        //explored out start
        System.out.println("Explored table:");
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(explored[f][i][j] + " ");
            }
            System.out.println();
        }
            System.out.println("_");
        }
//explored out end
        //explored out start
        System.out.println("Cost table:");
        for (int f = 0; f < Sol.mapheight; f++){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[f][i][j] == 999999999) {
                    System.out.print("p ");
                } else {
                    System.out.print(cost[f][i][j] + " ");
                }
            }
            System.out.println();
        }
            System.out.println("_");
        }
//explored out end
        System.out.println("___");
//big out end ============================================================================
    }
}
