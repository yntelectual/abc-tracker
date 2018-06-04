package sk.rain.men.abc.tracking.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sk.rain.men.abc.tracking.R;
import sk.rain.men.abc.tracking.activities.AddChildActivity;
import sk.rain.men.abc.tracking.activities.ChildDetailActivity;
import sk.rain.men.abc.tracking.adapter.ChildListAdapter;
import sk.rain.men.abc.tracking.databinding.ChildListFragmentBinding;
import sk.rain.men.abc.tracking.db.models.ChildEntity;
import sk.rain.men.abc.tracking.listeners.GenericListClickListener;
import sk.rain.men.abc.tracking.model.viewmodels.ChildListViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GenericListClickListener} interface
 * to handle interaction events.
 * Use the {@link ChildListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildListFragment extends Fragment {
    public static final String TAG = "ChildListFragment";
    private GenericListClickListener<?> mListener;
    private ChildListFragmentBinding mBinding;
    private ChildListAdapter mChildAdapter;

    public ChildListFragment() {
    }

    public static ChildListFragment newInstance() {
        ChildListFragment fragment = new ChildListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.child_list_fragment, container, false);
        mBinding.fabAddChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Context context = getActivity().getApplicationContext();
                Intent intent = new Intent(context, AddChildActivity.class);
                context.startActivity(intent);

            }
        });
        mChildAdapter = new ChildListAdapter(mListener);
        mBinding.childListView.setAdapter(mChildAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ChildListViewModel viewModel = ViewModelProviders.of(this).get(ChildListViewModel.class);

        subscribeUi(viewModel);
    }

    private void subscribeUi(ChildListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getChildren().observe(this, new Observer<List<ChildEntity>>() {
            @Override
            public void onChanged(@Nullable List<ChildEntity> myChilds) {
                Log.i("ChildListFragment", "************Children list chagned " + myChilds);
                if (myChilds != null) {
                    mBinding.setIsLoading(false);
                    mChildAdapter.setChildList(myChilds);
                } else {
                    mBinding.setIsLoading(true);
                }
                // espresso does not know how to wait for data binding's loop so we execute changes sync.
                mBinding.executePendingBindings();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GenericListClickListener) {
            mListener = (GenericListClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement GenericListClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
