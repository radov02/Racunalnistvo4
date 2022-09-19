import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWrite {
    public static void main(String[] args) throws IOException{

        String ime = args[0];
        File datoteka = new File(ime);
        datoteka.createNewFile();
        System.out.println(datoteka.exists());
        System.out.println(datoteka.mkdir());
        System.out.println(datoteka.mkdirs());
        System.out.println(datoteka.length());
        System.out.println(datoteka.renameTo(new File("C:\\NewDir\\NewFile.txt")));

        System.out.println();
        System.out.println();

        // ----- WRITE -----
        BufferedWriter bw = new BufferedWriter(new FileWriter(datoteka));
        bw.write((int)'c');
        bw.write("Zapis z BufferedWriterjem");
        bw.newLine();
        bw.flush();
        bw.close();

        PrintWriter pw = new PrintWriter(new FileWriter(datoteka));
        pw.println("Zapis s PrintWriterjem");
        pw.print("Zapis s PrintWriterjem\n");
        pw.write(new char[] {'Z', 'a', 'p', 'i', 's'});
        pw.flush();
        pw.close();
        // ----- WRITE -----


        // ----- READ -----
        BufferedReader br = new BufferedReader(new FileReader(datoteka));
        char[] ch = new char[50];
        while(br.ready()){
            String line = br.readLine();
            char c = (char)br.read();
            br.read(ch);
            br.skip(10);    // skip n characters (skip a line with if and continue)
        }
        br.close();

        FileReader fr = new FileReader(datoteka);
        while(fr.ready()){
            char c = (char)fr.read();
            fr.read(ch);
            fr.skip(10);
        }
        fr.close();
        // ----- READ -----


        // ----- COMPARE -----
        File datoteka1 = new File("datotekaVaja.txt");
        File datoteka2 = new File("datoteka2Vaja.txt");

        BufferedReader br1 = new BufferedReader(new FileReader(datoteka1));
        BufferedReader br2 = new BufferedReader(new FileReader(datoteka2));
        int lines1 = 0, lines2 = 0;
        boolean enaki = true;
        while(br1.ready() && enaki){
            String a = br1.readLine();
            if(br2.ready()){
                String b = br2.readLine();
                enaki = a.equals(b);
                lines2++;
            }
            lines1++;
            if(lines1 != lines2){
                enaki = false;
            }
        }
        br2.close();
        System.out.println((enaki) ? ("Datoteki sta enaki"):("Datoteki nista enaki"));
        // ----- COMPARE -----

        // ----- COPY -----
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(datoteka2));
        while(br1.ready()){
            bw2.write(br1.readLine());
            bw2.newLine();
        }
        br1.close();
        bw2.close();
        // ----- COPY -----
    }
}
