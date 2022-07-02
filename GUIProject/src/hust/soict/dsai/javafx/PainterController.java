package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	private boolean isPane = true;
	
	@FXML
	private Pane drawingAreaPane;
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		if (isPane) {
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
			drawingAreaPane.getChildren().add(newCircle);
		}
	}
	
	@FXML
	void onMouseExit(MouseEvent event) {
		isPane = false;
	}
	
	@FXML
	void onMouseEnter(MouseEvent event) {
		isPane = true;
	}
}
