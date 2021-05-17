package org.czh.interview.amuse_interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : czh
 * description : 数独运算
 * date : 2021-05-16
 * email 916419307@qq.com
 */
public class ShuDu {

    private static final Map<Integer, Number> allMap = new HashMap<>(81); // 总键值对
    private static final Map<Integer, Number> zeroMap = new HashMap<>(81); // 0键值对
    private static final Map<Integer, Map<Integer, Number>> rowMapMap = new HashMap<>(9); // 行键值对
    private static final Map<Integer, Map<Integer, Number>> columnMapMap = new HashMap<>(9); // 列键值对
    private static final Map<Integer, Map<Integer, Number>> gongMapMap = new HashMap<>(9); // 宫键值对
    private static final boolean printFalse = false;

    /**
     * 启动函数
     */
    public static void main(String[] args) {
        String text;
        if (args != null && args.length == 1) {
            text = args[0];
        } else {
            text = systemIn();
        }
        ready(text);
        boolean flag = compare();
        if (flag) {
            printFalse();
            printTrue();
        }
    }

    /**
     * 打印完结
     */
    private static void printTrue() {
        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------------------------------\n");
        int rowResult = 0;
        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            int column = i % 9;
            Number number = allMap.get(i);
            int num = number.getNum();
            if (row != rowResult) {
                rowResult = row;
                builder.append("    ||\n-------------------------------------------------\n");
            }
            if (column % 3 == 0) {
                builder.append("    ||    ").append(num);
            } else {
                builder.append(num);
            }
        }
        builder.append("    ||\n-------------------------------------------------\n\n\n");
        System.out.print(builder);
    }

    /**
     * 打印未完结
     */
    private static void printFalse() {
        if (!printFalse) {
            return;
        }
        int rowResult = 0;
        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            Number number = allMap.get(i);
            int num = number.getNum();
            if (row != rowResult) {
                rowResult = row;
                System.out.println();
            }
            System.out.print(num);
            if (num == 0) {
                StringBuilder builder = new StringBuilder("[");
                for (Integer suspected : number.getSuspectedSet()) {
                    builder.append(suspected).append(",");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append("]");
                System.out.print(builder);
            }
        }
        System.out.println("\n\n");
    }

    /**
     * 检查是否完结
     */
    private static boolean checkZero() {
        return zeroMap.size() == 0;
    }

    /**
     * 最多循环100次，比较行列宫
     */
    private static boolean compare() {
        for (int i = 0; i < 100; i++) {
            boolean change = compareMapMap(rowMapMap);
            change = compareMapMap(columnMapMap) || change;
            change = compareMapMap(gongMapMap) || change;
            if (checkZero()) {
                return true;
            }
            if (!change) {
                return false;
            }
            printFalse();
        }
        return false;
    }

    /**
     * 比较行列宫
     */
    private static boolean compareMapMap(Map<Integer, Map<Integer, Number>> mapMap) {
        boolean change = false;
        for (Map<Integer, Number> map : mapMap.values()) {
            Map<Integer, Integer> timeMap = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                Number number = map.get(i);
                if (number.getNum() != 0) {
                    continue;
                }
                Set<Integer> suspectedSet = number.getSuspectedSet();
                if (suspectedSet.size() == 1) {
                    for (Integer suspected : suspectedSet) {
                        number.setExact(suspected, zeroMap);
                        change = true;
                    }
                }
                for (Integer suspected : suspectedSet) {
                    Integer time = timeMap.get(suspected);
                    if (time == null) {
                        timeMap.put(suspected, 1);
                    } else {
                        timeMap.put(suspected, ++time);
                    }

                }
            }

            for (Map.Entry<Integer, Integer> timeEntry : timeMap.entrySet()) {
                Integer value = timeEntry.getValue();
                if (value == 1) {
                    Integer key = timeEntry.getKey();
                    for (int i = 0; i < 9; i++) {
                        Number number = map.get(i);
                        if (number.getNum() != 0) {
                            continue;
                        }
                        boolean contains = number.getSuspectedSet().contains(key);
                        if (contains) {
                            number.setExact(key, zeroMap);
                            change = true;
                        }
                    }
                }
            }
        }
        return change;
    }

    /**
     * 计算疑似值
     */
    private static void calculateSuspected() {
        for (int i = 0; i < 81; i++) {
            Number number = allMap.get(i);
            number.cleanSuspectedSet();
            if (number.getNum() != 0) {
                continue;
            }
            number.addSuspected();
        }
    }

    /**
     * 准备工作
     */
    private static void ready(String text) {
        char[] cs = text.toCharArray();
        assert cs.length == 81;

        for (int i = 0; i < cs.length; i++) {
            int num = Integer.parseInt(String.valueOf(cs[i]));
            int row = i / 9;
            int column = i % 9;
            int gong = (row / 3) * 3 + column / 3;

            // 构建Number实体
            Number number = new Number(i, num);
            // 记录所有Number
            allMap.put(i, number);

            // 记录所有为0的Number
            if (num == 0) {
                zeroMap.put(i, number);
            }

            // 记录到所在行
            Map<Integer, Number> rowMap = rowMapMap.computeIfAbsent(row, k -> new HashMap<>());
            rowMap.put(rowMap.size(), number);
            number.setRowMap(rowMap);

            // 记录到所在列
            Map<Integer, Number> columnMap = columnMapMap.computeIfAbsent(column, k -> new HashMap<>());
            columnMap.put(columnMap.size(), number);
            number.setColumnMap(columnMap);

            // 记录到所在列
            Map<Integer, Number> gongMap = gongMapMap.computeIfAbsent(gong, k -> new HashMap<>());
            gongMap.put(gongMap.size(), number);
            number.setGongMap(gongMap);
        }
        // 统计疑似值
        calculateSuspected();
    }

    /**
     * 获取文本
     */
    private static String systemIn() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static class Number {

        /**
         * 偏移量索引
         */
        private final int id;
        /**
         * 数值，准确值为1-9，空值为0
         */
        private int num;

        public Number(int id, int num) {
            this.id = id;
            this.num = num;
        }

        /**
         * 疑似值Set集合
         */
        private final Set<Integer> suspectedSet = new HashSet<>(9);

        /**
         * 清空疑似值Set集合
         */
        public void cleanSuspectedSet() {
            suspectedSet.clear();
        }

        /**
         * 设置准确值
         */
        public void setExact(int exact, Map<Integer, Number> zeroMap) {
            // 设置准确值
            this.num = exact;
            // 清空疑似集合，准确值疑似集合为空
            cleanSuspectedSet();
            // 移除空Map中的当前对象
            zeroMap.remove(this.id);
            // 移除当前对象所在的行中，其它位置猜测的疑似值中，有猜测为 exact 这个值的记录
            this.rowMap.values().forEach(rowNumber -> rowNumber.getSuspectedSet().remove(exact));
            // 移除当前对象所在的列中，其它位置猜测的疑似值中，有猜测为 exact 这个值的记录
            this.columnMap.values().forEach(columnNumber -> columnNumber.getSuspectedSet().remove(exact));
            // 移除当前对象所在的宫中，其它位置猜测的疑似值中，有猜测为 exact 这个值的记录
            this.gongMap.values().forEach(gongNumber -> gongNumber.getSuspectedSet().remove(exact));
        }

        /**
         * 添加疑似值到Set集合
         */
        public void addSuspected() {
            if (num != 0) {
                return;
            }

            abc:
            for (int j = 1; j <= 9; j++) {
                // 判断当前对象所在的行，有没有这个疑似值，有则直接否定，没有再去判断列
                for (Number number : rowMap.values()) {
                    if (number.getNum() == j) {
                        continue abc;
                    }
                }

                // 判断当前对象所在的列，有没有这个疑似值，有则直接否定，没有再去判断宫
                for (Number number : columnMap.values()) {
                    if (number.getNum() == j) {
                        continue abc;
                    }
                }

                // 判断当前对象所在的宫，有没有这个疑似值，有则直接否定，没有就记录到疑似值Set集合中
                for (Number number : gongMap.values()) {
                    if (number.getNum() == j) {
                        continue abc;
                    }
                }

                this.suspectedSet.add(j);
            }
        }

        /**
         * 当前对象所在的行
         */
        private Map<Integer, Number> rowMap;
        /**
         * 当前对象所在的列
         */
        private Map<Integer, Number> columnMap;
        /**
         * 当前对象所在的宫
         */
        private Map<Integer, Number> gongMap;

        /**
         * toString方法
         * 方便调试模式
         * 按需调节
         */
        @Override
        public String toString() {
            return "Number{" + "id=" + id + ", num=" + num + ", suspectedSet=" + suspectedSet + '}';
        }

        public int getNum() {
            return num;
        }

        public Set<Integer> getSuspectedSet() {
            return suspectedSet;
        }

        public void setRowMap(Map<Integer, Number> rowMap) {
            this.rowMap = rowMap;
        }

        public void setColumnMap(Map<Integer, Number> columnMap) {
            this.columnMap = columnMap;
        }

        public void setGongMap(Map<Integer, Number> gongMap) {
            this.gongMap = gongMap;
        }
    }
}
