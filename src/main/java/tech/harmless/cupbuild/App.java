/*
 * Copyright (c) 2025 harmless-tech
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package tech.harmless.cupbuild;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.tinylog.Logger;
import tech.harmless.cupbuild.experimental.InvokeJava;
import tech.harmless.cupbuild.experimental.ManifestParser;

public final class App {

    /** @param none */
    public static void noNullsPls(String none) {
        System.out.println("No Null: " + none);
    }

    public static void main(String[] args) throws IOException {
        System.setProperty("cupbuild.target.dir", "./target");
        Thread.currentThread().setName("main");
        Logger.info("CupBuild started!");

        noNullsPls("Hi!");
        noNullsPls(null);

        // TODO: Lock file in target/cupbuild.lockable. print pid in file in case of stuff...

        var directory = new File("./target/cupbuild/tclasses");
        System.out.println("Dir " + directory.getCanonicalPath());
        // System.out.println(directory.mkdirs());
        Files.createDirectories(Path.of(directory.getCanonicalPath()));

        File[] files = {
            new File("./future-look/src/main/module-info.java"), new File("./future-look/src/main/hi/HelloWorld.java")
        };
        InvokeJava.getJavaTool(files);

        // TODO: Trying
        InvokeJava.getJavaProcess();
        try {
            ManifestParser.parse(new File("./future-look/CupBuild.toml"));
            throw new RuntimeException("No TIME!");
        } catch (Exception e) {
            Logger.error(e);
        }
        //

        var kup = new KupBuild();
        kup.hello();
    }
}
