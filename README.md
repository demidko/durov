# Durov

Telegram-based database. You need only bot token and channel id (where bot has all admin rights) to
getting started.

## Build with Java

Execute `./gradlew clean build`. Your jar will be located at `./build/libs` with `-all.jar` postfix.
Now you can run:

```shell
TOKEN=... CHANNEL=... java -jar durov-all.jar
```

## Or, build with Docker

Execute `docker build . -t durov`. Your image will be located at `docker images -a`. Now you can
run:

```shell
docker  --env TOKEN=...  --env CHANNEL=... run -v `pwd`:`pwd` -w `pwd` -it --rm durov
```

## Deploy

You can edit deploy configuration at file [deploy.template.yaml](.do/deploy.template.yaml).

[![Deploy to DigitalOcean](https://www.deploytodo.com/do-btn-blue-ghost.svg)](https://cloud.digitalocean.com/apps/new?repo=https://github.com/YOUR/REPO/tree/main)
