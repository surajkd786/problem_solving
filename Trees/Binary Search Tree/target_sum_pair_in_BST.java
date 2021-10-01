import java.io.*;
import java.util.*;

public class target_sum_pair_in_BST {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static boolean find(Node node, int data) {
    if (node == null) {
      return false;
    }
    if (data > node.data) {
      return find(node.right, data);
    } else if (data < node.data) {
      return find(node.left, data);
    } else {
      return true;
    }

  }

  public static void target_sum_pair(Node root, Node node, int tar) {
    if (node == null) {
      return;
    }
    target_sum_pair(root, node.left, tar);
    int comp = tar - node.data;
    if (node.data < comp) {
      if (find(root, comp) == true) {
        System.out.println(node.data + " " + comp);
      }
    }
    target_sum_pair(root, node.right, tar);
  }

  // second approach
  public static void tnf(Node node, ArrayList<Integer> List) {
    if (node == null) {
      return;
    }
    tnf(node.left, List);
    List.add(node.data);// add node in inorder
    tnf(node.right, List);
  }

  public static class ITpair {
    Node node;
    int state;

    ITpair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node getNextFromNormalInorder(Stack<ITpair> st) {
    while (st.size() > 0) {
      ITpair top = st.peek();
      if (top.state == 0) {
        if (top.node.left != null) {
          st.push(new ITpair(top.node.left, 0));
        }
        top.state++;
      } else if (top.state == 1) {
        if (top.node.right != null) {
          st.push(new ITpair(top.node.right, 0));
        }
        top.state++;
        return top.node;
      } else {
        st.pop();
      }
    }
    return null;
  }

  public static Node getNextFromNormalReverseInorder(Stack<ITpair> st) {
    while (st.size() > 0) {
      ITpair top = st.peek();
      if (top.state == 0) {
        if (top.node.right != null) {
          st.push(new ITpair(top.node.right, 0));
        }
        top.state++;
      } else if (top.state == 1) {
        if (top.node.left != null) {
          st.push(new ITpair(top.node.left, 0));
        }
        top.state++;
        return top.node;
      } else {
        st.pop();
      }
    }
    return null;
  }

  public static void bestApproach(Node node, int data) {
    Stack<ITpair> ls = new Stack<>();
    Stack<ITpair> rs = new Stack<>();
    ls.push(new ITpair(node, 0));
    rs.push(new ITpair(node, 0)); 
    Node left = getNextFromNormalInorder(ls);
    Node right = getNextFromNormalReverseInorder(rs);
    while (left.data < right.data) {
      if (left.data + right.data < data) {
        left = getNextFromNormalInorder(ls);
      } else if (left.data + right.data > data) {
        right = getNextFromNormalReverseInorder(rs);
      } else {
        System.out.println(left.data + " " + right.data);
        left = getNextFromNormalInorder(ls);
        right = getNextFromNormalReverseInorder(rs);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    // write your code here
    // target_sum_pair(root, root, data);
    // ArrayList<Integer> List = new ArrayList<>();
    // tnf(root, List);
    // int li = 0;
    // int ri = List.size() - 1;
    // while (li < ri) {
    // int left = List.get(li);
    // int right = List.get(ri);
    // if (left + right < data) {
    // li++;
    // } else if (left + right > data) {
    // ri--;
    // } else {
    // System.out.println(left + " " + right);
    // li++;
    // ri--;
    // }
    // }
    bestApproach(root, data);
  }

}
