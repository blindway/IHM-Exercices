package s02.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MineHuntView extends Application {
	
		//private static final String TITLE = "./ressources/FlipText_Title.png";
		//private static final String ICON = "./ressources/Blue_Right_Arrow.png";
	
		private VBox root = new VBox(20);
		private VBox vgrid = new VBox(30);
		private HBox htitle = new HBox(30);
		private HBox hinfo = new HBox(30);
		private HBox hclick = new HBox(30);
		private HBox herror = new HBox(30);
		private HBox hbutton = new HBox(30);
		
		private GridPane grid = new GridPane();


		Button mines = new Button("Show Mines");
		Button button = new Button("New Game");

		
		Label title = new Label("MINEHUNT");
		Label click = new Label("NB Clicks: ");
		Label error = new Label("NB Clicks: ");


		public void start(Stage mainStage) throws Exception {

			// box
			mainStage.setTitle("MineHunt App");
			mainStage.setMinWidth(500);
			mainStage.setMinHeight(500);

			mainStage.setResizable(true);
			
			
			root.getChildren().add(htitle);
			root.getChildren().add(hinfo);
			hinfo.getChildren().add(hclick);
			hinfo.getChildren().add(herror);
			root.getChildren().add(vgrid);
			root.getChildren().add(hbutton);

			
			htitle.setAlignment(Pos.CENTER);
			hinfo.setAlignment(Pos.CENTER);
			hclick.setAlignment(Pos.CENTER_LEFT);
			herror.setAlignment(Pos.CENTER_RIGHT);
			grid.setAlignment(Pos. CENTER);
			grid.setHgap(1);
			grid.setVgap(1);
			hbutton.setAlignment(Pos. BOTTOM_RIGHT);

			

			//background
			Background bgMine = new Background(
					new BackgroundFill(Color.LIGHTYELLOW,
					CornerRadii.EMPTY,
					null ));
			
			
					root.setBackground(bgMine);
			
					
					
					

			// Police et ajout du text
			title.setFont(Font.font("SansSerif", 44));
			title.setTextFill(Color.RED);

			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					Button btn = new Button();
					btn.setMinSize(30, 30);
				     grid.add(btn, i, j); // column=2 row=1
				}
			}
			

			
			
			
			htitle.getChildren().add(title);
			hinfo.getChildren().add(click);
			hinfo.getChildren().add(error);
			hbutton.getChildren().add(mines);
			hbutton.getChildren().add(button);
			vgrid.getChildren().add(grid);
			


			// boeuf
			mainStage.setScene(new Scene(root));
			mainStage.show();
		}
	
	

}
