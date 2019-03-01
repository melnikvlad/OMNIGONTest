package com.example.omnigontest.data.remote.model;

import com.example.omnigontest.data.remote.model.beans.Fixture;

import java.util.List;

public class FixturesResponse {
    private List<Fixture> fixtures;

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}
