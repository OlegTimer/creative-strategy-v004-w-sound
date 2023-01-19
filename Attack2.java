import java.util.ArrayList;
import java.util.Collections;
public class Attack2 {
    public static int check(int unitnum){
        int arr[]; int res=-1;      int hdes=1;
        arr = (int[]) Sol.unitlist.get(unitnum);//descr of attacker
        try{for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky attacker
            if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes=0;break;}}} catch (Exception ef){}
        int name = arr[14]; int z1=arr[1];  int y1=arr[2]; int x1=arr[3];
        double range=0;
        if (arr[14]==6||arr[14]==2006||arr[14]==1006||arr[14]==3006||arr[14]==9||arr[14]==2009){
            range = arr[19]+(int) (arr[1]/3);}
        else{  range = arr[19];}

        for (int i = 0; i < Sol.buildlist.size(); i++){
            arr = (int[]) Sol.buildlist.get(i);

            if (name==4){//zepp pl1 is attacker
                if (arr[14]>2000 &&arr[14]!=2004 &&arr[14]<4000){//if target is pl2, not zepp
                    double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                    double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                    if (0.1>=dist1){
                        int hdes1=1;
                        for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky target
                            if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                        if (hdes1>0){res=i;}
                    }
                    if (res<0&&0.1>=dist2){
                        int hdes2=1;
                        for (int n = arr[4]+1; n <Sol.mapheight-1; n++){//till the sky target
                            if (Sol.map2[n][arr[5]][arr[6]]!=0){hdes2=0;break;}}
                        if (hdes2>0){res=i;}
                    }
                }}

            if (name==2004){//zepp pl2 is attacker
                if (arr[14]>2 &&arr[14]!=4 &&arr[14]<2000){//if target is pl2, not zepp
                    double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                    double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                    if (0.1>=dist1){
                        int hdes1=1;
                        for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky target
                            if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                        if (hdes1>0){res=i;}
                    }
                    if (res<0&&0.1>=dist2){
                        int hdes2=1;
                        for (int n = arr[4]+1; n <Sol.mapheight-1; n++){//till the sky target
                            if (Sol.map2[n][arr[5]][arr[6]]!=0){hdes2=0;break;}}
                        if (hdes2>0){res=i;}
                    }
                }}

            if (name==9){//heavy howitzer pl1 is attacker
                if (hdes>0){
                    if (arr[14]>2000 &&arr[14]!=2004 &&arr[14]<4000){//if target is pl2, not zepp
                        double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                        double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                        if (dist1>Sol.mindistmortandhowit&&dist2>Sol.mindistmortandhowit){
                            if (range>=dist1){
                                int hdes1=1;
                                for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                                if (hdes1>0){res=i;
                                    int arrz[];
                                    arrz = (int[]) Sol.unitlist.get(unitnum);
                                    arrz[27]=arr[2]; arrz[28]=arr[3];
                                    Sol.unitlist.set(unitnum, arrz);
                                }
                            }
                            if (res<0&&range>=dist2){
                                int hdes2=1;
                                for (int n = arr[4]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[5]][arr[6]]!=0){hdes2=0;break;}}
                                if (hdes2>0){res=i;
                                    int arrz[];
                                    arrz = (int[]) Sol.unitlist.get(unitnum);
                                    arrz[27]=arr[2]; arrz[28]=arr[3];
                                    Sol.unitlist.set(unitnum, arrz);
                                }
                            }
                        }}}}

            if (name==2009){//heavy howitzer pl2 is attacker
                if (hdes>0){
                    if (arr[14]>2 &&arr[14]!=4 &&arr[14]<2000){//if target is pl1, not zepp
                        double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                        double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                        if (dist1>Sol.mindistmortandhowit&&dist2>Sol.mindistmortandhowit){
                            if (range>=dist1){
                                int hdes1=1;
                                for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                                if (hdes1>0){res=i;
                                    int arrz[];
                                    arrz = (int[]) Sol.unitlist.get(unitnum);
                                    arrz[27]=arr[2]; arrz[28]=arr[3];
                                    Sol.unitlist.set(unitnum, arrz);
                                }
                            }
                            if (res<0&&range>=dist2){
                                int hdes2=1;
                                for (int n = arr[4]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[5]][arr[6]]!=0){hdes2=0;break;}}
                                if (hdes2>0){res=i;
                                    int arrz[];
                                    arrz = (int[]) Sol.unitlist.get(unitnum);
                                    arrz[27]=arr[2]; arrz[28]=arr[3];
                                    Sol.unitlist.set(unitnum, arrz);
                                }
                            }
                        }}}}

            if (name==6){//tank howitzer pl1 is attacker
                if (hdes>0){
                    if (arr[14]>2000 &&arr[14]!=2004 &&arr[14]<4000){//if target is pl2, not zepp
                        double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                        double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                        if (dist1>Sol.mindistmortandhowit&&dist2>Sol.mindistmortandhowit){
                            if (range>=dist1){
                                int hdes1=1;
                                for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                                if (hdes1>0){res=i;}
                            }
                            if (res<0&&range>=dist2){
                                int hdes2=1;
                                for (int n = arr[4]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[5]][arr[6]]!=0){hdes2=0;break;}}
                                if (hdes2>0){res=i;}
                            }
                        }}}}
            if (name==2006){//tank howitzer pl2 is attacker
                if (hdes>0){
                    if (arr[14]>2 &&arr[14]!=4 &&arr[14]<2000){//if target is pl1, not zepp
                        double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                        double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                        if (dist1>Sol.mindistmortandhowit&&dist2>Sol.mindistmortandhowit){
                            if (range>=dist1){
                                int hdes1=1;
                                for (int n = arr[1]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[2]][arr[3]]!=0){hdes1=0;break;}}
                                if (hdes1>0){res=i;break;}
                            }
                            if (res<0&&range>=dist2){
                                int hdes2=1;
                                for (int n = arr[4]+1; n <Sol.mapheight-1; n++){//till the sky target
                                    if (Sol.map2[n][arr[5]][arr[6]]!=0){hdes2=0;break;}}
                                if (hdes2>0){res=i;break;}
                            }
                        }}}}


            if (name==7||name==2007||name==8||name==2008){//car gun or tank pl1 or pl2 is attacker
                int n1,n2,n3; n1=n2=n3=-1;
                if (name==7||name==8){n1=2000;n2=2004;n3=4000;}
                if (name==2007||name==2008){n1=2;n2=4;n3=2000;}

                if (arr[14]>n1 &&arr[14]!=n2 &&arr[14]<n3){//if target is plnum, not zepp
                    double dist1 = Math.sqrt((y1 - arr[2]) * (y1 - arr[2]) + (x1 - arr[3]) * (x1 - arr[3]));
                    double dist2 = Math.sqrt((y1 - arr[5]) * (y1 - arr[5]) + (x1 - arr[6]) * (x1 - arr[6]));
                    int firstdisttry=0;
                    for (int m = 0; m <2; m++){
                        double dtemp=-1;
                        if (firstdisttry==0){dtemp=dist1;}else{dtemp=dist2;}
                        if (res<0&&range>=dtemp){
                            int zt=z1;    int yt=y1; int xt=x1;      int zt2=arr[1]; int yt2 =arr[2];  int xt2 =arr[3];

                            if (Math.abs(zt-zt2)<2){
                                for (int i2 = 0; i2 <Sol.gun_dist; i2++) {
                                    if (res != -1) {
                                        break;
                                    }

                                    double e, w, n, s, ne, nw, se, sw;
                                    e = w = n = s = ne = nw = se = sw = 9999.0;//dist
                                    int ie, iw, in, is, ine, inw, ise, isw;
                                    ie = iw = in = is = ine = inw = ise = isw = -1;//blocks on map
                                    ArrayList list = new ArrayList();
                                    w = Math.sqrt((yt - yt2) * (yt - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2));
                                    list.add(w);
                                    e = Math.sqrt((yt - yt2) * (yt - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2));
                                    list.add(e);
                                    n = Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt - xt2) * (xt - xt2));
                                    list.add(n);
                                    nw = Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2));
                                    list.add(nw);
                                    ne = Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2));
                                    list.add(ne);
                                    s = Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt - xt2) * (xt - xt2));
                                    list.add(s);
                                    sw = Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2));
                                    list.add(sw);
                                    se = Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2));
                                    list.add(se);

                                    Collections.sort(list);
                                    double min = (double) list.get(0);
                                    double min2 = (double) list.get(1);
                                    double min3 = (double) list.get(2);

                                    if (Math.sqrt((yt - yt2) * (yt - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2)) == min || Math.sqrt((yt - yt2) * (yt - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2)) == min2) {
                                    } else {
                                        w = -1.0;
                                    }
                                    if (Math.sqrt((yt - yt2) * (yt - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2)) == min || Math.sqrt((yt - yt2) * (yt - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2)) == min2) {
                                    } else {
                                        e = -1.0;
                                    }
                                    if (Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt - xt2) * (xt - xt2)) == min || Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt - xt2) * (xt - xt2)) == min2) {
                                    } else {
                                        n = -1.0;
                                    }
                                    if (Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2)) == min || Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2)) == min2) {
                                    } else {
                                        nw = -1.0;
                                    }
                                    if (Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2)) == min || Math.sqrt((yt - 1 - yt2) * (yt - 1 - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2)) == min2) {
                                    } else {
                                        ne = -1.0;
                                    }
                                    if (Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt - xt2) * (xt - xt2)) == min || Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt - xt2) * (xt - xt2)) == min2) {
                                    } else {
                                        s = -1.0;
                                    }
                                    if (Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2)) == min || Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt - 1 - xt2) * (xt - 1 - xt2)) == min2) {
                                    } else {
                                        sw = -1.0;
                                    }
                                    if (Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2)) == min || Math.sqrt((yt + 1 - yt2) * (yt + 1 - yt2) + (xt + 1 - xt2) * (xt + 1 - xt2)) == min2) {
                                    } else {
                                        se = -1.0;
                                    }
//System.out.println("n:"+n+" nw:"+nw+" ne:"+ne+" w:"+w+" e:"+e+" s:"+s+" sw:"+sw+" se:"+se);
                                    try {
                                        iw = Sol.map2[zt][yt][xt - 1];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        ie = Sol.map2[zt][yt][xt + 1];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        in = Sol.map2[zt][yt - 1][xt];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        inw = Sol.map2[zt][yt - 1][xt - 1];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        ine = Sol.map2[zt][yt - 1][xt + 1];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        is = Sol.map2[zt][yt + 1][xt];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        isw = Sol.map2[zt][yt + 1][xt - 1];
                                    } catch (Exception e2) {
                                    }
                                    try {
                                        ise = Sol.map2[zt][yt + 1][xt + 1];
                                    } catch (Exception e2) {
                                    }
                                    int dd=0;  if (zt>zt2){ try {dd = Sol.map2[zt2+1][yt2 ][xt2 ];} catch (Exception e2) {}}
                                    if (zt<zt2){try {dd = Sol.map2[z1+1][y1 ][x1 ];} catch (Exception e2) {}}
                                    if (dd>2000&&dd<4000){dd=0;}


                                    if (w == min && w < 0.001&&dd==0) {
                                        res = i;
                                        break;
                                    }
                                    if (e == min && e < 0.001&&dd==0) {
                                        res = i;
                                        break;
                                    }
                                    if (n == min && n < 0.001&&dd==0) {
                                        res = i;
                                        break;
                                    }
                                    if (s == min && s < 0.001&&dd==0) {
                                        res = i;
                                        break;
                                    }//
                                    if (nw == min && nw < 0.001 && iw == 0 || nw == min && nw < 0.001 && in == 0&&dd==0) {
                                        res = i;
                                        break;
                                    }
                                    if (ne == min && ne < 0.001 && ie == 0 || ne == min && ne < 0.001 && in == 0&&dd==0) {
                                        res = i;
                                        break;
                                    }
                                    if (sw == min && sw < 0.001 && iw == 0 || sw == min && sw < 0.001 && is == 0&&dd==0) {
                                        res = i;
                                        break;
                                    }
                                    if (se == min && se < 0.001 && ie == 0 || se == min && se < 0.001 && is == 0&&dd==0) {
                                        res = i;
                                        break;
                                    }

                                    if (min > 0.001) {
                                        if (w == min && iw == 0) {
                                            xt = xt - 1;
                                        }
                                        if (e == min && ie == 0) {
                                            xt = xt + 1;
                                        }
                                        if (n == min && in == 0) {
                                            yt = yt - 1;
                                        }
                                        if (s == min && is == 0) {
                                            yt = yt + 1;
                                        }

                                        if (nw == min && inw == 0 && iw == 0 && in == 0) {
                                            xt = xt - 1;
                                            yt = yt - 1;
                                        }
                                        if (ne == min && ine == 0 && ie == 0 && in == 0) {
                                            xt = xt + 1;
                                            yt = yt - 1;
                                        }
                                        if (sw == min && isw == 0 && iw == 0 && is == 0) {
                                            xt = xt - 1;
                                            yt = yt + 1;
                                        }
                                        if (se == min && ise == 0 && ie == 0 && is == 0) {
                                            xt = xt + 1;
                                            yt = yt + 1;
                                        }
                                    }
                                }}//gun range cycle end
                            firstdisttry=1;
                        }
                    }//
                }}//num 7 or 8 or 2007 or 2008  - tank and car gun both pl end



        }
        return res;
    }
}
