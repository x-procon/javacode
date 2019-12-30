package com.hazer.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ShiroRealm
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/30 10:27
 * @Version: 1.0
 */
public class ShiroRealm extends AuthenticatingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class.getName());

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("执行了doGetAuthenticationInfo方法！");
        return null;
    }
}
