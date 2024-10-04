abstract class Pair{
    public abstract Pair add(Pair other);
    public abstract Pair subtract(Pair other);
    public abstract Pair multiply(int value);
    public abstract Pair divide(int value);

    public abstract String toString();

    public abstract boolean equals(Object obj);
}

class Money extends Pair{
    private int dollars;
    private int cents;

    public Money(int dollars, int cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money add(Pair other){
        if (other instanceof Money){
            Money o = (Money) other;
            int totalCents = (this.dollars * 100 + this.cents) + (o.dollars * 100 + o.cents);
            return new Money(totalCents / 100, totalCents%100);
        }
        return null;
    }

    public Money subtract(Pair other){
        if (other instanceof Money){
            Money o = (Money) other;
            int totalCents = (this.dollars * 100 + this.cents) - (o.dollars * + o.cents);
            return new Money(totalCents / 100, totalCents % 100);
        }
        return null;
    }

    public Money multiply(int value){
        int totalCents = (this.dollars * 100 + this.cents) * value;
        return new Money(totalCents / 100, totalCents % 100);
    }

    public Money divide(int value){
        int totalCents = (this.dollars * 100 + this.cents) / value;
        return new Money(totalCents / 100, totalCents % 100);
    }

    public String toString(){
        return dollars + " dollars " + cents + " cents ";
    }

    public boolean equals(Object obj){
        if(obj instanceof Money){
            Money other = (Money)  obj;
            return this.dollars == other.dollars && this.cents == other.cents;
        }
        return false;
    }
}

class Fraction extends Pair{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Pair other) {
        if (other instanceof Fraction) {
            Fraction o = (Fraction) other;
            int newNumerator = this.numerator * o.denominator + o.numerator * this.denominator;
            int newDenominator = this.denominator * o.denominator;
            return new Fraction(newNumerator, newDenominator);
        }
        return null;
    }

    public Fraction subtract(Pair other) {
        if (other instanceof Fraction) {
            Fraction o = (Fraction) other;
            int newNumerator = this.numerator * o.denominator - o.numerator * this.denominator;
            int newDenominator = this.denominator * o.denominator;
            return new Fraction(newNumerator, newDenominator);
        }
        return null;
    }

    public Fraction multiply(int value) {
        return new Fraction(this.numerator * value, this.denominator);
    }

    public Fraction divide(int value) {
        return new Fraction(this.numerator, this.denominator * value);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            return this.numerator * other.denominator == other.numerator * this.denominator;
        }
        return false;
    }
}

public class Mainn{
    public static void main(String[] args) {
        Pair[] pairs = new Pair[4];
        pairs[0] = new Money(5, 75);   
        pairs[1] = new Money(2, 50);   
        pairs[2] = new Fraction(3, 4); 
        pairs[3] = new Fraction(2, 3); 

        System.out.println("Робота з об'єктами класу Money:");
        System.out.println(pairs[0] + " + " + pairs[1] + " = " + pairs[0].add(pairs[1]));
        System.out.println(pairs[0] + " - " + pairs[1] + " = " + pairs[0].subtract(pairs[1]));
        System.out.println(pairs[0] + " * 2 = " + pairs[0].multiply(2));
        System.out.println(pairs[0] + " / 2 = " + pairs[0].divide(2));

        System.out.println("\nРобота з об'єктами класу Fraction:");
        System.out.println(pairs[2] + " + " + pairs[3] + " = " + pairs[2].add(pairs[3]));
        System.out.println(pairs[2] + " - " + pairs[3] + " = " + pairs[2].subtract(pairs[3]));
        System.out.println(pairs[2] + " * 3 = " + pairs[2].multiply(3));
        System.out.println(pairs[2] + " / 2 = " + pairs[2].divide(2));
    }
}