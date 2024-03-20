# Event Requirement Manager 🚦
In this project, you can register Bukkit listeners and add one or more requirements. A "requirement" is a condition that must be fulfilled for this event to be executed.

## Using Event Requirement Manager in your plugin

### Maven
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
dependencies {
    compileOnly 'world.avionik:event-requirement-manager:1.0.1'
}
```

## How to register a Listener with some requirements

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

## How to use the EventRequirementHandler
There is an [EventRequirementHandler](https://github.com/avionik-world/event-requirement-manager/blob/master/src/main/kotlin/world/avionik/event/requirement/manager/EventRequirementHandler.kt) class. You can implement this class in your code to have a more elegant way of creating requirements.

#### Here is an example of how to use the EventRequirementHandler
```kotlin
class FirstEventRequirementHandler : EventRequirementHandler {

    /**
     * This method is executed when an event with this requirement is called.
     * @param event that is about to be executed
     * @return whether this event should be executed or not
     */
    override fun execute(event: Event): Boolean {
        if (event !is PlayerEvent)
            return false
        return event.player.gameMode == GameMode.SPECTATOR
    }

}
```
