package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;

/**
 * Created by mhorvath on 14.02.2018.
 */

public class AbcForm extends SugarRecord {

    private long childId;
    private long abcId;

    public AbcForm() {

    }

    public AbcForm(long childId, long abcId) {
        this.childId = childId;
        this.abcId = abcId;
    }

    public long getChildId() {
        return childId;
    }

    public void setChildId(long childId) {
        this.childId = childId;
    }

    public long getAbcId() {
        return abcId;
    }

    public void setAbcId(long abcId) {
        this.abcId = abcId;
    }
}
