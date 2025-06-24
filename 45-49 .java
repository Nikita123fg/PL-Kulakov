 // 45. Конвертация количества лет из Арабских чисел в Римские
 int n1 = sc.nextInt();
 if (n1 <= 1 || n1 >= 10000) {
     System.out.println("Число вне диапазона");
 } else {
     String[] thousands = {"", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};
     String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     String roman = thousands[n1 / 1000] + hundreds[(n1 % 1000) / 100] + tens[(n1 % 100) / 10] + ones[n1 % 10];
     System.out.println(roman);
 }
 // 46. Конвертация количества лет из Римских чисел в Арабские
 String roman2 = sc.next().toUpperCase();
 java.util.Map<Character, Integer> values = new java.util.HashMap<>();
 values.put('I', 1); values.put('V', 5); values.put('X', 10); values.put('L', 50);
 values.put('C', 100); values.put('D', 500); values.put('M', 1000);
 int result = 0, prev = 0;
 for (int i = roman2.length() - 1; i >= 0; i--) {
     int val = values.get(roman2.charAt(i));
     if (val < prev) result -= val;
     else result += val;
     prev = val;
 }
 if (result <= 1 || result >= 10000) {
     System.out.println("Число вне диапазона");
 } else {
     System.out.println(result);
 }
 // 47. Сортировка массива змейкой
 int n = sc.nextInt();
 int size = (int)Math.ceil(Math.sqrt(n));
 int[][] array = new int[size][size];
 int val = 1;
 for (int i = 0; i < size; i++) {
     for (int j = 0; j < size; j++) {
         if (val <= n) array[i][j] = val++;
         else array[i][j] = 0;
     }
 }
 java.util.List<Integer> res = new java.util.ArrayList<>();
 int top = 0, bottom = size - 1, left = 0, right = size - 1;
 while (top <= bottom && left <= right) {
     for (int i = left; i <= right; i++) res.add(array[top][i]);
     top++;
     for (int i = top; i <= bottom; i++) res.add(array[i][right]);
     right--;
     if (top <= bottom) {
         for (int i = right; i >= left; i--) res.add(array[bottom][i]);
         bottom--;
     }
     if (left <= right) {
         for (int i = bottom; i >= top; i--) res.add(array[i][left]);
         left++;
     }
 }
 System.out.println(res);
 // 48. Генерация ряда чисел u без дубликатов
 int limit = sc.nextInt();
 java.util.Set<Integer> set = new java.util.TreeSet<>();
 java.util.Queue<Integer> q = new java.util.LinkedList<>();
 q.add(1); set.add(1);
 while (set.size() < limit) {
     int x = q.poll();
     int y = 2 * x + 1;
     int z = 3 * x + 1;
     if (set.add(y)) q.add(y);
     if (set.add(z)) q.add(z);
 }
 System.out.println(set);
 // 49. Быстрый fib и fusc
 int fibn = sc.nextInt();
 long a = 1, b = 0;
 int m = fibn;
 while (m > 0) {
     long tmp = a;
     a = b;
     b = tmp + b;
     m--;
 }
 System.out.println(a + b);
 int k = sc.nextInt();
 System.out.println(fusc(k));
}

public static int fusc(int n) {
 if (n == 0) return 0;
 if (n == 1) return 1;
 if (n % 2 == 0) return fusc(n / 2);
 else return fusc(n / 2) + fusc(n / 2 + 1);
}