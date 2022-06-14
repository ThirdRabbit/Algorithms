# 순열 사용을 위한 라이브러리
from itertools import permutations

n = int(input())
arr = list(map(int, input().split()))
# arr.sort()
# 모든 순열 구하기
per = list(permutations(arr, n))
max_val = 0

for i in range(len(per)): # 모든 순열 돌기
    cur = 0
    for j in range(0, n - 1):
        cur += abs(per[i][j] - per[i][j + 1])  # abc : 절대값 함수
        if cur > max_val:
            max_val = cur
print(max)