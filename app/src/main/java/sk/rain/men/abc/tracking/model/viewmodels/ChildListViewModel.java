package sk.rain.men.abc.tracking.model.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import java.util.List;

import sk.rain.men.abc.tracking.db.ABCTrackingDatabase;
import sk.rain.men.abc.tracking.db.models.ChildEntity;

/**
 * Created by mmajchra on 26. 3. 2018.
 */
public class ChildListViewModel extends AndroidViewModel {
    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<ChildEntity>> mObservableProducts;

    public ChildListViewModel(Application application) {
        super(application);

        mObservableProducts = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableProducts.setValue(null);

        LiveData<List<ChildEntity>> products = ABCTrackingDatabase.getInstance(application).childDao().getAllLiveData();

        // observe the changes of the products from the database and forward them
        mObservableProducts.addSource(products, mObservableProducts::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<ChildEntity>> getChildren() {
        return mObservableProducts;
    }
}
