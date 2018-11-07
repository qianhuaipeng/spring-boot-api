package com.alan.api.util;

import javax.servlet.http.HttpServletRequest;

/**
 * author: alan.peng
 * description: IP 工具类
 * date: create in 16:00 2018/11/7
 * modified By：
 */
public class IpUtil {

    private final static String UNKNOWN = "unknown";
    private final static String LOCALHOST_IPV4 = "127.0.0.1";
    private final static String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    /**
     * 获取登录用户的IP地址
     *
     * @param request request
     * @return IP地址
     */
    public static String getIpAddress(final HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (LOCALHOST_IPV6.equals(ip)) {
            ip = LOCALHOST_IPV4;
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
