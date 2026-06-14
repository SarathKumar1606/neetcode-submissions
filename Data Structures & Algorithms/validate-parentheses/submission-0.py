from collections import deque
stack=deque()
class Solution:
    def isValid(self, s: str) -> bool:
        i=0
        n=len(s)
        for c in s:
            if c=='(' or c=='{' or c=='[':
                stack.append(c)
            else:
                topchar=stack[-1]
                if (c==')' and topchar=='(' )or( c==']' and topchar=='[') or(c=='}' and topchar=='{'):
                    stack.pop()
                else:
                    return False
        return True