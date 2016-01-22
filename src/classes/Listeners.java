package classes;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;

public class Listeners 
implements Listener
{
	  private Main plugin;
	  public Listeners(Main main)
	  {
	    this.plugin = main;
	    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	  }
	 
	  

	@EventHandler(priority = EventPriority.HIGHEST )
	  public void onChat(AsyncPlayerChatEvent e){
		FileConfiguration PlayerInfo = this.plugin.PlayerInfo;
		FileConfiguration Cfg = this.plugin.Cfg;
		  
		  String incomingMessage = e.getMessage();
		  for(Player p : Bukkit.getServer().getOnlinePlayers()){
				if(PlayerInfo.getConfigurationSection("Players." + p.getName()) == null){
					PlayerInfo.set("Players."+ p.getName() + ".color", 4);
					PlayerInfo.set("Players." + p.getName() + ".sound.tone", "PIANO");
					PlayerInfo.set("Players." + p.getName() + ".sound.volume", 10);
					PlayerInfo.set("Players." + p.getName() + ".sound.pitch", 5);
					plugin.saveYamls();
				}
				if(Cfg.getString("Chat.Transition") == null){
					Cfg.set("Chat.Transition", ">>");
					Cfg.set("Chat.MessageColor", "7");
					plugin.saveYamls();
				}
				if(Cfg.getString("Chat.Layout") == null){
					Cfg.set("Chat.Layout", "PreVaultGroup");
					plugin.saveYamls();
				}
				if(PlayerInfo.get("Players." + p.getName() + ".enabled") == null){
					PlayerInfo.set("Players." + p.getName() + ".enabled", true);
				}
			  
			  if(PlayerInfo.getBoolean("Players." + p.getName() + ".enabled") == true){
			  incomingMessage = incomingMessage.replaceAll(p.getName(), "§" + PlayerInfo.getString("Players." + p.getName() + ".color")+ "@" + p.getName()+ "§" +Cfg.getString("Chat.MessageColor"));
			  }
			  if(e.getMessage().toLowerCase().contains(p.getName().toLowerCase())){
				  if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("PIANO")){
				  p.playSound(p.getLocation(), Sound.NOTE_PIANO, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("CLICK")){
				  p.playSound(p.getLocation(), Sound.CLICK, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("FIREWORK")){
				  p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("ARROW_HIT")){
				  p.playSound(p.getLocation(), Sound.ARROW_HIT, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("ANVIL")){
				  p.playSound(p.getLocation(), Sound.ANVIL_LAND, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("THUNDER")){
				  p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("CAT")){
				  p.playSound(p.getLocation(), Sound.CAT_MEOW, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
				  else if(PlayerInfo.getString("Players." + p.getName() + ".sound.tone").equals("BASS")){
				  p.playSound(p.getLocation(), Sound.NOTE_BASS, PlayerInfo.getInt("Players." + p.getName() + ".sound.volume"), PlayerInfo.getInt("Players." + p.getName() + ".sound.pitch"));
				  }
			  }
		  }
		  if(Cfg.getBoolean("Chat.Vault") == false){
		  e.setMessage("§" +Cfg.getString("Chat.MessageColor") + incomingMessage);
		  }else if(Cfg.getBoolean("Chat.Vault") == true) {
			  if(Cfg.getString("Chat.Layout").equalsIgnoreCase("PreVaultGroup")){
				  String Prefix = Main.chat.getGroupPrefix("world", Main.chat.getPrimaryGroup(e.getPlayer()));
				  String NewPrefix = Prefix.replace('&', '§');
				  String Message = incomingMessage;
				  String Player = e.getPlayer().getDisplayName();
				  e.setFormat(NewPrefix + " " + Player + " §" + Cfg.getString("Chat.MessageColor")+ Cfg.getString("Chat.Transition") + " " + Message);
			  }
			  else if(Cfg.getString("Chat.Layout").equalsIgnoreCase("PreVaultPlayer")){
				  String Prefix = Main.chat.getPlayerPrefix(e.getPlayer());
				  String NewPrefix = Prefix.replace('&', '§');
				  String Message = incomingMessage;
				  String Player = e.getPlayer().getDisplayName();
				  e.setFormat(NewPrefix + " " + Player + " §" + Cfg.getString("Chat.MessageColor")+ Cfg.getString("Chat.Transition") + " " + Message);
				  }
			  else if(Cfg.getString("Chat.Layout").equalsIgnoreCase("SufVaultPlayer")){
				  String Suffix = Main.chat.getPlayerSuffix(e.getPlayer());
				  String NewSuffix = Suffix.replace('&', '§');
				  String Message = incomingMessage;
				  String Player = e.getPlayer().getDisplayName();
				  e.setFormat(Player + NewSuffix + " §" + Cfg.getString("Chat.MessageColor")+ Cfg.getString("Chat.Transition") + " " + Message);
				  }
			  else if(Cfg.getString("Chat.Layout").equalsIgnoreCase("SufVaultGroup")){
				  String Suffix = Main.chat.getGroupSuffix("world", Main.chat.getPrimaryGroup(e.getPlayer()));
				  String NewSuffix = Suffix.replace('&', '§');
				  String Message = incomingMessage;
				  String Player = e.getPlayer().getDisplayName();
				  e.setFormat(Player + NewSuffix + " §" + Cfg.getString("Chat.MessageColor")+ Cfg.getString("Chat.Transition") + " " + Message);
				  }
			  else if(Cfg.getString("Chat.Layout").equalsIgnoreCase("None")){
				  e.setMessage("§" +Cfg.getString("Chat.MessageColor") + incomingMessage);
			  }
			}
	   }
}
