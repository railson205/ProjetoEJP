import java.util.*;

public class CrudMotorista {

    public CrudMotorista() {
        this.motoristas = new ArrayList<Motorista>();
    }

    Scanner sc = new Scanner(System.in);
    String cpfConsulta;
    int option;

    ArrayList<Motorista> motoristas;

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
        for (Motorista m : motoristas) {
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
        for (Motorista m : motoristas) {
            if (m.getCpf().equals(cpfConsulta)) {
                System.out.println("Nome: " + m.getNome());
                System.out.println("Cpf: " + m.getCpf());
                System.out.println("Telefone: " + m.getTelefone());
                System.out.println("Data de nascimento: " + m.getDataNascimento());
                System.out.println("Cnh: " + m.getCnh());
                System.out.println("São realmente seus dados?(0)-Não (1)-Sim ");
                option = sc.nextInt();
                if (option == 1)
                    motoristas.remove(motoristas.indexOf(m));
            }
        }
    }

}
