class Student:
    def __init__(self, name, id, gpa):
        self.name = name
        self.id = id
        self.gpa = gpa

    def __add__(self, other):
        self.gpa += other.gpa
        return self
    
    def __gt__(self, other):
        return self.gpa> other.gpa
    
    def __lt__(self,other):
        return self.gpa < other.gpa
    
    def __eq__(self, other):
        return self.gpa == other.gpa
    
students = [
    Student("Alice", 101, 3.8),
    Student("Bob", 102, 3.4),
    Student("Charlie", 103, 3.9),
    Student("Dina", 104, 3.2),
    Student("Ethan", 105, 3.6),
    Student("Fatima", 106, 3.7),
    Student("George", 107, 2.9)]

#test comparison
print("Is", students[0].name,"'s gpa greater than"
      , students[1].name,"'s gpa?",students[0]>students[1])
print("Is", students[2].name,"'s gpa less than"
      , students[3].name,"'s gpa?",students[2]<students[3])
print("Is ", students[3].name,"'s gpa equal to"
      , students[4].name,"'s gpa?",students[3]==students[4])

# this is a virtual student to accumulate all the GPA's
# at the end dummyStudent will have a GPA equals to the sum
# of the GPA's of all the students.
dummyStudent = Student("Dummy", 100, 0) 
sum_gpa = 0
for student in students:
    dummyStudent += student

avg_gpa = dummyStudent.gpa/len(students)
print(avg_gpa)
