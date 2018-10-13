import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Provides file utility methods for creating arrays of strings when reading from files, and
 * writing arrays of strings to a file
 *
 * @author Andrew Madden
 * @version 26 April 2018
 */
public class FileUtility {
    private FileUtility() {}

    private static final String TAG = "FileUtility";

    /**
     * Reads data from file returning the lines as a list, or null if error
     * @param  fileName pathname
     * @return          collection of strings
     */
    public static ArrayList<String> readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> data = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                data.add(line);
                line = reader.readLine();
            }
            reader.close();
            return data;

        } catch (FileNotFoundException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        }
        return null;
    }

    /**
     * Reads data from file returning the lines as a list, or null if error
     * @param  fileName file object
     * @return          collection of strings
     */
    public static ArrayList<String> readFromFile(File fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> data = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                data.add(line);
                line = reader.readLine();
            }
            reader.close();
            return data;

        } catch (FileNotFoundException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        }
        return null;
    }

    /**
     * Reads data from file returning the lines as a list, or null if error
     * @param  fileInputStream input stream from raw file
     * @return          collection of strings
     */
    public static ArrayList<String> readFromFile(InputStream fileInputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            ArrayList<String> data = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                data.add(line);
                line = reader.readLine();
            }
            reader.close();
            return data;

        } catch (FileNotFoundException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        }
        return null;
    }

    /**
     * Write data to file
     * @param fileName pathname
     * @param data     collection of strings
     */
    public static void writeToFile(String fileName, ArrayList<String> data) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            Iterator<String> itData = data.iterator();
            while (itData.hasNext()) {
                writer.println(itData.next());
            }
            writer.close();

        } catch(IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        }
    }


    /**
     * Write data to file
     * @param fileName file object
     * @param data     collection of strings
     */
    public static void writeToFile(File fileName, ArrayList<String> data) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            Iterator<String> itData = data.iterator();
            while (itData.hasNext()) {
                writer.println(itData.next());
            }
            writer.close();

        } catch(IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        }
    }


    /**
     * Write data to file
     * @param fileName pathname
     * @param data     collection of strings
     */
    public static void appendToFile(String fileName, ArrayList<String> data) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            Iterator<String> itData = data.iterator();
            while (itData.hasNext()) {
                writer.println(itData.next());
            }
            writer.close();

        } catch(IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
        }
    }

    /**
     * Write data to file
     * @param fileName file object
     * @param data     collection of strings
     */
    public static boolean appendToFile(File fileName, ArrayList<String> data) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            Iterator<String> itData = data.iterator();
            while (itData.hasNext()) {
                writer.println(itData.next());
            }
            writer.close();
            return true;

        } catch(IOException e) {
            Log.e(TAG, "readFromFile: " + e.getMessage());
            return false;
        }
    }
}
