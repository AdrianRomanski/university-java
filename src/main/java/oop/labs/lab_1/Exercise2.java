package oop.labs.lab_1;

class Exercise2 {
    public static void main(String[] args) {
		final Flyable[] flyables = {new Bird(), new Plane(), new UFO(), new Virus()};
        final Speakable[] speakables = {new Bird(), new Plane(), new UFO()};

        System.out.println(toString(shortest(flyables)));
        System.out.println(toString(loudest(speakables)));
    }

	private static Flyable shortest(Flyable[] flyables) {
		double min = Double.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < flyables.length; i++) {
		    if(flyables[i].distance() < min) {
		        min = flyables[i].distance();
		        index = i;
            }
        }
		return flyables[index];
	}

	private static Speakable loudest(Speakable[] speakables) {
        int max = 0;
        int index = 0;
        for(int i = 0; i < speakables.length; i++) {
            if(speakables[i].speak().length() > max) {
                max = speakables[i].speak().length();
                index = i;
            }
        }
        return speakables[index];
	}

	private static String toString(Object o) {
        return o.getClass().getSimpleName();
    }


}

interface Flyable {
     double distance();
     String drive();
}

interface Speakable {
    String speak();
}

class Bird implements Flyable, Speakable{
    @Override
    public String speak() { return "Kra Kra"; }

    @Override
    public double distance() { return 500; }

    @Override
    public String drive() { return "Skrzydla"; }

    public String toString() {
        return getClass().getSimpleName();
    }
}

class Plane implements Flyable, Speakable{
    @Override
    public String speak() { return "Zium Zium"; }

    @Override
    public double distance() { return 10000; }

    @Override
    public String drive() { return "Silnik"; }
}

class UFO implements Flyable, Speakable{
    @Override
    public String speak() { return "Bzium Bzium"; }

    @Override
    public double distance() { return 421521; }

    @Override
    public String drive() { return "Miedzygalaktyczny Silnik ZX42051p"; }
}

class Virus implements Flyable {
    @Override
    public double distance() {
        return 0.0000000000005;
    }
    @Override
    public String drive() {
        return "Wirusowe Nogi";
    }
}
