package net.sixik.sdmmobstages.stage;

import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.sixik.sdmmobstages.stage.type.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StageContainer extends SimplePreparableReloadListener<Void> {

    public static StageContainer INSTANCE = new StageContainer();

    public StageContainer(){
        create();
    }

    public HashMap<String,List<AbstractStage>> STAGES = new HashMap<>();


    public <T extends AbstractStage> List<T> getStages(String stage){
        return (List<T>) STAGES.getOrDefault(stage, new ArrayList<>());
    }

    public List<MobStage> getMobStage(){
        return STAGES.getOrDefault("mobSpawn", new ArrayList<>()).stream().map(s -> (MobStage)s).toList();
    }

    public List<MobDimensionStage> getMobDimStage(){
        return STAGES.getOrDefault("mobDimensionSpawn", new ArrayList<>()).stream().map(s -> (MobDimensionStage)s).toList();
    }

    public List<MobReplaceStage> getMobReplaceStage(){
        return STAGES.getOrDefault("mobReplaceSpawn", new ArrayList<>()).stream().map(s -> (MobReplaceStage)s).toList();
    }

    public List<MobDimensionReplaceStage> getMobDimensionReplaceStage(){
        return STAGES.getOrDefault("mobDimensionReplaceSpawn", new ArrayList<>()).stream().map(s -> (MobDimensionReplaceStage)s).toList();
    }

    public void put(AbstractStage stage){
        for (AbstractStage abstractStage : STAGES.get(stage.getID())) {
            if(abstractStage.add(stage)){
                return;
            }
        }

        STAGES.get(stage.getID()).add(stage);
    }

    @Override
    protected Void prepare(ResourceManager p_10796_, ProfilerFiller p_10797_) {
        return null;
    }

    public void create(){
        STAGES.put("mobSpawn", new ArrayList<>());
        STAGES.put("mobDimensionSpawn", new ArrayList<>());
        STAGES.put("mobDimensionReplaceSpawn", new ArrayList<>());
        STAGES.put("mobReplaceSpawn", new ArrayList<>());
    }

    @Override
    protected void apply(Void p_10793_, ResourceManager p_10794_, ProfilerFiller p_10795_) {
        create();
    }
}
