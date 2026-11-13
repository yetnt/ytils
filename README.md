# io.github.yetnt.utils (ytils)

My own custom utilities that I use a lot.

You can find the Javadoc [here](https://yetnt.github.io/ytils/)

This isn't supposed to be like production grade or anything its just
what i want man,

but the packages look like this:

- `io.github.yetnt.utils` (Even though all modules are separate, they all share this common base
  e package)
  - `tuple`
    - `Pair` - Immutable tuple of two related values of different types
    - `SamePair` - Immutable tuple of two related values of the same type
    - `MutablePair` - Mutable tuple of two related values of different types
    - `Triple` - Immutable tuple of three related values of the same type
  - `builders`
    - `AnsiColour` - Applying console colouring in a single method
    - `InlineHTML` - HTML Builder via method chaining
    - `MarkDownLiteral` - Markdown Builder via method chaining
    - `SimpleJSON` - JSON.
  - `collection`
    - `buckets`
      - `Bucket` - Holds multiple `Class<?>` objects
      - `Buckets` - Filters a mixed list of Objects by their `Bucket` or `Class<?>` into separated lists.
    - `HashMultiMap` - One key, Multiple values (HashMap to an ArrayList, with some extra method)
    - `SetDeque` - A deque with uniqueness. Not tested lol
  - `functional` (The interface names are self-descriptive.)
    - `consumer`
      - `TriConsumer`, `TrinaryConsumer`, `QuadConsumer`, `QuinticConsumer`
      - `ThrowableConsumer`, `ThrowableBiConsumer`, `ThrowableTriConsumer`, `ThrowableQuadConsumer`, `ThrowableQuinticConsumer`
    - `function`
        - `TriFunction`, `QuadFunction`, `QuinticFunction`
        - `ThrowableFunction`, `ThrowableBiFunction`, `ThrowableTriFunction`, `ThrowableQuadFunction`, `ThrowableQuinticFunction`
    - `generic`
        - `ThrowableRunnable`, `ThrowableSupplier` 
  - `io`
    - `FilesUtility` - Files utility, not finished writing this one so id suggest not using.
    - `JarPath` - Wraps a string path into a record, with a single `read` method to read from resources stream
  - `qol`
    - `Colours` - Contains random repetitive colour stuff i do
  - `cli` (New CLI helper stuff im making, Not up to speed yet and some of these aren't implemented.)
    - `DeclarativeCli` - CLI helper where you declare valid argument "paths"
    - `FunctionalCLI` - CLI helper where you consume typed arguments
    - `dcli` - Declarative cli stuff
    - `fcli` - Functional cli stuff
    - `types` - Common types between the 2
  - `wtf` (Dont use anything here.)
    - `ThrowableCentiFunction` - A Function which takes 100 arguments, returns a result and might throw.


## Adding as a dependency

### Maven pom.xml

```xml
<dependency>
    <groupId>io.github.yetnt</groupId>
    <artifactId>ytils-all</artifactId>
    <version>VERSION</version>
</dependency>
```

You can also install a specific module other than everything (the top
level list above are the module names)

e.g.


```xml
<dependency>
    <groupId>io.github.yetnt</groupId>
    <artifactId>functional</artifactId>
    <version>VERSION</version>
</dependency>
```

(It's published on Maven Central so the other imports should work)