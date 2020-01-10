/*
 * This file is part of Dependency-Track Jenkins plugin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jenkinsci.plugins.DependencyTrack;

import hudson.console.LineTransformationOutputStream;
import hudson.model.TaskListener;
import java.io.IOException;
import java.io.PrintStream;

public class ConsoleLogger extends LineTransformationOutputStream {

    private static final String PREFIX = "[" + DependencyTrackPublisher.PLUGIN_NAME + "] ";

    private transient final PrintStream logger;

    public ConsoleLogger(TaskListener listener) {
        this.logger = listener.getLogger();
    }

    /**
     * Log messages to the builds console.
     * @param message The message to log
     */
    protected void log(String message) {
        logger.println(PREFIX + message.replaceAll("\\n", "\n" + PREFIX));
    }

    /**
     * Changes each new line to append the prefix before logging
     */
    @Override
    protected void eol(byte[] b, int len) throws IOException {
        logger.append(PREFIX);
        logger.write(b, 0, len);
    }
}