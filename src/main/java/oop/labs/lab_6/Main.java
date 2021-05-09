//package oop.labs.lab_6;
//
//public class Main {
//
//    public static void main(String[] args) throws InterruptedException {
//        StringTask task = new StringTask("ABC", 50000);
//        System.out.println("Task " + task.getState());
//        task.start();
//        if (args.length > 0 && args[0].equals("abort")) {
//    /*<- tu zapisać kod przerywający działanie tasku po sekundzie
//         i uruchomic go (tj. kod) w odrębnym wątku (tzn. innym niż main)
//    */
//        }
//        while (!task.isDone()) {
//            Thread.sleep(500);
//            switch(task.getState()) {
//                case RUNNING: System.out.print("R."); break;
//                case ABORTED: System.out.println(" ... aborted."); break;
//                case READY: System.out.println(" ... ready."); break;
//                default: System.out.println("uknown state");
//            }
//
////        }
////        System.out.println("Task " + task.getState());
////        System.out.println(task.getResult().length());
////        System.out.println(task.getResult().substring(0,task.getTxt().length()));
//    }
//
//}
