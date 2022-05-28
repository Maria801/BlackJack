/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author Maria Tawfek
 */
public class Player {
    
    private String name;
    private int score=0;
    private Card player_cards[]= new Card[11];
    protected boolean winner=false;
    protected boolean in=true;
    private int index=0;

   public Player(String name) {
        this.name = name;
    }
    
  
    public int getScore() {
        return score;
    }

    public Card[] getPlayer_cards() {
        return player_cards;
    }

    public String getName() {
        return name;
    }

    
    
   public void addcard(Card c3){
       
        player_cards[index]= new Card(c3);
        score+= c3.getValue();
                
        index++;
    }
   
   
   
   
   /*public void plaaay(){
      
       for(int i=0; i<2; ++i){
        System.out.println(player_cards[i].getRank());
         System.out.println(player_cards[i].getSuit());
          System.out.println(player_cards[i].getValue());
       System.out.println(score);
       System.out.println("//////////////////////////////");
   }
   }*/
   
    
}
