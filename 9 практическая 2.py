matrix = [
    [3, 2, 1],
    [4, 9, 6],
    [7, 8, 5]
]

N = len(matrix)
c = N // 2

max_val, max_pos = matrix[c][c], (c, c)

for i in range(N):
    if matrix[i][i] > max_val: max_val, max_pos = matrix[i][i], (i, i)
    if matrix[i][N - i - 1] > max_val: max_val, max_pos = matrix[i][N - i - 1], (i, N - i - 1)

matrix[c][c], matrix[max_pos[0]][max_pos[1]] = matrix[max_pos[0]][max_pos[1]], matrix[c][c]

for row in matrix:
    print(row)
