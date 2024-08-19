package net.sixik.sdmmobstages.stage.type;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.List;

public class MobDimensionReplaceStage extends MobReplaceStage{

    public ResourceLocation dimension;

    public MobDimensionReplaceStage(String stage, List<EntityType<Entity>> entityTypeList, EntityType<Entity> replaceEntity, ResourceLocation dimension) {
        super(stage, entityTypeList, replaceEntity);
        this.dimension = dimension;
    }

    @Override
    public boolean add(AbstractStage someStage) {
        if(someStage instanceof MobDimensionReplaceStage mobStage){
            if(mobStage.stage.equals(this.stage) && mobStage.replaceEntity.equals(this.replaceEntity) && mobStage.dimension.equals(this.dimension)){
                this.entityTypeList.addAll(mobStage.entityTypeList);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getID() {
        return "mobDimensionReplaceSpawn";
    }
}
