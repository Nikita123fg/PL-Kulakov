n=int(input("Введите количество чисел из ряда Фибоначи:"))
a,b=0,1
s_fib=0
for _ in range(n):
    s_fib+=a
    a,b=b,a+b
print("Сумма первых",n, "чисел Фибоначи", s_fib)
