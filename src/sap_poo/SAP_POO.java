package sap_poo;

import java.util.Scanner;

public class SAP_POO {

    public static void main(String[] args) {
        int tipoUsuario, operacao = 0, tipoconta = 0, operacaocl = 0;
        Administrador adm = new Administrador();
        Cliente cl = new Cliente();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(" - - - Bem vindo a Marisa Beach - - - ");
            System.out.println("Selecione o tipo de usuário: ");
            System.out.println("1 - Administrador");
            System.out.println("2 - Cliente");
            System.out.println("3 - Cadastrar conta");
            System.out.println("4 - Sair");
            tipoUsuario = input.nextInt();
            switch (tipoUsuario) {
                case 1:
                    if (adm.verificarLogin() == true) {
                        do {
                            System.out.println("Selecione a operação: ");
                            System.out.println("1 - Cadastrar produto");
                            System.out.println("2 - Visualizar produtos");
                            System.out.println("3 - Atualizar produtos");
                            System.out.println("4 - Sair");
                            operacao = input.nextInt();
                            switch (operacao) {
                                case 1:
                                    adm.cadastrarProduto();
                                    break;
                                case 2:
                                    adm.visualizarProdutos();
                                    break;
                                case 3:
                                    adm.atualizarProdutos();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Selecione uma operacao válida");
                                    break;
                            }
                        } while (operacao != 4);
                    } else {
                        System.out.println("Login inválido");
                        break;
                    }
                    break;
                case 2:
                        if (cl.verificarLogin() == true) {
                            do {
                                System.out.println("Selecione a operação: ");
                                System.out.println("1 - Realizar pedido");
                                System.out.println("2 - Atualizar perfil");
                                System.out.println("3 - Imprimir info");
                                System.out.println("4 - Visualizar pedidos");
                                System.out.println("5 - Sair");
                                operacaocl = input.nextInt();
                                switch (operacaocl) {
                                    case 1:
                                        cl.realizarPedidos();
                                        break;
                                    case 2:
                                        cl.atualizarPerfil();
                                        break;
                                    case 3:
                                        System.out.println(cl.imprimirInfo());
                                    case 4:
                                        cl.visualizarPedidos();
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Selecione uma operacao valida");
                                }
                            } while (operacaocl != 4);

                        } else {
                            System.out.println("Login inválido");
                            break;
                        }
                        break;
                case 3:
                    System.out.println("Tipo de conta");
                    System.out.println("1 - Cliente");
                    System.out.println("2 - Administrador");
                    System.out.println("3 - sair");
                    tipoconta = input.nextInt();
                    switch (tipoconta) {
                        case 1:
                            cl.cadastrarCliente();
                            break;
                        case 2:
                            adm.cadastrarAdministrador();
                            break;
                        case 3:
                            break;
                    }
                    break;
            }

        } while (tipoUsuario != 4);
    }
}
