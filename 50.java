import java.io.*;
import java.util.Scanner;

public class Calculator {
    private static final String HISTORY_FILE = "history.txt";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;
            if (input.equals("history")) {
                printHistory();
                continue;
            }
            try {
                double result = evaluate(input);
                System.out.println(result);
                saveToHistory(input + " = " + result);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

    private static void saveToHistory(String record) throws Exception {
        FileWriter fw = new FileWriter(HISTORY_FILE, true);
        fw.write(record + "\n");
        fw.close();
    }

    private static void printHistory() throws Exception {
        File file = new File(HISTORY_FILE);
        if (!file.exists()) return;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    private static double evaluate(String expr) throws Exception {
        expr = expr.replace(" ", "");
        expr = handleAbs(expr);
        expr = handlePow(expr);
        expr = handleDivInt(expr);
        return simpleEval(expr);
    }

    private static String handleAbs(String expr) throws Exception {
        while (expr.contains("|")) {
            int start = expr.indexOf('|');
            int end = expr.indexOf('|', start + 1);
            if (end == -1) throw new Exception();
            String inside = expr.substring(start + 1, end);
            double val = Math.abs(evaluate(inside));
            expr = expr.substring(0, start) + val + expr.substring(end + 1);
        }
        return expr;
    }

    private static String handlePow(String expr) throws Exception {
        while (expr.contains("^")) {
            int idx = expr.indexOf('^');
            int left = idx - 1;
            while (left >= 0 && (Character.isDigit(expr.charAt(left)) || expr.charAt(left) == '.' || expr.charAt(left) == '-')) left--;
            int right = idx + 1;
            while (right < expr.length() && (Character.isDigit(expr.charAt(right)) || expr.charAt(right) == '.' || expr.charAt(right) == '-')) right++;
            double base = Double.parseDouble(expr.substring(left + 1, idx));
            double pow = Double.parseDouble(expr.substring(idx + 1, right));
            double res = Math.pow(base, pow);
            expr = expr.substring(0, left + 1) + res + expr.substring(right);
        }
        return expr;
    }

    private static String handleDivInt(String expr) throws Exception {
        while (expr.contains("//")) {
            int idx = expr.indexOf("//");
            int left = idx - 1;
            while (left >= 0 && (Character.isDigit(expr.charAt(left)) || expr.charAt(left) == '.' || expr.charAt(left) == '-')) left--;
            int right = idx + 2;
            while (right < expr.length() && (Character.isDigit(expr.charAt(right)) || expr.charAt(right) == '.' || expr.charAt(right) == '-')) right++;
            double a = Double.parseDouble(expr.substring(left + 1, idx));
            double b = Double.parseDouble(expr.substring(idx + 2, right));
            double res = (int)(a / b);
            expr = expr.substring(0, left + 1) + res + expr.substring(right);
        }
        return expr;
    }

    private static double simpleEval(String expr) throws Exception {
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '*' || c == '/' || c == '%') {
                double a = Double.parseDouble(expr.substring(0, i));
                double b = Double.parseDouble(expr.substring(i + 1));
                if (c == '*') return a * b;
                if (c == '/') return a / b;
                if (c == '%') return a % b;
            }
        }
        for (int i = 1; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+') {
                double a = Double.parseDouble(expr.substring(0, i));
                double b = Double.parseDouble(expr.substring(i + 1));
                return a + b;
            }
            if (c == '-') {
                double a = Double.parseDouble(expr.substring(0, i));
                double b = Double.parseDouble(expr.substring(i + 1));
                return a - b;
            }
        }
        return Double.parseDouble(expr);
    }
}