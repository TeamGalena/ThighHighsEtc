plugins {
    id("com.possible-triangle.forge")
}

forge {
    enableMixins()

    dependOn(project(":common"))
}

dependencies {
    modImplementation(pack.forge.modrinth.etcetera)
    modInclude(libs.registrate.forge)
    modInclude(libs.galena.hats.forge)

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.forge)
        modRuntimeOnly(pack.forge.modrinth.not.enough.animations)
    }
}
