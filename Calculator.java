package Calc;

import java.util.Scanner;

public class Calculator {
    enum Roman {
        I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"), VIII("8"), IX("9"), X("10"),
        XI("11"), XII("12"), XIII("13"), XIV("14"), XV("15"), XVI("16"), XVII("17"), XVIII("18"), XIX("19"), XX("20"),
        XXI("21"), XXII("22"), XXIII("23"), XXIV("24"), XXV("25"), XXVI("26"), XXVII("27"), XXVIII("28"), XXIX("29"), XXX("30"),
        XXXI("31"), XXXII("32"), XXXIII("33"), XXXIV("34"), XXXV("35"), XXXVI("36"), XXXVII("37"), XXXVIII("38"), XXXIX("39"), XL("40"),
        XLI("41"), XLII("42"), XLIII("43"), XLIV("44"), XLV("45"), XLVI("46"), XLVII("47"), XLVIII("48"), XLIX("49"), L("50"),
        LI("51"), LII("52"), LIII("53"), LIV("54"), LV("55"), LVI("56"), LVII("57"), LVIII("58"), LIX("59"), LX("60"),
        LXI("61"), LXII("62"), LXIII("63"), LXIV("64"), LXV("65"), LXVI("66"), LXVII("67"), LXVIII("68"), LXIX("69"), LXX("70"),
        LXXI("71"), LXXII("72"), LXXIII("73"), LXXIV("74"), LXXV("75"), LXXVI("76"), LXXVII("77"), LXXVIII("78"), LXXIX("79"), LXXX("80"),
        LXXXI("81"), LXXXII("82"), LXXXIII("83"), LXXXIV("84"), LXXXV("85"), LXXXVI("86"), LXXXVII("87"), LXXXVIII("88"), LXXXIX("89"), XC("90"),
        XCI("91"), XCII("92"), XCIII("93"), XCIV("94"), XCV("95"), XCVI("96"), XCVII("97"), XCVIII("98"), XCIX("99"), C("100");


        private final String translation;

        Roman(String translation) {
            this.translation = translation;
        }

        public String getTranslation() {

            return translation;
        }
    }

        public static String calc(String input) {

            String p = "+";
            String m = "-";
            String u = "*";
            String d = "/";

            String[] arr = input.split(" ");

            if (arr.length > 3) {
                System.out.println("ôîðìàò ìàòåìàòè÷åñêîé îïåðàöèè íå óäîâëåòâîðÿåò çàäàíèþ - äâà îïåðàíäà è îäèí îïåðàòîð (+, -, /, *).");
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
                            System.out.println("Îäíî èç èëè îáà ÷èñåëà áîëüøå X (10),ïîâòîðèòå ââîä ÷èñåë.");
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
                                System.out.println("Â ðèìñêîé ñèñòåìå íåò íóëÿ è îòðèöàòåëüíûõ ÷èñåë,ïîâòîðèòå ââîä ÷èñåë.");
                                return input;
                            }
                        } else if (arr[1].equals(u)) {
                            System.out.println(Roman.values()[prz - 1]);
                            return input;
                        } else if (arr[1].equals(d)) {
                            System.out.println(Roman.values()[del - 1]);
                            return input;
                        } else {
                            System.out.println("Çíàê àðèôìåòè÷åñêîãî äåéñòâèÿ ââåäåí íå êîðåêòíî,ïîâòîðèòå ââîä àðèôìåòè÷åñêîãî äåéñòâèÿ ÷åðåç ïðîáåë (I + II).");
                            return input;
                        }
                    }
                }
            } catch (IllegalArgumentException error2) {
                System.out.println("Âû ââåëè îäíîâðåìåííî ðàçíûå ñèñòåìû ñ÷èñëåíèÿ,ïîâòîðèòå ââîä ÷èñåë.");
                return input;
            } catch (ArrayIndexOutOfBoundsException error3) {
                System.out.println("Ââåäåííîå çíà÷åíèå íå ÿâëÿåòñÿ ìàòåìàòè÷åñêîé îïåðàöèåé,ïîâòîðèòå ââîä ÷èñåë.");
                return input;
            }

            try {
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[2]);

                if (x < 1 || x > 10 || y < 1 || y > 10) {
                    System.out.println("Ââåäåíîå ÷èñëî íå äîëæíî áûòü ìåíüøå 1 èëè áîëüøå 10,ïîâòîðèòå ââîä ÷èñåë (1 + 10).");
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
                    System.out.println("Çíàê àðèôìåòè÷åñêîãî äåéñòâèÿ ââåäåí íå êîðåêòíî,ïîâòîðèòå ââîä àðèôìåòè÷åñêîãî äåéñòâèÿ ÷åðåç ïðîáåë (2 + 2).");
                }

            } catch (NumberFormatException error5) {
                System.out.println("ñòðîêà íå ÿâëÿåòñÿ ìàòåìàòè÷åñêîé îïåðàöèåé,ïîâòîðèòå ââîä ÷èñåë.");
            }
            return input;
        }

        public static void main(String[] args) {
            System.out.println("Âàñ ïðèâåòñòâóåò êàëüêóëÿòîð V 1.007.\nÊàëüêóëÿòîð ïðèíèìàåò íà âõîä àðàáñêèå è ðèìñêèå öèôðû.\nÂâåäåííûå öèôðû íå äîëæíû áûòü ìåíüøå 1 èëè áîëüøå 10(I èëè X).\nÂâåäåííûå ÷èñëà äîëæíû ââîäèòñÿ ÷åðåç ïðîáåë (1 + 1) ïðè íå ïðàâèëüíîì ââîäå ïîâòîðèòå ïîïûòêó.\nÊàëüêóëÿòîð óìååò ðàáîòàòü îäíîâðåìåííî òîëüêî ñ ðèìñêèìè èëè àðàáñêèìè öèôðàìè.\nÊàëüêóëÿòîð óìååò âûïîëíÿòü (+, -, /, *).\n");
            System.out.println("Ââåäèòå àðåôìèòè÷åñêóþ îïåðàöèþ.");
            Scanner sc = new Scanner(System.in);
            calc(sc.nextLine());

        }



}



)








