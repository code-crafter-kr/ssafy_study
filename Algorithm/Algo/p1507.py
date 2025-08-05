from collections import deque
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

n = int(input())

lst = (list(map(int, input().split())) for _ in range(n))

roadMap = [[0] * n for _ in range(n)]

for i in lst:
    for j in i:
        print("%2d" %j, end = " ")
    print(" ")