package model;

import model.SetorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import model.Dispositivo;
import model.Movimentacao;
import model.Setor;

public class MovimentacaoDao {

    private final Connection connection;

    public MovimentacaoDao() {
        this.connection = new Conexao().getConnection();
    }

    public void movimenta(Dispositivo dispositivo, Setor setor) {
        String sql = "INSERT INTO movimentacao " + "(dispositivo, setorDestino)" + " VALUES (?, ?)";

        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                // seta os valores
                stmt.setString(1, dispositivo.getSerie());
                stmt.setInt(2, setor.getCodigo());

                // executa
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movimentacao> getLista() {
        String sql = "SELECT * FROM movimentacao";
        try {
            List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto movimentacao
                Movimentacao movimentacao = new Movimentacao();
                int setorDestino = (rs.getInt("setorDestino"));
                SetorDao auxSetor = new SetorDao();
                movimentacao.setSetorDestino(auxSetor.getSetor(setorDestino));

                String dispositivo = (rs.getString("dispositivo"));
                DispositivoDao auxDispositivo = new DispositivoDao();
                movimentacao.setDispositivo(auxDispositivo.getDispositivo("\"" + dispositivo + "\""));

                movimentacao.setDataMovimento(rs.getTimestamp("dia"));
                // adicionando o objeto à lista
                movimentacoes.add(movimentacao);
            }
            rs.close();
            stmt.close();
            return movimentacoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Movimentacao movimentacao, String dispositivo, int setorDestino, Timestamp dia) {
        String sql = "UPDATE movimentacao SET setorDestino=?, dispositivo=? " + "WHERE setorDestino=?" + " AND dispositivo=?" + "\"" + dispositivo + "\"" + " AND dia=?" + "\"" + dia + "\"";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, movimentacao.getSetorDestino().getCodigo());
            stmt.setString(2, movimentacao.getDispositivo().getSerie());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
