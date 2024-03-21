package com.arch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IngeniousFileUtils {
    /**
     * Given a file, parses each set of 4 lines into {@link IngeniousDigitList}s
     * @param ingeniousFile the file to parse
     * @return a {@link List} containing {@link IngeniousDigitList}s for each set of four lines
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<IngeniousDigitList> readIngeniousFile(File ingeniousFile) throws FileNotFoundException, IOException {
        List<IngeniousDigitList> digitLists = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(ingeniousFile))){
            while(true){
                String firstLine = reader.readLine();
                if(firstLine == null){
                    break;
                }
                // Each entry is 4 lines long, ...
                // The first 3 lines of each entry contain an account number written using pipes and underscores ...
                StringBuilder digits = new StringBuilder(firstLine).append('\n')
                    .append(reader.readLine()).append('\n')
                    .append(reader.readLine()).append('\n');

                // and the fourth line is blank.
                reader.readLine();

                digitLists.add(new IngeniousDigitList(digits.toString()));
            }
        }

        return digitLists;
    }

    /**
     * Writes validation information for IngeniousDigitLists by way of {@link IngeniousDigitList#toStringWithValidation()}
     * @param ingeniousEntires the {@link Collection} of {@link IngeniousDigitLists}
     * @param outFile the file to write this information to
     * @throws IOException
     */
    public static void writeValidationData(Collection<IngeniousDigitList> ingeniousEntires, File outFile) throws IOException {
        try(PrintWriter writer = new PrintWriter(outFile)){
            for(IngeniousDigitList idl : ingeniousEntires){
                writer.println(idl.toStringWithValidation());
            }
        }
    }
}
