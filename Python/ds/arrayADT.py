from abc import ABC, abstractmethod
class ArrayADT(ABC):

    @abstractmethod
    def add(self, value):
        pass

    @abstractmethod
    def insert(self, index, value):
        pass
    
    @abstractmethod
    def remove(self, index):
        pass
  
    @abstractmethod
    def size(self):
        pass
   
    @abstractmethod
    def is_empty(self):
        pass
   
    @abstractmethod
    def clear(self):
        pass

    @abstractmethod
    def get(self, index):
        pass
     