package com.example.omnigontest.ui.adapter.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.omnigontest.R;
import com.example.omnigontest.data.results.model.Result;
import com.example.omnigontest.utils.DateUtils;

public class ResultDateViewHolder extends RecyclerView.ViewHolder {

    private static final String HOME = "home";
    private static final String AWAY = "away";

    private TextView textHeaderDate;
    private TextView textCompetition;
    private TextView textVenue;
    private TextView textDate;
    private TextView textHomeTeam;
    private TextView textAwayTeam;
    private TextView textHomeScore;
    private TextView textAwayScore;

    public ResultDateViewHolder(@NonNull View v) {
        super(v);
        textHeaderDate = v.findViewById(R.id.text_month_date);
        textCompetition = v.findViewById(R.id.text_competition);
        textVenue = v.findViewById(R.id.text_venue);
        textDate = v.findViewById(R.id.text_date);
        textHomeTeam = v.findViewById(R.id.text_team_1);
        textAwayTeam = v.findViewById(R.id.text_team_2);
        textHomeScore = v.findViewById(R.id.text_team_1_score);
        textAwayScore = v.findViewById(R.id.text_team_2_score);
    }

    public void bind(Context context, Result item, String date) {
        textHeaderDate.setText(DateUtils.parseMonthYear(date));

        textCompetition.setText(item.competitionStage.competition.name);
        textVenue.setText(item.venue.name);
        textDate.setText(String.format(context.getString(R.string.date_long_templ), DateUtils.parseDate(item.date)));
        textHomeTeam.setText(item.homeTeam.name);
        textAwayTeam.setText(item.awayTeam.name);
        textHomeScore.setText(String.valueOf(item.score.home));
        textAwayScore.setText(String.valueOf(item.score.away));

        if (item.score.winner.equals(HOME)) {
            textHomeScore.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
            textAwayScore.setTextColor(ContextCompat.getColor(context, R.color.black));
        } else {
            textAwayScore.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
            textHomeScore.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }
}
