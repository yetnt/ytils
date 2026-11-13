# 1.0.0

- add all the utils from jaiva and j3engine

# 1.0.1

- add small method in `HashMultiMap` (findKeysWhere)

# 1.1.0

- Add dependency on IntelliJ Annotations
- Add following functional interfaces
  - ThrowableBiConsumer, ThrowableConsumer, ThrowableQuadConsumer, ThrowableTriConsumer,
  ThrowableBiFunction, ThrowableFunction, ThrowableQuadFunction
- Add README and CHANGELOG

# 1.2.0

- Add `ThrowableRunnable`, `ThrowableSupplier`

# 1.3.0

- Add `SimpleJSON`

# 1.3.1

- Fix SimpleJSON

# 2.0.0

## Breaking

- Change all packages to `io.github.yetnt.utils` (To match the maven coordinates)

> Old:
> ```java
> import com.yetnt.utils.*;
> ```
> 
> New:
> ```java
> import io.github.yetnt.utils.*;
> ```

- Change monolithic project to instead be multiple sub-modules
  (each sub package in `utils` is itself now a sub module, and importing the
  parent alone wont work, instead import the `ytils-all` module.)

Old:
```xml
<dependency>
    <groupId>io.github.yetnt</groupId>
    <artifactId>ytils</artifactId> <!-- Doing this now won't work -->
    <version>2.0.0</version>
</dependency>
```

New:
```xml
<dependency>
    <groupId>io.github.yetnt</groupId>
    <artifactId>ytils-all</artifactId>
    <version>VERSION</version>
</dependency>
```

> [!NOTE]
> Some modules use resources from other modules so in many cases you may
not even require using ytils-all, An example would be importing the
`tuple` module which has a dependency on `functional`

## Others

- A lot of methods in `tuple` were changed with better names and types cuz why not
- Started adding `cli` but nothing in there works at the moment but theres so many improvements
  that i need v2 now lol for J3Engine and Jaiva

[//]: # (- Added `Quintic` and `Sextic` functional interfaces [Uncomment when added.] )
- Fix `SimpleJSON#copy`
- Add `ToJSONList`
- other shiz