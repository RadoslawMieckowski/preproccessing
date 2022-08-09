package utilites;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Preproccessor {

    private Preproccessor() {

    }

    public static List<String[]> readFile(String fileName) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines.collect(Collectors.toList());
        }
        return result.stream().map(line -> line.split(",")).collect(Collectors.toList());
    }

    public static  List<String[]> preproccessList(List<String[]> list) {
        List<String[]> newList = new LinkedList<>();
        String[] array = new String[10];
        System.arraycopy(list.get(0), 0, array, 0, 6);
        array[6] = "RSI";
        array[7] = "SMA(15)";
        array[8] = "SMA(45)";
        array[9] = "OpenInt";
        newList.add(array);
        list.stream()
            .skip(1)
            .map(Preproccessor::addAveragesAndRSIColumns)
            .forEach(element -> newList.add(element));
        return newList;
    }

    private static String[] addAveragesAndRSIColumns(String[] record) {
        String[] array = new String[10];
        System.arraycopy(record, 0, array, 0, 6);
        array[6] = String.valueOf(Calculator.calculateRSI(14));
        array[7] = String.valueOf(Calculator.calculateSimpleMovingAverage15(4));
        array[8] = String.valueOf(Calculator.calculateSimpleMovingAverage45(4));
        array[9] = "0";
        return array;
    }

//    public static List<String> toListOfStrings(List list) {
//        list.stream().map(array -> String.join(",", Arrays.stream(array)));
//    }

    public static void writeAllLinesToFile(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(lines);
        }
    }
}
