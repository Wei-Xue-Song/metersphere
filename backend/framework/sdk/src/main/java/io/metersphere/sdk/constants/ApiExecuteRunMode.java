package io.metersphere.sdk.constants;

/**
 * 接口执行时的资源类型
 * @Author: jianxing
 * @CreateTime: 2023-12-08  10:53
 */
public enum ApiExecuteRunMode {
    /**
     * 手动运行
     */
    RUN,
    /**
     * 调试
     */
    DEBUG,
    /**
     * jenkins 触发
     */
    JENKINS,
    /**
     * 定时任务
     */
    SCENARIO
}
