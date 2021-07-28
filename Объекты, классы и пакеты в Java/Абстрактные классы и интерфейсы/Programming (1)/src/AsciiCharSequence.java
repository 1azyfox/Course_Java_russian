public class AsciiCharSequence implements CharSequence {

    private final byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray.clone();
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int i) {
        return (char) byteArray[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] byteArraySubSequence = new byte[i1 - i];
        for (int j = 0, k = i; j < byteArraySubSequence.length && k <= i1; j++, k++) {
            byteArraySubSequence[j] = byteArray[k];
        }
        return new AsciiCharSequence(byteArraySubSequence);
    }

    @Override
    public String toString() {
        char[] byteToCharArray = new char[byteArray.length];
        StringBuilder b = new StringBuilder();
        for (int j = 0, i = 0; j < byteArray.length; j++, i++) {
            byteToCharArray[j] = (char) byteArray[i];
            b.append(byteToCharArray[j]);
        }
        return b.toString();
    }
}