package oop.training.eduweb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MailSender {

    private ExecutorService executorService;

    public MailSender(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Future<?> sendMail(String mail) {
        return executorService.submit(() -> {
            someLongBlockingInternalOperation();
            System.out.println(mail + " sent");
        });
    }

    private void someLongBlockingInternalOperation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
