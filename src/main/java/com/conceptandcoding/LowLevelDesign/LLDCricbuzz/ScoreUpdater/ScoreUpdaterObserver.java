package com.conceptandcoding.LowLevelDesign.LLDCricbuzz.ScoreUpdater;


import com.conceptandcoding.LowLevelDesign.LLDCricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}
