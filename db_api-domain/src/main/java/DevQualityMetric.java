package com.cmbibank.db_api.domain.metrics.devquality;

import com.cmbibank.db_api.domain.metrics.MainMetric;
import com.cmbibank.db_api.domain.metrics.MainMetricType;
import com.cmbibank.db_api.domain.user.UserProfile;
import lombok.Data;

@Data
public class DevQualityMetric extends MainMetric {

    private BugMetric bugMetric;

    public DevQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setDevQualityMetric(this);
        this.metricMainType = MainMetricType.DEV_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getDevQualityWeight();
    }
}
