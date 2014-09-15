package stringProblems;

public class StringCompare {

	/**
	 * 排序的字符串中只含有小写字母
	 * 
	 * @param str
	 * @return
	 */
	private char[] countSort(String str) {
		int[] num = new int[26];
		char[] c = str.toCharArray();

		for (int i = 0; i < c.length; i++) {
			num[(int) (c[i] - 'a')]++;
		}

		int z = 0;
		for (int i = 0; i < 26; i++) {
			while (num[i]-- > 0)
				c[z++] = (char) (i + 'a');
		}
		return c;
	}

	/**
	 * 假设这有一个各种字母组成的字符串A，和另外一个字符串B，字符串里B的字母数相对少一些。什么方法能最快的查出所有小字符串B里的字母在大字符串A里都有
	 * 比如，如果是下面两个字符串：String 1: ABCDEFGHLMNOPQRS String 2: DCGSRQPO
	 * 答案是true，所有在string2里的字母string1也都有。
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean compare(String a, String b) {
		char[] new_a = countSort(a);
		char[] new_b = countSort(b);
		
		int p = 0, q = 0;
		while(p < new_a.length && q < new_b.length){
			if(new_a[p] != new_b[q])
				p++;
			else
				q++;
		}
		
		if(new_a.length > new_b.length)
			return p > new_a.length - 1? false : true;
		else
			return q > new_b.length - 1? false : true;
		
	}
	
	public static void main(String[] args){
		String strOne = "abcdef";  
	    String strTwo = "abdg";  
	    
	    StringCompare test = new StringCompare();
	    System.out.println(test.compare(strOne, strTwo));
	}
}
