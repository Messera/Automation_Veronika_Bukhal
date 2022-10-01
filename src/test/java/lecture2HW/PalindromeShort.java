package lecture2HW;

public class PalindromeShort {

    public static void main(String[] args) {

        String s = "А роза упала на лапу Азора";

        if (s.replaceAll("\\W", "").
                equalsIgnoreCase(new StringBuilder(s.replaceAll("\\W", "")).reverse().toString())) {

            System.out.println("Фраза является палиндромом");

        } else {

            System.out.println("Фраза не является палиндромом");

        }

    }
}
