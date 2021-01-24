package cn.ggx.entity;

import java.io.Serializable;
import java.util.Date;

public class ToolsTypeItem implements Serializable {

    private static final long serialVersionUID = 3269017706217743834L;
    private Integer toolsTypeId ;
    private String toolsTypeName ;
    private Integer toolsTypeFlag ;
    private Date toolsTypeCreateTime ;
    private Integer toolsItemId ;
    private String toolsItemName ;
    private String toolsItemToolsUrl ;
    private String toolsItemImgUrl ;
    private Integer toolsItemToolsTypeId ;
    private Integer toolsItemFlag ;
    private Date toolsItemCreateTime ;

    public ToolsTypeItem() {
    }

    public ToolsTypeItem(Integer toolsTypeId, String toolsTypeName, Integer toolsTypeFlag, Date toolsTypeCreateTime, Integer toolsItemId, String toolsItemName, String toolsItemToolsUrl, String toolsItemImgUrl, Integer toolsItemToolsTypeId, Integer toolsItemFlag, Date toolsItemCreateTime) {
        this.toolsTypeId = toolsTypeId;
        this.toolsTypeName = toolsTypeName;
        this.toolsTypeFlag = toolsTypeFlag;
        this.toolsTypeCreateTime = toolsTypeCreateTime;
        this.toolsItemId = toolsItemId;
        this.toolsItemName = toolsItemName;
        this.toolsItemToolsUrl = toolsItemToolsUrl;
        this.toolsItemImgUrl = toolsItemImgUrl;
        this.toolsItemToolsTypeId = toolsItemToolsTypeId;
        this.toolsItemFlag = toolsItemFlag;
        this.toolsItemCreateTime = toolsItemCreateTime;
    }

    public Integer getToolsTypeId() {
        return toolsTypeId;
    }

    public void setToolsTypeId(Integer toolsTypeId) {
        this.toolsTypeId = toolsTypeId;
    }

    public String getToolsTypeName() {
        return toolsTypeName;
    }

    public void setToolsTypeName(String toolsTypeName) {
        this.toolsTypeName = toolsTypeName;
    }

    public Integer getToolsTypeFlag() {
        return toolsTypeFlag;
    }

    public void setToolsTypeFlag(Integer toolsTypeFlag) {
        this.toolsTypeFlag = toolsTypeFlag;
    }

    public Date getToolsTypeCreateTime() {
        return toolsTypeCreateTime;
    }

    public void setToolsTypeCreateTime(Date toolsTypeCreateTime) {
        this.toolsTypeCreateTime = toolsTypeCreateTime;
    }

    public Integer getToolsItemId() {
        return toolsItemId;
    }

    public void setToolsItemId(Integer toolsItemId) {
        this.toolsItemId = toolsItemId;
    }

    public String getToolsItemName() {
        return toolsItemName;
    }

    public void setToolsItemName(String toolsItemName) {
        this.toolsItemName = toolsItemName;
    }

    public String getToolsItemToolsUrl() {
        return toolsItemToolsUrl;
    }

    public void setToolsItemToolsUrl(String toolsItemToolsUrl) {
        this.toolsItemToolsUrl = toolsItemToolsUrl;
    }

    public String getToolsItemImgUrl() {
        return toolsItemImgUrl;
    }

    public void setToolsItemImgUrl(String toolsItemImgUrl) {
        this.toolsItemImgUrl = toolsItemImgUrl;
    }

    public Integer getToolsItemToolsTypeId() {
        return toolsItemToolsTypeId;
    }

    public void setToolsItemToolsTypeId(Integer toolsItemToolsTypeId) {
        this.toolsItemToolsTypeId = toolsItemToolsTypeId;
    }

    public Integer getToolsItemFlag() {
        return toolsItemFlag;
    }

    public void setToolsItemFlag(Integer toolsItemFlag) {
        this.toolsItemFlag = toolsItemFlag;
    }

    public Date getToolsItemCreateTime() {
        return toolsItemCreateTime;
    }

    public void setToolsItemCreateTime(Date toolsItemCreateTime) {
        this.toolsItemCreateTime = toolsItemCreateTime;
    }

    @Override
    public String toString() {
        return "ToolsTypeItem{" +
                "toolsTypeId=" + toolsTypeId +
                ", toolsTypeName='" + toolsTypeName + '\'' +
                ", toolsTypeFlag=" + toolsTypeFlag +
                ", toolsTypeCreateTime=" + toolsTypeCreateTime +
                ", toolsItemId=" + toolsItemId +
                ", toolsItemName='" + toolsItemName + '\'' +
                ", toolsItemToolsUrl='" + toolsItemToolsUrl + '\'' +
                ", toolsItemImgUrl='" + toolsItemImgUrl + '\'' +
                ", toolsItemToolsTypeId=" + toolsItemToolsTypeId +
                ", toolsItemFlag=" + toolsItemFlag +
                ", toolsItemCreateTima=" + toolsItemCreateTime +
                '}';
    }
}
