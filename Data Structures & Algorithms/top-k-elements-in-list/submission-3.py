class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}

        for num in nums:
            freq[num] = 1 + freq.get(num, 0)
        
        bucket = []

        for num, cnt in freq.items():
            bucket.append([cnt, num])
        
        bucket.sort()

        res = []

        while len(res) < k:
            res.append(bucket.pop()[1])
        
        return res