
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class kFrequent {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3,3,3,3,4 };
        int[] result = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(result));
    }
    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            } else {
                numMap.put(nums[i], 1);
            }
        }
        int max = nums.length;
        //创建一个int list的array用来放每一个数字出现的频率，index就是频率的数字，list装有相同频率的数字
        ArrayList<Integer>[] frequency = (ArrayList<Integer>[]) new ArrayList[max+1];
        //Need to initialize the empty list of string for each record in frequency
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = new ArrayList<Integer>();
        }
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            frequency[entry.getValue()].add(entry.getKey());
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = frequency.length-1; i >= 0; i--) {
            if (!frequency[i].isEmpty()) {
                for (int n : frequency[i]) {
                    result.add(n);
                    if (result.size() >= k) {
                        return result.stream().mapToInt(Integer::intValue).toArray();
                    }
                }
            }
        }
        //convert a list of integer to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
