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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lomacedo
 */
public class UsuarioDAO implements DAO<Usuario> {

    public Usuario getSingle(String login) {
        Connection conn = Conexao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select login, senha, nome where login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("login"), rs.getString("nome"), rs.getString("senha"));
            }
        } catch (SQLException ex) {
        } finally {
            Conexao.fecharConexao();
        }
        return null;
    }

    @Override
    public Usuario getSingle(Object... chave) {
        if (chave[0] instanceof Integer) {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement("select login, nome, senha where login = ?");
                ps.setInt(1, (Integer) chave[0]);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Usuario(rs.getString("login"), rs.getString("nome"), rs.getString("senha"));
                }
            } catch (SQLException ex) {
            } finally {
                Conexao.fecharConexao();
            }
        }
        return null;
    }

    @Override
    public List<Usuario> getList() {
        return getList(0);
    }

    @Override
    public List<Usuario> getList(int top) {
        if (top < 0) {
            return null;
        }
        List<Usuario> lista = null;
        Connection conn = Conexao.getConnection();
        Statement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.createStatement();
            rs = ps.executeQuery("select " + (top > 0 ? "top " + top : "") + "login, nome, senha");
            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new Usuario(rs.getString("login"), rs.getString("nome"), rs.getString("senha")));
            }
        } catch (SQLException ex) {
        } finally {
            Conexao.fecharConexao();
        }
        return lista;
    }
}
