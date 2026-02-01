from ds.arrayADT import ArrayADT
class Array(ArrayADT):
    def __init__(self):
        self.length = 10
        self.array = [None] * self.length

    def __iter__(self):
        self.index = 0
        return self
    
    def __next__(self):
        if self.index < self.length:
            value = self.array[self.index]
            self.index += 1
            return value
        else:
            raise StopIteration
        
    def add(self, value):
        for i in range(self.length):
            if self.array[i] is None:
                self.array[i] = value
                return
        raise Exception("Array is full")
    
    def insert(self, index, value):
        if 0 <= index < self.length:
            if self.array[index] is None:
                self.array[index] = value
            else:
                raise Exception("Index already occupied")
        else:
            raise IndexError("Index out of bounds")
        
    def remove(self, index):
        if 0 <= index < self.length:
            if self.array[index] is not None:
                self.array[index] = None
            else:
                raise Exception("Index already empty")
        else:
            raise IndexError("Index out of bounds")
        
    def size(self):
        count = 0
        for i in range(self.length):
            if self.array[i] is not None:
                count += 1
        return count
    
    def is_empty(self):
        for i in range(self.length):
            if self.array[i] is not None:
                return False
        return True
    
    def clear(self):
        for i in range(self.length):
            self.array[i] = None
    
    def get(self, index):
        if 0 <= index < self.length:
            return self.array[index]
        else:
            raise IndexError("Index out of bounds")