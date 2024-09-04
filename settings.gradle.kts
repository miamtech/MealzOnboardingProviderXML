pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        /**
         * TODO (Step 1): Add the mealz dependency
         * B. Add resolution config
         * https://miamtech.github.io/mealz-documentation/docs/android/overview/installation
         */
        maven {
            url = uri("https://github.com/miamtech/releaseMealz/raw/main")
        }
    }
}

rootProject.name = "MealzOnboardingProviderXML"
include(":app")
includeBuild("../../mealzMarmitonAndroid") {
    dependencySubstitution {
        substitute(module("ai.mealz.marmiton:marmiton")).using(project(":marmiton"))
    }
}