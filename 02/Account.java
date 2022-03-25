import java.util.Currency;

public class Account {
    private String firstName;
    private String surname;
    private String currency;
    private double balance;
    private String number;

    public static int NUMBER_OF_CREATED_ACCOUNTS;

    public Account (String fN, String s, String c)
    {
        firstName = fN;
        surname = s; 
        currency = c;
        balance = 0;
        NUMBER_OF_CREATED_ACCOUNTS++;
        number = "Not assigned to any bank";
    }

    public Account (String fN, String s, double n, String c)
    {
        firstName = fN;
        surname = s; 
        currency = c;
        balance = n;
        NUMBER_OF_CREATED_ACCOUNTS++;
        number = "Not assigned to any bank";
    }

    public String getOwner()
    {
        return firstName + " " + surname;
    }
    
    public String getAccountBalance()
    {
        return balance + " " + currency;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance (double n)
    {
        balance = n;
    }
    public String toString ()
    {
        return "{first name: " + firstName + ", surname: " + surname + ", number: " + number + ", balance: " + getAccountBalance() + "}";
    }

    @Override
    public boolean equals (Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (this.getClass() == o.getClass())
        {
            Account other = (Account)o;
            return firstName.equals(other.firstName) && 
            surname.equals(other.surname) && 
            currency.equals(other.currency) && 
            balance == other.balance && 
            number.equals(other.number);
        }
        return false;
    }

    public void setNumber (int n)
    {
        number = "" + n;
    }

    public void changeBalance (double n)
    {
        balance += n;
    }

    public String getNumber ()
    {
        return number;
    }
    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String c)
    {
        currency = c;
    }

}
