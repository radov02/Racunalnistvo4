import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WriteReadFile {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // File:
        System.out.println("Enter file name: ");
        String filename = br.readLine();
        File file = new File(".\\" + filename);
        file.createNewFile();

        // Write:
        System.out.println("Write lines to the file (type 'close' to exit):");
        String input;
        while(true){
            input = br.readLine();
            if(input.equals("close")){
                break;
            }
            writeLine(file, input);
        }
        br.close();

        // Read:
        ArrayList<String> arr = read(file);
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

    public static void writeLine(File file, String line) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // true - dodaj na koncu datoteke, false = overwrite
        bw.write(line);
        bw.newLine();
        // ali bw.write(line + "\r\n");
        bw.close();
    }
    public static ArrayList<String> read(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> a = new ArrayList<String>();
        while(br.ready()){
            a.add(br.readLine());
        }
        br.close();
        return a;
    }
}
