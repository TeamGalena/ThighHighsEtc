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

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.fabric)
        modRuntimeOnly(pack.fabric.modrinth.not.enough.animations)
    }
}
