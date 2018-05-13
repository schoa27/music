package nl.scholtens.music.domain;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StartEndDate {

    @Column(name = "at_startdate")
    private String startDate;

    @Column(name = "at_enddate")
    private String endDate;

    @Override
    public String toString() {
        return "StartEndDate{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
