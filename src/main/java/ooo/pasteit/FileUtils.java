package ooo.pasteit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileUtils {

    static File getUserDir() {
        return new File(System.getProperty("user.dir")); //$NON-NLS-1$
    }

    static String read(final File file) throws IOException {
        BufferedReader reader = null;
        try {
            final StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new FileReader(file));
            String line;
            boolean isFirst = true;
            final String lineSeparator = System.getProperty("line.separator"); //$NON-NLS-1$
            while ((line = reader.readLine()) != null) {
                if (isFirst)
                    isFirst = false;
                else
                    builder.append(lineSeparator);
                builder.append(line);
            }
            return builder.toString();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (final IOException e) {
                }
        }
    }

    static void write(final File file, final String text) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (final IOException e) {
                }
        }
    }
}
