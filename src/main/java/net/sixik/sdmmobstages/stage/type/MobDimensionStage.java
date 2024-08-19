package net.sixik.sdmmobstages.stage.type;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.List;

public class MobDimensionStage extends MobStage{

    public ResourceLocation dimension;

    public MobDimensionStage(String stage, List<EntityType<Entity>> entityTypeList, ResourceLocation dimension) {
        super(stage, entityTypeList);
        this.dimension = dimension;
    }

    @Override
    public boolean add(AbstractStage someStage) {
        if(someStage instanceof MobDimensionStage mobStage){
            if(mobStage.stage.equals(this.stage) && mobStage.dimension.equals(this.dimension)){
                this.entityTypeList.addAll(mobStage.entityTypeList);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getID() {
        return "mobDimensionSpawn";
    }
}
