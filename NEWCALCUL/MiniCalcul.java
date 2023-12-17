package NEWCALCUL;

public class MiniCalcul {
    public int minicalcul(int num1, int num2, char symbol) throws Exception {
        int result = 0;
            switch (symbol) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            return result;
        }
    }

