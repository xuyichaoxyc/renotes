RandomAccessFile 类是对随机文件的读取和写入。

该随机访问文件类似于存储在文件系统中的一个庞大字节数组，输入操作从该数组的开始读取字节，并随着对字节的读取而前移。如果随机访问文件以读取/写入模式创建，则输出操作也可用。输出操作从文件指针开始写入字节，并随着对字节的写入而前移。如果随机访问文件以读取/写入模式创建，则输出操作也可用。输出操作从文件指针开始写入字节，并随着对字节的写入而前移。


+ RandomAccessFile(String name, String mode)
+ RandomAccessFile(File file, String mode)

"r"代表只读，"rw"代表可读写

文件指针的操作：
+ long getFilePointer():用于得到当前的文件指针
+ void seek(long pos):用于移动文件指针到指定的位置
+ int skipBytes(int n):使文件指针向前移动指定的n个字节

