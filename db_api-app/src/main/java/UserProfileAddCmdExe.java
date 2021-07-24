package com.cmbibank.db_api.command;

import com.alibaba.cola.dto.Response;
import com.cmbibank.db_api.convertor.UserProfileConvertor;
import com.cmbibank.db_api.domain.user.UserProfile;
import com.cmbibank.db_api.dto.UserProfileAddCmd;
import com.cmbibank.db_api.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
