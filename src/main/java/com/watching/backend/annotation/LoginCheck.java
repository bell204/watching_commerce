package com.watching.backend.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginCheck {

    UserLevel userLevel();

    enum UserLevel {

        USER;

        public static UserLevel getEnumLevel(String level) {
            UserLevel userLevel = Enum.valueOf(UserLevel.class, level);
            return userLevel;
        }
    }

}
