# Reference
 - GitHub: @`nativelydigital` (matt@nativelydigital.com)
 - OS: Ubuntu 22.10 LTS (installed via Hyper-V quick-create image)
 - Have previously:
    - Installed Git (2.34.1) via apt
        - Set GitHub config (above), and VI(M) editor.
        - Created new SSH keys (passphrase with "!")
    - Installed VS Code via download; installed C# & GitLens extensions
    - Installed .NET SDK 6.0 via apt
    - Installed Git status Bash prompt and my other bash customisations

# Preparation
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
 - Created a new Maven project to work with
    - Used `maven-archetype-quickstart` (`org.apache.maven.archetypes`) for a simple JAR CLI app
    - Group  `com.nativelydigital.canva`**, artifact `round1`
    - Package `com.nativelydigital.canva.round1`

# Session
