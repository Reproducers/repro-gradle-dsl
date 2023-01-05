# repro-gradle-dsl

1. Run `./gradlew publishToMavenLocal`
2. Uncomment `includeBuild("consumer")` in the [`settings.gradle.kts`](settings.gradle.kts)
3. Play with `repro` extension in [`consumer/build.gradle.kts`](consumer/build.gradle.kts)
