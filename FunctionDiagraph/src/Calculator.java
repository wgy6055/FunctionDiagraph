/**
 * Created by WangGuanyu on 16/3/1.
 */
//Calculator.java Class for calculator
import java.util.Stack;

public class Calculator {
    private double Value;
    public double getValue() {
        return Value;
    }

    //Priority of Operators: +、-、*、/、(、)、#、SPECIAL FUNCTION、^
    public static final char[][] RELATION = {{'>','>','<','<','<','>','>','A','<'},
            {'>','>','<','<','<','>','>','A','<'},{'>','>','>','>','<','>','>','A','<'},
            {'>','>','>','>','<','>','>','A','<'},{'<','<','<','<','<','=','!','A','<'},
            {'>','>','>','>','!','>','>','!','<'},{'<','<','<','<','<','!','=','A','<'},
            {'<','<','<','<','<','=','!','A','<'},{'>','>','>','>','<','>','>','A','>'}};
    public static final char[] SPECIAL_FUNCION= {'#','s','c','t','l','S','C','T'};
    public void calc(String exp, double x) {
        //Number Stack
        Stack<Double> num = new Stack<Double>();
        //Operator Stack
        Stack<Character> op = new Stack<Character>();

        op.add('#');
        int i = 0;
        int[] index = new int[5];
        int count = 0;
        char ch = exp.charAt(i);
        int flag0 = 0;
        boolean flag = false;
        while(ch != '#' || op.peek() != '#') {
            if((ch >= '0' && ch <= '9')||(ch == 'π')||(ch == 'x')||(ch == 'e')) {
                if(ch == 'x') {
                    num.push((double)x);
                }
                else {
                    if(ch == 'π') {
                        num.push(Math.PI);
                    }
                    else {
                        if(ch == 'e') {
                            num.push(Math.E);
                        }
                        else {
                            if(flag) {
                                double tmp = num.pop();
                                num.push(tmp * 10 + Double.parseDouble(ch + ""));
                            }
                            else {
                                num.push(Double.parseDouble(ch + ""));
                            }
                        }
                    }

                }
                flag = true;
                i++;
            } else {
                flag = false;
                switch(precede(op.peek(), ch)) {
                    case '<':
                        op.push(ch);
                        i++;
                        if(flag0>0) {
                            count++;
                        }

                        break;
                    case '=':
                        if(flag0>0&&ch == ')'&&count == 0) {
                            double num3 = num.pop();
                            double result = operate(num3, SPECIAL_FUNCION[index[flag0-1]]);
                            flag0--;
                            num.push(result);
                            op.pop();
                        }
                        else {
                            op.pop();
                            if(flag0>0) {
                                count--;
                            }

                        }
                        i++;
                        break;
                    case '>':
                        double num1 = num.pop();
                        double num2 = num.pop();
                        double result = operate(num1, op.pop(), num2);
                        num.push(result);
                        if(flag0>0) {
                            count--;
                        }
                        break;
                    case '!':
                        i++;
                        break;
                    case 'A':
                        op.push(ch);
                        flag0++;
                        switch(ch) {
                            case 's':
                                index[flag0-1] = 1;
                                i+=4;
                                break;
                            case 'c':
                                index[flag0-1] = 2;
                                i+=4;
                                break;
                            case 't':
                                index[flag0-1] = 3;
                                i+=4;
                                break;
                            case 'l':
                                index[flag0-1] = 4;
                                i+=4;
                                break;
                            case 'a':
                                switch(exp.charAt(i+3)) {
                                    case 's':
                                        index[flag0-1] = 5;
                                        i+=7;
                                        break;
                                    case 'c':
                                        index[flag0-1] = 6;
                                        i+=7;
                                        break;
                                    case 't':
                                        index[flag0-1] = 7;
                                        i+=7;
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            ch = exp.charAt(i);
        }
        Value = num.peek();
    }
    private static char precede(char peek, char ch) {
        return RELATION[getIndex(peek)][getIndex(ch)];
    }


    private static int getIndex(char ch) {
        int index = -1;
        switch(ch) {
            case '+':
                index = 0;
                break;
            case '-':
                index = 1;
                break;
            case '*':
                index = 2;
                break;
            case '/':
                index = 3;
                break;
            case '(':
                index = 4;
                break;
            case ')':
                index = 5;
                break;
            case '#':
                index = 6;
                break;
            case 's':
                index = 7;
                break;
            case 'c':
                index = 7;
                break;
            case 't':
                index = 7;
                break;
            case 'a':
                index = 7;
                break;
            case 'l':
                index = 7;
                break;
            case '^':
                index = 8;
                break;
        }
        return index;
    }


    private static double operate(double num1, char ch, double num2) {
        double result = 0;
        switch(ch) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '^':
                result = Math.pow(num2, num1);
                break;
        }
        return result;
    }

    private static double operate(double num, char ch) {
        double result = 0;
        switch(ch) {
            case 's':
                result = Math.sin(num);
                break;
            case 'c':
                result = Math.cos(num);
                break;
            case 't':
                result = Math.tan(num);
                break;
            case 'l':
                result = Math.log(num);
                break;
            case 'S':
                if(num<-1||num>1) {
                    result = 0;
                    break;
                }
                result = Math.asin(num);
                break;
            case 'C':
                if(num<-1||num>1) {
                    result = 0;
                    break;
                }
                result = Math.acos(num);
                break;
            case 'T':
                result = Math.atan(num);
                break;
        }
        return result;
    }
}

