import java.util.HashSet;

/**
 * 同样使用hashset储存iterated的element，之后再比较hashset中的element得到是否存在重复元素
 */
class Duplicate {
    public static boolean IsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean iscontains = IsDuplicate(new int[] { 1, 2, 3, 4 });
        System.out.println(iscontains);

    }
}