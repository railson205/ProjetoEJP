import java.util.*;

public class SolicitarServico {

    public SolicitarServico() {
        this.precos = new ArrayList<Double>();
        this.profAux = new ArrayList<Profissional>();
        this.pessoa = new Pessoa();
        // TODO:add profissões
        this.precos.add(150.0);
        this.precos.add(160.0);
        this.precos.add(170.0);
        this.precos.add(180.0);
        this.precos.add(190.0);
        this.profAceita = new ArrayList<Integer>();
    }

    public SolicitarServico(Profissional prof, int dia, int mes, int horario, double preco, Pessoa pessoa,String problema,String cpfCliente) {
        this.profissional = prof;
        this.dia = dia;
        this.mes = mes;
        this.horario = horario;
        this.preco = preco;
        this.pessoa = pessoa;
        this.problema = problema;
        this.cpfCliente = cpfCliente;
        this.profAceita.add(0);
    }

    ArrayList<Double> precos;
    private ArrayList<Profissional> profAux;
    private String cpfConsulta;
    Scanner sc = new Scanner(System.in);
    boolean cadastro;
    int option;
    
    static ArrayList<Integer> profAceita;
    Profissional profissional;
    int dia;
    int mes;
    int horario;
    double preco;
    Pessoa pessoa;
    String problema;
    String cpfCliente;

    public void solicitarServico() {
        cadastro=false;
        do {
            System.out.println("\nDigite seu cpf para podermos pegar seu cadastro: ");
            cpfConsulta = sc.next();
            for (Pessoa p : CrudPessoa.pessoas) {
                if (p.getCpf().equals(cpfConsulta)) {
                    pessoa = p;
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
        System.out.println("Descreva o seu problema: ");
        problema = sc.next();
        System.out.println("Dia disponível para o profissional ir: ");
        System.out.println("Dia: ");
        dia = sc.nextInt();
        System.out.println("Mês: ");
        mes = sc.nextInt();
        System.out.println("Hora: ");
        horario = sc.nextInt();
        System.out.println("Serviço solicitado");
        SolicitarServico repassaServico = new SolicitarServico(profissional, dia, mes, horario, preco, pessoa,problema,cpfConsulta);
        HistoricoServico.addServico(repassaServico);
        MenuServicoProfissional.servicos.add(repassaServico);
        
    }

    public void auto() {
        System.out.println("\nSolicitar serviço\n");
        cadastro=false;
        cpfConsulta = "987.654.321-10";
        for (Pessoa p : CrudPessoa.pessoas) {
            if (p.getCpf().equals(cpfConsulta)) {
                pessoa = p;
                cadastro = true;
                break;
            }
            System.out.println("Cpf sem cadastro");
        }
        preco = precos.get(0);
        for (Profissional p : CrudProfissional.profissionais) {
            if (p.getProfissao().equalsIgnoreCase(CrudProfissional.profissoes.get(0))) {
                profAux.add(p);
                
            }
        }
        profissional = profAux.get(0);
        problema = "Estourou um cano no banheiro";
        dia = 12;
        mes = 2;
        horario = 16;

        SolicitarServico repassaServico = new SolicitarServico(profissional, dia, mes, horario, preco, pessoa,problema,"987.654.321-10");
        HistoricoServico.addServico(repassaServico);
        MenuServicoProfissional.servicos.add(repassaServico);
    }
}
