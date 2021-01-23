package basics_of_programming.labs.lab_13.account;

public class AccountMain {


    public static void main(String[] args) {

        CreditCard creditCard = new CreditCard(500);
        DebetCard debetCard = new DebetCard(250);

        Account account = new Account(1000, debetCard, creditCard);


        System.out.println("**************************");
        System.out.println("Karta Debetowa");
        System.out.println("**************************");

        try {
            account.withdrawFromDebet(100);
            account.withdrawFromDebet(150);
            account.withdrawFromDebet(150);
        } catch (NotEnoughFunds exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("**************************");
        System.out.println("Karta Kredytowa");
        System.out.println("**************************");

        try {
            account.withdrawFromCredit(200);
            account.withdrawFromCredit(150);
            account.withdrawFromCredit(150);
            account.withdrawFromCredit(50);
        } catch (NotEnoughFunds exception) {
            System.out.println(exception.getMessage());
        }
    }





}
