import java.util.Scanner;

public class MenuServicoCliente {

    int option;
    Scanner sc = new Scanner(System.in);
    SolicitarServico solicitar = new SolicitarServico();
    HistoricoServico historicoServico = new HistoricoServico();

    public void menu() {
        do {
            System.out.println("##--Menu de serviço do cliente--##");
            System.out.println("| 1 - Solicitar serviço |");
            System.out.println("| 2 - Histórico de serviços |");
            System.out.println("| 3 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    solicitar.solicitarServico();
                    break;
                case 2:
                    historicoServico.mostraHistoricoServico();
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
    solicitar.auto();
}

public void autoHistorico() {
    historicoServico.autoHistorico();
}
}
