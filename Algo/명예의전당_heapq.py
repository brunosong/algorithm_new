import heapq

def solution(k, score):
    answer = []
    queue_of = []
    
    for s in score:
        if len(queue_of) < k:
            heapq.heappush(queue_of, s)
        else:
            if s > queue_of[0]:
                heapq.heappushpop(queue_of, s)
            
        answer.append(queue_of[0])
    print(answer)
    
    stttr = ""
    
    answer
    
    
    return answer


# solution(3, [10, 100, 20, 150, 1, 100, 200])
solution(4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000])