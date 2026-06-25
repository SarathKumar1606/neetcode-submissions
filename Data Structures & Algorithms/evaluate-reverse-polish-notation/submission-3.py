class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        for token in tokens:
            if token in {"+","-","/","*"}:
                first=stack[-2]
                second=stack[-1]
                stack.pop()
                stack.pop()
                if token=='+':
                    ans=first+second
                elif token=="-":
                    ans=first-second
                elif token=="*":
                    ans=first*second
                elif token=="/":
                    ans=first/second if second!=0 else 0
                stack.append(int(ans))
            else:
                stack.append(int(token))
        return int(stack[0])