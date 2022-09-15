import java.util.Random;

public class Liki {
    public static void main(String[] args){

        Random r = new Random();

        Lik[] tabela = new Lik[5];

        for(int i = 0; i < tabela.length; i++){
            int rand = r.nextInt(3);
            switch(rand){
                case 0: tabela[i] = new Krog(r.nextInt(10), r.nextInt(10), r.nextInt(5)); break;
                case 1: tabela[i] = new Kvadrat(r.nextInt(10), r.nextInt(10), r.nextInt(5)); break;
                case 2: tabela[i] = new Trikotnik(r.nextInt(10), r.nextInt(10), r.nextInt(5), r.nextInt(5), r.nextInt(5)); break;
                default: break;
            }
        }
        
        for(Lik l : tabela){
            l.narisi();
        }
    }

}

abstract class Lik{
    int x, y;

    public abstract void narisi();
    public void premakni(int dx, int dy){
        x += dx;
        y += dy;
    }
}

class Kvadrat extends Lik{
    int a;
    public Kvadrat(int x, int y, int a){
        this.x = x;
        this.y = y;
        this.a = a;
    }
    public void narisi(){
        System.out.println("Izris kvadrata");
    }
}
class Krog extends Lik{
    int r;
    public Krog(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public void narisi(){
        System.out.println("Izris kroga");
    }
}
class Trikotnik extends Lik{
    int a, b, c;
    public Trikotnik(int x, int y, int a, int b, int c){
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void narisi(){
        System.out.println("Izris trikotnika");
    }
}
