package duckcreeper.crates.API.Objects.Exceptions;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class InvalidPrizeInput extends Exception {
	
	private static final long serialVersionUID = 1l;

	public void log(String prizeId) {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(" ");
		console.sendMessage(" ");
		console.sendMessage(ChatColor.RED + "Crates V 1.0 CRATE ERROR: ");
		console.sendMessage(ChatColor.RED + "PROBLEM WITH YOUR \"crate loot.yml\" file!");
		console.sendMessage(ChatColor.RED + "    Prize with error: " + prizeId);
		console.sendMessage(" ");
		console.sendMessage(" ");
	}
	
	public void writeToFile(String prizeId) {
		
		Logger logger = Logger.getLogger("errorLog");
		try {
			FileHandler fh = new FileHandler("plugins/Crates/error log.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.setUseParentHandlers(false);
			
			logger.info("Prize Error - Prize ID: " + prizeId);
		} catch(SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
