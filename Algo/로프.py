n = input()
numbers = []
max_result = set()

for _ in range(n):
    numbers.append(input())

sorted_numbers = numbers.sort()
size = len(sorted_numbers)

for idx,num in enumerate(sorted_numbers):
    max_result.add(num * (size - idx))

print(max(max_result))