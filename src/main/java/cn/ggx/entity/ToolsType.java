package cn.ggx.entity;

import java.util.Date;
import java.util.List;

/**
 * tools_type
 * 
 * @author bianj
 * @version 1.0.0 2021-01-21
 */
public class ToolsType implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2719977130124234435L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** id */
    private Integer id;

    /** name */
    private String name;

    /** flag */
    private Integer flag;

    /** createTime */
    private Date createTime;

    private List<ToolsItem> toolsItems;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

    /**
     * 获取id
     * 
     * @return id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置id
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取name
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取flag
     * 
     * @return flag
     */
    public Integer getFlag() {
        return this.flag;
    }

    /**
     * 设置flag
     * 
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取createTime
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置createTime
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ToolsItem> getToolsItems() {
        return toolsItems;
    }

    public void setToolsItems(List<ToolsItem> toolsItems) {
        this.toolsItems = toolsItems;
    }

    /* This code was generated by TableGo tools, mark 2 end. */

    @Override
    public String toString() {
        return "ToolsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                ", createTime=" + createTime +
                ", toolsItems=" + toolsItems +
                '}';
    }
}