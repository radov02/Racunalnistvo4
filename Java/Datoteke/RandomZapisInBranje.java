import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RandomZapisInBranje {
    public static void main(String[] args) throws IOException{
        File file = new File(".\\Random.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(int i = 0; i < 100; i++){
            bw.write(String.valueOf(Math.random()*201 - 100) + "\n");
        }
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(file));
        double vsotaNeg = 0, steviloPoz = 0, max = -100, min = 100;
        String line;
        while(br.ready()){
            line = br.readLine();
            if(Double.parseDouble(br.readLine()) < 0) vsotaNeg += Double.parseDouble(line);
            if(Double.parseDouble(br.readLine()) > 0) steviloPoz++;
            if(Double.parseDouble(br.readLine()) > max) max = Double.parseDouble(line);
            if(Double.parseDouble(br.readLine()) < min) min = Double.parseDouble(line);
        }
        br.close();
        System.out.println("Vsota negativnih stevil: " + vsotaNeg);
        System.out.println("Stevilo pozitivnih stevil: " + steviloPoz);
        System.out.println("Najvecje stevilo: " + max);
        System.out.println("Najmanjse stevilo: " + min);
    }
}
