/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Node {
    Words info;
    int height;
    Node left,right;

    public Node() {
    }

    public Node(Words info) {
        this.info = info;
        this.height = 1;
        this.left = this.right = null;
    }

    public Words getInfo() {
        return info;
    }

    public void setInfo(Words info) {
        this.info = info;
    }

    public int getHeigh() {
        return height;
    }

    public void setHeigh(int heigh) {
        this.height = heigh;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public int CompareTwoNodebyEnglish(Node node1, Node node2){
        return node1.getInfo().getEnglish().compareToIgnoreCase(node2.getInfo().getEnglish());
    }
    
    public int CompareTwoNodebyVietnam(Node node1, Node node2){
        return node1.getInfo().getVietnam().compareToIgnoreCase(node2.getInfo().getVietnam());
    }
}
