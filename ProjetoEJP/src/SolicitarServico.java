import java.util.*;

public class SolicitarServico {

    public SolicitarServico() {
        this.precos = new ArrayList<Double>();
        this.profAux = new ArrayList<Profissional>();
        // TODO:add profissões
        this.precos.add(150.0);
        this.precos.add(160.0);
        this.precos.add(170.0);
        this.precos.add(180.0);
        this.precos.add(190.0);
    }

    public SolicitarServico(Profissional prof,int dia,int mes, String horario,double preco) {
this.profissional = prof;
this.dia = dia;
this.mes = mes;
this.horario = horario;
this.preco = preco;
    }

    ArrayList<Double> precos;
    ArrayList<Profissional> profAux;
    String cpfConsulta;
    Scanner sc = new Scanner(System.in);
    boolean cadastro = false;
    int option;
    Profissional profissional;
    int dia;
    int mes;
    String horario;
    double preco;

    public void solicitarServico() {
        do {
            System.out.println("\nDigite seu cpf para podermos pegar seu cadastro: ");
            cpfConsulta = sc.next();
            for (Pessoa p : CrudPessoa.pessoas) {
                if (p.getCpf().equals(cpfConsulta)) {
                    cadastro = true;
                    break;
                }
                System.out.println("Cpf sem cadastro");
            }
        } while (!cadastro);
        System.out.println("Profissões para contratar:");
        for (String p : CrudProfissional.profissoes)
            System.out.println((CrudProfissional.profissoes.indexOf(p) + 1) + "-" + p);
        option = sc.nextInt();
        System.out.println("Preço base:(valor podendo sofrer alteração no decorrrer do serviço)");
        preco = precos.get(option - 1);
        System.out.printf("R$ %.2f\n\n", precos.get(option - 1));
        System.out.println("Escolha entre esses profissionais da área");
        int cont = 0;
        for (Profissional p : CrudProfissional.profissionais) {
            cont++;
            if (p.getProfissao().equalsIgnoreCase(CrudProfissional.profissoes.get(option - 1))) {
                profAux.add(p);
                System.out.println(cont + "-" + p.toString());
            }
        }
        option = sc.nextInt();
        profissional = profAux.get(option - 1);
        System.out.println("Dia disponível para o profissional ir: ");
        System.out.println("Dia: ");
        dia = sc.nextInt();
        System.out.println("Mês: ");
        mes = sc.nextInt();
        System.out.println("Hora: ");
        horario = sc.next();
        System.out.println("Serviço solicitado");
        HistoricoServico.solicitacoes.add(new SolicitarServico(profissional,dia,mes,horario,preco));
    }

}
