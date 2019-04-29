package com.project.common.utils;

import com.project.web.service.IFileService;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class ValidationUtils {


    public static boolean objIsNull(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && ((String) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Date && ((Date) obj).getTime() == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }
        return false;
    }




}
