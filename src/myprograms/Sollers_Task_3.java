package myprograms;

public class Sollers_Task_3 {

    public static void main(String[] args) {

        String slowo = "1250";
        int testowy = Integer.parseInt(slowo);
        System.out.println(testowy);

        int[] A = { 3, 5, 1 };
        int[] B = { 0, 7, 2, 0, 4, 9, 0 };
        System.out.println(solution_1(A));
        System.out.println(solution_2(A));
        System.out.println(solution_1(B));
        System.out.println(solution_2(B));
    }

    public static int solution_1(int[] A) {
        StringBuilder sb = new StringBuilder();
        for (int i = A.length; i > 0; i--) {
            sb.append("" + A[i - 1]);
        }
        int number = Integer.parseInt(sb.toString());
        number *= 17;
        String newNumber = "" + number;
        char[] array = newNumber.toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            String stringNumberFromChar = Character.toString(array[i]);
            int intNumberFromChar = Integer.parseInt(stringNumberFromChar);
            sum += intNumberFromChar;
        }
        return sum;
    }

    public static int solution_2(int[] A) {
        int number = 0;
        int multiplyFactor = 1;
        for (int i = 0; i < A.length; i++) {
            number += A[i] * multiplyFactor;
            multiplyFactor *= 10;
        }
        number *= 17;
        int sum = 0;
        while (number > 0) {
            int copyNumber = number;
            sum += copyNumber % 10;
            number /= 10;
        }
        return sum;
    }

}
