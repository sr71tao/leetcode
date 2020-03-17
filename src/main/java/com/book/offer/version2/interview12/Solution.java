package com.book.offer.version2.interview12;

/**
 * Created by yuntao.wu on 2020/3/15.
 * 矩阵中路径
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isExistPath(
                new char[][]{
                        {'a','b','t','g'},
                        {'c','f','c','s'},
                        {'j','d','e','h'}
                },
                "ecsg"
        ));
    }


    private boolean isExistPath(char[][] arr, String path) {
        if (path == null || path.length() < 1 || arr == null || arr.length < 1) {
            return false;
        }
        int ylen = arr.length;
        int xlen = arr[0].length;

        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (pathRecur(arr, i, j , path, 0, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * @param arr
     * @param x
     * @param y
     * @param path 路径
     * @param idx path idx
     * @param direction 来自方向 1上 2右 3下 4左
     * @return
     */
    private boolean pathRecur(char[][] arr, int x, int y, String path, int idx, int direction) {
        if (idx >= path.length()) {
            return true;
        }
        if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0) {
            return false;
        }
        if (arr[x][y] == 0 || arr[x][y] != path.charAt(idx)) {
            return false;
        }
        arr[x][y] = 0;
        int dict = 1;
        while(dict <= 4) {
            if (dict == direction) {
                ++dict;
                continue;
            }
            boolean isExit = false;
            switch(dict) {
                case 1:
                    isExit = pathRecur(arr, x, y-1, path, idx+1, 3);
                    break;
                case 2:
                    isExit = pathRecur(arr, x+1, y, path, idx+1, 4);
                    break;
                case 3:
                    isExit = pathRecur(arr, x, y+1, path, idx+1, 1);
                    break;
                case 4:
                    isExit = pathRecur(arr, x-1, y, path, idx+1, 2);
                    break;
                default:
                    return false;
            }
            if (isExit) {
                return true;
            }
            ++dict;
        }
        arr[x][y] = path.charAt(idx);
        return false;
    }
}
