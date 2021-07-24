package com.cmbibank.db_api.domain.metrics.appquality;

import com.cmbibank.db_api.domain.metrics.MainMetric;
import com.cmbibank.db_api.domain.metrics.MainMetricType;
import com.cmbibank.db_api.domain.metrics.devquality.BugMetric;
import com.cmbibank.db_api.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
