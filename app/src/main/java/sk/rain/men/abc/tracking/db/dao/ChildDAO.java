package sk.rain.men.abc.tracking.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sk.rain.men.abc.tracking.db.models.ChildEntity;

/**
 * Created by mmajchra on 23. 3. 2018.
 */
@Dao
public interface ChildDAO {

    @Query("SELECT * FROM child")
    List<ChildEntity> getAll();

    @Query("SELECT * FROM child")
    LiveData<List<ChildEntity>> getAllLiveData();

    @Query("SELECT * FROM child WHERE name LIKE :first or surname LIKE :last")
    ChildEntity findByName(String first, String last);

    @Insert
    void insert(ChildEntity newChild);

    @Update
    void update(ChildEntity newChild);

    @Delete
    void delete(ChildEntity child);

    @Query("SELECT * FROM child WHERE id = :id")
    LiveData<ChildEntity> getById(long id);
}
