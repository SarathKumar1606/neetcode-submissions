# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverse(self, head):
        if head==None:
            return head
        prev=None
        curr=head
        while curr:
            nxt=curr.next
            curr.next=prev
            prev=curr
            curr=nxt
        return prev
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow,fast=head,head
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next

        second=slow.next
        slow.next=None
        second=self.reverse(second)
        first=head
        f=True
        while first and second:
            if f:
                temp1=first.next
                first.next=second
                first=temp1
                f=False
            else:
                temp2=second.next
                second.next=first
                second=temp2
                f=True
        
        