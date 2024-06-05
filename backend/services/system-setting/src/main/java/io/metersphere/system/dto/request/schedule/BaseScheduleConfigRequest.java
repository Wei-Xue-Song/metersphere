package io.metersphere.system.dto.request.schedule;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BaseScheduleConfigRequest {
    @NotBlank(message = "{api_scenario.id.not_blank}")
    @Schema(description = "定时任务资源ID")
    @Size(min = 1, max = 50, message = "{api_scenario.id.length_range}")
    private String resourceId;

    @Schema(description = "启用/禁用")
    private boolean enable;

    @Schema(description = "Cron表达式")
    @NotBlank
    private String cron;
}
