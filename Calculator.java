package Calc.src;

import java.util.Scanner;

public class Calculator {

    public static String calc(String input) {

        String p = "+";
        String m = "-";
        String u = "*";
        String d = "/";

        String[] arr = input.split(" ");

        if (arr.length > 3) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
            return input;
        }
        try {
            for (Roman value : Roman.values()) {

                if (arr[0].contains(value.toString()) || arr[2].contains(value.toString())) {

                    Roman s = Roman.valueOf(arr[0]);
                    Roman z = Roman.valueOf(arr[2]);
                    int x = Integer.parseInt(s.getTranslation());
                    int y = Integer.parseInt(z.getTranslation());

                    if (x < 1 || x > 10 || y < 1 || y > 10) {
                        System.out.println("Одно из или оба чисела больше X (10),повторите ввод чисел.");
                        return input;
                    }

                    int sum = x + y;
                    int prz = x * y;
                    int del = x / y;
                    int min = x - y;

                    if (arr[1].equals(p)) {
                        System.out.println(Roman.values()[sum - 1]);
                        return input;
                    } else if (arr[1].equals(m)) {
                        try {
                            System.out.println(Roman.values()[min - 1]);
                            return input;
                        } catch (ArrayIndexOutOfBoundsException error1) {
                            System.out.println("В римской системе нет нуля и отрицательных чисел,повторите ввод чисел.");
                            return input;
                        }
                    } else if (arr[1].equals(u)) {
                        System.out.println(Roman.values()[prz - 1]);
                        return input;
                    } else if (arr[1].equals(d)) {
                        System.out.println(Roman.values()[del - 1]);
                        return input;
                    } else {
                        System.out.println("Знак арифметического действия введен не коректно,повторите ввод арифметического действия через пробел (I + II).");
                        return input;
                    }
                }
            }
        } catch (IllegalArgumentException error2) {
            System.out.println("Вы ввели одновременно разные системы счисления,повторите ввод чисел.");
            return input;
        } catch (ArrayIndexOutOfBoundsException error3) {
            System.out.println("Введенное значение не является математической операцией,повторите ввод чисел.");
            return input;
        }

        try {
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[2]);

            if (x < 1 || x > 10 || y < 1 || y > 10) {
                System.out.println("Введеное число не должно быть меньше 1 или больше 10,повторите ввод чисел (1 + 10).");
                return input;
            }

            if (arr[1].equals(p)) {
                System.out.println(x + y);

            } else if (arr[1].equals(m)) {
                System.out.println(x - y);
            } else if (arr[1].equals(u)) {
                System.out.println(x * y);
            } else if (arr[1].equals(d)) {
                System.out.println(x / y);
            } else {
                System.out.println("Знак арифметического действия введен не коректно,повторите ввод арифметического действия через пробел (2 + 2).");
            }

        } catch (NumberFormatException error5) {
            System.out.println("строка не является математической операцией,повторите ввод чисел.");
        }
          return input;
    }

    public static void main(String[] args) {
        System.out.println("Вас приветствует калькулятор V 1.007.\nКалькулятор принимает на вход арабские и римские цифры.\nВведенные цифры не должны быть меньше 1 или больше 10(I или X).\nВведенные числа должны вводится через пробел (1 + 1) при не правильном вводе повторите попытку.\nКалькулятор умеет работать одновременно только с римскими или арабскими цифрами.\nКалькулятор умеет выполнять (+, -, /, *).\n");
        System.out.println("Введите арефмитическую операцию.");
        Scanner sc = new Scanner(System.in);
        calc(sc.nextLine());

    }
}















