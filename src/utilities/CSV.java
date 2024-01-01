package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * The CSV class provides a utility method to read data from a CSV file and return it as a list.
 */
public class CSV {

    /**
     * This method reads data from a CSV file and returns it as a list of String arrays.
     * Each String array represents a line in the file.
     * @param file The file path of the CSV file to be read.
     * @return A List of String arrays, each representing a line from the file.
     */
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);  
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading file: " + file);
            e.printStackTrace();
        }
        return data;
    }
}
