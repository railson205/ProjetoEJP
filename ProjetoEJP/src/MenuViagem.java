import java.util.ArrayList;
import java.util.Scanner;

public class MenuViagem {

    int option;
    Scanner sc = new Scanner(System.in);
    SolicitarViagem solicitar = new SolicitarViagem();
    HistoricoViagem historicoViagem = new HistoricoViagem();

    public void menu() {
        do {
            System.out.println("##--Menu de viagem--##");
            System.out.println("| 1 - Solicitar viagem |");
            System.out.println("| 2 - Histórico de viagens |");
            System.out.println("| 3 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    solicitar.solicitarViagem();
                    break;
                case 2:
                    historicoViagem.mostraHistoricoViagem();
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
