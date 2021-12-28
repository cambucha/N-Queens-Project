public class Queen {

    private int column, row; //x coordinate, y coordinate

    //default constructor
    public Queen(){
    }

    public Queen(int x, int y){
        column = x;
        row = y;
    }

    public boolean conflict(Queen q){
        int rowCheck = 0;
        int columnCheck = 0;
        if(column == q.column)
            return true;

        while(rowCheck > 0 || columnCheck > 0){
            rowCheck--;
            columnCheck--;
            if(rowCheck == row && columnCheck == column)
                return true;
        }

        rowCheck = q.row;
        columnCheck = q.column;

        while(rowCheck > 0){
            rowCheck--;
            columnCheck++;
            if(rowCheck == row && columnCheck == column)
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String answer = "(row = " + column + "col = " + row + ")";

        return answer;
    }

    //do we need to throw any exceptions for any reason?
    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void setRow(int r) {
        row = r;
    }

    public void setColumn(int c) {
        column = c;
    }
}
