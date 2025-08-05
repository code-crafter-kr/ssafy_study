import sys

sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

N, M = map(int, input().split())

lst = []
for _ in range(N):
    lst.append(input().strip())