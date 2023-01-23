# Preparation
## Previous
 - GitHub: @`nativelydigital` (matt@nativelydigital.com)
 - OS: Ubuntu 22.10 LTS (installed via Hyper-V quick-create image)
 - Have previously:
    - Installed Git (2.34.1) via apt
        - Set GitHub config (above), and VI(M) editor.
        - Created new SSH keys (passphrase with "!")
    - Installed VS Code via download; installed C# & GitLens extensions
    - Installed .NET SDK 6.0 via apt
    - Installed Git status Bash prompt and my other bash customisations

## System
 - Installed **Java (v17)** via apt:
   `$ sudo apt install` openjdk-17-jre-headless  # version 17.0.5+8-2ubuntu1~22.04
   `$ java --version`   # openjdk 17.0.5 2022-10-18 | OpenJDK Runtime Environment (build 17.0.5+8-Ubuntu-2ubuntu122.04) | OpenJDK 64-Bit Server VM (build 17.0.5+8-Ubuntu-2ubuntu122.04, mixed mode, sharing)
 - Installed **Eclipse (2022-12)** via Snap store
   `$ sudo snap install --classic eclipse`
   Launched successfully with `$ eclipse`
 - Installed Maven via apt:
   `$ sudo apt install maven`

## Repo
 - Created **'canva' repo** on GitHub; cloned locally at `~/projects/canva`
    (Used Java gitignore)
 - Created **branch `round1`**

## Project
 - Created a new Maven project to work with
    - Used `maven-archetype-quickstart` (`org.apache.maven.archetypes`) for a simple JAR CLI app
    - Group  `com.nativelydigital.canva`**, artifact `round1`
    - Package `com.nativelydigital.canva.round1`

##

# Session
## Quick walkthrough
 **Environment**
  - Ubuntu 22.10 LTS in VM
  - Git 2.34 (with gitk & git-gui)
  - **Eclipse 2022-12**, **Java 17** (OpenJDK)
 **Git**
  - Created **`canva` repo** and hosted privately at https://github.com/nativelydigital/canva/tree/round1
  - Created **`round1` branch**.
 **Project**
  - **`round1` project**
   (Maven quickstart archetype - no dependencies)
  - See `pom.xml` - added **JUnit 5 & Hamcrest 2** test dependencies

# Task

Modelling user access to resources
Designs that users create, and who can access them



# Remember
**Clear, working, testable, maintainable, performant**
 - Tests
 - Performance
 - Docs where appropriate

# Reference
## J17 features
 - `record ClassName(int x, int y);` & `x()`
 - `switch(...) { case A, B -> "foo"; }`
 - `"""TextBlock"""`
 - `obj instanceof Class x`

## JUnit 5 assertions (no Hamcrest)
 - `org.junit.jupiter.api.Assertions.*`
 - `assert*(expected, actual);`

## Executors
 - Executors.newCachedThreadPool(int nThreads) - spins up a new thread immediately per task (as many as needed), but caches idle for threads 1 min to avoid re-creating
 - Executors.newFixedThreadPool(int nThreads) - spins up at most N threads; queues & executes tasks in order
 - Executors.newWorkStealingPool()/(int parallelism) - unordered; threads can take any task
  
 - ExecutorService
     .run(Runnable) - no status nor return results
     .submit(Callable) - returns Future<T> and can return result as well as status
     
     .invokeAll(Callable[]) - returns Future<T>[]; queues them all AND WAITS FOR COMPLETION
 
 - ExecutorCompletionService - wrapper around ES; ideal where you need to handle task completions as they occur (e.g. further processing, or notification)

## Concurrency control
Pessimistic:
 - synchronized(Object lock) { }
 - synchronized method equivalent to synchronized(this)
 - Remember to mark mutating variables as volatile to ensure immediate & in-order propagation (rather than deferred and/or reordered)

Optimistic:
 - Atomic*
 
Collections.synchronized*()