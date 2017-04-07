package cn.sean.zxx;

public class GetAllSubSequences
{

    public static void main(String[] args)
    {
        System.out.println(subsequences("abc"));
    }

    /**
     * Return all subsequences of word (as defined above) separated by commas,
     * with partialSubsequence prepended to each one.
     */
    @SuppressWarnings("unused")
    private static String subsequencesAfter(String partialSubsequence, String word)
    {
        return word.isEmpty() ? partialSubsequence
                : subsequencesAfter(partialSubsequence, word.substring(1)) + ","
                        + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));

        // if (word.isEmpty()) {
        // // base case
        // return partialSubsequence;
        // } else {
        // // recursive step
        // return subsequencesAfter(partialSubsequence, word.substring(1)) +
        // ","
        // + subsequencesAfter(partialSubsequence + word.charAt(0),
        // word.substring(1));
        // }
    }

    /**
     * @param word consisting only of letters A-Z or a-z
     * @return all subsequences of word, separated by commas, where a
     *         subsequence is a string of letters found in word in the same
     *         order that they appear in word.
     */
    private static String subsequences(String word)
    {
        if (word.isEmpty())
        {
            return ""; // base case
        }
        else
        {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequencesOfRest = subsequences(restOfWord);

            String result = "";
            for (String subsequence : subsequencesOfRest.split(",", -1))
            {
                result += "," + subsequence;
                result += "," + firstLetter + subsequence;
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }

}
