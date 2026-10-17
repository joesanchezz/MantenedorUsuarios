package com.sanchez.jorge.controller;

import com.sanchez.jorge.dto.UsuarioDto;
import com.sanchez.jorge.model.UsuarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UsuarioController {
    @FXML
    public PasswordField passwordContrasena;

    @FXML
    public TextField txtUsuario;

    @FXML
    public TextField txtRut;

    @FXML
    public Button buttonCrearUsuario;

    @FXML
    public TableView<UsuarioDto> tableUsuarios;

    @FXML
    public Button buttonEliminarUsuario;

    @FXML
    public TableColumn<UsuarioDto, String> colNombre;

    @FXML
    public TableColumn<UsuarioDto, String> colCorreo;

    @FXML
    public TableColumn<UsuarioDto, Integer> colEdad;

    @FXML
    public TableColumn<UsuarioDto, String> colRut;

    @FXML
    public Label lblMensaje;

    @FXML
    public TextField txtCorreo;

    @FXML
    private Label welcomeText;

    @FXML
    private Spinner<Integer> spnEdad;

    private UsuarioModel usuariosModel;
    private ObservableList<UsuarioDto> usuarios;
    private UsuarioDto usuarioSeleccionado;

    public UsuarioController() {
        this.usuariosModel = new UsuarioModel();
    }

    @FXML
    public void initialize() {
        this.colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        this.usuarios = FXCollections.observableArrayList();
        this.tableUsuarios.setItems(this.usuarios);
    }

    @FXML
    public void handlerAgregarUsuario(ActionEvent actionEvent) {
        if (txtUsuario.getText().trim().isEmpty() || passwordContrasena.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtRut.getText().trim().isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("No pueden haber campos vacíos");
            return;
        }

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre(txtUsuario.getText());
        usuarioDto.setContrasena(passwordContrasena.getText());
        usuarioDto.setRut(txtRut.getText());
        usuarioDto.setCorreo(txtCorreo.getText());
        usuarioDto.setEdad(spnEdad.getValue());

        this.usuariosModel.agregarUsuario(usuarioDto);
        this.usuarios.setAll(this.usuariosModel.mostrarUsuarios());

        this.txtUsuario.setText("");
        this.passwordContrasena.setText("");
        this.txtRut.setText("");
        this.txtCorreo.setText("");
        this.spnEdad.getValueFactory().setValue(18);

        lblMensaje.setStyle("-fx-text-fill: green;");
        lblMensaje.setText("Usuario agregado con éxito");

        this.txtUsuario.requestFocus();
    }

    @FXML
    public void handleSeleccionar(MouseEvent mouseEvent) {
        UsuarioDto usuarioDto = (UsuarioDto) this.tableUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioDto != null) {

            this.buttonEliminarUsuario.setDisable(false);
            this.usuarioSeleccionado = usuarioDto;
        }
    }

    @FXML
    public void handlerEliminarUsuario(){
            usuariosModel.eliminarUsuario(usuarioSeleccionado);

            this.usuarios.setAll(this.usuariosModel.mostrarUsuarios());

            this.tableUsuarios.getSelectionModel().clearSelection();
            this.buttonEliminarUsuario.setDisable(true);
            this.usuarioSeleccionado = null;
            lblMensaje.setStyle("-fx-text-fill: green;");

            lblMensaje.setText("Usuario eliminado con éxito");

    }
}