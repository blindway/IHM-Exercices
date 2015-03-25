package e04;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FlipTextView extends Application {

	private static final String TITLE = "/ressources/FlipText_Title.png";
	private static final String ICON = "/ressources/Blue_Right_Arrow.png";

	private VBox root = new VBox(30);
	private HBox b2 = new HBox(5);
	private ImageView title = new ImageView(TITLE);

	Border border1 = new Border(new BorderStroke(Color.BLUE,
			BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3),
			new Insets(20)));

	ImageView image = new ImageView(TITLE);
	Label fText = new Label();
	ImageView icon = new ImageView(ICON);
	Button btnA = new Button("Next Text");
	Label text = new Label("A Kind of Magic");

	@Override
	public void start(Stage mainStage) throws Exception {

		mainStage.setTitle("My First JavaFX App");
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10));
		mainStage.setMinWidth(500);
		mainStage.setMinHeight(300);
		mainStage.setResizable(false);
		b2.setAlignment(Pos.CENTER);
		b2.getChildren().add(icon);
		text.setFont(Font.font("SansSerif", FontWeight.BOLD, 20));
		text.setTextFill(Color.rgb(180, 50, 50));
		b2.getChildren().add(text);

		root.setBorder(border1);
		fText.setGraphic(image);
		root.getChildren().add(fText);
		root.getChildren().add(b2);
		root.getChildren().add(btnA);

		// --- Print username/password on button click

		btnA.setOnAction(event -> text.setText("YO"));

		mainStage.setScene(new Scene(root));
		mainStage.show();

	}

}
