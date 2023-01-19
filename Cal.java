import java.util.ArrayList;
import java.util.Collections;

public class Cal {
    public void calc(){
        for (int i = 0; i < Sol.mapheight; i++)
            for (int j = 0; j < Sol.mapwidth; j++)
                for (int k = 0; k < Sol.maplength; k++) {
                    Sol.map3[i][j][k] = Sol.map2[i][j][k];
                }

        for (int i = Sol.mapheight-2; i >-1; i--){
            for (int j = 0; j < Sol.mapwidth; j++){
                for (int k = 0; k < Sol.maplength; k++) {//reverse height start
                    if (Sol.map2[i][j][k]!=0) {
                        int a = 777;
                        try {
                            a = Sol.map2[i][j][k - 1];
                        } catch (Exception e) {
                        }
                        int b = 777;
                        try {
                            b = Sol.map2[i][j][k + 1];
                        } catch (Exception e) {
                        }
                        int d = 777;
                        try {
                            d = Sol.map2[i][j - 1][k];
                        } catch (Exception e) {
                        }
                        int e = 777;
                        try {
                            e = Sol.map2[i][j + 1][k];
                        } catch (Exception e2) {
                        }

                        if (i > 0 && Sol.map2[i][j][k] > 997999 && Sol.map2[i][j][k] < 999000) { //if rock start
                            int stay = 1;

                            if (Sol.map2[i-1][j][k] <998000) {// if void down rock start
                                stay=0;

                                if(a!=777&&b!=777&&Sol.map2[i][j][k+1]>997999&&Sol.map2[i][j][k+1]<999000&&Sol.map2[i][j][k-1]>997999&&Sol.map2[i][j][k-1]<999000
                                        &&Sol.map2[i-1][j][k+1]>997999&&Sol.map2[i-1][j][k-1]>997999){stay++;}//arc 1 we

                                int a2 = 777;try {a2 = Sol.map2[i][j][k - 2];} catch (Exception e3) { }
                                int b2 = 777;try {b2 = Sol.map2[i][j][k +2];} catch (Exception e3) { }
                                int d2 = 777;try {d2 = Sol.map2[i][j-2][k];} catch (Exception e3) { }
                                int ee = 777;try {ee = Sol.map2[i][j+2][k];} catch (Exception e3) { }

                                if(a!=777&&b!=777&&Sol.map2[i][j][k+1]>997999&&Sol.map2[i][j][k+1]<999000&&Sol.map2[i][j][k-1]>997999&&Sol.map2[i][j][k-1]<999000&&a2!=777
                                        &&Sol.map2[i][j][k-2]>997999&&Sol.map2[i][j][k-2]<999000  &&Sol.map2[i-1][j][k+1]>997999&&Sol.map2[i-1][j][k-2]>997999){stay++;}//arc 2 we L

                                if(a!=777&&b!=777&&Sol.map2[i][j][k+1]>997999&&Sol.map2[i][j][k+1]<999000&&Sol.map2[i][j][k-1]>997999&&Sol.map2[i][j][k-1]<999000&&b2!=777
                                        &&Sol.map2[i][j][k+2]>997999&&Sol.map2[i][j][k+2]<999000  &&Sol.map2[i-1][j][k+2]>997999&&Sol.map2[i-1][j][k-1]>997999){stay++;}//arc 2 we R

                                if(d!=777&&e!=777&&Sol.map2[i][j+1][k]>997999&&Sol.map2[i][j+1][k]<999000&&Sol.map2[i][j-1][k]>997999&&Sol.map2[i][j-1][k]<999000
                                        &&Sol.map2[i-1][j+1][k]>997999&&Sol.map2[i-1][j-1][k]>997999){stay++;}//arc 1 ns

                                if(d!=777&&e!=777&&Sol.map2[i][j+1][k]>997999&&Sol.map2[i][j+1][k]<999000&&Sol.map2[i][j-1][k]>997999&&Sol.map2[i][j-1][k]<999000&&d2!=777
                                        &&Sol.map2[i][j-2][k]>997999&&Sol.map2[i][j-2][k]<999000&&Sol.map2[i-1][j+1][k]>997999&&Sol.map2[i-1][j-2][k]>997999){stay++;}//arc 2 ns L

                                if(d!=777&&e!=777&&Sol.map2[i][j+1][k]>997999&&Sol.map2[i][j+1][k]<999000&&Sol.map2[i][j-1][k]>997999&&Sol.map2[i][j-1][k]<999000&&ee!=777
                                        &&Sol.map2[i][j+2][k]>997999&&Sol.map2[i][j+2][k]<999000&&Sol.map2[i-1][j+2][k]>997999&&Sol.map2[i-1][j-1][k]>997999){stay++;}//arc 2 ns R

                            }// if void down rock end

                            if (i > 1) {//rock too high>2 start
                                if (a != 777&&Sol.map2[i][j][k-1]<998000&&Sol.map2[i-1][j][k-1]<998000&&Sol.map2[i-2][j][k-1]<998000) {
                                    stay=0;}
                                if (b != 777&&Sol.map2[i][j][k+1]<998000&&Sol.map2[i-1][j][k+1]<998000&&Sol.map2[i-2][j][k+1]<998000) {
                                    stay=0;}
                                if (d != 777&&Sol.map2[i][j-1][k]<998000&&Sol.map2[i-1][j-1][k]<998000&&Sol.map2[i-2][j-1][k]<998000) {
                                    stay=0;}
                                if (e != 777&&Sol.map2[i][j+1][k]<998000&&Sol.map2[i-1][j+1][k]<998000&&Sol.map2[i-2][j+1][k]<998000) {
                                    stay=0;}
                            }//rock too high>2 end
                            if (stay == 0)
                                Sol.map2[i][j][k] = 999000;
                        } //if rock end
                        if (i > 0 && Sol.map2[i][j][k] > 998999 && Sol.map2[i - 1][j][k] >= 998000) { //if gravel stands on smth slide start

                            if (a != 777) {
                                if (a < 998000 && Sol.map2[i - 1][j][k - 1] < 998000) {
                                    a = 1;
                                }
                            }
                            if (b != 777) {
                                if (b < 998000 && Sol.map2[i - 1][j][k + 1] < 998000) {
                                    b = 1;
                                }
                            }
                            if (d != 777) {
                                if (d < 998000 && Sol.map2[i - 1][j - 1][k] < 998000) {
                                    d = 1;
                                }
                            }
                            if (e != 777) {
                                if (e < 998000 && Sol.map2[i - 1][j + 1][k] < 998000) {
                                    e = 1;
                                }
                            }

                            if (a != 1)
                                a = 0;
                            if (b != 1)
                                b = 0;
                            if (d != 1)
                                d = 0;
                            if (e != 1)
                                e = 0;

                            int total = a + b + d + e;

                            if (total > 0) {//if total>0 start
                                double adoub = (double) 1.0 * a;
                                double bdoub = (double) 2.0 * b;
                                double ddoub = (double) 3.0 * d;
                                double edoub = (double) 4.0 * e;
                                double rnd = (double) 1.0 + (Math.random() * 4.0);

                                ArrayList<Double> list5 = new ArrayList<Double>();
                                if (adoub > 0)
                                    list5.add(Math.abs(rnd - adoub));
                                if (bdoub > 0)
                                    list5.add(Math.abs(rnd - bdoub));
                                if (ddoub > 0)
                                    list5.add(Math.abs(rnd - ddoub));
                                if (edoub > 0)
                                    list5.add(Math.abs(rnd - edoub));
                                Collections.sort(list5);
                                double minnum = list5.get(0);

                                if (a > 0 && minnum == Math.abs(rnd - adoub)) {
                                    Sol.map2[i][j][k] = 0;
                                    Sol.map2[i][j][k - 1] = 999000;
                                    a =b=d=e= 0;
                                }

                                if (b > 0 && minnum == Math.abs(rnd - bdoub)) {
                                    Sol.map2[i][j][k] = 0;
                                    Sol.map2[i][j][k + 1] = 999000;
                                    a =b=d=e= 0;
                                }

                                if (d > 0 && minnum == Math.abs(rnd - ddoub)) {
                                    Sol.map2[i][j][k] = 0;
                                    Sol.map2[i][j - 1][k] = 999000;
                                    a =b=d=e= 0;
                                }

                                if (e > 0 && minnum == Math.abs(rnd - edoub)) {
                                    Sol.map2[i][j][k] = 0;
                                    Sol.map2[i][j + 1][k] = 999000;
                                    a =b=d=e= 0;
                                }

                            }//if total>0 end
                        }//if gravel stands on smth slide end

                        if (i > 0 && Sol.map2[i][j][k] > 998999 && Sol.map2[i - 1][j][k] < 998000) {//if empty down, gravel falls (and kills/replace gr unit)
                            Sol.map2[i][j][k] = 0;
                            Sol.map2[i - 1][j][k] = 999000;
                        }
                        if (i > 0 && Sol.map2[i][j][k] < 998000 && Sol.map2[i - 1][j][k] < 998000) {//if empty down, ground unit or bld dies
                            Sol.map2[i][j][k] = 0;
                        }

                    } }}}//reverse height end
        Unit unit = new Unit();
        unit.checkunitcount();
        Sol.phcalcomp();
    }
}
