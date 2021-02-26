package Conta;




import Dominio.InstituicaoBancaria;
import Dominio.TipoTransacao;
import Dominio.Transacao;
import Util.DataUtil;

import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Exception.SaqueInvalidoException;
import Exception.ContaDigitalInvalidaException;
import Exception.SaldoInsuficienteException;


public class ContaDigital extends Conta implements ContaBancaria {

    public ContaDigital(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo, List<Transacao> transacoes) {
        super(numeroConta, instituicaoBancaria, saldo, transacoes);
        validaContaDigital(instituicaoBancaria);

    }

    @Override
    public Double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
        transacoes.add(new Transacao(TipoTransacao.DEPOSITAR, DataUtil.getDataTransacao(),valor));
        System.out.println("Depositando o valor R$ " + valor + " para " + toString());
    }

    @Override
    public void sacar(Double valor) {
        verificaSaldo(valor);
        if(valor >= 10){
            saldo -= valor;
        }else{
            throw new SaqueInvalidoException("O saque somente é permitido para valores acima de 10.0");
        }
        transacoes.add(new Transacao(TipoTransacao.SACAR, DataUtil.getDataTransacao(),valor));
        System.out.println("Sacando o valor R$ " + valor + " da " + toString());
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificaSaldo(valor);
        saldo -= valor;
        transacoes.add(new Transacao(TipoTransacao.SACAR, DataUtil.getDataTransacao(),valor));
        System.out.println("Transferindo o valor R$ " + valor + " da " + toString());
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("------ EXTRATO CONTA DIGITAL " +  instituicaoBancaria.getNome() + " "  + numeroConta);
        for(Transacao transacao : transacoes) {
            if ((inicio == null || inicio.isBefore(transacao.getDataTransacao()))
                    && (fim == null || fim.isAfter(transacao.getDataTransacao()))) {
                System.out.println(transacao.getTipoTransacao().getNome() + DecimalFormat.getCurrencyInstance().format(transacao.getValorTransacao()) + " " + transacao.getDataTransacao().format(formatter));
            }
        }
        System.out.println("---------------");


    }

    private void validaContaDigital(InstituicaoBancaria instituicaoBancaria) {
        if (!instituicaoBancaria.equals(InstituicaoBancaria.ITAU) && !instituicaoBancaria.equals(InstituicaoBancaria.NUBANK)) {
            throw new ContaDigitalInvalidaException("Essa instituição bancária não permite contas digitais");
        }
    }
    private void verificaSaldo(Double valor) {
        if(saldo < valor){
            throw new SaldoInsuficienteException("O saldo não é suficiente para essa operação");
        }
    }
    @Override
    public String toString() {
        return "Conta Digital " + instituicaoBancaria.getNome() + " " + this.numeroConta;
    }
}

