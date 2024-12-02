package org.ethan.rabbit.client.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/28 10:31
 */
@Slf4j
public class CommonUtils {


    /**
     * 将 未知类型的Map 转换成 String类型的Map
     * @param uriVariables
     * @return
     */
    public static Map<String, String> convertToStringMap(Map<String, ?> uriVariables) {
        return uriVariables.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> String.valueOf(entry.getValue())
                ));
    }


}
