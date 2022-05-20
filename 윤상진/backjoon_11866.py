from collections import deque

num1, num2 = map(int, input().split())

queue = deque(list(range(1,num1+1)))
result = []

cnt = 0

while queue:
    element = queue.popleft()
    cnt+=1
    if cnt == num2:
        result.append(element)
        cnt = 0
    else:
        queue.append(element)
    
print('<', end='')
for i in result:
    if i == result[-1]:
        print(i, end='>\n')
    else:
        print(i, end=', ')
