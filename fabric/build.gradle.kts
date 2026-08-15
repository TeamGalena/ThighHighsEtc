plugins {
    id("com.possible-triangle.fabric")
}

fabric {
    dataGen()

    dependOn(project(":common"))
}

dependencies {
    modImplementation(pack.fabric.modrinth.etcetera)
    modInclude(libs.registrate.fabric)
    modInclude(libs.galena.hats.fabric)

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.fabric)
    }
}
