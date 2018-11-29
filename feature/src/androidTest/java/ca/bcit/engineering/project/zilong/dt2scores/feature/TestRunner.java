package ca.bcit.engineering.project.zilong.dt2scores.feature;

import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.test.runner.AndroidJUnitRunner;

public class TestRunner extends AndroidJUnitRunner {
    @Override
    public void onCreate(Bundle arguments) {
        MultiDex.install(getTargetContext());
        super.onCreate(arguments);
    }
}