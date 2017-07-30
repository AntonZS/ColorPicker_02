package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        UColor c = new UColor("34-45-123",34.23,34.3,123.2);
        ColorAtlas atlasZambatti = new ColorAtlas();
        atlasZambatti.addColor(c);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
