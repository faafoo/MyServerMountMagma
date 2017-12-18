package myservermod;

import com.youthdigital.servermod.game.*;

public class Player extends PlayerData {

  
  public int credits = 3;
  public Player(EntityPlayer parPlayerObject) {
    super(parPlayerObject);
  }

  @Override
    public void onUpdate() {


      if (Conditions.didRightClickBlock("redteamjoin")){
        GameManager.joinTeam("redTeam");
        Actions.displayChatMessageToAll(Actions.getPlayerName() + " has joined the" + getTeamChatColor() + " Red Team");
        Actions.startCountdown(6);
        
      }

    if (Conditions.didRightClickBlock("blueteamjoin")){
       GameManager.joinTeam("blueTeam");
       Actions.displayChatMessageToAll(Actions.getPlayerName() + " has joined the" + getTeamChatColor() + " Blue Team");
       Actions.startCountdown(6);
      

    }

    if (Conditions.isStandingOnBlock("health") && Conditions.secondsGoneBy(1)){

      Actions.restoreHealth(5);
      Actions.restoreHunger(5);
      Actions.spawnParticles("health", EnumParticleTypes.ENCHANTMENT_TABLE, 50);
      Actions.playSound("health", "randomOrb");
    }
    
    
    
    

      //Store
     
      //Warrior
      if (Conditions.didRightClickBlock("warriorKit") && credits == 3){
       Actions.giveItems(Items.iron_sword, Enchantment.sharpness, 2,
                         Items.iron_helmet, Enchantment.unbreaking, 1,
                         Items.iron_chestplate, Enchantment.unbreaking, 1,
                         Items.iron_leggings, Enchantment.unbreaking, 1,
                         Items.iron_boots, Enchantment.unbreaking, 1, 
                         Items.iron_pickaxe,
                         Potion.moveSlowdown, 10000, 0);
       Actions.displayChatMessage("Warrior, arise!");
       credits = credits - 3;
     } 
      //Archer
     if (Conditions.didRightClickBlock("archerKit") && credits == 3){
       Actions.giveItems(Items.bow, Enchantment.punch, 1,
                         Items.arrow, 64,
                         Items.leather_helmet,
                         Items.leather_chestplate,
                         Items.leather_leggings,
                         Items.leather_boots,
                         Items.iron_pickaxe,
                         Potion.moveSpeed, 10000);
       Actions.displayChatMessage("May your bow bring destruction!");
       credits = credits - 3;
     }
      //Mage
     if (Conditions.didRightClickBlock("mageKit") && credits ==3){
       Actions.giveItems(Items.snowball, 200,
                         Items.leather_helmet,Enchantment.fireProtection, 1,
                         Items.leather_chestplate, Enchantment.fireProtection, 1,
                         Items.leather_leggings, Enchantment.fireProtection, 1,
                         Items.leather_boots, Enchantment.fireProtection, 1,
                         Items.iron_pickaxe,
                         Potion.nightVision, 10000, 1);
       Actions.displayChatMessage("Rise Mage, and may the world bow to your feet!");
       credits = credits - 3;
     }
      
      //Ninja
      if (Conditions.didRightClickBlock("ninjaKit") && credits == 3){
        Actions.giveItems(Items.iron_sword,
                          Items.snowball, 16,
                          Items.iron_pickaxe,
                          Potion.jump, 10000, 1);
        Actions.displayChatMessage("It's the Silent, It's the Acrobatic, It's the NINJA!!!!!");
        credits = credits - 3;
      }
      
      //Tank
      if (Conditions.didRightClickBlock("tankKit") && credits == 3){
        Actions.giveItems(Items.wooden_sword, Enchantment.unbreaking, 3,
                          Items.diamond_helmet,
                          Items.diamond_chestplate,
                          Items.diamond_leggings,
                          Items.diamond_boots,
                          Items.iron_pickaxe,
                          Potion.healthBoost,10000,1);
        Actions.displayChatMessage("May you always survive.");
        credits = credits - 3;
      }
      
      //Alchemist
     if (Conditions.didRightClickBlock("cowboyKit") && credits == 3){
       Actions.giveItems(Items.chainmail_helmet,
                        Items.chainmail_chestplate,
                        Items.chainmail_leggings,
                        Items.chainmail_boots, 
                        Items.iron_pickaxe);
     	SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       	SuperItems.givePlayerSpecialItem(Potions.Invisibility_II);
      SuperItems.givePlayerSpecialItem(Potions.Invisibility_II);
       SuperItems.givePlayerSpecialItem(Potions.Slowness_II);
      SuperItems.givePlayerSpecialItem(Potions.Slowness_II);
      SuperItems.givePlayerSpecialItem(Potions.Slowness_II);
      SuperItems.givePlayerSpecialItem(Potions.Harming_II);
       SuperItems.givePlayerSpecialItem(Potions.Harming_II);
       SuperItems.givePlayerSpecialItem(Potions.Harming_II);
       SuperItems.givePlayerSpecialItem(Potions.Harming_II);
       SuperItems.givePlayerSpecialItem(Potions.Harming_II);
       SuperItems.givePlayerSpecialItem(Potions.Harming_II);
      SuperItems.givePlayerSpecialItem(Potions.Swiftness_II);
       SuperItems.givePlayerSpecialItem(Potions.Swiftness_II);
       SuperItems.givePlayerSpecialItem(Potions.Swiftness_II);
		 SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
       SuperItems.givePlayerSpecialItem(Potions.Instant_Health_II);
     Actions.displayChatMessage("Mwahahahahaha! Mad Science!");
     credits = credits - 3;
     }
      
      //Cowboy
       if (Conditions.didRightClickBlock("alchemistKit") && credits == 3){
         Actions.giveItems(Items.bow, Enchantment.punch, 2,
                           Items.arrow, 64,
                           Items.iron_pickaxe,
                           Items.leather_helmet, Enchantment.unbreaking, 3,
                           Items.leather_chestplate, Enchantment.unbreaking, 3,
                           Items.leather_leggings, Enchantment.unbreaking, 3,
                           Items.leather_boots, Enchantment.unbreaking, 3,
                           Items.golden_apple, 20,
                           Items.saddle);
         SuperItems.givePlayerSpecialItem(SpawnEggs.horse);
         SuperItems.givePlayerSpecialItem(SpawnEggs.horse);
         Actions.displayChatMessage("Yee Haw! The Cowboy's in town!");
         credits = credits - 3;
       }
      
      //Prisioners of war
      Random random = new Random ();
      String[] talkArray = {"[Prisioner] I heard that the Shadowlord appears when some time has passed.", "[Prisioner] I heard that you can gain credits by shooting at the archery range.", "[Prisioner] I heard that if you shoot one of the buttons on one of the bases, somthing happens.", "[Prisioner] I heard that if you sneak at one block, you get a buff.", "[Prisioner] I heard that you can summon the Holy Nova in some mysterious way.",};
      int talkNumber = random.nextInt(talkArray.length);
      
      	 if (Conditions.didRightClickBlock("prision")){
           		Actions.displayChatMessage(talkArray[talkNumber]);
          }
     //Display
      if (credits > 0){
       
       Actions.displaySmallInfo("Credits: " + credits);

     }
     if (GameManager.isGameActive()){
       if (Game.secondsLeft > 9){
       Actions.displaySmallInfo(getTeamChatColor() + getTeamDisplayName() + " - " + Game.minutesLeft + ":" + Game.secondsLeft);  
       } else {
       Actions.displaySmallInfo(getTeamChatColor() + getTeamDisplayName() + " - " + Game.minutesLeft + ":0" + Game.secondsLeft);  
       }
       
      }
     if (Conditions.playerDied()){
       Actions.dropItems(Items.emerald);
     }
    //Notifications
     if (Conditions.playerDied()){
       Actions.displayChatMessage("-20 points");
     } 
      if (Conditions.mobDestroyed(EntityZombie.class)){
       Actions.displayChatMessage("+10 points!");
     } 
      if (Conditions.mobDestroyed(EntitySkeleton.class)){
       Actions.displayChatMessage("+10 points!");
     } 
      if (Conditions.mobDestroyed(EntityBlaze.class)){
       Actions.displayChatMessage("+30 points!");
     } 
      if (Conditions.itemsInInventory(Items.emerald, 2)){
        Actions.displayChatMessage("You can carry no more emeralds!");
      }
    
    //Easter Eggs
    if (Conditions.didRightClickBlock("clickEgg")){
      Actions.giveItems(Blocks.crafting_table, Items.diamond, 2, Items.stick);
      Actions.displayChatMessage("You Found an Easter Egg!");
    }
    
    if (Conditions.isSneakingOnBlock("shiftEgg")){
      Actions.givePotion(Potion.absorption, 60, 10);
      Actions.displayChatMessage("You Found an Easter Egg");
    }
    if (Conditions.isArrowInArea("arrowEgg", 4)){
      Actions.spawnEntity("arrowEgg", EntityCow.class, 100);
      Actions.displayChatMessage("You found an Easter Egg!");
    }
    
    //Cheat Codes
    if (Conditions.cheatEntered("Holy Nova")){
      Actions.giveItems(Items.diamond_sword, 
                        Enchantment.smite, 2,
                        Enchantment.fireAspect, 2,
                        Enchantment.sharpness, 3,
                        Enchantment.knockback, 2);
     Actions.displayChatMessage("The Holy Nova has Arrived!");
    }
    
    if (Conditions.cheatEntered("givePoints")){
      getTeam().points += GameManager.getValueFromCheat(1);
    
    Actions.displayChatMessage("You have earned points!");
    }
    if (Conditions.cheatEntered("SpecialKit") && credits == 3){
      credits -= 3;
      Actions.giveItems(Items.diamond_sword, Enchantment.fireAspect, 2, Enchantment.sharpness, 4, Enchantment.knockback, 3,
                        Items.diamond_helmet, Enchantment.fireProtection, 2, Enchantment.thorns, 2,
                        Items.diamond_chestplate, Enchantment.fireProtection, 2, Enchantment.thorns, 2,
                        Items.diamond_leggings, Enchantment.fireProtection, 2, Enchantment.thorns, 2,
                        Items.diamond_boots, Enchantment.fireProtection, 2, Enchantment.thorns, 2,
                        Items.iron_pickaxe,
                        Potion.invisibility, 10000,
                       	Potion.fireResistance, 10000);
      Actions.displayChatMessage("I pronounce you RULER of all Shadows!");
      
    }
     if (Conditions.cheatEntered("MageSight")){
       Actions.givePotion(Potion.nightVision, GameManager.getValueFromCheat(1), GameManager.getValueFromCheat(2));
       Actions.displayChatMessage("I summon, Mage Sight!");
     }
    //Archery
     if (Conditions.isArrowInArea("archeryHit", 2)){
       credits += 1;
     }
     if (Conditions.didRightClickBlock("archeryRange")){
       Actions.teleportPlayers("archeryEntery");
       Actions.fillChest("bowArrow", Items.bow, Items.arrow, 64);   
     
     
     }
      
     if (Conditions.didRightClickBlock("archeryReturn")){
       Actions.teleportPlayers("archeryExit"); 
      }
      
      //Store
      if (Conditions.didRightClickBlock("brewingBuy") && credits >=5){
        Actions.giveItems(Items.brewing_stand);
      credits -= 5;
      }
       
      if (Conditions.didRightClickBlock("potionBuy") && credits >=10){
        Actions.giveItems(Items.nether_wart);
        Actions.giveItems(Items.sugar);
        Actions.giveItems(Items.magma_cream);
        Actions.giveItems(Items.rabbit_foot);
        Actions.giveItems(Items.golden_carrot);
        
        
        credits -= 10;
      }
    if (Conditions.didRightClickBlock("swordBuy") && credits >=1){
        Actions.giveItems(Items.iron_sword);
      credits -= 1;
      }
    
    if (Conditions.didRightClickBlock("shopEntry")){
        Actions.teleportPlayers("shopEntrance");
      }  
      if (Conditions.didRightClickBlock("shopExit")){
       Actions.teleportPlayers("shopLobby"); 
      }
       
      if (Conditions.didRightClickBlock("bottleBuy") && credits >= 1){
       Actions.giveItems(Items.glass_bottle, 3);
      credits -= 1;
      }
        
    //Boss Teleport
    if (Conditions.isStandingOnBlock("bossRedTeleport")){
      Actions.teleportPlayers("redTeamBoss");
    }
    if (Conditions.isStandingOnBlock("bossBlueTeleport")){
      Actions.teleportPlayers("blueTeamBoss");
    }
    if (Conditions.isStandingOnBlock("baseTeleport")){
      Actions.teleportPlayers(getTeamBase());
    }
    }






  @Override
  public void onJoinedServer(){
   //Instructions
    Actions.displayChatMessage("How to Play");
    Actions.displayChatMessage("===========");
    Actions.displayChatMessage("Choose a kit and pick a team to start a game");
    Actions.displayChatMessage("Bring Emeralds back to chest and fight mobs for points");
    Actions.displayChatMessage("100 points to win");
    
    
    Actions.teleportPlayers("lobbySpawn");


  }

  @Override
  public void onStartGame() {
     Actions.teleportPlayers(getTeamBase());
     
       
  }

  @Override
  public void onResetGameToLobby() {
      credits = 3;
      Actions.restoreHealth(20);
      Actions.restoreHunger(20);
      Actions.clearPotions();
      Actions.removeItems();
      Actions.teleportPlayers("lobbySpawn");
    

  }

  @Override
  public void onRespawned() {

     Actions.teleportPlayers(getTeamBase());

  }

}