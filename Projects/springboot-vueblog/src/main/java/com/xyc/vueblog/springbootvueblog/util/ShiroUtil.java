package com.xyc.vueblog.springbootvueblog.util;

import com.xyc.vueblog.springbootvueblog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
