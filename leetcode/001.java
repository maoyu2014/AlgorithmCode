import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class One {
	
	public static void main(String[] args) {
		new One().init();
	}
	
	private void init() {
		Scanner cin = new Scanner(System.in);
		int[] nums = new int[100];
		for (int count=0; count<4; count++) {
			nums[count] = cin.nextInt();
		}
		int[] results = twoSum(nums, 9);
		System.out.println(results[0]+""+results[1]);
//		Arrays.sort(nums);
	}

	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		for (int i=0; i<length; i++) {
			for (int j=i+1; j<length; j++) {
				if (nums[i]+nums[j]==target) {
					int[] results = new int[2];
					results[0]=i+1;
					results[1]=j+1;
					return results;
				}
			}
		}
		return null;
	}
}
