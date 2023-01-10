package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;
    
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    // Pre-Order traversal of a Binary Tree
    /* Follow the below steps at each node:
     *  1. visit the root node
     *  2. visit the left node
     *  3. visit the right node
     */
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Iterative Pre-Order traversal
    public void iterativePreOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(! stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    // in-Order traversal
    /* Follow the below steps at each node:
     * 1. Visit the left subtree
     * 2. Visit the root
     * 3. Visit the right sub tree
     */

    public void inOrder(TreeNode root){
        if(root == null){ // Base condition
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Iterative In-Order traversal 
    public void iter_InOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }      
        }
    }

    // Post-Order traversal
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }


    public void iter_PostOrder(TreeNode root) {
       if(root == null){
            return;
       }
       TreeNode curr = root;
       Stack<TreeNode> stack = new Stack<>();
       while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else{
                    curr = temp;
                }
            }
       }

    }

    // Maximum depth of a Binary Tree
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1+ Math.max(leftDepth, rightDepth);
    }

    // Left or Right View of a Tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode currNode, List<Integer> result, int level){
        if(currNode == null){
            return;
        }
        if(level == result.size()){
            result.add(currNode.data);
        }
        rightView(currNode.right, result, level+1);
        rightView(currNode.left, result, level+1);
    }

    public static void main(String[] args){
        BinaryTree obj = new BinaryTree();
        obj.createBinaryTree();
        System.out.println("Pre Order traversal of a Binary Tree: ");
        obj.preOrder(obj.root);
        System.out.println("Iterative Approach: ");
        obj.iterativePreOrder(obj.root);

        System.out.println();
        System.out.println("In-Order traversal of a Binary Tree: ");
        obj.inOrder(obj.root);

        System.out.println();
        System.out.println("Iterative In-Order traversal: ");
        obj.iter_InOrder(obj.root);

        System.out.println();
        System.out.println("Post-Order traversal of a Binary Tree: ");
        obj.postOrder(obj.root);
        
        System.out.println();
        System.out.println("Post-Order traversal of a Binary Tree: ");
        obj.iter_PostOrder(obj.root);

        System.out.println("Max Depth of the tree: "+obj.maxDepth(obj.root));

        System.out.println("Right View: "+obj.rightSideView(obj.root));
    }
}
