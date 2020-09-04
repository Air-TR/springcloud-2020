package com.tr.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用 Bus 必须在 Controller 类配置 @RefreshScope 才有效,其他地方配置调用 /actuator/bus-refresh 无效,配置不更新
 *
 * @author TR
 * @version 1.0
 * @date 2020/9/5 上午2:09
 */
@RestController
@RefreshScope
public class Controller {

    @Value("${title}")
    String title;

    @GetMapping("/config/title")
    public String getTitle() {
        return title;
    }

    @GetMapping("/get")
    public String get() {
        return "Get";
    }

}
