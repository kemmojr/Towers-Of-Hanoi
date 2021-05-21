public class LStack {

    LinkedList data;

    //A LStack constructor which creates an empty LinkedList
    LStack() {
        data = new LinkedList();
    }

    //Returns a boolean value indicating if the LinkedList is empty
    public boolean empty(){
        if (data.getSize() == 0){
            return true;
        } else  {
            return false;
        }
    }

    //Returns the size of the LinkedList
    public int height(){
        return data.getSize();
    }

    //Returns the data of the head of the LinkedList
    public String top(){
        return data.getHead().getData();
    }

    //Adds a new node with data element at the head
    public void push(String element){
        data.addToHead(element);
    }

    //Removes the top Head Node of LinkdeList
    public void pop(){
        data.removeNode(data.getHead());
    }

}
