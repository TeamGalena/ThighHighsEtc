val mc_version: String by extra
val registrate_fabric_version: String by extra
val etc_fabric_version: String by extra

plugins {
    id("com.possible-triangle.vanilla")
}

dependencies {
    modCompileOnly("com.tterrag.registrate_fabric:Registrate:${registrate_fabric_version}")
    modCompileOnly("maven.modrinth:etcetera:${etc_fabric_version}")
}