package com.kasirgui;

import java.io.IOException;

import com.kasirgui.helpers.DataSaveTriger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void stop() throws Exception {
        DataSaveTriger.save();
        super.stop();
    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        initScene();
        stage.resizableProperty().setValue(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void initScene() throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
    }

    public static void setRoot(String fxml) throws IOException {
        DataSaveTriger.save();
        DataSaveTriger.getData();
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}