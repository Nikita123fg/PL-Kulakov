 // 28. Простое шифрование Цезаря
 public static void task28(Scanner sc) {
    String s = sc.next();
    int shift = sc.nextInt();
    String dir = sc.next(); // "left" или "right"
    if (dir.equals("left")) shift = -shift;
    String result = "";
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        result += (char)(c + shift);
    }
    System.out.println(result);
}

// 29. Проверка, является ли число разницей двух последовательных квадратов
public static void task29(Scanner sc) {
    int n = sc.nextInt();
    boolean found = false;
    for (int i = 1; i * i - (i - 1) * (i - 1) <= n; i++) {
        if (i * i - (i - 1) * (i - 1) == n) {
            found = true;
            break;
        }
    }
    System.out.println(found);
}

// 30. Проверка суммы степеней цифр
public static void task30(Scanner sc) {
    int num = sc.nextInt();
    int startPow = sc.nextInt();
    String s = "" + num;
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
        int digit = s.charAt(i) - '0';
        int pow = startPow + i;
        int res = 1;
        for (int j = 0; j < pow; j++) res *= digit;
        sum += res;
    }
    if (sum % num == 0) {
        System.out.println("YES, multiplier: " + (sum / num));
    } else {
        System.out.println("NO");
    }
}

// 31. Максимальная сумма расстояний по 3 городам (без коллекций)
public static void task31(Scanner sc) {
    int[] l = new int[5];
    for (int i = 0; i < 5; i++) l[i] = sc.nextInt();
    int t = sc.nextInt(); // максимум километров
    int maxSum = -1;
    for (int i = 0; i < 3; i++)
        for (int j = i + 1; j < 4; j++)
            for (int k = j + 1; k < 5; k++) {
                int sum = l[i] + l[j] + l[k];
                if (sum <= t && sum > maxSum) maxSum = sum;
            }
    System.out.println(maxSum);
}

// 32. i-й Фибоначчи и самая частая цифра
public static void task32(Scanner sc) {
    int n = sc.nextInt();
    String fib = "";
    if (n == 10) fib = "55";
    else {
        long a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        fib = "" + c;
    }
    int[] count = new int[10];
    for (int i = 0; i < fib.length(); i++) count[fib.charAt(i) - '0']++;
    int max = 0, digit = 0;
    for (int i = 0; i < 10; i++) {
        if (count[i] > max || (count[i] == max && i > digit)) {
            max = count[i];
            digit = i;
        }
    }
    System.out.println("[" + max + ", " + digit + "]");
}

// 33. Игра с палочками (ход любого игрока)
public static void task33(Scanner sc) {
    long n = sc.nextLong();
    while (n > 0) {
        if (n % 2 == 0) {
            System.out.println("Можно взять 1 или " + (n / 2));
            n -= 1; // пример хода
        } else {
            System.out.println("Можно взять только 1");
            n -= 1;
        }
    }
}

// 34. Таня начинает, Саша берет максимум
public static void task34(Scanner sc) {
    long n = sc.nextLong();
    boolean tanya = true;
    long tanyaTotal = 0;
    while (n > 0) {
        long take;
        if (n % 2 == 0) {
            take = n / 2 > 1 ? n / 2 : 1;
        } else {
            take = 1;
        }
        if (tanya) tanyaTotal += take;
        n -= take;
        tanya = !tanya;
    }
    System.out.println(tanyaTotal);
}

// 35. Сортировка по сумме цифр
public static void task35(Scanner sc) {
    String line = sc.nextLine();
    String[] arr = line.split(" ");
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            int sum1 = 0, sum2 = 0;
            for (int k = 0; k < arr[i].length(); k++) sum1 += arr[i].charAt(k) - '0';
            for (int k = 0; k < arr[j].length(); k++) sum2 += arr[j].charAt(k) - '0';
            if (sum1 > sum2 || (sum1 == sum2 && arr[i].compareTo(arr[j]) > 0)) {
                String tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
    }
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]);
        if (i < arr.length - 1) System.out.print(" ");
    }
    System.out.println();
}

// 36. Расшифровка Цезаря (перебор сдвигов)
public static void task36(Scanner sc) {
    String encrypted = sc.next();
    for (int shift = 1; shift < 26; shift++) {
        String res = "";
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            res += (char)(c - shift);
        }
        System.out.println("Shift " + shift + ": " + res);
    }
}

// 37. Игра: угадай 4-значный код
public static void task37(Scanner sc) {
    int[] code = {1,2,3,4}; // загаданный код
    int tries = 0;
    while (tries < 20) {
        int[] guess = new int[4];
        for (int i = 0; i < 4; i++) guess[i] = sc.nextInt();
        int matches = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (guess[i] == code[j]) matches++;
        System.out.println("Совпадений: " + matches);
        tries++;
        if (matches == 4) {
            System.out.println("Угадали!");
            break;
        }
    }
}

// 38. Каждый третий выбывает
public static void task38(Scanner sc) {
    int n = sc.nextInt();
    int start = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = i + 1;
    int left = n, idx = start - 1, count = 0;
    int[] out = new int[n];
    while (left > 0) {
        int step = 0;
        while (step < 2) {
            idx = (idx + 1) % n;
            if (arr[idx] != 0) step++;
        }
        while (arr[idx] == 0) idx = (idx + 1) % n;
        out[count++] = arr[idx];
        arr[idx] = 0;
        left--;
    }
    for (int i = 0; i < n; i++) System.out.print(out[i] + " ");
    System.out.println();
}

// 39. Переместить первую букву слова в конец и добавить "ауч"
public static void task39(Scanner sc) {
    String line = sc.nextLine();
    String[] words = line.split(" ");
    for (int i = 0; i < words.length; i++) {
        String w = words[i];
        if (w.length() > 1 && ((w.charAt(0) >= 'A' && w.charAt(0) <= 'Z') || (w.charAt(0) >= 'a' && w.charAt(0) <= 'z') || (w.charAt(0) >= 'А' && w.charAt(0) <= 'Я') || (w.charAt(0) >= 'а' && w.charAt(0) <= 'я'))) {
            System.out.print(w.substring(1) + w.charAt(0) + "ауч");
        } else {
            System.out.print(w);
        }
        if (i < words.length - 1) System.out.print(" ");
    }
    System.out.println();
    }
