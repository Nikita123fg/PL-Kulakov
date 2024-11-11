array = list(map(float, input("Введите элементы массива через пробел: ").split()))

min_mod_element = min(array, key=abs)

print(f"Минимальный по модулю элемент: {min_mod_element}")
print("Массив в обратном порядке:", *array[::-1])
