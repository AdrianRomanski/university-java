package basics_of_programming.labs.lab_13.account;

public class Card {

    private double total;

    public double getTotal() {
        return total;
    }

    public boolean withdraw(double limit, double amount) throws NotEnoughFunds {
        if(total + amount <= limit) {
            this.total+=amount;
            return true;
        } else  {
            throw new NotEnoughFunds((total + amount) % limit);
        }
    }

}
