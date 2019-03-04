package com.example.omnigontest.data.model.fixture;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.omnigontest.data.model.UIObject;
import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.utils.Constants;

public class FixtureUI extends UIObject {

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
