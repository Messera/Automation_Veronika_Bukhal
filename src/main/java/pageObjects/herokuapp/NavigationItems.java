package pageObjects.herokuapp;

public enum NavigationItems {

    DYNAMIC_LOADING("Dynamic Loading"),
    DROPDOWN("Dropdown"),
    INFINITE_SCROLL("Infinite Scroll"),
    CONTEXT_MENU("Context Menu"),
    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_UPLOADER("File Upload"),
    SORTABLE_DATA_TABLES("Sortable Data Tables");


    private String item;

    NavigationItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
