package basics_of_programming.labs.lab_13.account;

public class NotEnoughFunds extends Exception{

    public NotEnoughFunds(Double amount) {
        super("Limit zostal przekroczony o " + amount + "$ niestety nie mozna dokonac wyplaty");
    }
}
