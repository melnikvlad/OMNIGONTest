package com.example.omnigontest.ui.adapter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.omnigontest.R;
import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.utils.DateUtils;

import java.util.Objects;

public class FixtureDateViewHolder extends RecyclerView.ViewHolder {

    private TextView textHeaderDate;
    private TextView textCompetition;
    private TextView textVenue;
    private TextView textDate;
    private TextView textHomeTeam;
    private TextView textAwayTeam;
    private TextView textMonthDay;
    private TextView textWeekDay;
    private TextView postponedView;


    public FixtureDateViewHolder(@NonNull View v) {
        super(v);
        textHeaderDate = v.findViewById(R.id.text_month_date);
        textCompetition = v.findViewById(R.id.text_competition);
        textVenue = v.findViewById(R.id.text_venue);
        textDate = v.findViewById(R.id.text_date);
        textHomeTeam = v.findViewById(R.id.text_team_1);
        textAwayTeam = v.findViewById(R.id.text_team_2);
        textMonthDay = v.findViewById(R.id.text_month_day);
        textWeekDay = v.findViewById(R.id.text_week_day);
        postponedView = v.findViewById(R.id.text_postponed);
    }

    public void bind(Context context, Fixture item, String date) {
        textHeaderDate.setText(DateUtils.parseMonthYear(date));
        textCompetition.setText(item.competitionStage.competition.name);
        textVenue.setText(item.venue.name);
        textDate.setText(String.format(context.getString(R.string.date_long_templ), DateUtils.parseDate(item.date)));
        textHomeTeam.setText(item.homeTeam.name);
        textAwayTeam.setText(item.awayTeam.name);
        textMonthDay.setText(DateUtils.parseMonthDay(item.date));
        textWeekDay.setText(DateUtils.parseWeekDay(item.date));

        if (Objects.equals(item.state, "postponed")) {
            postponedView.setVisibility(View.VISIBLE);
            textDate.setTextColor(ContextCompat.getColor(context, R.color.red));
        } else {
            postponedView.setVisibility(View.INVISIBLE);
            textDate.setTextColor(Color.GRAY);
        }
    }
}
