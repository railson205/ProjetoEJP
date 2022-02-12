import java.util.Scanner;

public class MenuCliente {


    int option;
    Scanner sc = new Scanner(System.in);
    PerfilPessoa perfilPessoa = new PerfilPessoa();
    MenuServicoCliente menuServico= new MenuServicoCliente();;

    public void menu(){
        do {
            System.out.println("##--Menu do cliente--##");
            System.out.println("| 1 - Serviços |");
            System.out.println("| 2 - Perfil |");
            System.out.println("| 3 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                if(CrudPessoa.pessoas.size()<1){
                    System.out.println("Faça um cadastro antes");
                    break;
                }
                    menuServico.menu();
                    break;
                case 2:
                    perfilPessoa.menu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        } while (option != 3);
    }
    public void auto() {
        perfilPessoa.auto();
    }
    public void autoServico(){
        menuServico.auto();
    }
    public void autoHistorico(){
        menuServico.autoHistorico();
    }
}
