package com.example.Backend;

import java.util.ArrayList;
import java.util.Scanner;

public class Home {
    public Home() {
        init();
    }

    static ArrayList<String> profissoes = new ArrayList<String>();
    static ArrayList<String> profissoesProcura = new ArrayList<String>();
    private String email, senha, nome, descricao;

    public void init() {

        try {
            ConectaFirebase conecta = new ConectaFirebase();
            CurrentUser user = new CurrentUser();
            Notificacao not = new Notificacao();
            Historico hist = new Historico();
            ProfissionalManager prof = new ProfissionalManager();
            Perfil perfil = new Perfil();
            VerificaEmail verificaEmail = new VerificaEmail();
            Contrata contrata = new Contrata();

            Scanner s = new Scanner(System.in);
            int op = 0;
            // do {
            clear();
            System.out.println("opção:");
            // op = Integer.parseInt(s.next());

            op = -2;
            switch (op) {
                case 0:
                    System.out.println("email:");
                    email = "joao.railson.costa60@aluno.ifce.edu.br";
                    // email = s.nextLine();
                    System.out.println("senha:");
                    senha = "123456";
                    // senha = s.nextLine();
                    System.out.println(conecta.login(email, senha));
                    break;
                // login
                case 1:
                    System.out.println("email:");
                    email = "joaorailson7@gmail.com";
                    // email = s.nextLine();
                    System.out.println("senha:");
                    senha = "123456";
                    // senha = s.nextLine();
                    System.out.println(conecta.login(email, senha));
                    break;
                // cadastrar cliente
                case 2:
                    System.out.println("Nome e sobrenome");
                    // nome = s.nextLine();
                    nome = "João Railson";
                    System.out.println("Email:");
                    // email = s.nextLine();
                    email = "joaorailson7@gmail.com";
                    System.out.println("Senha:");
                    senha = "123456";
                    // senha = s.nextLine();

                    if (nome.trim().contains(" ") && senha.length() >= 6 && verificaEmail.isVerified(email)) {
                        conecta.inserirDadosCliente( nome,
                                email, senha);
                    }
                    break;
                // cadastrar profissional
                case 3:
                    System.out.println("Nome e sobrenome");
                    // nome = s.nextLine();
                    nome = "Jonas Almeida";
                    System.out.println("Profissões");
                    profissoes.add("Pedreiro");
                    System.out.println("Descrição:");
                    descricao = "Trabalho a 5 anos como pedreiro";
                    // descricao = s.nextLine();
                    System.out.println("Email:");
                    email = "joao.railson.costa60@aluno.ifce.edu.br";
                    // email = s.nextLine();
                    System.out.println("Senha:");
                    senha = "123456";
                    // senha = s.nextLine();
                    // System.out.println(nome.trim().contains(" ") +" "+ senha.length() +" "+
                    // verificaEmail.isVerified(email)+" "+descricao.trim().contains(" ")+"
                    // "+profissoes.size());
                    if (nome.trim().contains(" ") && senha.length() >= 6 && verificaEmail.isVerified(email)
                            && descricao.trim().contains(" ") && profissoes.size() > 0) {
                        conecta.inserirDadosProfissional( nome,
                                email, descricao, senha, profissoes);
                    }
                    break;
                // contratar profissional
                case 4:
                    prof.attListaProfissionais();
                    if (!user.uid.equals(conecta.lista.get(0).get(0))) {
                        contrata.pedido(user.uid, (String) conecta.lista.get(0).get(0),"");
                    }
                    break;
                // notificação para fornecer orçamento para o cliente
                case 5:
                    not.verificaMensagem(user.getCliente());
                    break;
                // notificação para fornecer endereço, data e horário para o profissional ir
                case 6:
                    not.verificaMensagem(user.getCliente());
                    break;
                // notificação para o profissional escolher a data e o horário
                case 7:
                    not.verificaMensagem(user.getCliente());
                    break;
                // notificação para o cliente saber quando o profissional virá
                case 8:
                    not.verificaMensagem(user.getCliente());
                    break;
                // histórico dos serviços pedidos
                case 9:
                    hist.mostaHistorico(user.uid,user.cliente);
                    break;
                // trocar senha
                case 10:
                    perfil.trocaSenha();
                    break;
                // trocar nome
                case 11:
                    perfil.trocaNome();
                    break;
                // mostrar avaliações
                case 12:
                    perfil.mostraAvaliacao();
                    break;
                // mostrar faturamento
                case 13:
                    perfil.faturamento();
                    break;
                case 14:
                    prof.procuraProfissional(s.nextLine());
                    break;
                case 15:
                    profissoesProcura.add("Pedreiro");
                    prof.procuraProfissional(profissoesProcura);
                    break;

                // auto
                case -2:
                /*email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                prof.attListaProfissionais();
                    if (!user.uid.equals(conecta.lista.get(0).get(0))) {
                        contrata.pedido(user.uid, (String) conecta.lista.get(0).get(0));
                    }
                    System.out.println("--------------------------------");
                    not.verificaMensagem(user.getCliente());
                    System.out.println("--------------------------------");

                    email = "joao.railson.costa60@aluno.ifce.edu.br";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    not.verificaMensagem(user.getCliente());
                    System.out.println("--------------------------------");

                    email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    not.verificaMensagem(user.getCliente());
                    System.out.println("--------------------------------");

                    email = "joao.railson.costa60@aluno.ifce.edu.br";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    not.verificaMensagem(user.getCliente());
                    System.out.println("--------------------------------");

                    email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    not.verificaMensagem(user.getCliente());
                    System.out.println("--------------------------------");
                    email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    hist.mostaHistorico(user.uid);
                    System.out.println("--------------------------------");

                    email = "joao.railson.costa60@aluno.ifce.edu.br";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    hist.mostaHistorico(user.uid);
                    System.out.println("--------------------------------");

                    email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    hist.mostaHistorico(user.uid);
                    System.out.println("--------------------------------");


                    System.out.println("--------------------------------");
                    email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    hist.mostaHistorico(user.uid);
                    System.out.println("--------------------------------");

                    email = "joao.railson.costa60@aluno.ifce.edu.br";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    hist.mostaHistorico(user.uid);
                    System.out.println("--------------------------------");*/

                    email = "joaorailson7@gmail.com";
                    senha = "123456";
                    System.out.println(conecta.login(email, senha));
                    hist.mostaHistorico(user.uid,user.cliente);


                    break;

            }

            // } while (op != -1);
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void clear() {
        email = null;
        senha = null;
        nome = null;
        descricao = null;
        profissoes.clear();
        profissoesProcura.clear();
    }
}
