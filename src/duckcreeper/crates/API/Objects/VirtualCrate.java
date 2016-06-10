package duckcreeper.crates.API.Objects;

import java.util.ArrayList;

import duckcreeper.crates.API.Objects.Exceptions.InvalidVirtualCrateInput;
import duckcreeper.crates.API.Objects.Exceptions.InvalidKeyInput;
import duckcreeper.crates.Files.FileHandler;
import duckcreeper.crates.Util.FileType;

public class VirtualCrate {
	
	private String title;
	private int blockID;
	private int blockData;
	private String openSound;
	private String winSound;
	private String scrollSound;
	private boolean firework;
	private int openDuration;
	private int prizeDisplayDuration;
	private boolean disableColoredGlass;
	private ArrayList<String> useableKeys;
	
	@SuppressWarnings("unchecked")
	public VirtualCrate() throws InvalidVirtualCrateInput {
		try {
			this.title = (String) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.title");
			this.blockID = (int) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.blockID");
			this.blockData = (int) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.blockData");
			this.openSound = (String) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.openSound");
			this.winSound = (String) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.winSound");
			this.scrollSound = (String) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.scrollSound");
			this.firework = (boolean) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.firework");
			this.openDuration = (int) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.openDuration");
			this.prizeDisplayDuration = (int) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.prizeDisplayDuration");
			this.disableColoredGlass = (boolean) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.disableColouredGlass");
			this.useableKeys = (ArrayList<String>) FileHandler.get(FileType.VIRTUAL_CRATES, "Virtual Crates.useableKeys");
		} catch(Exception e) {
			throw new InvalidVirtualCrateInput();
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getBlockID() {
		return this.blockID;
	}
	
	public int getBlockData() {
		return this.blockData;
	}
	
	public String getOpenSound() {
		return this.openSound;
	}
	
	public String getWinSound() {
		return this.winSound;
	}
	
	public String getScrollSound() {
		return this.scrollSound;
	}

	public boolean firework() {
		return this.firework;
	}
	
	public int getOpenDuration() {
		return this.openDuration;
	}
	
	public int getPrizeDisplayDuration() {
		return this.prizeDisplayDuration;
	}
	
	public boolean disableColoredGlass() {
		return this.disableColoredGlass;
	}
	
	public ArrayList<Key> getRawUseableKeys() {
		ArryList<Key> useable = new ArrayList<>();
		for(String s : this.useableKeys) {
			Key key = null;
			try {
				key = new Key(s);
			} catch(InvalidKeyInput e) {
				e.log(s);
				e.writeToFile(s);
			}
			if(key == null) continue;
			useable.add(key);
		}
		return useable;
	}

}
