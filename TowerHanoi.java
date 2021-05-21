public class TowerHanoi {

    LStack[] stack = new LStack[3];
    int stackWidth, numberOfDiscs;

    TowerHanoi(int numOfDiscs){
        String nodeData;
        numberOfDiscs = numOfDiscs;
        String out;
        String strX = "X", whiteSpace = " ", empty = "";
        String strXOut = "";
        String whiteSpaceString = " ";
        String finString;
        int whiteSpaceInt;
        int numX;
        stackWidth = 1+2*(numberOfDiscs-1)+4;

        for (int j = 0; j < 3; j++) {
            stack[j] = new LStack();
            if (j==0){
                for (int i =numberOfDiscs; i>0; i--){
                    numX = 1+2*(i-1);
                    strXOut = "";
                    for (int k = 0; k < numX; k++){
                        strXOut += strX;
                    }
                    whiteSpaceInt = (stackWidth-numX)/2;
                    for (int k = 0; k < whiteSpaceInt; k++){
                        whiteSpaceString += whiteSpace;
                    }
                    out = whiteSpaceString+strXOut+whiteSpaceString;
                    stack[j].push(out);
                }
            } else{
                for (int i =numberOfDiscs; i>0; i--){
                    stack[j].push(empty);
                }
            }
        }
    }

    //A function for moving the discs. It takes the two inputs of the to and from discs and returns that there is an error to the user if they have inputted the incorrect data
//The rods given are then checked to make sure that there is a disc to move and that the move is legal i.e. the rod is smaller than the one it is going on top of
//It then empties both rods of any blank strings and then pushes the disc onto the receiving rod and then removes the disc from it's previous rod.
//Both stacks are then reassembled with blank strings until they are the normal height.
    public void move(int from, int to) {
        //Check the from rod has a disc
        //Check the to rod has a disc
        //Check the size of the disc on the from rod is smaller than the to rod

        if (from < 1 || from > 3 || to < 1 || to > 3){
            System.err.println("The data you have entered is incorrect. The rod values cannot be greater than 3 or less than 1 as there is only 3.");
            return;
        }

        String fromString, toString, empty = "";
        boolean noFromDiscs = false, noToDiscs = false;
        for (int i = 0; i < numberOfDiscs; i++) {
            if (stack[from-1].top().equals(empty)){
                if (stack[from-1].height() == 1){
                    stack[from-1].pop();
                    noFromDiscs = true;
                    break;
                }
                stack[from-1].pop();
            } else {
                noFromDiscs = false;
                break;
            }
        }

        if (noFromDiscs){
            for (int i =numberOfDiscs; i>0; i--){
                stack[from-1].push(empty);
            }
            System.err.println("The rod you were trying to move from has no discs.");
            return;
        }
        for (int i = 0; i < numberOfDiscs; i++) {
            if (stack[to-1].top().equalsIgnoreCase(empty)){
                if (stack[to-1].height() == 1){
                    stack[to-1].pop();
                    noToDiscs = true;
                    break;
                }
                stack[to-1].pop();
            } else {
                noToDiscs = false;
                break;
            }
        }

        if (!noToDiscs){
            //getStack(to-1)->top();
            toString = stack[to-1].top();
            fromString = stack[from-1].top();
            if (fromString.length()<toString.length()){
                stack[to-1].push(stack[from-1].top());
                stack[from-1].pop();
            } else {
                System.err.println("The disc you were trying to move is larger than the one you are trying to put it on top of. ");
            }
        } else {
            stack[to-1].push(stack[from-1].top());
            stack[from-1].pop();
        }

        while (stack[from-1].height()<numberOfDiscs){
            stack[from-1].push(empty);
        }
        while (stack[to-1].height()<numberOfDiscs){
            stack[to-1].push(empty);
        }
    }

    //A function that checks if the game has been won by looking at the top of the third stack and if the top string is not empty then the game has been completed
    public boolean checkWin(){
        if (stack[2].top() != ""){
            return true;
        } else return false;
    }

//A print helper function
//Uses the methods top, push and pop to get the data on the top of the stack, add it to a string and a temporary stack and then remove the top item of the stack
//Once a fully formatted string has been created the stacks are rebuilt from the temporary stack exactly as they were before printing
    String print() {
        String out = "", stackData, stackPrintData = "", dash = "-", blank = " ";
        LStack[] tempStack = new LStack[3];
        for (int k = 0; k < 3; k++) {
            tempStack[k] = new LStack();
        }
        for (int i = 0; i < numberOfDiscs; i++) {
            for (int j = 0; j < 3; j++) {
                stackData = stack[j].top();
                stackPrintData = "";
                if (stackData.equalsIgnoreCase("")){
                    for (int k = 0; k < stackWidth; k++) {
                        stackPrintData += blank;
                    }
                } else {
                    stackPrintData = stackData;
                }
                out += stackPrintData;
                if (j == 2){
                    out += "\n";
                }
                tempStack[j].push(stackData);
                stack[j].pop();
            }
        }

        for (int i = 0; i < numberOfDiscs; i++) {
            for (int j = 0; j < 3; j++) {
                stackData = tempStack[j].top();
                stack[j].push(stackData);
                tempStack[j].pop();
            }
        }

        String stack = "";
        for (int i = 0; i < stackWidth; i++) {
            stack += dash;
        }
        stackPrintData = stack + stack + stack;
        out += stackPrintData + "\n";
        return out;
    }

    @Override
    public String toString() {
        return print();
    }
}
