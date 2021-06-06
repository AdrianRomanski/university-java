package oop.labs.lab_6.zadanie_12;

class Buffer {
    int max;
    int index;
    int[] numbers;
    boolean endOfProduction;

    Buffer(int max) {
        this.numbers = new int[max];
        this.max = max;
    }

    synchronized void put(int randomNumber) {
        // pelny to czekamy
        if(index == max) {
            closeProduction();
        }
        if(index + 1 < max) {
          numbers[index++]=randomNumber;
        }
        notify();
    }

    synchronized int get ()  {
        // pusty to czekamy
        if ((index == 0) && (!endOfProduction)) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        return pop();
    }

    synchronized void closeProduction () {
        System.out.println("Closing Production");
        endOfProduction = true;
        notifyAll();
    }

    private int pop() {
        int temp = this.numbers[0];
        if(index!=0) {
            index--;
        }
        for (int i = 1; i < max; i++) {
            this.numbers[i-1]=this.numbers[i];
        }
        return temp;
    }
}
