
//**************Double Linked List************************//
public class Service_1 {
    Patient head; //head of list
    Patient tail; //tail of list

    //Constructor
    public Service_1() {
        //Write your codes here
        this.head=null;
        this.tail=null;
    }

    //Check list is empty or not
    public boolean isEmpty() {
        //Write your codes here
        return head == null;
    }

    //This function first builds new patient with the given data
    //than adds it to the LinkedList
    //new nodes are added to the tail of LinkedList
    public void insert(String name) {
        //Write your codes here

        Patient newPatient = new Patient(name);


        if (isEmpty()) {
            head = tail = newPatient;
            head.previous = null;
        } else {

            tail.next = newPatient;
            newPatient.previous = tail;
            tail = newPatient;
        }
        tail.next = null;
    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(String name, int pos) {
        //Write your codes here
        Patient newPatient = new Patient(name);
        newPatient.next = null;
        newPatient.previous = null;

        if (isEmpty()) {
            head = tail = newPatient;
            head.previous = null;
            tail.next = null;
        }else {
            if (pos == 0) {
                newPatient.next = head;
                head.previous = newPatient;
                head = newPatient;
            } else {
                Patient temp;
                temp = head;
                for (int i = 1; i < pos; i++) {
                    if (temp != null) {
                        temp = temp.next;
                    }
                }
                if (temp != null) {
                    newPatient.next = temp.next;
                    newPatient.previous = temp;
                    temp.next = newPatient;
                    if (newPatient.next != null) {
                        newPatient.next.previous = newPatient;
                    }
                } else {
                    System.out.print("\nThe previous node is null.");
                }
            }
        }
    }

    //This method finds how many patients are exist in LinkedList
    public int size() {
        //Write your codes here
        int count = 0;
        if (isEmpty()){
            return count;
        }else{
            count++;
            Patient temp = head;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
        }
        return count;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public Patient deleteByName(String name) {

        if (!isEmpty()) {
            Patient del;
            del = head;

            if (del.getName().equals(name)) {
                head = head.next;
            } else if (del.next != null) {
                while (!del.getName().equals(name)) {
                    del = del.next;
                    if (del == null)
                        break;
                }
            }


            if (del != null) {
                if (del.next != null) {
                    del.next.previous = del.previous;
                }

                if (del.previous != null) {
                    del.previous.next = del.next;
                }

                return del;
            }
        }
        return null;
    }



    // This functions delete a node in the LinkedList by a given position
    public Patient deleteByPosition(int pos) {
        //Write your codes here
        Patient del;
        del = head;
        if (pos == 0) {
            head = head.next;
        } else {

            for (int i = 0; i < pos; i++) {
                if (del != null) {
                    del = del.next;
                }
            }

            if (del.next != null) {
                del.next.previous = del.previous;
            }

            if (del.previous != null) {
                del.previous.next = del.next;
            }
        }
        return del;
    }

    //This function get the node in the given index
	//*********************DO NOTHING*********************
    public Patient getByPosition(int pos){
        if(this.isEmpty())
            return new Patient("empty");
        Patient current = this.head;
        int index = 0;

        while (current != null){
            if(index++ == pos)
                break;
            current = current.next;
        }

        if(current == null)
            return new Patient("empty");

        return current;
    }

    // This function prints  the LinkenList
	//*********************DO NOTHING*********************
    public void print() {

        if(this.isEmpty())
            return;
        Patient patient = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (patient != null) {
            System.out.println(index++ + ". " + patient.getName());

            patient = patient.next;  // iterate to next node
        }

    }

}
