
import org.junit.Assert;
import org.junit.Test;
import state.StateAnalyser;
import state.StateAnalyserException;

public class StateAnalyserTest {
    private static final String INDIA_STATE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_CSV_FILE_TYPE = "./src/test/resources/IndiaStateCode.txt";


    @Test
    public void givenIndianStateCSVFileReturnsCorrectRecords() {
        try {
            StateAnalyser stateAnalyser = new StateAnalyser();
            int numOfRecords = stateAnalyser.loadIndiaStateData(INDIA_STATE_CSV_FILE_PATH);
            Assert.assertEquals(37, numOfRecords);
        } catch (StateAnalyserException e) {
        }
    }

    @Test
    public void givenIndiaStateData_WithWrongFile_ShouldThrowException() {
        try {
            StateAnalyser stateAnalyser = new StateAnalyser();
            stateAnalyser.loadIndiaStateData(WRONG_CSV_FILE_PATH);
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.STATE_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaStateData_WithWrongType_ShouldThrowException() {
        try {
            StateAnalyser stateAnalyser = new StateAnalyser();
            stateAnalyser.loadIndiaStateData(WRONG_CSV_FILE_TYPE);
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.STATE_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaStateData_WithWrongHeader_ShouldThrowException() {
        try {
            StateAnalyser stateAnalyser = new StateAnalyser();
            stateAnalyser.loadIndiaStateData(INDIA_STATE_CSV_FILE_PATH);
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.STATE_FILE_PROBLEM, e.type);
        }
    }
}
