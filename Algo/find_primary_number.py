# 첫 번째 줄: 숫자의 개수
n = int(input())

# 두 번째 줄: 공백으로 구분된 n개의 정수를 리스트로 변환
files = []
for str in range(0,n):
    files.append(input())

data = {}
for file in files:
    file_arr = file.split(".")
    data[file_arr[1]] = data.get(file_arr[1], 0) + 1

for d in sorted(data):
    print(d, data.get(d))

