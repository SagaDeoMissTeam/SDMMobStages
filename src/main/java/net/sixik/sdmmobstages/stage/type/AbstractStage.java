package net.sixik.sdmmobstages.stage.type;

import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.world.entity.player.Player;

public abstract class AbstractStage {

    public String stage;

    public AbstractStage(String stage){
        this.stage = stage;
    }


    public String getStage() {
        return stage;
    }

    public boolean hasStage(Player player){
        return GameStageHelper.hasStage(player, stage);
    }

    public abstract void execute(Object object1, Object object2, Object object3);

    public abstract boolean add(AbstractStage someStage);

    public abstract String getID();
}
