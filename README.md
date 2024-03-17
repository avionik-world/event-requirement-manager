# Event Requirement Manager 🚦
In this project, you can register Bukkit listeners and add one or more requirements. A "requirement" is a condition that must be fulfilled for this event to be executed.

## Using Event Requirement Manager in your plugin

### Maven
```xml
<repositories>
  <repository>
     <id>github</id>
     <url>https://maven.pkg.github.com/avionik-world/event-requirement-manager</url>
   </repository>
</repositories>
```

```xml
<dependencies>
 <dependency>
    <groupId>world.avionik</groupId>
    <artifactId>event-requirement-manager</artifactId>
    <version>1.0.1</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

### Gradle
```groovy
repositories {
    maven { url = 'https://maven.pkg.github.com/avionik-world/event-requirement-manager' }
}

dependencies {
    compileOnly 'world.avionik:event-requirement-manager:1.0.1'
}
```

## How to register a Listener with some requirements
There is an [EventRequirementHandler](https://github.com/avionik-world/event-requirement-manager/blob/master/src/main/kotlin/world/avionik/event/requirement/manager/EventRequirementHandler.kt) class. You can implement this class in your code to have a more elegant way of creating requirements.

#### Register a requirement 
``` kotlin
Bukkit.getPluginManager().registerEvents(PlayerMoveListener(), javaPlugin) {
    it is PlayerEvent // Here you must return a Boolean that specifies whether you want to call the event or not.
}
```

#### Register multiple requirements at once
``` kotlin
Bukkit.getPluginManager().registerEvents(
    PlayerMoveListener(), // The listener class to register
    javaPlugin,
    FirstEventRequirementHandler(), // Here you can add all requerements
    SecondEventRequirementHandler()
)
```

#### Register a requirement without Kotlin extensions
``` kotlin
EventRequirement.registerEvents(
    PlayerMoveListener(), // The listener class to register
    javaPlugin,
    FirstEventRequirementHandler(), // Here you can add all requerements
    SecondEventRequirementHandler()
)
```

Whenever a listener is registered, this triggers a Bukkit event called [ListenerRegisterEvent](https://github.com/avionik-world/event-requirement-manager/blob/master/src/main/kotlin/world/avionik/event/requirement/manager/event/ListenerRegisterEvent.kt). This event contains the registered listener.
