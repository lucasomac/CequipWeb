package model;

public class Dispositivo {

    private int patrimonio;
    private String serie;
    private String tipo;
    private String marca;
    private String modelo;
    private Setor setor;
    private String nome;
    private String usuario;

    public int getPatrimonio() {
        return patrimonio;
    }

    @Override
    public String toString() {
        return getSerie();
    }

    public String getSerie() {
        return serie;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Setor getSetor() {
        return setor;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
