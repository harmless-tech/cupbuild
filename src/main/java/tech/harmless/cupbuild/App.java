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
import org.tinylog.Logger;
import tech.harmless.cupbuild.experimental.InvokeJava;
import tech.harmless.cupbuild.experimental.ManifestParser;

public final class App {
    public static void main(String[] args) {
        System.setProperty("cupbuild.target.dir", "./target");
        Thread.currentThread().setName("main");
        Logger.info("CupBuild started!");

        // TODO: Lock file in target/cupbuild.lockable. print pid in file in case of stuff...

        // TODO: Trying
        InvokeJava.getJavaProcess();
        try {
            ManifestParser.parse(new File("./future-look/CupBuild.toml"));
            throw new RuntimeException("No TIME!");
        } catch (Exception e) {
            Logger.error(e);
        }
        //
    }
}
