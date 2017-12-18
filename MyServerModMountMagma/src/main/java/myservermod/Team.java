package myservermod;

import com.youthdigital.servermod.game.*;

public class Team extends TeamData {
  
  
  //Points To Win
  public int pointsToWin = 100;
  
  public Team(String blockName, String teamDisplayName, ChatColors teamColor) {
    super(blockName, teamDisplayName, teamColor);
  
  }
  
 
  @Override
  public void onUpdate() {
   //Points
    if (Conditions.mobDestroyed(EntityZombie.class)){
      points += 10;
    }
  
    if (Conditions.mobDestroyed(EntitySkeleton.class)){
      points += 10;
    }
  
   if (Conditions.mobDestroyed(EntityBlaze.class)){
      points += 30;
    }
  if (Conditions.playerDied()){
    points -= 20;
  }
   if (Conditions.mobDestroyedWithAttribute(EntityBlaze.class, "Shadowlord")){
     points += 50;
   Actions.displayChatMessageToAll("The Shadowlord has been defeated.");
   }
    
    
    
    
    //chests
   points += Actions.updateScoreFromChestItemCount(getTeamName() + "Chest", Items.emerald, 9);
   Actions.clearChest(getTeamName() + "Chest");
  //Game Over
  if (points >= pointsToWin){
    GameManager.triggerGameOver();
    Actions.spawnFireworks("fireworks", getTeamRGBColor());
    Actions.displayTitleToAll(getTeamChatColor() + "Game Over", getTeamDisplayName() + " is the Winner!!!!");
  }
  
  }
  @Override
  public void onResetGameToLobby() {
    Actions.displayChatMessageToAll( getTeamChatColor() + getTeamDisplayName() + ChatColors.WHITE +  " Points: " + points);
    points = 0;
    
  }
  
  @Override
  public void onStartGame() {
    
  }
  
}