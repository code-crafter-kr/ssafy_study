import sys
from collections import defaultdict
tree = defaultdict(dict)

sys.stdin = open("input.txt", "r")
n = int(input())

tree['A'] = {"p" : ".", "left" : None, "right" : None}

for i in range(n):
    node1, node2, node3 = input().split()
    tree[node1]["left"] = node2
    tree[node1]["right"] = node3
    tree[node2]["p"] = node1
    tree[node3]["p"] = node1


def dfs_forward(node):
    if node == ".":
        return

    print(node, end = "")
    dfs_forward(tree[node]["left"])
    dfs_forward(tree[node]["right"])

def dfs_mid(node):
    if node == ".":
        return

    dfs_mid(tree[node]["left"])
    print(node, end = "")
    dfs_mid(tree[node]["right"])

def dfs_backward(node):
    if node == ".":
        return

    dfs_backward(tree[node]["left"])
    dfs_backward(tree[node]["right"])
    print(node, end = "")



dfs_forward("A")
print()
dfs_mid("A")
print()
dfs_backward("A")