public class FibonaccijevoZaporedje {
    public static void main(String[] args){
        System.out.println(Fibo(6));
        System.out.println(Fibon(6));
    }

    public static int Fibo(int n){
        int a;
        if(n == 1 || n == 2)
            a = 1;
        else
            a = Fibo(n - 1) + Fibo(n - 2);
        return a;
    }

    public static int Fibon(int n){
        int a = 2;
        int prvi = 1;
        int drugi = 1;
        
        while(a < n){
            
            int tmp = prvi + drugi;
            prvi = drugi;
            drugi = tmp;

            a++;
        }
        return drugi;
    }
}
