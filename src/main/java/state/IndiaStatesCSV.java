package state;

import com.opencsv.bean.CsvBindByName;

public class IndiaStatesCSV {

    @CsvBindByName(column = "SrNo", required = true)
    public String srNo;

    @CsvBindByName(column = "State Name", required = true)
    public int stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int TIN;

    @CsvBindByName(column = "StateCode", required = true)
    public int stateCode;

}
