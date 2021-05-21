public class LinkedList {

    Node head, tail, current;
    int size;

    //creates an empty LinkedList of size 0
    LinkedList(){
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    //Returns the value of the head Node
    public Node getHead(){
        return head;
    }

    //Returns the value of the tail Node
    public Node getTail(){
        return tail;
    }

    //Set the value of the head Node to h
    public void setHead(Node h){
        head = h;
    }

    //Set the value of the head Node to h
    public void setTail(Node t){
        tail = t;
    }

    //Add a new Node at the head with data value
    public void addToHead(String value){
        //add new node at head
        Node node = new Node(value);
        node.setNext(head);
        if(size == 0){
            tail = node;
            current = node;
        } else {
            current = node;
        }
        head = node;
        size++;
    }

    //Set the current pointer to head
    public void setCurrentToHead(){
        current = head;
    }

    //Set the current pointer to next Node
    public void setCurrentToNext(){
        current = current.getNext();
    }

    //Return the current pointer
    public Node getCurrent(){
        return current;
    }

    //Return the size of the LinkedList
    public int getSize(){
        return size;
    }

    //remove a node and rearrange the pointers
    public void removeNode(Node n){


        if(n == head){
            //set head to next
            head = n.getNext();
        }
        size--;
        n = null;
    }
}
