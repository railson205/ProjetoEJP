import java.util.ArrayList;
import java.util.Scanner;

public class HistoricoServico {

    public HistoricoServico() {
        this.solicitacoes = new ArrayList<SolicitarServico>();
    }

    static ArrayList<SolicitarServico> solicitacoes;
    String cpfConsulta;
    Scanner sc = new Scanner(System.in);
    private boolean cadastro;

    public void mostraHistoricoServico() {
        cadastro = false;
        System.out.println("Cpf para consulta: ");
         cpfConsulta =sc.next();
        //cpfConsulta = "987.654.321-10";
        for (SolicitarServico s : solicitacoes) {
            if (s.cpfCliente.equalsIgnoreCase(cpfConsulta))
                cadastro = true;
        }

        if (cadastro) {
            int cont = 0;
            for (SolicitarServico s : solicitacoes) {
                System.out.println("Nome do profissional: " + s.profissional.getNome());
                System.out.println("Profissão do profissional: " + s.profissional.getProfissao());
                System.out.println("Preço base cobrado pelo serviço: " + s.preco);
                System.out.printf("Data e horário marcado para o serviço: %d/%d às %dh\n", s.dia, s.mes, s.horario);
                switch (s.profAceita.get(cont)) {
                    case 0:
                        System.out.println("Profissional ainda não verificou");
                        break;
                    case 1:
                        System.out.println("Profissional aceitou o serviço");
                        break;
                    case 2:
                        System.out.println("Profissional recusou o serviço");
                }
                cont++;
                System.out.println("-----------");
            }
        } else
            System.out.println("Cadastro não encontrado");
    }

    public static void addServico(SolicitarServico servico) {
        solicitacoes.add(servico);
    }

    public static void attServico(SolicitarServico servico, int decisao) {
        ArrayList<SolicitarServico> solAux = new ArrayList<SolicitarServico>();
        for (SolicitarServico s : solicitacoes) {
            if (s.equals(servico))
                s.profAceita.set(solicitacoes.indexOf(servico), decisao);
            solAux.add(s);

        }
        solicitacoes = solAux;

    }

    public void autoHistorico() {
        cadastro = false;
        cpfConsulta = "987.654.321-10";
        for (SolicitarServico s : solicitacoes) {
            if (s.cpfCliente.equalsIgnoreCase(cpfConsulta))
                cadastro = true;
        }

        if (cadastro) {
            int cont = 0;
            for (SolicitarServico s : solicitacoes) {
                System.out.println("Nome do profissional: " + s.profissional.getNome());
                System.out.println("Profissão do profissional: " + s.profissional.getProfissao());
                System.out.println("Preço base cobrado pelo serviço: " + s.preco);
                System.out.printf("Data e horário marcado para o serviço: %d/%d às %dh\n", s.dia, s.mes, s.horario);
                switch (s.profAceita.get(cont)) {
                    case 0:
                        System.out.println("Profissional ainda não verificou");
                        break;
                    case 1:
                        System.out.println("Profissional aceitou o serviço");
                        break;
                    case 2:
                        System.out.println("Profissional recusou o serviço");
                }
                cont++;
                System.out.println("-----------");
            }
        } else
            System.out.println("Cadastro não encontrado");
    }
}
