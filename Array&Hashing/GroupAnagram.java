import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = groupAnagramWithoutSort(strs);
        for (List<String> list2 : list) {
            System.out.println(Arrays.toString(list2.toArray()));
        }


    }
//第一个思路是先把单词用ASCII数字sort之后得到sorted string作为key，加入hashmap，value为sort之前的单词。但sort逻辑对时间占用很大，所以不是最优选
    public static List<List<String>> groupAnagram(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs.length <= 1) {
            list.add(Arrays.asList(strs));
            return list;
        }
        HashMap<String, List<String>> sortedStrs = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] strChars = str.chars().toArray();
            Arrays.sort(strChars);
            String sortedStr = "";
            for (int ci : strChars) {
                char c = (char) ci;
                sortedStr = sortedStr + c;
            }
            if (sortedStrs.containsKey(sortedStr)) {
                sortedStrs.get(sortedStr).add(str);
            } else {
                sortedStrs.put(sortedStr, new ArrayList<>(List.of(str)));
            }
        }
        sortedStrs.forEach((k, v) -> {
            list.add(v);
        });
        return list;

    }
    //第二个思路是创建一个有26个元素的int array，count每一个单词字母在该单词里的出现频率，将该array作为hashmap的key，value为所有相同字母频率的单词
    //注意！！因为int[]为java的primitive type，所以即使内容相同int[]也不会被判定为相同的数组，不能直接作为hashmap的key，需要将int[]转换为使用reference的ArrayList才能放入hashmap进行比较
    //initiate了拥有26个元素的int[]之后，使用字母与a之差来作为int[]的index
    public static List<List<String>> groupAnagramWithoutSort(String[] strs) {
        HashMap<List<Integer>, List<String>> countedStrs = new HashMap<List<Integer>, List<String>>();
        for (String string : strs) {
            int[] count = new int[26];
            for (char c : string.toCharArray()) {
                //ここはポイント！！！！！！超级smart的解决方案！initiate了拥有26个元素的int[]之后，使用字母与a之差来作为int[]的index
                count[(int) c - (int) 'a'] += 1;
            }
            //convert a int[] to an arraylist
            List<Integer> key = Arrays.stream(count).boxed().collect(Collectors.toList());
            if (countedStrs.containsKey(key)) {
                countedStrs.get(key).add(string);
            }
            else {
                countedStrs.put(key, new ArrayList<>(List.of(string)));
            }
        }
        return new ArrayList<>(countedStrs.values());
    }
}