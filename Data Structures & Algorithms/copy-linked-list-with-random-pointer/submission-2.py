"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        mp={}
        curr=head
        while curr:
            mp[curr]=Node(curr.val)
            curr=curr.next
        curr=head
        while curr:
            copy=mp[curr]
            copy.next=mp.get(curr.next,None)
            copy.random=mp.get(curr.random,None)
            curr=curr.next
        return mp[head]