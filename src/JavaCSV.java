import java.util.List;

public class JavaCSV {
    List<List<java.lang.String>> csv;

    public String[][] toArray(){
        String[][] stringArray = new String[csv.size()][csv.get(0).size()]; //First array is the row and second is the column
        for(int row = 0; row<stringArray.length; row++){ //Goes through the row
            for(int col = 0; col<stringArray[0].length; col++){ //Goes through the col
                stringArray[row][col] = csv.get(row).get(col); //Puts the String in a particular row and column in the array
            }
        }
        return stringArray;
    }

}
