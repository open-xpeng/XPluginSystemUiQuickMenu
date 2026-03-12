package com.xiaopeng.speech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes23.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface SpeechAnnotation {
    String event() default "";
}