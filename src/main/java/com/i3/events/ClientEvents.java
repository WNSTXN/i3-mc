package com.i3.events;

import com.i3.KeyBinding;
import com.i3.Main;
import com.i3.handlers.Workspace;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


public class ClientEvents {
    @EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput() {
            Workspace.onKeyInput();
        }
    }

    @EventBusSubscriber(modid = Main.MODID, bus = Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister() {
            for (final KeyMapping keyMap : KeyBinding.workspaceKeyList) {
                ClientRegistry.registerKeyBinding(keyMap);
            }
        }
    }
}
