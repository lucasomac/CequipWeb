package model;

import java.sql.Timestamp;

public class Movimentacao {

    private Setor setorDestino;
    private Dispositivo dispositivo;
    private Timestamp dataMovimento;

    @Override
    public String toString() {
        return getDispositivo() + " <<<>>> " + getSetorDestino();
    }

    public void setSetorDestino(Setor setorDestino) {
        this.setorDestino = setorDestino;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setDataMovimento(Timestamp dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public Setor getSetorDestino() {
        return setorDestino;
    }

    public Dispositivo getDispositivos() {
        return dispositivo;
    }

    public Timestamp getDataMovimento() {
        return dataMovimento;
    }
}
