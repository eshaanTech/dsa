package tech.mantra.meta;
/*
 cafeteria table consists of a row of
N seats, numbered from 1 1 to N from left to right. Social distancing guidelines require that every diner be seated such that K seats to their left and
K seats to their right (or all the remaining seats to that side if there are fewer than K) remain empty. There are currently M diners seated at the table, the
ith of whom is in seat S i ​
 . No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
 */

import java.util.Arrays;

public class CafeteriaSittingArrangement {
    public static void main(String[] args){
       long N = 15;
        long K = 2;
        int M = 3;
        long[] S = {11, 6, 14};
        /*long N = 10;
        long K = 1;
        int M = 2;
        long[] S = {2, 6};*/
        //output {2, 4, 6, 8, 10}
        long res = getMaxAdditionalDinersCount(N, K, M, S);
        System.out.println(res);
    }

    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        if(S==null || S.length<=K){
            return 0;
        }
        Arrays.sort(S);
        //identify the additional diner count before the first existing counter - start at 0 check it the current index is < S[0]
        long additionlaDiners = 0;
        long prevOccupied =0;
        for(int i =0; i<M; i++){
            long currentOccupied = S[i];
            long freeSeats = currentOccupied - prevOccupied - 1;
            additionlaDiners += Math.max(0, (freeSeats)/(K+1));
            prevOccupied = currentOccupied+K;
        }
        //calculate the possible positions after the last diner
        long freeSeats = N-S[S.length-1];
        additionlaDiners += Math.max(0, freeSeats/(K+1));
        return additionlaDiners;
    }
}
