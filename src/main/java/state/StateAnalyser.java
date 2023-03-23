package state;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateAnalyser {

    public int loadIndiaStateData(String csvFilePath) throws StateAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaStatesCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaStatesCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaStatesCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaStatesCSV> censusCSVIterator = csvToBean.iterator();;
            int numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new StateAnalyserException(e.getMessage(),
                    StateAnalyserException.ExceptionType.STATE_FILE_PROBLEM);
        }
    }
}
