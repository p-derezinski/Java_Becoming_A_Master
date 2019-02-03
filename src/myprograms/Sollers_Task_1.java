package myprograms;

import java.util.ArrayList;
import java.util.List;

public class Sollers_Task_1 {

    public static void main(String[] args) {

        System.out.println("a = 0, b = 0   -   " + solution_3(0, 0));
        System.out.println("a = 0, b = 1   -   " + solution_3(0, 1));
        System.out.println("a = 1, b = 1   -   " + solution_3(1, 1));
        System.out.println("a = 3, b = 2   -   " + solution_3(3, 2));
        System.out.println("a = 4, b = 1   -   " + solution_3(4, 1));
        System.out.println("a = 4, b = 2   -   " + solution_3(4, 2));
        System.out.println("a = 4, b = 3   -   " + solution_3(4, 3));
        System.out.println("a = 4, b = 4   -   " + solution_3(4, 4));
        System.out.println("a = 1, b = 4   -   " + solution_3(1, 4));
        System.out.println("a = 2, b = 4   -   " + solution_3(2, 4));
        System.out.println("a = 3, b = 4   -   " + solution_3(3, 4));
        System.out.println("a = 4, b = 10  -   " + solution_3(4, 10));
        System.out.println("a = 10, b = 4  -   " + solution_3(10, 4));
        System.out.println("a = 10, b = 10 -   " + solution_3(10, 10));
        System.out.println("a = 10, b = 9  -   " + solution_3(10, 9));
    }

    // The final solution
    public static String solution_3(int A, int B) {
        int higher;
        int lower;
        String higherLetter;
        String lowerLetter;
        if (A >= B) {
            higher = A;
            lower = B;
            higherLetter = "a";
            lowerLetter = "b";
        } else {
            higher = B;
            lower = A;
            higherLetter = "b";
            lowerLetter = "a";
        }
        StringBuilder sb = new StringBuilder();
        int countHigher = 0;
        int counter = 1;
        List<String> array = new ArrayList<>();

        for (int i = 1; i <= (lower * 3); i++) {
            if (i % 3 == 0) {
                array.add(lowerLetter);
            } else if (i % 3 == 1) {
                array.add(higherLetter);
                countHigher++;
            } else {
                array.add("");
            }
        }
        if (countHigher != higher) {
            array.add(higherLetter);
            countHigher++;
        }
        array.add("");
        while (countHigher != higher) {
            array.set(counter, higherLetter);
            countHigher++;
            counter += 3;
        }
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
        }
        return sb.toString();
    }


    // This is my original solution submitted to Sollers New Year,s IT Challenge.
    // The solution is wrong.
    public static String solution_1(int A, int B) {
        StringBuilder sb = new StringBuilder();
        int countA = 0;
        int countB = 0;
        char[] currentString = new char[0];
        int currentLength = currentString.length;
        String lastTwo;
        if (A == 0 && B == 0) {
            return "";
        }
        if (A == 0 && B == 1) {
            return "b";
        }
        if (A == 0 && B == 2) {
            return "bb";
        }
        if (A == 1 && B == 0) {
            return "a";
        }
        if (A == 2 && B == 0) {
            return "aa";
        }
        if (A > B) {
            sb.append("aa");
            countA += 2;
            while (countA < A || countB < B) {
                currentString = sb.toString().toCharArray();
                currentLength = currentString.length;
                lastTwo = sb.toString().substring(currentLength - 2, currentLength);
                if (countA == A) {
                    sb.append("b");
                    countB++;
                } else if (lastTwo.equals("aa")) {
                    sb.append("b");
                    countB++;
                } else if (lastTwo.equals("bb")) {
                    sb.append("a");
                    countA++;
                } else if (lastTwo.equals("ab")) {
                    sb.append("a");
                    countA++;
                } else if (lastTwo.equals("ba")) {
                    sb.append("a");
                    countA++;
                }
            }
        } else if (A < B){
            sb.append("bb");
            countB += 2;
            while (countA < A || countB < B) {
                currentString = sb.toString().toCharArray();
                currentLength = currentString.length;
                lastTwo = sb.toString().substring(currentLength - 2, currentLength);
                if (countB == B) {
                    sb.append("a");
                    countA++;
                } else if (lastTwo.equals("aa")) {
                    sb.append("b");
                    countB++;
                } else if (lastTwo.equals("bb")) {
                    sb.append("a");
                    countA++;
                } else if (lastTwo.equals("ab")) {
                    sb.append("b");
                    countB++;
                } else if (lastTwo.equals("ba")) {
                    sb.append("b");
                    countB++;
                }
            }
        } else {
            sb.append("aa");
            countA += 2;
            while (countA < A || countB < B) {
                currentString = sb.toString().toCharArray();
                currentLength = currentString.length;
                lastTwo = sb.toString().substring(currentLength - 2, currentLength);
                if (countA == A) {
                    sb.append("b");
                    countB++;
                } else if (lastTwo.equals("aa")) {
                    sb.append("b");
                    countB++;
                } else if (lastTwo.equals("bb")) {
                    sb.append("a");
                    countA++;
                } else if (lastTwo.equals("ab")) {
                    sb.append("a");
                    countA++;
                } else if (lastTwo.equals("ba")) {
                    sb.append("b");
                    countB++;
                }
            }
        }
        return sb.toString();
    }

}
