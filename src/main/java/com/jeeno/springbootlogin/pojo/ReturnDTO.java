package com.jeeno.springbootlogin.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 14:22
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDTO<T> {

    /**
     * 请求处理结果
     */
    private StatusEnum status;
    /**
     * 返回的数据
     */
    private T data;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回状态
     */
    public enum StatusEnum {
        /**
         * 操作成功
         */
        SUCCESS,
        /**
         * 操作失败
         */
        FAILURE;
    }
}
