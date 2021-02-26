package Conta;




import Dominio.InstituicaoBancaria;
import Dominio.Transacao;

import java.util.List;

    public abstract class Conta {

    protected Integer numeroConta;
    protected InstituicaoBancaria instituicaoBancaria;
    protected Double saldo;
    protected List<Transacao> transacoes;


    public Conta(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo, List<Transacao> transacoes) {
        this.numeroConta = numeroConta;
        this.instituicaoBancaria = instituicaoBancaria;
        this.saldo = saldo;
        this.transacoes = transacoes;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    public void setInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
        this.instituicaoBancaria = instituicaoBancaria;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

}

