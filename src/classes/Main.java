package classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
extends JavaPlugin
{
	
	String prefix = ChatColor.GRAY + "["+ ChatColor.AQUA +"MentionMe"+ ChatColor.GRAY + "] ";
	String noperm = prefix + ChatColor.RED + "Seems like you dont have permission to do that!";
	
	public static Chat chat = null;
	

	  File PlayerInfoFile;
	  File ConfigFile;
	  FileConfiguration PlayerInfo;
	  FileConfiguration Cfg;
	  
	
public void onEnable(){
	new Listeners(this);
	getCommand("mentionme").setExecutor(new commands(this));
	
	PlayerInfoFile = new File(getDataFolder(), "PlayerInfo.yml");
	ConfigFile = new File(getDataFolder(), "Config.yml");
	
    try{
    	firstrun();
    }catch (Exception e){
    	e.printStackTrace();
    }
	PlayerInfo = new YamlConfiguration();
	Cfg = new YamlConfiguration();
	loadYamls();
	
    if (!setupChat()) {
        System.out.println(String.format("[§s] - No Vault dependency found!", getDescription().getName()));
        System.out.println(prefix + "Disabling Vault features!");
        Cfg.set("Chat.Vault", false);
    }else{
    	System.out.println(prefix + "Successfully hooked into Vault!");
    	Cfg.set("Chat.Vault", true);
    }
    saveYamls();
}

public void onDisable(){
System.out.println("[MentionMe] Plugin disabled!");
saveYamls();
}
public void firstrun(){
	if(!PlayerInfoFile.exists()){
		PlayerInfoFile.getParentFile().mkdirs();
		copy(getResource("PlayerInfo.yml"), PlayerInfoFile);
	}
	if(!ConfigFile.exists()){
		ConfigFile.getParentFile().mkdirs();
		copy(getResource("Config.yml"), ConfigFile);
	}
}

private void copy(InputStream in, File file) {
    try {
        OutputStream out = new FileOutputStream(file);
        byte[] buf = new byte[1024];
        int len;
        while((len=in.read(buf))>0){
            out.write(buf,0,len);
        }
        out.close();
        in.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void loadYamls() {
    try {
        PlayerInfo.load(PlayerInfoFile);
        Cfg.load(ConfigFile);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void saveYamls() {
    try {
        PlayerInfo.save(PlayerInfoFile);
        Cfg.save(ConfigFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void writeConfig(){
	Cfg.set("Chat.Layout", "PreVaultGroup");
	Cfg.set("Chat.Transition", ">>");
}
private boolean setupChat() {
	if(getServer().getPluginManager().getPlugin("Vault") != null){
    RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
    chat = rsp.getProvider();
    return chat != null;
	}
	return false;
}
}

