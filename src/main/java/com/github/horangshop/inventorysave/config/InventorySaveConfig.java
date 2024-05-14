package com.github.horangshop.inventorysave.config;

import com.github.horangshop.lib.plugin.config.HSConfiguration;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InventorySaveConfig extends HSConfiguration {

    private String item = "minecraft:name_tag";
    private boolean keepInventory = true;
    private boolean keepLevel = true;

    public InventorySaveConfig() {
        super("InventorySave.yml", 1);
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
        keepInventory = getBoolean("keepInventory", keepInventory, """
                인벤토리 아이템을 보호합니다""");
        keepLevel = getBoolean("keepLevel", keepLevel, """
                플레이어 경험치를 보호합니다""");
    }
}
