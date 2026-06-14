class LRUCache:
    class Node:
        def __init__(self,_key:int=0, _val:int=0):
            self.key=_key
            self.val=_val
            self.prev=None
            self.next=None

    def __init__(self, capacity: int):
        self.cap=capacity
        self.head=self.Node(-1,-1)
        self.tail=self.Node(-1,-1)
        self.head.next=self.tail
        self.tail.prev=self.head
        self.mp={}

    def addNode(self,_key:int=0, _val:int=0)->Node:
        node=self.Node(_key,_val)
        temp=self.head.next
        self.head.next=node
        node.next=temp
        node.prev=self.head

    def deleteNode(self, delNode:Node):
        temp1=delNode.prev
        temp2=delNode.next
        temp1.next=temp2
        temp2.prev=temp1
        del delNode
    
    def get(self, key: int) -> int:
        if key in self.mp:
            resNode=self.mp[key]
            res=resNode.val

            self.deleteNode(resNode)
            del mp[key]
            self.addNode(resNode)
            self.mp[key]=self.head.next
            return res
        return -1
        
        

    def put(self, key: int, value: int) -> None:
        if key in self.mp:
            node=self.mp[key]
            del self.mp[key]
            self.deleteNode(node)
        if len(self.mp)==self.cap:
            del self.mp[self.tail.prev.key]
            self.deleteNode(self.tail.prev)
        
        self.addNode(key,value)
        self.mp[key]=self.head.next



