import java.util.Arrays;

public class MaxArea {
    public static int maxArea (int [] histogram)
    {
        int maxA = 0;
        for (int i = 0; i < histogram.length; i++)
        {
            int height = histogram[i];
            for (int x = i; x < histogram.length; x++)
            {
                if (histogram[x] < height)
                {
                    height = histogram[x];
                }
                
                int area =  height * (x-i + 1);

                if (area > maxA)
                {
                    maxA = area;
                }
            }
        }

        return maxA;
    }

    public static void main(String[] args) {
        
        int [] histogram1 = {3, 5, 1, 7, 5, 9};
        int [] histogram2 = {3, 5, 3, 7, 5, 9};
        int [] histogram3 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("histogram = " + Arrays.toString(histogram1));
        System.out.println("Max area is " + maxArea(histogram1));

        System.out.println("histogram = " + Arrays.toString(histogram2));
        System.out.println("Max area is " + maxArea(histogram2));
        
    }
}
