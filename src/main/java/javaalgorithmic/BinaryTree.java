package javaalgorithmic;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class BinaryTree {
    //创建树的起点
    private TreeNode root = null;
    //初始化二叉树
    public BinaryTree() {
        root = new TreeNode() {
            @Override
            public TreeNode getChildAt(int childIndex) {
                return null;
            }

            @Override
            public int getChildCount() {
                return 0;
            }

            @Override
            public TreeNode getParent() {
                return null;
            }

            @Override
            public int getIndex(TreeNode node) {
                return 0;
            }

            @Override
            public boolean getAllowsChildren() {
                return false;
            }

            @Override
            public boolean isLeaf() {
                return false;
            }

            @Override
            public Enumeration children() {
                return null;
            }
        };
    }
    /**
     *
     */
}
