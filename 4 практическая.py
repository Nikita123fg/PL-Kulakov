n = int(input("Введите кол-во чисед из ряда Фибоначчи: "))
    a = 0
    b = 1
    total = 0
    
    for _ in range(n):
        total += a + b
        c = a + b
        a = b
        b = c
        
    return total

result = fci_sum(n)
print(f"Сумма чисел {n} из ряда Фибоначчи равна {result}")
