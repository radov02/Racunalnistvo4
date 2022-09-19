public class PreoblozitevPrekrivanje{

    public static void main(String[] args){
        
        Enemy e = new Enemy();
        Enemy f = new Enemy(5, 7);

        e.move(3, 6);
        f.move(3.0, 5.2);

        Alien vesoljc = new Alien();
        vesoljc.move(3, 4);     // klic prekrite metode (polimorfizem)
    }
}

class Enemy{
    int x, y;

    Enemy(){    // privzeti konstruktor (default)
        this.x = 0;
        this.y = 0;
    }
    Enemy(int x, int y){    // preoblozen konstruktor (overload)
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){ // metoda
        this.x = x;
        this.y = y;
    }
    public void move(double x, double y){   // preoblozena metoda
        this.x = (int)x;
        this.y = (int)y;
    }
}

class Alien extends Enemy{
    public void move(int x, int y){     // prekrita metoda (override)
        this.x = 1 + x;
        this.y = 1 + y;
    }
    public void move(int x){     // prekrita metoda (override)
        super(x, x);
        this.x = 1 + x;
        this.y = 1 + y;
    }
}
