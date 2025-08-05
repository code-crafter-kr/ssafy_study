# 시간초과 예상 -> 타겟 넘버 말고도 모든 숫자 구하는 로직 구현
# pypy 통과
n = int(input())

lst = [0] + [float('inf')] * 50000


for i in range(1, 50001):
    # 2제곱수 3제곱수 4제곱수 연산 로직
    for j in range(1,  50001): # i가 25면 26으로.. 5까지 반복
        if j * j > i:
            break

        if j * j == i:
            lst[i] = 1
            break

        temp = lst[i - j*j] + 1
        lst[i] = min(lst[i], temp)

print(lst[n])