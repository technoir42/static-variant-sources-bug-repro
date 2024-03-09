See the custom task in [app/build.gradle.kts](app/build.gradle.kts#L37).

```shell
./gradlew :app:myTaskDebug
```

Build fails:
```
> Task :app:myTaskDebug FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Querying the mapped value of property(org.gradle.api.file.Directory, property(org.gradle.api.file.Directory, property(org.gradle.api.file.Directory, map(org.gradle.api.file.Directory flatmap(provider(task 'generateDebugBuildConfig', class com.android.build.gradle.tasks.GenerateBuildConfig)) check-type())))) before task ':app:generateDebugBuildConfig' has completed is not supported
```

Workaround:

```shell
./gradlew -Pandroid.enableBuildConfigAsBytecode=true :app:myTaskDebug
```

Build succeeds.
