package id.prihantoro.sayurongo.model;

/**
 * Created by Wahyu Prihantoro on 12-Sep-16.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private int drawable;
    private boolean isLine;


    public NavDrawerItem() {

    }

    public NavDrawerItem(String title, int drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    public NavDrawerItem(boolean isLine) {
        this.isLine = isLine;
    }

    public NavDrawerItem(int drawable, String title) {
        this.drawable = drawable;
        this.title = title;
    }

    public NavDrawerItem(boolean showNotify, String title, int drawable, boolean isLine) {
        this.showNotify = showNotify;
        this.title = title;
        this.drawable = drawable;
        this.isLine = isLine;
    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public boolean isLine() {
        return isLine;
    }

    public void setLine(boolean line) {
        isLine = line;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
