import com.possible_triangle.gradle.features.publishing.UploadExtension

val mc_version: String by extra
val registrate_forge_version: String by extra
val jei_version: String by extra
val etc_forge_version: String by extra

forge {
    enableMixins()

    dependOn(project(":common"))
    includesMod("com.tterrag.registrate:Registrate:${registrate_forge_version}")
}

dependencies {
    modImplementation("maven.modrinth:etcetera:${etc_forge_version}")

    if (!env.isCI) {
        modRuntimeOnly("mezz.jei:jei-${mc_version}-forge:${jei_version}")
    }
}

fun configureDependencies(it: UploadExtension) {
    it.dependencies {
        required("etcetera")
    }
}

uploadToCurseforge(::configureDependencies)
uploadToModrinth(::configureDependencies)