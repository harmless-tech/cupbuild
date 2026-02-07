CMD := "./mvnw -T 1C"

default:
    just -l

mvn +ARGS:
    {{ CMD }} {{ ARGS }}

version-check:
    {{ CMD }} versions:display-dependency-updates versions:display-plugin-updates versions:display-property-updates

license:
    {{ CMD }} license:aggregate-download-licenses license:aggregate-third-party-report

verify:
    {{ CMD }} verify

test:
    {{ CMD }} test

qcheck:
    mkdir -p ./tmp/qres
    mkdir -p ./tmp/qres-cache
    podman run --rm -it -p 8080:8080 \
        -v ./:/data/project/ \
        -v ./tmp/qres:/data/results/ \
        -v ./tmp/qres-cache:/data/cache/ \
        docker.io/jetbrains/qodana-jvm-community:latest \
        --show-report \
        --cache-dir /data/cache/

javadoc:
    {{ CMD }} compile javadoc:javadoc
    open ./target/reports/apidocs/index.html

fmt: apply
apply:
    {{ CMD }} spotless:apply

run: exec
exec:
    {{ CMD }} compile exec:java

compile:
    {{ CMD }} compile

package:
    {{ CMD }} package

native-package:
    {{ CMD }} -Pnative package

prod:
    {{ CMD }} -V clean verify --file pom.xml
    {{ CMD }} -V package --file pom.xml

install:
    {{ CMD }} install

clean:
    {{ CMD }} clean

extract:
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-javadoc.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-javadoc
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-sources.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-sources
