package sap_poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {

    private Cliente clienteLogado;
    private String nomeCliente;
    private String endereco;
    public ArrayList<Cliente> clientes = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public ArrayList<Pedido> pedidos = new ArrayList<>();
    public ArrayList<CartaoCredito> cartoes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String login, String senha, String email, String nomeCliente, String endereco) {
        super(login, senha, email);
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void cadastrarCliente() {
        Cliente cl = new Cliente();
        System.out.println("Nome do cliente: ");
        cl.setNomeCliente(input.next());
        System.out.println("Login do cliente: ");
        cl.setLogin(input.next());
        System.out.println("Senha do cliente: ");
        cl.setSenha(input.next());
        System.out.println("Email do cliente: ");
        cl.setEmail(input.next());
        System.out.println("Endereco: ");
        cl.setEndereco(input.next());
        clientes.add(cl);
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void atualizarPerfil() {
        System.out.println("Digite as novas informações para o cliente: ");

        System.out.println("Nome do cliente: ");
        clienteLogado.setNomeCliente(input.next());

        System.out.println("Login do cliente: ");
        clienteLogado.setLogin(input.next());

        System.out.println("Senha do cliente: ");
        clienteLogado.setSenha(input.next());

        System.out.println("Email do cliente: ");
        clienteLogado.setEmail(input.next());

        System.out.println("Endereco: ");
        clienteLogado.setEndereco(input.next());
    }

    public String imprimirInfo() {
        return String.format("Nome do cliente: %s\nEmail: %s\nEndereco: %s", clienteLogado.getNomeCliente(), clienteLogado.getEmail(), clienteLogado.getEndereco());
    }

    public void realizarPedidos() {
        int produtoPedido;
        Pedido pd = new Pedido();
        CartaoCredito cc = new CartaoCredito();
        System.out.print("Digite o número do pedido: ");
        pd.setNumPedido(input.next());
        pd.setCliente(clienteLogado);
        System.out.println("informe os produtos do pedido: ");
        if (super.produtos.size() != 0) {
            for (int i = 0; i < super.produtos.size(); i++) {
                System.out.println(produtos.get(i).infoProduto());
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }
        System.out.println("Digite o id do produto ou 0 para sair: ");
        do {
            produtoPedido = input.nextInt();
            if (produtoPedido == 0) {
                break;
            }
            pd.produtosPd.add(produtos.get(produtoPedido - 1));
            System.out.println("Quantidade: ");
            pd.produtosPd.get(produtoPedido - 1).setQuantidade(input.nextInt());
            System.out.println("Informe o tipo de pagamento: ");
            System.out.println("1 - Pix");
            System.out.println("2 - Cartão de crédito");
            int tipoPagamento = input.nextInt();
            if (tipoPagamento == 1) {
                pd.setTipoPagamento("Pix");
            } else if (tipoPagamento == 2) {
                System.out.println("Informe o número do cartão: ");
                cc.setNumero(input.next());
                System.out.println("Informe o titular do cartão: ");
                cc.setTitular(input.next());
                System.out.println("Informe a data de validade do cartão: ");
                cc.setDtValidade(input.next());
                System.out.println("Informe o ccv do cartão: ");
                cc.setCcv(input.next());
                pd.setTipoPagamento("Cartão");
            }
            pd.calcularValor();
        } while (produtoPedido != 0);
    }

    public void visualizarPedidos() {
        for (Pedido pds : pedidos) {
            if (pds.getCliente().equals(clienteLogado)) {
                System.out.println(pds.imprimirInfo());
                System.out.println("--------------------------------------");
            }
        }
    }

    @Override
    public boolean verificarLogin() {
        System.out.println("Digite o login: ");
        String log = input.next();
        System.out.println("Digite a senha: ");
        String sen = input.next();
        for (Cliente cl : clientes) {
            if (cl.getLogin().equals(log) && cl.getSenha().equals(sen)) {
                clienteLogado = cl;
                return true;
            }
        }
        return false;
    }
}
