import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Naloga{
    public static void main(String[] args) throws IOException{

        File dat = new File(".\\naloga.txt");

        BufferedReader br = new BufferedReader(new FileReader(dat));
        
        String[] vrstica = br.readLine().split(" ");
        int stStolpcev = vrstica.length;
        int[] vsote = new int[stStolpcev];
        String vr;

        while(true){
            for(int i = 0; i < stStolpcev; i++){
                vsote[i] += Integer.parseInt(vrstica[i]);
            }
            if((vr = br.readLine()) != null)
                vrstica = vr.split(" ");
            else
                break;
        }
        br.close();

        // izpis:
        for(int i = 0; i < vsote.length; i++)
            System.out.println("Vsota " + i + ". stolpca: " + vsote[i]);

        Zival pes = new Pes();
        System.out.println(pes.oglasanje());
        pes.nic();
        // Zival macek = new Zival();
        //Zival ovca = new Ovca();
        //ovca.ovca();

        System.out.println(Fibo(6));
        System.out.println(Fakt(4));

        BufferedWriter bw = new BufferedWriter(new FileWriter(dat));

        bw.write(Fibo(8) + "--");
        bw.newLine();
        bw.write(Fakt(8) + "--");
        bw.close();

        try{
            int c = 10/0;
        } catch(ArrayIndexOutOfBoundsException | ArithmeticException e){
            System.out.println(e.toString());
        }

        BufferedReader bur = new BufferedReader(new FileReader(dat));
        char c;
        while(bur.ready()){
            System.out.println((char)bur.read());
        }
        bur.close();

        throw new ArithmeticException("exc");
    }
    

    public static int Fibo(int n){
        if(n == 1 || n == 2)
            return 1;
        n = Fibo(n-2) + Fibo(n-1);
        return n;
    }

    public static int Fakt(int n){
        if(n == 0 || n == 1)
            return 1;
        n = n * Fakt(n-1);
        return n;
    }
}

abstract class Zival{
    int noge;
    public abstract String oglasanje();
    public void nic(){
        int a = 1 + 1;
    }
}
class Pes extends Zival{
    public String oglasanje(){
        return "Hov";
    }
}

abstract class Ovca extends Zival{
    public String ovca(){
        return "ovca";
    }
}
