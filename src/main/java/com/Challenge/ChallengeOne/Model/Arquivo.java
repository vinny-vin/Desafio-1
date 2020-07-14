package com.Challenge.ChallengeOne.Model;


public class Arquivo {

    public String nome;
    public String pasta;

    public Arquivo() {
    }

    public Arquivo(String nome, String pasta) {
        this.nome = nome;
        this.pasta = pasta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "nome='" + nome + '\'' +
                ", pasta='" + pasta + '\'' +
                '}';
    }

}
