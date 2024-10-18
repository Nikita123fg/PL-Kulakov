def fci_sum(n)
    a = 0
    b = 1
    total = 0
    
    for _ in range(n):
        total += a + b
        c = a + b
        a = b
        b = c

n = int(input("Введите кол-во чисед из ряда Фибоначчи: "))
    return total

result = fci_sum(n)
print(f"Сумма чисел {n} из ряда Фибоначчи равна {result}")
