import org.springframework.core.io.ClassPathResource
import java.io.BufferedInputStream
import java.io.File
import java.io.FileFilter
import java.util.zip.ZipFile

fun main() {
    val destPath = File("/tmp/tempdir")
    destPath.mkdirs()
    simpleFileUnzip(ClassPathResource("test.zip").file, destPath.absolutePath)

    destPath.listFiles(FileFilter {it.extension == "txt"}).forEach { file ->
        file.inputStream().use {
            it.bufferedReader().use {
                println ("file: ${file.name}")
                it.lines().forEach(::println)
            }
        }
    }

    destPath.deleteRecursively()
}

fun simpleFileUnzip(zipFile: File, targetPath: String) {
    val zip = ZipFile(zipFile, Charsets.UTF_8)
    zip.entries().iterator().forEach {
        val destFilePath = File(targetPath)

        BufferedInputStream(zip.getInputStream(it))
                .use { bis ->
                    File("${destFilePath.absolutePath}/${it.name}")
                            .outputStream()
                            .buffered(4096)
                            .use { out -> bis.copyTo(out) }
                }
    }
}
