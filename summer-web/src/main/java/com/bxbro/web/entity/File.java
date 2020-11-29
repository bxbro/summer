package com.bxbro.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 *  文件实体类
 * </p>
 *
 * @author auto-generator
 * @since 2020-11-29
 */
@TableName("t_file")
public class File extends Model<File> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件存储的相对路径
     */
    private String fileUrl;

    /**
     * 文件类型：0图片 1音频 2视频
     */
    private Boolean fileType;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 修改时间
     */
    private Long mtime;

    /**
     * 是否删除标志位
     */
    private Boolean deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Boolean getFileType() {
        return fileType;
    }

    public void setFileType(Boolean fileType) {
        this.fileType = fileType;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public static final String ID = "id";

    public static final String FILE_NAME = "file_name";

    public static final String FILE_URL = "file_url";

    public static final String FILE_TYPE = "file_type";

    public static final String CTIME = "ctime";

    public static final String MTIME = "mtime";

    public static final String DELETED = "deleted";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "File{" +
        "id=" + id +
        ", fileName=" + fileName +
        ", fileUrl=" + fileUrl +
        ", fileType=" + fileType +
        ", ctime=" + ctime +
        ", mtime=" + mtime +
        ", deleted=" + deleted +
        "}";
    }
}
