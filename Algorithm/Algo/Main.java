import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 트리 구성
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            // 부모 노드가 없으면 생성
            tree.putIfAbsent(parent, new Node(parent));
            Node parentNode = tree.get(parent);

            // 왼쪽 자식
            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                parentNode.left = tree.get(left);
            }

            // 오른쪽 자식
            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                parentNode.right = tree.get(right);
            }
        }

        Node root = tree.get('A'); // 항상 'A'가 루트

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }

    // 전위 순회
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
