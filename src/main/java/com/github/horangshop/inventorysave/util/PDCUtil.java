package com.github.horangshop.inventorysave.util;

import com.github.horangshop.lib.plugin.HSPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PDCUtil {

    public static void set(Player player, boolean visible) {
        NamespacedKey key = new NamespacedKey(HSPlugin.getPlugin(), "visible");
        PersistentDataContainer container = player.getPersistentDataContainer();
        container.set(key, PersistentDataType.INTEGER, visible ? 1 : 0);
    }

    public static boolean get(Player player) {
        NamespacedKey key = new NamespacedKey(HSPlugin.getPlugin(), "visible");
        PersistentDataContainer container = player.getPersistentDataContainer();
        boolean exist = container.has(key, PersistentDataType.INTEGER);
        if (exist) {
            Integer value = container.get(key, PersistentDataType.INTEGER);
            if (value == null) return false;
            return value != 0;
        } else return false;
    }
}
