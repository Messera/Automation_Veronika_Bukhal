package lecture2HW;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {

        String s = "А роза упала на лапу Азора";
        char[] chars = s.toLowerCase().toCharArray();
        List<String> list = new ArrayList<>();

        for (char c : chars) {
            if (!String.valueOf(c).equals(" "))
                list.add(String.valueOf(c));
        }

        System.out.println(list);

        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list.get(list.size() - 1 - i)))
                count++;
        }

        if (count == list.size()) {
            System.out.println("Фраза является палиндромом");
        } else
            System.out.println("Фраза не является палиндромом");

    }

}
