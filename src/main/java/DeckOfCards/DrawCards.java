package DeckOfCards;

import POJOClasses.response.DrawCardsPOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DrawCards {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        String deckId = "48jpl9m0a1dl";

        System.out.println("deckId="+deckId);

        DrawCardsPOJO drawCardsPOJO =  given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().as(DrawCardsPOJO.class);

        System.out.println("Deck ID = "+drawCardsPOJO.getDeck_id());
        System.out.println("Remaining = "+drawCardsPOJO.getRemaining());


        System.out.println("Code="+drawCardsPOJO.getCards().get(0).getCode());
        System.out.println("Code="+drawCardsPOJO.getCards().get(1).getCode());

        System.out.println("Getting Cardimages urls");

        System.out.println("Card 1 = "+drawCardsPOJO.getCards().get(0).getImages().getPng());
        System.out.println("Card 2 = "+drawCardsPOJO.getCards().get(1).getImages().getPng());
    }
}
