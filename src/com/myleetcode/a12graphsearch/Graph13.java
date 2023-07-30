package com.myleetcode.a12graphsearch;

import java.util.*;

/**
 * @author eniac555
 * @date 2023/7/30
 * @description: 单词接龙
 */
public class Graph13 {
    /*
    要求：
    字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
    序列中第一个单词是 beginWord 。
    序列中最后一个单词是 endWord 。
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典 wordList 中的单词。
    给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
    找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。

    示例：
    输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    输出：5
    解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。

    思路：
    需要自己构图，两个单词只有一个字母不同，即可存在连接
    最短路径，只能是广搜了
    本题是一个无向图，需要用标记位，标记着节点是否走过，否则就会死循环
     */


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度

        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }

        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);

        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词
            int path = map.get(word); //获取到该单词的路径长度
            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        queue.offer(newWord);//加入队尾
                    }
                }
            }
        }
        return 0; //未找到
    }
}
