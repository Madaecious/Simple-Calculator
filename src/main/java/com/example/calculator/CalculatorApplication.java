/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	Name:			Mark Barros
//	Course:			CS4800 - Software Engineering
//	Description:	This project is of a simple calculator. The GUI was created using the JavaFX
//                  framework and SceneBuilder.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.example.calculator;

// These are imports. ---------------------------------------------------------------------------------------
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// This is the CalculatorApplication class. -----------------------------------------------------------------
public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 245, 415);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
} // End of CalculatorApplication class. --------------------------------------------------------------------