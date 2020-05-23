import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class JBFileParser {
    /**
     * Takes a file as input. Uses a buffered reader to read the file line by line. Uses String.split() on each line with
     * the delimiter ',' putting each value into a list. Puts that list of values into a another list of lines.
     * A list of lines made up of a list of the values on each line.
     * @param file The file that will be parsed.
     * @return A List of Lists of Strings.
     * @throws IOException
     */
    public List<List<String>> parseFile(File file) throws IOException {

        List<List<String>> linesList = new ArrayList<List<String>>();
        String fileName = file.toString();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready()) {
            String currentLine = br.readLine();
            String[] lineAsStringArray = currentLine.split(",");
            List<String> line = Arrays.asList(lineAsStringArray);
            linesList.add(line);
        }
        return linesList;
    }

    public JTable toTable(JavaCSV csv){
        String[][] data = csv.toArray();
        String[] dataColumns = csv.getColumnNames();
        JTable table = new JTable(data, dataColumns);
        return table;
    }

    public static void main(String[] args){

        JBFileParser fp = new JBFileParser();
        File file = new File("C:/Users/Jabbe/OneDrive/Desktop/DataTestFile/convertcsv.csv");
        JavaCSV csv = new JavaCSV();

        try{
            csv.csv = fp.parseFile(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Print out list
        ListIterator iterator = csv.csv.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Put list in Table
        JFrame frame = new JFrame("Table");
        frame.setSize(750,750);
        frame.setVisible(true);

        JTable table = fp.toTable(csv);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.revalidate();
    }
}

