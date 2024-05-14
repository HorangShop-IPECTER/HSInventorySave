package com.github.horangshop.inventorysave.listeners;

import com.github.horangshop.inventorysave.HSInventorySave;
import com.github.horangshop.inventorysave.config.InventorySaveConfig;
import com.github.horangshop.lib.plugin.listener.HSListener;
import com.github.horangshop.lib.util.support.ItemUtil;
import com.google.common.base.Preconditions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerDeath extends HSListener {

    private final HSInventorySave plugin = HSInventorySave.getInstance();
    private final InventorySaveConfig config = plugin.getInventorySaveConfig();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        String item = plugin.getInventorySaveConfig().getItem();
        if (plugin.getInventorySaveConfig().isAutoProtect()) {
            ItemStack itemStack = ItemUtil.fromId(item);
            if (itemStack == null) return;
            if(first(itemStack, player.getInventory().getContents()) != -1) {
                removeItemAnySlot(player, itemStack);
                e.setKeepInventory(config.isKeepInventory());
                e.setKeepLevel(config.isKeepLevel());
                e.getDrops().clear();
            }
        } else {
            if (plugin.getInventorySaveMap().getOrDefault(player.getUniqueId(), false)) {
                plugin.getInventorySaveMap().remove(player.getUniqueId());
                e.setKeepInventory(config.isKeepInventory());
                e.setKeepLevel(config.isKeepLevel());
                e.getDrops().clear();
            }
        }
    }

    private int first(ItemStack item, ItemStack[] inventory) {
        if (item == null) return -1;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) continue;
            if (ItemUtil.isSimilar(item, inventory[i])) return i;
        }
        return -1;
    }

    private void removeItemAnySlot(Player player, ItemStack item) {
        Inventory inventory = player.getInventory();
        Preconditions.checkArgument(item != null, "ItemStack cannot be null");
        int toDelete = item.getAmount();
        while (true) {
            ItemStack[] toSearch = inventory.getContents();
            int first = this.first(item, toSearch);
            if (first == -1) {
                item.setAmount(toDelete);
                break;
            } else {
                ItemStack itemStack = inventory.getItem(first);
                int amount = itemStack.getAmount();
                if (amount <= toDelete) {
                    toDelete -= amount;
                    inventory.clear(first);
                } else {
                    itemStack.setAmount(amount - toDelete);
                    inventory.setItem(first, itemStack);
                    toDelete = 0;
                }
            }
            if (toDelete <= 0) break;
        }
    }
}
