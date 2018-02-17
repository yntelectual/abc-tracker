package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by mhorvath on 14.02.2018.
 */

public class BehaviorStrategy extends SugarRecord {

    private int childId;
    private int behaviorId;
    private Date creationDate;
    private StrategyType type;
    private String description;

    public BehaviorStrategy() {

    }

    public BehaviorStrategy(int childId, int behaviorId, Date creationDate, StrategyType type, String description) {
        this.childId = childId;
        this.behaviorId = behaviorId;
        this.creationDate = creationDate;
        this.type = type;
        this.description = description;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public StrategyType getType() {
        return type;
    }

    public void setType(StrategyType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
