package net.sixik.sdmmobstages.addons.crafttweaker;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.sixik.sdmmobstages.addons.crafttweaker.action.MobDimensionReplaceStageAction;
import net.sixik.sdmmobstages.addons.crafttweaker.action.MobDimensionStageAction;
import net.sixik.sdmmobstages.addons.crafttweaker.action.MobReplaceStageAction;
import net.sixik.sdmmobstages.addons.crafttweaker.action.MobStageAction;
import net.sixik.sdmmobstages.stage.type.MobReplaceStage;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.mobstages.MobStages")
public class CTMethods {

    @ZenCodeType.Method
    public static void addStage(String stage, EntityType<Entity> entityType) {
        CraftTweakerAPI.apply(new MobStageAction(stage, new EntityType[]{entityType}));
    }

    @ZenCodeType.Method
    public static void addStage(String stage, EntityType<Entity>[] entityType) {
        CraftTweakerAPI.apply(new MobStageAction(stage, entityType));
    }

    @ZenCodeType.Method
    public static void addReplacement(String stage, EntityType<Entity> entityType, EntityType<Entity> replaceEntity) {
        CraftTweakerAPI.apply(new MobReplaceStageAction(stage, new EntityType[]{entityType}, replaceEntity));
    }

    @ZenCodeType.Method
    public static void addReplacement(String stage, EntityType<Entity>[] entityType, EntityType<Entity> replaceEntity) {
        CraftTweakerAPI.apply(new MobReplaceStageAction(stage, entityType, replaceEntity));
    }

    @ZenCodeType.Method
    public static void addDimension(String stage, EntityType<Entity> entityType, ResourceLocation dimension) {
        CraftTweakerAPI.apply(new MobDimensionStageAction(stage, new EntityType[]{entityType}, dimension));
    }

    @ZenCodeType.Method
    public static void addDimension(String stage, EntityType<Entity>[] entityType, ResourceLocation dimension) {
        CraftTweakerAPI.apply(new MobDimensionStageAction(stage, entityType, dimension));
    }

    @ZenCodeType.Method
    public static void addDimensionReplace(String stage, EntityType<Entity> entityType, EntityType<Entity> replaceEntity, ResourceLocation dimension) {
        CraftTweakerAPI.apply(new MobDimensionReplaceStageAction(stage, new EntityType[]{entityType}, replaceEntity, dimension));
    }

    @ZenCodeType.Method
    public static void addDimensionReplace(String stage, EntityType<Entity>[] entityType, EntityType<Entity> replaceEntity, ResourceLocation dimension) {
        CraftTweakerAPI.apply(new MobDimensionReplaceStageAction(stage, entityType, replaceEntity, dimension));
    }
}
