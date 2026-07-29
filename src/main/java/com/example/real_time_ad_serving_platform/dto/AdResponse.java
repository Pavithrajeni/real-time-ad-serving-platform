package com.example.real_time_ad_serving_platform.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdResponse {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String landingUrl;
}