package com.example.real_time_ad_serving_platform.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignRequest {

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String country;

    @NotNull
    @Min(1)
    private Integer minAge;

    @NotNull
    @Max(100)
    private Integer maxAge;

    @NotNull
    private Integer priority;

    @NotNull
    private Boolean active;

    private String imageUrl;

    private String landingUrl;
}