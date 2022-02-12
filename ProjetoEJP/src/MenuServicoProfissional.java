import java.util.*;

public class MenuServicoProfissional {
    int option;
    Scanner sc = new Scanner(System.in);
    String cpfConsulta;
    boolean cadastro = false;

    public MenuServicoProfissional() {
        this.servicos = new ArrayList<SolicitarServico>();
        this.historicoServico = new ArrayList<SolicitarServico>();
    }

    public MenuServicoProfissional(SolicitarServico ser) {
        this.servicos = new ArrayList<SolicitarServico>();
        this.historicoServico = new ArrayList<SolicitarServico>();
        servicos.add(ser);
    }

    static ArrayList<SolicitarServico> servicos;
    static ArrayList<SolicitarServico> historicoServico;

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
        cadastro = false;
        System.out.println("Cpf para consulta: ");
         cpfConsulta = sc.next();
        for (SolicitarServico s : servicos) {
            if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta))
                cadastro = true;
        }
        if (servicos.size() >= 1 && cadastro) {

            int cont = 0;
            for (SolicitarServico solSer : servicos) {
                cont++;
                System.out.println(cont + "ª solicitação");
                System.out.println("Nome do cliente: " + solSer.pessoa.getNome());
                System.out.println("Descrição do problema: " + solSer.problema);
                System.out.printf("Data e horário de ida solicitado pelo cliente: %d/%d às %dh\n", solSer.dia,
                        solSer.mes, solSer.horario);
                HistoricoServico.attServico(solSer, 2);
                System.out.println("-----------\n");
            }            
             do {
             
             System.out.println(
             "Qual das solicitações você irá aceitar?(digite 0 se não for aceitar mais nenhuma solicitação)"
             );
             option = sc.nextInt();
             if (option > 0) {
             HistoricoServico.attServico(servicos.get(option - 1), 1);
             historicoServico.add(servicos.get(option - 1));
             }
             } while (option != 0);
             

        } else if (!cadastro)
            System.out.println("Cadastro não encontrado");
        else if (servicos.size() < 1 && cadastro)
            System.out.println("Sem solicitação de serviços");

    }

    public void historicoServico() {
        cadastro = false;
        System.out.println("Cpf para consultar: ");
         cpfConsulta = sc.next();
        for (SolicitarServico s : servicos) {
            if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta))
                cadastro = true;
        }

        if (cadastro) {
            System.out.println(historicoServico.size());
            for (SolicitarServico s : historicoServico) {
                if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta)) {
                    System.out.println("Nome do cliente: " + s.pessoa.getNome());
                    System.out.println("Descrição do problema: " + s.problema);
                    System.out.printf("Data e horário do serviço: %d/%d às %dh\n", s.dia, s.mes, s.horario);
                    System.out.println("Valor base cobrado: " + s.preco);
                    switch (s.profAceita.get(historicoServico.indexOf(s))) {
                        case 1:
                            System.out.println("Você aceitou o serviço");
                            break;
                        case 2:
                            System.out.println("Você recusou o serviço");
                            break;
                    }
                    System.out.println("----------------");
                }
            }
        } else
            System.out.println("Cadastro não encontrado");

    }

    public void verificaGanho() {
        double sum = 0;
        cadastro = false;

        System.out.println("Cpf para consultar: ");
         cpfConsulta = sc.next();
        //cpfConsulta = "123.456.789-01"; //Retire o // do começo para rodá-lo sem ter q colocar cpf e comente a linha acima
        for (SolicitarServico s : servicos) {
            if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta))
                cadastro = true;
        }
        if (cadastro) {

            for (SolicitarServico s : historicoServico)
                sum += s.preco;
            System.out.printf("\nVocê ganhou no mínimo: R$%.2f com seus serviços\n", sum);
        } else
            System.out.println("Cadastro não encontrado");
    }

    public void autoServico() {
        System.out.println("\nVerificar e confirmar serviço do profissional\n");
            cadastro = false;
            cpfConsulta = "123.456.789-01";
            for (SolicitarServico s : servicos) {
                if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta))
                    cadastro = true;
            }
            if (servicos.size() >= 1 && cadastro) {
    
                int cont = 0;
                for (SolicitarServico solSer : servicos) {
                    cont++;
                    System.out.println(cont + "ª solicitação");
                    System.out.println("Nome do cliente: " + solSer.pessoa.getNome());
                    System.out.println("Descrição do problema: " + solSer.problema);
                    System.out.printf("Data e horário de ida solicitado pelo cliente: %d/%d às %dh\n", solSer.dia,
                            solSer.mes, solSer.horario);
                    HistoricoServico.attServico(solSer, 2);
                    System.out.println("-----------\n");
                }
                HistoricoServico.attServico(servicos.get(0), 1);
                historicoServico.add(servicos.get(0));    
            } else if (!cadastro)
                System.out.println("Cadastro não encontrado");
            else if (servicos.size() < 1 && cadastro)
                System.out.println("Sem solicitação de serviços");
    
        
    }

    public void autoHistorico() {
        System.out.println("\nHistórico de  serviços do profissional\n");
        cadastro = false;
        cpfConsulta = "123.456.789-01";
        for (SolicitarServico s : servicos) {
            if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta))
                cadastro = true;
        }

        if (cadastro) {
            System.out.println(historicoServico.size());
            for (SolicitarServico s : historicoServico) {
                if (s.profissional.getCpf().equalsIgnoreCase(cpfConsulta)) {
                    System.out.println("Nome do cliente: " + s.pessoa.getNome());
                    System.out.println("Descrição do problema: " + s.problema);
                    System.out.printf("Data e horário do serviço: %d/%d às %dh\n", s.dia, s.mes, s.horario);
                    System.out.println("Valor base cobrado: " + s.preco);
                    switch (s.profAceita.get(historicoServico.indexOf(s))) {
                        case 1:
                            System.out.println("Você aceitou o serviço");
                            break;
                        case 2:
                            System.out.println("Você recusou o serviço");
                            break;
                    }
                    System.out.println("----------------");
                }
            }
        } else
            System.out.println("Cadastro não encontrado");
    }
}
