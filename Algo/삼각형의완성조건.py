def solution(sides):
    answer = 0
    
    line1, line2 = sides[0], sides[1]
    
    long_line = 0
    short_line = 0
    
    if line1 > line2:
        long_line = line1
        short_line = line2
    else:
        long_line = line2
        short_line = line1
    
    cnt = 1
    sum = 0
    while cnt <= long_line:
        if short_line + cnt > long_line and cnt <= long_line:
            sum += 1
        cnt += 1
    
    other_line = long_line + 1
    while short_line + long_line > other_line:
        other_line += 1
        sum += 1
    
    return answer

solution([3, 6]) #	5