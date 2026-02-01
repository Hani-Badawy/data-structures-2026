from abc import ABC, abstractmethod

class LinkListADT(ABC):
    
    @abstractmethod
    def addFirst(self, node):
        pass

    @abstractmethod
    def addLast(self, node):
        pass

    @abstractmethod
    def removeFirst(self):
        pass

    @abstractmethod
    def removeLast(self):
        pass

    @abstractmethod
    def insertAt(self, index, node):
        pass

    @abstractmethod
    def removeAt(self, index):
        pass

    @abstractmethod
    def get(self, index):
        pass

    @abstractmethod
    def size(self):
        pass

    @abstractmethod
    def isEmpty(self):
        pass