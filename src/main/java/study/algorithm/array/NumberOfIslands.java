package study.algorithm.array;

/**
 * Created by EricWang on 2020/3/21 11:22 PM.
 * leetcode link: https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands t = new NumberOfIslands();

        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(t.numIslands(grid));


    }

    //todo looksl ike that I didn't get the point of this challenge
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++){

            for (int j = 0; j < grid[i].length; j++){

                if (grid[i][j] == '0'){
                    continue;
                }

                int adjecntLandsCount = 0;
                if (i > 0 && grid[i-1][j] == '1'){
                    adjecntLandsCount++;
                }

                if (j > 0 && grid[i][j-1] == '1'){
                    adjecntLandsCount++;
                    if (adjecntLandsCount > 1){
                        continue;
                    }
                }



                if (i < grid.length - 1 && grid[i+1][j] == '1'){
                    adjecntLandsCount++;
                    if (adjecntLandsCount > 1){
                        continue;
                    }
                }

                if (j < grid[i].length - 1 && grid[i][j+1] == '1'){
                    adjecntLandsCount++;
                    if (adjecntLandsCount > 1){
                        continue;
                    }
                }

                count++;

            }
        }

        return count;

    }
}
