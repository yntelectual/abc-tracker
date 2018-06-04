package sk.rain.men.abc.tracking.model.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import sk.rain.men.abc.tracking.db.ABCTrackingDatabase;
import sk.rain.men.abc.tracking.db.models.ChildEntity;

/**
 * Created by mmajchra on 27. 3. 2018.
 */

public class ChildViewModel extends AndroidViewModel {
   private LiveData<ChildEntity> mObservableChild;

    public ChildViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ChildEntity> getmObservableChild() {
        return mObservableChild;
    }

    public void init(long id) {
        mObservableChild = ABCTrackingDatabase.getInstance(getApplication()).childDao().getById(id);
    }

    public void setChild(ChildEntity child) {
        //this.mObservableChild.set(child);
    }

    public void insertNewChild(ChildEntity child) {
    }
}
