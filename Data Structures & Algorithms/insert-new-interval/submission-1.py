class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        intervals.sort()

        newIntervals = []

        for i in intervals:
            if len(newIntervals) == 0:
                newIntervals.append(i)
            else:
                cur = newIntervals.pop()
                if cur[1] >= i[0]:
                    newIntervals.append([cur[0], max(cur[1], i[1])])
                else:
                    newIntervals.append(cur)
                    newIntervals.append(i)

        return newIntervals
