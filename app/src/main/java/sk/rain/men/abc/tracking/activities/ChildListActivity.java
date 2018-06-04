package sk.rain.men.abc.tracking.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import sk.rain.men.abc.tracking.R;
import sk.rain.men.abc.tracking.db.models.ChildEntity;
import sk.rain.men.abc.tracking.fragments.ChildDetailFragment;
import sk.rain.men.abc.tracking.fragments.ChildListFragment;
import sk.rain.men.abc.tracking.listeners.GenericListClickListener;

/**
 * An activity representing a list of ChildItems. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ChildDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ChildListActivity extends AppCompatActivity implements GenericListClickListener<ChildEntity> {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.childitem_detail_container) != null) {
            // The detail container view will be present only in the large-screen layouts (res/values-w900dp).
            // If this view is present, then the activity should be in two-pane mode.
            mTwoPane = true;
        }

        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            ChildListFragment fragment = ChildListFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.list_fragment_container, fragment, ChildListFragment.TAG).commit();
        }
    }

    @Override
    public void onItemClicked(ChildEntity item) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putLong(ChildDetailFragment.ARG_ITEM_ID, item.getId());
            ChildDetailFragment fragment = new ChildDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.childitem_detail_container, fragment)
                    .commit();
        } else {
            Context context = getApplicationContext();
            Intent intent = new Intent(context, ChildDetailActivity.class);
            intent.putExtra(ChildDetailFragment.ARG_ITEM_ID, item.getId());

            context.startActivity(intent);
        }
    }
}
