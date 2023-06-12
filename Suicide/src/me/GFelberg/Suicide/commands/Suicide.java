package me.GFelberg.Suicide.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.GFelberg.Suicide.utils.SuicideUtils;

public class Suicide implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("suicide")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can be only made by Players!");
				return true;
			}

			if (!(sender.hasPermission("suicide.suicide"))) {
				sender.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
				return true;
			}

			Player p = (Player) sender;
			SuicideUtils utils = new SuicideUtils();

			if (args.length == 0) {
				utils.suicidePlayer(p);
				return true;
			}

			if (args.length == 1) {

				if (args[0].equalsIgnoreCase("reload")) {
					utils.reloadConfig(p);
				} else if (args[0].equalsIgnoreCase("help")) {
					utils.helpPage(p);
				}
				return true;
			}
		}
		return true;
	}
}
