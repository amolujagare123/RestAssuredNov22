package DeckOfCards.SpecBuilderDemo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class PlayingCards {

    public static void main(String[] args) {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://deckofcardsapi.com")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification reqSpec = given().log().all().spec(requestSpecification).queryParam("deck_count", "1");

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();

        Response response = reqSpec.when().get("/api/deck/new/shuffle/");


        String respStr = response.then().log().all().spec(responseSpecification).extract().asString();

        System.out.println(respStr);

        String deckId = new JsonPath(respStr).getString("deck_id");


        RequestSpecification reqSpecDrawCard = given().log().all().spec(requestSpecification).queryParam("count", "2");

        Response responseDrawCars = reqSpecDrawCard.when().get("/api/deck/" + deckId + "/draw/");

        String respDrawCardsStr = responseDrawCars.then().log().all().spec(responseSpecification).extract().asString();

        int remaining = new JsonPath(respDrawCardsStr).get("remaining");


        System.out.println("remaining="+remaining);



    }
}
