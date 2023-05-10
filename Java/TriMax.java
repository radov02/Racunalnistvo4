import java.util.Arrays;

public class TriMax {
	public static void main(String[] args){

		testiranje(100000);
	}

	public static int[] a(int[] tab) {
    int max[] = new int[3];
    int min = tab[0];
    for (int i = 0; i < tab.length; i++) {
      if (tab[i] < min) {
        min = tab[i];
      }
    }
    max[0] = max[1] = max[2] = min;
    for (int i = 0; i < tab.length; i++) {
      if (tab[i] > tab[max[0]]) {
        max[2] = max[1];
        max[1] = max[0];
        max[0] = i;
      } else if (tab[i] > tab[max[1]]) {
        max[2] = max[1];
        max[1] = i;
      } else if (tab[i] > tab[max[2]]) {
        max[2] = i;
      }
    }
    return max;
  }

	public static void testiranje(int primerov) {

		if(primerov > 100){
			for(int j = 0; j < primerov; j++){
				int[] tab = new int[10];
				
				for(int i = 0; i < 10; i++){
					tab[i] = (int)(Math.random() * 30 + 1);
				}
	
				int[] tn = triNajvecje(tab);
				int[] tn2 = triNajvecjeNaDolgo(tab);
				if(!Arrays.equals(tn, tn2)){
					System.out.println("Napaka:");
					System.out.println(Arrays.toString(tn) + ", " + Arrays.toString(tn2));
					break;
				}
			}
		}
		else{
			for(int j = 0; j < primerov; j++){
				int[] tab = new int[10];
				System.out.print("[");
				for(int i = 0; i < 10; i++){
					tab[i] = (int)(Math.random() * 30 + 1);
					if(i < 9) System.out.print(tab[i] + ", ");
					else System.out.print(tab[i]);
				}
				System.out.println("] --> ");
	
				int[] tn = triNajvecje(tab);
				int[] tn2 = triNajvecjeNaDolgo(tab);
				int[] tn3 = a(tab);
				if(Arrays.equals(tn, tn2) && Arrays.equals(tn, tn3)){
					System.out.println("Enaki rezultati: ");
				}
				else{
					System.out.println("Napaka: ");
				}
				System.out.println(Arrays.toString(tn));
				System.out.println(Arrays.toString(tn2) + "\n");
			}
		}
	}

	public static int[] triNajvecjeNaDolgo(int[] tab){

		int[] indeksi = {-1, -1, -1};

		for(int j = 0; j < 3; j++){
			int max = 0;
			for(int i = 0; i < tab.length; i++){
				if(i != indeksi[0] && i != indeksi[1] && tab[i] > tab[max]){
					max = i;
				}
			}
			indeksi[j] = max;
		}
		return indeksi;
	}

	public static int[] triNajvecje(int[] tab){

		int m1 = 0, m2 = 0, m3 = 0;

		for(int i = 0; i < tab.length; i++){
			if(tab[i] > tab[m1]){
				m3 = m2;
				m2 = m1;
				m1 = i;
			}
			else if(tab[i] > tab[m2]){
				m3 = m2;
				m2 = i;
			}
			else if(tab[i] > tab[m3]){
				m3 = i;
			}
			//System.out.println(tab[m1] + ", " +  tab[m2] + ", " + tab[m3]);
		}
		return new int[] {m1, m2, m3};
	}
}