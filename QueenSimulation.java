public class QueenSimulation {

    public static void main(String args[]){

        Queen q1 = new Queen(3,3);
        Queen q2 = new Queen(4,4);

        System.out.println("The Queens are in conflict: " + q2.conflict(q1));

        int n = 4; //change to an input variable
        int row = 2;
        int column = 1;
        int solutions = 0;
        boolean exit = true;
        Queen queen = new Queen(1, 1);
        LinkedStack queenStack = new LinkedStack();
        queenStack.push(queen);


        //((Queen)queenStack.itemAt(queenStack.size()-1).getData()).getColumn() <= n
        while(exit){
            queen = new Queen(column,row);

            //exits main while loop if the stack is empty and the column of the first queen is out of bounds
            if(queenStack.size() == 1 && ((Queen) queenStack.itemAt(0).getData()).getColumn() >n) //look at exit logic
                exit = false;

            //if the stack size is equal to n queens, increment the number of solutions and start working backwards
            else if (queenStack.size() == n) {
                solutions++;
                Queen temp = (Queen) queenStack.pop();
                column = temp.getColumn()+1;
                row = temp.getRow();
            }

            //if queen to be written is out of bounds, work backwards
            else if(column > n || row > n){
                Queen temp = (Queen) queenStack.pop();
                column = temp.getColumn()+1;
                row = temp.getRow();
            }

            //check if queen to be written has any conflicts and adjust location accordingly
            else {

                boolean check = true;
                int listCounter = 0;

                while (listCounter < queenStack.size() && check) {

                    if (((Queen) queenStack.itemAt(listCounter).getData()).conflict(queen))
                        check = false;

                    listCounter++;

                }//end inner while

                if (!check) {
                    queenStack.push(queen);
                    row++;
                    column = 1;
                } else {
                    column++;
                }
            }//end big else


        }//end outer while

    }

}
