package LinkedList;


public class QueueUsingStack {
	static class Queue {
		java.util.Stack<Integer>temp = new  java.util.Stack<>();
		java.util.Stack<Integer>value = new  java.util.Stack<>();
		
		public void offer(int x) {
	        if(value.isEmpty()){
	            value.push(x);
	        }else{
	            while(!value.isEmpty()){
	                temp.push(value.pop());
	            }
	 
	            value.push(x);
	 
	            while(!temp.isEmpty()){
	                value.push(temp.pop());
	            }    
	        }
	    }
	 
	    // Removes the element from in front of queue.
	    public void poll() {
	        value.pop();
	    }
	 
	    // Get the front element.
	    public int peek() {
	        return value.peek();
	    }
	 
	    // Return whether the queue is empty.
	    public boolean empty() {
	        return value.isEmpty();
	    }
	}

	public static void main(String[] args) {
		Queue s = new Queue();
		s.offer(1);
		s.offer(2);
		s.offer(3);

		System.out.println(s.peek());
		s.poll();
		System.out.println(s.peek());
		s.poll();
		System.out.println(s.peek());
	}

}
