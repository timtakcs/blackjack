import java.util.Random;

public class deck
{
    static String[] suits = {"♡", "♠", "♢", "♣"};
    static int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    public static card[] deckOfCards = new card[52];
    static Random random = new Random();

    public deck(){
        int i = 0;
        for(String suit : suits)
        {
            for(int value : values)
            {
                deckOfCards[i] = new card(suit, value);
                i++;
            }
        }
    }

    public card cardGrabber(int i)
    {
        card Card = deckOfCards[i];
        return Card;
    }

    public static void shuffle()
    {
        Random num = new Random();

        card[] shuffledDeck = new card[52];
        boolean[] shuffledCards = new boolean[52];
        int numShuffledCards = 0;

        while(numShuffledCards < 52)
        {
            int randnum = num.nextInt(52);
            if(shuffledCards[randnum] == false)
            {
                shuffledDeck[numShuffledCards] = deckOfCards[randnum];
                shuffledCards[randnum] = true;
                numShuffledCards = numShuffledCards + 1;
            }
        }
        deckOfCards = shuffledDeck;
    }
}
