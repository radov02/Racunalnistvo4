import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Pregled{
	public static void main(String[] args) throws IOException{
		//tabeliranje();
		int[] tabela = {2, 5, 6, 1, 2, 9, 2, 5, 1, 6, 7, 3, 8, 2, 1};
		//bubbleSort(tabela);
		int[][] t2d = new int[2][2];
		String niz = "beseda1";
		String niz1 = new String("Besedilo 1234");
		char a = niz.charAt(5);
		String n = "1012";
		int nu = Integer.parseInt(n);
		int num = Integer.valueOf(n);
		int ab = nu + num;
		//System.out.println(ab);
		String numb = String.valueOf(nu);
		String numbe = Integer.toString(num);
		System.out.println(Character.isLetter('.'));
		char[] ca = {'a', 'b', 'c'};
		String fromCa = new String(ca);
		byte[] zl = {43, 54, 65, 76};
		String fromZl = new String(zl);
		int dolzinaNiza = fromZl.length();
		//vrstice(fromCa);
		String n123 = fromCa.concat(fromZl);
		String besedilo = "Danes je lep dan, ampak ne tako kot je bil včeraj. Jutri pa upamo, da ne bo deževalo!";
		//preslInLoc(besedilo);

		String b1 = "beseda";
		String b2 = "beseda";
		StringBuffer sb1 = new StringBuffer("beseda");
		StringBuffer sb2 = new StringBuffer(b1);
		if(b1 == b2){	// primerja hash code ce imamo referencne tipe (enaki pri enakih Stringih) in vrednosti ce imamo primitivne tipe
			//System.out.println("beseda1.");
		}
		if(b1.equals(b2)){	// primerja vrednosti, enakosti vsebin
			//System.out.println("beseda2.");
		}
		if(b1.compareTo(b2) == 0){
			//System.out.println("beseda3.");
		}
		System.out.println("-->" + b1.equals(b2));
		int p = 23232323;
		long q = 23232323l;
		System.out.println(p == q);

		String a1 = "bEsEdA";
		String a2 = "beseda";
		String a3 = "besed";	// ce je krajse vrne razliko dolzin
		String a4 = "bese";
		String a5 = "besedA";	// ce je enako dolgo in so crke razlicne vrne razliko crk
		System.out.println(a1.compareToIgnoreCase(a2));
		System.out.println(a2.compareTo(a3));
		System.out.println(a2.compareTo(a4));
		System.out.println(a2.compareTo(a5));

		String odlomek = "Seveda nismo vsega imeli ampak smo znali imeti to čemur se pravi veselje in to je pomenilo vse";
		String[] bo = odlomek.split(" ");
		for(int i = 0; i < bo.length; i++){
			if(bo[i].startsWith("se")){
				System.out.println(bo[i] + " se začne s se");
			}
			if(bo[i].endsWith("li")){
				System.out.println(bo[i] + " se konča z li");
			}
			for(int j = 0; j < bo[i].length(); j++){
				if(bo[i].startsWith("se", j)){
					System.out.println(bo[i] + " vsebuje se na indeksu: " + bo[i].indexOf("se"));	// indexOf(int); - kje je znak
				}
			}
		}
		System.out.println(odlomek.substring(12, 18));	// [12, 18)
		String[] arrayS = new String[6];
		arrayS = odlomek.split(" ", 6);	// naredi šest nizov, kar ostane ne upošteva regex ampak da vse skupaj v zadnji niz
		System.out.println(Arrays.toString(arrayS));

		//String je nespremenljiv:
		String nek = "  TUŠ";
		nek = nek.concat(" 6  ");
		nek = nek.replace('U', 'E');
		nek = nek.toLowerCase();
		nek = nek.trim();
		System.out.println(nek);
		// lahko pa uporabimo StringBuffer, ki je spremenljiv
		StringBuffer sb = new StringBuffer("Sem dijak Šolskega centra Novo mesto.");
		sb.deleteCharAt(sb.length() - 1);
		sb.append(" in SEŠTG.");
		System.out.println(sb);
		sb.replace(1,3,"va");
		sb.insert(9, 'a');
		sb.setCharAt(sb.length() - 1, '?');
		System.out.println(sb);
		sb.delete(26, sb.length() - 1);
		sb.insert(sb.length() - 1, " " + sb.indexOf("cen"));
		System.out.println(sb);

		System.out.println(max(1.1, 2.3));	// ko imamo dve preoblozeni metodi, katrih tipa sta podobna in ne moremo razlikovati med njima, vzame prvo metodo po vrstnem redu

		// RAZREDI
		Avto av1 = new Avto();
		System.out.println(av1);	// ker imamo metodo String toString() lahko tako izpisujemo
		Avto av2 = new Avto("zelena");
		av2.barva = "modrozelena";
		System.out.println(av2);
		Avto av3 = new Avto(100000, "črna");
		av3.setLastnik("Andrej Andrejčič");
		av3.prizgiUgasni();
		System.out.println(av3);
		av2.setLastnik("Bojan", "Berk");

		// razredna vs. statična metoda:
		Pregled.max(1.2, 2.3);	// del razreda, zato klicemo: Razred.metoda()
		av1.prizgiUgasni();	// za objekt, zato klicemo: objekt.metoda()

		Audi audi1 = new Audi();
		Audi audi2 = new Audi("zavarovanje1");
		Audi audi3 = new Audi(30321);
		System.out.println(audi1);
		System.out.println(audi2);
		System.out.println(audi3);
		
		Vozilo audi4 = new Audi();	// z implementacijo abstraktnega razreda (drug nacin kot prej, enako)
		System.out.println(audi4);

		System.out.println(Fibonacci(2));
		System.out.println(Fibonacci(3));
		System.out.println(Fibonacci(4));
		System.out.println(Fibonacci(5));

		File datot = new File("C:\\VisualStudioCode\\vaja.txt");
		BufferedReader br = new BufferedReader(new FileReader(datot));
		String vrstica = "";
		while((vrstica = br.readLine()) != null){
			System.out.println(vrstica);
		}
		br.close();
		try{
			Scanner sc = new Scanner(System.in);
			BufferedWriter bw = new BufferedWriter(new FileWriter(datot));
			int i = 0;
			while(i < 3){
				System.out.println("Vnesi (" + i+1 + "/3)");
				String vnos = sc.nextLine();
				if(vnos == ""){
					throw new Exception("neveljaven vnos");
				}
				bw.write(vnos);
				System.out.println();
				i++;
			}
			sc.close();
			bw.close();
		} catch(Exception e){
			System.out.println(e);
		} finally{
			System.out.println("Ta del se izvede vedno, razen če pride do nenavadne prekinitve programa!");
		}
		
	}

	public static String max(double a, double b){
		return "string: " + a + " " + b;
	}
	public static float max(float a, float b){
		return Math.max(a, b);
	}

	public static void tabeliranje(){
		System.out.println("x , y");
		for(double x = -2*Math.PI; x <= 2*Math.PI; x += Math.PI/3){
			System.out.format("%.2f, %.2f\n", x, 2*Math.sin(3*x+Math.PI/3));
		}
	}

	public static void bubbleSort(int[] tab) {
		boolean menjaj = true;
		while(menjaj){
			menjaj = false;
			for(int j = 0; j < tab.length-1; j++){
				if(tab[j] > tab[j + 1]){
					int tmp = tab[j];
					tab[j] = tab[j+1];
					tab[j+1] = tmp;
					menjaj = true;
				}
			}
		}
		System.out.println(Arrays.toString(tab));
	}

	public static void vrstice (String b){
		int presl = 0;
		for(int i = 0; i < b.length(); i++){
			for(int j = 0; j < presl; j++){
				System.out.print(" ");
			}
			System.out.println(b.charAt(i));
			presl++;
		}
	}

	public static void preslInLoc(String besedilo){
		StringBuffer sb = new StringBuffer(besedilo);
		char[] locila = {'.', ',', '!', '?'};
		for(int i = 0; i < sb.length(); i++){
			for(int j = 0; j < locila.length; j++){
				if((locila[j] == sb.charAt(i)) || Character.isWhitespace(sb.charAt(i))){
					sb.deleteCharAt(i);
					i--;
					break;
				}
			}
		}
		System.out.println(sb);
	}

	public static int Fibonacci(int n){
		if(n == 1 || n == 2){
			return 1;
		}
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
}

abstract class Vozilo{	// podrazredi abstraktnega so abstraktni, ce ne implementirajo vseh abstraktnih metod
	int prevozenih;
	boolean prizgan;

	public void prizgiUgasni(){		// ce je povsod enaka jo zapisemo kot neabstraktno metodo ze tukaj
		this.prizgan = !this.prizgan;
	}
	public abstract String toString();	// nacrt za metode, ki so lahko razlicne
}

class Avto extends Vozilo{
	public static int stVozil;	// vsi izvodi razreda skupno spremenljivko, lahko jo klicemo kot objekt.stVozil ali Avto.stVozil (ni direktno povezana z objektom)
	// staticne spremenljivke so lahko samo v razredih, v metodah ne, ker so lokalne in nima smisla
	protected int prevozenih;
	public String barva;
	private String lastnik;
	private boolean prizgan;

	public Avto(){
		stVozil++;
		this.prevozenih = 0;
		this.lastnik = "Avtohisa A";
		this.barva = "Neznano";
		this.prizgan = false;
	}
	public Avto(int p){
		this();
		this.prevozenih = p;
	}
	public Avto(String barva){
		this();
		this.barva = barva;
	}
	public Avto(int p, String barva){
		this(p);
		this.barva = barva;
	}

	/*public void prizgiUgasni(){
		this.prizgan = !this.prizgan;
	}*/
	public void setLastnik(String l){
		this.lastnik = l;
	}
	public void setLastnik(String ime, String priimek){
		this.lastnik = ime + " " + priimek;
	}
	public String getLastnik(){
		return this.lastnik;
	}
	public String toString(){
		return (stVozil + ", " + this.prevozenih + ", " + 
		this.lastnik + ", " + 
		this.barva + ", " + 
		(this.prizgan ? "prizgan":"ugasnjen"));
	}
}

class Audi extends Avto{
	private int serijskaSt;
	private String audiZavarovanje;

	public Audi(){
		super();
		serijskaSt++;
		audiZavarovanje = "osnovno Audi";
	}
	public Audi(int s){
		super();
		this.serijskaSt = s;
	}
	public Audi(String z){
		super();
		this.audiZavarovanje = z;
	}

	public void setAudiZavarovanje(String z){
		this.audiZavarovanje = z;
	}
	public void setSerijskaSt(int s){
		this.serijskaSt = s;
	}

	public String toString(){
		super.toString();
		return (this.serijskaSt + " " + this.audiZavarovanje);
	}
}
