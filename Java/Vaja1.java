public class Vaja1 {
	public static void main(String[] args){
		Cas zdaj = new Cas(9, 5);
		System.out.println(((zdaj.getUra() > 9) ? (zdaj.getUra()):("0"+zdaj.getUra())) + ":" + ((zdaj.getMin() > 9) ? (zdaj.getMin()):("0"+zdaj.getMin())));
		zdaj.izpis();
		System.out.println(zdaj);
	}
}

class Cas{
	private int ura;
	private int min;
	
	public Cas(){}
	public Cas(int a, int b){
		ura = a;
		min = b;
	}
	
	public void setUra(int a){
		this.ura = a;
	}
	public void setMin(int b){
		this.min = b;
	}
	public int getUra(){
		return this.ura;
	}
	public int getMin(){
		return this.min;
	}
	
	public void izpis(){
		System.out.println(((this.ura > 9) ? (this.ura):("0"+this.ura)) + ":" + ((this.min > 9) ? (this.min):("0"+this.min)));
	}
	
	public String toString(){
		return (((this.ura > 9) ? (this.ura):("0"+this.ura)) + ":" + ((this.min > 9) ? (this.min):("0"+this.min)));
	}
}
