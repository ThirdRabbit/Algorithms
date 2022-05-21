t = int(input())
arr = []
stack = []
result = []
for i in range(0,t):
    arr.append(int(input()))


for i in range(1, t+1):
    stack.append(i)
    result.append('+')

    while stack[-1] == arr[0]:
        stack.pop()
        arr.pop(0)
        result.append('-')
        
        if len(arr) == 0 or len(stack) == 0:
            break
        
    
if len(stack) != 0:
    print('NO')
else:
    for i in result:
        print(i)