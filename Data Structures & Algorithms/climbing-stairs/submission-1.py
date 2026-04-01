class Solution:
    def climbStairs(self, n: int) -> int:
        step1 = 1
        step2 = 2

        if n  <= 2:
            return n
        
        for i in range(3, n+1):
            tmp = step2
            step2+=step1
            step1=tmp
        
        return step2

        