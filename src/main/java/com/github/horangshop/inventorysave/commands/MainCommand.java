package com.github.horangshop.inventorysave.commands;

import com.github.horangshop.inventorysave.HSInventorySave;
import com.github.horangshop.lib.HSLib;
import com.github.horangshop.lib.plugin.command.CommandData;
import com.github.horangshop.lib.plugin.command.HSCommand;
import com.github.horangshop.lib.plugin.config.CommandConfiguration;
import com.github.horangshop.lib.plugin.config.MessageConfiguration;
import com.github.horangshop.lib.translation.CommonTranslation;

import java.util.List;

public class MainCommand extends HSCommand {

    private final HSInventorySave plugin = HSInventorySave.getInstance();
    private final CommandConfiguration command = plugin.getConfigurations().getCommand();
    private final MessageConfiguration message = plugin.getConfigurations().getMessage();
    private final CommonTranslation common = HSLib.getInstance().getTranslation();
    ;

    public MainCommand() {
        super("인벤세이브", true);
    }

    @Override
    public void command(CommandData data) {
    }

    @Override
    public void reload(CommandData command) {
        //Enhance CONFIG 리로드
    }

    @Override
    public void wrongUsage(CommandData command) {
    }

    @Override
    public List<String> tabComplete(CommandData data) {
        return List.of();
    }
}
