package me.GFelberg.Suicide.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.GFelberg.Suicide.Main;

public class SuicideUtils {

	public static String prefix, message, help_page, help_suicide, help_reload;

	public static void loadVariables() {
		prefix = Main.getInstance().getConfig().getString("Suicide.Prefix").replace("&", "§");
		message = Main.getInstance().getConfig().getString("Suicide.Message").replace("&", "§");
		help_page = Main.getInstance().getConfig().getString("Help.Page").replace("&", "§");
		help_suicide = Main.getInstance().getConfig().getString("Help.Suicide").replace("&", "§");
		help_reload = Main.getInstance().getConfig().getString("Help.Reload").replace("&", "§");
	}

	public void reloadConfig(Player p) {

		if (!(p.hasPermission("suicide.reload"))) {
			p.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
		} else {
			Main.getInstance().reloadConfig();
			loadVariables();
			p.sendMessage(prefix + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			Bukkit.getServer().getConsoleSender().sendMessage("=========================================");
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Suicide Plugin reloaded");
			Bukkit.getServer().getConsoleSender().sendMessage("=========================================");
		}
	}

	public void helpPage(Player p) {

		if (!(p.hasPermission("suicide.admin"))) {
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
			p.sendMessage(ChatColor.AQUA + "Suicide - Help Commands");
			p.sendMessage(ChatColor.YELLOW + "/suicide help : " + help_page);
			p.sendMessage(ChatColor.YELLOW + "/suicide : " + help_suicide);
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		} else {
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
			p.sendMessage(ChatColor.AQUA + "Suicide - Help Commands");
			p.sendMessage(ChatColor.YELLOW + "/suicide help : " + help_page);
			p.sendMessage(ChatColor.YELLOW + "/suicide : " + help_suicide);
			p.sendMessage(ChatColor.YELLOW + "/suicide reload : " + help_reload);
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		}
	}

	public void suicidePlayer(Player p) {
		p.setHealth(0);
		p.sendMessage(message);
	}
}