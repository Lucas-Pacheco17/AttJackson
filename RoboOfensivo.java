public class RoboOfensivo extends Robo {
 
    public RoboOfensivo(int codigo, String nome, int ataque, int defesa, int energia, int win, int lose, int ponto) {
 
        super(codigo, nome, ataque, defesa, energia, win, lose, ponto);
 
    }
//Alterar método da superclasse polimorfismo
@Override
    public int ataque() {
        return super.ataque() +5;
    }
}
