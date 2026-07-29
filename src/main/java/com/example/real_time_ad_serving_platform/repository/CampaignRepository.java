package com.example.real_time_ad_serving_platform.repository;

import com.example.real_time_ad_serving_platform.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findByActiveTrueAndCountry(String country);

}