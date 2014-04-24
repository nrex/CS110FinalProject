public class FirstTester
{



   public static void main(String[] args)
   {
   Deck warDeck = new Deck();
   warDeck.shuffle();
   displayDeck(warDeck);
   }
   
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
 
   
   
   }
}
