package Leetcode;
//https://leetcode.com/problems/lemonade-change/?envType=daily-question&envId=2024-08-15
public class _860_lemonade_change {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int bill : bills){
            if(bill == 5) five++;

            // if bill is 10 we need to give a change of 5
            else if(bill == 10){
                if(five < 1) return false;
                five--;
                ten++;
            }
            // bill is 20
            else {
                // if we have one 10 and one 5, we can give 15(change)
                if(ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                // if we have 3 fives , then also we can give a change of 15
                else if(five >= 3){
                    five -= 3;
                }
                // if we can't give change then return false
                else return false;
            }
        }
        return true;
    }
}
