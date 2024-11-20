def solution(spell, dic):
    answer = 2
    
    for word in dic:
        check = True
        for s in spell:
            if s not in word:
                check = False
                break
        if check == True:
            return 1

    return answer


print(solution(["p", "o", "s"], ["sod", "eocd", "qixm", "adio", "soo"])) # 	2
# ["z", "d", "x"]	["def", "dww", "dzx", "loveaw"]	1
# ["s", "o", "m", "d"]	["moos", "dzx", "smm", "sunmmo", "som"]	2