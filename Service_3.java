
//Queue with Linked List
public class Service_3 {
    Service_1 queue; // Your queue. Use this

    // Constructor to initialize a queue
    Service_3() {
        this.queue = new Service_1();
    }

    // Utility function to dequeue the front element
    public Patient dequeue() {
        //Write your codes here
        //queue.head = front
        //return queue.deleteByPosition(0);
        queue.head = queue.head.next;
        return queue.head.previous;
    }

    // Utility function to add an item to the queue
    public void enqueue(Patient p) {
        //Write your codes here
        //queue.insert(p.getName());
        //queue.head = front
        //queue.tail = rear
        Patient newPatient = new Patient(p.getName());
        if (isEmpty()) {
            queue.head = queue.tail = newPatient;
            queue.head.previous = null;
        } else {
            queue.tail.next = newPatient;
            newPatient.previous = queue.tail;
            queue.tail = newPatient;
        }
        queue.tail.next = null;
    }

    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        //Write your codes here
        //queue.head = front
        //return queue.isEmpty();
        return queue.head == null;
    }

    // Utility function to return the size of the queue
    public int size() {
        //Write your codes here
        //return queue.size();
        int count=0;
        if (isEmpty())
            return count;
        else {
            count++;
            Patient temp = queue.head;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
        }
        return count;
    }

}
