import java.util.Scanner;

public class MenuPassageiro {


    int option;
    Scanner sc = new Scanner(System.in);
    PerfilPassageiro perfilPassageiro = new PerfilPassageiro();
    MenuViagem menuViagem;

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
                if(CrudPassageiro.passageiros.size()<1){
                    System.out.println("Faça um cadastro antes");
                    break;
                }
                    menuViagem.menu();
                    break;
                case 2:
                    perfilPassageiro.menu();
                    menuViagem = new MenuViagem();
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
