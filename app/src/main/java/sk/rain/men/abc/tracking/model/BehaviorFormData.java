package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by mhorvath on 14.02.2018.
 */

public class BehaviorFormData extends SugarRecord {

    private int childId;
    private int behaviorId;
    private Date startDate;
    private Date endDate;
    // In seconds
    private float duration;

    public BehaviorFormData() {

    }

    public BehaviorFormData(int childId, int behaviorId, Date startDate, Date endDate, float duration) {
        this.childId = childId;
        this.behaviorId = behaviorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(int behaviorId) {
        this.behaviorId = behaviorId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
