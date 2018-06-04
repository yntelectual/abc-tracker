package sk.rain.men.abc.tracking.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import sk.rain.men.abc.tracking.R;
import sk.rain.men.abc.tracking.activities.ChildDetailActivity;
import sk.rain.men.abc.tracking.activities.ChildListActivity;
import sk.rain.men.abc.tracking.databinding.ChildDetailFragmentBinding;
import sk.rain.men.abc.tracking.db.models.ChildEntity;
import sk.rain.men.abc.tracking.model.viewmodels.ChildViewModel;

/**
 * A fragment representing a single ChildItem detail screen.
 * This fragment is either contained in a {@link ChildListActivity}
 * in two-pane mode (on tablets) or a {@link ChildDetailActivity}
 * on handsets.
 */
public class ChildDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private ChildDetailFragmentBinding mBinding;
    private ChildViewModel model;

    public ChildDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.child_detail_fragment, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = ViewModelProviders.of(this).get(ChildViewModel.class);
        model.init(getArguments().getLong(ARG_ITEM_ID));
        subscribeToModel(model);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.child_add,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.saveChildMenuItem == item.getItemId()){
            model.insertNewChild(mBinding.getChild());
        }
        return super.onOptionsItemSelected(item);
    }

    private void subscribeToModel(final ChildViewModel model) {

        // Observe product data
        model.getmObservableChild().observe(this, new Observer<ChildEntity>() {
            @Override
            public void onChanged(@Nullable ChildEntity productEntity) {
                Log.i("DetailFragment", "onChanged " + productEntity);
                mBinding.setChild(productEntity);
                model.setChild(productEntity);
            }
        });
    }

}
