package myservermod;

import com.youthdigital.servermod.game.*;

public class Game extends TeamData {
 //Variables 
  public static int minutesLeft = 5;
  public static int secondsLeft = 30;
  
  public void setTimer(){
    minutesLeft = 5;
    secondsLeft = 30;
  }
  
  
  
  
  public Game(ChatColors teamColor, String teamNameDisplay) {
    super("All Players", teamColor, teamNameDisplay);
    setTimer();
  }
  
  public static void setupGameRules() {
    //Game Rules
    GameInfo.setServerDescription("Volcano of the Shadows");
    GameInfo.addToOPs("Mooheadkid, ydDamon, ydParker");
    GameInfo.addAllowedBreakableBlock(Blocks.emerald_ore);
    GameInfo.addMaxItemsHeldLimit(Items.emerald, 2);
    GameInfo.disableBlockBreaking();
    GameInfo.disableMobSpawning();
    GameInfo.setTime(18000);
    GameInfo.setDifficulty(2);
    GameInfo.isRaining(false);
    GameInfo.setPVP(false);
    GameInfo.setLobbyPVP(false);
    GameInfo.setTeamPVP(false);
    
    
    
    Welcome.setWelcomeMessage("Volcano of the Shadows", "Be wary of the Shadowlord");
    Welcome.setWelcomeSound("fireworks.blast_far1");
    
    Team redTeam = new Team("redTeam","Red Team", ChatColors.RED);
    Team blueTeam = new Team("blueTeam", "Blue Team", ChatColors.BLUE);
    GameInfo.addTeam(redTeam);
    GameInfo.addTeam(blueTeam);
  
  }
  
  @Override
  public void onUpdate() {
   
    //Fire Resistent Zombie
    if (Conditions.secondsGoneBy(5)){
              
       Actions.spawnSpecialEntityInRange("zombieSpawn",  20, EntityZombie.class, 1, Items.iron_sword, Enchantment.fireAspect,2,
                                                                                  Items.iron_helmet,
                                                                                  Items.iron_chestplate,
                                                                                  Items.iron_leggings,
                                                                                  Items.iron_boots,Potion.fireResistance,10000, SharedMonsterAttributes.maxHealth, 10);

    }
    //Nimble Skeleton
     if (Conditions.secondsGoneBy(5)){
              
       Actions.spawnSpecialEntityInRange("skeletonSpawn", 20, EntitySkeleton.class, 1, Items.bow, Enchantment.flame,2,
                                                                                  Items.leather_helmet,
                                                                                  Items.leather_chestplate,
                                                                                  Items.leather_leggings,
                                                                                 Items.leather_boots,Potion.moveSpeed,10000, SharedMonsterAttributes.maxHealth, 6);

    }
       
    //Shadow 
    if (Conditions.secondsGoneBy(5)){
            Actions.spawnSpecialEntityInRange("blazeSpawn", 10, EntityBlaze.class, 1, 
                                              Potion.invisibility,10000, 
                                              SharedMonsterAttributes.maxHealth, 20);

        }
   //Shadowlord
   if (minutesLeft == 3 && secondsLeft == 0 && Conditions.secondsGoneBy(1)){
     MobMania.spawnMountedEntityInRange("bossSpawn", 1000000, 1,EntityBlaze.class, 1, "Shadowlord", Potion.invisibility, 1000,
                                        								SharedMonsterAttributes.maxHealth, 80,
                                       							EntityBlaze.class, 1, "Shadowlord", Potion.invisibility, 1000,
                                                             SharedMonsterAttributes.maxHealth, 80);
     Actions.displayTitle("The Shadowlord", "The ruler of Shadows has spawned!");
   }
    
    
    //Chests
   
    Random random = new Random ();
    int fillRate = random.nextInt(5) + 3;
    
    
    
    String[] chestArray = {"basicChest", "advancedChest", "secretChest",};
    
    Item[] itemArray = {Items.iron_sword,Items.flint_and_steel, Items.cooked_porkchop, Items.map};
    int chestNumber = random.nextInt(chestArray.length);
    int itemNumber = random.nextInt(itemArray.length);
    
    if (Conditions.secondsGoneBy(fillRate)  &&  Conditions.getChestCount(chestArray[chestNumber])  <  3 ) {
      Actions.fillChest(chestArray[chestNumber], itemArray[itemNumber], 1);
    }  

    
//Timer
 if (GameManager.isGameActive()){
   if (Conditions.secondsGoneBy(1)){
    if (secondsLeft > 0){
      secondsLeft--;
    } else {
      minutesLeft--;
      secondsLeft = 59;
    }
    
  }
 }
  if (secondsLeft == 0 && minutesLeft == 0){
    GameManager.triggerGameOver();
  }  
  
//Ore Restore
 if (Conditions.secondsGoneBy(60)){
   Actions.loadBlocks("ores");
   Actions.saveBlocks("ores", 33, Blocks.emerald_ore);
 }    
    
    
    
  }
  
  @Override
  public void onResetGameToLobby() {
    Actions.loadBlocks("ores");
    setTimer();
  }
  
  @Override
  public void onStartGame() {
   Actions.saveBlocks("ores", 33, Blocks.emerald_ore);
  }
  
}