def solution(n, lost, reserve):
    answer = 0
    
    student = {}
    for u in range(1,n+1):
        student[u] = 1
        if u in lost:
            student[u] = student.get(u) - 1
        if u in reserve:
            student[u] = student.get(u) + 1
    
    for key, val in student.items():
        if val > 1:
            if key - 1 >= 0:
                if student.get(key - 1) == 0:
                    student[key - 1] = 1
                    student[key] = student.get(key) - 1
            if key + 1 <= len(student):
                if student.get(key + 1) == 0:
                    if student.get(key) > 1:
                        student[key + 1] = 1
                        student[key] = student.get(key) - 1
        
    for key, val in student.items():
        if val > 0:
            answer += 1
    
    print(student)    
    
    return answer



# solution(5, [2, 4], [3])
solution (5, [5], [4])