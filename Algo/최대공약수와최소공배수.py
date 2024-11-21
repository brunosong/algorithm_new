import math

text = input().split(" ")
a, b = int(text[0]), int(text[1])

result = math.gcd(a, b)
result_a = math.lcm(a, b)

print(result)
print(result_a)
