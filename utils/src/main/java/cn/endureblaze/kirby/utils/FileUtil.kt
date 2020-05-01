package cn.endureblaze.kirby.utils

import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.text.DecimalFormat
import java.util.*

object FileUtil {

    /**
     * 大小的类型
     */
    object FileSizeType {
        const val B: Int = 1
        const val KB: Int = 2
        const val MB: Int = 3
        const val GB: Int = 4
    }

    /**
     * 给定路径和文件名创建文件
     * @param filePath 路径名称
     * @param fileName 文件名
     * @return 创建好的 File 对象
     */
    fun newFile(filePath: String, fileName: String): File? {
        if (filePath.isEmpty() || fileName.isEmpty()) {
            return null
        }
        //判断目录是否存在，如果不存在就创建
        val dir = File(filePath)
        if (!dir.exists()) {
            dir.mkdirs()
        }

        //组织文件路径
        val sbFile: StringBuilder = StringBuilder(filePath)
        if (!filePath.endsWith("/")) {
            sbFile.append("/")
        }
        sbFile.append(fileName)

        //创建文件并返回对象
        val file = File(sbFile.toString())
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    /**
     * 获取指定文件或文件夹的指定单位的大小
     * @param filePath 文件路径
     * @param sizeType 文件大小的类型,具体请访问 FileSizeType
     */
    fun getFileOrFilesSize(filePath: String, sizeType: Int): Double {
        return formetFileSize(getSize(filePath), sizeType)
    }

    /**
     * 获取指定文件或文件夹的指定单位的大小，并且自动计算单位
     * @param filePath 文件路径
     * @return 计算好的带 B、KB、MB、GB 的字符串
     */
    fun getAutoFileOrFilesSize(filePath: String): String {
        return formetFileSize(getSize(filePath))
    }

    /**
     * 获取指定路径的大小，抽出来的函数
     * @param filePath 路径
     * @return Long 类型的大小
     */
    private fun getSize(filePath: String): Long {
        val file = File(filePath)
        var blockSize: Long = 0

        blockSize = if (file.isDirectory) {
            getFilesSize(file)
        } else {
            getFileSize(file)
        }
        return blockSize
    }

    /**
     * 获取指定文件夹的大小
     * @param file 文件夹的 File 对象
     * @return Long 类型的大小值
     */
    private fun getFilesSize(file: File): Long {
        var size: Long = 0
        val fList: Array<File>? = file.listFiles()
        if (fList != null) {
            for (f: File in fList) {
                size += if (file.isDirectory) {
                    getFilesSize(f)
                } else {
                    getFileSize(f)
                }
            }
        }
        return size
    }

    /**
     * 获取文件的大小
     * @param file 文件的 File 对象
     * @return Long 类型的大小值
     */
    private fun getFileSize(file: File): Long {
        var size: Long = 0
        if (file.exists()) {
            val fis = FileInputStream(file)
            size = fis.available().toLong()
        } else {
            file.createNewFile()
            Log.e("获取文件大小", "文件不存在!")
        }
        return size
    }

    /**
     * 转换文件大小
     * @param fileSize 文件的大小值
     * @param sizeType 需要转换的类型
     * @return 转换的结果
     */
    private fun formetFileSize(fileSize: Long, sizeType: Int): Double {
        val df = DecimalFormat("#.00")
        var fileSizeLong = 0.0
        when (sizeType) {
            FileSizeType.B -> fileSizeLong = df.format(fileSize.toDouble()).toDouble()
            FileSizeType.KB -> fileSizeLong = df.format(fileSize.toDouble() / 1024).toDouble()
            FileSizeType.MB -> fileSizeLong = df.format(fileSize.toDouble() / 1048576).toDouble()
            FileSizeType.GB -> fileSizeLong = df.format(fileSize.toDouble() / 1073741824).toDouble()
        }
        return fileSizeLong
    }

    /**
     * 转换文件大小并且自动带上单位
     * @param fileSize 文件的大小值
     * @return 转换的结果
     */
    private fun formetFileSize(fileSize: Long): String {
        val df = DecimalFormat("#.00")
        val fileSizeStr: String
        val wrongSize = "0 B"
        if (fileSize == 0L) {
            return wrongSize
        }
        fileSizeStr = when {
            fileSize < 1024 -> {
                "${df.format(fileSize.toDouble())} B"
            }
            fileSize < 1048576 -> {
                "${df.format(fileSize.toDouble() / 1024)} KB"
            }
            fileSize < 1073741824 -> {
                "${df.format(fileSize.toDouble() / 1048576)} MB"
            }
            else -> {
                "${df.format(fileSize.toDouble() / 1073741824)} GB"
            }
        }
        return fileSizeStr
    }

    /**
     * 删除单个文件
     * @param filePath 被删除文件的文件路径
     * @return 文件删除成功返回 true，否则返回 false
     */
    fun delFile(filePath: String): Boolean {
        val file = File(filePath)
        if (file.isFile && file.exists()) {
            return file.delete()
        }
        return false
    }

    /**
     * 删除文件夹和目录下的文件
     * @param filePath 被删除的目录路径
     * @param isDelThisDir 是否删除当前剩下的空目录
     * @return 目录删除成功返回 true，否则返回 false
     */
    fun delDir(filePath: String, isDelThisDir: Boolean): Boolean {
        var flag: Boolean
        var path = filePath
        //如果filePath不以文件分隔符结尾，自动添加文件分隔符
        //如果filePath不以文件分隔符结尾，自动添加文件分隔符
        if (!path.endsWith(File.separator)) {
            path += File.separator
        }
        val dirFile = File(path)
        if (!dirFile.exists() || !dirFile.isDirectory) {
            return false
        }
        flag = true
        val files = dirFile.listFiles()
        //遍历删除文件夹下的所有文件(包括子目录)
        for (file in Objects.requireNonNull(files)) {
            if (file.isFile) {
                //删除子文件
                flag = delFile(file.absolutePath)
                if (!flag) break
            } else {
                //删除子目录
                flag = delDir(file.absolutePath, isDelThisDir)
                if (!flag) break
            }
        }
        if (!flag)
            return false
        //是否删除当前空目录
        if (isDelThisDir)
            return dirFile.delete()
        return true
    }

    /**
     * 根据路径删除指定的目录或文件，无论存在与否
     * @param filePath 要删除的目录或文件
     * @param isDelThisDir 是否删除当前剩下的空目录
     * @return 删除成功返回 true，否则返回 false。
     */
    fun delFolder(filePath: String, isDelThisDir: Boolean): Boolean {
        val file = File(filePath)
        return if (!file.exists()) {
            false
        } else {
            if (file.isFile) {
                // 为文件时调用删除文件方法
                delFile(filePath)
            } else {
                // 为目录时调用删除目录方法
                delDir(filePath, isDelThisDir)
            }
        }
    }

    /**
     * 判断文件是否存在
     * @param filePath 要判断的文件路径
     * @return 如果存在返回 true，反之返回 false
     */
    fun isfFileIsExists(filePath: String): Boolean {
        try {
            val f = File(filePath)
            if (!f.exists()) {
                return false
            }
        } catch (e: Exception) {
            return false
        }
        return true
    }
}