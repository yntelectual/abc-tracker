package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;
import com.orm.dsl.MultiUnique;

/**
 * Created by mhorvath on 14.02.2018.
 */
@MultiUnique("childId, behaviorId")
public class BehaviorForm extends SugarRecord {

    private int childId;
    private int behaviorId;

    public BehaviorForm() {

    }

    public BehaviorForm(int childId, int behaviorId, AbcType type) {
        this.childId = childId;
        this.behaviorId = behaviorId;
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
}
