package myprograms;

public class Testing {

    public static void main(String[] args) {

//        double d100 = Math.random() * 100;
//        System.out.println(d100);
//        double d100_2 = Math.floor(d100) + 1;
//        System.out.println(d100_2);
//        int i100 = (int) d100 + 1;
//        System.out.println(i100);

//        String testowy = "abcdefghij";
//        char[] testowaTablica = testowy.toCharArray();
//        int dlugoscTablicy = testowaTablica.length;
//        System.out.println(dlugoscTablicy);
//        String dwaOstatnie = testowy.substring(dlugoscTablicy - 2, dlugoscTablicy);
//        System.out.println(dwaOstatnie);

        System.out.println("-------------------------------------");

        Object object1 = new Object();
        System.out.println("object1:");
        System.out.println("- Metoda toString() - " + object1);
        System.out.println("- Metoda hashCode() - " + object1.hashCode());

        Object object2 = new Object();
        Object object3 = object1;

        System.out.println("object2:\n- Metoda toString() - " + object2 + "\n- Metoda hashCode() - " + object2.hashCode());
        System.out.println("object3:\n- Metoda toString() - " + object3 + "\n- Metoda hashCode() - " + object3.hashCode());

        System.out.println("Czy object1 equals object2? - " + object1.equals(object2));
        System.out.println("Czy object1 equals object3? - " + object1.equals(object3));

    }

}
