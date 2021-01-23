package basics_of_programming.labs.lab_13.account;

public class CreditCard extends Card{

    private double credit;

    public CreditCard(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }
}
