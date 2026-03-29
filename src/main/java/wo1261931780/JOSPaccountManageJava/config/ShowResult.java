package wo1261931780.JOSPaccountManageJava.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回结果封装
 * @author junw
 */
@Schema(description = "统一返回结果")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowResult<T> implements Serializable {

    @Schema(description = "状态码")
    private Integer code;

    @Schema(description = "返回消息")
    private String message;

    @Schema(description = "返回数据")
    private T data;

    private static final long serialVersionUID = 1L;

    /**
     * 成功返回（无数据）
     */
    public static <T> ShowResult<T> sendSuccess() {
        return new ShowResult<>(200, "操作成功", null);
    }

    /**
     * 成功返回（有数据）
     */
    public static <T> ShowResult<T> sendSuccess(T data) {
        return new ShowResult<>(200, "操作成功", data);
    }

    /**
     * 成功返回（自定义消息）
     */
    public static <T> ShowResult<T> sendSuccess(T data, String message) {
        return new ShowResult<>(200, message, data);
    }

    /**
     * 失败返回
     */
    public static <T> ShowResult<T> sendError(String message) {
        return new ShowResult<>(500, message, null);
    }

    /**
     * 失败返回（自定义状态码）
     */
    public static <T> ShowResult<T> sendError(Integer code, String message) {
        return new ShowResult<>(code, message, null);
    }
}
