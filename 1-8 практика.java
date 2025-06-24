    // 1. Проверка окончания строки
    public static void task1(Scanner sc) {
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean isEnding = true;
        if (s2.length() > s1.length()) {
            isEnding = false;
        } else {
            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(s1.length() - s2.length() + i) != s2.charAt(i)) {
                    isEnding = false;
                    break;
                }
            }
        }
        System.out.println(isEnding);
    }

    // 2. Приветствие с правильным регистром
    public static void task2(Scanner sc) {
        String name = sc.nextLine();
        String result = "";
        if (name.length() > 0) {
            result += Character.toUpperCase(name.charAt(0));
            for (int i = 1; i < name.length(); i++) {
                result += Character.toLowerCase(name.charAt(i));
            }
        }
        System.out.println("Привет, " + result + "!");
    }

    // 3. Удаление всех гласных
    public static void task3(Scanner sc) {
        String s = sc.nextLine();
        String vowels = "аеёиоуыэюяaeiouyАЕЁИОУЫЭЮЯAEIOUY";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isVowel = false;
            for (int j = 0; j < vowels.length(); j++) {
                if (c == vowels.charAt(j)) {
                    isVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                result += c;
            }
        }
        System.out.println(result);
    }

    // 4. Квадраты чисел с шагом (минимальное число - шаг)
    public static void task4(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int step = a < b ? a : b;
        int end = a > b ? a : b;
        for (int i = step; i <= end; i += step) {
            System.out.print((i * i));
            if (i + step <= end) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // 5. Ряд с шагом и количеством шагов
    public static void task5(Scanner sc) {
        int start = sc.nextInt();
        int step = sc.nextInt();
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print((start + i * step));
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // 6. Ячейка памяти на три числа
    public static void task6(Scanner sc) {
        int[] memory = new int[3];
        int size = 0;
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (size < 3) {
                memory[size] = n;
                size++;
            } else {
                int minIndex = 0;
                for (int i = 1; i < 3; i++) {
                    if (memory[i] < memory[minIndex]) {
                        minIndex = i;
                    }
                }
                if (n > memory[minIndex]) {
                    memory[minIndex] = n;
                }
            }
            // Выводим текущее состояние памяти
            for (int i = 0; i < size; i++) {
                System.out.print(memory[i] + " ");
            }
            if (size == 3) {
                System.out.print("(память заполнена)");
            }
            System.out.println();
        }
    }

    // 7. Удаление повторяющихся слов
    public static void task7(Scanner sc) {
        String line = sc.nextLine();
        String[] words = line.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (!result.equals("")) {
                    result += " ";
                }
                result += words[i];
            }
        }
        System.out.println(result);
    }

    // 8. Преобразование регистра строки
    public static void task8(Scanner sc) {
        String s = sc.nextLine();
        int upper = 0, lower = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z' || c >= 'А' && c <= 'Я') upper++;
            if (c >= 'a' && c <= 'z' || c >= 'а' && c <= 'я') lower++;
        }
        if (upper > lower) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    System.out.print((char)(c - 32));
                } else if (c >= 'а' && c <= 'я') {
                    System.out.print((char)(c - 32));
                } else {
                    System.out.print(c);
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    System.out.print((char)(c + 32));
                } else if (c >= 'А' && c <= 'Я') {
                    System.out.print((char)(c + 32));
                } else {
                    System.out.print(c);
                }
            }
        }
        System.out.println();
    }