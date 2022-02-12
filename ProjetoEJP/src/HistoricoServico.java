import java.util.ArrayList;

public class HistoricoServico {

    public HistoricoServico() {
        this.solicitacoes = new ArrayList<SolicitarServico>();
    }

    static ArrayList<SolicitarServico> solicitacoes;

    public void mostraHistoricoServico() {
        for (SolicitarServico s : solicitacoes) {
            System.out.println("Nome do profissional: " + s.profissional.getNome());
            System.out.println("Profissão do profissional: " + s.profissional.getProfissao());
            System.out.println("Preço base cobrado pelo serviço: " + s.preco);
            System.out.printf("Data e horário marcado para o serviço: %d/%d às %sh\n", s.dia, s.mes, s.horario);
            System.out.println("-----------");
        }
    }
}
