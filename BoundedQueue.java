package msk180001;

public class BoundedQueue<T> {

	Object[] queue;
	int front, rear, len;
		
	public BoundedQueue(int size) 
	{
		queue = new Object[size];
		front = -1;
		rear = -1;
		len =0;
	}
	
	public int size()
	{
		return len;
	}
	
	boolean isEmpty()
	{
		if (size() == 0)
			return true;
		else
			return false;
	}
	
	void clear()
	{
		queue = null;
		
	}
	
	boolean offer(T x)
	{
		if (rear == -1)
		{			
			front = 0;
			rear = 0;
			queue[rear] = x; // add first element at the rear of the queue
			len++;
			System.out.println(len);
			return true;
		}else if(rear + 1 < queue.length)
		{
			queue[++rear] = x;
			len++;
			System.out.println(len);
			
			return true;
		}else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public T poll()
	{
		if (isEmpty())
           return null;
        else 
        {
	    	len-- ;
			System.out.println(len);
         	T ele = (T)queue[front]; // the element at the front of the queue is stored in ele
            if ( front == rear) 
            {
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
	
	@SuppressWarnings("unchecked")
	public T peek()
	{
		if (isEmpty())
		{
			return null;

		}else 
		{
			return (T) queue[front];	
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
    	BoundedQueue<Integer> que = new BoundedQueue<>(5);
    	System.out.println(que.offer(1));
    	System.out.println(que.offer(21));
    	System.out.println(que.peek());
    	System.out.println(que.poll());
    	System.out.println(que.peek());
    	//System.out.println(que.poll());
    	System.out.println(que.isEmpty());
    	System.out.print(que.clear());

    	que.display(); 
    }
