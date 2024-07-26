package com.afk.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface FrameworkConfig extends Config {
    @Key("timeout")
    long timeout();

    @Key("url")
    String url();

    @Key("browser")
    String browser();

    @Key("runmode")
    String runmode();

    @Key("remoteurl")
    String remoteurl();
}
