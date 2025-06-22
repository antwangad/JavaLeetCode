import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("LeetCode time!");
    }

    public int LongestSubstringNoRepeats(String s) {
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }

    public int LongestSubstringKDistinctChar(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        int maxlen = 0;
        int left =  0;

        for (int right = 0; right < s.length(); right++) {
            set.put(s.charAt(right), set.getOrDefault(s.charAt(right), 0) + 1);
            while (set.size() > 2) {
                set.put(s.charAt(left), set.get(s.charAt(left)) - 1);
                if (set.getOrDefault(s.charAt(left), -1) == 0) {
                    set.remove(s.charAt(left));
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left +1);
        }

        return maxlen;
    }

}