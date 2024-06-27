package com.raven.model;

import java.util.HashMap;
import java.util.Map;

public class DrugManager {
    private Map<String, Drug> drugMap;

    public DrugManager() {
        drugMap = new HashMap<>();
    }

    // Method to add a drug to the collection
    public void addDrug(Drug drug) {
        drugMap.put(drug.getCode(), drug);
    }

    // Method to remove a drug from the collection
    public void removeDrug(String code) {
        drugMap.remove(code);
    }

    // Method to get a drug from the collection
    public Drug getDrug(String code) {
        return drugMap.get(code);
    }

    // Method to update a drug's information
    public void updateDrug(Drug drug) {
        drugMap.put(drug.getCode(), drug);
    }

    // Method to get all drugs
    public Map<String, Drug> getAllDrugs() {
        return new HashMap<>(drugMap);
    }
}
