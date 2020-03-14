package core.resultMainPage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class result {

    String postcode;
    Integer quality;
    Long eastings;
    Long northings;
    String country;
    String nhs_ha;
    Double longitude;
    Double latitude;
    String european_electoral_region;
    String primary_care_trust;
    String region;
    String lsoa;
    String msoa;
    String incode;
    String outcode;
    String parliamentary_constituency;
    String admin_district;
    String parish;
    String admin_county;
    String admin_ward;
    String ced;
    String ccg;
    String nuts;
    codes codes;


    public void printCityAndRegions(PostCodesResult postCodesResult) {
           System.out.println("City: "+postCodesResult.getResult().getCountry() +"  Regions: "+postCodesResult.getResult().getRegion());
    }
}
