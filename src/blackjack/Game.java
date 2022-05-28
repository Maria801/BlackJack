/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Maria Tawfek
 */
public class Game {
    
    protected Player players[]= new Player[4];
    protected Card card[]= new Card[52];
    private static int maxscore=0;
   

    public int getMaxscore() {
        return maxscore;
    }
    
    
    
   public void generates(){
      
       int index=0;
       int num=1;
       for(int i=0; i<13; i++){
           for(int j=0; j<4; ++j){
               
               card[index]= new Card(j, i, num  );
                
                
                index++;
           }
           if(i<9)
                   num++;
               else
                   num=10;
           
       }
   }
   
   public Card take_card(){
       
       
       Random rand= new Random();
       int randchoice= rand.nextInt(52);
       
       while(true){
       if(card[randchoice] == null){
           randchoice= rand.nextInt(52);
       }
       
       else{
           Card c2= new Card( card[randchoice]);
           card[randchoice]=null;
           return c2;
       }
       }
   }
   
  public void dataplayer(){
      
      
     
      Scanner scanner =new Scanner(System.in) ;
      for(int i=0; i<4; ++i){
      
      System.out.println("Enter the name of "+ (i+1)+ " player : ");
      String player= scanner.next();
      
      players[i]=new Player(player); 
      

       for(int j=0; j<2; ++j){
           Card take = take_card();
         players[i].addcard( take);
         
       }
      // players[i].plaaay();
       
      }
  }
  
  public static void max(int value){
      if(value > maxscore  && value<=21)
          maxscore=value;
      
  }
  
  public void play(){
 
       GUI gui = new GUI();  
        
      
     generates();
     dataplayer();
      gui.runGUI( card, players[0].getPlayer_cards(), players[1].getPlayer_cards(), players[2].getPlayer_cards(), players[3].getPlayer_cards() );

       Scanner scanner =new Scanner(System.in) ;
      for(int i=0; i<3; ++i){
          System.out.println( "1 Hit          2 Stand  for " + (i+1)+ " player.");
          while(true){
               int option= scanner.nextInt();
              if(option == 2)
                  break;
              else if(option==1){
                   
                   Card c4= take_card();
                  players[i].addcard(c4);  
                    gui.updatePlayerHand(c4,i);

                  if(players[i].getScore() >21){
                      players[i].in= false;
                      System.out.println("Busted");
                      break;
                  }
                    if(players[i].getScore()==21)  {
                        players[i].winner= true;
                          System.out.println("BlackJack");
                        break;
                    }
                  
               }
              else{
                  System.out.println("Invalid Choice");
                  System.out.println( "1 Hit          2 Stand  for " + (i+1)+ " player.");
              }
          }
           max(players[i].getScore());
          // System.out.println(players[i].getScore());
          // System.out.println(maxscore);
    

      }
      
      if(players[3].getScore() > maxscore ){
              players[3].winner= true;
              
          }
      else{
          while(true){
                 Card c5= take_card();
                  players[3].addcard(c5);  
                  gui.updateDealerHand(c5, card);
                  
                  if(players[3].getScore() >21){
                      players[3].in= false; 
                        System.out.println("Busted");
                      break;
                  }
                    if(players[3].getScore()==21)  {
                        players[3].winner= true;
                          System.out.println("BlackJack");
                        break;
                    }
                    
                    
                   if(players[3].getScore() > maxscore && players[3].getScore()<=21)  {
                        break;
                    }
               }
             
      }
      
      max(players[3].getScore());
      
      //System.out.println(players[3].getScore());
      //System.out.println(maxscore);

      
  }
  
  
  
    
}
