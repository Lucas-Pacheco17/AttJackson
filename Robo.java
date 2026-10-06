public class Robo {
    public int codigo;
    public String nome;
    public int ataque;
    public int defesa;
    public int energia;
    public int vitoria;
    public int derrota;
    public int pontos;
    public int roboCodigo;
   
 
    Robo(int codigo, String nome, int ataque, int defesa, int energia, int vitoria, int derrota, int pontos){
       
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = energia;
        this.vitoria = vitoria;
        this.derrota = derrota;
        this.pontos = pontos;
    }
   
public void Consultar() {
 
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        System.out.println("Energia " + energia);
        System.out.println("Vitórias: " + vitoria);
        System.out.println("Derrotas: " + derrota);
        System.out.println("Pontos: " + pontos);
    }
}