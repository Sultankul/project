import java.math.BigInteger;
import java.util.Comparator;

public class Rational implements MyComparable {
    private BigInteger num;
    private BigInteger den;

    Rational(int num, int den){
        this(new BigInteger(String.valueOf(num)),new BigInteger(String.valueOf(den)));
    }
    Rational(BigInteger num, BigInteger den){
        if (den.equals(BigInteger.ZERO)){
            throw new ArithmeticException("The denominator cannot be equal to zero.");
        }

        BigInteger gcd = num.gcd(den);
        num = num.divide(gcd);
        den = den.divide(gcd);

        if (den.compareTo(BigInteger.ZERO) < 0){
            num = num.negate();
            den = den.negate();
        }

        this.num = num;
        this.den = den;
    }

    Rational add(Rational other){
        return new Rational(num.multiply(other.den).add(den.multiply(other.num)), den.multiply(other.den));
    }

    Rational sub(Rational other){
        return new Rational(num.multiply(other.den).subtract( den.multiply(other.num)), den.multiply(other.den));
    }

    Rational mul(Rational other){
        return new Rational(num.multiply(other.num), den.multiply(other.den));
    }

    Rational div(Rational other){
        return new Rational(num.multiply(other.den), den.multiply(other.num));
    }

    public int compareTo(Object object) {
        return compareTo((Rational)object);
    }
    public int compareTo(Rational other){
        return num.multiply(other.den).compareTo(den.multiply(other.num));
    }

    public String toString(){
        return num + "/" + den;
    }
    static Rational parse(String s){
        int index = s.indexOf('/');

        Rational result;
        try {
            if (index == -1) {
                result = new Rational(new BigInteger(s), BigInteger.ONE);
            } else {
                BigInteger num = new BigInteger(s.substring(0,index));
                BigInteger den = new BigInteger(s.substring(index + 1));
                result = new Rational(num, den);
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("Incorrect rational: " + s);
        }

        return result;
    }


}
