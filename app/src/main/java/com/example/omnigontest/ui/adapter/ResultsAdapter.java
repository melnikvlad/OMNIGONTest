package com.example.omnigontest.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.omnigontest.data.remote.model.ResultUI;
import com.example.omnigontest.data.remote.model.UIObject;
import com.example.omnigontest.ui.adapter.viewholder.ResultDateViewHolder;
import com.example.omnigontest.ui.adapter.viewholder.ResultViewHolder;

import java.util.List;

public class ResultsAdapter extends AbstractRecyclerAdapter<ResultUI> {

    private final Context mContext;

    public ResultsAdapter(Context context, List<ResultUI> list) {
        super(list);
        mContext = context;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder vh, int i) {
        ResultUI item = mList.get(vh.getAdapterPosition());

        if (item.getType() == UIObject.TYPE_RESULT) {
            ((ResultViewHolder) vh).bind(mContext, item.getResult());
        } else {
            ((ResultDateViewHolder) vh).bind(mContext, item.getResult(), item.getDate());
        }
    }
}
