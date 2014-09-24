package stringProblems;

public class KMP {

	public static void main(String[] args) {  
        String s = "abbabbbbcab"; // 主串  
        String t = "ababcaabc"; // 模式串  
        char[] ss = s.toCharArray();  
        char[] tt = t.toCharArray();  
        System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串  
    }  
  
    /** 
     * 获得字符串的next函数值 
     * （1）next[0]= -1  意义：任何串的第一个字符的模式值规定为-1。
     * （2）next[j]= -1   意义：模式串T中下标为j的字符，如果与首字符相同，且j的前面的1—k个字符与开头的1—k个字符不等（或者相等但T[k]==T[j]）（1≤k<j）。
     *  如：T=”abCabCad” 则 next[6]=-1，因T[3]=T[6]
     * （3）next[j]=k    意义：模式串T中下标为j的字符，如果j的前面k个字符与开头的k个字符相等，且T[j] != T[k] （1≤k<j）。
     *  即T[0]T[1]T[2]。。。T[k-1]==T[j-k]T[j-k+1]T[j-k+2]…T[j-1]且T[j] != T[k].（1≤k<j）;
     *  (4) next[j]=0   意义：除（1）（2）（3）的其他情况。
     *  
     * @param t 
     *            字符串 
     * @return next函数值 
     */  
    public static int[] next(char[] t) {  
        int[] next = new int[t.length];  
        next[0] = -1;  
        int i = 0;  
        int j = -1;  
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {  
                i++;  
                j++;  
                if (t[i] != t[j]) {  
                    next[i] = j;  
                } else {  
                    next[i] = next[j];  
                }  
            } else {  
                j = next[j];  
            }  
        }  
        return next;  
    }  
  
    /** 
     * KMP匹配字符串 
     * 设在字符串S中查找模式串T，若S[m]!=T[n],那么，取T[n]的模式函数值next[n],
     * 1.next[n]=-1，表示S[m]和T[0]间接比较过了，不相等，下一次比较 S[m+1]和T[0]
     * 2.next[n]= 0，表示比较过程中产生了不相等，下一次比较 S[m]和T[0]。
     * 3.next[n]= k > 0 但k < n，表示S[m]的前k个字符与T中的开始k个字符已经间接比较相等了，下一次比较S[m]和T[k]相等吗？
     * 4.其他值，不可能。
     *  
     * @param s 
     *            主串 
     * @param t 
     *            模式串 
     * @return 若匹配成功，返回下标，否则返回-1 
     */  
    public static int KMP_Index(char[] s, char[] t) {  
        int[] next = next(t);  
        int i = 0;  
        int j = 0;  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } else  
            return i - t.length; // 返回模式串在主串中的头下标  
    }  
}
