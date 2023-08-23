val mc_version: String by extra
val registrate_fabric_version: String by extra
val jei_version: String by extra
val etc_fabric_version: String by extra

fabric {
    dataGen()

    dependOn(project(":common"))
    includesMod("com.tterrag.registrate_fabric:Registrate:${registrate_fabric_version}")
}

dependencies {
    modImplementation("maven.modrinth:etcetera:${etc_fabric_version}")

    if(!env.isCI) {
        modRuntimeOnly("mezz.jei:jei-${mc_version}-fabric:${jei_version}")
    }
}

// This should not be necessary and results in a "duplicate content roots" warning by IDEA,
// but without it, fabric does not load the common resources even though it should
sourceSets.main {
    resources.srcDir(project(":common").file("src/main/resources"))
    resources.srcDir(project(":common").file("src/generated/resources"))
}

uploadToCurseforge()
uploadToModrinth()