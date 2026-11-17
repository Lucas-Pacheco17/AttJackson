public class RoboDefensivo extends Robo {
    public RoboDefensivo(int codigo, String nome, int ataque, int defesa, int energia, int win, int lose, int ponto) {
 
        super(codigo, nome, ataque, defesa, energia, win, lose, ponto);
 
    }
 
//Alterar método da superclasse polimorfismo
    @Override
    public int defesa() {
        int defesa = super.defesa();
        defesa =+ 3;
        if (defesa < 2) {
            defesa = 2;
        }
        return defesa;
    }
}