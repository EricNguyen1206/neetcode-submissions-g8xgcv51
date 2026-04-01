class Solution:
    def isValid(self, s: str) -> bool:
        openstack = []
        openChars = set(['(', '{', '['])

        for c in s:
            if c in openChars:
                openstack.append(c)
            else:
                if len(openstack) == 0:
                    return False
                lastChar = openstack.pop()
                if c == ')' and lastChar != '(':
                    return False
                if c == '}' and lastChar != '{':
                    return False
                if c == ']' and lastChar != '[':
                    return False
        
        return False if openstack else True

        