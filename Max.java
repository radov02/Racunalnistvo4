public class Main{
	public static void main(String[] args){
		System.out.println(max(3, 1, 2));
		System.out.println(max1(3, 1, 2));
		System.out.println(max2(3, 1, 2));
	}

	public static int max(int a, int b, int c){
		int prvi = Math.max(a, b);
		return Math.max(prvi, c);
	}

	public static int max1(int a, int b, int c){
		if(a > b){
			if(a > c){
				return a;
			}
			else{
				return c;
			}
		}
		else{
			if(b > c){
				return b;
			}
			else{
				return c;
			}
		}
	}
	
	public static int max2(int a, int b, int c){
		if(a >= b && a >= c){
		    return a;
		}
		else if(b >= a && b >= c){
		    return b;
		}
		else{
		    return c;
		}
	}
}
