package sk.rain.men.abc.tracking.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by mmajchra on 23. 3. 2018.
 */

public class DBAdapters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
