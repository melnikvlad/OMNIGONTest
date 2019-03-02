package com.example.omnigontest.ui.adapter;

import android.content.Context;
import android.provider.Contacts;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.omnigontest.data.remote.model.FixtureUI;
import com.example.omnigontest.data.remote.model.UIObject;
import com.example.omnigontest.ui.adapter.viewholder.FIxtureViewHolder;
import com.example.omnigontest.ui.adapter.viewholder.FixtureDateViewHolder;

import java.util.List;

public class FixturesAdapter extends AbstractRecyclerAdapter<FixtureUI> {

    private final Context mContext;

    public FixturesAdapter(Context context, List<FixtureUI> list) {
        super(list);
        mContext = context;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder vh, int pos) {
        FixtureUI item = mList.get(vh.getAdapterPosition());

        if (item.getType() == UIObject.TYPE_FIXTURE) {
            ((FIxtureViewHolder) vh).bind(mContext, item.getFixture());
        } else {
            ((FixtureDateViewHolder) vh).bind(mContext, item.getFixture(), item.getDate());
        }


    }
}
