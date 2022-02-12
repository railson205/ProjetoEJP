import java.util.Scanner;

public class MenuProfissional {

    
    PerfilProfissional perfilProfissional = new PerfilProfissional();
    MenuServicoProfissional menuServico = new MenuServicoProfissional();
    
    int option;
    Scanner sc = new Scanner(System.in);
    public void menu() {
        do {
            System.out.println("##--MENU Profissional--##");
            System.out.println("| 1 - Serviços |");
            System.out.println("| 2 - Perfil |");
            System.out.println("| 3 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    menuServico.menu();
                    break;
                case 2:
                    perfilProfissional.menu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        } while (option != 3);
    }
}
