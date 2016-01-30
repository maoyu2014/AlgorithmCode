import java.util.Arrays;


public class Three {
	/*
	 * 思路如下：
	 * 这里我们做一个两层循环，
	 * 第一层i指向当前这个可能存在的串的首部，
	 * 第二层j从i开始往后走，每走到一个字符，如果从i开始都没有出现过，就记录在pre数组中
	 * 如果一旦发现出现过了，那么，违反了without repeating原则，
	 * 那么， j-i就是从i开始的最长的符合条件的字符串。
	 * 每次比较j-i和ans的大小，保留最大的。
	 * 优化：
	 * 如果从i开始一直到最后length，这个距离如果一开始就比ans小，那么再往后就不用算了。
	 */
	public int lengthOfLongestSubstring(String s) {
		int ans=0;
        int length = s.length();
        int[] pre = new int[300];
        for (int i=0;i<length; i++) {
        	// ------optimize
        	if (length-i<=ans) break;
        	//---------------
        	Arrays.fill(pre, -1);
        	char c = s.charAt(i);
        	pre[c]=1;
        	int j;
        	for (j=i+1;j<length; j++) {
        		char cc = s.charAt(j);
        		if (pre[cc]==-1) {
        			pre[cc]=1;
        		} else {
        			int len=j-i;
        			if (len>ans) ans=len;
        			break;
        		}
        	}
        	if (j>=length) {
        		int len=j-i;
    			if (len>ans) ans=len;
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int cc='中';
		char c = (char)100;
		System.out.print(cc);
	}
}
