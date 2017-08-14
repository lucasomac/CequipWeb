package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDao {

    // a conexão com o banco de dados
    private final Connection connection;

    public SetorDao() {
        this.connection = new Conexao().getConnection();
    }

    public void adiciona(Setor setor) {
        String sql = "INSERT INTO setor " + "(nome,descricao)" + " VALUES (?,?)";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                // seta os valores
                stmt.setString(1, setor.getNome());
                stmt.setString(2, setor.getDescricao());
                // executa
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Setor não adicionado!!");
        }
    }

    public List<Setor> getLista() {
        String sql = "SELECT * FROM setor";
        try {
            List<Setor> setores = new ArrayList<Setor>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Contato
                Setor setor = new Setor();
                setor.setCodigo(rs.getInt("codigo"));
                setor.setNome(rs.getString("nome"));
                setor.setDescricao(rs.getString("descricao"));
                // adicionando o objeto à lista
                setores.add(setor);
            }
            rs.close();
            stmt.close();
            return setores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Setor getSetor(int codigo) {
        Setor setor = new Setor();
        String sql = "SELECT *FROM setor WHERE codigo=" + codigo;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // criando o objeto Contato
            if (rs.next()) {
                setor.setCodigo(rs.getInt("codigo"));
                setor.setNome(rs.getString("nome"));
                setor.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            stmt.close();
            return setor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Setor getSetor(String nome) {
        Setor setor = new Setor();
        String sql = "SELECT * FROM setor WHERE nome=" + "\"" + nome + "\"";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // criando o objeto Contato
            if (rs.next()) {
                setor.setCodigo(rs.getInt("codigo"));
                setor.setNome(rs.getString("nome"));
                setor.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            stmt.close();
            return setor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Setor setor) {
        String sql = "UPDATE setor SET nome=?, descricao=?" + "WHERE codigo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, setor.getNome());
            stmt.setString(2, setor.getDescricao());
            stmt.setInt(3, setor.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Setor setor) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM setor WHERE codigo=?");
            stmt.setInt(1, setor.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("");
        }
    }

    public void salvar(Setor setor) {
        if (setor.getCodigo() != 0) {
            altera(setor);
        } else {
            adiciona(setor);
        }
    }
}
