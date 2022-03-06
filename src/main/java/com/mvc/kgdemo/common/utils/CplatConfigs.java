package com.mvc.kgdemo.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @author zhq
 * @version 1.0
 * @date 2020/12/24 20:03
 */
@Configuration
@PropertySource(value = "classpath:ht-config.properties", encoding = "UTF-8")
public class CplatConfigs {

    @Value("${profile}")
    private String profile;
    @Value("${home.title}")
    private String homeTitle;
    @Value("${home.href}")
    private String homeHref;

    @Value("${logo.title}")
    private String logoTitle;
    @Value("${logo.image}")
    private String logoImage;
    @Value("${logo.href}")
    private String logoHref;
    @Value("${cookie.info.login}")
    private String cookieInfoLogin;
    @Value("${single.system.login}")
    private String singleSystemLogin;
    @Value("${captcha.code.login}")
    private String captchaCodeLogin;
    @Value("${open.dict.cache}")
    private String openDictCache;
    @Value("${open.quartz.job}")
    private String openQuartzJob;

    @Value("${dispatch.action}")
    private String DispatchAction;

    @Value("${plat.app.ename}")
    private String platAppEname;
    @Value("${app.ename}")
    private String appEname;
    private String appCname;
    @Value("#{${app.maps}}")
    private Map<String, String> appMaps;
    @Value("${menu.parent.ename}")
    private String menuParentEname;

    @Value("${user.default.password}")
    private String userDefaultPassword;

    @Value("${file.storage.url}")
    private String fileStorageUrl;
    @Value("${file.view.url}")
    private String fileViewUrl;
    @Value("${captcha.type}")
    private String captchaType;
    @Value("${temp.file.path}")
    private String tempFilePath;

    public String getProfile() {
        return profile;
    }

    public String getHomeTitle() {
        return homeTitle;
    }

    public String getHomeHref() {
        return homeHref;
    }

    public String getLogoTitle() {
        return logoTitle;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public String getLogoHref() {
        return logoHref;
    }

    public String getCookieInfoLogin() {
        return cookieInfoLogin;
    }

    public String getSingleSystemLogin() {
        return singleSystemLogin;
    }

    public String getCaptchaCodeLogin() {
        return captchaCodeLogin;
    }

    public String getOpenDictCache() {
        return openDictCache;
    }

    public String getOpenQuartzJob() {
        return openQuartzJob;
    }

    public String getPlatAppEname() {
        return platAppEname;
    }

    public String getAppEname() {
        return appEname;
    }

    public Map<String, String> getAppMaps() {
        return appMaps;
    }

    public String getAppCname() {
        this.appCname = appMaps.get(appEname) == null ? " " : appMaps.get(appEname);
        return appCname;
    }

    public String getMenuParentEname() {
        return menuParentEname;
    }

    public String getDispatchAction() {
        return DispatchAction;
    }

    public String getUserDefaultPassword() {
        return userDefaultPassword;
    }

    public String getFileStorageUrl() {
        return fileStorageUrl;
    }

    public String getFileViewUrl() {
        return fileViewUrl;
    }

    public String getCaptchaType() {
        return captchaType;
    }

    public String getTempFilePath() {
        return tempFilePath;
    }
}
