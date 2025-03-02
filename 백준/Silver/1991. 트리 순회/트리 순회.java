import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char centerNode = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);

            insertTree(centerNode, leftNode, rightNode);
        }
        
        // 전위, 중위, 후위순회 결과출력
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    public static void insertTree(char center, char left, char right) {
        if (root == null) { // 루트 노드가 없으면 생성
            root = new Node(center);
            if (left != '.') root.left = new Node(left);
            if (right != '.') root.right = new Node(right);
        } else { // 루트 노드가 이미 있으면 적절한 위치에 삽입
            searchNode(root, center, left, right);
        }
    }
    

    public static void searchNode(Node root, char center, char left, char right) {
        if (root == null) return;
        
        if (root.center == center) {
            if (left != '.') root.left = new Node(left);
            if (right != '.') root.right = new Node(right);
        } else {
            searchNode(root.left, center, left, right);
            searchNode(root.right, center, left, right);
        }
    }

    // 전위순회
    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.center);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    // 중위순회
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.center);
            inorder(root.right);
        }
    }
    
    // 후위순회
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.center);
        }
    }
}

class Node {
    char center;
    Node left, right;
    
    Node(char center) {
        this.center = center;
    }
}