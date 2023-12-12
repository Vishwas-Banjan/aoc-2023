package util

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

object ReadFile {
    fun fileToString(filePath: String): String {
        var fileContent = ""
        try {
            BufferedReader(FileReader(filePath)).use { reader ->
                val stringBuilder = StringBuilder()
                var line: String?

                while ((reader.readLine().also { line = it }) != null) {
                    stringBuilder.append(line).append("\n")
                }

                fileContent = stringBuilder.trim().toString()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileContent
    }
}