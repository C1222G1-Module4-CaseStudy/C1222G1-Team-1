package com.example.castudy_module_4.util;

import com.example.castudy_module_4.dto.MyUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static MyUser getPrincipal() {
        return (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }
}
