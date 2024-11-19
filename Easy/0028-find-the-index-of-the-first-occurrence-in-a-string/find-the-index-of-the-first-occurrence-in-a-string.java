class Solution {
    public int strStr(String haystack, String needle) {
        int indexHaystack = 0;

        while(indexHaystack < haystack.length()) {
            int indexNeedle = 0;
            while (indexNeedle < needle.length() && indexHaystack+indexNeedle < haystack.length() && haystack.charAt(indexHaystack+indexNeedle) == needle.charAt(indexNeedle)) {
                indexNeedle++;
            }

            if (indexNeedle == needle.length()) {
                return indexHaystack;
            }

            indexHaystack++;
        }


        return -1;
    }
}