package state;

public class StateAnalyserException extends Exception{

    public enum ExceptionType {
        STATE_FILE_PROBLEM;
    }

    public StateAnalyserException.ExceptionType type;

    public StateAnalyserException(String message, StateAnalyserException.ExceptionType type) {
        super(message);
        this.type = type;
    }

    public StateAnalyserException(String message, StateAnalyserException.ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}

