import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public boolean isNaN(double v) {
        return v != v;
    }

    public long doubleToRawLongBits(double var0) {
        return Double.doubleToRawLongBits(var0);
    }

    public long doubleToLongBits(double value) {
        return !isNaN(value) ? doubleToRawLongBits(value) : 9221120237041090560L;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}