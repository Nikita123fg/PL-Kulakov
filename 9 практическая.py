matrix = [
    [3, 5, 2],
    [1, 4, 7],
    [8, 9, 6]
]

print("Наибольший элемент в каждой строке:")
for row in matrix:
    print(max(row))

print("Наименьший элемент в каждом столбце:")
for col in zip(*matrix):
    print(min(col))
