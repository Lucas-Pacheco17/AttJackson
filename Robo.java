 
public abstract class Robo {
    //Encapsulamento
    private  int codigo;
    private  String nome;
    private  int ataque;
    private  int defesa;
    private  int energia;
    private  int win;
    private  int lose;
    private  int ponto;
   
 
    public Robo(int codigo, String nome, int ataque, int defesa, int energia, int win, int lose, int ponto){
       
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = energia;
        this.win = win;
        this.lose = lose;
        this.ponto = ponto;
    }
   
public void Consultar() {
 
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Código: " + (codigo));
        System.out.println("Nome: " + nome);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        System.out.println("Energia " + energia);
        System.out.println("Ponto " + ponto);
       
    }
//Métodos para utilizar as variaveis privadas
public int codigo(){
    return codigo;
}
 
public String nome(){
    return nome;
}
public int ataque(){
    return ataque;
}
 
public int defesa(){
    return defesa;
}
public int energia(){
    return energia;
}
 
public int win(){
    return win;
}
 
public int lose(){
    return lose;
}
 
public int ponto(){
    return ponto;
}
 
//Set para as variaveis em modificação
public void setEnergia(int energia) {
    this.energia = energia;
}
 
public void setWin(int win) {
    this.win = win;
}
 
public void setLose(int lose) {
    this.lose = lose;
}
 
public void setPonto(int ponto) {
    this.ponto = ponto;
}
 
}
 