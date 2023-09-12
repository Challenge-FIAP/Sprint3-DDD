package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Prestador;

public class PrestadorDao {

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "rm89162";
    final String PASS = "280400";

    public void inserir(Prestador prestador) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        try {
            var sql = "INSERT INTO prestador (email, senha, modelo_guincho, nm_prestador) VALUES (?, ?, ?, ?) ";
            var comando = conexao.prepareStatement(sql);
            comando.setString(1, prestador.email());
            comando.setString(2, prestador.senha());
            comando.setString(3, prestador.modelo_guincho());
            comando.setString(4, prestador.nm_prestador());
            comando.executeUpdate();
            conexao.close();
        } catch (Exception e) {
            System.out.println("\n\n\nERRO AQUI\n\n\n");
        }
    }

    public List<Prestador> buscarTodos() throws SQLException {
        var prestadores = new ArrayList<Prestador>();
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var rs = conexao.createStatement().executeQuery("SELECT * FROM prestador");

        while (rs.next()) {
            prestadores.add(new Prestador(
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("nm_prestador"),
                    rs.getString("modelo_guincho")));
        }

        conexao.close();

        return prestadores;
    }

    public void apagar(Prestador prestador) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var stm = con.prepareStatement("DELETE FROM prestador WHERE senha=?");
        stm.setString(1, prestador.senha());
        stm.executeUpdate();
        con.close();
    }
}
