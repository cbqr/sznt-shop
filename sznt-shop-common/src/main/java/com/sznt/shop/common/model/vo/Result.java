package com.sznt.shop.common.model.vo;//package com.sznt.shop.common.vo;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//
///**
// * 统一返回对象封装
// *
// * @author S Mr.L
// * @since 2021-06-01
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ApiModel(value = "接口返回对象")
//public class Result<T> implements Serializable {
//
//    /**
//     * 返回代码
//     */
//    @ApiModelProperty(value = "返回代码")
//    private Integer code;
//
//    /**
//     * 返回信息描述
//     */
//    @ApiModelProperty(value = "返回信息描述")
//    private String message;
//
//    /**
//     * 返回数据对象 data
//     */
//    @ApiModelProperty(value = "返回数据对象")
//    private T data;
//
//    public Result(ResultCode resultCode, T data) {
//        this.code = resultCode.getCode();
//        this.message = resultCode.getMessage();
//        this.data = data;
//    }
//
//    /** 业务代码和描述信息 */
//    public static Result<Void> success() {
//        return new Result<>(ResultCode.SUCCESS, null);
//    }
//
//    /** 业务代码、描述信息和返回的参数 */
//    public static <T> Result<T> success(T data) {
//        return new Result<>(ResultCode.SUCCESS, data);
//    }
//
//    /** 业务代码、描述信息和返回的参数 */
//    public static <T> Result<T> success(ResultCode resultStatus, T data) {
//        if (resultStatus == null) {
//            return success(data);
//        }
//        return new Result<>(resultStatus, data);
//    }
//
//    /** 业务异常返回业务代码和描述信息 */
//    public static <T> Result<T> failure() {
//        return new Result<>(ResultCode.ERROR, null);
//    }
//
//    /** 业务异常返回业务代码,描述和返回的参数 */
//    public static <T> Result<T> failure(ResultCode resultStatus) {
//        return failure(resultStatus, null);
//    }
//
//    /** 业务异常返回业务代码,描述和返回的参数 */
//    public static <T> Result<T> failure(int resultStatus, String message) {
//        return new Result<T>(resultStatus, message, null);
//    }
//
//    /** 业务异常返回业务代码,描述和返回的参数 */
//    public static <T> Result<T> failure(ResultCode resultStatus, T data) {
//        return new Result<T>(resultStatus.getCode(), resultStatus.getMessage(), data);
//    }
//
//    @Getter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public enum ResultCode{
//
//        /**
//         * 响应成功
//         */
//        SUCCESS(200, "操作成功"),
//
//        /**
//         * 响应失败
//         */
//        FAILED(1001, "响应失败"),
//
//        /**
//         * 参数校验失败
//         */
//        VALIDATE_FAILED(1000, "参数校验失败"),
//
//        /**
//         * 未知错误
//         */
//        ERROR(500, "未知错误");
//
//        /**
//         * 返回code
//         */
//        private Integer code;
//
//        /**
//         * 返回信息描述
//         */
//        private String message;
//    }
//
//}
