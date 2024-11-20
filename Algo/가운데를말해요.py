from sortedcontainers import SortedList

a = int(input())

sorted_list = SortedList()
input_list = []
output_list = []

for d in range(0,a):
    num = int(input())
    input_list.append(num)
    
print(input_list)

for num in input_list:
    sorted_list.add(num)
    if len(sorted_list) % 2 == 0:
        center = len(sorted_list) // 2
        left = sorted_list[center-1]
        right = sorted_list[center]
        min_po = min(left,right)
        output_list.append(min_po)
    else:
        center = len(sorted_list) // 2
        output_list.append(sorted_list[center])
        
for item in output_list:
    print(item)
    