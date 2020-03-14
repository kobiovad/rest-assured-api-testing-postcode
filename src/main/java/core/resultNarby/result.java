package core.resultNarby;

import lombok.*;

@ToString
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
    Integer distance;

}
