import java.util.*;

public class MenuServicoProfissional {
    int option;
    Scanner sc = new Scanner(System.in);

    static ArrayList<SolicitarServico> servicos= new ArrayList<SolicitarServico>();
    static ArrayList<SolicitarServico> historicoServico = new ArrayList<SolicitarServico>();

    public void menu() {
        do {
            System.out.println("##--MENU Serviço do profissional--##");
            System.out.println("| 1 - Verificar serviços |");
            System.out.println("| 2 - Histórico de serviços |");
            System.out.println("| 3 - Verificar ganho |");
            System.out.println("| 4 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    verificaServico();
                    break;
                case 2:
                    historicoServico();
                    break;
                case 3:
                    verificaGanho();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        } while (option != 4);
    }

    public void verificaServico() {

    }

    public void historicoServico() {

    }

    public void verificaGanho() {

    }
}
