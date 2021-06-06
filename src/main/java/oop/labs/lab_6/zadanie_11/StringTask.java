package oop.labs.lab_6.zadanie_11;

public class StringTask implements Runnable{

    private String input;
    private String result="";
    private TaskState state;
    private int timesOfDuplicate;
    private boolean isDone;

    public StringTask(String input, int timesOfDuplicate) {
        this.state = TaskState.CREATED;
        this.input = reverse(input);
        this.timesOfDuplicate = timesOfDuplicate;
    }

    public String reverse(String toReverse) {
        StringBuilder sb = new StringBuilder();
        for (int i = toReverse.length()-1; i >= 0; i--) {
            sb.append(toReverse.charAt(i));
        }
        return sb.toString();
    }

    public TaskState getState() {
        if (state.equals(TaskState.ABORTED))
            Thread.currentThread().interrupt();
        return state;
    }

    public String getResult() {
       return result;
    }

    public String getInput() {
        return input;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void abort() {
        this.isDone = true;
        this.state = TaskState.ABORTED;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public void run() {
        this.state = TaskState.RUNNING;
        for (int i = 0; i < timesOfDuplicate; i++) {
            result = result + input;
            // break przed koncem
        }
        isDone=true;
        this.state = TaskState.READY;
    }
}
