import java.util.Scanner;

public class PerfilProfissional {


    int option;
    Scanner sc = new Scanner(System.in);
    CrudProfissional crProfissional = new CrudProfissional();


    public void menu() {
        do {
            System.out.println("##--Perfil Profissional--##");
            System.out.println("| 1 - Cadastrar |");
            System.out.println("| 2 - Alterar |");
            System.out.println("| 3 - Consultar |");
            System.out.println("| 4 - Excluir |");
            System.out.println("| 5 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    crProfissional.cadastrarProfissional();
                    break;
                case 2:
                    crProfissional.alterarProfissional();
                    break;
                case 3:
                    crProfissional.consultarProfissional();
                    break;
                case 4:
                    crProfissional.excluirProfissional();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        } while (option != 5);
    }

    public void auto(){
        crProfissional.auto();
    }
}
