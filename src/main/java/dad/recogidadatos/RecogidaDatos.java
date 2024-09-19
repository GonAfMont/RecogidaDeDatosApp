package dad.recogidadatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RecogidaDatos extends Application {

    private TextField nombreTextF;
    private TextField apellidosTextF;
    private TextField edadTextF;
    private Label nombreLabel;
    private Label apellidosLabel;
    private Label edadLabel;
    private Button guardarButton;
    private Button limpiarButton;

    @Override
    public void start(Stage stage) throws Exception {

        nombreLabel = new Label("Nombre:   ");

        nombreTextF = new TextField();

        apellidosLabel = new Label("Apellidos:   ");

        apellidosTextF = new TextField();

        edadLabel = new Label("Edad:   ");

        edadTextF = new TextField();
        edadTextF.setPrefColumnCount(3);

        guardarButton = new Button("Guardar");
        guardarButton.setDefaultButton(true);
        guardarButton.setOnAction(this::Save);

        limpiarButton = new Button("Limpiar");
        limpiarButton.setOnAction(this::Clear);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(nombreLabel,nombreTextF);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(apellidosLabel, apellidosTextF);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(edadLabel, edadTextF);
        hBox3.setAlignment(Pos.CENTER);

        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(guardarButton, limpiarButton);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setSpacing(10);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);


        Scene scene = new Scene(vBox, 640, 480);

        stage.setTitle("Recogida de datos");
        stage.setScene(scene);
        stage.show();

    }

    private void Clear(ActionEvent e) {
        nombreTextF.clear();
        apellidosTextF.clear();
        edadTextF.clear();
    }

    private void Save(ActionEvent e) {
        try {
            Gson gson = new GsonBuilder()
                        .create();
            Persona p = new Persona();
            p.setNombre(nombreTextF.getText());
            p.setApellidos(apellidosTextF.getText());
            p.setEdad(edadTextF.getText());

            String json = gson.toJson(p);

            File jsonFile = new File("Datos.json");
            Files.writeString(jsonFile.toPath(), json);
        } catch (IOException IoE) {
            System.out.println("Ha ocurrido un error");
        }

    }

}
