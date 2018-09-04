class BoundedQueue<T>{


	protected Object[] queue;
	protected int front, rear, size, len;

// constructor initializes the variables and the size of the queue as provided by the user. If the queue is empty front and rear are set to -1
	public BoundedQueue(int n){
		size = n;
		len = 0;
		queue = new Object[size];
		front = -1;
		rear = -1;
	}

// If front is equal to -1 the queue is empty and it will return false
	@SuppressWarnings("unchecked")
	public boolean isEmpty(){
		return front == -1;
	}

	public int  size(){
		return len;
	}

// returns the element at the front of the queue without deleting it
@SuppressWarnings("unchecked")
	public T peek(){
		if (isEmpty()) {
			return null;

		} else {

			return (T) queue[front];	
		}
	}



// If rear = -1 the queue is empty and we are adding the first element
	public boolean offer(T x){
		if (rear == -1) {
			
			front = 0;
			rear = 0;
			queue[rear] = x; // add first element at the rear of the queue
			len++;
			return true;
		}
		else if(rear + 1 >= size){
			return false; // the queue is already full and new element cannot be added
		}
		else if (rear + 1 < size) {

			queue[++rear] = x; // the queue neither empty nor full and the new element is added at the rear
			len ++;
			return true;
			
		}
		return false;

	}


@SuppressWarnings("unchecked")
	public T poll() {
		if (isEmpty())
           return null;
        else {
	    	len-- ;
         	T ele = (T)queue[front]; // the element at the front of the queue is stored in ele
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

    public void display() {
        System.out.print("\nQueue = ");
        if (len == 0){
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)

            System.out.print(queue[i]+" ");

        System.out.println();        

    }

    public static void main(String[] args) {
    	BoundedQueue<Integer> que = new BoundedQueue<>(10);
    	System.out.println(que.offer(1));
    	System.out.println(que.offer(10));
    	System.out.println(que.poll());
    	System.out.println(que.poll());
    	System.out.println(que.isEmpty());

    	que.display(); 
    }

}
