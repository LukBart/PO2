public class Main {
    public static void main(String[] args) {

        System.out.println("Number of created accounts = " + Account.NUMBER_OF_CREATED_ACCOUNTS);
        Account account1 = new Account("Jan", "Kowalski", "PLN");
        Account account2 = new Account("Jan", "Kownacki", 100., "EURO");
        Account account3 = new Account("Adam", "Nowak", "PLN");
        Account account4 = new Account("Adam", "Kowalski", 3237.22, "USD");
        System.out.println("Number of created accounts = " + Account.NUMBER_OF_CREATED_ACCOUNTS);

        System.out.println();

        System.out.println("Account 1 details:");
        System.out.println("Owner: " + account1.getOwner());
        System.out.println("Balance: " + account1.getAccountBalance());
        account1.setBalance(150.32);
        System.out.println("Balance: " + account1.getAccountBalance());
        System.out.println("Account 2 details:");
        System.out.println(account2);
        System.out.println();
        Account account2Test = new Account("Jan", "Kownacki", 100., "EURO");
        System.out.println("account2 == account2Test: " + (account2 == account2Test));
        System.out.println("account2.equals(account2Test): " + account2.equals(account2Test));
        System.out.println("account1.equals(account2): " + account1.equals(account2));

        System.out.println();

        System.out.println("Currencies:");
        System.out.println("Euro = " + Bank.EURO); // 4.6
        System.out.println("USD = " + Bank.USD); // 3.95
        System.out.println("PLN = " + Bank.PLN); // 1.0

        System.out.println();

        Bank bank = new Bank();
        bank.addAccount(account1);
        bank.addAccount(account2);
        Bank bank2 = new Bank();
        bank2.addAccount(account3);
        bank2.addAccount(account4);
        System.out.println("Accounts in banks:");
        System.out.print("Bank: ");
        bank.printAccounts();
        System.out.print("Bank2: ");
        bank2.printAccounts();

        System.out.println();

        System.out.println("Account by numbers:");
        System.out.println(account1.getNumber() + ": " + bank.findAccount(account1.getNumber()));
        System.out.println(account4.getNumber() + ": " + bank2.findAccount(account4.getNumber()));
        System.out.println("1111: " + bank.findAccount("1111")); // will not find account

        System.out.println();

        System.out.println("Transfer from EURO to USD");
        System.out.println("Balance before transfer: " + account2.getAccountBalance());
        bank.transferToDifferentCurrency(account2.getNumber(), "USD");
        System.out.println("Balance after transfer: " + account2.getAccountBalance());
        bank.transferToDifferentCurrency("1111", "USD"); // will not find account

        System.out.println();

        System.out.println("Transfer between accounts (same bank):");
        System.out.println("Account 1 balance before transfer: " + account1.getAccountBalance());
        System.out.println("Account 2 balance before transfer: " + account2.getAccountBalance());
        bank.transfer(account1.getNumber(), account2.getNumber(), 50);
        System.out.println("Account 1 balance after transfer: " + account1.getAccountBalance());
        System.out.println("Account 2 balance after transfer: " + account2.getAccountBalance());
        bank.transfer(account1.getNumber(), "1111", 50); // will not find account
        bank2.transfer(account1.getNumber(), account3.getNumber(), 50); // will not work, wrong bank
        bank.transfer(account1.getNumber(), account3.getNumber(), 50); // will not work, wrong bank

        System.out.println();

        System.out.println("Transfer between accounts (different bank):");
        System.out.println("Account 2 balance before transfer: " + account2.getAccountBalance());
        System.out.println("Account 4 balance before transfer: " + account4.getAccountBalance());
        bank.transfer(account2.getNumber(), account4.getNumber(), 50, bank2);
        System.out.println("Account 2 balance after transfer: " + account2.getAccountBalance());
        System.out.println("Account 4 balance after transfer: " + account4.getAccountBalance());
        bank.transfer(account1.getNumber(), account3.getNumber(), 50, bank); // will not work, wrong bank
        bank2.transfer(account1.getNumber(), account3.getNumber(), 50, bank2); // will not work, wrong bank
    }
}
