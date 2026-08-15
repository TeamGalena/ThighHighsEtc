plugins {
    id("com.possible-triangle.core")
    id("com.possible-triangle.common") apply false
    id("com.possible-triangle.neoforge") apply false
    id("com.possible-triangle.fabric") apply false
}

subprojects {
    apply(plugin = "com.possible-triangle.core")

    repositories {
        nexus {
            content {
                includeGroup("dev.galena")
                includeGroup("com.possible-triangle")
            }
        }

        maven {
            url = uri("https://maven.ithundxr.dev/snapshots")
            content {
                includeGroup("com.tterrag.registrate")
            }
        }

        maven {
            url = uri("https://maven.blamejared.com/")
            content {
                includeGroup("mezz.jei")
            }
        }

        nexus("jitpack") {
            content {
                includeGroup("com.github.llamalad7.mixinextras")
            }
        }

        nexus {
            content {
                includeGroup("dev.galena")
                includeGroup("com.possible-triangle")
                includeGroup("com.tterrag.registrate_fabric")
                includeGroup("io.github.fabricators_of_create.Porting-Lib")
            }
        }

        maven {
            url = uri("https://maven.isxander.dev/releases")
            content {
                includeGroup("dev.isxander")
                includeGroupAndSubgroups("org.quiltmc")
            }
        }
    }

    upload {
        maven.nexus()

        forEach {
            dependencies {
                required("etcetera")
            }
        }
    }
}

enableSonarQube()
enableSpotless()
