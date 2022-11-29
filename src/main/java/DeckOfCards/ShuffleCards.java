package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ShuffleCards {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        String shuffleCardResponse = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jsonShuffleCardResp  = new JsonPath(shuffleCardResponse);

        String deckId = jsonShuffleCardResp.getString("deck_id");

        System.out.println("deckId="+deckId);

        given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200);


    }
}
