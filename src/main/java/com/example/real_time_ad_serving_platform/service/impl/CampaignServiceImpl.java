package com.example.real_time_ad_serving_platform.service.impl;

import com.example.real_time_ad_serving_platform.dto.CampaignRequest;
import com.example.real_time_ad_serving_platform.dto.CampaignResponse;
import com.example.real_time_ad_serving_platform.entity.Campaign;
import com.example.real_time_ad_serving_platform.repository.CampaignRepository;
import com.example.real_time_ad_serving_platform.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.real_time_ad_serving_platform.dto.AdResponse;
import java.util.Comparator;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import com.example.real_time_ad_serving_platform.exception.ResourceNotFoundException;
@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    @Override
    public CampaignResponse createCampaign(CampaignRequest request) {

        Campaign campaign = Campaign.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .country(request.getCountry())
                .minAge(request.getMinAge())
                .maxAge(request.getMaxAge())
                .priority(request.getPriority())
                .active(request.getActive())
                .imageUrl(request.getImageUrl())
                .landingUrl(request.getLandingUrl())
                .build();

        Campaign savedCampaign = campaignRepository.save(campaign);

        return mapToResponse(savedCampaign);
    }

    @Override
    public List<CampaignResponse> getAllCampaigns() {
        return campaignRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
   @Cacheable("campaigns")
    public CampaignResponse getCampaignById(Long id) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));;

        return mapToResponse(campaign);
    }

    @Override
    public CampaignResponse updateCampaign(Long id, CampaignRequest request) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        campaign.setTitle(request.getTitle());
        campaign.setDescription(request.getDescription());
        campaign.setCountry(request.getCountry());
        campaign.setMinAge(request.getMinAge());
        campaign.setMaxAge(request.getMaxAge());
        campaign.setPriority(request.getPriority());
        campaign.setActive(request.getActive());
        campaign.setImageUrl(request.getImageUrl());
        campaign.setLandingUrl(request.getLandingUrl());

        Campaign updated = campaignRepository.save(campaign);

        return mapToResponse(updated);
    }

    @Override
    public void deleteCampaign(Long id) {

        campaignRepository.deleteById(id);
    }
    @Override
   @Cacheable(value = "ads", key = "#country + '_' + #age")
    public AdResponse serveAd(String country, Integer age) {

        Campaign campaign = campaignRepository.findByActiveTrueAndCountry(country)
                .stream()
                .filter(c -> age >= c.getMinAge() && age <= c.getMaxAge())
                .max(Comparator.comparing(Campaign::getPriority))
                .orElseThrow(() -> new ResourceNotFoundException("No matching campaign found"));

        return AdResponse.builder()
                .id(campaign.getId())
                .title(campaign.getTitle())
                .description(campaign.getDescription())
                .imageUrl(campaign.getImageUrl())
                .landingUrl(campaign.getLandingUrl())
                .build();
    }

    private CampaignResponse mapToResponse(Campaign campaign) {

        return CampaignResponse.builder()
                .id(campaign.getId())
                .title(campaign.getTitle())
                .description(campaign.getDescription())
                .country(campaign.getCountry())
                .minAge(campaign.getMinAge())
                .maxAge(campaign.getMaxAge())
                .priority(campaign.getPriority())
                .active(campaign.getActive())
                .imageUrl(campaign.getImageUrl())
                .landingUrl(campaign.getLandingUrl())
                .build();
    }
}