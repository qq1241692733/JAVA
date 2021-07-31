import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/31
 * Time: 10:07
 */
public class TestDemo {
    static int[][] newPosition = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};

    public static void main(String[] args) {
        //int image[][] = {{1,1,1}, {1,1,0}, {1,0,1}};
        int image[][] = {{0,0,0}, {0,1,0}};
        for(int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }
        //image = floodFill(image,1,1,2);
        image = floodFill(image,0,0,2);
        System.out.println("-------------------------------");
        for(int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            Dfs(image,sr,sc,oldColor,newColor);
        }
        return image;
    }

    public static void Dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int newX = x + newPosition[i][0];
                int newY = y + newPosition[i][1];
                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length) {
                    Dfs(image,newX,newY,oldColor,newColor);
                }
            }
        }
    }
}
