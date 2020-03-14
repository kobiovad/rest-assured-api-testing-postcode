package core;

import com.google.gson.Gson;
import core.resultMainPage.PostCodesResult;
import core.resultMainPage.PostValidate;
import core.resultNarby.PostCodesResultNarby;

import static io.restassured.RestAssured.given;


public class BaseRest {

    public  PostCodesResult getResponse(String cityCode){

        PostCodesResult postCodesResult = given()
                    .header("Content-Type", "application/json")
                    .when()
                    .get("https://api.postcodes.io/postcodes/" + cityCode)
                    .then()
                    //.statusCode(404)
                    .and()
                    .extract().response().as(PostCodesResult.class);

        return postCodesResult;
    }

    public  PostValidate getvalidateRequest (String cityCode){

        PostValidate postValidate = given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://api.postcodes.io/postcodes/"+cityCode+"/validate")
                .then()
                //.statusCode(404)
                .and()
                .extract().response().as(PostValidate.class);

       //System.out.println(postValidate.getResult());
        return postValidate;
    }

    public PostCodesResultNarby getNearestPostCodes (PostCodesResult postCodesResult){


        PostCodesResultNarby postCodesResultNarby = given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://api.postcodes.io/postcodes?lon=" + postCodesResult.getResult().getLongitude() + "&lat=" + postCodesResult.getResult().getLatitude())
                .then()
                //.statusCode(200)
                .and()
                .extract().response().as(PostCodesResultNarby.class);



        return postCodesResultNarby;
    }
}
