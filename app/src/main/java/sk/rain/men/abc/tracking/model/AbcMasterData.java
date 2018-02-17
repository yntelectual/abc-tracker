package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;

/**
 * Created by mhorvath on 14.02.2018.
 */

public class AbcMasterData extends SugarRecord {

    private String name;
    private String description;
    private AbcType type;

    public AbcMasterData() {

    }

    public AbcMasterData(String name, String description, AbcType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AbcType getType() {
        return type;
    }

    public void setType(AbcType type) {
        this.type = type;
    }
}
