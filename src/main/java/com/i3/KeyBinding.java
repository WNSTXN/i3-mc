package com.i3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

public class KeyBinding {
    static final IntStream workspaceIndices = IntStream.concat(IntStream.rangeClosed(1, 9), IntStream.of(0));

    public static final List<KeyMapping> workspaceKeyList = workspaceIndices.mapToObj(workspaceIndex -> new KeyMapping(
        String.format("key.i3.workspace%d", workspaceIndex),
        KeyConflictContext.IN_GAME,
        KeyModifier.ALT,
        InputConstants.Type.KEYSYM,
        workspaceIndex == 0 ? 48 : 48 + workspaceIndex,
        "key.category.i3.workspace"
    )).collect(Collectors.toList());
}
