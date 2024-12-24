package Leetcode.HashSet;
import java.util.Set;
import java.util.HashSet;

// https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04

public class _874_walking_robot {
    public int robotSim(int[] commands, int[][] obs) {
        // declaring set of string because if we use Pair class we have to override the equals and hashcode method, because same two elements in a pair can have a different address and they will not be equal
        Set<String> set = new HashSet<>();

        for(int [] arr : obs){
            set.add(arr[0] + "," + arr[1]);
        }

        // creating this directions array to store x and y cordinate after moving one unit in the current direction
        int [][] directions = {
            {0,1}, // north
            {1,0}, // east
            {0,-1}, // south
            {-1,0} // west
        };

        int ans = 0;
        int x = 0, y = 0; // initial cordinates
        int direction = 0; // 0: North, 1: East, 2: South, 3: West

        for(int command : commands){
            // turning right
            if(command == -1) direction = (direction + 1) % 4; // why + 1 and + 3, try to calculate from the above sentence written beside the direction variable
            // turning left
            else if(command == -2) direction = (direction + 3) % 4;
            else{
                for(int i = 0; i < command; i++){

                    // the new cordinate will be, first get the direction(which way the robot is moving currently) and then get the respective x and y coordinate from the directions table, for ex : if robot is going in east then for every unit/iteration it x coordinate will increase by and and y coordinate will remain same
                    int newX = x + directions[direction][0];
                    int newY = y + directions[direction][1];

                    // if there is an obstacle, break from here
                    if(set.contains(newX + "," + newY)) break;

                    x = newX;
                    y = newY;

                    ans = Math.max(ans, x*x + y*y);
                }
            }
        }
        return ans;
    }
}
