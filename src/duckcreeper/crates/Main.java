package duckcreeper.crates;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new OnEnable(this);
	}
	
	@Override
	public void onDisable() {
		
	}

}
