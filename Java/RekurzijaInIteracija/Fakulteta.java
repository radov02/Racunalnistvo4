public class Fakulteta {
    public static void main(String[] args){
        System.out.println(Fakt(6));
        System.out.println(Fakul(6));
    }

    public static int Fakt(int n){
        if(n == 0 || n == 1)
            return 1;
        return n * Fakt(n - 1);
    }

    public static int Fakul(int n){
        int i = 1;
        int a = 1;
        int rez = 1;

        while(i < n){
            rez *= ++a;
            i++;
        }
        return rez;
    }
}
