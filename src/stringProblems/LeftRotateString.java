package stringProblems;

public class LeftRotateString {

	/**
	 * 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部，如把字符串abcdef左旋转2位得到字符串cdefab。
	 * 请实现字符串左旋转的函数，要求对长度为n的字符串操作的时间复杂度为O(n)，空间复杂度为O(1)。 
	 * @param str
	 * @param m
	 */
	public static String leftRotateString(String str, int m){
		if(str == null || m < 0)
			return str;
		char[] c = str.toCharArray();
		int p = 0, q = m; 
		int n = str.length();
		if(n < m)
			return str;
		while(true){
			swap(c, p, q);
			p++;
			if(q < n -1)
				q++;
			else
				break;
		}
		int r = m - n % m;//尾部剩余
		for(int i = 0; i < r; i++){
			for(int j = p; j < n-1; j++)
				swap(c, j, j+1);
		}
		return new String(c);
	}

	private static void swap(char[] c, int p, int q) {
		// TODO Auto-generated method stub
		char temp = c[p];
		c[p] = c[q];
		c[q] = temp;
	}
	
	/**
	 * has something wrong
	 * @param str
	 * @param m
	 * @return
	 */
	public static String rotate(String str, int m){
		char[] c = str.toCharArray();
		int lenOfStr = c.length;
		int numOfGroup = gcd(lenOfStr, m);
		int elemInSub = lenOfStr /numOfGroup;
		
		for(int j = 0; j < numOfGroup; j++){
			char tmp = c[j];
			int i = 0;
			for(; i < elemInSub; i++)
				c[(j + i * m) % lenOfStr] = c[(j + (i + 1) * m) % lenOfStr];  
		    c[(j + i * m) % lenOfStr] = tmp;   
		}
		return new String(c);
	}
	private static int gcd(int n, int m) {
		// TODO Auto-generated method stub
		if(n == 0) return m;
		if(m == 0) return n;
		if(n > m) return gcd(n%m, m);
		else return gcd(n, m%n);
	}

	public static void main(String[] args){
		String s = "abcdef";
		System.out.println(LeftRotateString.rotate(s, 1));
	}
}
