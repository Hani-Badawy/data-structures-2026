package ds;

public class Queue<T> implements QueueADT<T> {

	T[] data;
    int front;
    int back;
    int capacity;
    int length;

    public Queue(int capacity) {
        this.capacity = capacity;
        data = (T[])new Object[capacity];
        this.front = this.back = -1;
        this.length = back - front + 1;
    }

    public Queue() {
        this.capacity = 100;
        data = (T[]) new Object[capacity];
        this.front = 0;
        this.back = -1;
        this.length = back - front + 1;
    }

    public void enqueue(T element) {
        data[++back] = element;
        this.length = back - front + 1;
    }

    public T dequeue() throws Exception {
        if(this.length==1)
            reset();
        if (isEmpty()) {
            throw new Exception("Can't dequeue, the queue is empty");
        }
        else {
            front++;
        }
        this.length = back - front + 1;
        return data[front];
    }
    
    public T peek()
    {
        return data[front];
    }
    public boolean isEmpty() {
        return this.length == 0;
    }

    private void reset() {
        this.front= 0;
        this.back = -1;
        this.length = back - front + 1;
    }

    // using length instead of size as length mores appropriate for queue. 
    public int length() {
		return this.length;
	}
}
