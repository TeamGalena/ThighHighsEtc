package galena.thigh_highs_etc.platform;

import galena.thigh_highs_etc.platform.services.IDataGenHelper;
import galena.thigh_highs_etc.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IDataGenHelper DATAGEN = load(IDataGenHelper.class);

    private static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }

}
