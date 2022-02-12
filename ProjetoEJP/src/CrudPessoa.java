import java.util.*;

public class CrudPessoa {

    public CrudPessoa(){
        this.pessoas = new ArrayList<Pessoa>();
    }
    
    static ArrayList<Pessoa> pessoas;
    Scanner sc = new Scanner(System.in);
    String cpfConsulta;
    int option;

	public void cadastrarCliente() {
        Pessoa pessoa = new Pessoa();
        System.out.println("Nome: ");
        pessoa.setNome(sc.nextLine());
        System.out.println("CPF: ");
        pessoa.setCpf(sc.nextLine());
        System.out.println("Telefone para contato: ");
        pessoa.setTelefone(sc.nextLine());
        System.out.println("Data de nascimento: ");
        pessoa.setDataNascimento(sc.nextLine());
        pessoas.add(pessoa);
    }

    public void alterarPessoa() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpfConsulta)) {
                int index = pessoas.indexOf(pessoa);
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
                pessoas.set(index, pessoa);
            }
        }
    }

    public void consultarPessoa() {
       System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Cpf: " + p.getCpf());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Data de nascimento: " + p.getDataNascimento());
            }
        }
    }

    public void excluirPessoa() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Data de nascimento: " + p.getDataNascimento());
                System.out.println("CPF: " + p.getCpf());
                System.out.println("São realmente seus dados?(0)-Não (1)-Sim ");
                option = sc.nextInt();
                if (option == 1) pessoas.remove(pessoas.indexOf(p));

            }
        }
    }

    public void auto() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria Eduarda");
        pessoa.setCpf("987.654.321-10");
        pessoa.setTelefone("(85) 91234-5678");
        pessoa.setDataNascimento("8/3/2006");
        pessoas.add(pessoa);
    }
}
