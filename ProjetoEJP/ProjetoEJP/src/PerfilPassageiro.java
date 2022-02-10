import java.util.Scanner;

public class PerfilPassageiro {
    int option;
    Scanner sc = new Scanner(System.in);
    CrudPassageiro crPassageiro = new CrudPassageiro();

    public void menu() {
        do {
            System.out.println("##--Perfil do passageiro--##");
            System.out.println("| 1 - Cadastrar |");
            System.out.println("| 2 - Alterar |");
            System.out.println("| 3 - Consultar |");
            System.out.println("| 4 - Excluir |");
            System.out.println("| 5 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    crPassageiro.cadastrarPassageiro();
                    break;
                case 2:
                    crPassageiro.alterarPassageiro();
                    break;
                case 3:
                    crPassageiro.consultarPassageiro();
                    break;
                case 4:
                    crPassageiro.excluirPassageiro();
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
