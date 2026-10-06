import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Main {
      public static void main(String[] args) {
 
        Scanner s = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>();
        System.out.println("Digite o número de robôs a serem cadastrados: ");
        int numRobos = s.nextInt();
        int opt = -1;
        do {
 
            System.out.println();
            System.out.println("=================================");
            System.out.println("   ==== Batalha de Robôs ====    ");
            System.out.println("=================================");
            System.out.println("  0. Sair");
            System.out.println("  1. Cadastrar participante");
            System.out.println("  2. Consultar robos");
            System.out.println("  3. Realizar combate");
            System.out.println("  4. Recuperar energia dos robos");
            System.out.println("  5. Excluir robos");
            System.out.println("---------------------------------");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
 
            switch (opt) {
 
                case 0:
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("   Até mais!  ");
                    System.out.println("=================================");
                    break;
 
                case 1:
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("        Cadastrar Robo");
                    System.out.println("=================================");
 
                    for(int codigo = 0; codigo<numRobos; codigo++){
                   
                    System.out.println("Código: " + (1 + codigo));
 
                    System.out.println("Digite o nome do robo: ");
                    String nome = s.next();
                   
                    int ataque;
                    do{
                   
                    try{
                    System.out.println("Digite o ataque do robo: ");
                    ataque = s.nextInt();
                    if (ataque<10 && ataque>30) {
                        System.out.println("Ataque inválido!");
                    }
                }
                    catch(InputMismatchException e){
                        System.out.println("Digite apenas números!");
                        s.next();
                        ataque = 0;
                    }
                    }while(ataque<10 || ataque>30);
 
                    int defesa;
                    do{
                   
                    try{
                    System.out.println("Digite o defesa do robo: ");
                    defesa = s.nextInt();
                    if (defesa<0 && defesa>20) {
                        System.out.println("Defesa inválido!");
                    }
                }
                    catch(InputMismatchException e){
                        System.out.println("Digite apenas números!");
                        s.next();
                        defesa = 0;
                    }
                    }while(defesa<0 || defesa>20);
 
                    Robo robo = new Robo(
                            codigo + 1,
                            nome,
                            ataque,
                            defesa,
                            100,
                        0,
                    0,
                0);
                    robos.add(robo);
                    }
                    System.out.println();
                    System.out.println("---------------------------------");
                    System.out.println("Robô cadastrado com sucesso!");
                    System.out.println("---------------------------------");
                    break;
 
                case 2:
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("         Lista de Robôs");
                    System.out.println("=================================");
 
                    if (robos.isEmpty()) {
                        System.out.println("Nenhum robô cadastrado.");
                    } else {
 
                        for (Robo p : robos) {
                            p.Consultar();
 
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("     Rinha      ");
                    System.out.println("=================================");
                    System.out.println("Insira o código do primeiro robo: ");
                    int codigo1 = s.nextInt();
                    System.out.println("Insira o código do segundo robo: ");
                    int codigo2 = s.nextInt();
                   
                    Robo robo1 = null;
                    Robo robo2 = null;
 
                    for(Robo r: robos){
                        if(r.codigo == codigo1){
                            robo1 = r;
                        }
                        if(r.codigo == codigo2){
                            robo2 = r;
                        }
                    }
 
                    if (codigo1 == codigo2) {
                        System.out.println("Robos devem ser diferentes");
                        continue;
                    }
 
                    if (robo1 == null || robo2 == null) {
                        System.out.println("Código inválido");
                        continue;
                    }
                    Robo primeiro;
                    Robo segundo;
                    if (robo1.pontos == robo2.pontos) {
                        primeiro = robo1.codigo > robo2.codigo ? robo2 : robo1;
                        segundo = robo1.codigo > robo2.codigo ? robo1 : robo2;
                    } else if (robo1.pontos < robo2.pontos) {
                        primeiro = robo1;
                        segundo = robo2;
                    } else {
                        primeiro = robo2;
                        segundo = robo1;
                    }
 
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Rodada " + i + "ª: ");
                        int dano = primeiro.ataque - segundo.defesa;
                        if (dano < 0) {
                            dano = 0;
                        } else if (dano < 5) {
                            dano = 5;
                        }
 
                        if (i % 2 == 0) {
                            dano += 5;
                        }
 
                        segundo.energia -= dano;
                        if (segundo.energia < 0) {
                            segundo.energia = 0;
                        }
                        if (segundo.energia == 0) {
                            break;
                        }
 
                        primeiro.Consultar();
                        segundo.Consultar();
 
                        Robo swap = primeiro;
                        primeiro = segundo;
                        segundo = swap;
                    }
 
                    if (primeiro.energia == segundo.energia) {
                        primeiro.pontos ++;
                        segundo.pontos ++;
                    } else if (primeiro.energia > segundo.energia) {
                        primeiro.pontos += 3;
                        primeiro.vitoria++;
                        segundo.derrota++;
                    } else {
                        segundo.pontos += 3;
                        segundo.vitoria++;
                        primeiro.derrota++;
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("         Recuperar energia");
                    System.out.println("=================================");
                    System.out.println("Insira o código do robo a ser recarregado: ");
                    int roboCodigo = s.nextInt();
                    int energiaRecarga = 0;
                    int resto = 0;
                    do {
                        System.out.println("Insira a quantidade de energia a ser recarregada: ");
                        energiaRecarga = s.nextInt();
   
                        resto = energiaRecarga % 10;
                       
                        if (resto > 0) {
                            System.out.println("Energia informada não é multipla de 10. Digite novamente.");
                        }
                    } while (resto > 0);
 
                    Robo roboRecarga = null;
 
                    for(Robo r: robos){
                        if(r.codigo == roboCodigo){
                            roboRecarga = r;
                        }
                    }
                    if(roboRecarga == null){
                        System.out.println("Robo não encontrado");
                        break;
                    }
 
                    if ((roboRecarga.energia + energiaRecarga) > 100) {
                        System.out.println("Operação supera a quantidade de 100 energias. Tente novamente");
                        break;
                    }
                    int pontosAReduzir = energiaRecarga / 10;
 
                    if (roboRecarga.pontos < pontosAReduzir) {
                        System.out.println("Robo não possui a quantidade necessária de pontos. Tente novamente");
                        break;
                    }
 
                    roboRecarga.energia += energiaRecarga;
                    roboRecarga.pontos -= pontosAReduzir;
                    break;
                case 5:
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println("         Excluir robos");
                    System.out.println("=================================");
                    System.out.println("Digite o código do robo a ser excluído: ");
                    int roboCodigo1 = s.nextInt();
                    Robo roboExcluir = null;
                    for(Robo r: robos){
                        if(r.codigo == roboCodigo1){
                            roboExcluir = r;
                        }
                    }
                    if(roboExcluir == null){
                        System.out.println("Robo não encontrado");
                    } else {
                        robos.remove(roboExcluir);
                        System.out.println("Robo excluído com sucesso!");
                    }
            }
        } while (opt != 0);
        s.close();
    }
 
    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
 
            } catch (InputMismatchException e) {
                s.next();
                System.out.println();
                System.out.println("=================================");
                System.out.println("         OPERAÇÃO INVÁLIDA");
                System.out.println("=================================");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);
        return opt;
    }
}