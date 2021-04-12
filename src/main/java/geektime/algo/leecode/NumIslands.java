package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-07 08:02
 * @description: 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 */
public class NumIslands {

    // 网格遍历通用逻辑
    void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return  r>=0 && r < grid.length
                && c >=0 && c< grid[0].length;
    }

    //695-- 岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c =0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    int ans = area(grid, r, c);
                    maxArea = Math.max(ans, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return 1
                + area(grid, r, c-1)
                + area(grid, r, c+1)
                + area(grid, r-1, c)
                + area(grid, r+1, c);
    }

    // 827. 最大人工岛（Hard）

   // 463. 岛屿的周长
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c =0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    return perimeter(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int perimeter(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] == 2) {
            return 0;
        }
        grid[r][c] = 2;
        return perimeter(grid, r, c-1)
                + perimeter(grid, r, c+1)
                + perimeter(grid, r-1, c)
                + perimeter(grid, r +1, c);
    }

    // 200. 岛屿数量
    public int numIslands(char[][] grid) {
        int nums = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c =0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    nums++;
                    dfs1(grid, r, c);
                }
            }
        }

        return nums;
    }

    private void dfs1(char[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea1(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs1(grid, r - 1, c);
        dfs1(grid, r + 1, c);
        dfs1(grid, r, c - 1);
        dfs1(grid, r, c + 1);
    }

    private boolean inArea1(char[][] grid, int r, int c) {
        return  r>=0 && r < grid.length
                && c >=0 && c< grid[0].length;
    }

}