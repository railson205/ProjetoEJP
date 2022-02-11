import java.util.*;

public class CrudProfissional {

    public CrudProfissional() {
        this.profissionais = new ArrayList<Profissional>();
    }

    Scanner sc = new Scanner(System.in);
    String cpfConsulta;
    int option;

    ArrayList<Profissional> profissionais;

    public void cadastrarProfissional() {
        Profissional c = new Profissional();
        /*System.out.println("Nome: ");
        c.setNome(sc.nextLine());
        System.out.println("CPF: ");
        c.setCpf(sc.nextLine());
        System.out.println("Telefone para contato: ");
        c.setTelefone(sc.nextLine());
        System.out.println("Data de nascimento: ");
        c.setDataNascimento(sc.nextLine());
        System.out.println("Carro: ");
        c.setCarro(sc.nextLine());
        System.out.println("Cnh: ");
        c.setCnh(sc.nextLine());*/
        profissionais.add(c);
    }

    public void alterarProfissional() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Profissional m : profissionais) {
            if (m.getCpf().equals(cpfConsulta)) {
                int index = profissionais.indexOf(m);
                do {
                    System.out.println("1-Nome \n2-Telefone \n3-Data de nascimento \n4-Carro: ");
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
                            m.setCarro(sc.next());
                            break;
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
                System.out.println("Cnh: " + m.getCnh());
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
                System.out.println("Cnh: " + m.getCnh());
                System.out.println("São realmente seus dados?(0)-Não (1)-Sim ");
                option = sc.nextInt();
                if (option == 1)
                    profissionais.remove(profissionais.indexOf(m));
            }
        }
    }

}
