
package Conta;


import Dominio.InstituicaoBancaria;
import Dominio.TipoTransacao;
import Dominio.Transacao;
import Util.DataUtil;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Exception.SaqueInvalidoException;
import Exception.ContaPoupancaInvalidaException;
import Exception.SaldoInsuficienteException;


public class ContaPoupanca extends Conta implements ContaBancaria {

       public ContaPoupanca(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo, List<Transacao> transacoes) {
              super(numeroConta, instituicaoBancaria, saldo, transacoes);
              validarContaPoupanca(instituicaoBancaria);
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
              if (valor >= 50.0) {
                     saldo -= valor + (valor * 0.02);
              } else {
                     throw new SaqueInvalidoException("Saque inválido para valores menores que 50.0");
              }
              transacoes.add(new Transacao(TipoTransacao.SACAR, DataUtil.getDataTransacao(),valor));
              System.out.println("Sacando o valor R$ " + valor + " da " + toString());
       }

       @Override
       public void transferir(Double valor, ContaBancaria contaDestino) {
              verificaSaldo(valor);
              if (getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria())){
                     System.out.println("Cobrando taxa de 0.5% do valor " + valor);
                     saldo -= valor + (valor * 0.005);
              }else{
                     System.out.println("Cobrando taxa de 1% do valor " + valor);
                     saldo -= valor + (valor * 0.01);
              }
              transacoes.add(new Transacao(TipoTransacao.SACAR, DataUtil.getDataTransacao(),valor));
              System.out.println("Transferindo o valor R$ " + valor + " da " + toString());
       }

       @Override
       public void exibirExtrato(LocalDate inicio, LocalDate fim) {
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              System.out.println("------ EXTRATO CONTA POUPANÇA " +  instituicaoBancaria.getNome() + " "  + numeroConta);
              for(Transacao transacao : transacoes) {

                     if ((inicio == null || inicio.isBefore(transacao.getDataTransacao()))
                             && (fim == null || fim.isAfter(transacao.getDataTransacao()))) {
                            System.out.println(transacao.getTipoTransacao().getNome() + DecimalFormat.getCurrencyInstance().format(transacao.getValorTransacao()) + " " + transacao.getDataTransacao().format(formatter));

                     }
              }
              System.out.println("---------------");

       }

       private void validarContaPoupanca(InstituicaoBancaria instituicaoBancaria) {
              if (instituicaoBancaria.equals(InstituicaoBancaria.NUBANK)){
                     throw new ContaPoupancaInvalidaException("Essa instituição não permite contas poupança");
              }
       }
       private void verificaSaldo(Double valor) {
              if(saldo < valor){
                     throw new SaldoInsuficienteException("O saldo não é suficiente para essa operação");
              }
       }
       @Override
       public String toString() {
              return "Conta Poupanca " + instituicaoBancaria.getNome() + " " + this.numeroConta;

       }
}
