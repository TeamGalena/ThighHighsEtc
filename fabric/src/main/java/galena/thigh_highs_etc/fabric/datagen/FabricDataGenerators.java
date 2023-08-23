package galena.thigh_highs_etc.fabric.datagen;

import galena.thigh_highs_etc.THECommon;
import galena.thigh_highs_etc.THEConstants;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resources.ResourceLocation;

import static galena.thigh_highs_etc.fabric.FabricEntrypoint.REGISTRATE;

public class FabricDataGenerators implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        THECommon.init();

        var fileHelper = ExistingFileHelper.withResourcesFromArg();
        REGISTRATE.setupDatagen(generator.createPack(), fileHelper);

        var advancementId = new ResourceLocation(THEConstants.MOD_ID, "equipped_thigh_highs");
        REGISTRATE.addLang("advancement", advancementId, "title", "Warm and Fuzzy");
        REGISTRATE.addLang("advancement", advancementId, "description", "Equip a pair of cosy thigh highs");
        generator.createPack().addProvider(AdvancementProvider::new);
    }

}
