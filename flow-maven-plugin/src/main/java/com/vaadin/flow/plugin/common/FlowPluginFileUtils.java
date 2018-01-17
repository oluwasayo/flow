/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.flow.plugin.common;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;

import org.apache.commons.io.FileUtils;

/**
 * Util methods for files manipulation.
 *
 * @author Vaadin Ltd.
 */
public final class FlowPluginFileUtils {
    private FlowPluginFileUtils() {
    }

    /**
     * A {@link FileUtils#forceMkdir(File)} wrapper that handles {@link IOException}.
     *
     * @param directory the directory to create, must not be {@code null}
     * @throws UncheckedIOException if {@link FileUtils#forceMkdir(File)} throws {@link IOException}
     */
    public static void forceMkdir(File directory) {
        try {
            FileUtils.forceMkdir(Objects.requireNonNull(directory));
        } catch (IOException e) {
            throw new UncheckedIOException(String.format("Failed to create directory '%s'", directory), e);
        }
    }
}
