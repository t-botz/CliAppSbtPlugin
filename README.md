# CliAppSbtPlugin

A hello word in scala 2.11 published as an SBT plugin

## What's the purpose

Sbt plugins runs in the sbt context which can be a different scala version than the project that is being built.

The simplified rule is that Sbt 0.13.x runs on scala 2.10 and Sbt 1.x runs on scala 2.12. (Simplified as it can be overridden but is never done in practice and can lead to some painful experiences)

If you build a plugin you have to target those specific versions.

If, like me, you want to use a library which only runs on Scala 2.11, well things get complicated.
So far my solution is to run, somehow, this library in a separate JVM. This project is the illustration for it and is a work in progress.

## How it works

The `plugin` folder is the SBT plugin itself. It compile to the usual scala versions for SBT (2.10 and 2.12).
At build time it will download the 2.11 scala app you need and will spin up a separate JVM to run it.

The `cli` folder contains the hello world app built with scala 2.11, that the plugin will run for demo purpose.


## Runnning the tests

```sh
sbt +publishLocal +scripted
```