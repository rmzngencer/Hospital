
//Stack with Linked List
public class Service_2 {
    Service_1 stack; // Your stack. Use this

    // Constructor to initialize the stack
    Service_2(){
        this.stack = new Service_1();
    }

    // Utility function to add an element `x` to the stack
    public void push(Patient p){
        //Write your codes here
        //stack.head = top
        //stack.insert(p.getName(),0);
        if (isEmpty()) {
           stack.head = stack.tail = p;
            stack.head.previous = null;
            stack.tail.next = null;
        }else{
            stack.head.previous = p;
            p.next = stack.head;
            stack.head = p;
        }
    }

    // Utility function to pop a top element from the stack
    public Patient pop(){
        //Write your codes here
        //stack.head = top
        //return stack.deleteByPosition(0);
        if(!isEmpty()){
            stack.head = stack.head.next;
            return stack.head.previous;
        }
        return null;
    }

    // Utility function to check if the stack is empty or not
    public Boolean isEmpty(){
        //Write your codes here
        //stack.head = top
        //return stack.isEmpty();
        return stack.head == null;
    }

    // Utility function to return the size of the stack
    public int size() {
        //Write your codes here
        //return stack.size();
        int count = 0;
        if (isEmpty())
            return count;
        else {
            count++;
            Patient temp = stack.head;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
        }
        return count;

    }
}
