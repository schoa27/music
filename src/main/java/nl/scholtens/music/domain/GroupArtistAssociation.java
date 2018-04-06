package nl.scholtens.music.domain;

import javax.persistence.*;

@Table(name = "gp_at")
public class GroupArtistAssociation {

    @Id
    private int gp_id;

    @Id
    private int at_id;

    @Column(name = "at_startdate")
    private String startdate;

    @Column(name = "at_enddate")
    private String enddate;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="gp_id", referencedColumnName="gp_id")
    private Group group;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "at_id", referencedColumnName = "at_id")
    private Artist artist;


}
