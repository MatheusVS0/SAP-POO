//
package sap_poo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Administrador extends Usuario {

    private String nomeAdmin;
    Scanner input = new Scanner(System.in);

    public Administrador() {
    }
    public ArrayList<Administrador> adms = new ArrayList<>();

    public Administrador(String login, String senha, String email, String nomeAdmin) {
        super(login, senha, email);
        this.nomeAdmin = nomeAdmin;
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public void cadastrarProduto() {
        Produto p = new Produto();
        System.out.println("Informe o nome do produto: ");
        p.setNome(input.next());
        System.out.println("Informe o valor do produto: ");
        p.setValor(input.nextDouble());
        super.produtos.add(p);
    }

    public void visualizarProdutos() {
        if (produtos.size() > 0) {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println("------------------------------------");
                System.out.println((i + 1) + " - " + produtos.get(i).infoProduto());
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }
    }

    public void atualizarProdutos() {
        if (produtos.size() > 0) {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + " - " + produtos.get(i).getNome());
            }
            System.out.print("Selecione o produto que deseja atalizar o valor: ");
            int pc = input.nextInt();
            System.out.print("Digite o novo valor do produto: ");
            produtos.get(pc - 1).setValor(input.nextDouble());
        } else {
            System.out.println("Nenhum produto cadastrado");
        }
    }

    public void cadastrarAdministrador() {
        Administrador admin = new Administrador();
        System.out.println("Nome do adm: ");
        admin.setNomeAdmin(input.next());
        System.out.println("Login do adm: ");
        admin.setLogin(input.next());
        System.out.println("Senha do adm: ");
        admin.setSenha(input.next());
        System.out.println("Email do adm: ");
        admin.setEmail(input.next());
        adms.add(admin);
    }

    @Override
    public boolean verificarLogin()  {
        System.out.println("Digite o login: ");
        String log = input.next();
        System.out.println("Digite a senha: ");
        String sen = input.next();
        for (Administrador ad : adms) {
            if (ad.getLogin().equals(log) && ad.getSenha().equals(sen)) 
                return true;            
        }
        return false;
    }

}
