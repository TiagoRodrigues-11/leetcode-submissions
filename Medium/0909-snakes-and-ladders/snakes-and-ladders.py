class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        if not board:
            return

        n = len(board)
        
        flat_board = []
        direction = 1
        for i in range(n-1, -1, -1):
            for j in range(n)[::direction]:
                flat_board.append(board[i][j])
            direction *= -1

        queue = deque([(0, 0)]) # (index, rolls)
        visited = set()

        while queue:
            index, rolls = queue.popleft()

            if (index == n*n-1):
                return rolls

            # [1, 2, 3, 4, 5, 6]
            for dice_roll in range(1, 7):
                next_cell = index + dice_roll
                if next_cell >= n*n:
                    break

                if flat_board[next_cell] != -1:
                    next_cell = flat_board[next_cell]-1

                if next_cell not in visited:
                    visited.add(next_cell)
                    queue.append((next_cell, rolls+1))

        return -1