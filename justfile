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
    docker run --rm -it -p 8080:8080 \
        -v ./:/data/project/ \
        -v ./tmp/qres:/data/results/ \
        jetbrains/qodana-jvm-community:latest --show-report

javadoc:
    {{ CMD }} compile javadoc:javadoc
    open ./target/reports/apidocs/index.html

apply:
    {{ CMD }} spotless:apply

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
    {{ CMD }} -V package license:aggregate-download-licenses --file pom.xml

install:
    {{ CMD }} install

clean:
    {{ CMD }} clean

extract:
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-javadoc.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-javadoc
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-sources.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-sources
