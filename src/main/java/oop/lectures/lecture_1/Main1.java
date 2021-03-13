package oop.lectures.lecture_1;

public class Main1 {

    public static void main(String[] args) {

        String str = "Ala";

        process(str, new StringModifier() {
            @Override
            public String rev(String str) {
                String res = "";
                for(int i = str.length()-1; i>=0; i--) {

                }
                return res;
            }

        });

    }

    public static void process(String str, StringModifier sm) {
        System.out.println(
                sm.rev(str)
        );
    }
}


interface StringModifier {
    String rev(String str);
}
