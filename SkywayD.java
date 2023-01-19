import java.util.ArrayList;
import java.util.Collections;

public class SkywayD {

    public static int y=-1;
    public static int x=-1;
    public static int y2=-1;//target
    public static int x2=-1;
    public static int n=2*Sol.unitcountwaydepth; //double seems needed
    public static int res1=-1;
    public static int res2=-1;
    public static int ystart =-1;
    public static int xstart = -1;
    public static int done=0;
    public static int explored[][];
    public static int reachable[][];
    public static int prevstep[][][];
    public static int field [][]; //only obstacles as -1
    public static int cost [][];

    public static void gofirst(){

        reachable =new int [n][n];
        explored =new int [n][n];
        prevstep =new int [n][n][2];
        field =new int [n][n];
        cost =new int [n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                cost[i][j]=999999999;
                for (int k = 0; k < 2; k++){
                    prevstep[i][j][k] = -1;}}}
        reachable[y][x]=1;//start
        cost [y][x]=0;
        prevstep[y][x][0]=-2;
        prevstep[y][x][1]=-2;

        int z=-1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                field[i][j]=-1;
            }}

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                z=-1;
                try { z=Sol.map2[Sol.mapheight-1][ystart+i][xstart+j];} catch (Exception e){}
                if (z==0){field[i][j]=0;}
            }
        }
        field[Sol.unitcountwaydepth][Sol.unitcountwaydepth]=0; //start if not obstacle (but finish maybe)
        go();
    }

    public static void go(){

        int firstreach[]= {-1,-1};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){//all reachable cells
            for (int j = 0; j < n; j++){
                if (reachable [i][j]>0&&explored[i][j]<1){
                    firstreach[0]= i; firstreach[1]= j;
                    list.add(cost[i][j]);
                    //       System.out.print("y:"+i+" x:"+j+" cost:"+cost[i][j]+" ");
                }
            }
        }
        Collections.sort(list);
        int min=-1;
        if (list.size()>0){
            min =  list.get(0);}

        //    System.out.println(" min:"+min+ "_");

        for (int i = 0; i < n; i++){//all reachable cells
            for (int j = 0; j < n; j++){
                if (reachable [i][j]>0&&explored[i][j]<1&&cost[i][j]==min){
                    firstreach[0]= i; firstreach[1]= j;
                }}}

        if (firstreach[0]>-1&&firstreach[1]>-1){
            y=firstreach[0]; x=firstreach[1];

            //     System.out.println("reachable cell exist");

            int  l,r,u,d;
            l=r=u=d=-1;//end of field
            try { l=field[y][x-1];} catch (Exception e){}
            try { r=field[y][x+1];} catch (Exception e){}
            try { u=field[y-1][x];} catch (Exception e){}
            try { d=field[y+1][x];} catch (Exception e){}
            //    System.out.println("l:"+l+" r:"+r+" u:"+u+" d:"+d);
            int lrudsum = l+r+u+d;

            if (lrudsum!=-4){
                if (l==0){
                    if (explored [y][x-1]<1){
                        if (cost [y][x-1]>cost [y][x]+1){
                            cost [y][x-1]=cost [y][x]+1;
                            prevstep[y][x-1][0] =y;
                            prevstep[y][x-1][1] =x;
                            reachable [y][x-1]=1;
                        }
                        if (y==y2&&x-1==x2){done=1;}
                    }}
                if (r==0){
                    if (explored [y][x+1]<1){
                        if (cost [y][x+1]>cost [y][x]+1) {
                            cost [y][x+1]=cost [y][x]+1;
                            prevstep[y][x+1][0] =y;
                            prevstep[y][x+1][1] =x;
                            reachable [y][x+1]=1;}
                        if (y==y2&&x+1==x2){done=1;}
                    }}
                if (u==0){
                    if (explored [y-1][x]<1){
                        if (cost [y-1][x]>cost [y][x]+1){
                            cost [y-1][x]=cost [y][x]+1;
                            prevstep[y-1][x][0] =y;
                            prevstep[y-1][x][1] =x;
                            reachable [y-1][x]=1;}
                        if (y-1==y2&&x==x2){done=1;}
                    }}
                if (d==0){
                    if (explored [y+1][x]<1){
                        if (cost [y+1][x]>cost [y][x]+1){
                            cost [y+1][x]=cost [y][x]+1;
                            prevstep[y+1][x][0] =y;
                            prevstep[y+1][x][1] =x;
                            reachable [y+1][x]=1;}
                        if (y+1==y2&&x==x2){done=1;}
                    }}
                reachable [y][x]=0;
                explored [y][x]=1;
            }
            else{
                reachable [y][x]=0;
                explored [y][x]=1;
                //   System.out.println(lrudsum+" nowhere to move from this cell");//but maybe another cells will work
            }
            go();
        }//
        else//all accessible cell ended
        {
            fin();
        }
    }

    public static void fin(){
        if (done>0) {
            int    ypre,xpre,ypre2,xpre2;
            ypre = xpre = ypre2=xpre2=-1;
            ypre =        prevstep[y2][x2][0];
            xpre =        prevstep[y2][x2][1];

            int res1pre=-66666;  int res2pre=-66666;
int whilelisten=0;

            while (true){
                if (ypre==-2){break;}
                res1=res1pre;  res2=res2pre;
                res1pre=ypre;  res2pre=xpre;
           //    System.out.println(ypre + " " + xpre);
                ypre2 = prevstep[ypre][xpre][0];
                xpre2 = prevstep[ypre][xpre][1];
                ypre = ypre2;
                xpre = xpre2;
                whilelisten++;
            }
         //   System.out.println(whilelisten);
if (whilelisten==1){
 res1=y2;res2=x2;
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

    public void bigout() {
        //big out start====================================================================
        //field out start
        System.out.println("Obstacles (-1) field table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] > -1) {
                    System.out.print(" ");
                }
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
//field out end
// prevstep out start
        System.out.println("Prestep table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(");
                for (int k = 0; k < 2; k++) {
                    if (prevstep[i][j][k] > -1) {
                        System.out.print(" ");
                    }
                    System.out.print(prevstep[i][j][k] + "");
                    System.out.print(" ");
                }
                System.out.print(")");
            }
            System.out.println();
        }
        //prevstep out end
        //Reachable out start
        System.out.println("Reachable table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(reachable[i][j] + " ");
            }
            System.out.println();
        }
//Reachable out end
        //explored out start
        System.out.println("Explored table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(explored[i][j] + " ");
            }
            System.out.println();
        }
//explored out end
        //explored out start
        System.out.println("Cost table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] == 999999999) {
                    System.out.print("p ");
                } else {
                    System.out.print(cost[i][j] + " ");
                }
            }
            System.out.println();
        }
//explored out end
        System.out.println("___");
//big out end ============================================================================
    }
}