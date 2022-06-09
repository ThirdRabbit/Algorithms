from itertools import combinations

N, S = input().split()
N = int(N)
S = int(S)
count = 0
arr = list(map(int, input().split()))

for i in range(1, N + 1):
    result = list(combinations(arr, i))

    for j in result:
        # print(j)
        if sum(j) == S:
            count += 1

print(count)