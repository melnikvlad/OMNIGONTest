package com.example.omnigontest.data.remote.model;

import com.example.omnigontest.data.IRecyclerViewItem;
import com.example.omnigontest.data.remote.model.beans.Fixture;

public class FixtureUI extends UIObject  {

    private Fixture fixture = null;

    public FixtureUI(int type) {
        super(type);
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }
}
