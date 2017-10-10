/**
 * Reverse.java - part of Homework 1 for UW CSE 373: Sound Blaster!
 * University of Washington, Summer 2017
 * @version CSE 373 17su
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Reverse is a sound manipulation program that reverses audio clips
 * from .dat file types. This process, called "backmasking," was used 
 * by musicians including the Beatles, Jimi Hendrix, and Ozzy Ozbourn
 * (see Wikipedia for more information: 
 * https://en.wikipedia.org/wiki/Backmasking). 
 * 
 * Usage: 
 * In the command-line, run
 *   java Reverse <stack type> <input file> <output file>
 * The Reverse program takes 3 command-line arguments:
 *   - <stack type>: the word "array" or "list" to specify 
 *                   which Stack implementation to use
 *   - <input file>: the path/filename to the input .dat file
 *   - <output file>: the path/filename to the output .dat file
 * 
 * Example usage:
 *   java Reverse list in.dat out.dat
 * 
 * Exceptions:
 * Reverse throws exceptions in the following cases:
 *  - Incorrect number of command-line arguments.
 *  - Errors in opening/reading/writing with the input or output files.
 *  - Incorrect file format for input and/or output files.
 */
public class Reverse {
    public static void main(String[]args) {

        // Check for the correct number of command-line arguments.
        if (args.length != 3) {
            System.err.println(" Incorrect number of arguments");
            System.err.println(" Usage: ");
            System.err.
            println("\tjava Reverse <stack type> <input file> <output file>");

            System.exit(1);
        }

        // Determine whether we're using a stack implemented with
        // a linked-list or with an array.
        boolean useList = true;
        if (args[0].compareTo("list") == 0)
            useList = true;
        else if (args[0].compareTo("array") == 0)
            useList = false;
        else {
            System.err.println("\tSaw " + args[0] + 
                " instead of list or array as first argument");
            System.exit(1);
        }

        try {
            // Set up the input file to read, and the output 
            // the file to write to.
            BufferedReader fileIn =
                new BufferedReader(new FileReader(args[1]));
            PrintWriter fileOut =
                new PrintWriter(new
            BufferedWriter(new FileWriter(args[2])));

            // Read the first line of the .dat file to get sample rate.
            // We want to store the sample rate value in a variable, 
            // but we can ignore the "; Sample Rate" part of the line. 
            // Step through the first line one token (word) at a time 
            // using the StringTokenizer.  The fourth token is the one
            // we want (the sample rate).

            // Read one line and break up it into "tokens".
            StringTokenizer str;
            String oneLine;
            oneLine = fileIn.readLine();
            str = new StringTokenizer(oneLine);
            
            // Skip the unneeded tokens ("; Sample Rate").
            str.nextToken();
            str.nextToken();
            str.nextToken();

            // Read in the sample rate.
            int sampleRate;
            sampleRate = Integer.parseInt(str.nextToken());   

            // Read in the remainder of the file on line at a time.
            // The values in the first column are thrown away. 
            // Place values from the second column on the stack.
            // Stop reading if we reach the end of the file.

            DStack stack;
            if (useList)
                stack = new ListStack();
            else
                stack = new ArrayStack();

            int count = 0;
            while ((oneLine = fileIn.readLine()) != null) {
                if (oneLine.charAt(0) == ';') {
                    continue;
                }
                str = new StringTokenizer(oneLine);

            // Skip the next token (the time step value from first column).
            str.nextToken(); 

            // Read in the data value from second column.
            double data;
            data = Double.parseDouble(str.nextToken());
            
            // DELETE THIS WHEN DONE ******
            System.out.println(data);
            // DELETE THIS WHEN DONE ******

            stack.push(data);
            count++;
            }

            System.out.println(count+" samples in file");
            

            // Print the data values to output .dat file.
            // First, output the header line:
            // "; Sample Rate <sample rate>"
            fileOut.println("; Sample Rate " + sampleRate);

            // Since the first column consists of numbers which start
            // at 0 and increase by 1/sampleRate every time slice, we'll
            // just use numSteps to recalculate these numbers.
            int numSteps = 0;

            // Finally, we print the values in reverse order (by popping
            // them off the stack). The first column consists of numbers
            // which start at 0 and increase by 1/sampleRate per row, so
            // we'll use numSteps/sampleRate to recalculate the 
            // appropriate values. Print a tab for uniform spacing.
            while (!stack.isEmpty()) {
            	fileOut.println((double) numSteps / sampleRate + "\t" +
                        stack.pop());
                numSteps++;
            }

            // Be proper and close all of our files.
            fileIn.close();
            fileOut.close();

        } catch(IOException ioe) {
            System.err.println(
                "Error opening/reading/writing input or output file.");
            System.exit(1);
        } catch(NumberFormatException nfe) {
            System.err.println(nfe.toString());
            System.err.println("Error in file format");
            System.exit(1);
        }
    }
}
