# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy=ListNode(0)
        res=ListNode(0)
        dummy.next=res
        carry=0
        while l1 and l2:
            val=l1.val+l2.val+carry
            if val>=10 :
                carry=1
                dig=val%10
            else:
                carry=0
                dig=val
            node=ListNode(dig)
            res.next=node
            res=res.next
            l1=l1.next
            l2=l2.next
        if l1:
            while l1:
                val=l1.val+carry
                if val>=10:
                    carry=1
                    dig=val%10
                else:
                    carry=0
                    dig=val
                node=ListNode(dig)
                res.next=node
                res=res.next
                l1=l1.next
        elif l2:
            while l2:
                val=l2.val+carry
                if val>=10:
                    carry=1
                    dig=val%10
                else:
                    carry=0
                    dig=val
                node=ListNode(dig)
                res.next=node
                res=res.next
                l2=l2.next

                

        if carry!=0:
            node=ListNode(carry)
            res.next=node
        return dummy.next.next
        