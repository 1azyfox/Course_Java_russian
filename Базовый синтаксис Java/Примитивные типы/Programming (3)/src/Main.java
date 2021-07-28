/**
 * Flips one bit of the given <code>value</code>.
 *
 * @param value     any number
 * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
 * @return new value with one bit flipped
 */
public static int flipBit(int value, int bitIndex) {
        int answer;
        int b;
        b = (int) Math.pow(2,(bitIndex-1));
        answer = value ^ b;
        return answer;
        }