public class MaturaInventar{
    public static void main(String[] args){
        Inventar i1 = new Inventar(1, "lesene deske", 10.50);
        i1.izpis();

        DelovniInventar di1 = new DelovniInventar(2, "kovinska plošča", 13.49, 10, 2);
        di1.izpis();
    }
}

class Inventar{
    int invSt;
    String ime;
    double nabCena;

    public Inventar(int i, String ime, double n){
        this.invSt = i;
        this.ime = ime;
        this.nabCena = n;
    }
    public Inventar(){
        this.invSt = 0;
        this.ime = "";
        this.nabCena = 0.0;
    }
    public double vrniVrednost(){
        return this.nabCena;
    }
    public void izpis(){
        System.out.println("Inventarna številka = " + this.invSt);
        System.out.println("Ime = " + this.ime);
        System.out.format("Vrednost = %.2f\n", this.vrniVrednost());
    }
}

class DelovniInventar extends Inventar{
    int starost, odstotekAm;

    public DelovniInventar(int i, String ime, double n, int st, int am){
        super(i, ime, n);
        this.starost = st;
        this.odstotekAm = am;
    }
    public DelovniInventar(){
        super();
        this.starost = 0;
        this.odstotekAm = 0;
    }
    public double vrniVrednost(){
        double vrednost = super.vrniVrednost();
        if(vrednost > 1000) vrednost -= 200;
        for(int i = 0; i < this.starost; i++)
            vrednost -= vrednost * (this.odstotekAm / 100.0);
        if(vrednost < 1.0) vrednost = 0.0;
        return vrednost;
    }
    public void izpis(){
        super.izpis();
    }
}
