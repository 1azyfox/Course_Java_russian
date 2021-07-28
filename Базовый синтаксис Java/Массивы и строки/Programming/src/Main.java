/**
 * Checks if given <code>text</code> is a palindrome.
 *
 * @param text any string
 * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
 */
public static boolean isPalindrome(String text) {
        String textLowered = text.toLowerCase(Locale.ROOT);
        String textReplaced = textLowered.replaceAll("[^a-zA-Z0-9]","");
        StringBuilder stringBuilder = new StringBuilder(textReplaced);
        String textReversed = stringBuilder.reverse().toString();
        return textReplaced.contentEquals(textReversed);
        }