def solution(picture, k):
    answer = []
    
    for p in picture:
        temp_col = ""
        for c in range(len(p)):
            for _ in range(0,k):
                temp_col += p[c]

        for _ in range(0,k):
            answer.append(temp_col)
        
    return answer



solution([".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."],2)