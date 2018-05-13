package nl.scholtens.music.domain;

import javax.persistence.Column;

public class StartEndDate {

    @Column(name = "at_startdate")
    private String startDate;

    @Column(name = "at_enddate")
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
