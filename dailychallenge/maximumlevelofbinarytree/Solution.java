package maximumlevelofbinarytree;

import java.util.LinkedList;
import java.util.Queue;

//TODO: Fix the code

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int index = 1, level = 2, levelVal = 0, maxVal = Integer.MIN_VALUE, maxValLevel = 1;
        maxVal = root.val;
        maxValLevel = 1;
        nodeQueue.add(root.left);
        nodeQueue.add(root.right);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (node == null) {
                index++;
                continue;
            }
            int currentLevel = (int) Math.ceil(Math.log(index) / Math.log(2)) + 1;
            if (currentLevel == level) {
                levelVal += node.val;
            } else {
                if (levelVal > maxVal) {
                    maxVal = levelVal;
                    maxValLevel = level;
                }
                levelVal = node.val;
                level = currentLevel;
            }
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
            index++;
        }
        if (levelVal > maxVal) {
            maxVal = levelVal;
            maxValLevel = level;
        }
        return maxValLevel;
    }

    public static void main(String[] args) {
        TreeNode tNode = new TreeNode(1,new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        Solution s = new Solution();
        int res= s.maxLevelSum(tNode);
        System.out.println(res);
    }
}