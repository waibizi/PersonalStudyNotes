package com.waibizi.solution_1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author 歪鼻子
 * @Date 2020/6/17 18:45
 * @Description:
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        if (root != null) queue.add(root);
        int flag = 1;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i>0; i--){   //妙啊，for值记录一次初始化，利用这个特性，可以达到一次赋值之后概念queue的大小
                TreeNode node =queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (result.size()%2 ==1) Collections.reverse(list);
            result.add(list);
        }
        return result;
    }
}
