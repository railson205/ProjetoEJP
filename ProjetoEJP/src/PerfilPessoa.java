import java.util.*;

public class PerfilPessoa {


    int option;
    Scanner sc = new Scanner(System.in);
    CrudPessoa crPessoa = new CrudPessoa();

    public void menu() {
        do {
            System.out.println("##--Perfil do cliente--##");
            System.out.println("| 1 - Cadastrar |");
            System.out.println("| 2 - Alterar |");
            System.out.println("| 3 - Consultar |");
            System.out.println("| 4 - Excluir |");
            System.out.println("| 5 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    crPessoa.cadastrarCliente();
                    break;
                case 2:
                    crPessoa.alterarPessoa();
                    break;
                case 3:
                    crPessoa.consultarPessoa();
                    break;
                case 4:
                    crPessoa.excluirPessoa();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        } while (option != 5);
    }
}
