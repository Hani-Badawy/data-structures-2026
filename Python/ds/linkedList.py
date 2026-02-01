from linkedListADT import LinkListADT
from node import Node

class LinkedList(LinkListADT):

    def __init__(self):
        self.head = None
        self.tail = None
        self._size = 0

    def addFirst(self, node):
        if not isinstance(node, Node):
            node = Node(node)
        if self.head is None:
            self.head = node
            self.tail = node
        else:
            node.next = self.head
            self.head = node
        self._size += 1
    
    def addLast(self, node):
        if not isinstance(node, Node):
            node = Node(node)
        if self.tail is None:
            self.head = node
            self.tail = node
        else:
            self.tail.next = node
            self.tail = node
        self._size += 1

    def removeFirst(self):
        if self.head is None:
            raise Exception("List is empty")
        removed_node = self.head
        self.head = self.head.next
        if self.head is None:
            self.tail = None
        self._size -= 1
        return removed_node
    
    def removeLast(self):
        if self.tail is None:
            raise Exception("List is empty")
        if self.head == self.tail:
            removed_node = self.head
            self.head = None
            self.tail = None
        else:
            current = self.head
            while current.next != self.tail:
                current = current.next
            removed_node = self.tail
            current.next = None
            self.tail = current
        self._size -= 1
        return removed_node
    
    def insertAt(self, index, node):
        if not isinstance(node, Node):
            node = Node(node)
        if index < 0 or index > self._size:
            raise IndexError("Index out of bounds")
        if index == 0:
            self.addFirst(node)
        elif index == self._size:
            self.addLast(node)
        else:
            current = self.head
            for _ in range(index - 1):
                current = current.next
            node.next = current.next
            current.next = node
            self._size += 1

    def removeAt(self, index):
        if index < 0 or index >= self._size:
            raise IndexError("Index out of bounds")
        if index == 0:
            return self.removeFirst()
        elif index == self._size - 1:
            return self.removeLast()
        else:
            current = self.head
            for _ in range(index - 1):
                current = current.next
            removed_node = current.next
            current.next = removed_node.next
            self._size -= 1
            return removed_node
    
    def get(self, index):
        if index < 0 or index >= self._size:
            raise IndexError("Index out of bounds")
        current = self.head
        for _ in range(index):
            current = current.next
        return current
    
    def size(self):
        return self._size
    
    def isEmpty(self):
        return self._size == 0
    
    def __iter__(self):
        self.current = self.head
        return self
    
    def __next__(self):
        if self.current is not None:
            node = self.current
            self.current = self.current.next
            return node
        else:
            raise StopIteration
        
    