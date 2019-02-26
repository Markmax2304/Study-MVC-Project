package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    Controller contr;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("ODZ");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        contr = fxmlLoader.getController();
        primaryStage.setOnCloseRequest(e -> contr.saveModelData());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
