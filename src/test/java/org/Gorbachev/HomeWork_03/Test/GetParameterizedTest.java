package org.Gorbachev.HomeWork_03.Test;

import io.restassured.http.Method;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class GetParameterizedTest extends AccuweatherAbstractTest {

    @ParameterizedTest
    @ValueSource(ints = {25, 50, 100})
    void get_ten_day_return_401(int location) {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", location)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);

    }
}
