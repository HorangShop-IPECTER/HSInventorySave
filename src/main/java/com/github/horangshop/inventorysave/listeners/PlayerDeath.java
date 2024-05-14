package com.github.horangshop.inventorysave.listeners;

import com.github.horangshop.inventorysave.HSInventorySave;
import com.github.horangshop.inventorysave.config.InventorySaveConfig;
import com.github.horangshop.lib.plugin.listener.HSListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath extends HSListener {

    private final HSInventorySave plugin = HSInventorySave.getInstance();
    private final InventorySaveConfig config = plugin.getInventorySaveConfig();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        if (plugin.getInventorySaveMap().getOrDefault(player.getUniqueId(), false)) {
            plugin.getInventorySaveMap().remove(player.getUniqueId());
            e.setKeepInventory(config.isKeepInventory());
            e.setKeepLevel(config.isKeepLevel());
            e.getDrops().clear();
        }
    }

}
