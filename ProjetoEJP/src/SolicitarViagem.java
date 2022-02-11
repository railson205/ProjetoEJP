import java.util.*;

public class SolicitarViagem {

    String cpfConsulta, partida, chegada;
    Scanner sc = new Scanner(System.in);
    boolean cadastro = false;

    public void solicitarViagem() {
        do {
            System.out.println("\nDigite seu cpf para podermos pegar seu cadastro: ");
            cpfConsulta = sc.next();
            for (Pessoa p : CrudPassageiro.passageiros) {
                if (p.getCpf().equals(cpfConsulta)) {
                    /*System.out.println("Nome: " + p.getNome());
                    System.out.println("Cpf: " + p.getCpf());
                    System.out.println("Telefone: " + p.getTelefone());
                    System.out.println("Data de nascimento: " + p.getDataNascimento());*/
                    cadastro = true;
                    break;
                }
                System.out.println("Cpf sem cadastro");
            }
        } while (!cadastro);
    }

}
