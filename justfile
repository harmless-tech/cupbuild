default:
    just -l

mvn +ARGS:
    ./mvnw {{ ARGS }}

version-check:
    ./mvnw versions:display-dependency-updates versions:display-plugin-updates versions:display-property-updates

license:
    ./mvnw license:aggregate-download-licenses license:aggregate-third-party-report

verify:
    ./mvnw verify

qcheck:
    docker run --rm -it -p 8080:8080 \
        -v ./:/data/project/ \
        -v ./tmp/qres:/data/results/ \
        jetbrains/qodana-jvm-community:latest --show-report

javadoc:
    ./mvnw compile javadoc:javadoc
    open ./target/reports/apidocs/index.html

apply:
    ./mvnw spotless:apply

exec:
    ./mvnw compile exec:java

compile:
    ./mvnw compile

package:
    ./mvnw package

native-package:
    ./mvnw -Pnative package

prod:
    ./mvnw -V clean verify --file pom.xml
    ./mvnw -V package license:aggregate-download-licenses --file pom.xml

install:
    ./mvnw install

clean:
    ./mvnw clean

extract:
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT
    #cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-shaded.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-shaded
    #cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-jarjar.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-jarjar
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-javadoc.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-javadoc
    cd ./target && jar xf cupbuild-1.0.0-SNAPSHOT-sources.jar -C ./xf-cupbuild-1.0.0-SNAPSHOT-sources
