package sk.rain.men.abc.tracking.db;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.Executors;

import sk.rain.men.abc.tracking.db.dao.ChildDAO;
import sk.rain.men.abc.tracking.db.models.ChildEntity;

/**
 * Created by mmajchra on 19. 3. 2018.
 */
@Database(entities = {ChildEntity.class}, version = 1)
@TypeConverters({DBAdapters.class})
public abstract class ABCTrackingDatabase extends RoomDatabase {

    private static final String TAG = "ABCTrackingDatabase";
    private static ABCTrackingDatabase instance;

    public abstract ChildDAO childDao();

    public static ABCTrackingDatabase getInstance(final Context context) {
        if (instance == null) {
            synchronized (ABCTrackingDatabase.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(), ABCTrackingDatabase.class, "abc.db").addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadExecutor().execute(() -> {
                            Log.i(ABCTrackingDatabase.TAG, "Init data start:");
                            // Add a delay to simulate a long-running operation
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException ignored) {
                            }
                            // Generate the data for pre-population


                            ChildEntity e = new ChildEntity();
                            e.setName("Janko");
                            e.setSurname("Testovaci");
                            ChildEntity e1 = new ChildEntity();
                            e1.setName("Misko");
                            e1.setSurname("Pokusny");
                            instance.childDao().insert(e);
                            instance.childDao().insert(e1);
                            Log.i(ABCTrackingDatabase.TAG, "Init data finished:");
                        });
                    }
                }).build();
            }

        }
        return instance;
    }
}
