package com.leetcode.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by wuyuntao on 2025/5/6
 * 某店铺将用于组成套餐的商品记作字符串 goods，其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。
 * 返回结果 无顺序要求，但不能含有重复的元素。
 *
 * 示例 1：
 * 输入：goods = "agew"
 * 输出：["aegw","aewg","agew","agwe","aweg","awge","eagw","eawg","egaw","egwa","ewag","ewga","gaew","gawe","geaw","gewa","gwae","gwea","waeg","wage","weag","wega","wgae","wgea"]
 *
 * 提示：1 <= goods.length <= 8
 */
public class ProblemLCR157 {
    private final List<String> result = new LinkedList<>();
    private char[] chars = null;


    private final HashSet<String> dupSet = new HashSet<>();

    public static void main(String[] args) {
        ProblemLCR157 problemLCR157 = new ProblemLCR157();
        String[] result = problemLCR157.goodsOrder("agew");

        for (String s : result) {
            System.out.println(s);
        }
    }

    // standard
    public String[] goodsOrder(String goods) {
        if (goods == null) {
            return null;
        }
        chars = goods.toCharArray();
        dfs(0);
        return result.toArray(new String[]{});
    }

    private void dfs(int n) {
        if (n == chars.length) {
            result.add(String.valueOf(chars));
            return;
        }
        Set<Character> dupSet = new HashSet<>();
        for (int i = n;i < chars.length; i++) {
            if (dupSet.contains(chars[i])) {
                continue;
            }
            dupSet.add(chars[i]);
            swap(n, i);
            dfs(n+1);
            swap(n, i);
        }
    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }





    public String[] goodsOrder2(String goods) {
        List<String> result = new LinkedList<>();

        checkOrder(goods, "", result);
        return result.toArray(new String[0]);
    }

    private void checkOrder(String ori, String finalStr, List<String> result) {
        if ("".equals(ori)) {
            if (!dupSet.contains(finalStr)) {
                result.add(finalStr);
                dupSet.add(finalStr);
            }
            return;
        }
        for (int i = 0; i < ori.length(); i++) {
            checkOrder(ori.substring(0, i) + ori.substring(i+1), finalStr + ori.charAt(i), result);
        }
    }
}
