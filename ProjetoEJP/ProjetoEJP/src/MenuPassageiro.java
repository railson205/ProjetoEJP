import java.util.Scanner;

public class MenuPassageiro {
    int option;
    Scanner sc = new Scanner(System.in);
    PerfilPassageiro perfilPassageiro = new PerfilPassageiro();
    MenuViagem menuViagem = new MenuViagem();

    public void menu(){
        do {
            System.out.println("##--Menu do passageiro--##");
            System.out.println("| 1 - Viagem |");
            System.out.println("| 2 - Perfil |");
            System.out.println("| 3 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    menuViagem.menu();
                    break;
                case 2:
                perfilPassageiro.menu();
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
