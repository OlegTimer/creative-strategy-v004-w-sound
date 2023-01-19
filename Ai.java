
public class Ai {
    public static void go2(int i){
        if (Sol.hqgoal>0) {
        int[] ar;
            int hqy1, hqy2, hqx1, hqx2;
            hqy1= hqy2= hqx1= hqx2=-1;
            for (int i2 = 0; i2 < Sol.buildlist.size(); i2++){
                ar = (int[]) Sol.buildlist.get(i2);
                if (ar[0]==1003)
                {if (hqy1==-1){
                    hqy1 = ar[2];   hqx1 = ar[3];
                }else{
                    hqy2 = ar[2];   hqx2 = ar[3];
                }}
            }
            if (hqy1!=-1){
                for (int i2 = 0; i2 < Sol.buildlist.size(); i2++){
            ar = (int[]) Sol.buildlist.get(i2);
            if     (  Sol.unitscountpl2<Sol.unitsnum/2){
                if (ar[14]==3008){
                    int y1=-1; int x1=-1; double dist =-1.0;
                    if (hqy2!=-1){//if two hq
                        double dist1 = Math.sqrt((hqy1 - ar[2]) * (hqy1 - ar[2]) + (hqx1 - ar[3]) * (hqx1 - ar[3]));
                        double dist2 = Math.sqrt((hqy2 - ar[2]) * (hqy2 - ar[2]) + (hqx2 - ar[3]) * (hqx2 - ar[3]));
                        if (dist1>dist2){y1=hqy2; x1=hqx2; dist=dist2;} else{y1=hqy1; x1=hqx1;  dist=dist1;}
                    }else{y1=hqy1; x1=hqx1; dist=Math.sqrt((hqy1 - ar[2]) * (hqy1 - ar[2]) + (hqx1 - ar[3]) * (hqx1 - ar[3]));}
                  //  System.out.println(y1+" "+x1+" "+dist);
                    if (dist<= (int) Sol.aipl2dist ){Sol.aipl2dist=(int)  dist;
                    }
                    }}}

                for (int i2 = 0; i2 < Sol.buildlist.size(); i2++){
                    ar = (int[]) Sol.buildlist.get(i2);
                    if     (  Sol.unitscountpl2<Sol.unitsnum/2){
                        if (ar[0]==3008){
                        int y1=-1; int x1=-1; double dist =-1.0;
                        if (hqy2!=-1){//if two hq
                            double dist1 = Math.sqrt((hqy1 - ar[2]) * (hqy1 - ar[2]) + (hqx1 - ar[3]) * (hqx1 - ar[3]));
                            double dist2 = Math.sqrt((hqy2 - ar[2]) * (hqy2 - ar[2]) + (hqx2 - ar[3]) * (hqx2 - ar[3]));
                            if (dist1>dist2){y1=hqy2; x1=hqx2; dist=dist2;} else{y1=hqy1; x1=hqx1;  dist=dist1;}
                        }else{y1=hqy1; x1=hqx1; dist=Math.sqrt((hqy1 - ar[2]) * (hqy1 - ar[2]) + (hqx1 - ar[3]) * (hqx1 - ar[3]));}
  //System.out.println(y1+" "+x1+" "+dist+" min_dist: "+((int) Sol.aipl2dist-1));
                            int comparedist = (int) dist;
                        if ( comparedist<= Sol.aipl2dist){
                if (ar[29]==0){//if barracks is not in job
                    double rand = Math.random()*10.0;
                    int nm= (int)(rand);
                 if (nm<3||nm>9){nm=6;}
                 if (Sol.aipl2_eng_count>1&&nm==3){nm=6;}
                    if (Sol.aipl2_air_def_car_count>0&&nm==5){nm=6;}
          //          System.out.println(Sol.aipl2_eng_count);

                if    (Sol.aipl2_zepp_count==0){nm=4;}//if pl2 has zero zepp - build
                    if    (Sol.aipl2_zepp_count>3&&nm==4){nm=6;}//not more 4 zepp

                    int hdzep=1;
                    if (nm==4) {   try{for (int n = ar[1]+1; n <Sol.mapheight-1; n++){//till the sky
                        if (Sol.map2[n][ar[2]][ar[3]]!=0){hdzep=0;break;}}} catch (Exception ef){}}

                    if (hdzep==0&&nm==4){nm=3;hdzep=1;}

                    if (hdzep!=0){

int res= Sol.getpspeedbuild(nm);
                        if (Sol.aipl2>0){res = Sol.aihard;}
                        ar[26] = res;
                        ar[29] = nm;
                        Sol.buildlist.set(i2, ar);
                        Unit unit = new Unit();
                        unit.checkunitcount();
                    }
                }}}}
            }//
        }//
            Sol.aipl2dist=(int)  999_999;
    }
}

    public static void go(int i){
        int[] arr;
        arr = (int[]) Sol.unitlist.get(i);
        if (arr[14]>2000&&arr[21]==0){
                if (Sol.hqgoal>0) {
                    int[] ar; int hqy1, hqy2, hqx1, hqx2;
                    hqy1= hqy2= hqx1= hqx2=-1;
                    for (int i2 = 0; i2 < Sol.buildlist.size(); i2++){
                        ar = (int[]) Sol.buildlist.get(i2);
                        if (ar[0]==1003)
                        {if (hqy1==-1){
                            hqy1 = ar[2];   hqx1 = ar[3];
                        }else{
                            hqy2 = ar[2];   hqx2 = ar[3];
                        }}

                }
             //       System.out.println(hqy1+"_"+hqx1+" "+hqy2+"_"+hqx2);

if (hqy1!=-1){     //if exist at least 1 hq
    int y1=-1; int x1=-1; double dist =-1.0;
    if (hqy2!=-1){//if two hq
        double dist1 = Math.sqrt((hqy1 - arr[2]) * (hqy1 - arr[2]) + (hqx1 - arr[3]) * (hqx1 - arr[3]));
double dist2 = Math.sqrt((hqy2 - arr[2]) * (hqy2 - arr[2]) + (hqx2 - arr[3]) * (hqx2 - arr[3]));
if (dist1>dist2){y1=hqy2; x1=hqx2; dist=dist2;} else{y1=hqy1; x1=hqx1;  dist=dist1;}
  }else{y1=hqy1; x1=hqx1; dist=Math.sqrt((hqy1 - arr[2]) * (hqy1 - arr[2]) + (hqx1 - arr[3]) * (hqx1 - arr[3]));}
//System.out.println(y1+" "+x1+" "+dist);

                double rand = (Math.random());
    rand=rand*10.0;
                int rand2= (int)(rand);
    int randt = rand2;
    double randx = Math.random();
    randx =randx*10.0;
    int rand2x= (int)(randx);
    int randtx = rand2x;
                //    rand2 =5;
        arr[11]=arr[1];
    arr[12]=arr[2];
    arr[13]=arr[3];

 // if (Math.abs(arr[2]-y1)>=Sol.blocksmumwidth/4){if (rand<5.0) {rand2=Math.abs(arr[2]-y1);}else{rand2=randt;}}
    if (arr[14]==2004) {   if (Math.abs(arr[2]-y1)<=Sol.blocksmumwidth){rand2=Math.abs(arr[2]-y1);}else{rand2=randt;}}
    if (arr[2]-y1>0) {arr[12]=arr[2]-rand2;}else{arr[12]=arr[2]+rand2;}


  // if (Math.abs(arr[3]-x1)>=Sol.blocksmumwidth/4){if (randx<5.0) {rand2x=Math.abs(arr[3]-x1);}else{rand2x=randtx;}}
    if (arr[14]==2004) {if (Math.abs(arr[3]-x1)<=Sol.blocksmumwidth){rand2x=Math.abs(arr[3]-x1);}else{rand2x=randtx;}}
    if (arr[3]-x1>0) {arr[13]=arr[3]-rand2x;}else{arr[13]=arr[3]+rand2x;}

            arr[15]=Sol.getunitspeed(arr[14]);

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

    if(arr[13]<0){arr[13]=0;}
    if(arr[12]<0){arr[12]=0;}
    if(arr[13]>Sol.maplength-1){arr[13]=Sol.maplength-1;}
    if(arr[12]> Sol.mapwidth-1){arr[12]= Sol.mapwidth-1;}

    if (arr[14]==2009){
    double range=0;
    if (arr[14]==6||arr[14]==2006||arr[14]==1006||arr[14]==3006||arr[14]==9||arr[14]==2009){
        range = arr[19]+(int) (arr[1]/3);}
    else{  range = arr[19];}
    if (dist<range){
        arr[11]=-1;arr[12]=-1; arr[13]=-1;   arr[15]=Sol.getunitspeed(arr[14]);
        arr[25]=0; arr[17]=0;
        arr[27]=y1; arr[28]=x1;
    }
    else{
        arr[25]=1; arr[17]=0;
        arr[27]=-1; arr[28]=-1;
        Sol.unitlist.set(i, arr);
    }
}

    if (arr[14]==2004){
        if (y1==arr[2]&&x1==arr[3]){
            arr[11]=-1;arr[12]=-1; arr[13]=-1;   arr[15]=Sol.getunitspeed(arr[14]);
            arr[25]=0; arr[17]=0;
            arr[27]=y1; arr[28]=x1;
        }
        else{
            arr[25]=1; arr[17]=0;
            arr[27]=-1; arr[28]=-1;
            Sol.unitlist.set(i, arr);
        }
    }

    if (arr[14]==2003){
        int lock=0;
        int zt=arr[1]; int yt = arr[2]; int xt = arr[3];
        int ie, iw, in, is;
        ie = iw = in = is =  -1;
        int medic = 3010; int sum = -4;//if has dummy, stops
        try {iw = Sol.map2[zt][yt][xt - 1]; if (iw!=medic){iw=-1;}} catch (Exception e2) {}
        try {ie = Sol.map2[zt][yt][xt + 1]; if (ie!=medic){ie=-1;}} catch (Exception e2) {}
        try {in = Sol.map2[zt][yt - 1][xt]; if (in!=medic){in=-1;}} catch (Exception e2) {}
        try {is = Sol.map2[zt][yt + 1][xt]; if (is!=medic){is=-1;}} catch (Exception e2) {}
        sum = iw+ie+in+is;
        if (sum>-4){ lock=1;
            arr[11]=-1;arr[12]=-1; arr[13]=-1;   arr[15]=Sol.getunitspeed(arr[14]);
        }else{//if has free space

 if (Sol.buildcountpl2<Sol.buildnum/2&&dist<5*Sol.blocksmumwidth/2&&dist>Sol.blocksmumwidth-2&&rand<0.6){//0-10 which chance ?
      medic = 0; sum = -4;//try if we can vuild
     try {iw = Sol.map2[zt][yt][xt - 1]; if (iw!=medic){iw=-1;}} catch (Exception e2) {}
     try {ie = Sol.map2[zt][yt][xt + 1]; if (ie!=medic){ie=-1;}} catch (Exception e2) {}
     try {in = Sol.map2[zt][yt - 1][xt]; if (in!=medic){in=-1;}} catch (Exception e2) {}
     try {is = Sol.map2[zt][yt + 1][xt]; if (is!=medic){is=-1;}} catch (Exception e2) {}
     medic=998000;
     if (iw!=-1){if(zt>0){try {iw = Sol.map2[zt-1][yt][xt - 1]; if (iw<medic){iw=-1;}} catch (Exception e2) {}}}
     if (ie!=-1){if(zt>0){try {ie = Sol.map2[zt-1][yt][xt +1]; if (ie<medic){ie=-1;}} catch (Exception e2) {}}}
     if (in!=-1){if(zt>0){try {in = Sol.map2[zt-1][yt-1][xt ]; if (in<medic){in=-1;}} catch (Exception e2) {}}}
     if (is!=-1){if(zt>0){try {is = Sol.map2[zt-1][yt+1][xt ]; if (is<medic){is=-1;}} catch (Exception e2) {}}}
     sum = iw+ie+in+is;
//     System.out.println(iw+" "+ie+" "+in+" "+is);
     if (sum>-4){//if we have free space to build and floor
  int targz=zt;    int targy=-1;   int targx=-1;

  if (iw>-1){targy=yt;targx=xt-1;}else{
      if (ie>-1){targy=yt;targx=xt+1;}else{
          if (in>-1){targy=yt-1;targx=xt;}else{
              if (is>-1){targy=yt-1;targx=xt;}
          }
      }
  }
         int hdes=1;
         try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky attacker
             if (Sol.map2[n][targy][targx]!=0){hdes=0;break;}}} catch (Exception ef){}

         if (hdes>0&&lock==0&&Sol.aipl2_barracks_count<5){
             lock=1;
     arr[11]=-1;arr[12]=-1; arr[13]=-1;   arr[15]=Sol.getunitspeed(arr[14]);
         //  System.out.println("build barr");
             Sol.loading = 1;
             Sol.mouseblock[0]=targz;
             Sol.mouseblock[1]=targy;
             Sol.mouseblock[2]=targx;
             Sol.brush = 3010;
             Sol.dummy = 3008;
             Unit unit = new Unit();
             unit.go();
             Sol.brush=-1;
             Sol.dummy = -1;
             Sol.loading = 0;
             unit.checkunitcount();
           }

         if (hdes>0&&lock==0&&Sol.buildshootcountpl2<Sol.shootingbuildforone){
             lock=1;
             arr[11]=-1;arr[12]=-1; arr[13]=-1;   arr[15]=Sol.getunitspeed(arr[14]);
             //  System.out.println("build barr");
             Sol.loading = 1;
             Sol.mouseblock[0]=targz;
             Sol.mouseblock[1]=targy;
             Sol.mouseblock[2]=targx;
             Sol.brush = 3010;
             Sol.dummy = 3006;
             Unit unit = new Unit();
             unit.go();
             Sol.brush=-1;
             Sol.dummy = -1;
             Sol.loading = 0;
             unit.checkunitcount();
         }
        }//
    }//for building
        }//free space

        double chance  = 8.0;
        if (lock==0&&dist<5*Sol.blocksmumwidth/2&&rand<chance){//drill
            int dig = 3; //3 type void
            arr[30]=dig;
            //0 w, 1 n, 2 e, 3 s
            arr[31]=1;
            if (rand<chance/4){arr[31]=0;}
            if (rand>chance/4&&rand<2*chance/4){arr[31]=1;}
            if (rand>2*chance/4&&rand<3*chance/4){arr[31]=2;}
            if (rand>3*chance/4){arr[31]=3;}
            Sol.engdig(i);
        }

    }

   // System.out.println(rand+" "+arr[31]);
        Sol.unitlist.set(i, arr);
    }else{}
                }}}
}
