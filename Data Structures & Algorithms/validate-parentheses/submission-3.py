from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        stack=deque()
        i=0
        n=len(s)
        for c in s:
            if c=='(' or c=='{' or c=='[':
                stack.append(c)
            else:
                if len(stack)==0:
                    return False
    
                topchar=stack[-1]
                if (c==')' and topchar=='(' )or( c==']' and topchar=='[') or(c=='}' and topchar=='{'):
                    stack.pop()
                else:
                    return False
        return len(stack)==0