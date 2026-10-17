package com.sanchez.jorge.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UsuarioController {
    
    public PasswordField passwordContrasena;
    public TextField txtUsuario;
    public TextField txtRut;
    public PasswordField passwordRepetirContrasena;
    public Button buttonCrearUsuario;
    public TableView tableUsuarios;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onUsuarioButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
