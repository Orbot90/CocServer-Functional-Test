package ru.orbot90.tests.diceroll

import io.restassured.RestAssured
import io.restassured.http.ContentType
import net.serenitybdd.junit.runners.SerenityRunner
import org.junit.Test
import org.junit.runner.RunWith

const val SERVER_URL = "http://localhost:8080"

@RunWith(SerenityRunner::class)
class DicerRollEndpointTest {

    @Test
    fun verifyThatDiceRollEndpointReturnsResult() {
        RestAssured.given().body("{\"diceCount\": 1, \"diceFacesCount\": 100}")
            .contentType(ContentType.JSON).`when`().post(SERVER_URL + "/diceroll").then()
            .assertThat().statusCode(200)
    }
}