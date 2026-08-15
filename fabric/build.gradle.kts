plugins {
    id("com.possible-triangle.fabric")
}

fabric {
    dataGen()

    dependOn(project(":common"))
}

dependencies {
    modImplementation(packs.fabric.modrinth.etcetera)
    modInclude(libs.registrate.fabric)

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.fabric)
        modRuntimeOnly(packs.fabric.modrinth.not.enough.animations)
    }
}