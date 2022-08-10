import utilites.Calculator;
import utilites.Preproccessor;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String sourceDirectory = "C:\\Users\\Admin\\Desktop\\Praca magisterska R\\data\\RNN\\Data\\Stock_price_prediction\\Data\\Stocks";
        final String targetDirectory = "C:\\Users\\Admin\\Desktop\\Praca magisterska R\\data\\RNN\\Data\\Stock_price_prediction\\Data\\PreproccessedStocks";
        try {
            String[] pathnames;
            File f = new File(sourceDirectory);
            pathnames = f.list();
            for (String fileName : pathnames) {
                Calculator.setRSI_COUNTER(0);
                Calculator.setSMA_15_COUNTER(0);
                Calculator.setSMA_45_COUNTER(0);
                List<String[]> lines = Preproccessor.readFile(sourceDirectory + "\\" + fileName);
                List<String[]> newLines = Preproccessor.preproccessList(lines);
                Preproccessor.writeAllLinesToFile(newLines, Path.of(targetDirectory + "\\" + fileName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
