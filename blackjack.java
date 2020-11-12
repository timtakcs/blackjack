import java.util.Scanner;

public class blackjack {
    public static void main(String[] args) {
        deck Deck = new deck();
        Deck.shuffle();
        int card_drawn = 4;
        String input = null;

        Scanner reader = new Scanner(System.in);

        //player hand
        System.out.println("Player Hand");
        System.out.println("-------------------");
        Deck.cardGrabber(0).display();
        Deck.cardGrabber(1).display();
        int player_hand_value = Deck.cardGrabber(0).GetValue() + Deck.cardGrabber(1).GetValue();
        System.out.println("Total Value: " + player_hand_value);

        //dealer hand
        System.out.println("");
        System.out.println("Dealer Hand");
        System.out.println("-------------------");
        Deck.cardGrabber(2).display();
        System.out.println("*Unknown Card*");
        int dealer_hand_value = Deck.cardGrabber(2).GetValue() + Deck.cardGrabber(3).GetValue();
        System.out.println("Total Value: " + dealer_hand_value);


            //loops through the cards and draws them
        do {
            int value = Deck.cardGrabber(card_drawn).GetValue();
            System.out.println("Stand or Hit: ");
            input = reader.nextLine();
            if (input.equalsIgnoreCase("hit")) {
                Deck.cardGrabber(card_drawn).display();
                card_drawn++;
                switch (value) {
                    case 11:
                    case 12:
                    case 13:
                        player_hand_value += 10;
                        break;
                    default:
                        player_hand_value += value;
                        break;
                }
            }
        }while(player_hand_value <= 21 && !input.equalsIgnoreCase("stand"));
            System.out.println(player_hand_value);


            //dealer counting
        while(dealer_hand_value < player_hand_value && player_hand_value <= 21)
        {
            dealer_hand_value += Deck.cardGrabber(card_drawn).GetValue();
            card_drawn++;
        }

        if(player_hand_value > 21)
        {
            System.out.println("Bust!");
            System.out.println("The Dealer Won");
            System.out.println("Your hand: " + player_hand_value);
            System.out.println("Dealer's hand: " + dealer_hand_value);
        }
        else if(dealer_hand_value > 21)
        {
            System.out.println("Dealer went bust!");
            System.out.println("You Won");
            System.out.println("Dealer's hand: " + dealer_hand_value);
            System.out.println("Your hand: " + player_hand_value);
        }
        else if(dealer_hand_value > player_hand_value)
        {
            System.out.println("The Dealer Won");
            System.out.println("Your hand: " + player_hand_value);
            System.out.println("Dealer's hand: " + dealer_hand_value);
        }
        else
            {
                System.out.println("You Won");
                System.out.println("Dealer's hand: " + dealer_hand_value);
                System.out.println("Your hand: " + player_hand_value);
            }
        }
    }
