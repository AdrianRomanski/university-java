package basics_of_programming.labs.lab_13.account;

public class Account {

    private double balance;
    private double dailyDebet;
    private double credit;
    private DebetCard debetCard;
    private CreditCard creditCard;

    public Account(double balance, DebetCard debetCard, CreditCard creditCard) {
        this.balance = balance;
        this.dailyDebet = debetCard.getDailyDebet();
        this.credit = creditCard.getCredit();
        this.debetCard = debetCard;
        this.creditCard = creditCard;
    }

    public void withdrawFromDebet(double amount) throws NotEnoughFunds {
        if(this.debetCard.withdraw(dailyDebet, amount)) {
            this.balance-=amount;
            System.out.println("Wyplacono " + amount + "$ Pozostalo na koncie " + balance);
            if(this.dailyDebet - this.debetCard.getTotal() != 0) {
                System.out.println("Pozostalo " + (this.dailyDebet - this.debetCard.getTotal()) + "$ dziennych wyplat");
            } else {
                System.out.println("Limit dziennych transakcji wraz z ta transakcja zostal wyczerpany");
            }
        }
    }

    public void withdrawFromCredit(double amount) throws NotEnoughFunds {
        if(this.creditCard.withdraw(this.credit, amount)) {
            System.out.println("Wyplacono " + amount);
            if(this.credit - this.creditCard.getTotal() != 0) {
                System.out.println("Pozostalo  " + (credit - this.creditCard.getTotal()) + "$ kredytu do wykorzystania");
            } else {
                System.out.println("Limit kredytu zostal osiagniety");
            }
        }
    }


}
