package oop.labs.lab_5;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class TestGame {

    public static void main(String[] args) {

        Player p1 = new Player("ppj");
        Player p2 = new Player("gui");
        Referee ref = new Referee(10, new Player[]{p1,p2});

        ref.startGame();
        try {
            ref.join();
        } catch (InterruptedException exc){
            exc.printStackTrace();
        }
        ref.result();
    }
}


class Player extends Thread {
    Random random = new Random();
    int totalPoints;

    public Player(String nazwa) {
        super(nazwa);
    }

    public void run() {
        while (true) {
            int randomDelay = random.nextInt(1000);
            int randomNumber = random.nextInt(100);
            totalPoints+=randomNumber;
            System.out.println(totalPoints + " " + super.getName());
            try {
                Thread.sleep(randomDelay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}


class Referee extends Thread {
    long startTime;
    long actualTime;
    int maxScore;
    String playerName;
    Player[] players;
    Map<String, Integer> results = new HashMap<>();

    public Referee(int startTime, Player[] pl) {
        this.startTime = startTime;
        this.players = pl;
    }

    void startGame(){
        this.start();
    }

    public void run() {
        for(Player p: players) {
            p.start();
        }

        while(startTime > actualTime) {
            try {
                Thread.sleep(1000);
                actualTime++;
                System.out.println("Current time in seconds " + actualTime);
                for(Player p: players) {
                    results.put(p.getName(), p.totalPoints);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(Player p: players) {
            p.interrupt();
        }
    }

    void result() {
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                playerName = entry.getKey();
            }
        }
        System.out.println("And the winner is " + playerName + " with score " + maxScore);
        this.interrupt();
    }
}
