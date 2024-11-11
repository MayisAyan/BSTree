import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int value;
    Node left;
    Node right;
    Node(int key){
        value = key;
        left = null;
        right = null;
    }
}

class BinarySearchTree{
    Node root;
    BinarySearchTree(){
        root = null;
    }

    public void insert(int data){
        if(root == null){
            root = new Node(data);
        }else{
            insertHelper(root, data);
        }
    }


    public void insertIterative(int data){
        Node temp = root;
        while(temp != null){
            if(temp.value > data){
                if(temp.left == null){
                    temp.left = new Node(data);
                    return;
                }
                temp = temp.left;
            }
            else if(temp.value < data){
                if(temp.right == null){
                    temp.right = new Node(data);
                    return;
                }
                temp = temp.right;
            }
        }
    }


    public Node find(int data){
        return findHelper(root, data);
    }

    public Node findIterative(int data){
        if(root == null || root.value == data){
            return root;
        }
        Node temp = root;
        while(temp != null){
            if(temp.value > data){
                if(temp.left != null) {
                    temp = temp.left;
                    if (temp.value == data) {
                        return temp;
                    }
                }
            }else{
                if(temp.right != null) {
                    temp = temp.right;
                    if (temp.value == data) {
                        return temp;
                    }
                }
            }
        }
        return temp;
    }


    public Node minNode(Node node) {
        if (node.left != null)
            return minNode(node.left);
        else
            return node;
    }

    public void remove(int data){
        removeHelper(root, data);
    }

    public void printInorderRecursive(Node node){
        if(node == null){
            return;
        }
        printInorderRecursive(node.left);
        System.out.print(node.value + " ");
        printInorderRecursive(node.right);
    }

    public void printPreorderRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreorderRecursive(node.left);
        printPreorderRecursive(node.right);
    }

    public void printPostorderRecursive(Node node) {
        if (node == null){
            return;
        }
        printPostorderRecursive(node.left);
        printPostorderRecursive(node.right);
        System.out.print(node.value + " ");
    }

    private Node removeHelper(Node node, int data){
        if(node == null){
            return null;
        }else{
            if(node.value > data){
                node.left = removeHelper(node.left, data);
            }
            else if(node.value < data){
                node.right = removeHelper(node.right, data);
            }
            else{
                if(node.left == null && node.right == null){
                    node = null;
                }
                else if(node.left == null){
                    node = node.right;
                }
                else if(node.right == null){
                    node = node.left;
                }
                else{
                    Node temp = minNode(node.right);
                    node.value = temp.value;
                    node.right = removeHelper(node.right, data);
                }
            }
            return node;
        }
    }


    public void printPostOrderIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(node);
        while(!st1.isEmpty()){
            Node tmp = st1.pop();
            st2.push(tmp);
            if(tmp.left != null){
                st1.push(tmp.left);
            }
            if(tmp.right != null){
                st1.push(tmp.right);
            }
        }
        while(!st2.isEmpty()){
            Node tmp = st2.pop();
            System.out.print(tmp.value + " ");
        }
    }

    public void printPreOrderIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            Node tmp = st.peek();
            System.out.print(tmp.value + " ");
            st.pop();

            if(tmp.right != null){
                st.push(tmp.right);
            }
            if(tmp.left != null){
                st.push(tmp.left);
            }
        }
    }
    public void printInOrderIterative(Node node){
        if(node == null){
            return;
        }
        Node tmp = node;
        Stack<Node> st = new Stack<>();
        while(tmp != null || st.size() > 0){
            while(tmp != null){
                st.push(tmp);
                tmp = tmp.left;
            }
            tmp = st.pop();
            System.out.print(tmp.value + " ");
            tmp = tmp.right;
        }
    }
    public void levelOrder(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node tmp = queue.peek();
            queue.remove();
            System.out.println(tmp);
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }
    }


    private Node findHelper(Node node, int data){
        if(node == null || node.value == data){
            return node;
        }
        if(node.value > data){
            return findHelper(node.left, data);
        }else{
            return findHelper(node.right, data);
        }
    }
    private Node insertHelper(Node node , int data){
        if(node == null){
            return new Node(data);
        }
        if(data < node.value){
            node.left = insertHelper(node.left, data);
        }
        else if(data > node.value){
            node.right = insertHelper(node.right, data);
        }
        return node;
    }
}
