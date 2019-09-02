package solution_34;

/**
 * 面试题33：打印和为某一值的路径。注意在这题中，走到根节点才算一条路径！还有就是慎用static变量！防止出现上一组数据值影响下一组数据输出结果的情况！
 */

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> vec=new ArrayList<>();
        travel(root,target,vec);
        return result;
    }

    void travel(TreeNode root,int target,ArrayList<Integer> vec){
        if(root==null) return;
        int sum=target-root.val;
        vec.add(root.val);
        if(sum==0 && root.left==null && root.right==null)
            result.add(new ArrayList<>(vec));

        travel(root.left,sum,vec);
        travel(root.right,sum,vec);

        vec.remove(vec.size()-1);

    }
}