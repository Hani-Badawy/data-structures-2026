from ds.array import *

def main():
    arr = Array()
    print("Is array empty?", arr.is_empty())  # True
    arr.add(10)
    arr.add(20)
    print("Array size after adding 2 elements:", arr.size())  # 2
    arr.insert(2, 30)

    for item in arr:
        print(item) 
        
    print("Array size after inserting an element at index 2:", arr.size())  # 3
    arr.remove(1)
    print("Array size after removing element at index 1:", arr.size())  # 2
    print("Is array empty?", arr.is_empty())  # False
    arr.clear()
    print("Array size after clearing:", arr.size())  # 0
    print("Is array empty?", arr.is_empty())  # True

if __name__ == "__main__":
    main()
