package com.bee.admin.params.charts;

/**
 * Created by suntongwei on 15/10/22.
 */
public class Feature implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -6947386341806965557L;

    /**
     * 是否显示保存图片按钮
     */
    private SaveAsImage saveAsImage;

    public SaveAsImage getSaveAsImage() {
        return saveAsImage;
    }

    public void setSaveAsImage(SaveAsImage saveAsImage) {
        this.saveAsImage = saveAsImage;
    }
}
