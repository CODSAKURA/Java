package Money;

public class Money {


private int euros, cents;


public Money(int e, int c) {

euros = e; cents = c;

}


public int getEuros() {

return euros;

}


public int getCents() {

return cents;

}


public String toString() {

        return "EUR"+euros + "."+cents;

}


public Money plus(Money other) {

        return new Money (euros  + other.euros , cents + other.cents);

}

}

