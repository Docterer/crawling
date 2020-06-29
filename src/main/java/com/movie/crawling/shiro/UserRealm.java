package com.movie.crawling.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm{

    /**
     * 执行授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 执行认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获得持久层的账号密码
        String userName = "";
        String password = "";
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //对持久层的账号进行验证,账号不存在抛出UnknowAccountException的异常

        return new SimpleAuthenticationInfo("",password,"");
    }
}
