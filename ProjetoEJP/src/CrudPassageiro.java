import java.util.*;

public class CrudPassageiro {

    public CrudPassageiro(){
        this.passageiros = new ArrayList<Pessoa>();
    }
    
    static ArrayList<Pessoa> passageiros;
    ArrayList<Pessoa> passAux = new ArrayList<Pessoa>();
    Scanner sc = new Scanner(System.in);
    String cpfConsulta;
    int option;

	public ArrayList<Pessoa> cadastrarPassageiro() {
        Pessoa pessoa = new Pessoa();
        System.out.println("Nome: ");
        pessoa.setNome(sc.nextLine());
        System.out.println("CPF: ");
        pessoa.setCpf(sc.nextLine());
        System.out.println("Telefone para contato: ");
        pessoa.setTelefone(sc.nextLine());
        System.out.println("Data de nascimento: ");
        pessoa.setDataNascimento(sc.nextLine());
        passAux.add(pessoa);
        passageiros = passAux;
        return passageiros;
    }

    public void alterarPassageiro() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa pessoa : passageiros) {
            if (pessoa.getCpf().equals(cpfConsulta)) {
                int index = passageiros.indexOf(pessoa);
                do {
                    System.out.println("1-Nome \n2-Telefone \n3-Data de nascimento \n4-Sair: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            pessoa.setNome(sc.next());
                            break;
                        case 2:
                            pessoa.setTelefone(sc.next());
                            break;
                        case 3:
                            pessoa.setDataNascimento(sc.next());
                            break;
                        default:
                            option = 0;
                            break;
                    }
                } while (option != 0);
                passageiros.set(index, pessoa);
            }
        }
    }

    public void consultarPassageiro() {
       System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa p : passageiros) {
            if (p.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Cpf: " + p.getCpf());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Data de nascimento: " + p.getDataNascimento());
            }
        }
    }

    public void excluirPassageiro() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa p : passageiros) {
            if (p.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Data de nascimento: " + p.getDataNascimento());
                System.out.println("CPF: " + p.getCpf());
                System.out.println("São realmente seus dados?(0)-Não (1)-Sim ");
                option = sc.nextInt();
                if (option == 1) passageiros.remove(passageiros.indexOf(p));

            }
        }
    }
}
