/*
 * Copyright (c) 2025 harmless-tech
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package tech.harmless.cupbuild.experimental;

// TODO: Get git info from 'git' command or by reading files?
//       Files -> git as fallback

// git rev-parse HEAD
// git rev-parse --verify HEAD
// git rev-parse --short HEAD
// git rev-parse --short=12 HEAD

// .git/refs/heads/main
// .git/HEAD (Contains ref or detached)

// Logic:
// If ran in tld of git, then search .git. Else run git.
// What about git init?
public class InvokeGit {}
