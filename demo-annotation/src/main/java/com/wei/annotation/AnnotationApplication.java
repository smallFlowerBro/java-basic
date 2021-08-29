package com.wei.annotation;

import com.wei.annotation.annotation.Start;
import com.wei.annotation.config.ApplicationAutoStart;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Start(package_scan = "com.wei.annotation.*",
        exclude_scan = "com.wei.annotation.annotation")

public class AnnotationApplication {
    public static void main(String[] args) {
        ApplicationAutoStart.run(AnnotationApplication.class,args);
    }
}
