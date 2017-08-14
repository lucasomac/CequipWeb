package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DispositivoDao {

    private final Connection connection;

    public DispositivoDao() {
        this.connection = new Conexao().getConnection();
    }

    public void adiciona(Dispositivo dispositivo) {
        String sql = "INSERT INTO dispositivo " + "(patrimonio, serie, tipo, marca, modelo, setor, nome, usuario)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            // seta os valores
            try ( // prepared statement para inserção
                    PreparedStatement stmt = this.connection.prepareStatement(sql)) {
                // seta os valores
                stmt.setInt(1, dispositivo.getPatrimonio());
                stmt.setString(2, dispositivo.getSerie());
                stmt.setString(3, dispositivo.getTipo());
                stmt.setString(4, dispositivo.getMarca());
                stmt.setString(5, dispositivo.getModelo());
                stmt.setInt(6, dispositivo.getSetor().getCodigo());
                stmt.setString(7, dispositivo.getNome());
                stmt.setString(8, dispositivo.getUsuario());
                // executa
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dispositivo> getLista() {
        String sql = "SELECT * FROM dispositivo";
        try {
            List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Dispositivo
                Dispositivo dispositivo = new Dispositivo();
                dispositivo.setPatrimonio(rs.getInt("patrimonio"));
                dispositivo.setSerie(rs.getString("serie"));
                dispositivo.setTipo(rs.getString("tipo"));
                dispositivo.setMarca(rs.getString("marca"));
                dispositivo.setModelo(rs.getString("modelo"));
                int id = rs.getInt("setor");
                SetorDao aux = new SetorDao();
                dispositivo.setSetor(aux.getSetor(id));
                dispositivo.setNome(rs.getString("nome"));
                dispositivo.setUsuario(rs.getString("usuario"));
                // adicionando o objeto à lista
                dispositivos.add(dispositivo);
            }
            rs.close();
            stmt.close();
            return dispositivos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dispositivo getDispositivo(String serie) {
        String sql = "SELECT * FROM dispositivo WHERE serie=?";
        Dispositivo dispositivo = new Dispositivo();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, serie);
            ResultSet rs = stmt.executeQuery();
            // criando o objeto Contato
            if (rs.next()) {
                dispositivo.setNome(rs.getString("patrimonio"));
                dispositivo.setSerie(rs.getString("serie"));
                dispositivo.setTipo(rs.getString("tipo"));
                dispositivo.setMarca(rs.getString("marca"));
                dispositivo.setModelo(rs.getString("modelo"));
                int id = rs.getInt("setor");
                SetorDao aux = new SetorDao();
                dispositivo.setSetor(aux.getSetor(id));
                dispositivo.setNome(rs.getString("nome"));
                dispositivo.setUsuario(rs.getString("usuario"));
            }
            rs.close();
            stmt.close();
            return dispositivo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Dispositivo dispositivo, String serie) {
        String sql = "UPDATE dispositivo SET patrimonio=?, serie=?, tipo=?, marca=?, modelo=?, setor=?, nome=?, usuario=? " + "WHERE serie=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, dispositivo.getPatrimonio());
            stmt.setString(2, dispositivo.getSerie());
            stmt.setString(3, dispositivo.getTipo());
            stmt.setString(4, dispositivo.getMarca());
            stmt.setString(5, dispositivo.getModelo());
            stmt.setInt(6, dispositivo.getSetor().getCodigo());
            stmt.setString(7, dispositivo.getNome());
            stmt.setString(8, dispositivo.getUsuario());
            stmt.setString(9, serie);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Dispositivo dispositivo) {
        String sql = "UPDATE dispositivo SET setor=1 " + "WHERE serie=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, dispositivo.getSerie());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(Dispositivo dispositivo) {
        if (!"".equals(dispositivo.getSerie())) {
            altera(dispositivo, dispositivo.getSerie());
        } else {
            adiciona(dispositivo);
        }
    }
}
