package com.cmbibank.db_api.command;

import com.alibaba.cola.dto.Response;
import com.cmbibank.db_api.domain.metrics.techcontribution.ContributionMetric;
import com.cmbibank.db_api.domain.metrics.techcontribution.RefactoringLevel;
import com.cmbibank.db_api.domain.metrics.techcontribution.RefactoringMetric;
import com.cmbibank.db_api.domain.metrics.techcontribution.RefactoringMetricItem;
import com.cmbibank.db_api.domain.user.UserProfile;
import com.cmbibank.db_api.dto.RefactoringMetricAddCmd;
import com.cmbibank.db_api.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RefactoringMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class RefactoringMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(RefactoringMetricAddCmd cmd) {
        RefactoringMetricItem refactoringMetricItem = new RefactoringMetricItem();
        BeanUtils.copyProperties(cmd.getRefactoringMetricCO(), refactoringMetricItem);
        refactoringMetricItem.setSubMetric(new RefactoringMetric(new ContributionMetric(new UserProfile(cmd.getRefactoringMetricCO().getOwnerId()))));
        refactoringMetricItem.setRefactoringLevel(RefactoringLevel.valueOf(cmd.getRefactoringMetricCO().getRefactoringLevel()));
        metricGateway.save(refactoringMetricItem);
        return Response.buildSuccess();
    }
}
