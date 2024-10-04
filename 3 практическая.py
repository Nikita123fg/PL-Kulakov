def can_break_chocolate(n, m, k):
    parts = n * m
    return (k < parts) and (k % n == 0 or k % m == 0)

n, m, k = map(int, input("Введите n, m и k через пробел: ").split())
if can_break_chocolate(n, m, k):
    print("Да")
else:
    print("Нет")
