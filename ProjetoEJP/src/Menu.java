import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Menu(){
        super();
        this.motoristas = new ArrayList<Motorista>();
        this.passageiros = new ArrayList<Pessoa>();
    }

    int option;
    Scanner sc = new Scanner(System.in);

    Pessoa passageiro = new Pessoa();
    Motorista motor = new Motorista();

    String cpfConsulta;

    ArrayList<Motorista> motoristas;
    ArrayList<Pessoa> passageiros;

    public void menuPrincipal() {
        System.out.println("##--MENU PRINCIPAL--##");
        System.out.println("| 1 - Passageiro |");
        System.out.println("| 2 - Motorista |");
        System.out.println("| 3 - Sair |");
        System.out.println("|---------------------|");
        option = sc.nextInt();
        switch (option) {
            case 1:
                menuPassageiro();
                break;
            case 2:
                menuMotorista();
                break;
            case 3:
                System.out.println("Tchau");
                break;
            default:
                System.out.println("Opção inválida");
                menuPrincipal();
                break;
        }
    }

    public void menuPassageiro() {
        do {
            System.out.println("##--MENU Passageiro--##");
            System.out.println("| 1 - Cadastrar |");
            System.out.println("| 2 - Alterar |");
            System.out.println("| 3 - Consultar |");
            System.out.println("| 4 - Excluir |");
            System.out.println("| 5 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    cadastrarPassageiro();
                    break;
                case 2:
                    alterarPassageiro();
                    break;
                case 3:
                    consultarPassageiro();
                    break;
                case 4:
                    excluirPassageiro();
                    break;
                case 5:
                    break;
                default:
                System.out.println("Operação inválida");
                    break;
            }
        } while (option != 5);
    }

    public void menuMotorista() {
        do {
            System.out.println("##--MENU Motorista--##");
            System.out.println("| 1 - Cadastrar |");
            System.out.println("| 2 - Alterar |");
            System.out.println("| 3 - Consultar |");
            System.out.println("| 4 - Excluir |");
            System.out.println("| 5 - Sair |");
            System.out.println("|---------------------|");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    cadastrarMotorista();
                    break;
                case 2:
                    alterarMotorista();
                    break;
                case 3:
                    consultarMotorista();
                    break;
                case 4:
                    excluirMotorista();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        } while (option != 5);
    }

    public void cadastrarMotorista() {
    	Motorista motorista = new Motorista();
        System.out.println("Nome: ");
        motorista.setNome(sc.nextLine());
        System.out.println("CPF: ");
        motorista.setCpf(sc.nextLine());
        System.out.println("Telefone para contato: ");
        motorista.setTelefone(sc.nextLine());
        System.out.println("Data de nascimento: ");
        motorista.setDataNascimento(sc.nextLine());
        System.out.println("Carro: ");
        motorista.setCarro(sc.nextLine());
        System.out.println("Cnh: ");
        motorista.setCnh(sc.nextLine());
        motoristas.add(motorista);
    }

    public void alterarMotorista() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Motorista m : motoristas) {
            if (m.getCpf().equals(cpfConsulta)) {
                int index = motoristas.indexOf(m);
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
                motoristas.set(index, m);
            }
        }
    }
    public void consultarMotorista() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Motorista m: motoristas) {
            if (m.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + m.getNome());
                System.out.println("Cpf: " + m.getCpf());
                System.out.println("Telefone: " + m.getTelefone());
                System.out.println("Data de nascimento: " + m.getDataNascimento());
                System.out.println("Cnh: " + m.getCnh());
            }
        }
    }
    public void excluirMotorista() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Motorista m: motoristas) {
            if (m.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + m.getNome());
                System.out.println("Cpf: " + m.getCpf());
                System.out.println("Telefone: " + m.getTelefone());
                System.out.println("Data de nascimento: " + m.getDataNascimento());
                System.out.println("Cnh: " + m.getCnh());
                System.out.println("São realmente seus dados?(0)-Não (1)-Sim ");
                option = sc.nextInt();
                if (option == 1) motoristas.remove(motoristas.indexOf(m));
            }
        }
    }

    public void cadastrarPassageiro() {
        Pessoa pessoa = new Pessoa();
        System.out.println("Nome: ");
        pessoa.setNome(sc.nextLine());
        System.out.println("CPF: ");
        pessoa.setCpf(sc.nextLine());
        System.out.println("Telefone para contato: ");
        pessoa.setTelefone(sc.nextLine());
        System.out.println("Data de nascimento: ");
        pessoa.setDataNascimento(sc.nextLine());
        passageiros.add(pessoa);
    }

    public void alterarPassageiro() {
        System.out.println("Cpf para consultar: ");
        cpfConsulta = sc.nextLine();
        for (Pessoa pessoa : passageiros) {
            if (pessoa.getCpf().equals(cpfConsulta)) {
                int index = passageiros.indexOf(pessoa);
                do {
                    System.out.println("1-Nome \n2-Telefone \n3-Data de nascimento: ");
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
