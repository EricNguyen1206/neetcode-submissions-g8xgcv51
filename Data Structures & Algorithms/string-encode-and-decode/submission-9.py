class Solution:

    def encode(self, strs: List[str]) -> str:
        encodeStr = ""
        
        for s in strs:
            encodeStr += str(len(s)) + "#" + s
        
        return encodeStr

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0

        while i < len(s):
            j = i
            numStr = ""
            
            while s[j] != "#":
                j += 1
            
            lenght = int(s[i: j])
            j += 1 # skip the '#'

            res.append(s[j: j+lenght])
            i = j + lenght
    
        return res

