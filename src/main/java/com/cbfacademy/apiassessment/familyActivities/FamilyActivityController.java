package com.cbfacademy.apiassessment.familyActivities;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/FamilyActivities")
public class FamilyActivityController {

    private final FamilyActivityService familyActivityService;

    public FamilyActivityController(FamilyActivityService familyActivityService) {
        this.familyActivityService = familyActivityService;
    }

    @GetMapping("/") 
    public List<FamilyActivity> getAllFamilyActivities(
            @RequestParam(value = "type", required = false) ActivityType type,
            @RequestParam(value = "order", required = false) SortOrder order) {
    
        List<FamilyActivity> activities;
    
        // Logic to retrieve activities based on type
    
        // Check if type and order parameters are provided
        if (type != null && order != null) {
            activities = familyActivityService.getFamilyActivities(type, order);
        } else if (type != null) {
            activities = familyActivityService.getFamilyActivities(type);
        } else if (order != null) {
            activities = familyActivityService.getFamilyActivities(order);
        } else {
            activities = familyActivityService.getFamilyActivities();
        }
    
        // Sort the activities if order is provided
        if (order != null) {
            ActivitySorter.sort(activities, order);
        }
    
        return activities;
    }
    

    @GetMapping("/{id}")
    public FamilyActivity getFamilyActivityById(@PathVariable UUID id) {
        return familyActivityService.getFamilyActivity(id);
    }

    @PostMapping("/")
    public FamilyActivity createFamilyActivity(@RequestBody FamilyActivity familyActivity) {
        return familyActivityService.createFamilyActivity(familyActivity);
    }

    @PutMapping("/{id}")
    public FamilyActivity updateFamilyActivity(@PathVariable UUID id, @RequestBody FamilyActivity updatedFamilyActivity) {
        return familyActivityService.updateFamilyActivity(id, updatedFamilyActivity);
    }

    @DeleteMapping("/{id}")
    public String deleteFamilyActivity(@PathVariable UUID id) {
        familyActivityService.deleteFamilyActivity(id);
        return "Family activity deleted successfully!";
    }
}

