package com.example.omnigontest.ui.fixtures.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.omnigontest.R;
import com.example.omnigontest.data.remote.model.beans.Fixture;
import com.example.omnigontest.utils.DateUtils;

import java.util.List;
import java.util.Objects;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.FixtureVH> {
    private Context mContext;
    private List<Fixture> mList;

    public FixturesAdapter(Context context, List<Fixture> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public FixtureVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View fixtureVH = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_fixture_info, viewGroup, false);
        return new FixtureVH(fixtureVH);
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureVH fixtureVH, int i) {
        fixtureVH.bind(mList.get(fixtureVH.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void add(List<Fixture> fixtures) {
        mList.addAll(fixtures);
        notifyDataSetChanged();
    }

    class FixtureVH extends RecyclerView.ViewHolder {
        private TextView textCompetition;
        private TextView textVenue;
        private TextView textDate;
        private TextView textHomeTeam;
        private TextView textAwayTeam;
        private TextView textMonthDay;
        private TextView textWeekDay;
        private TextView postponedView;

        FixtureVH(@NonNull View v) {
            super(v);
            textCompetition = v.findViewById(R.id.text_competition);
            textVenue = v.findViewById(R.id.text_venue);
            textDate = v.findViewById(R.id.text_date);
            textHomeTeam = v.findViewById(R.id.text_team_1);
            textAwayTeam = v.findViewById(R.id.text_team_2);
            textMonthDay = v.findViewById(R.id.text_month_day);
            textWeekDay = v.findViewById(R.id.text_week_day);
            postponedView = v.findViewById(R.id.text_postponed);
        }

        void bind(final Fixture item) {
            textCompetition.setText(item.competitionStage.competition.name);
            textVenue.setText(item.venue.name);
            textDate.setText(String.format(mContext.getString(R.string.date_long_templ), DateUtils.parseDate(item.date)));
            textHomeTeam.setText(item.homeTeam.name);
            textAwayTeam.setText(item.awayTeam.name);
            textMonthDay.setText(DateUtils.parseMonthDay(item.date));
            textWeekDay.setText(DateUtils.parseWeekDay(item.date));

            if (Objects.equals(item.state, "postponed")) {
                postponedView.setVisibility(View.VISIBLE);
                textDate.setTextColor(ContextCompat.getColor(mContext, R.color.red));
            } else {
                postponedView.setVisibility(View.INVISIBLE);
                textDate.setTextColor(Color.GRAY);
            }
        }
    }
}
