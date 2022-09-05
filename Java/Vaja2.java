public class Vaja2 {

	public static void main(String[] args) {
		
		String[] imena = {"Janez", "Jan", "Robert", "Goran"};
		String[] priimki = {"Novak", "Kovac", "Kotar"};
		
		
		Evidenca e = new Evidenca(10);
		
		for(int i = 0; i < 5; i++){
			e.setDijak(new Dijak(randomIme(imena), randomPriimek(priimki), randomVpis()));
		}
		//e.izpis();
		
		e.deleteID(4);
		e.setDijak(new Dijak("b", "v", randomVpis()));
		e.izpis();
	}
	
	public static boolean randomVpis(){
		int r = (int)(Math.random()*2);
		if(r == 1) return true;
		else return false;
	}
	public static String randomIme(String[] imena){
		int r = (int)(Math.random()*imena.length);
		return imena[r];
	}
	public static String randomPriimek(String[] priimki){
		int r = (int)(Math.random()*priimki.length);
		return priimki[r];
	}
}

class Evidenca{
	private Dijak[] a;
	private int index;
	private static int id;
	
	public Evidenca(int velikost){
		a = new Dijak[velikost];
		id = 1;
	}
	
	public void setDijak(Dijak d){
		a[index++] = d;
		d.setID(id++);
	}
	public Dijak deleteID(int id){
		for(int i = 0; i < a.length; i++){
			if(a[i].getID() == id){
				for(int j = i; j < a.length -1; j++){
					a[j] = a[j+1];
				}
				index--;
				return a[i];
			}
		}
		return null;
	}
	public void izpis(){
		for(int i = 0; i < index; i++){
			System.out.println(a[i].getID() + " " + a[i].getName() + " " + a[i].getSurname() + " " + a[i].isEnrolled());
		}
	}
}

class Dijak{
	private int id;
	private String name;
	private String surname;
	private boolean enrolled;
	
	public Dijak(){}
	public Dijak(String n, String s, boolean si){
		this.name = n;
		this.surname = s;
		this.enrolled = si;
	}
	
	public void setName(String n){
		this.name = n;
	}
	public String getName(){
		return this.name;
	}
	public void setSurname(String n){
		this.name = n;
	}
	public String getSurname(){
		return this.surname;
	}
	public boolean isEnrolled(){
		return enrolled;
	}
	public int getID(){
		return this.id;
	}
	public void setID(int a){
		this.id = a;
	}
}
