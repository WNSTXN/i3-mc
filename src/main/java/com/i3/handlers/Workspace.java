package com.i3.handlers;

import java.util.HashMap;
import java.util.Map;

import com.i3.KeyBinding;
import com.i3.types.Vec4;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;

public class Workspace {
    static Map<Integer, Vec4> workspaceMap = new HashMap<Integer, Vec4>();
    static Integer currentWorkspaceIndex = 1;

    public static void onKeyInput() {
        for (int i = 0; i < KeyBinding.workspaceKeyList.size(); i++) {
            final KeyMapping keyMap = KeyBinding.workspaceKeyList.get(i);
            if (!keyMap.consumeClick()) return;

            final Minecraft minecraft = Minecraft.getInstance();
            final LocalPlayer localPlayer = minecraft.player;
            if (localPlayer == null) return;

            
            final double rotationVector = localPlayer.getXRot();
            final Vec3 positionVector = localPlayer.position();
            workspaceMap.put(currentWorkspaceIndex, new Vec4(
                positionVector.x,
                positionVector.y,
                positionVector.z,
                rotationVector
            ));
            
            if (workspaceMap.containsKey(i)) {
                final Vec4 playerState = workspaceMap.get(i);

                localPlayer.sendSystemMessage(Component.literal(String.format("/tp %f %f %f %f", 
                    playerState.getX(),
                    playerState.getY(),
                    playerState.getZ(),
                    playerState.getRotation()
                )));
            }

            Workspace.currentWorkspaceIndex = i;
        }
    }
}
