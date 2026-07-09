class Solution {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (str1.length() != str2.length()) {
            System.out.println("Not Anagram");
            return;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
            count2[str2.charAt(i) - 'a']++;
        }

        boolean isAnagram = true;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                isAnagram = false;
                break;
            }
        }

        System.out.println(isAnagram ? "Anagram" : "Not Anagram");
    }
}
