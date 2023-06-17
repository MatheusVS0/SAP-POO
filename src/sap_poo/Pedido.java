package sap_poo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Pedido {

    private String numPedido;
    private Date datacriacao;
    private Cliente cliente;
    private String tipoPagamento;
    private double valorPedido;
    Scanner input = new Scanner(System.in);
    ArrayList<Produto> produtosPd = new ArrayList<>();

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public void calcularValor() {
        if (produtosPd.size() > 0) {
            for (int i = 0; i < produtosPd.size(); i++) {
                double valorPorProduto = (produtosPd.get(i).getValor() * produtosPd.get(i).getQuantidade());
                this.valorPedido += valorPorProduto;
                break;
            }
            System.out.println("Valor do pedido é: " + valorPedido + "R$");
        } else {
            System.out.println("Nenhum produto cadastrado no pedido");
        }

    }
    
    public String produtosNoPedido(){
        for (int i = 0; i < produtosPd.size(); i++){
            System.out.println(produtosPd.get(i).getNome());
        }
        return null;
    }
    
    public String imprimirInfo(){
        return String.format("Nota Fiscal \nNúmero do pedido: " + this.getNumPedido() + "\nData: " + this.getDatacriacao() + "\nCliente:" + this.getCliente()
        + "\nPagamento: " + this.getTipoPagamento() + "\nValor do pedido: " + this.getValorPedido() + "\nProdutos: " + this.produtosNoPedido() );
    }
}
