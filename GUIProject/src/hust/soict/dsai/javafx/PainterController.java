package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	private boolean isPane = true;
	
	@FXML
	private Pane drawingAreaPane;
	
	@FXML
	private RadioButton pen;
	
	@FXML
	private RadioButton eraser;
	
	@FXML
	private ToggleGroup drawTools;
	
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		if (pen.isSelected() || eraser.isSelected()) {
			Color inkColor;
			if (pen.isSelected()) {
				inkColor = Color.BLACK;
			} else {
				inkColor = Color.WHITE;
			}
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
			drawingAreaPane.getChildren().add(newCircle);
		}
		
	}
}
