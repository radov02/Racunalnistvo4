public class Main {
	public static void main(String[] args){
		Tocka ta = new Tocka(2, 7);
		Tocka.nova(ta, new Tocka(3, 0));
	}
}

class Tocka{
	int x, y;
	
	Tocka(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static void nova(Tocka t, Tocka premik){
		t.x += premik.x;
		t.y += premik.y;
		System.out.println("(" + t.x + ", " + t.y + ")");
	}
}
