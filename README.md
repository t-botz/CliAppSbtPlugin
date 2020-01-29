# CliAppSbtPlugin

A hello word in scala 2.11 published as an SBT plugin

## What's the purpose

Sbt plugins runs in the sbt context which can be a different version than the project.

The simplified rule is that Sbt 0.13.x runs on scala 2.10 and Sbt 1.x runs on scala 2.12. (Simplified as it can be overridden but is never dine in practice and can lead to some painful experience)

If you build a plugin you have to target those specific versions.

If, like me, you want to use a library which only runs on Scala 2.11, well things get complicated.
So far my solution is to run, somehow, this library in a separate JVM. This project is the illsutration for it and is a work in progress.


## Runnning the tests

```sh
sbt publishLocal scripted
```