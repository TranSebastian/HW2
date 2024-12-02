public class Question4 {
    public static void inRange (int [][] ranges, int [] numbers){
        System.out.print("Provide the numbers: ");
        for (int i : numbers){
            System.out.print(i + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < ranges.length; i++){
            System.out.println("Range-"+i + ": " + ranges[i][0] + " " + ranges[i][1]);
        }
        System.out.println();

        int [] numsWithin = new int [ranges.length];

        for (int i = 0; i < numbers.length; i++){
            for (int x = 0; x < ranges.length; x++){
                if (numbers[i] >= ranges[x][0] && numbers[i] <= ranges[x][1]){
                    numsWithin[x] ++;
                }
            }
        }

        for (int i = 0; i < numsWithin.length; i++){
            System.out.println("Numbers lie in Range " + i + ": " + numsWithin[i]);
        }
    }

    public static void main(String[] args) {
        int [] [] ranges1 = {{0,50}, {6,100}, {27,1000}};
        int [] nums1 = {1, 14, 16, 28, 100, 120};
        inRange(ranges1, nums1);

        System.out.println("====================Input 2========================");

        int [] [] ranges2 = {{0,50}, {6,130}, {7,1000}};
        int [] nums2 = {100, 142, 165, 384, 1000};
        inRange(ranges2, nums2);

    }
}
