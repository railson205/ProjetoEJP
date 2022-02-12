import java.util.*;

public class CrudProfissional {

    public CrudProfissional() {
        this.profissionais = new ArrayList<Profissional>();

        this.profissoes = new ArrayList<String>();
        this.profissoes.add("Encanador");
        this.profissoes.add("Eletricista");
        this.profissoes.add("Pedreiro");
        this.profissoes.add("Babá");
        this.profissoes.add("Diarista");
    }

    Scanner sc = new Scanner(System.in);
    String cpfConsulta;
    int option;

    static ArrayList<String> profissoes;
    static ArrayList<Profissional> profissionais;

    public void cadastrarProfissional() {
        Profissional c = new Profissional();
        System.out.println("Nome: ");
        c.setNome(sc.nextLine());
        System.out.println("CPF: ");
        c.setCpf(sc.nextLine());
        System.out.println("Telefone para contato: ");
        c.setTelefone(sc.nextLine());
        System.out.println("Data de nascimento: ");
        c.setDataNascimento(sc.nextLine());
        System.out.println("Profissão que vai prestar serviço: ");
        for (String p : profissoes)
            System.out.println((profissoes.indexOf(p) + 1) + "-" + p);
        option = sc.nextInt();
        c.setProfissao(profissoes.get(option - 1));
        System.out.println("Coloque uma descrição sobre você e seu trabalho: ");
        c.setDescricao(sc.nextLine());
        profissionais.add(c);
    }

    public void alterarProfissional() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Profissional m : profissionais) {
            if (m.getCpf().equals(cpfConsulta)) {
                int index = profissionais.indexOf(m);
                do {
                    System.out.println(
                            "Diga o quê você quer alterar \n1-Nome \n2-Telefone \n3-Data de nascimento \n4-Profissão \n5-Descrição: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            m.setNome(sc.next());
                            break;
                        case 2:
                            m.setTelefone(sc.next());
                            break;
                        case 3:
                            m.setDataNascimento(sc.next());
                            break;
                        case 4:
                            m.setProfissao(sc.next());
                            break;
                        case 5:
                            m.setDescricao(sc.next());
                        default:
                            option = 0;
                            break;
                    }
                } while (option != 0);
                profissionais.set(index, m);
            }
        }
    }

    public void consultarProfissional() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Profissional m : profissionais) {
            if (m.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + m.getNome());
                System.out.println("Cpf: " + m.getCpf());
                System.out.println("Telefone: " + m.getTelefone());
                System.out.println("Data de nascimento: " + m.getDataNascimento());
                System.out.println("Profissão: " + m.getProfissao());
                System.out.println("Descrição: " + m.getDescricao());
            }
        }
    }

    public void excluirProfissional() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Profissional m : profissionais) {
            if (m.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + m.getNome());
                System.out.println("Cpf: " + m.getCpf());
                System.out.println("Telefone: " + m.getTelefone());
                System.out.println("Data de nascimento: " + m.getDataNascimento());
                System.out.println("Profissão: " + m.getProfissao());
                System.out.println("Descrição: " + m.getDescricao());
                System.out.println("São realmente seus dados?(0)-Não (1)-Sim ");
                option = sc.nextInt();
                if (option == 1)
                    profissionais.remove(profissionais.indexOf(m));
            }
        }
    }
}
