package com.wei.annotation.config;

import com.wei.annotation.annotation.Start;
public class ApplicationAutoStart{
    public static void run(Class application,String[] args){
        Start annotation = (Start) application.getAnnotation(Start.class);
        if(annotation!=null){
            System.out.println(annotation.exclude_scan());
            System.out.println(annotation.package_scan());
        }
    }
}
