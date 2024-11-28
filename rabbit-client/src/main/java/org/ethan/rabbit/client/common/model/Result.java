package org.ethan.rabbit.client.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/14 10:13
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Result<T> {

    public static final int success = 0;
    public static final int fail = 1;
    private int status = success;
    private String message = "success";
    private T data;

}
