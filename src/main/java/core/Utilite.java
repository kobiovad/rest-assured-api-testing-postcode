package core;

import core.resultMainPage.*;
import core.resultNarby.PostCodesResultNarby;

import java.util.ArrayList;

public class Utilite {
    //"CB3 0FA"
    public void printPostCity(String cityCode){
        BaseRest baseRest = new BaseRest();
        PostValidate postValidate = baseRest.getvalidateRequest(cityCode);

        if (postValidate.getResult()) {
            PostCodesResult postCodesResult = baseRest.getResponse(cityCode);
            postCodesResult.getResult().printCityAndRegions(postCodesResult);
            PostCodesResultNarby postCodesResultNarby = baseRest.getNearestPostCodes(postCodesResult);
            printListNarby(postCodesResultNarby);
            }
        else
            System.out.println("Post Code incorrect: "+ cityCode);
    }

    public void printListNarby(PostCodesResultNarby postCodesResultNarby){
        System.out.println("\nNerby City: ");
        for(int i =0;i<postCodesResultNarby.getResult().size();i++){
            System.out.println("City: "+postCodesResultNarby.getResult().get(i).getCountry() + "   Region:"+ postCodesResultNarby.getResult().get(i).getRegion());
        }
    }
}
