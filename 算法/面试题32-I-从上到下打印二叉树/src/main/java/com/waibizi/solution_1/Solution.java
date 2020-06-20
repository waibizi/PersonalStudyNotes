package com.waibizi.solution_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author 歪鼻子
 * @Date 2020/6/17 11:12
 * @Description: 采用队列的思想，把树的结构进行遍历之后输出
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
        int[] real = new int[result.size()];
        for (int i = 0;i<result.size();i++){
            real[i] = result.get(i);
        }
        return real;
    }
}
