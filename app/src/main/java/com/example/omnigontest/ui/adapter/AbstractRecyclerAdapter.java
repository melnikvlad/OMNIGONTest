package com.example.omnigontest.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.omnigontest.R;
import com.example.omnigontest.data.remote.model.UIObject;
import com.example.omnigontest.ui.adapter.viewholder.FixtureDateViewHolder;
import com.example.omnigontest.ui.adapter.viewholder.ResultDateViewHolder;
import com.example.omnigontest.ui.adapter.viewholder.EmptyViewHolder;
import com.example.omnigontest.ui.adapter.viewholder.FIxtureViewHolder;
import com.example.omnigontest.ui.adapter.viewholder.ResultViewHolder;

import java.util.List;

public abstract class AbstractRecyclerAdapter<T extends UIObject> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> mList;

    AbstractRecyclerAdapter(List<T> list) {
        super();
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case UIObject.TYPE_RESULT_AND_DATE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_result_and_date, viewGroup, false);
                return new ResultDateViewHolder(view);

            case UIObject.TYPE_FIXTURE_AND_DATE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_fixture_and_date, viewGroup, false);
                return new FixtureDateViewHolder(view);

            case UIObject.TYPE_FIXTURE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_fixture, viewGroup, false);
                return new FIxtureViewHolder(view);

            case UIObject.TYPE_RESULT:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_result, viewGroup, false);
                return new ResultViewHolder(view);

            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_empty, viewGroup, false);
                return new EmptyViewHolder(view);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (mList.get(position).getType()) {
            case UIObject.TYPE_FIXTURE:
                return UIObject.TYPE_FIXTURE;

            case UIObject.TYPE_RESULT:
                return UIObject.TYPE_RESULT;

            case UIObject.TYPE_RESULT_AND_DATE:
                return UIObject.TYPE_RESULT_AND_DATE;

            case UIObject.TYPE_FIXTURE_AND_DATE:
                return UIObject.TYPE_FIXTURE_AND_DATE;

            default:
                return -1;
        }
    }

    public void add(List<T> items) {
        mList.clear();
        mList.addAll(items);
        notifyDataSetChanged();
    }
}
