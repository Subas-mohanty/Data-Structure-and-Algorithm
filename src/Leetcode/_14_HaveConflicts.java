package Leetcode;
//https://leetcode.com/problems/determine-if-two-events-have-conflict/
public class _14_HaveConflicts {
    public static void main(String[] args) {
        String [] a={"01:15","22:08"};
        String [] b={"02:40","03:00"};
        System.out.println(haveConflict(a,b));
    }
    public static boolean haveConflict(String[] event1, String[] event2) {
        int st1 = Integer.parseInt(event1[0].substring(0, 2))*60 + Integer.parseInt(event1[0].substring(3));
        int et1 = Integer.parseInt(event1[1].substring(0, 2))*60 + Integer.parseInt(event1[1].substring(3));
        int st2 = Integer.parseInt(event2[0].substring(0, 2))*60 + Integer.parseInt(event2[0].substring(3));
        int et2 = Integer.parseInt(event2[1].substring(0, 2))*60 + Integer.parseInt(event2[1].substring(3));
        // return st2<=et1 && st1<=et2;
        return (st1>=st2 && st1<=et2) || (st2>=st1 && st2<=et1);
        // start time of event 1 should be between start and end time of event2 or start time of event 2 should be between start and end time of event1, if any of these happens it means there is a conflict otherwise there is no conflict
    }
}
