/*
 * Copyright (c) 2025 harmless-tech
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package tech.harmless.cupbuild.experimental;

import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public final class ManifestParser {
    public static void parse(final File mFile) throws Exception {
        // TODO: File checking!

        var reader = new BufferedReader(new FileReader(mFile, StandardCharsets.UTF_8));

        var toml = new TomlMapper();
        var root = toml.readTree(reader);

        System.out.println(root.path("version").asText());
        System.out.println(root.get("project").get("javaRelease").asInt());
        System.out.println(root.get("deps"));

        //        var toml = new TomlMapper();
        //        var mainClass = toml.readValue("app.mainClass", String.class);
        //        System.out.println(mainClass);

        //        TomlFactory fac = new TomlFactory();
        //        JsonParser parser = fac.createParser(reader);
        //
        //        while (parser.nextToken() != JsonToken.END_OBJECT) {
        //            var token = parser.getCurrentToken();
        //            if (token == JsonToken.START_OBJECT) {
        //            }
        //
        //            var field = parser.currentName();
        //            if (field == null) continue;
        //
        //            System.out.println("Found Field: " + field);
        //
        //            if (field.equals("version")) {
        //                var next = parser.nextToken();
        //                System.out.println(next.toString());
        //                System.out.println(parser.getValueAsString());
        //            }
        //
        //            if (field.equals("app.mainClass")) {
        //                System.out.println(token.asString());
        //            }
        //        }
        //        parser.close();
    }
}
