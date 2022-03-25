import java.util.List;
import java.text.BreakIterator;
import java.util.ArrayList;

public class Bank {
    public static final double EURO = 4.6;
    public static final double USD = 3.95;
    public static final double PLN = 1.0;

    public static int numberOfBanks;

    private int bankNumber;
    private List<Account> accounts = new ArrayList<>();
    private static List<Account> allAccounts = new ArrayList<>();

    

    Bank ()
    {
        numberOfBanks++;
        bankNumber = numberOfBanks;
    }

    public void addAccount (Account o)
    {
        accounts.add(o);
        allAccounts.add(o);
        int number = bankNumber * 1000 + ((int) (Math.random() * ((999) + 1)));
        o.setNumber(number);
    }

    public void printAccounts()
    {
        for (Account o : accounts)
        {
            System.out.println(o);
        }
    }

    public String findAccount (String n)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            if (n.equals(accounts.get(i).getNumber()))
                return accounts.get(i).toString();
        }
        return "Could not find given account";
    }

    public void transferToDifferentCurrency (String n, String c)
    {
        double v1=1.;
        double v2=1.;
        switch (c)
        {
            case "USD" : v1 = Bank.USD; break;
            case "EURO" : v1 = Bank.EURO; break;
            case "PLN" : v1 = Bank.PLN; break;
        }
        for (int i = 0; i < accounts.size(); i++)
        {
            if (n.equals(accounts.get(i).getNumber()))
            {
                switch (accounts.get(i).getCurrency())
                {  
                    case "USD" : v2 = Bank.USD; break;
                    case "EURO" : v2 = Bank.EURO; break;
                    case "PLN" : v2 = Bank.PLN; break; 
                }
                accounts.get(i).setBalance(accounts.get(i).getBalance()/v1 * v2);
                accounts.get(i).setCurrency(c);
            }
        }
    }
    public void transfer (String n1, String n2, double n)
    {

        int i = 0;
        while (!n1.equals(accounts.get(i).getNumber()))
        {
            i++;
            if (i == accounts.size())
            {
                for (Account e : allAccounts)
                {
                    if (e.getNumber().equals(n1))
                    {
                        System.out.println ("Cannot transfer, wrong bank");
                        return;
                    }
                }
                System.out.println("Could not find given account");
                return;
            }
        }
        int j = 0;
        while (!n2.equals(accounts.get(j).getNumber()))
        {
            j++;
            if (j == accounts.size())
            {
                for (Account e : allAccounts)
                {
                    if (e.getNumber().equals(n2))
                    {
                        System.out.println ("Cannot transfer, wrong bank");
                        return;
                    }
                }
                System.out.println("Could not find given account");
                return;
            }
        }

        double v1= 1.;
        double v2= 1.;
        switch (accounts.get(i).getCurrency())
        {
            case "USD" : v1 = Bank.USD; break;
            case "EURO" : v1 = Bank.EURO; break;
            case "PLN" : v1 = Bank.PLN; break;
        }
        switch (accounts.get(j).getCurrency())
        {
            case "USD" : v2 = Bank.USD; break;
            case "EURO" : v2 = Bank.EURO; break;
            case "PLN" : v2 = Bank.PLN; break;
        }
        accounts.get(i).changeBalance(-n);
        accounts.get(j).changeBalance(n/v2*v1);

        
    }

    public void transfer (String n1, String n2, double n, Bank other)
    {
        if (this.equals(other))
        {
            System.out.println("Cannot transfer, wrong bank");
        }
        int i = 0;
        while (!n1.equals(allAccounts.get(i).getNumber()))
        {
            i++;
        }
        int j = 0;
        while (!n2.equals(allAccounts.get(j).getNumber()))
        {
            j++;
        }

        double v1= 1.;
        double v2= 1.;
        switch (allAccounts.get(i).getCurrency())
        {
            case "USD" : v1 = Bank.USD; break;
            case "EURO" : v1 = Bank.EURO; break;
            case "PLN" : v1 = Bank.PLN; break;
        }
        switch (allAccounts.get(j).getCurrency())
        {
            case "USD" : v2 = Bank.USD; break;
            case "EURO" : v2 = Bank.EURO; break;
            case "PLN" : v2 = Bank.PLN; break;
        }
        allAccounts.get(i).changeBalance(-n);
        allAccounts.get(j).changeBalance(n/v2*v1);        
    }

}
