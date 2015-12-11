package classes;


import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor {

	  private Main plugin;
	  
	  public commands(Main main)
	  {
	    this.plugin = main;
	  }
	  
	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
		    FileConfiguration PlayerInfo = this.plugin.PlayerInfo;
		    FileConfiguration Cfg = this.plugin.Cfg;
			if(args.length == 0){
				p.sendMessage(plugin.prefix + ChatColor.GRAY + "/mentionme help");
			}
			else if(args[0].equalsIgnoreCase("Help")){
				if(p.hasPermission("mentionme.help")){
					sendhelp(p);
				}else{
					p.sendMessage(plugin.noperm);
				}
				}
			else if(args[0].equalsIgnoreCase("toggle")){
				if(p.hasPermission("mentionme.toggle")){
					if(PlayerInfo.getBoolean("Players." + p.getName() + ".enabled") == true){
						PlayerInfo.set("Players." + p.getName() + ".enabled", false);
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "You disabled the colored mention!");
					}else{
						PlayerInfo.set("Players." + p.getName() + ".enabled", true);
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "You enabled the colored mention!");
					}
				}
			}
			
			else if(args[0].equalsIgnoreCase("color")){
				if(p.hasPermission("mentionme.color")){
				 if(args.length == 2){
					 if(args[1].equalsIgnoreCase("Black")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 0);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkBlue")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 1);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkGreen")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 2);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkAqua")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 3);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkRed")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 4);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Purple")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 5);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Gold")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 6);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Gray")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 7);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkGray")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 8);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Blue")){
						 PlayerInfo.set("Players." + p.getName() + ".color", 9);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Green")){
						 PlayerInfo.set("Players." + p.getName() + ".color", "a");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Aqua")){
						 PlayerInfo.set("Players." + p.getName() + ".color", "b");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Red")){
						 PlayerInfo.set("Players." + p.getName() + ".color", "c");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Pink")){
						 PlayerInfo.set("Players." + p.getName() + ".color", "d");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Yellow")){
						 PlayerInfo.set("Players." + p.getName() + ".color", "e");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("White")){
						 PlayerInfo.set("Players." + p.getName() + ".color", "f");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New color set!");
						 plugin.saveYamls();
					 }else{
						 p.sendMessage(plugin.prefix + ChatColor.RED + "Unknown color!");
					 }
				 }else{
					 p.sendMessage(plugin.prefix + ChatColor.RED + "Please define a color!");
					 p.sendMessage(plugin.prefix + ChatColor.RED + "/mentionme colorlist");
				 }
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("colorlist")){
				if(p.hasPermission("mentionme.colorlist")){
				p.sendMessage(plugin.prefix + "§0Black, §1DarkBlue, §2DarkGreen");
				p.sendMessage(plugin.prefix + "§3DarkAqua, §4DarkRed, §5Purple");
				p.sendMessage(plugin.prefix + "§6Gold, §7Gray, §8DarkGray");
				p.sendMessage(plugin.prefix + "§9Blue, §aGreen, §bAqua");
				p.sendMessage(plugin.prefix + "§cRed, §dPink, §eYellow");
				p.sendMessage(plugin.prefix + "§fWhite");
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("sound")){
				if(p.hasPermission("mentiome.sound")){
				if(args.length == 2){
					if(args[1].equalsIgnoreCase("piano")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "PIANO");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("click")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "CLICK");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("firework")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "FIREWORK");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("arrow")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "ARROW_HIT");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("anvil")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "ANVIL");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("thunder")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "THUNDER");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("cat")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "CAT");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else if(args[1].equalsIgnoreCase("bass")){
						 PlayerInfo.set("Players." + p.getName() + ".sound.tone", "BASS");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New sound set!");
						 plugin.saveYamls();
					}
					else{
						p.sendMessage(plugin.prefix + ChatColor.RED + "Unknown sound!");
						p.sendMessage(plugin.prefix + ChatColor.RED + "/mentionme soundlist");
					}
				}else{
					p.sendMessage(plugin.prefix + ChatColor.RED + "Too few arguments!");
					p.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /mentionme sound <soundname>");
				}
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("soundlist")){
				if(p.hasPermission("mentionme.soundlist")){
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "Available sounds:");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Piano");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Click");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Firework");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Arrow");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Anvil");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Thunder");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Cat");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "-Bass");
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "To test a sound use: /mentionme playsound <name>");
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("playsound")){
				if(p.hasPermission("mentionme.playsound")){
				if(args.length != 2){
					p.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /mentionme playsound <name>");
				}else{
					if(args[1].equalsIgnoreCase("Piano")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Piano!");
						p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Click")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Click!");
						p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Firework")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Firework!");
						p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Arrow")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Arrow!");
						p.playSound(p.getLocation(), Sound.ARROW_HIT, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Anvil")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Anvil!");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Thunder")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Thunder!");
						p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Cat")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Cat!");
						p.playSound(p.getLocation(), Sound.CAT_MEOW, 10, 1);
					}
					else if(args[1].equalsIgnoreCase("Bass")){
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Playing sound: "+ ChatColor.GOLD + "Bass!");
						p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
					}
					else{
						p.sendMessage(plugin.prefix + ChatColor.RED + "Unknown sound!");
						p.sendMessage(plugin.prefix + ChatColor.RED + "/mentionme soundlist");
					}
					}
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("chatcolor")){
				if(p.hasPermission("mentionme.chatcolor")){
				 if(args.length == 2){
					 if(args[1].equalsIgnoreCase("Black")){
						 Cfg.set("Chat.MessageColor", 0);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkBlue")){
						 Cfg.set("Chat.MessageColor", 1);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkGreen")){
						 Cfg.set("Chat.MessageColor", 2);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkAqua")){
						 Cfg.set("Chat.MessageColor", 3);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkRed")){
						 Cfg.set("Chat.MessageColor", 4);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Purple")){
						 Cfg.set("Chat.MessageColor", 5);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Gold")){
						 Cfg.set("Chat.MessageColor", 6);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Gray")){
						 Cfg.set("Chat.MessageColor", 7);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("DarkGray")){
						 Cfg.set("Chat.MessageColor", 8);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Blue")){
						 Cfg.set("Chat.MessageColor", 9);
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Green")){
						 Cfg.set("Chat.MessageColor", "a");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Aqua")){
						 Cfg.set("Chat.MessageColor", "b");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Red")){
						 Cfg.set("Chat.MessageColor", "c");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Pink")){
						 Cfg.set("Chat.MessageColor", "d");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("Yellow")){
						 Cfg.set("Chat.MessageColor", "e");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }
					 else if(args[1].equalsIgnoreCase("White")){
						 Cfg.set("Chat.MessageColor", "f");
						 p.sendMessage(plugin.prefix + ChatColor.GREEN + "New chatcolor set!");
						 plugin.saveYamls();
					 }else{
						 p.sendMessage(plugin.prefix + ChatColor.RED + "Unknown color!");
					 }
				 }else{
					 p.sendMessage(plugin.prefix + ChatColor.RED + "Please define a color!");
					 p.sendMessage(plugin.prefix + ChatColor.RED + "/mentionme colorlist");
				 }
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("volume")){
				if(p.hasPermission("mentionme.volume")){
				if(args.length == 2){
					p.sendMessage(plugin.prefix + ChatColor.GREEN + "Default is 10.");
					int eingabe = Integer.parseInt(args[1]);
					if(eingabe < 0){
						p.sendMessage(plugin.prefix + ChatColor.RED + "Volume has to be at least 0!");
					}
					else if(eingabe >= 21){
						p.sendMessage(plugin.prefix + ChatColor.RED + "Volume to high!");
						p.sendMessage(plugin.prefix + ChatColor.RED + "Please enter a number between 0 - 20.");
					}
					else if(eingabe >= 0 && eingabe <= 20){
						PlayerInfo.set("Players." + p.getName() + "sound.volume", eingabe);
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Successfully set new volume!");
					}
				}else{
					p.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /mentionme volume <volume>");
				}
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
			else if(args[0].equalsIgnoreCase("pitch")){
				if(p.hasPermission("mentionme.pitch")){
				if(args.length == 2){
					p.sendMessage(plugin.prefix + ChatColor.GREEN + "Default is 5.");
					int eingabe = Integer.parseInt(args[1]);
					if(eingabe <= 0){
						p.sendMessage(plugin.prefix + ChatColor.RED + "Pitch has to be at least 1!");
					}
					else if(eingabe >= 11){
						p.sendMessage(plugin.prefix + ChatColor.RED + "Pitch to high!");
						p.sendMessage(plugin.prefix + ChatColor.RED + "Please enter a number between 0 - 10.");
					}
					else if(eingabe >= 1 && eingabe <= 10){
						PlayerInfo.set("Players." + p.getName() + "sound.pitch", eingabe);
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Successfully set new pitch!");
					}
				}else{
					p.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /mentionme pitch <pitch>");
				}
				}else{
					p.sendMessage(plugin.noperm);
				}
			}
		}else{
			System.out.println("You have to be a player to perform this command!");
		}
		return true;
	}
public void sendhelp(Player p){
	if(p.hasPermission("mentionme.chatcolor")){
	p.sendMessage(plugin.prefix + ChatColor.DARK_AQUA + " - Help - ");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme color <color> - Sets the mention to the desired color.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme colorlist - Displays all available colors.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme sound <sound> - Changes the mention tone.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme soundlist - Displays all available tones.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme playsound <sound> - To test the sounds.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme chatcolor <color> - Sets the chat color.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme volume <volume> - Changes your mention volume.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme pitch <color> - Sets your mention pitch.");
	p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme toggle - Turns colored mentions on and off.");
	}else{
		p.sendMessage(plugin.prefix + ChatColor.DARK_AQUA + " - Help - ");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme color <color> - Sets the mention to the desired color.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme colorlist - Displays all available colors.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme sound <sound> - Changes the mention tone.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme soundlist - Displays all available tones.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme playsound <sound> - To test the sounds.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme volume <volume> - Changes your mention volume.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme pitch <pitch> - Sets your mention pitch.");
		p.sendMessage(plugin.prefix + ChatColor.DARK_GREEN + "/mentionme toggle - Turns colored mentions on and off.");
	}
	
}
	
}
