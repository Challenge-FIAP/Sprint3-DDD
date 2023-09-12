package com.example.controller;

import java.io.IOException;

import com.example.App;
import com.example.data.SessaoDao;
import com.example.model.Sessao;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    ImageView imageView;
    @FXML
    TextField txtEmail;
    @FXML
    TextField txtSenha;

    
    @FXML
    private void irParaTertiary() throws IOException {
        App.setRoot("tertiary");
    }


    public void logIn() throws IOException {
        System.out.println("Trying to log in");
        Sessao sessao = this.carregarSessaoDoFormulario();
        SessaoDao dao = new SessaoDao();

        if (dao.autenticar(sessao)) {
            try {
                App.setRoot("secondary");
            } catch (Exception e) {
                this.mostrarMensagem(AlertType.ERROR, "ERRO", e.getMessage());
            }
        } else {
            this.mostrarMensagem(AlertType.WARNING, "Não encontrado",
                    "Usuário não encontrado por favor digitar as credenciais corretas, ou cadastre-se na plataforma.");
        }

    }

    private void mostrarMensagem(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }

    private Sessao carregarSessaoDoFormulario() {
        return new Sessao(this.txtEmail.getText(), this.txtSenha.getText());
    }
}
