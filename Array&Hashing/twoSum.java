import java.util.HashMap;

/**
 * 将iterated的element存入hashmap/hashset，直接通过对比hashset里的element获得答案
 */
public class twoSum {
    public static void main(String[] args) {
        System.out.println(twoSumM(new int[]{1,2,3,4},6));
    }
    public static int[] twoSumM(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i };
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
