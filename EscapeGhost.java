/* You are playing a simplified PAC-MAN game on an infinite 2-D grid... You start at the point [0, 0], and you are given a destination point target = [x, y] that you are trying to get to... There are several ghosts on the map with their starting positions given as a 2D array ghosts, where ghosts[i] = [xi, yi] represents the starting position of the ith ghost... All inputs are integral coordinates... Each turn, you and all the ghosts may independently choose to either move 1 unit in any of the four cardinal directions: north, east, south, or west, or stay still. All actions happen simultaneously... You escape if and only if you can reach the target before any ghost reaches you... If you reach any square (including the target) at the same time as a ghost, it does not count as an escape... Return true if it is possible to escape regardless of how the ghosts move, otherwise return false...
 * Eg 1: Ghosts = [[1, 0], [0, 3]]    Target = [0, 1]       Output = True
 * Eg 2: Ghosts = [[1, 0]]            Target = [2, 0]       Output = False
 * Eg 3: Ghosts = [[2, 0]]            Target = [1, 0]       Output = False
 */
import java.util.*;
public class EscapeGhost
{
    public boolean EscapePossibility(int gh[][], int target[])
    {   // Evaluate distance...
        double dist = Math.sqrt((target[0]*target[0]) + (target[1]*target[1]));
        for(int i = 0; i < gh[0].length; i++)
        {   // Checking absolute distance of every ghost from the target...
            double gh_dist = Math.sqrt(((gh[0][i]-target[0])*(gh[0][i]-target[0])) + ((gh[1][i]-target[1])*(gh[1][i]-target[1])));
            if(dist >= gh_dist)
                return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a;
        System.out.print("Enter the number of ghosts on the grid : ");
        x = sc.nextInt();
        int ghost[][] = new int[2][x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the x coordinate of "+(i+1)+" Ghost : ");
            a = sc.nextInt();
            ghost[0][i] = a;
            System.out.print("Enter the y coordinate of "+(i+1)+" Ghost : ");
            a = sc.nextInt();
            ghost[1][i] = a;
        }
        System.out.println("The Ghost location on the grid !!");
        for(int i = 0; i < x; i++)
            System.out.print("["+ghost[0][i]+", "+ghost[1][i]+"], ");
        System.out.println();
        int target[] = new int[2];
        System.out.print("Enter target x coordinate : ");
        target[0] = sc.nextInt();
        System.out.print("Enter target y coordinate : ");
        target[1] = sc.nextInt();
        System.out.println("The target coordinates are : ["+target[0]+", "+target[1]+"]");
        EscapeGhost escape = new EscapeGhost();    // Object creation...
        System.out.println("Any chances of escaping ghosts : "+escape.EscapePossibility(ghost, target));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS:-
 * 1. Since the ghosts can wait, if they reach the target before than the player they simply have to wait and eliminate the player...
 * 2. Since both player and ghosts can move equal distances, their speed is equal...
 * 3. The limiting factor in this case is the absolute distance from the target...
 */