package myprograms;

public class DecToBin {

    public static void main(String[] args) {

        System.out.println(binaryNumber(173));
        System.out.println(binaryNumber(347));
        System.out.println(binaryNumber(1));
        System.out.println(binaryNumber(2));
        System.out.println(binaryNumber(67));
        System.out.println(binaryNumber(125));

    }

    public static int binaryNumber(int decNumber) {
        int number = decNumber;
        int binNumber = 0;
        int count = 1;
        while (number >= 1) {
            int tempNumber = number;
            binNumber += (tempNumber % 2) * count;
            number /= 2;
            count *= 10;
        }
        return binNumber;
    }

}
