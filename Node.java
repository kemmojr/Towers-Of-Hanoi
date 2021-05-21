public class Node {
    Node next, previous;
    String data;
    //Node constructor creates an empty Node
    Node(){
        next = null;
        previous = null;
    }

    //A node constructor that creates a Node with d data
    Node(String d){
        next = null;
        data = d;
    }

    //Set the next pointer of Node to another Node
    public void setNext(Node nxt){
        next = nxt;
    }

    //Returns the next pointer of a Node
    public Node getNext(){
        return next;
    }

    //Set the data to s
    public void setData(String s){
        data = s;
    }

    //Get the data of Node
    public String getData(){
        return data;
    }

    //Overloading toString
    @Override
    public String toString() {
        return data;
    }

}
