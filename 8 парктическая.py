number=int(input("Введите число:"))
steps=0
while number > 0:
    number -= sum(int(digit) for digit in str(number))
    steps +=1
print("Количесво шагов до нуля:",steps)
