import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ZagastaFunkcija {
	public static void main(String[] args) throws IOException{

		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\VisualStudioCode\\javaGarbage\\zagasta.txt"));

		final double A = 1;
		double min = -2 * Math.PI;
		double max = 2 *  Math.PI;
		double korak = Math.PI / 10;
		int komponent = 20;

		double tab[][] = tabeliraj(A, min, max, korak, komponent);

		for(int i = 0; i < tab[0].length; i++){
			bw.write(tab[0][i] + ", " + tab[1][i] + "\n");
		}

		bw.close();
	}

	public static double[][] tabeliraj(double amplituda, double minvred, double maxvred, double korak, double stKomponentVtocki){

		int stElementov = (int)((maxvred - minvred) / korak) + 1;
		double tabela[][] = new double[2][stElementov];
		int stevec = 0;

		for(double t = minvred; t <= maxvred; t += korak){
			double vsota = 0;
			for(int i = 1; i < stKomponentVtocki; i++){
				vsota += (Math.sin(2 * Math.PI * i * t) / i); // * Math.pow(-1, i)
			}
			double konst = 2 * amplituda / Math.PI;

			tabela[0][stevec] = t;
			tabela[1][stevec++] = konst * vsota;
		}
		//System.out.println(Arrays.toString(tabela[0]));
		//System.out.println(Arrays.toString(tabela[1]));

		return tabela;
	}
}
