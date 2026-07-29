package com.example.real_time_ad_serving_platform.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignResponse {

    private Long id;

    private String title;

    private String description;

    private String country;

    private Integer minAge;

    private Integer maxAge;

    private Integer priority;

    private Boolean active;

    private String imageUrl;

    private String landingUrl;
}