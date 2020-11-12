public class card
{
    String suit;
    int value;

    public card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }

    public void display()
    {
        String charValue;
        switch(this.value)
        {
            case 11: charValue = "J";
            value = 10;
            break;
            case 12: charValue = "Q";
            value = 10;
            break;
            case 13: charValue = "K";
            value = 10;
            break;
            case 1: charValue = "A";
            value = 1;
            break;
            default: charValue = Integer.toString(this.value);
        }
        System.out.println(charValue + suit);
    }
    public int GetValue() {return value;}
}
