package com.cmbibank.db_api.command;

import com.alibaba.cola.dto.Response;
import com.cmbibank.db_api.convertor.UserProfileConvertor;
import com.cmbibank.db_api.domain.user.UserProfile;
import com.cmbibank.db_api.dto.UserProfileUpdateCmd;
import com.cmbibank.db_api.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}