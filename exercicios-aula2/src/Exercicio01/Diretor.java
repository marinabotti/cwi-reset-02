package Exercicio01;

import Exercicio01.Genero;

public class Diretor {



        private String nome;
        private int idade;
        private int quantidadeFilmesDirigidos;
        private Genero genero;

    public int getIdade() {
        return idade;
    }

    public Genero getGenero(){
        return genero;
    }

    public Diretor(String nome, int idade, int quantidadeFilmesDirigidos, Genero genero) {
            this.nome = nome;
            this.idade = idade;
            this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
            this.genero = genero;

        }

        public String getNome() {
            return this.nome;
        }
    }

