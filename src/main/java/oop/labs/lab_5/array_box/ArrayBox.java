package oop.labs.lab_5.array_box;

class ArrayBox <T extends Comparable> {

    Object[] arr;
    int index;
    int size;

    ArrayBox(int c) {
        arr = new Object[c];
        this.size = c;
    }

    boolean add(T element) {
        boolean flag = true;
        checkSize();
        for (int i = 0; i < this.arr.length; i++) {
            if (element.compareTo(this.arr[i]) == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            this.arr[this.index++] = element;
            return true;
        } else {
            return false;
        }
    }

    boolean addAll(T[] array) {
        boolean anyAdded = false;
        boolean flag = true;
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i < array.length) {
                    if (array[i].compareTo(this.arr[j]) == 0) {
                        flag = false;
                        break;
                    }
                    if (flag) {
                        checkSize();
                        this.arr[this.index++] = array[i];
                        anyAdded = true;
                    }
                } else {
                    break;
                }

            }
        }
        return anyAdded;
    }

    void checkSize() {
        if (this.index + 1 > this.size) {
            this.size *= 2;
            Object[] newArray = new Object[this.size];
            for (int i = 0; i < this.index; i++) {
                newArray[i] = this.arr[i];
            }
            this.arr = newArray;
        }
    }

    T min() {
        T min = null;
        for (int i = 0; i < this.arr.length; i++) {
            if(min == null) {
                min = (T)this.arr[i];
            } else {
                if (min.compareTo(this.arr[i]) < 1) {
                    min = (T) this.arr[i];
                }
            }
        }
        return min;
    }

    T max() {
        T max = null;
        for (int i = 0; i < this.arr.length; i++) {
            if(max == null) {
                max = (T)this.arr[i];
            } else {
                if (max.compareTo(this.arr[i]) > 0) {
                    max = (T) this.arr[i];
                }
            }
        }
        return max;
    }

    boolean delete(T element) {
        boolean flag = false;
        int matchIndex = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if (element.compareTo(this.arr[i]) == 0) {
                flag = true;
                matchIndex = i;
                this.arr[matchIndex] = null;
                break;
            }
        }
        for (int i = matchIndex - 1; i < this.arr.length - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        index--;
        return flag;
    }

    int search(T element) {
        int index = -1;
        for (int i = 0; i < this.arr.length; i++) {
            if (element.compareTo(this.arr[i]) == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    void print() {
        for (Object o : this.arr) {
            System.out.println(o.toString());
        }
    }

    boolean swap(int firstItem, int secondItem) {
        if (firstItem == secondItem ||
                (firstItem < 0 || firstItem > index) ||
                (secondItem < 0 || secondItem > index)
        ) {
            return false;
        } else {
            Object temp = this.arr[firstItem];
            this.arr[firstItem] = this.arr[secondItem];
            this.arr[secondItem] = temp;
            return true;
        }
    }

    static class Osoba implements Comparable<Osoba> {

        private final String imie;
        private final int wiek;

        public Osoba(String imie, int wiek) {
            this.imie = imie;
            this.wiek = wiek;
        }

        public int compareTo(Osoba o) {
            if(o != null) {
                if (o.imie.compareTo(this.imie) == 0) {
                    return Integer.compare(this.wiek, o.wiek);
                } else {
                    return o.imie.compareTo(this.imie);
                }
            } else {
                return -5;
            }
        }
    }


    static class Student extends Osoba {

        private final int numerGrupy;

        public Student(String imie, int wiek, int numerGrupy) {
            super(imie, wiek);
            this.numerGrupy = numerGrupy;
        }

        public int compareTo(Osoba o) {
            if (o instanceof Student s) {
                if (super.compareTo(s) == 0) {
                    return Integer.compare(this.numerGrupy, s.numerGrupy);
                } else {
                    return super.compareTo(s);
                }
            } else {
                return super.compareTo(o);
            }
        }
    }


    static class Test {
        public static void main(String[] args) {
            ArrayBox<Osoba> bo = new ArrayBox<>(2);

            bo.add(new Osoba("Kowalski", 19));                        // nazwisko = "Kowalki", wiek = 19
            bo.add(new Student("Kowalska", 18, 100));                    // nazwisko, wiek, grupa = 100
            bo.add(new Student("Kowalska", 20, 200));

            Osoba[] to = new Osoba[]{new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};
            bo.addAll(to);

            System.out.println(bo.min());                                           // Student 1: Kowalska, 18, 100

            ArrayBox<Student> bst = new ArrayBox<>(1);
            bst.add(new Student("Nowacka", 24, 100));
            bst.add(new Student("Nowacka", 24, 300));
            bst.add(new Student("Nowacka", 24, 200));

            System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

            ArrayBox<Integer> bi = new ArrayBox<>(2);
            Integer[] ti = new Integer[]{1, 2, 3};
            bi.addAll(ti);

            bi.print();                                                                          // 1, 2, 3

            ArrayBox<String> bs = new ArrayBox<>(1);
            String[] ts = new String[]{"cpp", new String("java")};
            bs.addAll(ts);
            bs.swap(0, 1);
            bs.print();                                                                         // java, cpp
        }
    }
}

