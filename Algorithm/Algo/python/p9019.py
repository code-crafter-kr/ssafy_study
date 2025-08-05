import sys
from collections import deque

sys.stdin = open("input.txt" , "r")
input = sys.stdin.readline

TC = int(input())

def D(n):
    return (n * 2) % 10000

def S(n):
    return 9999 if n == 0 else n - 1

def L(n):
    return (n % 1000) * 10 + (n // 1000)

def R(n):
    return (n % 10) * 1000 + (n // 10)


def bfs(start, target):
    visited = [0] * 10000
    dq = deque([(start, "")])
    functions = [("D", D), ("S", S), ("L", L), ("R", R)]
    while dq:
        current_number, order = dq.popleft()
        if current_number == target:
            print(order)
            return

        if visited[current_number] != 0:
            continue
        
        visited[current_number] = 1
        for command, command_function in functions:
            next_number = command_function(current_number)
            next_order = order + command
            
            dq.append((next_number, next_order))


for _ in range(TC):
    a, b = map(int, input().split())
    bfs(a, b)