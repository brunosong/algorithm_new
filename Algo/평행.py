def solution(dots):
    answer = 0
    
    dots.sort(key=lambda x : x[0])
    print(dots)
    
    x1,y1 = dots[0][0], dots[0][1]
    x2,y2 = dots[1][0], dots[1][1]
    
    x,y = x1 - x2, y1 - y2
    
    x3,y3 = dots[2][0], dots[2][1]
    x4,y4 = dots[3][0], dots[3][1]
    
    xx,yy = x3 - x4, y3 - y4
    
    if x == xx and y == yy:
        return 1
    
    if x * 2 == xx and y * 2 == yy:
        return 1
    
    if xx * 2 == x and yy * 2 == y:
        return 1
    
    return answer




# solution([[1, 4], [9, 2], [3, 8], [11, 6]]) #1
#print(solution([[3, 5], [4, 4], [8, 9], [6, 11]])) #1
print(solution([[1, 2], [5, 1], [3, 6], [6, 3]]))
#[[3, 5], [4, 1], [2, 4], [5, 10]]	0