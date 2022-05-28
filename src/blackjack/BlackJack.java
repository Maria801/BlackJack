/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

public class BlackJack {
          
          static Game g= new Game();
          
          static int counter=0;
          static String name;
      
      public static void winner(){
         
          for(int i=0; i<4; ++i){
              if(g.players[i].in== false)
                  continue;
              
              else if(g.players[i].winner== true || g.players[i].getScore()== g.getMaxscore())
                  counter++;
                  name=g.players[i].getName();
              }
          }
    public static void main(String[] args) {
        //System.out.println("finished");
     
          g.play();
     winner();
    //  System.out.println("finished");
     if( counter>1)
         System.out.println( "There is no winner in this game");
     
     else
         System.out.println( "The winner is "+ name);
     
        // System.out.println(g.getMaxscore());
     
    // System.out.println("finished");
     }
 
            
    }
    
