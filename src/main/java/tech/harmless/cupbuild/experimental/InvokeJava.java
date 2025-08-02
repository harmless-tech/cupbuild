/*
 * Copyright (c) 2025 harmless-tech
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package tech.harmless.cupbuild.experimental;

// TODO: Invoke javac
// -Xlint -Xdoclint
// javac -d /Users/zack/dev/java/cupbuild/target/classes -classpath /Users/zack/dev/java/cupbuild/target/classes:
// --module-path
// /Users/zack/.m2/repository/org/jetbrains/annotations/26.0.2/annotations-26.0.2.jar:/Users/zack/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-toml/2.19.0/jackson-dataformat-toml-2.19.0.jar:/Users/zack/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.19.0/jackson-databind-2.19.0.jar:/Users/zack/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.19.0/jackson-annotations-2.19.0.jar:/Users/zack/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.19.0/jackson-core-2.19.0.jar: -sourcepath /Users/zack/dev/java/cupbuild/src/main/java:/Users/zack/dev/java/cupbuild/target/generated-sources/annotations: -s /Users/zack/dev/java/cupbuild/target/generated-sources/annotations -g --release 24 -encoding UTF-8 --module-version 1.0.0-SNAPSHOT -XDuseUnsharedTable=true @target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst
public final class InvokeJava {
    public static void getJavaProcess() {
        //        Runtime.getRuntime().exec()
        try {
            var javaCmd = ProcessHandle.current().info().command();
            System.out.println("Java process: " + javaCmd);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }
}
