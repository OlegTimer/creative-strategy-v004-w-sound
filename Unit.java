import javax.swing.*;


public class Unit {
    public int z = Sol.mouseblock[0];
    public int y = Sol.mouseblock[1];
    public int x = Sol.mouseblock[2];

    void go() {
       // if (Sol.unitscount_procpl1!=0){ if (Sol.brush>2&&Sol.brush<1000){Sol.unitscount_procpl1--;}}
      //  if (Sol.unitscount_procpl2!=0){  if (Sol.brush>2000&&Sol.brush<3000){Sol.unitscount_procpl2--;}  }
        checkunitcount();

        int perm=1;
        if (Sol.brush>2&&Sol.brush<1000&&Sol.unitscountpl1>=Sol.unitsnum/2){perm=0;}
        if (Sol.brush>2000&&Sol.brush<3000&&Sol.unitscountpl2>=Sol.unitsnum/2){perm=0;}

        if (Sol.brush>1000&&Sol.brush<2000&&Sol.buildcountpl1>=Sol.buildnum/2){perm=0;}
        if (Sol.brush>3000&&Sol.brush<4000&&Sol.buildcountpl2>=Sol.buildnum/2){perm=0;}

        if (Sol.brush==1005&&Sol.buildshootcountpl1 >=Sol.shootingbuildforone ){perm=0;}
        if (Sol.brush==3005&&Sol.buildshootcountpl2 >=Sol.shootingbuildforone ){perm=0;}
        if (Sol.brush==1006&&Sol.buildshootcountpl1 >=Sol.shootingbuildforone ){perm=0;}
        if (Sol.brush==3006&&Sol.buildshootcountpl2 >=Sol.shootingbuildforone ){perm=0;}
        if (Sol.brush==1007&&Sol.buildshootcountpl1 >=Sol.shootingbuildforone ){perm=0;}
        if (Sol.brush==3007&&Sol.buildshootcountpl2 >=Sol.shootingbuildforone ){perm=0;}

        if (Sol.brush==1010&&Sol.buildshootcountpl1 >=Sol.shootingbuildforone ){
            if (Sol.dummy==1005||Sol.dummy==1006||Sol.dummy==1007) {perm=0;}}
        if (Sol.brush==3010&&Sol.buildshootcountpl2 >=Sol.shootingbuildforone ){
            if (Sol.dummy==3005||Sol.dummy==3006||Sol.dummy==3007) {perm=0;}}

        if (Sol.brush==1003&&Sol.hqnump1 >=2 ){perm=0;}
        if (Sol.brush==3003&&Sol.hqnump2 >=2 ){perm=0;}
        if (Sol.brush==1010&&Sol.dummy==1003&&Sol.hqnump1 >=2 ){perm=0;}
        if (Sol.brush==3010&&Sol.dummy==3003&&Sol.hqnump2 >=2 ){perm=0;}

        if (perm==1) {
        if (Sol.loading==0)    {
            if (Sol.brush!=4&&Sol.brush != 2004) {

                if (z < Sol.mapheight - 2) {
                    if (Sol.zpos != Sol.mapheight) {
                        if (z == -1) {
                            z = 0;
                        }
                    } else {
                        if (z == -1) {
                            z = 0;
                        } else {
                            z = z + 1;
                        }
                    }
                }
                if (Sol.zpos == Sol.mapheight - 2) {
                    z = Sol.mapheight - 2;
                }
            }

            if (Sol.brush == 4 && Sol.zpos >= Sol.mapheight - 1) {
                z = Sol.mapheight - 1;
            }
            if (Sol.brush == 2004 && Sol.zpos >= Sol.mapheight - 1) {
                z = Sol.mapheight - 1;
            }
        }

            if (Sol.map2[z][y][x]!=Sol.brush){//no double gen units

                int unitarr[] =  new int [40];
                unitarr[0]=Sol.brush;
                unitarr[1] = z;  unitarr[2] = y; unitarr[3] = x;
                unitarr[4] = z;  unitarr[5] = y; unitarr[6] = x;//coord for movement
                unitarr[7] = z;  unitarr[8] = y; unitarr[9] = x;//coord for movement if z (3 blocks needed)
                unitarr[10]=0; //if selected
                unitarr[11] = -1;  unitarr[12] = -1; unitarr[13] = -1; //target move
                unitarr[14]=Sol.brush;
                unitarr[15] = Sol.getunitspeed(unitarr[14]);
                unitarr[18] = Sol.getunithp(unitarr[14]);
                unitarr[19] = Sol.getunitrange(unitarr[14]);
                unitarr[20] = Sol.getunitdmg(unitarr[14]);

                unitarr [25]=1; //no heavy fire d
                unitarr [27]=-1;
                unitarr [28]=-1;
                //  JOptionPane.showMessageDialog(null, z+" "+y+" "+x, "w", JOptionPane.PLAIN_MESSAGE);
if (Sol.brush==1010||Sol.brush==3010){
  if (Sol.dummy!=1011&&Sol.dummy!=3011)  {unitarr[18] =1;}//for dynamite full hp
    unitarr [29] = Sol.dummy; Sol.dummy=-1;
}

                int gogo=1;
                if (Sol.brush==4||Sol.brush==2004){
                    if (z<Sol.mapheight - 1){  //deploy sky units in sky and top view only
                        gogo=0;
                    }
                }

                if (gogo>0) {
                    Sol.map2[z][y][x] = Sol.brush;
                    if (Sol.brush>2&&Sol.brush<1000||Sol.brush>2000&&Sol.brush<3000) {
                        Sol.unitlist.add(unitarr);
                    if (Sol.unitscount_procpl1!=0){ if (Sol.brush>2&&Sol.brush<1000){Sol.unitscount_procpl1--;}}
                   if (Sol.unitscount_procpl2!=0){  if (Sol.brush>2000&&Sol.brush<3000){Sol.unitscount_procpl2--;}  }
                     //   Sol.unitscount++;
                    }
                    else{
                        Sol.buildlist.add(unitarr);
                     //   Sol.buildcount++;
                    }

                    checkunitcount();
                    Sol.pane.drawf();
                    Sol.redrawmenu();
                }
                else {
//JOptionPane.showMessageDialog(null, "you try to deploy unit at wrong z", "w", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "too many units or buildings", "unit go", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void checkunitcount(){
        int arr[];
        for (int i = 0; i <Sol.unitlist.size(); i++) {
            arr = (int[]) Sol.unitlist.get(i);
            //if unit still in his blocks
            if (Sol.map2[arr[1]][arr[2]][arr[3]] == arr[0]
                    &&Sol.map2[arr[4]][arr[5]][arr[6]] == arr[0]
                    &&Sol.map2[arr[7]][arr[8]][arr[9]] == arr[0] ){
            }
            else{
                Sol.unitlist.remove(i);
            }
        }

        for (int i = 0; i <Sol.buildlist.size(); i++) {
            arr = (int[]) Sol.buildlist.get(i);
            if (Sol.map2[arr[1]][arr[2]][arr[3]] == arr[0]){}
            else{
                Sol.buildlist.remove(i);
            }
        }

        //all unit and bld check start
        for (int k = 0; k < Sol.mapheight; k++){//z
        for (int i = 0; i < Sol.mapwidth; i++){//y
            for (int j = 0; j < Sol.maplength; j++){//x
                if (Sol.map2[k][i][j]>2&&Sol.map2[k][i][j]<1000||Sol.map2[k][i][j]>2000&&Sol.map2[k][i][j]<3000){//if unit
                    int res=-1;
                    res = getunitnumlist(k,i,j);//if unit exist in this block
                    if (res==-1){
                        Sol.map2[k][i][j]=0;
                    }
                    else{
                        arr = (int[]) Sol.unitlist.get(res);
                        //

                        if (Sol.map2[arr[1]][arr[2]][arr[3]] == arr[14]//if unit exist in its blocks
                                &&Sol.map2[arr[4]][arr[5]][arr[6]] == arr[14]
                                &&Sol.map2[arr[7]][arr[8]][arr[9]] == arr[14]
                      ){//
                        }
                        else{
                            Sol.map2[k][i][j]=0;
                        }
                    }
                }//
                if (Sol.map2[k][i][j]>1000&&Sol.map2[k][i][j]<2000||Sol.map2[k][i][j]>3000&&Sol.map2[k][i][j]<4000){//if bld
                    int res=-1;
                    res = getbuildnumlist(k,i,j);//if bld exist in this block
                    if (res==-1){
                        Sol.map2[k][i][j]=0;
                    }
                    else{
                        arr = (int[]) Sol.buildlist.get(res);
                        //

                        if ( Sol.map2[arr[1]][arr[2]][arr[3]] == arr[14]){
                        }
                        else{
                            Sol.map2[k][i][j]=0;
                        }
                        //
                    }
                }
            }//
        }
        }
        //all unit  and bld check end
        Sol.unitscountpl1 = Sol.unitscountpl2 = Sol.aipl2_eng_count=Sol.aipl2_air_def_car_count=Sol.aipl2_zepp_count=0;
        for (int i = 0; i <Sol.unitlist.size(); i++){
            int arr0[];
            arr0 = (int[]) Sol.unitlist.get(i);

            if (Sol.loading!=1){
            int g1=-1; int g2=-1;
            if (arr0[1]>0){g1=Sol.map2[arr0[1]-1][arr0[2]][arr0[3]]; //only 2 blocks really used
            }else{
                g1=998000;}
            if (arr0[4]>0){//only 2 blocks really used
                g2=Sol.map2[arr0[4]-1][arr0[5]][arr0[6]];}else{
                g2=998000;}
            if(arr0[14]==4||arr0[14]==2004){ g1=998000; g2=998000;}
            if (g1>=998000&&g2>=998000){}else{
            Sol.unitlist.remove(i); Sol.phcal();}}

            if(arr0[14]>2&&arr0[14]<1000){Sol.unitscountpl1++;}
            if(arr0[14]>2000&&arr0[14]<3000){Sol.unitscountpl2++;
            if(arr0[14]==2003&&Sol.aipl2>0){Sol.aipl2_eng_count++;}
            if(arr0[14]==2004&&Sol.aipl2>0){Sol.aipl2_zepp_count++;}
            if(arr0[14]==2005&&Sol.aipl2>0){Sol.aipl2_air_def_car_count++;}
            }
        }
        Sol.buildcountpl1=Sol.buildcountpl2=Sol.buildshootcountpl1=Sol.buildshootcountpl2=
                Sol.unitscount_procpl1=Sol.unitscount_procpl2=Sol.aipl2_barracks_count=0;
        int hqcount1=0;   int hqcount2=0;
        for (int i = 0; i <Sol.buildlist.size(); i++){
            int arr0[];
            arr0 = (int[]) Sol.buildlist.get(i);

            if (Sol.loading!=1){
                int g1=-1;
                if (arr0[1]>0){g1=Sol.map2[arr0[1]-1][arr0[2]][arr0[3]]; //
                }else{
                    g1=998000;}
                if (g1>=998000){}else{
                    Sol.buildlist.remove(i); Sol.phcal();}}

            if(arr0[14]>1000&&arr0[14]<2000){Sol.buildcountpl1++;
                if (arr0[14]==1003){hqcount1++;}  if (arr0[29]==1003){hqcount1++;}
                if(arr0[20]!=0
            ||arr0[29]==1005||arr0[29]==1006||arr0[29]==1007){Sol.buildshootcountpl1++; }}
            if(arr0[14]>3000&&arr0[14]<4000){Sol.buildcountpl2++;
                if (arr0[14]==3008||arr0[29]==3008){Sol.aipl2_barracks_count++;}
                if (arr0[14]==3003){hqcount2++;} if (arr0[29]==3003){hqcount2++;}
                if(arr0[20]!=0
            ||arr0[29]==3005||arr0[29]==3006||arr0[29]==3007 ){Sol.buildshootcountpl2++; }}

       if (arr0[14]==1003||arr0[14]==1008){if (arr0[29]!=0){Sol.unitscount_procpl1++;}}
   if (arr0[14]==3003||arr0[14]==3008){if (arr0[29]!=0){Sol.unitscount_procpl2++;}}
        }
        Sol.unitscountpl1= Sol.unitscountpl1+Sol.unitscount_procpl1;
        Sol.unitscountpl2= Sol.unitscountpl2+Sol.unitscount_procpl2;
        Sol.hqnump1=hqcount1; Sol.hqnump2=hqcount2;
            Sol.unitscount = Sol.unitlist.size();
    }



    public  int getunitnumlist(int z2, int y2, int x2){

        int z3=z2; int y3 = y2;  int x3 = x2;
        int result=-1;
        int arr[];
        for (int i = 0; i <Sol.unitlist.size(); i++) {
            arr = (int[]) Sol.unitlist.get(i);
            if ( arr[1]==z3&&arr[2]==y3&&arr[3]==x3){//if some unit has any group of such coord
                result = i;
            }
            if ( arr[4]==z3&&arr[5]==y3&&arr[6]==x3){
                result = i;
            }
            if ( arr[7]==z3&&arr[7]==y3&&arr[9]==x3){
                result = i;
            }
        }
        return result;
    }

    public  int getbuildnumlist(int z2, int y2, int x2){
        int z3=z2; int y3 = y2;  int x3 = x2;
        int result=-1;
        int arr[];
        for (int i = 0; i <Sol.buildlist.size(); i++) {
            arr = (int[]) Sol.buildlist.get(i);
            if ( arr[1]==z3&&arr[2]==y3&&arr[3]==x3){
                result = i;
            }
        }
        return result;
    }


    public void zeroselect(){
        Sol.action =-1;  Sol.actdigtype=-1; Sol.actdigdir=-1;
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (Sol.iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i <Sol.unitlist.size(); i++) {//select null in unitlist
            int  arr[] = (int[]) Sol.unitlist.get(i);
            if (arr[14]>unmin&&arr[14]<unmax){
            arr[10]=0; arr[0]=arr[14];
            Sol.unitlist.set(i, arr);
        }}
        for (int i = 0; i <Sol.buildlist.size(); i++) {//select null
            int  arr[] = (int[]) Sol.buildlist.get(i);
            if (arr[14]>bldmin&&arr[14]<bldmax){
            arr[10]=0; arr[0]=arr[14];
            Sol.buildlist.set(i, arr);
        }}

      //  for (int i = 0; i < Sol.mapheight; i++){//select null in map
        //    for (int j = 0; j < Sol.mapwidth; j++){
            //    for (int k = 0; k < Sol.maplength; k++) {
              //      if (Sol.map2[i][j][k]==5){Sol.map2[i][j][k]=4;}
              //      if (Sol.map2[i][j][k]==6){Sol.map2[i][j][k]=3;}
             //   }}}
        Sol.pane.drawf();
    }

    public void unitstop(){

        int arr[];
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (Sol.iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i <Sol.unitlist.size(); i++) {
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){
                arr[11] = -1;  arr[12] = -1; arr[13] = -1;//no move
                arr[30]=0;arr[31]=0;arr[32]=0;//no dig
                Sol.unitlist.set(i, arr);
            }
        }
        Sol.pane.drawf();
  if (Sol.iampl2>0){Sol.action=2; }
    }

    public void unitselectall(){
        int arr[];
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (Sol.iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}

        for (int i = 0; i <Sol.buildlist.size(); i++) {//select null for bld
           arr = (int[]) Sol.buildlist.get(i);
            if (arr[14]>bldmin&&arr[14]<bldmax){
            arr[10]=0; arr[0]=arr[14];
            Sol.buildlist.set(i, arr);
        }}

        for (int i = 0; i <Sol.unitlist.size(); i++) {
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[14]>unmin&&arr[14]<unmax){
            arr[10]=1;
            Sol.unitlist.set(i, arr);
        }}
        Sol.singleselect=666;
        Sol.pane.drawf();
        Sol.redrawmenu();
    }
    public void unitgo(){

        int arr[];
        int unmin = 2;    int unmax = 1000;int bldmin = 1000;       int bldmax = 2000;
        if (Sol.iampl2>0){unmin=unmin+2000; unmax=unmax+2000; bldmin = bldmin+2000; bldmax=bldmax+2000;}
        for (int i = 0; i <Sol.unitlist.size(); i++) {
            arr = (int[]) Sol.unitlist.get(i);

            if (arr[10]==1&&arr[14]>unmin&&arr[14]<unmax){//set selected unit move coord
                //
                z = Sol.mouseblock[0];
               if (z==-1&&Sol.zpos!=Sol.mapheight){z=0;}
   if (arr[14]!=4&&arr[14]!=2004&&Sol.zpos==Sol.mapheight){z++;}//gr unit+1 h

                if (arr[14]==4||arr[14]==2004)//air height is the same
                {z=Sol.mapheight-1;arr[11]=  Sol.mapheight-1;}

                arr[11] = z;  arr[12] = y; arr[13] = x;
 if (Sol.iampl2>0){Sol.action=1; Sol.actz=z; Sol.acty=y; Sol.actx=x;}

           if (arr[14]==9||arr[14]==2009)     {arr [27]=-1; arr [28]=-1; arr [25]=1;}//drop gr attack coord if moved

                Sol.unitlist.set(i, arr);
            }
        }
     //   unitgo2();
    }


    public void unitgo2() {

        Sol.redrawmenu();
        int arr[]; int i = 0; int attack=-1;

        if (Sol.countt ==0){
            Sol.flashlist.clear();

            if (Sol.aipl2>0){//if playing against AI as pl2
                    Ai ai2 = new Ai(); ai2.go2(i);//build units
                }

        for (i = 0; i < Sol.unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);

            if (arr[18]>0&&arr[18]<Sol.getunithp(arr[14])){//if hp is not max
                int ie, iw, in, is, ine, inw, ise, isw;
                ie = iw = in = is = ine = inw = ise = isw = -1;
                int medic = 4001; int sum = -8;
                int zt=arr[1]; int yt = arr[2]; int xt = arr[3];

                if (arr[14]!=4&&arr[14]!=2004){
                try {
                    iw = Sol.map2[zt][yt][xt - 1]; if (iw!=medic){iw=-1;}
                } catch (Exception e2) {
                }
                try {
                    ie = Sol.map2[zt][yt][xt + 1]; if (ie!=medic){ie=-1;}
                } catch (Exception e2) {
                }
                try {
                    in = Sol.map2[zt][yt - 1][xt]; if (in!=medic){in=-1;}
                } catch (Exception e2) {
                }
                try {
                 //   inw = Sol.map2[zt][yt - 1][xt - 1]; if (inw!=medic){inw=-1;}
                } catch (Exception e2) {
                }
                try {
                 //   ine = Sol.map2[zt][yt - 1][xt + 1]; if (ine!=medic){ine=-1;}
                } catch (Exception e2) {
                }
                try {
                    is = Sol.map2[zt][yt + 1][xt]; if (is!=medic){is=-1;}
                } catch (Exception e2) {
                }
                try {
                  //  isw = Sol.map2[zt][yt + 1][xt - 1]; if (isw!=medic){isw=-1;}
                } catch (Exception e2) {
                }
                try {
                 //   ise = Sol.map2[zt][yt + 1][xt + 1]; if (ise!=medic){ise=-1;}
                } catch (Exception e2) {
                }
                 sum = ie + iw + in + is + ine + inw + ise + isw;
                }
                else{//if zepp in no  full hp
                int    hdes1=-1;
                    for (int n = Sol.mapheight-2; n >-1; n--){//till the ground
                        if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=n;break;}}
                    int idown=-1;
 try {idown = Sol.map2[hdes1][yt ][xt]; if (idown!=medic){sum=-8;}else{sum=medic;}} catch (Exception e2) {}
                }
                if (sum>-8){arr[18]++;}//if at least one medic is around - heals both pl units
            }//if hp not max end

          //  arr[21]=0; //firing
            arr[22]=0; //under fire
          arr[21]=0;
            if (arr[14]==4||arr[14]==2004||arr[14]==9||arr[14]==2009){
           if (arr[26]>0)    { arr[26]--;}}//timer for reloading

            if (arr[14]==3||arr[14]==2003){//timer for dig eng
                if (arr[32]>0)    { arr[32]--;}}

            Sol.unitlist.set(i, arr);
        }
            for (i = 0; i < Sol.buildlist.size(); i++){
                arr = (int[]) Sol.buildlist.get(i);
                if (arr[26]>0)    { arr[26]--;} //counter for buildings

                if (arr[14]==1001&&arr[26]<=0||arr[14]==3001&&arr[26]<=0)//if mine has 0 timer
                { arr[26]= Sol.getfiredelay(arr[14]); Sol.minego(i); }

                if (arr[14]==1003&&arr[26]==1||arr[14]==3003&&arr[26]==1)//if hq has 1 timer
                {  Sol.hqgo(i); }

                if (arr[14]==1008&&arr[26]==1||arr[14]==3008&&arr[26]==1)//if barracks has 1 timer
                {  Sol.bargo(i); }

  if (arr[14]==1010&&arr[18]==Sol.getunithp(arr[14])||arr[14]==3010&&arr[18]==Sol.getunithp(arr[14]))//if dummy has full hp
                {  Sol.dummygo(i); }

                if (arr[18]>0&&arr[18]<Sol.getunithp(arr[14])){//if hp is not max
                    int ie, iw, in, is, ine, inw, ise, isw;
                    ie = iw = in = is = ine = inw = ise = isw = -1;
                    int medic=-1;

                    if (arr[14]>3000) {medic=2003;}else{medic=3;}

                    int zt=arr[1]; int yt = arr[2]; int xt = arr[3];
                    try {
                        iw = Sol.map2[zt][yt][xt - 1]; if (iw!=medic){iw=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                        ie = Sol.map2[zt][yt][xt + 1]; if (ie!=medic){ie=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                        in = Sol.map2[zt][yt - 1][xt]; if (in!=medic){in=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                     //   inw = Sol.map2[zt][yt - 1][xt - 1]; if (inw!=medic){inw=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                    //    ine = Sol.map2[zt][yt - 1][xt + 1]; if (ine!=medic){ine=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                        is = Sol.map2[zt][yt + 1][xt]; if (is!=medic){is=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                     //   isw = Sol.map2[zt][yt + 1][xt - 1]; if (isw!=medic){isw=-1;}
                    } catch (Exception e2) {
                    }
                    try {
                     //   ise = Sol.map2[zt][yt + 1][xt + 1]; if (ise!=medic){ise=-1;}
                    } catch (Exception e2) {
                    }
                    int sum = ie + iw + in + is + ine + inw + ise + isw;
                    if (sum>-8){arr[18]++;}//if at least one eng is around - repair
                }//if hp not max end
                arr[21]=0;   arr[22]=0;
                Sol.buildlist.set(i, arr);
            }//bld end

            for (i = 0; i < Sol.unitlist.size(); i++){
                arr = (int[]) Sol.unitlist.get(i);
                if (arr[18]<=0){//if out of hp
                       Sol.unitlist.remove(i); Sol.phcal();
                }}

            int hq1=0;     int hq2=0;
            for (i = 0; i < Sol.buildlist.size(); i++){
                arr = (int[]) Sol.buildlist.get(i);
                if (arr[14]==1003){hq1++;}
                if (arr[14]==3003){hq2++;}
                if (arr[18]<=0){//if out of hp
                       Sol.buildlist.remove(i); Sol.phcal();
                }}

            if (Sol.hqgoal==1&&Sol.mapdev==0){//if we are in game mode
               // System.out.println(hq1+" "+hq2);
               if(hq1==0||hq2==0){
                   if (Sol.mp==0){
                   if (hq1==0&&hq2!=0){Sol.game_end=1;  Sol.gamefin();}
                   if (hq2==0&&hq1!=0){Sol.game_end=2;  Sol.gamefin();}
                   if (hq1==0&&hq2==0){Sol.game_end=3;}
                   }else{
                       if (hq1==0&&hq2!=0){Sol.game_end=1;  Sol.gamefinmp();}
                       if (hq2==0&&hq1!=0){Sol.game_end=2;  Sol.gamefinmp();}
                       if (hq1==0&&hq2==0){Sol.game_end=3;}
                   }
               }}

        }//countt=0 end

        for (i = 0; i < Sol.buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i); int      attack2=-1;
            if ( Sol.countt2 == i&&arr[20]!=0&&arr[17]==0){
                Attack3 att = new Attack3();
                attack=  att.check(i);
                if (attack>=0){
                    int arr2[];   arr2 = (int[]) Sol.unitlist.get(attack);
                    arr2[18]=arr2[18]-arr[20];
                    arr2[22]=1;
                    Sol.unitlist.set(attack, arr2); //pl2 under fire

                    arr[21]=1;
                    Sol.buildlist.set(i, arr);//pl1 bld is firing
                }
                else{
                        Attack4 att2 = new Attack4();
                        attack2=  att2.check(i);
                    }
                if (attack2>=0){
                    int arr2[];   arr2 = (int[]) Sol.buildlist.get(attack2);
                    arr2[18]=arr2[18]-arr[20];
                    arr2[22]=1;
                    Sol.buildlist.set(attack2, arr2); //pl2 under fire

                    arr[21]=1;
                    Sol.buildlist.set(i, arr);//pl1 is firing
                }
            }}

//========================
        for (i = 0; i < Sol.unitlist.size(); i++){
            arr = (int[]) Sol.unitlist.get(i);
            if (arr[18]<=0){//if out of hp
             //   Sol.unitlist.remove(i); Sol.phcal();
            }else{

 if (arr[14]!=2004&&arr[14]!=2007&&arr[14]>2000&&Sol.aipl2>0&&arr[15]<=-1&&Sol.countt%1==0) {
     //AI stop to look for a target, not zepp or car
                    arr[11] = -1;
                    arr[12] = -1;
                    arr[13] = -1;
                    arr[15] =Sol.getunitspeed(arr[14]);
                }

            if ( Sol.countt == i &&arr[17]==0&&arr[1] == arr[4] && arr[2] == arr[5] && arr[3] == arr[6]&& arr[11] == -1){
    if (arr[14]==4&&arr[25]==0&&arr[17]==0||arr[14]==2004&&arr[25]==0&&arr[17]==0){//if it's zepp turn and order is g (ground)
        attack=1;
    }else{
        if (arr[14]==9&&arr[25]==0&&arr[17]==0||arr[14]==2009&&arr[25]==0&&arr[17]==0){//if it's howitz turn and order is g (ground)
            attack=1;
        }else{
     Attack att = new Attack();
                attack=  att.check(i);
            }}}

            if (attack>=0&&Sol.countt == i){
                if (arr[14]==4||arr[14]==2004){//zepp fire
                    if (arr[26]==0){
                        arr[26]= Sol.getfiredelay(arr[14]);
                        arr[21]=1;
                        Sol.unitlist.set(i, arr);

                        int bb = 0;
                        for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                            bb = i3;
                            if (Sol.map2[i3][arr[2]][arr[3]] > 997_999)
                                break;
                        }
                        Sol.map2[bb][arr[2]][arr[3]]=0;
                     Sol.phcal();
                        Unit unit = new Unit();
                        unit.checkunitcount();
                        Sol.pane.drawf();
                        Sol.redrawmenu();
                    }
                }else{

                    if (arr[14]==9&&arr[25]==0||arr[14]==2009&&arr[25]==0){//howitz fire at ground
                        if (arr[26]==0&&arr[27]!=-1){
                      int      hdes=1;    try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky attacker
                                if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes=0;break;}}} catch (Exception ef){}
                            if (hdes>0){
                            arr[26]= Sol.getfiredelay(arr[14]);
                            arr[21]=1;
                            Sol.unitlist.set(i, arr);

                            int bb = 0;
                            for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                                bb = i3;
                                if (Sol.map2[i3][arr[27]][arr[28]] > 997_999)
                                    break;
                            }
                            Sol.map2[bb][arr[27]][arr[28]]=0;
                            Sol.phcal();

                                int arrf[] =  new int [2]; //flash coord
                                arrf[0]=arr[27];
                                arrf[1]=arr[28];
                                Sol.flashlist.add(arrf);

                                Unit unit = new Unit();
                                unit.checkunitcount();
                                Sol.pane.drawf();
                                Sol.redrawmenu();
                        }}}
                    else {
                        if (arr[14]==9&&arr[25]!=0||arr[14]==2009&&arr[25]!=0){//howitz fire at unit
                            if (arr[26]==0&&arr[27]!=-1){
                                int      hdes=1;    try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky attacker
                                    if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes=0;break;}}} catch (Exception ef){}
                                if (hdes>0){
                                    arr[26]= Sol.getfiredelay(arr[14]);
                                    arr[21]=1;
                                    Sol.unitlist.set(i, arr);

                                    int bb = 0;
                                    for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                                        bb = i3;
                                        if (Sol.map2[i3][arr[27]][arr[28]] > 997_999)
                                            break;
                                    }
                                    Sol.map2[bb][arr[27]][arr[28]]=0;
                                    Sol.phcal();

                                    int arrf[] =  new int [2]; //flash coord
                                    arrf[0]=arr[27];
                                    arrf[1]=arr[28];
                                    Sol.flashlist.add(arrf);
                                    Unit unit = new Unit();
                                    unit.checkunitcount();
                                    Sol.pane.drawf();
                                    Sol.redrawmenu();
                                }}}
                        else {

                        int arr2[];
                        arr2 = (int[]) Sol.unitlist.get(attack);
                        arr2[18] = arr2[18] - arr[20];
                        arr2[22] = 1;
                        Sol.unitlist.set(attack, arr2); //pl2 under fire

                        arr[21] = 1;
                        Sol.unitlist.set(i, arr);//pl1 is firing
                    }}//
            }}
            else{//if attack1 is empty - no units to attack, maybe buildings to attack
                int      attack2=-1;
                if ( Sol.countt == i &&arr[17]==0&&arr[1] == arr[4] && arr[2] == arr[5] && arr[3] == arr[6]&& arr[11] == -1){
                    Attack2 att2 = new Attack2();
                    attack2=  att2.check(i);
                }

                if (attack2>=0&&Sol.countt == i) {
                    if (arr[14]==4||arr[14]==2004){//zepp fire at bld
                        if (arr[26]==0){
                            arr[26]= Sol.getfiredelay(arr[14]);
                            arr[21]=1;
                            Sol.unitlist.set(i, arr);

                            int bb = 0;
                            for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                                bb = i3;
                                if (Sol.map2[i3][arr[2]][arr[3]] > 997_999)
                                    break;
                            }
                            Sol.map2[bb][arr[2]][arr[3]]=0;
                            Sol.phcal();
                            Unit unit = new Unit();
                            unit.checkunitcount();
                            Sol.pane.drawf();
                            Sol.redrawmenu();
                        }
                    }else{

                        if (arr[14]==9&&arr[25]!=0||arr[14]==2009&&arr[25]!=0){//howitz fire at bld
                            if (arr[26]==0&&arr[27]!=-1){
                                int      hdes=1;    try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky attacker
                                    if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes=0;break;}}} catch (Exception ef){}
                                if (hdes>0){
                                    arr[26]= Sol.getfiredelay(arr[14]);
                                    arr[21]=1;
                                    Sol.unitlist.set(i, arr);

                                    int bb = 0;
                                    for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                                        bb = i3;
                                        if (Sol.map2[i3][arr[27]][arr[28]] > 997_999)
                                            break;
                                    }
                                    Sol.map2[bb][arr[27]][arr[28]]=0;
                                    Sol.phcal();
                                    Unit unit = new Unit();
                                    unit.checkunitcount();
                                    Sol.pane.drawf();
                                    Sol.redrawmenu();

                                    int arrf[] =  new int [2]; //flash coord
                                    arrf[0]=arr[27];
                                    arrf[1]=arr[28];
                                    Sol.flashlist.add(arrf);
                                }}}
                        else {

                    int arr2[];
                    arr2 = (int[]) Sol.buildlist.get(attack2);
                    arr2[18] = arr2[18] - arr[20];
                    arr2[22] = 1;
                    Sol.buildlist.set(attack2, arr2); //pl2 under fire

                    arr[21] = 1;
                    Sol.unitlist.set(i, arr);//pl1 is firing
                }}
                }
                else{//if no attack start
                    if (arr[32]==0){//if dig eng counter is zero
        if (arr[11] != -1 && arr[12] != -1 && arr[13] != -1) {//if they have targetmove

            if (arr[1] == arr[11] && arr[2] == arr[12] && arr[3] == arr[13]) {//and if targetmove is  them
                arr[11] = -1;
                arr[12] = -1;
                arr[13] = -1;
                Sol.unitlist.set(i, arr);
            } else {

                if (arr[2]!=arr[5]||arr[3]!=arr[6]){
                    if (arr[2]>arr[5]){arr[16]=1;} //north
                    if (arr[5]>arr[2]){arr[16]=3;}//south
                    if (arr[3]>arr[6]){arr[16]=0;} //west
                    if (arr[6]>arr[3]){arr[16]=2;} //east
                    }
                arr[21]=0; //if unit moves, it does not fire
                Sol.unitlist.set(i, arr);

                if (arr[14] == 4||arr[14] == 2004) {//air or ground switch
                    if (arr[1] == arr[4] && arr[2] == arr[5] && arr[3] == arr[6] && Sol.countt == i) {//if air unit is in one block
                        unitgoair(i);
                    } else {//if unit is in some blocks
                        moveair2(i);
                    }
                } else {
                    if (arr[1] == arr[4] && arr[2] == arr[5] && arr[3] == arr[6] && Sol.countt == i) {//if gr unit is in one block
                        unitgoground(i);
                    } else {
                        movegr2(i);
                    }
                }

            }
        }
        else{
            if (arr[1] != arr[4] || arr[2] != arr[5] || arr[3] != arr[6]) {//no target nove but they are in some blocks
                if (arr[14] == 4 ||arr[14] == 2004) {
                    moveair2(i);
                }
             else {
                    movegr2(i);
                }
            }else{//if unit has no target move and is in one block start
                if (arr[14] == 3 ||arr[14] == 2003) {//eng
                    if (arr[31]>=4&&Sol.countt==i){// if unit has some unlimited dir
                        Sol.engdig(i);
                    }
                }
                if (Sol.aipl2>0&&Sol.countt==i){//if playing against AI as pl2
                    if (arr[14]>2000){//if pl2
  //     if (arr[14]==2004||arr[14]==2009){arr[21]=0; Sol.unitlist.set(i,arr);}
                        if (arr[21]==0){//not shooting
                   Ai ai = new Ai(); ai.go(i);
                }}}

               // if (attack<0&&attack2<0&&Sol.countt==i){
              //  arr[21]=0; Sol.unitlist.set(i, arr); }//

            }//if unit has no target move and is in one block end
        }
        }//if  dig counter is 0
                    else{//if dig counter is not zero start
  //JOptionPane.showMessageDialog(null, "dig", "w", JOptionPane.PLAIN_MESSAGE);
                        if (arr[32]==2&&Sol.countt==i){Sol.engdig2(i);}//block manipul
                        if (arr[32]==1&&Sol.countt==i){Sol.engdig3(i);}//decision to move
                    }//if dig counter is not zero end
    }//no attack end
        }}

            if (Sol.aipl2>0&&Sol.countt==i&&arr[26]!=0&&arr[14]>2000){//if playing against AI as pl2
          try{
             arr[25]=1; arr[17]=0; //ground attack stop
                arr[27]=-1; arr[28]=-1;
                Sol.unitlist.set(i, arr);
               } catch (Exception e){}
}
        }

     if (Sol.countt%1==0||Sol.countt==0)  {Sol.pane.drawf();} //units moved, draw field once at cycle
       // Sol.pane.drawf();
    }

    public void unitgoair(int b){//now work indiv with air unit (z does not matter)

        int i =b;
        int arr[];
        arr = (int[]) Sol.unitlist.get(i);
        arr[11] = Sol.mapheight-1;

        int y = arr[2];
        int x = arr[3];
        int y2 = arr[12];
        int x2 = arr[13];

        int xdist = x-x2;
        int ydist = y-y2;

        int targetdistance = Math.abs(xdist)+Math.abs(ydist);

        if (targetdistance >Sol.unitcountwaydepth){
            //  System.out.println("too away to count air unit");
            arr[11] = -1;
            arr[12] = -1;
            arr[13] = -1;
            Sol.unitlist.set(i, arr);
        }else{
            SkywayD skyway = new SkywayD();
            skyway.y = Sol.unitcountwaydepth;// 12
            skyway.x = Sol.unitcountwaydepth;
            skyway.y2 = Sol.unitcountwaydepth-ydist;
            skyway.x2 = Sol.unitcountwaydepth-xdist;
            skyway.ystart = y-Sol.unitcountwaydepth;
            skyway.xstart = x-Sol.unitcountwaydepth;

            int res1 = -1;         int res2 =   -1;
            try {      skyway.gofirst();} catch (Exception e){}

            try {  res1 =   skyway.returnres();} catch (Exception e){}
            try { res2 =   skyway.returnres2();} catch (Exception e){}
          //  if (res1<Math.abs(Sol.unitcountwaydepth)&&res2<Math.abs(Sol.unitcountwaydepth)){

                if (res1!=-66666&&res2!=-66666){
                res1=res1+y-Sol.unitcountwaydepth;
                res2=res2+x-Sol.unitcountwaydepth;

if(res1>-1&&res2>-1){
    try{
   if (Sol.map2[Sol.mapheight - 1][res1][res2]==0)
   { Sol.map2[Sol.mapheight - 1][res1][res2] = arr[0];
       arr[4] = Sol.mapheight - 1;
       arr[5] = res1;
       arr[6] = res2;
       arr[15] = Sol.getunitspeed(arr[14]);
       arr[33] = 0;//delta search to zero
       Sol.unitlist.set(i, arr);
       moveair2(i);
   }
    } catch (Exception e){}
    //     System.out.println("gogo air unit");
}
else
{
    //if cannot move. if smth is on target (and target is not reached). search trg near
 if (arr[13]-1>=0&&arr[33]<1){arr[13]--; Sol.unitlist.set(i, arr);}else{ if(arr[33]<1) {arr[33]=1;Sol.unitlist.set(i, arr);}
 if (arr[12]-1>=0&&arr[33]<9){arr[12]--; Sol.unitlist.set(i, arr); }else{ if(arr[33]<10) {arr[33]=10;Sol.unitlist.set(i, arr);}
 if (arr[13]+1<Sol.maplength){arr[13]++; Sol.unitlist.set(i, arr);}else{
 if (arr[12]+1<Sol.mapwidth){arr[12]++; Sol.unitlist.set(i, arr);}
            }}}
    //cannot move end
}
        }
            else
            {
                //if cannot move. if smth is on target (and target is not reached). search trg near
                if (arr[13]-1>=0&&arr[33]<1){arr[13]--; Sol.unitlist.set(i, arr);}else{ if(arr[33]<1) {arr[33]=1;Sol.unitlist.set(i, arr);}
                    if (arr[12]-1>=0&&arr[33]<9){arr[12]--; Sol.unitlist.set(i, arr); }else{ if(arr[33]<10) {arr[33]=10;Sol.unitlist.set(i, arr);}
                        if (arr[13]+1<Sol.maplength){arr[13]++; Sol.unitlist.set(i, arr);}else{
                            if (arr[12]+1<Sol.mapwidth){arr[12]++; Sol.unitlist.set(i, arr);}
                        }}}
                //cannot move end
            }
            //  System.out.println("res: "+res1+" "+res2);
          // System.out.println(arr[12]+" "+arr[13]);
        }
    }

    public void moveair2(int b) {//if unit exist in some cells
        //  System.out.println("air unit already on move");
        int i = b;
        int arr[] = (int[]) Sol.unitlist.get(i);
        arr[15]--;
        if (arr[15]<=0) {

            Sol.map2[arr[1]][arr[2]][arr[3]] = 0;
            Sol.map2[arr[4]][arr[5]][arr[6]] = arr[0];
            arr[1] = arr[4];
            arr[2] = arr[5];
            arr[3] = arr[6];
            arr[7] = arr[4];
            arr[8] = arr[5];
            arr[9] = arr[6];

            if (arr[15]<=-Sol.getunitspeed(arr[14])*3) {
                if (Sol.mp==0){
                    arr[11] = -1;
                    arr[12] = -1;
                    arr[13] = -1;}
                arr[15] =Sol.getunitspeed(arr[14]);
            }

            if (arr[4] == arr[11] && arr[5] == arr[12] && arr[6] == arr[13]) {//if reached end point
                arr[11] = -1;
                arr[12] = -1;
                arr[13] = -1;
                arr[15] =Sol.getunitspeed(arr[14]);
            }

            Sol.unitlist.set(i, arr);
            // Sol.testout();
        }
    else{Sol.unitlist.set(i, arr);} // write  until counter reaches zero
    }
    public void unitgoground(int b){
        int i =b; int arr[];
        arr = (int[]) Sol.unitlist.get(i);

        int z = arr[1];
        int y = arr[2];
        int x = arr[3];

        int z2 = arr[11];
        int y2 = arr[12];
        int x2 = arr[13];

        int xdist = x-x2;
        int ydist = y-y2;

        int targetdistance = Math.abs(xdist)+Math.abs(ydist);//measure xy screen side, not z (height)

        if (targetdistance >Sol.unitcountwaydepth){
            //  System.out.println("too away to count ground unit");
            arr[11] = -1;
            arr[12] = -1;
            arr[13] = -1;
            Sol.unitlist.set(i, arr);
        }else{
            GrwayD grway = new GrwayD();
            grway.z = z;
            grway.y = Sol.unitcountwaydepth;
            grway.x = Sol.unitcountwaydepth;

            grway.z2 = z2;
            grway.y2 = Sol.unitcountwaydepth-ydist;
            grway.x2 = Sol.unitcountwaydepth-xdist;


            grway.ystart = y-Sol.unitcountwaydepth;
            grway.xstart = x-Sol.unitcountwaydepth;

            int resz = -1;            int res1 = -1;         int res2 =   -1;
            try {      grway.gofirst();} catch (Exception e){}

            try { resz =   grway.returnresz();} catch (Exception e){}
            try {  res1 =   grway.returnres();} catch (Exception e){}
            try { res2 =   grway.returnres2();} catch (Exception e){}

            if (resz!=-66666&&res1!=-66666&&res2!=-66666){
                res1=res1+y-Sol.unitcountwaydepth;
                res2=res2+x-Sol.unitcountwaydepth;

                if (resz>-1&&res1>-1&&res2>-1) {

                    if (Sol.map2[resz][res1][res2]==0)
                    { Sol.map2[resz][res1][res2] = arr[0];
                        arr[4] = resz;
                        arr[5] = res1;
                        arr[6] = res2;
                        arr[15] = Sol.getunitspeed(arr[14]);
                        arr[33]=0;//delta targ to zero
                        try {  Sol.unitlist.set(i, arr);} catch (Exception e){}
                        movegr2(i);
                    }

                }else{//if res -
                    //if cannot move. if smth is on target (and target is not reached). search trg near
                    try{
                        if (arr[11]==-1){arr[11]=0;}

                            if (arr[13]-1>=0&&arr[33]<1){arr[13]--; Sol.unitlist.set(i, arr);}else{ if(arr[33]<1) {arr[33]=1;Sol.unitlist.set(i, arr);}
                                if (arr[12]-1>=0&&arr[33]<9){arr[12]--; Sol.unitlist.set(i, arr); }else{ if(arr[33]<10) {arr[33]=10;Sol.unitlist.set(i, arr);}
                                    if (arr[13]+1<Sol.maplength){arr[13]++; Sol.unitlist.set(i, arr);}else{
                                        if (arr[12]+1<Sol.mapwidth){arr[12]++; Sol.unitlist.set(i, arr);}
                                    }}}
                        //z lvl
                        try{
                            if (arr[11]==-1){arr[11]=0;}
                            int tc=-1; int tg=-1;
                            tc =     Sol.map2[arr[11]][arr[12]][arr[13]];
                            tg =     Sol.map2[arr[11]-1][arr[12]][arr[13]];
                            if (tc==0&&tg>997999){}else{
                                int ht = -1;
                                for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                                    ht = i3;
                                    if (Sol.map2[i3][arr[12]][arr[13]] > 997_999)
                                    { break;}
                                }
                                if (ht==0&&Sol.map2[0][arr[12]][arr[13]]< 997_999){ht=-1;}
                                arr[11]=ht+1;Sol.unitlist.set(i, arr);
                            }
                        } catch (Exception e){}
                        //z lvl end
                    } catch (Exception e){}
                    //cannot move end
                }
            }
            else
            {
                //if cannot move. if smth is on target (and target is not reached). search trg near
                try{
                    if (arr[11]==-1){arr[11]=0;}

                    if (arr[13]-1>=0&&arr[33]<1){arr[13]--; Sol.unitlist.set(i, arr);}else{ if(arr[33]<1) {arr[33]=1;Sol.unitlist.set(i, arr);}
                        if (arr[12]-1>=0&&arr[33]<9){arr[12]--; Sol.unitlist.set(i, arr); }else{ if(arr[33]<10) {arr[33]=10;Sol.unitlist.set(i, arr);}
                            if (arr[13]+1<Sol.maplength){arr[13]++; Sol.unitlist.set(i, arr);}else{
                                if (arr[12]+1<Sol.mapwidth){arr[12]++; Sol.unitlist.set(i, arr);}
                            }}}
                    //z lvl
                    try{
                        if (arr[11]==-1){arr[11]=0;}
                        int tc=-1; int tg=-1;
                        tc =     Sol.map2[arr[11]][arr[12]][arr[13]];
                        tg =     Sol.map2[arr[11]-1][arr[12]][arr[13]];
                        if (tc==0&&tg>997999){}else{
                            int ht = -1;
                            for (int i3 = Sol.mapheight - 3; i3 > -1; i3--) {
                                ht = i3;
                                if (Sol.map2[i3][arr[12]][arr[13]] > 997_999)
                                { break;}
                            }
                            if (ht==0&&Sol.map2[0][arr[12]][arr[13]]< 997_999){ht=-1;}
                            arr[11]=ht+1;Sol.unitlist.set(i, arr);
                        }
                    } catch (Exception e){}
                    //z lvl end
                } catch (Exception e){}
                //cannot move end
            }
         //     System.out.println("res gr: "+resz+" "+res1+" "+res2);
        }
    }

    public void movegr2(int b) {//if unit exist in some cells
        //  System.out.println("gr unit already on move");
        int i = b;
        int arr[] = (int[]) Sol.unitlist.get(i);
        arr[15]--;
        if (arr[15]<=0) {
            Sol.map2[arr[1]][arr[2]][arr[3]] = 0;
           Sol.map2[arr[4]][arr[5]][arr[6]] = arr[0];
            arr[1] = arr[4];
            arr[2] = arr[5];
            arr[3] = arr[6];
            arr[7] = arr[4];
            arr[8] = arr[5];
            arr[9] = arr[6];


            if (arr[15]<=-Sol.getunitspeed(arr[14])*3) {
                if (Sol.mp==0){
                arr[11] = -1;
                arr[12] = -1;
                arr[13] = -1;}
                arr[15] =Sol.getunitspeed(arr[14]);
            }

            if (arr[4] == arr[11] && arr[5] == arr[12] && arr[6] == arr[13]) {//if reached end point
                arr[11] = -1;
                arr[12] = -1;
                arr[13] = -1;
                arr[15] =Sol.getunitspeed(arr[14]);
            }

            Sol.unitlist.set(i, arr);
            // Sol.testout();
        }
        else{Sol.unitlist.set(i, arr);} // write  until counter reaches zero
    }

}
