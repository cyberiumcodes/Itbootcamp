import java.util.Stack;

public class Zadatak3 {
    public static void main(String[] args) {
        System.out.println(isValidBraces("()()()")); // true
        System.out.println(isValidBraces("(((([{}()]))))")); //true
        System.out.println(isValidBraces("(((")); // false
        System.out.println(isValidBraces(")")); // false
        System.out.println(isValidBraces("()(()")); // false
        System.out.println(isValidBraces("({[]})")); // true

    }
    public static boolean isValidBraces(String el){
        Stack<Character> stack = new Stack<>();
        boolean isValid = false;
        char[] characters = el.toCharArray();
        for (char ch:
             characters) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) return false;
        for (var cht :
                characters) {
            if (cht == ')' || cht == '}' || cht == ']') {
                char temp = stack.pop();
                    switch (cht) {
                        case ')':
                            if ('(' == temp) isValid = true;
                            break;
                        case '}':
                            if ('{' == temp) isValid = true;
                            break;
                        case ']':
                            if ('[' == temp) isValid = true;
                            break;
                        default:
                            isValid = false;
                    }
                }
            }
        if (!stack.isEmpty()) isValid = false;
        return isValid;
    }
}
