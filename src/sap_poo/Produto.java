
package sap_poo;

import java.util.ArrayList;

public class Produto {
    private String nome;
    private double valor;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String infoProduto(){
        return String.format("Nome: " + this.nome + "\nValor: " + this.valor + " R$");
    }
}
