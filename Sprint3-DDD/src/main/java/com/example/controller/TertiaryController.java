package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.example.App;
import com.example.data.PrestadorDao;
import com.example.model.Prestador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class TertiaryController {

    @FXML
    private TextField txtNovoEmail;
    @FXML
    private TextField txtNovaSenha;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtModeloGuincho;

    @FXML
    private void cadastrarNovoPrestador() {
        String email = txtNovoEmail.getText();
        String senha = txtNovaSenha.getText();
        String nome = txtNome.getText();
        String modeloGuincho = txtModeloGuincho.getText();


        if (email.isEmpty() || senha.isEmpty() || nome.isEmpty() || modeloGuincho.isEmpty()) {
            mostrarMensagem(AlertType.ERROR, "Erro", "Preencha todos os campos.");
            return;
        }

        PrestadorDao dao = new PrestadorDao();
        Prestador novoPrestador = new Prestador(email, senha, nome, modeloGuincho);

        try {
            dao.inserir(novoPrestador);
            mostrarMensagem(AlertType.INFORMATION, "Sucesso", "Prestador cadastrado com sucesso.");
            limparCampos();
            voltarParaPrimary();
        } catch (SQLException e) {
            mostrarMensagem(AlertType.ERROR, "Erro", e.getMessage());
        }
    }

    @FXML
    private void voltarParaPrimary() {
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            mostrarMensagem(AlertType.ERROR, "Erro", e.getMessage());
        }
    }

    private void mostrarMensagem(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }

    private void limparCampos() {
        txtNovoEmail.clear();
        txtNovaSenha.clear();
        txtNome.clear();
        txtModeloGuincho.clear();
    }
}
