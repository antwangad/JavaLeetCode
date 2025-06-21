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
}