class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        for token in tokens:
            if token in {"+","-","/","*"}:
                first=stack[-1]
                second=stack[-2]
                stack.pop()
                stack.pop()
                if token=='+':
                    ans=first+second
                elif token=="-":
                    ans=first-second
                elif token=="*":
                    ans=first*second
                elif token=="/":
                    ans=first/second
                stack.append(ans)
            else:
                stack.append(int(token))
        return stack[0]