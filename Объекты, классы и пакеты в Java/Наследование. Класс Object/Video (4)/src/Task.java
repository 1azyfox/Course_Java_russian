// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    System.out.println((doubleToRawLongBits(2)));
  }

  public static long doubleToRawLongBits(double var0) {
    return Integer.parseInt(Integer.toBinaryString((int)var0));
  }
}
