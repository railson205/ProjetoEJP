import java.util.Scanner;

public class Menu {

    public Menu() {
        super();
    }

    int option;
    Scanner sc = new Scanner(System.in);

    MenuCliente menuCliente = new MenuCliente();
    MenuProfissional menuProfissional = new MenuProfissional();

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
                    menuCliente.menu();
                    break;
                case 2:
                    menuProfissional.menu();
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
