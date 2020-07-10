
public class BasicJavaP1 {
	public static long floor(double num) {
	long value=(long)num;
	return value;
	}
	
	public static double conversion(double fahr) {
	double value=(fahr-32)*5/9;
	return value;
	}
	
	public static boolean willRoundUp(double num) {
	boolean result=false;
	return result;
	}
	
	public static int sumRange(int start, int end) {
		int counter=0;
		int sum=0;
		while(counter<(end-start-1)) {
			sum+=start;
			start++;
			
			
		}
		return sum;
	}
	public static int countChar(String str, char c) {
		int counter=0;
		int numOfChar=0;
		while (str!=null && counter<str.length()) {
			if(str.charAt(counter)==c) {
				numOfChar+=1;
				counter+=1;
			}
			else counter+=1;
		}
		return numOfChar;
}

	public static int addDigits(int num) {
		int sum=0;
		while(num!=0) {
			sum=sum+num%10;
			num=num/10;
		}
		return sum;
	}
	
}
