package galena.thigh_highs_etc.fabric.datagen;

import galena.thigh_highs_etc.THECommon;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import static galena.thigh_highs_etc.fabric.FabricEntrypoint.REGISTRATE;

public class FabricDataGenerators implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        THECommon.init();
        addDefaultTranslations();

        var fileHelper = ExistingFileHelper.withResourcesFromArg();
        REGISTRATE.setupDatagen(generator.createPack(), fileHelper);
    }

    private void addDefaultTranslations() {
    }

}
