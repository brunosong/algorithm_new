import queue

def solution(k, score):
    answer = []
    
    pq = queue.PriorityQueue()
    
    for s in score:
        if pq.qsize() < k:
            pq.put(s)
            min = custom_low_peek(pq)
            answer.append(min)
        else:
            min = custom_low_peek(pq)
            print(min)
            if min < s:
                pq.get()
                pq.put(s)
            min = custom_low_peek(pq)
            answer.append(min)
    
    print(answer)
    
    return answer

def custom_low_peek(pq):
    min = pq.get()
    pq.put(min)
    return min


# solution(3, [10, 100, 20, 150, 1, 100, 200])
solution(4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000])