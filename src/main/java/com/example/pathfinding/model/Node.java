package com.example.pathfinding.model;

public class Node {
    private int x, y;
    private boolean isObstacle;
    private boolean isVisited;
    private Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.isObstacle = false;
        this.isVisited = false;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isObstacle() { return isObstacle; }
    public void setObstacle(boolean obstacle) { isObstacle = obstacle; }
    public boolean isVisited() { return isVisited; }
    public void setVisited(boolean visited) { isVisited = visited; }
    public Node getParent() { return parent; }
    public void setParent(Node parent) { this.parent = parent; }
}
