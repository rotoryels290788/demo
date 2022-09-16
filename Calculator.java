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
            System.out.println("������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *).");
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
                        System.out.println("���� �� ��� ��� ������ ������ X (10),��������� ���� �����.");
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
                            System.out.println("� ������� ������� ��� ���� � ������������� �����,��������� ���� �����.");
                            return input;
                        }
                    } else if (arr[1].equals(u)) {
                        System.out.println(Roman.values()[prz - 1]);
                        return input;
                    } else if (arr[1].equals(d)) {
                        System.out.println(Roman.values()[del - 1]);
                        return input;
                    } else {
                        System.out.println("���� ��������������� �������� ������ �� ��������,��������� ���� ��������������� �������� ����� ������ (I + II).");
                        return input;
                    }
                }
            }
        } catch (IllegalArgumentException error2) {
            System.out.println("�� ����� ������������ ������ ������� ���������,��������� ���� �����.");
            return input;
        } catch (ArrayIndexOutOfBoundsException error3) {
            System.out.println("��������� �������� �� �������� �������������� ���������,��������� ���� �����.");
            return input;
        }

        try {
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[2]);

            if (x < 1 || x > 10 || y < 1 || y > 10) {
                System.out.println("�������� ����� �� ������ ���� ������ 1 ��� ������ 10,��������� ���� ����� (1 + 10).");
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
                System.out.println("���� ��������������� �������� ������ �� ��������,��������� ���� ��������������� �������� ����� ������ (2 + 2).");
            }

        } catch (NumberFormatException error5) {
            System.out.println("������ �� �������� �������������� ���������,��������� ���� �����.");
        }
          return input;
    }

    public static void main(String[] args) {
        System.out.println("��� ������������ ����������� V 1.007.\n����������� ��������� �� ���� �������� � ������� �����.\n��������� ����� �� ������ ���� ������ 1 ��� ������ 10(I ��� X).\n��������� ����� ������ �������� ����� ������ (1 + 1) ��� �� ���������� ����� ��������� �������.\n����������� ����� �������� ������������ ������ � �������� ��� ��������� �������.\n����������� ����� ��������� (+, -, /, *).\n");
        System.out.println("������� �������������� ��������.");
        Scanner sc = new Scanner(System.in);
        calc(sc.nextLine());

    }
}















