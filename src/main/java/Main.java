import utilites.Preproccessor;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String[]> lines = Preproccessor.readFile("src/main/resources/a.us.txt");
            List<String[]> newLines = Preproccessor.preproccessList(lines);
            Preproccessor.writeAllLinesToFile(newLines, Path.of("src/main/output/a.us.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
