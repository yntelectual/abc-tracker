package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by mhorvath on 14.02.2018.
 */

public class AbcFormData extends SugarRecord {

    private int childId;
    private int aId;
    private int bId;
    private int cId;
    private Date creationDate;
    private String comment;

    public AbcFormData() {

    }

    public AbcFormData(int childId, int aId, int bId, int cId, Date creationDate, String comment) {
        this.childId = childId;
        this.aId = aId;
        this.bId = bId;
        this.cId = cId;
        this.creationDate = creationDate;
        this.comment = comment;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
