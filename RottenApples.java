import java.util.LinkedList;

public class RottenApples {
   
    public static int rotten (int [] []  apples){

        LinkedList<int[]> queue = new LinkedList<>();
        int [] [] distance = new int[apples.length][apples[0].length];

        for (int row = 0; row < apples.length; row++){
            for (int column = 0; column < apples[row].length; column++){
                if (apples[row][column] == 0){
                    int [] arr = {row, column};
                    queue.add(arr);
                }
            }
        }

        int time = 0;
        while (!queue.isEmpty()){
            int r = queue.peek()[0];
            int c = queue.peek()[1];

            if (c-1 >= 0 && apples[r][c-1] == 1){
                int [] arr = {r, c-1};
                distance[r][c-1] = distance[r][c] + 1;
                apples[r][c-1] = 0;
                queue.add(arr);
            }

            if (c+1 < apples[r].length && apples[r][c+1] == 1){
                int [] arr = {r, c+1};
                distance[r][c+1] = distance[r][c] + 1;
                apples[r][c+1] = 0;
                queue.add(arr);
            }

            if (r-1 >= 0 && apples[r-1][c] == 1){
                int [] arr = {r-1, c};
                distance[r-1][c] = distance[r][c] + 1;
                apples[r-1][c] = 0;
                queue.add(arr);
            }

            if (r+1 < apples.length && apples[r+1][c] == 1){
                int [] arr = {r+1, c};
                distance[r+1][c] = distance[r][c] + 1;
                apples[r+1][c] = 0;
                queue.add(arr);
            }

            queue.pop();
            time = 24*distance[r][c];
        }

        int unrotten = 0;
        for (int row = 0; row < apples.length; row++){
            for (int column = 0; column < apples[row].length; column++){
                if (apples[row][column] == 1){
                    unrotten += 1;
                }
            }
        }

        if (unrotten != 0){
            System.out.println("Unrotten apples left: " + unrotten);
            return -1;
        }
        return time;
    }

    public static void main(String[] args) {
        int [] [] apples1 = {
            {0, 1, -1, 0, 1},
            {-1, 0, 1, 0, 1},
            {1, -1, -1, 0, 1}
        };
    
        int [] [] apples2 = {
            {0, 1, 1, 0, -1, 0, 1},
            {1, -1, 1, 0, -1, 1, -1},
            {0, -1, -1, 0, 1, 1, -1}
        };

        int [] [] apples3 = {
            {0, 1, -1, 0, 1},
            {1, -1, 1, 0, 1},
            {1, -1, -1, 0, 1}
        };

        System.out.println("Apple field one: ");
        System.out.println("Time to take to rot all apples: " + rotten(apples1) + "\n");
        System.out.println("Apple field two: ");
        System.out.println("Time to take to rot all apples: " + rotten(apples2));
        // System.out.println(rotten(apples3));

    }
}
