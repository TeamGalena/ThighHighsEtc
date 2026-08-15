plugins {
    id("com.possible-triangle.neoforge")
}

neoforge {
    dependOn(project(":common"))
}

dependencies {
    modImplementation(pack.neoforge.modrinth.etcetera)
    modInclude(libs.registrate.neoforge)
    modInclude(libs.galena.hats.neoforge)

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.neoforge)
        modRuntimeOnly(pack.neoforge.modrinth.not.enough.animations)
        modRuntimeOnly(libs.yacl.neoforge)
    }
}
