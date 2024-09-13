package com.Algorithmic_thinking.od;

import java.util.*;

/**
 * @author cgh
 * @create 2024/9/10
 * 题目描述：
 * <p>
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高三个分数之
 * <p>
 * 和进行降序排名，输出降序排名后的选手id序列。
 * <p>
 * 题目解析：
 * <p>
 * 给一个数字表示射击的次数，然后给几个选手进行（乱序）射击，生成对应的成绩！
 * <p>
 * 条件如下：
 * <p>
 * 一个选手可以有多个射击成绩的分数，且次序不固定
 * <p>
 * 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手
 * <p>
 * 如果选手的成绩之和相等，则相等的选手按照其id降序排列
 * <p>
 * 输入描述：
 * <p>
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（2<=N<=100）
 * <p>
 * 输入第二行，一个长度为N整数序列，表示参与每次射击的选手id（0<=id<=99）
 * <p>
 * 输入第三行，一个长度为N整数序列，表示参与每次射击选手对应的成绩（0<=成绩<=100）
 * <p>
 * 输出描述：
 * <p>
 * 符合题设条件的降序排名后的选手ID序列
 * <p>
 * 示例
 * <p>
 * 输入：
 * <p>
 * 13
 * <p>
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * <p>
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 * <p>
 * 输出：
 * <p>
 * 5,3,7,4
 * <p>
 * 作者：隔壁黄同学
 * 链接：https://www.nowcoder.com/discuss/355031991304151040?sourceSSR=search
 * 来源：牛客网
 */
public class ShootGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int playerCount = scanner.nextInt();
        scanner.nextLine();
        String[] player = scanner.nextLine().split(",");
        String[] score = scanner.nextLine().split(",");
        if (playerCount != player.length || playerCount != score.length) {
            System.out.println("error");
        }
        List<Integer> result = solution(player, score);
        System.out.println(Arrays.toString(result.toArray()));

    }

    private static List<Integer> solution(String[] player, String[] score) {
        Map<Integer, List<Integer>> kv = new HashMap<>();

        for (int i = 0; i < player.length; i++) {
            Integer p = Integer.parseInt(player[i]);
            Integer s = Integer.parseInt(score[i]);

            if (kv.get(p) == null) {
                ArrayList<Integer> scoreList = new ArrayList<>();
                scoreList.add(s);
                kv.put(p, scoreList);
            } else {
                kv.get(p).add(s);
            }
        }
        // 存访 玩家-前3排序分数和
        Map<Integer, Integer> resultMap = new HashMap<>();


        for (Map.Entry<Integer, List<Integer>> entry : kv.entrySet()) {
            List<Integer> socreList = entry.getValue();
            if (socreList.size() >= 3) {
                //升序，因为是要求前3最好成绩，所以再反转一下
                socreList.sort(Comparator.reverseOrder());
                int sum = socreList.stream().limit(3).mapToInt(Integer::intValue).sum();
                resultMap.put(entry.getKey(), sum);
            }
        }

        List<Integer> result = new ArrayList<>(resultMap.keySet());
        //比较分值，分支相同 比较id
        result.sort(
                (id1, id2) -> {
                    int score1 = resultMap.get(id1);
                    int score2 = resultMap.get(id2);
                    if (score1 != score2) {
                        return Integer.compare(score2, score1); // Descending order of scores
                    } else {
                        return Integer.compare(id2, id1); // Descending order of IDs
                    }
                }
        );
        return result;
    }

}
