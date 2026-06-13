# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if head.next==None: 
            return None
        dummy=ListNode(0)
        dummy.next=head
        N=0
        temp=head

        while temp:
            N+=1
            temp=temp.next
        
        target=N-n
        i=0
        temp=dummy
        while i<target:
            temp=temp.next
            i+=1
        
        delnode=temp.next

        if delnode.next!=None:
            temp.next=temp.next.next
        else:
            temp.next=None
        del delnode

        return head
        