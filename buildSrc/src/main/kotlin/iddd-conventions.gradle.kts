plugins {
    java
}

dependencies {
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.5.8")
    testImplementation(group = "junit", name = "junit", version = "4.8.2")

    dependencies {
        constraints {
            implementation(group = "javax.transaction", name = "jta") {
                version {
                    require("[1.1,2.0[")
                    prefer("1.1")
                }
                because(
                    "Older versions have licensing issues are were removed from Maven Central." +
                            "See https://central.sonatype.org/faq/cannot-download-javax-transaction/."
                )
            }
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}