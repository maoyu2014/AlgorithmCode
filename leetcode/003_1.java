import java.util.Arrays;


public class Three_one {

	public static void main(String[] args) {
		System.out.println(new Three_one().lengthOfLongestSubstring("abba"));
	}
	
	/*
	 * 思路：
	 * 先看一个例子：对于字符串"xyzabdcatch"
	 * 按照Three.java中暴利的方法，我们要做两重循环，
	 * 第一层分别从x,y,z,a,b,d,c,a,t,c,h开始
	 * 第二层从对应的第一层枚举的位置开始往后
	 * 于是乎，我们发现:
	 * 第一层分别从x,y,z,a这四个位置开始时，第二层一旦扫描到第二个a就终止了，
	 *     明显是从x开始到第二个a之前最长，temp=7
	 * 第一层分别从b,d,c三个位置开始时，第二层一旦扫描到第二个c就终止了
	 *     明显是从b开始到第二个c之前最长,temp=5
	 * 第一层分别从a,t,c,h四个位置开始时，可以扫描到最后
	 *     明显是从a开始到最后最长,temp=4
	 * 最终最长就是7
	 * 等于说，
	 * 我们只要做一次遍历，先设置一个front标记临时最长串的起始位置
	 * 然后开始遍历，如果该字符没出现过，记录下当前字符的位置
	 * 如果该字符出现过了，即遇到相同字符了，当前字符就不能纳入到这个临时最长串，
	 * 假设该字符现在位置是i,上次出现在x位置，那么，临时最长串为i-front
	 * 假设j在front到x之间，以j开始的串一定会在i处再次终止，于是，这段距离直接跳过，
	 * 也就是，更新front为x+1即可。
	 * 
	 * 细节点：
	 * 如果出现相同字符，但是x的位置在front之前，说明这个x的位置无效
	 * 举例：“abba”
	 * front已经指向3这个位置了，而第二个a之前出现在0号位置，所以，这个位置无效。
	 */
	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		int len = s.length();
		int[] prePos = new int[300];
		Arrays.fill(prePos, -1);
		
		int front=0, end=0;
		for (end=0; end<len; end++) {
			char c = s.charAt(end);
			if (prePos[c]==-1) {
				prePos[c] = end;
			} else {
				int x = prePos[c];
				if (x<front) {
					prePos[c] = end;
					continue;
				}
				int temp = end-front;
				ans = Math.max(ans, temp);
				front = prePos[c]+1;
				prePos[c] = end;
			}
		}
		int temp = len-front;
		ans = Math.max(ans, temp);
		
		return ans;
	}

}
