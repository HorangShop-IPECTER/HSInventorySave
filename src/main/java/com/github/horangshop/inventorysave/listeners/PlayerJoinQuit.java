package com.github.horangshop.inventorysave.listeners;

import com.github.horangshop.inventorysave.HSInventorySave;
import com.github.horangshop.inventorysave.util.PDCUtil;
import com.github.horangshop.lib.plugin.HSPlugin;
import com.github.horangshop.lib.plugin.listener.HSListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuit extends HSListener {

    private final HSInventorySave plugin = HSInventorySave.getInstance();

    public PlayerJoinQuit(HSPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (plugin.getInventorySaveConfig().isAutoProtect()) return;
        Player player = e.getPlayer();
        plugin.getInventorySaveMap().put(player.getUniqueId(), PDCUtil.get(player));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (plugin.getInventorySaveConfig().isAutoProtect()) return;
        Player player = e.getPlayer();
        PDCUtil.set(player, plugin.getInventorySaveMap().get(player.getUniqueId()));
    }
}
