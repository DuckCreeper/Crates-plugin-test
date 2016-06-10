package duckcreeper.crates.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Location implements FileInterface {
	
	private File file;
	private FileConfiguration fileconfig;
	
	public Location() {
		file = new File("plugins/Crates/Dont edit/locations.yml");
		fileconfig = YamlConfiguration.loadConfiguration(file);
	}
	
	@Override
	public FileConfiguration getFile() {
		return fileconfig;
	}
	@Override
	public void save() {
		try {
			fileconfig.save(file);
		} catch(IOException e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void reload() {
		file = new File("plugins/Crates/Dont edit/locations.yml");
		fileconfig = YamlConfiguration.loadConfiguration(file);
	}
	
	@Override
	public void set(String path, Object value) {
		
	}
	
	@Override
	public Object get(String path) {
		return null;
	}
	
	@Override
	public boolean exists() {
		if( new File("plugins/Crates/Dont edit/locations.yml").exists()) return true;
		return false;
	}
	
	@Override
	public void create() {
		getFile().set("crates", new ArrayList<>());
		getFile().set("crates id", 0);
		getFile().set("virtual crates", new ArrayList<>());
		getFile().set("virtual crate id", 0);

		getFile().set("file version", "1.0");
		
		save();
	}
	
	@Override
	public void setHeader() {
		
	}
}
