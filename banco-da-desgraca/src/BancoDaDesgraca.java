


import Conta.ContaBancaria;
import Conta.ContaCorrente;
import Conta.ContaDigital;
import Conta.ContaPoupanca;
import Dominio.InstituicaoBancaria;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class BancoDaDesgraca {
    public static void main(String[] args) {

        System.out.println("********** TESTES CONTA DIGITAL **********");

        ContaDigital contaDigitalRegra1 = new ContaDigital(1654, InstituicaoBancaria.NUBANK, 500.00, new ArrayList<>());
        if (contaDigitalRegra1.consultarSaldo() == 150.00) {
            System.out.println("Consultar saldo (Conta Digital");
        } else {
            System.out.println("Erro ao consultar saldo (Conta Digital)");
        }
        System.out.println("------------------------------------------------------");

        contaDigitalRegra1.depositar(180.00);
        if (contaDigitalRegra1.consultarSaldo() == 250.00) {
            System.out.println("Saldo: " + contaDigitalRegra1.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Digital).");
        }
        System.out.println("------------------------------------------------------");

        ContaBancaria contaDestino = new ContaCorrente(8975, InstituicaoBancaria.BRADESCO, 560.45, new ArrayList<>());
        contaDigitalRegra1.transferir(230.00, contaDestino);
        if (contaDigitalRegra1.consultarSaldo() == 80.00) {
            System.out.println("Saldo " + contaDigitalRegra1.consultarSaldo());
        } else {
            System.out.println("Erro na operação! (Conta Digital.");
        }
        System.out.println("-------------------------------------------------------");

        ContaDigital contaDigitalRegra2 = new ContaDigital(1253, InstituicaoBancaria.NUBANK, 800.00, new ArrayList<>());
        contaDigitalRegra2.sacar(300.00);

        if (contaDigitalRegra2.consultarSaldo() == 400.00) {
            System.out.println("Saldo " + contaDigitalRegra2.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Digital.");
        }
        System.out.println("******************************");



        System.out.println("********** TESTES  CONTA CORRENTE **********");

        ContaCorrente contaCorrenteRegra1 = new ContaCorrente(85795, InstituicaoBancaria.BRADESCO, 560.00, new ArrayList<>());
        if (contaCorrenteRegra1.consultarSaldo() == 500.0) {
            System.out.println(" Saldo inicial: " + contaCorrenteRegra1.consultarSaldo());
        } else {
            System.out.println(" Erro ao consultar saldo (Conta Corrente");
        }
        System.out.println("-------------------------------------------------------------------");

        contaCorrenteRegra1.depositar(360.00);
        if (contaCorrenteRegra1.consultarSaldo() == 600.00) {
            System.out.println("Saldo: " + contaCorrenteRegra1.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }

        System.out.println("******************************");


        ContaCorrente contaCorrenteRegra2 = new ContaCorrente(6547, InstituicaoBancaria.BRADESCO, 700.00, new ArrayList());
        ContaBancaria contaDestinoBancoDiferente = new ContaCorrente(5641, InstituicaoBancaria.CAIXA, 150.00, new ArrayList<>());
        contaCorrenteRegra2.transferir(80.00, contaDestinoBancoDiferente);
        System.out.println("BANCO DIVERSO");
        if (contaCorrenteRegra2.consultarSaldo() == 400.00) {
            System.out.println("Saldo: " + contaCorrenteRegra2.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }
        System.out.println("BANCOS IGUAIS");
        ContaBancaria contaDestinoBancoIgual = new ContaCorrente(85743, InstituicaoBancaria.BRADESCO, 569.00, new ArrayList<>());
        contaCorrenteRegra2.transferir(250.00, contaDestinoBancoIgual);
        if (contaCorrenteRegra2.consultarSaldo() == 320.00) {
            System.out.println(" Saldo: " + contaCorrenteRegra2.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }

        System.out.println("--------------------------------------------------------");


        ContaCorrente contaCorrenteRegra3 = new ContaCorrente(8654, InstituicaoBancaria.BRADESCO, 400.00, new ArrayList());
        contaCorrenteRegra3.sacar(20.00);
        if (contaCorrenteRegra3.consultarSaldo() == 400.0) {
            System.out.println("Saldo: " + contaCorrenteRegra3.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }

        System.out.println("******************************");

        System.out.println("********** TESTES CONTA POUPANÇA **********");


        ContaPoupanca contaPoupancaRegra1 = new ContaPoupanca(7414, InstituicaoBancaria.CAIXA, 850.00, new ArrayList());
        contaPoupancaRegra1.sacar(185.00);
        if (contaPoupancaRegra1.consultarSaldo() == 500.00) {
            System.out.println("Saldo: " + contaPoupancaRegra1.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }
        System.out.println("******************************");

        ContaPoupanca contaPoupancaRegra2 = new ContaPoupanca(7315, InstituicaoBancaria.BRADESCO, 560.00, new ArrayList());
        ContaBancaria contaDestinoMesmaInstituicao = new ContaCorrente(6596, InstituicaoBancaria.BRADESCO, 30.00, new ArrayList<>());
        contaPoupancaRegra2.transferir(80.00, contaDestinoMesmaInstituicao);
        System.out.println("BANCOS IGUAIS");
        if (contaPoupancaRegra2.consultarSaldo() == 500.00) {
            System.out.println("Saldo: " + contaPoupancaRegra2.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }

        System.out.println("BANCOS DIFERENTES");
        contaPoupancaRegra2 = new ContaPoupanca(9646, InstituicaoBancaria.BRADESCO, 600.00, new ArrayList());
        ContaBancaria contaDestinoInstituicaoDiferente = new ContaCorrente(6365, InstituicaoBancaria.CAIXA, 400.00, new ArrayList<>());
        contaPoupancaRegra2.transferir(200.00, contaDestinoInstituicaoDiferente);
        if (contaPoupancaRegra2.consultarSaldo() == 499.0) {
            System.out.println(" Saldo: " + contaPoupancaRegra2.consultarSaldo());
        } else {
            System.out.println(" Erro na operação! (Conta Corrente)");
        }


        System.out.println("********** REGRAS PARA AS INSTITUIÇÕES BANCÁRIAS **********");

        try {
            ContaDigital contaDigitalInstituicoesPermitem = new ContaDigital(7596, InstituicaoBancaria.CAIXA, 2000.00, new ArrayList<>());
        } catch (Exception e) {
            System.out.println("Somente Itaú e Nubank permitem contas digitais;");
        }


        try {
            ContaPoupanca contaPoupancaInstituicoesNaopermitem = new ContaPoupanca(5468, InstituicaoBancaria.NUBANK, 560.00, new ArrayList());
        } catch (Exception e) {
            System.out.println("Somente Nubank não permite conta poupança");
        }
        System.out.println("********** EXTRATO CONTA CORRENTE **********");

        ContaCorrente contaCorrente = new ContaCorrente(8596, InstituicaoBancaria.BRADESCO, 850.00, new ArrayList<>());
        contaCorrente.depositar(80.00);
        contaCorrente.sacar(100.0);

        contaCorrente.exibirExtrato(LocalDate.of(2020, 8, 26), null);
        contaCorrente.exibirExtrato(null, LocalDate.of(2020, 8, 26));
        contaCorrente.exibirExtrato(null, null);

        System.out.println("********** EXTRATO CONTA DIGITAL**********");
        ContaDigital contaDigital = new ContaDigital(8596, InstituicaoBancaria.NUBANK, 500.0, new ArrayList<>());
        contaDigital.depositar(320.00);
        contaDigital.sacar(150.00);

        contaDigital.exibirExtrato(LocalDate.of(2020, 9, 5), null);
        contaDigital.exibirExtrato(null, LocalDate.of(2020, 9, 5));
        contaDigital.exibirExtrato(null, null);


        System.out.println("********** EXTRATO CONTA POUPANÇA **********");
        ContaPoupanca contaPoupanca = new ContaPoupanca(6365, InstituicaoBancaria.CAIXA, 700.00, new ArrayList<>());
        contaPoupanca.depositar(200.00);
        contaPoupanca.sacar(250.00);

        contaPoupanca.exibirExtrato(LocalDate.of(2020, 9, 15), null);
        contaPoupanca.exibirExtrato(null, LocalDate.of(2020, 9, 15));
        contaPoupanca.exibirExtrato(null, null);
    }
}




