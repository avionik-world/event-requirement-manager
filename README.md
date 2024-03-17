## Event Requirement Manager 🚦
In this project, you can register Bukkit listeners and add one or more requirements. A "requirement" is a condition that must be fulfilled for this event to be executed.

#### How to register a Listener with some requirements
There is an `EventRequirementHandler` class. You can implement this class in your code to have a more elegant way of creating requirements.

##### Register a requirement 
``` kotlin
Bukkit.getPluginManager().registerEvents(PlayerMoveListener(), javaPlugin) {
    it is PlayerEvent // Here you must return a Boolean that specifies whether you want to call the event or not.
}
```

##### Register multiple requirements at once
``` kotlin
Bukkit.getPluginManager().registerEvents(
    PlayerMoveListener(), // The listener class to register
    javaPlugin,
    FirstEventRequirementHandler(), // Here you can add all requerements
    SecondEventRequirementHandler()
)
```