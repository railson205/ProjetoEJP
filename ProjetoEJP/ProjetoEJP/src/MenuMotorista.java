import java.util.Scanner;

public class MenuMotorista {


    int option;
    Scanner sc = new Scanner(System.in);
    CrudMotorista crMotorista = new CrudMotorista();


    public void menu() {
        do {
            System.out.println("##--MENU Motorista--##");
            System.out.println("| 1 - Cadastrar |");
            System.out.println("| 2 - Alterar |");
            System.out.println("| 3 - Consultar |");
            System.out.println("| 4 - Excluir |");
            System.out.println("| 5 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    crMotorista.cadastrarMotorista();
                    break;
                case 2:
                    crMotorista.alterarMotorista();
                    break;
                case 3:
                    crMotorista.consultarMotorista();
                    break;
                case 4:
                    crMotorista.excluirMotorista();
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
