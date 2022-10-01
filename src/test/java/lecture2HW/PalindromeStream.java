package lecture2HW;

import java.util.stream.IntStream;

public class PalindromeStream {


    public static void main(String[] args) {
        isPalindromeUsingIntStream("Madam, I'm Adam!");
    }

    public static void isPalindromeUsingIntStream(String text) {
        String temp = text.replaceAll("\\W+", "").toLowerCase();
        if (IntStream.range(0, temp.length() / 2).noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1))) {
            System.out.println("Фраза является палиндромом");
        } else
            System.out.println("Фраза не является палиндромом");
    }

}


