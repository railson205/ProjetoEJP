import java.util.Scanner;

public class Menu {

    public Menu() {
        super();
    }

    int option;
    Scanner sc = new Scanner(System.in);

    MenuPassageiro menuPassageiro = new MenuPassageiro();
    MenuMotorista menuMotorista = new MenuMotorista();

    public void menuPrincipal() {
        do {
            System.out.println("##--MENU PRINCIPAL--##");
            System.out.println("| 1 - Passageiro |");
            System.out.println("| 2 - Motorista |");
            System.out.println("| 3 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    menuPassageiro.menu();
                    break;
                case 2:
                    menuMotorista.menu();
                    break;
                case 3:
                    System.out.println("Tchau");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (option != 3);
    }

}
