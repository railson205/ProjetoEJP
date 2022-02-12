import java.util.Scanner;

public class Menu {

	public Menu() {
		super();
	}

	int option;
	Scanner sc = new Scanner(System.in);

	MenuCliente menuCliente = new MenuCliente();
	MenuProfissional menuProfissional = new MenuProfissional();

	public void menuPrincipal() {
		do {
			System.out.println("##--MENU PRINCIPAL--##");
			System.out.println("| 1 - Cliente |");
			System.out.println("| 2 - Profissional |");
			System.out.println("| 3 - Sair |");
			System.out.println("| 4 - Auto|");//Método que cadastra um cliente e um profissional e solicita um serviço e vai verificar o histórico para saber se o profissional aceitou ou não
			System.out.println("|---------------------|");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				menuCliente.menu();
				break;
			case 2:
				menuProfissional.menu();
				break;
			case 3:
				System.out.println("Tchau");
				break;
				case 4:
				menuProfissional.auto();
				menuCliente.auto();
				menuCliente.autoServico();
				menuProfissional.autoServico();
				menuCliente.autoHistorico();
				menuProfissional.autoHistorico();
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (option != 3);
	}

}
