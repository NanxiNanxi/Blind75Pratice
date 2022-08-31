import java.util.HashMap;

/**
 * 将index与element存入各自的hashmap中，将两个hashmap对比可得char的数量是否一样。也可通过sort之后直接对比，但内存占用较高，而且太偷懒。
 */
class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(validAnagram("tee", "teas"));
    }

    public static boolean validAnagram(String s, String t ){
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<String, Integer> mapS = new HashMap<>();
        HashMap<String, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = Character.toString(s.charAt(i));
            String tempT = Character.toString(t.charAt(i));

            mapS.put(temp, mapS.containsKey(temp) ? mapS.get(temp) + 1 : 0);
            mapT.put(tempT, mapT.containsKey(tempT) ? mapT.get(tempT) + 1 : 0);
        }
        for (int i = 0; i < mapS.size(); i++) {
            String temp = mapS.keySet().toArray()[i].toString();
            if (!(mapT.containsKey(mapS.keySet().toArray()[i]) && mapT.get(temp) == mapS.get(temp))) {
                return false;
            }
        }
        return true;
    }
}