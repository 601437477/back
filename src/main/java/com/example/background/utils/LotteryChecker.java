package com.example.background.utils;


import com.example.background.domain.LotteryItem;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryChecker {
    private static final List<Integer> r = Arrays.asList(1, 2, 7, 8, 12, 13, 18, 19, 23, 24, 29, 30, 34, 35, 40, 45, 46);
    private static final List<Integer> b = Arrays.asList(3, 4, 9, 10, 14, 15, 20, 25, 26, 31, 36, 37, 41, 42, 47, 48);
    private static final List<Integer> g = Arrays.asList(5, 6, 11, 16, 17, 21, 22, 27, 28, 32, 33, 38, 39, 43, 44, 49);

    public static boolean isWin(LotteryItem lottery, List<String> lotteryNums) {
        String data = lottery.getData();
        int kind = lottery.getKind();
        int type = lottery.getType();

        // 特码
        if (kind == 1) {
            int lotteryNum = Integer.parseInt(lotteryNums.get(6));
            // 数字
            if (type == 0) {
                return Integer.parseInt(data) == lotteryNum;
            }
            // 大
            if (data.equals("101")) {
                return lotteryNum >= 25;
            }
            // 小
            if (data.equals("102")) {
                return lotteryNum <= 24;
            }
            // 单
            if (data.equals("111")) {
                return lotteryNum % 2 == 1;
            }
            // 双
            if (data.equals("112")) {
                return lotteryNum % 2 == 0;
            }
            // 红
            if (data.equals("121")) {
                return r.contains(lotteryNum);
            }
            // 绿
            if (data.equals("122")) {
                return g.contains(lotteryNum);
            }
            // 蓝
            if (data.equals("123")) {
                return b.contains(lotteryNum);
            }
        }

        // 正码1-6
        if (kind == 3) {
            int lotteryNum;
            // 正码
            if (type >= 1 && type <= 6) {
                lotteryNum = Integer.parseInt(lotteryNums.get(type - 1));
                return Integer.parseInt(data) == lotteryNum;
            }

            // 大小
            if (type >= 11 && type <= 16) {
                lotteryNum = Integer.parseInt(lotteryNums.get(type - 11));
                if (data.equals("101")) { // 大
                    return lotteryNum >= 25;
                }
                if (data.equals("102")) { // 小
                    return lotteryNum <= 24;
                }
            }

            // 单双
            if (type >= 21 && type <= 26) {
                lotteryNum = Integer.parseInt(lotteryNums.get(type - 21));
                if (data.equals("111")) { // 单
                    return lotteryNum % 2 == 1;
                }
                if (data.equals("112")) { // 双
                    return lotteryNum % 2 == 0;
                }
            }

            // 波色
            if (type >= 31 && type <= 36) {
                lotteryNum = Integer.parseInt(lotteryNums.get(type - 31));
                if (data.equals("121")) { // 红
                    return r.contains(lotteryNum);
                }
                if (data.equals("122")) { // 绿
                    return g.contains(lotteryNum);
                }
                if (data.equals("123")) { // 蓝
                    return b.contains(lotteryNum);
                }
            }
        }

        // 连码
        if (kind == 5) {
            List<String> nums = Arrays.asList(lotteryNums.subList(0, 6).toArray(new String[0]));
            Set<String> numSet = new HashSet<>(nums);
            List<String> dataList = Arrays.asList(data.split(","));
            List<Integer> dataNums = dataList.stream().map(Integer::parseInt).collect(Collectors.toList());

            // 三中二
            if (type == 1) {
                for (String num : dataList) {
                    if (!numSet.contains(num)) {
                        return false;
                    }
                }
                return true;
            }

            // 二中二
            if (type == 2) {
                for (String num : dataList) {
                    if (!numSet.contains(num)) {
                        return false;
                    }
                }
                return true;
            }

            // 二中二包特 之中二平
            if (type == 3) {
                List<Integer> dataNumsList = new LinkedList<>(dataNums);
                for (String num : nums) {
                    if (dataNumsList.contains(Integer.parseInt(num))) {
                        dataNumsList.remove(Integer.parseInt(num));
                    }
                }
                return dataNumsList.size() == 2;
            }

            // 二中二包特 之一特一平
            if (type == 4) {
                for (String num : dataList) {
                    if (numSet.contains(num)) {
                        numSet.remove(num);
                    }
                }
                return numSet.size() == 1 && numSet.contains(lotteryNums.get(6));
            }

            // 十中三
            if (type == 5) {
                int count = 0;
                for (String num : dataList) {
                    if (numSet.contains(num)) {
                        count++;
                    }
                }
                return count >= 3;
            }
        }

        // 平特1肖2肖3肖4肖5肖
        if (kind == 6) {
            String[] dataList = data.split(",");
            List<Integer> lists = lotteryNums.stream().map(Integer::parseInt).collect(Collectors.toList());

            for (String item : dataList) {
                List<Integer> collect = Arrays.stream(item.split(",")).map(Integer::parseInt).collect(Collectors.toList());
                if (collect.stream().noneMatch(lists::contains)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }


}
