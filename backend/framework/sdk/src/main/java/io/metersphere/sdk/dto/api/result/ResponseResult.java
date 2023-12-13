package io.metersphere.sdk.dto.api.result;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 响应结果
 */
@Data
public class ResponseResult {

    private String responseCode;

    private String responseMessage;

    private long responseTime;

    private long latency;

    private long responseSize;

    private String headers;

    private String body;

    private String vars;

    private String console;

    private String contentType;

    private byte[] imageUrl;

    private final List<ResponseAssertionResult> assertions = new ArrayList<>();

}
