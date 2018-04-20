package sk.rain.men.abc.tracking.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import sk.rain.men.abc.tracking.R;
import sk.rain.men.abc.tracking.listeners.GenericListClickListener;
import sk.rain.men.abc.tracking.databinding.ListitemChildBinding;
import sk.rain.men.abc.tracking.db.models.ChildEntity;

/**
 * Created by mmajchra on 26. 3. 2018.
 */

public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter.ChildViewHolder> {

    List<? extends ChildEntity> mChildList;

    @Nullable
    private final GenericListClickListener mClickCallback;


    public ChildListAdapter(@Nullable GenericListClickListener clickCallback) {
        mClickCallback = clickCallback;
    }

    public void setChildList(final List<? extends ChildEntity> childList) {
        if (mChildList == null) {
            mChildList = childList;
            notifyItemRangeInserted(0, childList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mChildList.size();
                }

                @Override
                public int getNewListSize() {
                    return childList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mChildList.get(oldItemPosition).getId() == childList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    ChildEntity newChild = childList.get(newItemPosition);
                    ChildEntity oldChild = mChildList.get(oldItemPosition);
                    return newChild.getId() == oldChild.getId();
                }
            });
            mChildList = childList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListitemChildBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.listitem_child,
                        parent, false);
        binding.getRoot().setOnClickListener((x) -> {
            Toast.makeText(parent.getContext(), "click", Toast.LENGTH_LONG).show();
            mClickCallback.onItemClicked(binding.getChild());
        });
        return new ChildViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        holder.binding.setChild(mChildList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mChildList == null ? 0 : mChildList.size();
    }

    static class ChildViewHolder extends RecyclerView.ViewHolder {

        final ListitemChildBinding binding;

        public ChildViewHolder(ListitemChildBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
