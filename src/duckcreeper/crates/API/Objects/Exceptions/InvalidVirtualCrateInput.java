package duckcreeper.crates.API.Objects.Exceptions;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class InvalidVirtualCrateInput extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public void log() {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(" ");
		console.sendMessage(" ");
		console.sendMessage(ChatColor.RED + "Crates V 1.0 HAS FOUND VIRTUAL CRATE ERROR: ");
		console.sendMessage(ChatColor.RED + "PROBLEM WITH YOUR \"virtual crates.yml\" file!!!");
		console.sendMessage(" ");
		console.sendMessage(" ");
	}
	
	public void writeToFile() {
		
		Logger logger = Logger.getLogger("errorLog");
		try {
			FileHandler fh = new FileHandler("plugins/Crates/error log.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.setUseParentHandlers(false);
			
			logger.info("Virtual Crate Error - ERROR WITH VIRTUAL CRATES!!");
		} catch(SecurityException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
