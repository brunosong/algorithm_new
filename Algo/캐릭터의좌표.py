def solution(keyinput, board):
    answer = []
    max_x = (board[0] // 2) + 1
    max_y = (board[1] // 2) + 1
    
    limit_x_left, limit_x_right = 0 - max_x, 0 + max_x
    limit_y_top, limit_y_bottom = 0 + max_y, 0 - max_y
    
    current_po_x, current_po_y = 0, 0
    
    for i,val in enumerate(keyinput):
        if val == "left":
            dx = current_po_x - 1
            if dx > limit_x_left:
                current_po_x = dx
        elif val == "right":
            dx = current_po_x + 1
            if dx < limit_x_right:
                current_po_x = dx
        elif val == "up":
            dy = current_po_y + 1
            if dy < limit_y_top:
                current_po_y = dy
        elif val == "down":
            dy = current_po_y - 1
            if dy > limit_y_bottom:
                current_po_y = dy
    
    print(current_po_x, current_po_y)
    answer.append(current_po_x)
    answer.append(current_po_y)
    return answer


solution(["left", "right", "up", "right", "right"],[11, 11]) # 	[2, 1]