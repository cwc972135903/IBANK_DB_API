package com.cmbibank.db_api.domain;

import com.cmbibank.db_api.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
