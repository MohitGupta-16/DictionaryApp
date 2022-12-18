package com.example.dictionaryapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    TextField wordTextField;
    Button searchButton;
    Label meaningLabel;
    ListView<String> suggestionList;

    DictionaryUsingHashMap dictionaryUsingHashMap = new DictionaryUsingHashMap();
    Pane createContent(){
        Pane root = new Pane();

        // for the size
        root.setPrefSize(400,500);
//        root.setBackground();

        wordTextField = new TextField();
        // it is a point at top left corner
        // X for width
        wordTextField.setTranslateX(20);
        // Y for height
        wordTextField.setTranslateY(30);

        // writing in constructor will give it a name
        searchButton = new Button("Search");
        searchButton.setTranslateX(200);
        searchButton.setTranslateY(30);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                meaningLabel.setText("Button is clicked");
                String word = wordTextField.getText();
                // when you don't enter a word
                if(word.isBlank() || word.isEmpty()){
                    meaningLabel.setText("Please enter a word !");
                    meaningLabel.setTextFill(Color.RED);
                }
                // it will retrieve meaning for word using DictionaryUsingHashmap class
                else{
                    String meaning = dictionaryUsingHashMap.getMeaning(word);
                    meaningLabel.setText(meaning);
                    meaningLabel.setTextFill(Color.BLACK);
                }
            }
        });

        meaningLabel = new Label("I am meaning");
        meaningLabel.setTranslateX(20);
        meaningLabel.setTranslateY(60);

        suggestionList = new ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(100);
        suggestionList.setMinSize(330, 50);
        suggestionList.setMaxSize(300, 50);

        String[] wordList = {"start", "stop"};
        suggestionList.getItems().addAll(wordList);
        suggestionList.setOrientation(Orientation.VERTICAL);

        suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selectWord = suggestionList.getSelectionModel().getSelectedItem();
                meaningLabel.setText(selectWord);
            }
        });

        root.getChildren().addAll(wordTextField, searchButton, meaningLabel, suggestionList);

        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary App!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}