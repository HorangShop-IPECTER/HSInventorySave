package com.github.horangshop.inventorysave;

import com.github.horangshop.inventorysave.commands.MainCommand;
import com.github.horangshop.inventorysave.config.InventorySaveConfig;
import com.github.horangshop.inventorysave.listeners.ItemInteract;
import com.github.horangshop.inventorysave.listeners.PlayerDeath;
import com.github.horangshop.inventorysave.listeners.PlayerJoinQuit;
import com.github.horangshop.lib.plugin.HSPlugin;
import com.github.horangshop.lib.util.common.ComponentUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HSInventorySave extends HSPlugin {

    @Getter
    private static HSInventorySave instance;
    @Getter
    private InventorySaveConfig inventorySaveConfig;
    @Getter
    private final Map<UUID, Boolean> inventorySaveMap = new HashMap<>();

    public HSInventorySave() {
        super(ComponentUtil.miniMessage("<gradient:#ff9633:#ffd633>HSInventorySave | </gradient>"));
    }

    @Override
    public void load() {
        instance = this;
    }

    @Override
    public void enable() {
        inventorySaveConfig = new InventorySaveConfig();
        registerCommand(new MainCommand());
        registerEvent(new PlayerJoinQuit());
        registerEvent(new ItemInteract());
        registerEvent(new PlayerDeath());
    }

    @Override
    public void disable() {
    }
}
