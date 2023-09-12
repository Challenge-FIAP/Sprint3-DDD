package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Sessao;

public class SessaoDao {
  final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
  final String USER = "rm89162";
  final String PASS = "280400";

  public boolean autenticar(Sessao sessao) {
    try {
      var contas = buscarTodos();
      boolean isValid = contas.contains(sessao);

      if (isValid) {
        System.out.println("Valid");
      } else {
        System.out.println("Not Valid");
      }

      return isValid;
    } catch (Exception e) {
      return false;
    }

  }

  public List<Sessao> buscarTodos() throws SQLException {
    var contas = new ArrayList<Sessao>();
    var conexao = DriverManager.getConnection(URL, USER, PASS);
    var rs = conexao.createStatement().executeQuery("SELECT * FROM prestador");

    while (rs.next()) {
      contas.add(new Sessao(
          rs.getString("email"),
          rs.getString("senha")));
    }

    conexao.close();
    return contas;
  }
}
