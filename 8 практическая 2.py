A = list(map(int, input("Введите элементы массива A через пробел: ").split()))
B = list(map(int, input("Введите элементы массива B через пробел: ").split()))
C = list(map(int, input("Введите элементы массива C через пробел: ").split()))

for arr in [A, B, C]:
    prod = 1
    for num in arr:
        prod *= num
    avg = sum(arr) / len(arr)
    
    print(f"\nМассив: {arr}\nПроизведение: {prod}\nСреднее арифметическое: {avg}")
