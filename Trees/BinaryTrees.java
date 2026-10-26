import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
public class BinaryTrees {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //preorder traversalprinting
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);

        }

        //inorder traversal printing
        public static void inorder(Node root){

            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        //postorder traversal printing
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");

        }

        //level order traversal printing
        public static void levelOrderTraversal(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        //height of a tree
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        //count of Nodes
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftCount=countNodes(root.left);
            int rightCount=countNodes(root.right);

            return leftCount + rightCount +1;

        }

        //sum of all nodes
        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        //diameter of a tree
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }

            int leftDia = diameter(root.left);
            int rightDia = diameter(root.right);
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int maxDia = Math.max(leftDia,rightDia);

           int  selfDia = leftHeight+rightHeight+1;

           return Math.max(maxDia,selfDia);
        }

        //subtree in a main tree

        //step2: check if both trees are identical by checking if they are non identical
        // public static boolean isIdentical(Node root, Node subRoot){
        //     if(root==null && subRoot==null){
        //         return true;
        //     }
        //     else if(root==null || subRoot==null || root.data!=subRoot.data){
        //         return false;
        //     }
        //     return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        // }

        // //step1: find matching node root.data == subroot.data
        // public static boolean isSubtree(Node root,Node subRoot){
        //     if(subRoot==null){
        //         return true;    
        //     }
        //     if(root==null){
        //         return false;
        //     }
        //     if(root.data == subRoot.data){
        //         if(isIdentical(root,subRoot)){
        //             return true;
        //         }
        //     }

        //     return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        // }


        //public static is subtree

        public static boolean isIdentical(Node root,Node subRoot){
            if(root==null && subRoot==null){
                return true;
            }
            if(root==null || subRoot==null || root.data!=subRoot.data){
                return false;
            }
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }

        public static boolean isSubtree(Node root,Node subRoot){
                if(subRoot==null){
                    return true;
                }
                if(root==null){
                    return false;
                }
                if(root.data==subRoot.data){
                    if(isIdentical(root,subRoot)){
                        return true;
                    }
                }

                return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot); 
        }


        static class Info{
            Node node;
            int hd;
            Info(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }


        //top view of a tree
        public void topView(Node root){
            if(root==null){
                return;
            }
            int min = 0;
            int max = 0;
            HashMap<Integer,Node> map = new HashMap<>();
            Queue<Info> q = new LinkedList<>();
            
            //level order traversal
            q.add(new Info(root,0));
            q.add(null);

            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr==null){
                    if(!q.isEmpty()){
                        q.add(null);
                    }else{
                        break;
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd,curr.node);
                    }
                    if(curr.node.left!=null){
                        q.add(new Info(curr.node.left,curr.hd-1));
                        min=Math.min(min,curr.hd-1);
                    }
                    if(curr.node.right!=null){
                        q.add(new Info(curr.node.right,curr.hd+1));
                        max = Math.max(max,curr.hd+1);
                    }

                }
            }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }

        //Kth level of tree
        public void kthLevel(Node root,int k,int level){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            kthLevel(root.left, k, level+1);
            kthLevel(root.right, k, level+1);
            return;
        }

        //lowes common ancestor of a tree
        public Node lca(Node root,int n1,int n2){ //O(n)
            if(root==null || root.data==n1 || root.data==n2){
                return root;
            }
            Node leftlca = lca(root.left,n1,n2);
            Node rightlca = lca(root.right,n1,n2);

            if(leftlca==null){
                return rightlca;
            }
            if(rightlca==null){
                return leftlca;
            }
            return root;

        }


        public int minDistValue(Node root,int n){
            if(root==null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }
            int leftVal=minDistValue(root.left,n);
            int rightVal = minDistValue(root.right,n);
            if(leftVal>-1){
                return leftVal+1;
            }
            if(rightVal>-1){
                return rightVal+1;
            }
            

            return -1;

        }

        //min distance between two nodes
        public int minDist(Node root,int n1,int n2){
            Node lcaNode = lca(root,n1,n2);
            int minDistance = minDistValue(lcaNode, n1) + minDistValue(lcaNode, n2);
            return minDistance;
        }
    }



    public static void main(String args[]){

        BinaryTree tree = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        BinaryTree tree3 = new BinaryTree();
        int nodes[] = {1, 4, -1, -1, 5, -1, 3, -1, 6, -1, -1};
        int subNodes[] = {2, 4, -1, -1, 5, -1, -1};
        Node root = tree.buildTree(nodes);
        // Node subRoot=tree2.buildTree(subNodes);
        // System.out.println(tree3.isSubtree(root, subRoot));
        // tree.topView(root);
        // tree.kthLevel(root, 2, 0);
        System.out.println(tree.lca(root, 4, 6).data);


    }
}
