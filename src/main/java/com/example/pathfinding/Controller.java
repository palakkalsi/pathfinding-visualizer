package com.example.pathfinding;

import com.example.pathfinding.algorithms.AStar;
import com.example.pathfinding.algorithms.BFS;
import com.example.pathfinding.algorithms.Dijkstra;
import com.example.pathfinding.model.Grid;
import com.example.pathfinding.model.Node;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Canvas canvas;
    @FXML
    private ChoiceBox<String> algorithmChoice;

    private Grid grid;
    private String currentAlgorithm = "A*";

    @FXML
    public void initialize() {
        grid = new Grid(20, 20); // 20x20 grid
        algorithmChoice.getItems().addAll("A*", "Dijkstra", "BFS");
        algorithmChoice.setValue("A*");
        algorithmChoice.setOnAction(event -> currentAlgorithm = algorithmChoice.getValue());
        drawGrid();
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        int x = (int) event.getX() / grid.getCellSize();
        int y = (int) event.getY() / grid.getCellSize();
        Node node = grid.getNode(x, y);
        node.setObstacle(!node.isObstacle());
        drawGrid();
    }

    @FXML
    private void runAlgorithm() {
        switch (currentAlgorithm) {
            case "A*":
                new AStar(grid).findPath();
                break;
            case "Dijkstra":
                new Dijkstra(grid).findPath();
                break;
            case "BFS":
                new BFS(grid).findPath();
                break;
        }
        drawGrid();
    }

    private void drawGrid() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        grid.draw(gc);
    }
}
