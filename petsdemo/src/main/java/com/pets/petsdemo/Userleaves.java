package com.pets.petsdemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_applications2")
public class Userleaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fromdate")
    private String fromdate;

    @Column(name = "todate")
    private String todate;

    @Column(name = "leavetype")
    private String leavetype;

    @Column(name = "leavereason")
    private String leavereason;

    @Column(name = "file_path")
    private String filePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(String leavereason) {
        this.leavereason = leavereason;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Userleaves [id=" + id + ", fromdate=" + fromdate + ", todate=" + todate + ", leavetype=" + leavetype
                + ", leavereason=" + leavereason + ", filePath=" + filePath + "]";
    }

    

}
