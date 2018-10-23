package cn.like.study.algorithm;

import java.util.Scanner;

/**
 * @program: MyCode
 * @description: 数独问题
 * @author: like
 * @create: 2018-10-23 15:27
 **/
public class Shudu {
    public static final int N = 3;

    public static void main(String[] args) {
        int x[][] = {
                {0, 0, 0, 0, 1, 3, 4, 0, 0},
                {0, 8, 0, 0, 0, 6, 9, 5, 0},
                {6, 5, 0, 0, 0, 0, 0, 0, 0},
                {9, 6, 0, 2, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 7, 0, 0, 0, 2},
                {0, 0, 0, 3, 0, 4, 0, 1, 6},
                {0, 0, 0, 0, 0, 0, 0, 7, 9},
                {0, 2, 5, 8, 0, 0, 0, 4, 0},
                {0, 0, 9, 7, 6, 0, 0, 0, 0}
        };
        //int x[][] = init();
        long start = System.currentTimeMillis();
        fillCell(x, 0, 0);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("用时" + time + "毫秒");
        print(x);
    }

    private static int[][] init() {
        int[][] grid = new int[9][9];
        for (int i = 0; i < grid.length; i++) {
            System.out.print("请输入第" + (i + 1) + "行，以逗号分开：");
            Scanner scan = new Scanner(System.in); // 从键盘接收数据
            String num[] = scan.next().split(",");
            while (num.length != 9) {
                System.out.println("请重新输入第" + (i + 1) + "行，以逗号分开：");
                scan = new Scanner(System.in); // 从键盘接收数据
                num = scan.next().split(",");
            }
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = Integer.parseInt(num[j]);
            }
        }
        return grid;
    }

    private static boolean fillCell(int[][] x, int r, int c) {
        for (int i = 1; i <= 9; i++) {
            x[r][c] = i;
            if (checkNum(x, r, c)) {
                int rc[] = nextRC(x, r, c);
                if (rc[0] < 9 && rc[1] < 9) {
                    boolean next = fillCell(x, rc[0], rc[1]);
                    if (next) {
                        return true;
                    } else {
                        continue;
                    }
                } else {
                    //最后一个单元格取数成功
                    return true;
                }
            }
        }
        x[r][c] = 0;
        return false;
    }

    private static int[] nextRC(int[][] x, int r, int c) {
        c++;
        if (c >= 9) {
            r++;
            c = 0;
        }
        if (r < 9 && x[r][c] != 0) {
            return nextRC(x, r, c);
        } else {
            int rc[] = {r, c};
            return rc;
        }
    }

    private static boolean checkNum(int[][] x, int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (i != r && x[i][c] == x[r][c]) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (j != c && x[r][j] == x[r][c]) {
                return false;
            }
        }
        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if (!(i == r && j == c) && x[i][j] == x[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
