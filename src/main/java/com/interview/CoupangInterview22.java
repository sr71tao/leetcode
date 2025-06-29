package com.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wuyuntao on 2025/6/29
 */
public class CoupangInterview22 {
// 类实现 模拟文件目录结构存储
    // 接口创建、删除、移动 文件/目录
    // 目录 查看目录下文件
    // 文件 定位并展示文件


    public static void main(String[] args) {
        FileService fileService = new FileService();


        // 创建文件
        fileService.createFile("/a/b", "c", 1);
        // 查看文件
        fileService.listFiles("/a/b");
        // 删除文件
        fileService.removeFile("/a/b/c");


        // 创建目录
        fileService.createFile("/a/b","d", 1);
        fileService.createFile("/a/f","e", 2);
        // 查看目录
        fileService.listFiles("/a/b");
        // move目录
        fileService.move("/a/b", "/a/f");
        // 查看目录
        fileService.listFiles("/a/b");
        // 查看目录
        fileService.listFiles("/a/f");
        fileService.listFiles("/a/b");


    }


}




class FileService {


    // 创建
    public long createFile(String path, String name, int type) {
        System.out.println("create: " + path + "/" + name);
        return makeFile(name, type).create(path);
    }


    // 删除
    public boolean removeFile(String path) {
        System.out.println("remove: " + path);
        FileEntity file = getRealFile(path);
        if (file != null) {
            file.remove();
            return true;
        }
        return false;
    }


    // 查看
    public List<FileEntity> listFiles(String path) {
        if (!checkFileExist(path)) {
            return new LinkedList<>();
        }
        List<FileEntity> subFiles = new LinkedList<>();
        FileEntity file =  getRealFile(path);
        for (String subFileName : file.getSubFileNames()) {
            FileEntity fileEntity = file.getSubFile(subFileName);
            if (fileEntity != null) {
                subFiles.add(fileEntity);
            }
        }
        System.out.println("listFiles: " + path);
        for (FileEntity fileEntity : subFiles) {
            System.out.println(fileEntity);
        }
        return subFiles;


    }


    // 移动
    public boolean move(String oriFilePath, String toPath) {
        if (!checkFileExist(oriFilePath) || !checkFileExist(toPath)) {
            return false;
        }
        FileEntity fromFile = getRealFile(oriFilePath);
        FileEntity toDirFile = getRealFile(toPath);
        if (toDirFile.type == 1) {
            return false;
        }
        System.out.println("move fromPath:" + oriFilePath + ", toPath" + toPath);
        fromFile.move(toPath);
        return true;
    }




    private boolean checkFileExist(String path) {
        return getRealFile(path) != null? true: false;
    }


    private FileEntity makeFile(String name, int type) {
        return new FileEntity(name, type);
    }


    private FileEntity getRealFile(String path) {
        return FileEntity.find(path);
    }
}


class FileEntity {


    private static FileEntity rootFile = new FileEntity("", 2);


    String name;
    int type; // 类型: 1:文件 2:目录
    FileEntity parent;


    // type=2
    // name list
    private List<String> subFileNames = new LinkedList<>();
    // name -> FileEntity
    private Map<String, FileEntity> subFiles = new HashMap<String, FileEntity>();


    public FileEntity(FileEntity parent, String name, int type) {
        this.parent = parent;
        this.name = name;
        this.type = type;
    }


    public FileEntity(String name, int type) {
        this.name = name;
        this.type = type;
    }




    public long create(String pathName) {
        List<String> paths = Arrays.stream(pathName.split("/")).filter(e -> !"".equals(e)).collect(Collectors.toList());


        FileEntity file = rootFile;
        for (String fileName : paths) {
            FileEntity subFile = file.subFiles.get(fileName);
            if (subFile != null) {
                file = subFile;
                continue;
            }
            subFile = new FileEntity(file, fileName, 2);
            file.subFiles.put(fileName, subFile);
            file.subFileNames.add(fileName);
            file = subFile;
        }
        this.parent = file;
        file.subFiles.put(this.name, this);
        file.subFileNames.add(this.name);
        return 1;
    }


    public boolean remove() {
        FileEntity file = this.parent;
        if (file == null) {
            return false;
        }
        file.subFiles.remove(this.name);
        file.subFileNames.remove(this.name);
        return true;
    }


    public void move(String toPath) {
        List<String> paths = Arrays.stream(toPath.split("/")).filter(e -> !e.isEmpty()).collect(Collectors.toList());


        String parentPath = "";
        FileEntity file = rootFile;
        for (String fileName : paths) {
            String curPath = parentPath +"/" + fileName;
            FileEntity subFile = file.subFiles.get(fileName);
            if (subFile != null) {
                file = subFile;
                parentPath = curPath;
                continue;
            }
            subFile = new FileEntity(file, fileName, 2);
            file.subFiles.put(fileName, subFile);
            file.subFileNames.add(fileName);
            file = subFile;
            parentPath = curPath;
        }
        FileEntity oriParent = this.parent;
        this.parent = file;
        file.subFiles.put(this.name, this);
        file.subFileNames.add(this.name);


        oriParent.subFileNames.remove(this.name);
        oriParent.subFiles.remove(this.name);
    }






    public static FileEntity find(String path) {
        List<String> paths = Arrays.stream(path.split("/")).filter(e -> !"".equals(e)).collect(Collectors.toList());
        FileEntity file = rootFile;
        for (String fName : paths) {
            FileEntity subFile = file.subFiles.get(fName);
            if (subFile == null) {
                return null;
            }
            file = subFile;
        }
        return file;
    }


    public List<String> getSubFileNames() {
        return this.subFileNames;
    }


    public FileEntity getSubFile(String subFileName) {
        return this.subFiles.get(subFileName);
    }




    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
