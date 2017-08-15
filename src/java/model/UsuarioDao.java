/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lomacedo
 */
public class UsuarioDao {

    // a conexão com o banco de dados
    private final Connection connection;

    public UsuarioDao() {
        this.connection = Conexao.getConnection();
    }

    public Usuario getUsuario(String login, String senha) {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM users WHERE login=" + "\"" + login + "\"" + "AND senha=" + "\"" + senha + "\"";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // criando o objeto Usuario
            if (rs.next()) {
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
            }
            rs.close();
            stmt.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
