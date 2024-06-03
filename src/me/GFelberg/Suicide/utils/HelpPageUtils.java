package me.GFelberg.Suicide.utils;

import me.GFelberg.Suicide.Main;

public class HelpPageUtils {

	public String getHelp_page() {
		return Main.getInstance().getConfig().getString("Help.Page").replace("&", "§");
	}

	public String getHelp_suicide() {
		return Main.getInstance().getConfig().getString("Help.Suicide").replace("&", "§");
	}
	
	public String getHelp_reload() {
		return Main.getInstance().getConfig().getString("Help.Reload").replace("&", "§");
	}
}