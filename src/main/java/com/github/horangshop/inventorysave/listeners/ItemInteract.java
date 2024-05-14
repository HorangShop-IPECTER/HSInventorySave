package com.github.horangshop.inventorysave.listeners;

import com.github.horangshop.inventorysave.HSInventorySave;
import com.github.horangshop.lib.plugin.config.MessageConfiguration;
import com.github.horangshop.lib.plugin.listener.HSListener;
import com.github.horangshop.lib.util.support.ItemUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemInteract extends HSListener {

    private final HSInventorySave plugin = HSInventorySave.getInstance();
    private final MessageConfiguration message = plugin.getConfigurations().getMessage();

    @EventHandler
    public void onItemInteract(PlayerInteractEvent e) {
        if (!List.of(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK).contains(e.getAction())) return;
        Player player = e.getPlayer();
        ItemStack itemStack = e.getItem();
        if (itemStack != null) {
            if (ItemUtil.isSimilar(itemStack, ItemUtil.fromId(plugin.getInventorySaveConfig().getItem()))) {
                if (plugin.getInventorySaveMap().getOrDefault(player.getUniqueId(), false)) {
                    sendAnnounce(player, message.getTranslation("item.alreadyUse"));
                } else {
                    plugin.getInventorySaveMap().put(player.getUniqueId(), true);
                    itemStack.setAmount(itemStack.getAmount() - 1);
                    sendAnnounce(player, message.getTranslation("item.use"));
                }
            }
        }
    }
}
