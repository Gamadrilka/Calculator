package NEWCALCUL;
import java.util.Scanner;

 class Main {
    static Scanner sc = new Scanner(System.in);
    static char operation;
    static int number1, number2;
    static int result;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение: ");
        calc(sc.next());
    }

    public static String calc(String input) throws Exception {
        Convertor convertor = new Convertor();
        MiniCalcul MiniCalcul1 = new MiniCalcul();
        char[] symbol = new char[10];
        for (int i = 0; i < input.length(); i++) {
            symbol[i] = input.charAt(i);
            if (symbol[i] == '+') {
                operation = '+';
            } else if (symbol[i] == '-') {
                operation = '-';
            } else if (symbol[i] == '*') {
                operation = '*';
            } else if (symbol[i] == '/') {
                operation = '/';
            }
        }
        String symbolString = String.valueOf(symbol);
        if (symbolString.contains("+") || symbolString.contains("/") || symbolString.contains("-") || symbolString.contains("*")) {
            String[] split = symbolString.split("[+*-/]");
            String stroka1 = split[0];
            String stroka2 = split[1];
            if (split.length>2) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
                String probel1 = stroka1.trim();
                String probel2 = stroka2.trim();
                if ((probel1.contains("I") || probel1.contains("II") || probel1.contains("III") || probel1.contains("IV") || probel1.contains("V") ||
                        probel1.contains("VI") || probel1.contains("VII") || probel1.contains("VIII") || probel1.contains("IX") || probel1.contains("X")) &&
                        (probel2.contains("I") || probel2.contains("II") || probel2.contains("III") || probel2.contains("IV") || probel2.contains("V") ||
                                probel2.contains("VI") || probel2.contains("VII") || probel2.contains("VIII") || probel2.contains("IX") || probel2.contains("X"))) {
                    number1 = convertor.RomanToArab(probel1);
                    number2 = convertor.RomanToArab(probel2);
                    if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) {
                        result = MiniCalcul1.minicalcul(number1, number2, operation);
                        String RomanZapis = convertor.convertNumToRoman(result);
                        if (result <= 0) {
                            throw new Exception("В римской системе нет отрицательных чисел");
                        }
                        System.out.println("Реузультат: " + probel1 + " " + operation + " " + probel2 + " = " + RomanZapis);
                    } else {
                        throw new Exception("Значение должно быть от 1 и меньше 10");
                    }
                } else if ((probel1.contains("1") || probel1.contains("2") || probel1.contains("3") || probel1.contains("4") || probel1.contains("5") ||
                        probel1.contains("6") || probel1.contains("7") || probel1.contains("8") || probel1.contains("8") || probel1.contains("10")) &&
                        (probel2.contains("1") || probel2.contains("2") || probel2.contains("3") || probel2.contains("4") || probel2.contains("5") ||
                                probel2.contains("6") || probel2.contains("7") || probel2.contains("8") || probel2.contains("9") || probel2.contains("10"))) {
                    number1 = Integer.parseInt(probel1);
                    number2 = Integer.parseInt(probel2);
                    if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) {
                        result = MiniCalcul1.minicalcul(number1, number2, operation);
                        System.out.println("Результат: " + number1 + " " + operation + " " + number2 + " = " + result);
                    } else {
                        throw new Exception("Значение должно быть от 1 и меньше 10");
                    }
                } else {
                    throw new Exception("Используются одновременно разные системы счисления");
                }
            }else{
                throw new Exception("Неверный знак операции");
            }
            return input;
        }
    }















