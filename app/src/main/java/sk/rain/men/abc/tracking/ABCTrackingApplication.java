package sk.rain.men.abc.tracking;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by mmajchra on 19. 3. 2018.
 */

public class ABCTrackingApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
