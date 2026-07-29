package com.example.real_time_ad_serving_platform.controller;

import com.example.real_time_ad_serving_platform.dto.CampaignRequest;
import com.example.real_time_ad_serving_platform.dto.CampaignResponse;
import com.example.real_time_ad_serving_platform.service.CampaignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.real_time_ad_serving_platform.dto.AdResponse;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping
    public CampaignResponse createCampaign(@Valid @RequestBody CampaignRequest request) {
        return campaignService.createCampaign(request);
    }

    @GetMapping
    public List<CampaignResponse> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public CampaignResponse getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    @PutMapping("/{id}")
    public CampaignResponse updateCampaign(@PathVariable Long id,
                                           @Valid @RequestBody CampaignRequest request) {
        return campaignService.updateCampaign(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return "Campaign deleted successfully";
    }
    @GetMapping("/ads")
    public AdResponse serveAd(@RequestParam String country,
                              @RequestParam Integer age) {

        return campaignService.serveAd(country, age);
    }
}