package duckcreeper.crates.Util;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import duckcreeper.crates.API.Objects.Key;
import duckcreeper.crates.API.Objects.Exceptions.InvalidKeyInput;
import duckcreeper.crates.Files.FileHandler;


public class KeyFinder {

	public static String findKeyType(ItemStack item) {
		ArrayList<ItemStack> keys = new ArrayList<>();
		for(String s : FileHandler.getSection(FileType.KEYS, "Keys").getKeys(false))
			try {
				keys.add(new Key(s).getItem());
			} catch (InvalidKeyInput e) {
				e.log(s);
				e.writeToFile(s);
			}
		if(keys.contains(item)) {
			String keyType = null;
			for(String s : FileHandler.getSection(FileType.KEYS, "Keys").getKeys(false)) {
				Key key = null;
				try {
					key = new Key(s);
				} catch (InvalidKeyInput e) {
					e.log(s);
					e.writeToFile(s);
				}
				if(key == null) continue;
				if(item.equals(key.getItem())) {
					keyType = key.getKeyType();
					break;
				}
			}
			return keyType;
		}
		return null;
	}
	
	public static boolean isKeyType(String possableKeyType) {
		String keyType = null;
		for(String s : FileHandler.getSection(FileType.KEYS, "Keys").getKeys(false)) {
			if(s.toUpperCase().equals(possableKeyType.toUpperCase())) {
				keyType = s;
				break;
			}
		}
		if(keyType != null) return true;
		return false;
	}
	
	public static boolean isVKeyType(String possableVKeyType) {
		String vkeyType = null;
		for(String s : FileHandler.getSection(FileType.VIRTUAL_KEYS, "Virtual Keys").getKeys(false)) {
			if(s.toUpperCase().equals(possableVKeyType.toUpperCase())) {
				vkeyType = s;
				break;
			}
		}
		if(vkeyType != null) return true;
		return false;
	}
	
	public static String getKeyTypeToCase(String currentKeyType) {
		String keyType = null;
		for(String s : FileHandler.getSection(FileType.KEYS, "Keys").getKeys(false)) {
			if(s.toUpperCase().equals(currentKeyType.toUpperCase())) {
				keyType = s;
				break;
			}
		}
		return keyType;
	}

	public static String getVKeyTypeToCase(String currentVKeyType) {
		String vkeyType = null;
		for(String s : FileHandler.getSection(FileType.VIRTUAL_KEYS, "Virtual Keys").getKeys(false)) {
			if(s.toUpperCase().equals(currentVKeyType.toUpperCase())) {
				vkeyType = s;
				break;
			}
		}
		return vkeyType;
	}
	
}
