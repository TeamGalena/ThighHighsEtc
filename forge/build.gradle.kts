plugins {
    id("com.possible-triangle.forge")
}

forge {
    enableMixins()

    dependOn(project(":common"))
}

dependencies {
    modImplementation(packs.forge.modrinth.etcetera)
    modInclude(libs.registrate.forge)

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.forge)
        modRuntimeOnly(packs.forge.modrinth.not.enough.animations)
    }
}