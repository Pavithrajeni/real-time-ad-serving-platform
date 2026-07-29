package com.example.real_time_ad_serving_platform.service;

import com.example.real_time_ad_serving_platform.dto.AdResponse;
import com.example.real_time_ad_serving_platform.dto.CampaignRequest;
import com.example.real_time_ad_serving_platform.dto.CampaignResponse;

import java.util.List;

public interface CampaignService {

    CampaignResponse createCampaign(CampaignRequest request);

    List<CampaignResponse> getAllCampaigns();

    CampaignResponse getCampaignById(Long id);

    CampaignResponse updateCampaign(Long id, CampaignRequest request);

    void deleteCampaign(Long id);
    AdResponse serveAd(String country, Integer age);
}