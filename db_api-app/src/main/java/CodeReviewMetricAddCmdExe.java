package com.cmbibank.db_api.command;

import com.alibaba.cola.dto.Response;
import com.cmbibank.db_api.domain.metrics.techcontribution.CodeReviewMetric;
import com.cmbibank.db_api.domain.metrics.techcontribution.CodeReviewMetricItem;
import com.cmbibank.db_api.domain.metrics.techcontribution.ContributionMetric;
import com.cmbibank.db_api.domain.user.UserProfile;
import com.cmbibank.db_api.dto.CodeReviewMetricAddCmd;
import com.cmbibank.db_api.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CodeReviewMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:14 AM
 */
@Component
public class CodeReviewMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(CodeReviewMetricAddCmd cmd) {
        CodeReviewMetricItem codeReviewMetricItem = new CodeReviewMetricItem();
        BeanUtils.copyProperties(cmd, codeReviewMetricItem);
        codeReviewMetricItem.setSubMetric(new CodeReviewMetric(new ContributionMetric(new UserProfile(cmd.getOwnerId()))));
        metricGateway.save(codeReviewMetricItem);
        return Response.buildSuccess();
    }
}