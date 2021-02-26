package Dominio;


import java.time.LocalDate;

    public class Transacao {
    private TipoTransacao tipoTransacao;
    private LocalDate dataTransacao;
    private Double valorTransacao;

    public Transacao(TipoTransacao tipoTransacao, LocalDate dataTransacao, Double valorTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(Double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
}

