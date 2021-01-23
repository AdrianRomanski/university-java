package basics_of_programming.labs.lab_13.account;

public class DebetCard extends Card{

    private double dailyDebet;

    public DebetCard(double dailyDebet) {
        this.dailyDebet = dailyDebet;
    }

    public double getDailyDebet() {
        return dailyDebet;
    }
}
