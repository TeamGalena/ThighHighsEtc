val mc_version: String by extra
val registrate_forge_version: String by extra
val jei_version: String by extra
val etc_forge_version: String by extra
val animations_forge_version: String by extra

plugins {
    id("com.possible-triangle.forge")
}

forge {
    enableMixins()

    dependOn(project(":common"))
}

dependencies {
    modImplementation("maven.modrinth:etcetera:${etc_forge_version}")
    modInclude("com.tterrag.registrate:Registrate:${registrate_forge_version}")

    if (!env.isCI) {
        modRuntimeOnly("mezz.jei:jei-${mc_version}-forge:${jei_version}")
        modRuntimeOnly("maven.modrinth:not-enough-animations:${animations_forge_version}")
    }
}