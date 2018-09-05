package msk180001;


import java.util.Arrays;
import java.util.Scanner;


public class BoundedQueue<T> {

	Object[] queue;
	int front, rear, len;
		
	public BoundedQueue(int size) {
		queue = new Object[size];
		front = -1;
		rear = -1;
		len = 0;
	}
	
	public int size() {
		return len;
	}
	
	boolean isEmpty() {
		if (size() == 0)
			return true;
		else
			return false;
	}
	
	void clear() {
		//queue = null;
		front = -1;
		rear = -1;
		len = 0;
	}
	
	boolean offer(T x) {
	
		if (rear == -1) {			
			front = 0;
			rear = 0;
			queue[rear] = x; // add first element at the rear of the queue
			len++;
			return true;
		}
		//else if(rear + 1 < queue.length)  {
		else if (len < queue.length) {
			rear = (rear + 1) % queue.length;
			queue[rear] = x;
			len++;
			return true;
		} else
			return false;
	}
	
//	@SuppressWarnings("unchecked")
	public T poll()
	{
		if (isEmpty())
           return null;
        else {
	    	len-- ;
	     	T ele = (T)queue[front]; // the element at the front of the queue is stored in ele
	     	queue[front] = null;
            if ( front == rear) {
            	// if there was only one element in the queue
                front = -1;
                rear = -1;
            }
            else
            	// front is shifted one step forward after the element is removed
                front++;                
            return ele;
        }        
    }	
	
	//@SuppressWarnings("unchecked")
	public T peek()
	{
		if (isEmpty()) {
			return null;
		} else {
			return (T) queue[front];	
		}
	}
	
	public void display() {
        System.out.print("\nQueue = ");
        if (len == 0){
            System.out.print("Empty\n");
            return ;
        }
        System.out.println(Arrays.toString(queue));
//        for (int i = front; i < queue.length && size() <= queue.length ; i++)
//            System.out.print(queue[i % queue.length]+" ");
//        System.out.println();        
    }
	
	@SuppressWarnings("unchecked")
	void toArray(T[] a) {
		for (int i = front, j = 0; i < queue.length && size() < queue.length; i++, j++) {
			Object element = queue[i % queue.length];
			a[j] = (T) element;
		}
		System.out.println(Arrays.toString(a));
	}

    public static void main(String[] args) {
    	BoundedQueue<Integer> que = new BoundedQueue<>(5);
    	int n = 5;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}

    	for (int i = 1; i <= n; i++) {
			que.offer(Integer.valueOf(i));
		}
		que.display();
		Scanner in = new Scanner(System.in);
		whileloop: while (in.hasNext()) {
			int com = in.nextInt();
			switch (com) {
			case 1: //inserting an element to the queue
				int numberToInsert = in.nextInt();
				if(que.offer(numberToInsert)) {
					que.display();
				} else {
					throw new IndexOutOfBoundsException();
				}
				break;
			case 2: // Remove and return front element
				int ele = que.poll();
				System.out.println(ele);
				break;
			case 3: //return front element
				 System.out.println(que.peek());
				break;
			case 4:// Move to previous element and print it
				System.out.println(que.size());
				break;
			case 5:
				System.out.println(que.isEmpty());
				break;
			case 6:
				que.clear();
				que.display();
				break;
			case 7:
				Integer[] userArray = new Integer[5];
				que.toArray(userArray);
			default: // Exit loop
				break whileloop;
			}
		}
		que.display();
    }
}

