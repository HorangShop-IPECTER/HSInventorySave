package com.github.horangshop.inventorysave.config;

import com.github.horangshop.lib.plugin.HSPlugin;
import com.github.horangshop.lib.plugin.config.HSConfiguration;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InventorySaveConfig extends HSConfiguration {

    private String item = "minecraft:name_tag";
    private boolean autoProtect = true;
    private boolean keepInventory = true;
    private boolean keepLevel = true;

    public InventorySaveConfig(HSPlugin plugin) {
        super(plugin, "InventorySave.yml", 1);
        setup(this);
    }

    private void init() {
        item = getString("item", item, """
                인벤토리 세이브권으로 쓸 아이템을 설정합니다
                바닐라 아이템: minecraft:item_type
                ItemsAdder 아이템: itemsadder:category:item
                Oraxen 아이템: oraxen:item
                커스텀모델데이터 아이템: custom:item_type:custommodeldata
                예) custom:bread:1 = 1번 커스텀 모델 데이터를 가진 빵 아이템""");
        autoProtect = getBoolean("autoProtect", autoProtect, """
                true: 아이템을 우클릭으로 소모하여 인벤 세이브를 등록합니다
                false: 인벤토리에 가지고 있으면 자동으로 소모하여 인벤토리를 보호합니다""");
        keepInventory = getBoolean("keepInventory", keepInventory, """
                인벤토리 아이템을 보호합니다""");
        keepLevel = getBoolean("keepLevel", keepLevel, """
                플레이어 경험치를 보호합니다""");
    }
}
