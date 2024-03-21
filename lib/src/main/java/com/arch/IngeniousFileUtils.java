package com.arch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
}