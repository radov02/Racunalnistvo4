package car4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vaja2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Vnesi velikost evidence: ");
		System.out.print("> ");
		Evidenca e = new Evidenca(Integer.parseInt(br.readLine()));
		System.out.println();
		
		boolean help = true;
		boolean exit = false;
		
		while(!exit){
			if(help){
				System.out.println("UKAZI:\n	help\n	exit\n	dodaj\n	izbrisi_IDdijaka | izbrisi_imeDijaka | izbrisi_imeDijaka_priimekDijaka\n	izpisi\n	prikaziDijaka_IDdijaka | prikaziDijaka_imeDijaka | prikaziDijaka_imeDijaka_priimekDijaka]");
				help = false;
			}
			System.out.print("> ");
			String[] ukaz = br.readLine().split(" ");
			switch(ukaz[0]){
				case "dodaj": e.vnesiVEvidenco(); help = true; break;
				case "izbrisi": 
					if(isNumeric(ukaz[1])){
						e.deleteID(Integer.parseInt(ukaz[1]));
					}
					else{
						try{
							e.deleteName(ukaz[1], ukaz[2]);
						} catch(Exception ex){
							e.deleteName(ukaz[1]);
						}
					} help = true; break;
				case "izpisi": e.izpis(); help = true; break;
				case "prikaziDijaka":
					if(isNumeric(ukaz[1])){
						e.getDijakByID(Integer.parseInt(ukaz[1]));
					}
					else{
						try{
							System.out.println(e.getDijakByName(ukaz[1], ukaz[2]));
						} catch (Exception ex){
							System.out.println(e.getDijakByName(ukaz[1]));
						}
					} help = true; break;
				case "help": help = true; break;
				case "exit": exit = true; break;
				default: System.out.println("Napacen ukaz"); break;
			}
			System.out.println();
		}
		
		//String[] imena = {"Janez", "Jan", "Robert", "Goran"};
		//String[] priimki = {"Novak", "Kovac", "Kotar"};
		
		
		//Evidenca e = new Evidenca(10);
		
		//for(int i = 0; i < 5; i++){
		//	e.setDijak(new Dijak(randomIme(imena), randomPriimek(priimki), randomVpis()));
		//}
		//e.izpis();
		
		//e.deleteID(4);
		//e.setDijak(new Dijak("Test", "Test", randomVpis()));
		
		//e.vnesiVEvidenco();
		//e.izpis();
	}
	
	public static boolean isNumeric(String n){
		try{
			Integer.parseInt(n);
			return true;
		} catch (Exception ex){
			return false;
		}
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
	public Dijak deleteName(String ime){
		for(int i = 0; i < index; i++){
			if(a[i].getName().equals(ime)){
				for(int j = i; j < index - 1; j++){
					a[j] = a[j + 1];
				}
				index--;
				return a[i];
			}
		}
		return null;
	}
	public Dijak deleteName(String ime, String priimek){
		for(int i = 0; i < index; i++){
			if(a[i].getName().equals(ime) && a[i].getSurname().equals(priimek)){
				for(int j = i; j < index - 1; j++){
					a[j] = a[j + 1];
				}
				index--;
				return a[i];
			}
		}
		return null;
	}
	public Dijak getDijakByID(int id){
		for(int i = 0; i < index; i++){
			if(a[i].getID() == id){
				return a[i];
			}
		}
		return null;
	}
	public Dijak getDijakByName(String name){
		for(int i = 0; i < index; i++){
			if(a[i].getName() == name){
				return a[i];
			}
		}
		return null;
	}
	public Dijak getDijakByName(String name, String surname){
		for(int i = 0; i < index; i++){
			if(a[i].getName() == name && a[i].getSurname() == surname){
				return a[i];
			}
		}
		return null;
	}
	public void izpis(){
		System.out.println("--------------------------");
		for(int i = 0; i < index; i++){
			System.out.println("|" + a[i].getID() + " " + a[i].getName() + " " + a[i].getSurname() + " " + a[i].isEnrolled());
		}
		System.out.println("--------------------------");
	}
	public void vnesiVEvidenco() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Vnesi ime: ");
		String ime = br.readLine();
		System.out.print("Vnesi priimek: ");
		String priimek = br.readLine();
		System.out.print("Je vpisan [da|ne]: ");
		boolean enrolled = ((br.readLine().equals("da")) ? (true):(false));
		
		Dijak d = new Dijak(ime, priimek, enrolled);
		setDijak(d);
		
		System.out.println("Vneseno: " + d + ", se " + (a.length - index) + " prostih mest v evidenci");
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
	public String toString(){
		return this.id + " " + this.name + " " + this.surname + " " + this.enrolled;
	}
}
