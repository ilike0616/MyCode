package cn.like.study.algorithm;

import java.util.*;

/**
 * @program: MyCode
 * @description: 狄克斯特拉算法
 * 算法步骤：1.判断是否有未处理的节点
 * 2.若有，获得其中离起点最近的节点
 * 3.遍历该节点所有邻居并更行其开销
 * 4.如果有邻居的开销被更新，同时更新父节点
 * 5.该节点标记为已处理
 * 6.重复第1步
 * @author: like
 * @create: 2018-04-22 10:49
 **/
public class Dijkstra {
    //设置没有已知到达路径的标记
    private static int NOWAY_SIGN = Integer.MAX_VALUE;
    private static final String START = "start";
    private static final String END = "end";

    public void getMinStep(String start, String end, Map<String, Map<String, Integer>> graph) {
        //各节点的最少花费
        Map<String, Integer> costs = graph.get(start);
        //各节点最少花费时的父节点
        Map<String, String> parents = new HashMap<String, String>();
        //已处理的节点
        HashSet<String> processed = new HashSet<String>();
        //在未处理的节点中找到开销最小的节点
        String node = findLowestCostNode(costs, processed);
        while (node != null && graph.get(node) != null) {
            int cost = costs.get(node);
            //遍历当前节点的所有邻居
            Iterator iterator = graph.get(node).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
                //通过node节点到该节点的最小消耗
                int newCost = cost + entry.getValue();
                //更新从start到该节点的最小消耗
                if (!costs.containsKey(entry.getKey()) || costs.get(entry.getKey()) > newCost) {
                    costs.put(entry.getKey(), newCost);
                    parents.put(entry.getKey(), node);
                }
            }
            //该节点加入已处理
            processed.add(node);
            //找出当前最小消耗的节点
            node = findLowestCostNode(costs, processed);
        }
        printPath(parents, costs.get(END));
    }

    public void initParents(String start, Map<String, Integer> startGraph, Map<String, String> parents) {
        Iterator iterator = startGraph.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
            parents.put(entry.getKey(), start);
        }
    }

    /**
     * 找出未处理节点中消耗最小的节点
     *
     * @param costs
     * @param processed
     * @return
     */
    public String findLowestCostNode(Map<String, Integer> costs, HashSet<String> processed) {
        int lowestCost = NOWAY_SIGN;
        String lowestCostNode = null;
        Iterator iterator = costs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
            if (!processed.contains(entry.getKey()) && entry.getValue() < lowestCost) {
                lowestCost = entry.getValue();
                lowestCostNode = entry.getKey();
            }
        }
        return lowestCostNode;
    }

    public void printPath(Map<String, String> parents, int cost) {
        Stack<String> stack = new Stack<String>();
        String parent = parents.get(END);
        while (parent != null) {
            if (START.equalsIgnoreCase(parent)) {
                stack.push(START);
                break;
            }
            stack.push(parent);
            parent = parents.get(parent);
        }
        StringBuffer path = new StringBuffer();
        while (!stack.empty()) {
            String node = stack.pop();
            if (path.length() != 0) {
                path.append("->");
            }
            path.append(node);
        }
        System.out.println("最优路线：" + START + "->" + path.toString() + "->" + END);
        System.out.println("其开销为：" + cost);
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>();
        Map<String, Integer> start = new HashMap<String, Integer>();
        start.put("A", 5);
        start.put("B", 2);
        graph.put(START, start);
        Map<String, Integer> a = new HashMap<String, Integer>();
        a.put("C", 4);
        a.put("D", 2);
        graph.put("A", a);
        Map<String, Integer> b = new HashMap<String, Integer>();
        b.put("A", 8);
        b.put("D", 7);
        graph.put("B", b);
        Map<String, Integer> c = new HashMap<String, Integer>();
        c.put("D", 6);
        c.put(END, 3);
        graph.put("C", c);
        Map<String, Integer> d = new HashMap<String, Integer>();
        d.put(END, 1);
        graph.put("D", d);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.getMinStep(START, END, graph);
    }
}
