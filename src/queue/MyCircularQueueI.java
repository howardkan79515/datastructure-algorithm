package queue;

public class MyCircularQueueI {

	public static void main(String[] args) {
		MyCircularQueue queue = new MyCircularQueue(3);
		System.out.print(queue.Rear());
		System.out.print(queue.Front());
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
	}

	int[] queue;

	int head = 0;

	int tail = 0;

	int size;

	public MyCircularQueueI(int k) {
		queue = new int[k+1];
		this.size = k+1;
	}

	public boolean enQueue(int value) {
		if((tail+1) % size == head) {
			return false;
		}

		queue[tail] = value;
		tail = (tail+1) % size;
		return true;        
	}

	public boolean deQueue() {
		if(tail == head) {
			return false;
		}
		queue[head] = 0;
		head = (head+1) % size;
		return true;        
	}

	public int Front() {
		if(tail == head) {
			return -1;
		}
		return queue[head];

	}

	public int Rear() {
		if(tail == head) {
			return -1;
		}
		int index = tail == 0 ? queue.length-1 : tail-1;
		return queue[index];

	}

	public boolean isEmpty() {
		if(tail == head) {
			return true;
		}
		return false;        
	}

	public boolean isFull() {
		if((tail+1) % size == head) {
			return true;
		}
		return false;        
	}

}
