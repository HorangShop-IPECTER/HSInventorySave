package com.github.horangshop.inventorysave.commands;

import com.github.horangshop.inventorysave.HSInventorySave;
import com.github.horangshop.lib.plugin.HSPlugin;
import com.github.horangshop.lib.plugin.command.CommandData;
import com.github.horangshop.lib.plugin.command.CommandType;
import com.github.horangshop.lib.plugin.command.HSCommand;
import com.github.horangshop.lib.plugin.config.CommandConfiguration;
import com.github.horangshop.lib.plugin.config.MessageConfiguration;

import java.util.List;

public class MainCommand extends HSCommand {

    private final HSInventorySave plugin = HSInventorySave.getInstance();
    private final CommandConfiguration command = plugin.getConfigurations().getCommand();
    private final MessageConfiguration message = plugin.getConfigurations().getMessage();
    ;

    public MainCommand(HSPlugin plugin) {
        super(plugin, "인벤세이브", CommandType.MAIN);
    }

    @Override
    public boolean command(CommandData data) {
        return false;
    }

    @Override
    public void reload(CommandData command) {
        plugin.getInventorySaveConfig().reload();
    }

    @Override
    public void wrongUsage(CommandData command) {
    }

    @Override
    public List<String> tabComplete(CommandData data) {
        return List.of();
    }
}
