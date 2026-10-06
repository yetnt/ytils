# com.yetnt.utils (ytils)

My own custom utilities that I use a lot.

You can find the Javadoc [here](https://yetnt.github.io/ytils/)

This isn't supposed to be like production grade or anything its just
what i want man,

but the packages look like this:

- `com.yetnt.utils`
  - `tuple`
    - `Pair` - Immutable tuple of two related values of different types
    - `SamePair` - Immutable tuple of two related values of the same type
    - `MutablePair` - Mutable tuple of two related values of different types
    - `Triple` - Immutable tuple of three related values of the same type
  - `builders`
    - `AnsiColour` - Applying console colouring in a single method
    - `InlineHTML` - HTML Builder via method chaining
    - `MarkDownLiteral` - MarkDown Builder via method chaining
  - `collection`
    - `buckets`
      - `Bucket` - Holds multiple `Class<?>` objects
      - `Buckets` - Filters a mixed list of Objects by their `Bucket` or `Class<?>` into separated lists.
    - `HashMultiMap` - One key, Multiple values (HashMap to an ArrayList, with some extra method)
    - `SetDeque` - A deque with uniqueness. Not tested lol
  - `functional` (The interface names are self-descriptive.)
    - `consumer`
      - `TriConsumer`, `TrinaryConsumer`, `QuadConsumer`
      - `ThrowableConsumer`, `ThrowableBiConsumer`, ... `ThrowableQuadConsumer`
    - `function`
        - `TriFunction`, `QuadFunction`
        - `ThrowableFunction`, `ThrowableBiFunction`, ... `ThrowableQuadFunction`
  - `io`
    - `FilesUtility` - Files utility, not finished writing this one so id suggest not using.
    - `JarPath` - Wraps a string path into a record, with a single `read` method to read from resources stream
  - `qol`
    - `Colours` - Contains random repetitive colour stuff i do
  - `wtf` (Dont use anything here.)
    - `ThrowableCentiFunction` - A Function which takes 100 arguments, returns a result and might throw.