class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String str : strs) {

            result.append(str.length())
                  .append("#")
                  .append(str);
        }

        return result.toString();
    }

    public List<String> decode(String s) {
List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find delimiter
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            // Extract length
            int length = Integer.parseInt(
                    s.substring(i, j)
            );

            // Start of actual string
            int start = j + 1;

            // Extract actual string
            String str = s.substring(
                    start,
                    start + length
            );

            result.add(str);

            // Move to next encoded string
            i = start + length;
        }

        return result;
    }
}
