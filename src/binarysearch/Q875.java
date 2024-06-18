package binarysearch;

public class Q875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            //h - time; res - min speed
            //speed:         1,2,3,4....., 11      piles.length <= h
            //canFinishEat:  0,0,0,1,1,1,1,1.    => find the first 1   => binary search

            int left = 1, right = 0;

            //traveral piles
            for(int pile : piles){
                if(pile > right){
                    right = pile;
                }
            }

            while(left < right){
                int k = left + (right - left)/2;
                if(canFinishEat(piles, h, k)){
                    right = k;
                }else{
                    left = k + 1;
                }
            }
            return left;
        }

        private boolean canFinishEat(int[] piles, int h, int speed){
            int time = 0;
            for(int pile : piles){
                time += (pile + speed - 1)/speed; //还有一种写法： Math.ceil((double)pile / speed)
            }
            //错误写法：return h == time 不一定相等
            return h >= time;
        }
    }

}
