public class Main{
    public static void main(String[] args){
        Cas zdaj = new Cas(10);
        zdaj.setMin(20);
        zdaj.setCas(10, 30);
        Cas potem = new Cas(10, 55);
        potem.setCas(11, 00);
        
        System.out.println(zdaj.getUra());
        System.out.println(zdaj.getMin());
        System.out.println(potem.getUra());
        System.out.println(potem.getCas()[0] + ":" + (potem.getCas()[1] < 10 ? "0" + potem.getCas()[1] : potem.getCas()[1]));
    }
}

class Cas{
    private int ura;
    private int min;
    
    public Cas(int ura){
        this.ura = ura;
        this.min = 0;
    }
    public Cas(int ura, int min){
        this.ura = ura;
        this.min = min;
    }
    
    public void setUra(int ura){
        this.ura = ura;
    }
    public void setMin(int min){
        this.min = min;
    }
    public void setCas(int ura, int min){
        this.ura = ura;
        this.min = min;
    }
    public int getUra(){
        return this.ura;
    }
    public int getMin(){
        return this.min;
    }
    public int[] getCas(){
        
        return new int[] {this.ura, this.min};
    }
}
