n = 6
answer = "NO"
arr = [1, 3, 5, 6, 7, 10]
total = sum(arr)


def solution():
    dfs(0, 0)
    return answer


def dfs(level, sum_val):
    global answer

    if level == n:
        if total // 2 == sum_val:
            answer = "YES"
    else:
        dfs(level + 1, arr[level] + sum_val)
        dfs(level + 1, sum_val)


print(solution())
