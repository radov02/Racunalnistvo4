public class Main {
	public static void main(String[] args){
		Tocka ta = new Tocka(2, 7);
		System.out.println(ta);
		Tocka.nova(ta, new Tocka(3, 0));
		System.out.println(ta);
	}
}

class Tocka{
	int x, y;
	
	Tocka(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return ("(" + this.x + ", " + this.y + ")");
	}
	
	public static void nova(Tocka t, Tocka premik){
		t.x += premik.x;
		t.y += premik.y;
	}
}
