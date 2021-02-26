package Conta;


import Dominio.InstituicaoBancaria;
import Dominio.TipoTransacao;
import Dominio.Transacao;
import Exception.SaqueInvalidoException;
import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Util.DataUtil;
import Exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements ContaBancaria {

    public ContaCorrente(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo, List<Transacao> transacoes) {
        super(numeroConta, instituicaoBancaria, saldo, transacoes);
    }

    @Override
    public Double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
        transacoes.add(new Transacao(TipoTransacao.DEPOSITAR, DataUtil.getDataTransacao(), valor));
        System.out.println("Depositando o valor R$ " + valor + " para " + toString());
    }

    @Override
    public void sacar(Double valor) {
        verificaSaldo(valor);
        if (valor % 5 == 0) {
            saldo -= valor;
        } else {
            throw new SaqueInvalidoException("O valor para saque não é permitido");
        }
        transacoes.add(new Transacao(TipoTransacao.SACAR,DataUtil.getDataTransacao(), valor));
        System.out.println("Sacando o valor R$ " + valor + " da " + toString());
    }

    private void verificaSaldo(Double valor) {
        if(saldo < valor){
            throw new SaldoInsuficienteException("O saldo não é suficiente para essa operação");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificaSaldo(valor);
        if (getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()) {
            System.out.println("Cobrando taxa de 1% do valor " + valor);
            saldo -= valor + (valor * 0.01);
        } else {
            saldo -= valor;
        }
        transacoes.add(new Transacao(TipoTransacao.SACAR, DataUtil.getDataTransacao(), valor));
        System.out.println("Transferindo o valor R$ " + valor + " da " + toString());
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("------ EXTRATO CONTA CORRENTE " + instituicaoBancaria.getNome() + " " + numeroConta);
        for (Transacao transacao : transacoes) {
            if ((inicio == null || inicio.isBefore(transacao.getDataTransacao()))
                    && (fim == null || fim.isAfter(transacao.getDataTransacao())))
            {
                System.out.println(transacao.getTipoTransacao().getNome() + DecimalFormat.getCurrencyInstance().format(transacao.getValorTransacao()) + " " + transacao.getDataTransacao().format(formatter));
            }
        }
        System.out.println("---------------");

    }

    @Override
    public String toString() {
        return "Conta Corrente " + instituicaoBancaria.getNome() + " " + this.numeroConta;
    }
}

