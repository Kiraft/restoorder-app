package com.application.restoorderapp.util;
import com.application.restoorderapp.controllers.MenuController;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.App;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;

import com.application.restoorderapp.controllers.NavbarController;


public class StageLoaderCuenta {

    public static void load(String url, Event event, Cuenta cuenta) throws IOException {
        Object eventSource = event.getSource();
        Node sourceAsNode = (Node) eventSource;
        Scene oldScene = sourceAsNode.getScene();
        Window window = oldScene.getWindow();
        Stage stage = (Stage) window;
        stage.hide();

        FXMLLoader loader = new FXMLLoader(App.class.getResource(url));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        if (cuenta != null) {
            Object controller = loader.getController();

            if (controller instanceof NavbarController) {
                NavbarController navbarController = (NavbarController) controller;
                navbarController.setCuenta(cuenta);

            }
            else if (controller instanceof MenuController) {
                MenuController menuController = (MenuController) controller;
                menuController.setCuenta(cuenta);
            }

        }
        stage.show();
    }
}
