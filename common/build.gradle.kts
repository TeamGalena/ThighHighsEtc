plugins {
    id("com.possible-triangle.common")
}

dependencies {
    modCompileOnly(libs.neoforge.stub)
    modCompileOnly(libs.registrate.neoforge)
    modCompileOnly(pack.neoforge.modrinth.etcetera)
}
