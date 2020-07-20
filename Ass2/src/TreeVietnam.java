
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class TreeVietnam {

    Node root;

    public TreeVietnam() {
        this.root = null;
    }

    private String Visit(Node node) {
        String s = node.getInfo().getEnglish() + "; " + node.getInfo().getVietnam() + "; " + node.getInfo().getExampleE() + "; " + node.getInfo().getExampleV();
        return s;
    }

    public void PreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(Visit(node));
        PreOrder(node.getLeft());
        PreOrder(node.getRight());
    }

    public void InOrder(Node node) {
        if (node == null) {
            return;
        }
        InOrder(node.getLeft());
        System.out.println(Visit(node));
        InOrder(node.getRight());
    }

    public void PostOrder(Node node) {
        if (node == null) {
            return;
        }
        PostOrder(node.getLeft());
        PostOrder(node.getRight());
        System.out.println(Visit(node));
    }

    public void BreadthOrder(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(Visit(node));
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    public void BreadthOrder(Node node, File file) {
        try {
            file.createNewFile();
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);
            FileWriter fr = new FileWriter(file);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                fr.write(Visit(temp) + "\n");
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
            fr.close();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.height = max(height(y.getLeft()), height(y.getRight())) + 1;
        x.height = max(height(x.getLeft()), height(x.getRight())) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        x.height = max(height(x.getLeft()), height(x.getRight())) + 1;
        y.height = max(height(y.getLeft()), height(y.getRight())) + 1;
        return y;
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public Node InsertNodeV(Node node, String data) {
        StringTokenizer str = new StringTokenizer(data, ";");
        String enl, vne, enlE, vneE;
        enl = str.nextToken().trim();
        vne = str.nextToken().trim();
        enlE = str.nextToken().trim();
        vneE = str.nextToken().trim();
        Words word = new Words(enl, vne, enlE, vneE);
        Node node1 = new Node(word);
        if (node == null) {
            node = node1;
            return node;
        }
        if (node.CompareTwoNodebyVietnam(node, node1) > 0) {
            node.setLeft(InsertNodeV(node.getLeft(), data));
        }
        if (node.CompareTwoNodebyVietnam(node, node1) < 0) {
            node.setRight(InsertNodeV(node.getRight(), data));
        }
        if (node.CompareTwoNodebyVietnam(node, node1) == 0) {
            System.out.println("Duplicated value");
        }
        node.height = 1 + max(height(node.getLeft()), height(node.getRight()));
        int balance = getBalance(node);
        if (balance > 1 && node.CompareTwoNodebyVietnam(node, node1) > 0) {
            return rightRotate(node);
        }
        if (balance < -1 && node.CompareTwoNodebyVietnam(node, node1) < 0) {
            return leftRotate(node);
        }
        if (balance > 1 && node.CompareTwoNodebyVietnam(node, node1) < 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        if (balance < -1 && node.CompareTwoNodebyVietnam(node, node1) > 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        return node;
    }

    public void InsertNodeV(String info) {
        this.root = InsertNodeV(this.root, info);
    }

    public String SearchNodeV(Node node, String data) {
        if (node == null) {
            return "Not Found!";
        } else {
            if (data.equalsIgnoreCase(node.getInfo().getVietnam())) {
                return Visit(node);
            } else if (data.compareToIgnoreCase(node.getInfo().getVietnam()) < 0) {
                return SearchNodeV(node.getLeft(), data);
            } else if (data.compareToIgnoreCase(node.getInfo().getVietnam()) > 0) {
                return SearchNodeV(node.getRight(), data);
            }
        }
        return "Not Found!";
    }

    public void SearchNodeV(String data) {
        String s = SearchNodeV(this.root, data);
        if (s.equalsIgnoreCase("not found!")) {
            System.out.println(s);
        } else {
            System.out.println("Word is found: ");
            System.out.println(s);
        }
    }

    public Words minValue(Node node) {
        if (node.getLeft() != null) {
            minValue(node.getLeft());
        }
        return node.getInfo();
    }

    public Node deleteNodeV(Node node, String data) {
        try {
            if (data.equalsIgnoreCase(node.getInfo().getVietnam())) {
                if (node.getLeft() == null && node.getRight() == null) {
                    node = null;
                    return node;
                } else if (node.getLeft() == null) {
                    node = node.getLeft();
                    return node;
                } else if (node.getRight() == null) {
                    node = node.getRight();
                    return node;
                } else {
                    node.right.left = node.left;
                    node = node.getRight();
                    return node;

                }
            } else if (data.compareToIgnoreCase(node.getInfo().getVietnam()) < 0) {
                node.setLeft(deleteNodeV(node.getLeft(), data));
            } else if (data.compareToIgnoreCase(node.getInfo().getVietnam()) > 0) {
                node.setRight(deleteNodeV(node.getRight(), data));
            } else if (node == null) {
                System.out.println("Can't found this word to delete!");
            }
            node.height = 1 + max(height(node.getLeft()), height(node.getRight()));
            int balance = getBalance(node);
            if (balance > 1 && data.compareToIgnoreCase(node.getInfo().getVietnam()) < 0) {
                return rightRotate(node);
            }
            if (balance < -1 && data.compareToIgnoreCase(node.getInfo().getVietnam()) > 0) {
                return leftRotate(node);
            }
            if (balance > 1 && data.compareToIgnoreCase(node.getInfo().getVietnam()) > 0) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
            if (balance < -1 && data.compareToIgnoreCase(node.getInfo().getVietnam()) < 0) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
            return node;
        } catch (Exception E) {
            return node;
        }
    }

    public void deleteNodeV(String data) {
        deleteNodeV(this.root, data);
    }

}
