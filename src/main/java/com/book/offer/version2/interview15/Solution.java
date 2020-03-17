package com.book.offer.version2.interview15;

/**
 * Created by yuntao.wu on 2020/3/17.
 * 二进制1的个数
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOne(15));
        System.out.println(solution.countOne2(15));
    }

    public int countOne(int num) {
        int count = 0;
        int help = 1;
        while(help != 0) {
            if ((num & help) != 0) {
                count++;
            }
            help <<= 1;
        }
        return count;
    }

    public int countOne2(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num-1);
            ++count;
        }
        return count;
    }
}
