# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverse(self, head:Optional[ListNode],stopNode:Optional[ListNode])->Optional[ListNode]:
        curr=head
        prev=stopNode
        while curr!=stopNode:
            nxt=curr.next
            curr.next=prev
            prev=curr
            curr=nxt
        return prev
    def getKth(self,curr:Optional[ListNode],k: int)->Optional[ListNode]:
        while curr and k>0:
            curr=curr.next
            k-=1
        return curr

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy=ListNode(0)
        dummy.next=head
        groupPrev=dummy

        while True:
            kth=self.getKth(groupPrev,k)
            if not kth:
                break
            
            groupNext=kth.next
            oldHead=groupPrev.next
            groupPrev.next=self.reverse(oldHead,groupNext)
            groupPrev=oldHead
        return dummy.next


        