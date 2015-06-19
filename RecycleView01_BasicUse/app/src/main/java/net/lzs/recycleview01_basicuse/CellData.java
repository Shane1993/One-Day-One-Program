package net.lzs.recycleview01_basicuse;

/**
 * Created by LEE on 2015/6/19.
 */
public class CellData {

    private String title;
    private String content;

    public CellData(String title,String content)
    {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
