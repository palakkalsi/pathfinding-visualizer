package com.example.pathfinding.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Grid {
    private int rows, cols;
    private Node[][] nodes;
    private int cellSize = 30;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        nodes = new Node[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(i, j);
            }
        }
    }

    public Node getNode(int x, int y) { return nodes[x][y]; }

    public int getCellSize() { return cellSize; }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, cols * cellSize, rows * cellSize);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nodes[i][j].isObstacle()) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
    }
}
