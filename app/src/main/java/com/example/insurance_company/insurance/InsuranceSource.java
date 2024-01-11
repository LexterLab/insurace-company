package com.example.insurance_company.insurance;

import java.util.ArrayList;
import java.util.List;

public class InsuranceSource {
    public static List<Insurance> getLifeInsurance() {
        List<Insurance> insurances = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            insurances.add(new Insurance("life insurance" + i, 20.00, true, 30000));
        }
        return insurances;
    }

    public static List<Insurance> getCivilInsurance() {
        List<Insurance> insurances = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            insurances.add(new Insurance("civil insurance" + i, 25.00, true, 60000));
        }
        return insurances;
    }

    public static List<Insurance> getHouseInsurance() {
        List<Insurance> insurances = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            insurances.add(new Insurance("house insurance" + i, 100.00, true, 30003220));
        }
        return insurances;
    }
}
