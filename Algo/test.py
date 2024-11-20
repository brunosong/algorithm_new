arr = input().split(" ")
m, n = int(arr[0]), int(arr[1])

primes = [True] * (n + 1)
primes[0], primes[1] = False, False

for i in range(2, int((n ** 0.5) + 1)):
    if primes[i]:
        for j in range(i * i, n + 1, i):
            primes[j] = False

for i, p in enumerate(primes):
    if p and i >= m:
        print(i)

