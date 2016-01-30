import java.util.HashMap;


public class One_one {

	/*
	 * 思路：
	 * 此题最简单的方法就是直接暴利O(n^2)，见One.java
	 * 但是，可以优化到O(n)
	 * 在循环的时候，每次用target减去nums[i]，然后判断这个差在不在nums数组里
	 * 于是，我们用一个hash表维护nums数组
	 * hash的key是nums[i]的值，hash的value是nums[i]的位置，也就是i的值
	 * 于是，直接去hash表里查询一下target-nums[i]，即可实现。
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] results = new int[2];
		HashMap<Integer, Integer> hmap = new HashMap<>();
		hmap.clear();
		int len = nums.length;
		for (int i=0; i<len; i++) {
			hmap.put(nums[i], i+1);
		}
		for (int i=0; i<len; i++) {
			Integer x = hmap.get(target-nums[i]);
			if (x!=null && (i+1)!=x) {	//注意保证(i+1)!=x，即不能是同一个数
				results[0] = i+1;
				results[1] = x;
				break;
			}
		}
		
		return results;
	}
}
