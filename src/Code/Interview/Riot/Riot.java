package Code.Interview.Riot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 It has recently come to light that SHA1 is something to 
 start moving away from.
 
 Let�s say I�ve got a directory tree of mixed content:
    html, xml and json files.  
 These files have references to SHA1 sums of software packages,
 and links to downloads.

 I�d like to search all of those files for any strings that look like
 SHA1 Sums (eg: 2e1bd26dbfc73d361ae3de0fd200db202f0b56f9), and see a
 few things: 
 
 * a list of file�s (that contain the sha) to sha1, for example:
  
    ./README.TXT   2e1bd26dbfc73d361ae3de0fd200db202f0b56f9
    ./README.TXT   16deb290ff05ed015abd576d365278edfd882c6a
    . . . and so on . . .

 * a count of sha1s per file, for example:

    ./README.TXT   42
    ./index.html   73
    . . . and so on . . .

 * an ordered list of sha1�s by frequency, for example:

    3  2e1bd26dbfc73d361ae3de0fd200db202f0b56f9
    9  16deb290ff05ed015abd576d365278edfd882c6a
    . . . and so on . . .

 * BONUS: a summary of the directory tree with counts

    7492 ./
    74   ./docs
    1072 ./lib/ 
    423  ./lib/riot-core-remoting/
    . . . and so on . . .

 Would you kindly talk through your approach for solving this and 
 sketch out a process and supporting code for finding this info?

 here�s an example of what the directory structure looks like:

 ./README.txt
 ./index.html
 ./docs/intro.html
 ./docs/architecture.html
 ./lib/riot-core-remoting/secrets.cpp
    . . . and so on . . .
*/

public class Riot {

    // Object to hold processed files the Key will be the file path and the List
    // will be a list of SHAs found in the file
    static Map<String, ArrayList<String>> shaList = new LinkedHashMap<>();

    // Comparator to sort by value
    static Comparator<Entry<String, Integer>> valueComparator = (e1, e2) -> {
        Integer v1 = e1.getValue();
        Integer v2 = e2.getValue();
        return v1.compareTo(v2);
    };

    // Comparator to sort by path depth
    static Comparator<Entry<String, Integer>> depthComparatorBonus = (e1, e2) -> {
        Integer v1 = e1.getKey().length() - e1.getKey().replace(File.separator, "").length();
        Integer v2 = e2.getKey().length() - e2.getKey().replace(File.separator, "").length();
        return v1.compareTo(v2);
    };

    // Comparator to sort by path depth
    static Comparator<Entry<String, ArrayList<String>>> depthComparator = (e1, e2) -> {
        Integer v1 = e1.getKey().length() - e1.getKey().replace(File.separator, "").length();
        Integer v2 = e2.getKey().length() - e2.getKey().replace(File.separator, "").length();
        return v1.compareTo(v2);
    };

    public static void main(String[] argv) throws Exception {

        // Folder of source files
        String folderPath = "c:/test";

        // RegEX definition
        String regex = "[a-f0-9]{40}";

        // Process all files recursively
        processFiles(folderPath, regex);

        // Print all SHA's sorted by source file
        System.out.println("Print Case 1: SHA's sorted by source file\n");
        printShaPerFile();

        // Print SHA count per file
        System.out.println("\nPrint Case 2: SHA count per file\n");
        printShaCountPerFile();

        // Print Ordered list of number of times a SHA is found
        System.out.println("\nPrint Case 3: Ordered list of SHA instance count\n");
        printShaCount();

        // Print Ordered list of number of times a SHA is found per directory
        System.out.println("\nBonus Case: SHA count per directory\n");
        printBonus();
    }

    // Print Ordered list of number of times a SHA is found per directory
    private static void printBonus() {

        Map<String, Integer> shaBonus = new LinkedHashMap<>();
        for (String key : shaList.keySet()) {
            String path = key.substring(0, key.lastIndexOf(File.separator) + 1);

            Integer count = shaList.get(key).size();
            shaBonus.merge(path, count, Integer::sum);
        }

        Set<Entry<String, Integer>> keySet = shaBonus.entrySet();

        List<Entry<String, Integer>> keySetList = new ArrayList<>(keySet);

        keySetList.sort(depthComparatorBonus);

        LinkedHashMap<String, Integer> sorteMap = new LinkedHashMap<>(keySetList.size());

        for (Entry<String, Integer> key : keySetList) {
            sorteMap.put(key.getKey(), key.getValue());
        }

        Set<Entry<String, Integer>> entrySetSortedByValue = sorteMap.entrySet();

        for (Entry<String, Integer> mapping : entrySetSortedByValue) {
            System.out.format("%-5s  %s\n", mapping.getValue(), mapping.getKey());
        }
    }

    // Print Ordered list of number of times a SHA is found
    private static void printShaCount() {

        // Object to hold the sha counts per file
        Map<String, Integer> shacount = new LinkedHashMap<>();

        for (String key : shaList.keySet()) {
            for (String sha : shaList.get(key)) {
                shacount.merge(sha, 1, Integer::sum);
            }
        }

        Set<Entry<String, Integer>> keySet = shacount.entrySet();

        List<Entry<String, Integer>> keySetList = new ArrayList<>(keySet);

        keySetList.sort(valueComparator);

        LinkedHashMap<String, Integer> sortMap = new LinkedHashMap<>(keySetList.size());

        for (Entry<String, Integer> key : keySetList) {
            sortMap.put(key.getKey(), key.getValue());
        }

        Set<Entry<String, Integer>> entrySetSortedByValue = sortMap.entrySet();

        for (Entry<String, Integer> mapping : entrySetSortedByValue) {
            System.out.format("%-5s  %s\n", mapping.getValue(), mapping.getKey());
        }
    }

    // Print SHA count per file
    private static void printShaCountPerFile() {

        Set<Entry<String, ArrayList<String>>> keySet = shaList.entrySet();

        List<Entry<String, ArrayList<String>>> keySetList = new ArrayList<>(keySet);

        keySetList.sort(depthComparator);

        LinkedHashMap<String, ArrayList<String>> sorteMap = new LinkedHashMap<>(
                keySetList.size());

        for (Entry<String, ArrayList<String>> key : keySetList) {
            sorteMap.put(key.getKey(), key.getValue());
        }

        Set<Entry<String, ArrayList<String>>> entrySetSortedByValue = sorteMap.entrySet();

        for (Entry<String, ArrayList<String>> mapping : entrySetSortedByValue) {
            System.out.format("%s  %s\n", mapping.getKey(), mapping.getValue().size());
        }
    }

    // Print all SHA's sorted by source file
    private static void printShaPerFile() {

        Set<Entry<String, ArrayList<String>>> keySet = shaList.entrySet();

        List<Entry<String, ArrayList<String>>> keySetList = new ArrayList<>(keySet);

        keySetList.sort(depthComparator);

        LinkedHashMap<String, ArrayList<String>> sortMap = new LinkedHashMap<>(
                keySetList.size());

        for (Entry<String, ArrayList<String>> key : keySetList) {
            sortMap.put(key.getKey(), key.getValue());
        }

        Set<Entry<String, ArrayList<String>>> entrySetSortedByValue = sortMap.entrySet();

        for (Entry<String, ArrayList<String>> mapping : entrySetSortedByValue) {
            for (String value : mapping.getValue()) {
                System.out.format("%s  %s\n", mapping.getKey(), value);
            }
        }
    }

    private static void processFile(String filename, Pattern pattern) throws IOException {
        @SuppressWarnings("resource")
        FileInputStream inputStream = new FileInputStream(filename);
        FileChannel fc = inputStream.getChannel();

        ByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc.size());
        CharBuffer characterBuffer = StandardCharsets.ISO_8859_1.newDecoder().decode(byteBuffer);
        Matcher matcher = pattern.matcher(characterBuffer);

        // Create list to hold SHA's
        ArrayList<String> shaValues = new ArrayList<>();

        // Find all matches to the defined RegEx
        while (matcher.find()) {
            shaValues.add(matcher.group());
        }

        shaList.put(filename, shaValues);
    }

    // Process all files recursively
    private static void processFiles(String folderPath, String regex) throws IOException {

        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        Pattern pattern = Pattern.compile(regex);

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                processFile(listOfFile.getAbsolutePath(), pattern);
            } else if (listOfFile.isDirectory()) {
                processFiles(listOfFile.getAbsolutePath(), regex);
            }
        }

    }
}
