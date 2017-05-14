package lpii;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LPII {

    static Scanner Int = new Scanner(System.in);
    static Scanner string = new Scanner(System.in);
    static Scanner Long = new Scanner(System.in);
    static int op, opPlano, opOperadora, opOperadora2, opAut;
    static Autorizacao aut = new Autorizacao();

    static ArrayList<Segurado> segurados = new ArrayList();
    static ArrayList<PlanoDeSaude> planos = new ArrayList();
    static ArrayList<Operadora> operadoras = new ArrayList();
    static ArrayList<Procedimento> procedimentos = new ArrayList();

    public static void main(String[] args) {
        ArrayList<Clinica> clinicas = new ArrayList();
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd / MM / yyyy");
        long numAut, cpf, cep;
        String nomePlano, nomeSegurado, nomeProcedimento, nomeClinica, nomeHospital;
        boolean val = true;
        int opSegurado, opProcedimento, outroPlano, qtdMed, qtdTec;

        //Operadoras, Planos e Segurados já cadastrados
        aut.setData(formatarDate.format(data));
        Operadora o1 = new Operadora("Operadora1");
        operadoras.add(o1);
        Operadora o2 = new Operadora("Operadora2");
        operadoras.add(o2);
        Segurado s1 = new Segurado("Segurado1", 1);
        segurados.add(s1);
        Segurado s2 = new Segurado("Segurado2", 2);
        segurados.add(s2);
        PlanoDeSaude p1 = new PlanoDeSaude("Plano1", 1);
        planos.add(p1);
        PlanoDeSaude p2 = new PlanoDeSaude("Plano2", 2);
        planos.add(p2);
        PlanoDeSaude p3 = new PlanoDeSaude("Plano3", 3);
        planos.add(p3);
        p1.addSegurado(s1);
        p1.addSegurado(s2);
        p2.addSegurado(s1);
        p3.addSegurado(s2);
        o1.addPlano(p1);
        o1.addPlano(p2);
        o2.addPlano(p3);
        s1.addPlano(p2);
        s2.addPlano(p1);
        s2.addPlano(p3);
        //***********************************************
        Menu();

        while (op != 0) {
            switch (op) {
                case 1:
                    System.out.println("");
                    System.out.println("   ----Cadastrar um plano----");
                    MenuOperadora();
                    System.out.print("Entre com o nome do plano: ");
                    nomePlano = string.nextLine();
                    for (int i = 0; i < operadoras.size(); i++) {
                        for (int j = 0; j < operadoras.get(i).getPlanos().size(); j++) {
                            while (operadoras.get(i).getPlanos().get(j).getNome().equals(nomePlano)) {
                                System.out.println("");
                                System.out.println("Este plano já está cadastrado!");
                                System.out.print("Entre com outro plano: ");
                                i = 0;
                                j = 0;
                                nomePlano = string.nextLine();
                            }
                        }
                    }
                    System.out.print("Entre com o número de autorização: ");
                    numAut = Long.nextLong();
                    PlanoDeSaude p = new PlanoDeSaude(nomePlano, numAut);
                    planos.add(p);
                    operadoras.get(opOperadora - 1).addPlano(p);
                    System.out.println("");
                    System.out.println("Plano cadastrado com sucesso!!");
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("   ----Cadastrar um Segurado em um plano----");
                    System.out.print("Entre com o nome do segurado: ");
                    nomeSegurado = string.nextLine();
                    for (int i = 0; i < segurados.size(); i++) {
                        while (segurados.get(i).getNome().equals(nomeSegurado)) {
                            System.out.println("Segurado já cadastrado.");
                            System.out.print("Entre com o nome do segurado: ");
                            nomeSegurado = string.nextLine();
                        }
                    }
                    System.out.print("Entre com o CPF: ");
                    cpf = Long.nextLong();
                    for (int i = 0; i < segurados.size(); i++) {
                        while (segurados.get(i).getCpf() == cpf) {
                            System.out.println("Número de CPF já cadastrado.");
                            System.out.print("Entre com o CPF: ");
                            cpf = Long.nextLong();
                        }
                    }
                    Segurado s = new Segurado(nomeSegurado, cpf);
                    segurados.add(s);
                    System.out.println("");
                    MenuOperadora();
                    System.out.println("");
                    PlanosOperadora();
                    s.addPlano(operadoras.get(opOperadora - 1).getPlanos().get(opPlano - 1));
                    planos.get(opPlano - 1).addSegurado(s);
                    System.out.println("");
                    System.out.print("Deseja cadastrar outro plano? 1-sim | 2-não: ");
                    outroPlano = Int.nextInt();
                    while (outroPlano < 1 || outroPlano > 2) {
                        System.out.println("Opção inválida");
                        System.out.print("Deseja cadastrar outro plano? 1-sim | 2-não: ");
                        outroPlano = Int.nextInt();
                    }
                    while (outroPlano == 1) {
                        MenuOperadora();
                        opOperadora2 = opOperadora;
                        System.out.println("");
                        PlanosOperadora();
                        for (int j = 0; j < segurados.get(segurados.size() - 1).getPlanos().size(); j++) {
                            if (segurados.get(segurados.size() - 1).getPlanos().get(j).getNome() == operadoras.get(opOperadora - 1).getPlanos().get(opPlano - 1).getNome()) {
                                System.out.println("");
                                System.out.println("Plano já cadastrado ao segurado!!!!");
                                val = false;
                            }
                        }

                        if (val == true) {
                            s.addPlano(operadoras.get(opOperadora - 1).getPlanos().get(opPlano - 1));
                        }
                        System.out.print("Deseja cadastrar outro plano? 1-sim | 2-não: ");
                        outroPlano = Int.nextInt();
                        while (outroPlano < 1 || outroPlano > 2) {
                            System.out.println("Opção inválida");
                            System.out.print("Deseja cadastrar outro plano? 1-sim | 2-não: ");
                            outroPlano = Int.nextInt();
                        }
                    }
                    System.out.println("");
                    System.out.println("Segurado " + s.getNome() + " cadastrado ao(s) plano(s): ");
                    for (int i = 0; i < segurados.get(segurados.size() - 1).getPlanos().size(); i++) {
                        System.out.println("  " + segurados.get(segurados.size() - 1).getPlanos().get(i).getNome() + " | nº autorização: " + segurados.get(segurados.size() - 1).getPlanos().get(i).getNumAut());
                    }
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("  ----Criar um procedimento----");
                    System.out.println("Para criar um procedimento selecione um segurado");
                    System.out.println("");
                    for (int i = 0; i < segurados.size(); i++) {
                        System.out.println((i + 1) + "-" + segurados.get(i).getNome());
                    }
                    System.out.print("Selecione um segurado: ");
                    opSegurado = Int.nextInt();
                    while (opSegurado < 1 || opSegurado > segurados.size()) {
                        System.out.println("Opção invalida");
                        System.out.print("Selecione um segurado: ");
                        opSegurado = Int.nextInt();
                    }
                    System.out.println("");
                    System.out.println(" -Selecione um plano do segurado " + segurados.get(opSegurado - 1).getNome() + "-");
                    System.out.println("");
                    for (int i = 0; i < segurados.get(opSegurado - 1).getPlanos().size(); i++) {
                        System.out.println((i + 1) + "-" + segurados.get(opSegurado - 1).getPlanos().get(i).getNome());
                    }
                    System.out.print("Opção:");
                    opPlano = Int.nextInt();
                    while (opPlano < 1 || opPlano > segurados.get(opSegurado - 1).getPlanos().size()) {
                        System.out.println("");
                        System.out.println("Opção inválida");
                        System.out.print("Opção:");
                        opPlano = Int.nextInt();
                    }
                    System.out.println("");
                    System.out.print("Entre com o nome do procedimento: ");
                    nomeProcedimento = string.nextLine();
                    Procedimento proc = new Procedimento(nomeProcedimento);
                    procedimentos.add(proc);
                    PlanoDeSaude p4 = new PlanoDeSaude(segurados.get(segurados.size() - 1).getPlanos().get(opPlano - 1).getNome(), 4);
                    p4.addProcedimento(proc);
                    System.out.println("");
                    System.out.println(" -Selecione o meio do procedimento- ");
                    System.out.println("1-Ambulatotial");
                    System.out.println("2-Cirurgico");
                    System.out.print("Opção:");
                    opProcedimento = Int.nextInt();
                    while (opProcedimento < 1 || opProcedimento > 2) {
                        System.out.println("");
                        System.out.println("Opçao inválida");
                        System.out.print("Opção:");
                        opProcedimento = Int.nextInt();
                    }
                    switch (opProcedimento) {
                        case 1:
                            System.out.print("Entre com a quantidade de técnicos: ");
                            qtdTec = Int.nextInt();
                            System.out.print("Entre com o nome da clínica: ");
                            nomeClinica = string.nextLine();
                            System.out.print("Entre com o CEP do local: ");
                            cep = Long.nextLong();
                            Ambulatorial amb = new Ambulatorial(qtdTec, nomeClinica);
                            break;
                        case 2:
                            System.out.print("Entre com a quantidade de médicos: ");
                            qtdMed = Int.nextInt();
                            System.out.print("Entre com o nome do hospital: ");
                            nomeHospital = string.nextLine();
                            System.out.print("Entre com o CEP do local: ");
                            cep = Long.nextLong();
                            break;
                    }
                    System.out.println("");
                    MenuAutorizar();
                    break;
                case 4:
                    if (procedimentos.size() == 0) {
                        System.out.println("Nenhum procedimento cadastrado!!");
                    } else {
                        System.out.println(" -Selecione um procedimento-");
                        for (int i = 0; i < procedimentos.size(); i++) {
                            System.out.println((i+1)+"-"+procedimentos.get(i).getNome());
                        }
                        System.out.print("Opção: ");
                        opProcedimento = Int.nextInt();
                        MenuAutorizar();
                    }
                    break;

                case 5:
                    System.out.println("");
                    System.out.println("-----------------------------");
                    for (int i = 0; i < operadoras.size(); i++) {
                        System.out.println("Operadora: " + operadoras.get(i).getNome());
                        for (int k = 0; k < operadoras.get(i).getPlanos().size(); k++) {
                            System.out.println("  Plano: " + operadoras.get(i).getPlanos().get(k).getNome() + " | Número de autorização: " + operadoras.get(i).getPlanos().get(k).getNumAut());
                            for (int l = 0; l < operadoras.get(i).getPlanos().get(k).getSegurados().size(); l++) {
                                System.out.println("   Segurado: " + operadoras.get(i).getPlanos().get(k).getSegurados().get(l).getNome() + " | CPF: " + operadoras.get(i).getPlanos().get(k).getSegurados().get(l).getCpf());
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("-----------------------------");
                    break;
            }
            Menu();
        }

    }

    public static void Menu() {
        System.out.println("");
        System.out.println("   ----MENU----");
        System.out.println("0-Sair");
        System.out.println("1-Cadastrar um plano no sistema");
        System.out.println("2-Cadastrar um segurado em um plano");
        System.out.println("3-Criar um procedimento");
        System.out.println("4-Mudar autorização do procedimento");
        System.out.println("5-Visualizar Operadoras|Planos|Segurados");
        System.out.print("Opção:");
        op = Int.nextInt();
        while (op < 0 || op > 5) {
            System.out.println("");
            System.out.println("Opção inválida");
            System.out.print("Opção:");
            op = Int.nextInt();
        }
    }

    public static void MenuOperadora() {
        System.out.println("  -Selecione uma operadora-");
        for (int j = 0; j < operadoras.size(); j++) {
            System.out.println((j + 1) + "-" + operadoras.get(j).getNome());
        }
        System.out.print("Opção:");
        opOperadora = Int.nextInt();
        while (opOperadora < 1 || opOperadora > operadoras.size()) {
            System.out.println("");
            System.out.println("Opção inválida");
            System.out.print("Opção:");
            opOperadora = Int.nextInt();
        }
    }

    public static void PlanosOperadora() {//Requer o MenuOperadora para funcionar(variavel opOperadora)
        System.out.println("  -Planos da operadora " + operadoras.get(opOperadora - 1).getNome() + "-");
        for (int i = 0; i < operadoras.get(opOperadora - 1).getPlanos().size(); i++) {
            System.out.println((i + 1) + "-" + operadoras.get(opOperadora - 1).getPlanos().get(i).getNome());
        }
        System.out.print("Opção:");
        opPlano = Int.nextInt();
        while (opPlano < 1 || opPlano > operadoras.get(opOperadora - 1).getPlanos().size()) {
            System.out.println("");
            System.out.println("Opção inválida");
            System.out.print("Opção:");
            opPlano = Int.nextInt();
        }
    }

    public static void MenuAutorizar() {
        System.out.println(" -Autorização-");
        System.out.println("1-Autorizar");
        System.out.println("2-Negar");
        System.out.print("Opçao: ");
        opAut = Int.nextInt();
        while (opAut < 1 || opAut > 2) {
            System.out.println("");
            System.out.println("Opção inválida");
            System.out.print("Opçao: ");
            opAut = Int.nextInt();
        }
        System.out.println("");
        if (opAut == 1) {
            System.out.println("  Estado: " + Estado.EstadoEnum.AUTORIZADO.estado);
            System.out.println("  Autorizado em: " + aut.getData());
        } else {
            System.out.println("  Esatdo: " + Estado.EstadoEnum.NEGADO.estado);
            System.out.println("  Negaddo em: " + aut.getData());
        }
    }
}
