package fr.epita.mobprogramming.datamodel;

import java.util.Objects;

public class Competitor {

    private String familyName;
    private String country;
    private String givenName;
    private String weightCategory;
    private String ageCategory;


    public Competitor(){

    }


    public Competitor(String familyName, String country, String givenName, String weightCategory, String ageCategory) {
        this.familyName = familyName;
        this.country = country;
        this.givenName = givenName;
        this.weightCategory = weightCategory;
        this.ageCategory = ageCategory;
    }


    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competitor that = (Competitor) o;
        return Objects.equals(familyName, that.familyName) && Objects.equals(country, that.country) && Objects.equals(givenName, that.givenName) && Objects.equals(weightCategory, that.weightCategory) && Objects.equals(ageCategory, that.ageCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, country, givenName, weightCategory, ageCategory);
    }
}
