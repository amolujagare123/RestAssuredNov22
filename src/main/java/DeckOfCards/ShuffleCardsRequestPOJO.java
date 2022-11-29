package DeckOfCards;

import POJOClasses.ShuffleCardsPOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ShuffleCardsRequestPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        ShuffleCardsPOJO shuffleCardsPOJO =  given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().as(ShuffleCardsPOJO.class);

        System.out.println("Deck id = " + shuffleCardsPOJO.getDeck_id());
        System.out.println("Shuffled = " + shuffleCardsPOJO.isShuffled());
        System.out.println("Remaining = " + shuffleCardsPOJO.getRemaining());
        System.out.println("Success = " + shuffleCardsPOJO.isSuccess());


    }
}
