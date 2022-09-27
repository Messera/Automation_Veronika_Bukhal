package lecture10;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lecture10Test extends BaseTest {

    @Test
    public void test(){
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("user.home"));
//        System.out.println(System.getProperty("env"));
        new NavigationPage().open().navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
//        System.out.println(new SortableDataTablesPage().getTableRowsData());
//        new SortableDataTablesPage().getTableRowsData().forEach(System.out::println);

        Map<String, List<String>> mapTableData = new SortableDataTablesPage().clickTableColumn("Last Name").getTableData();

        List<List<String>> tableData = new SortableDataTablesPage().getTableRowsData();
        Assert.assertTrue(tableData.get(2).contains("$100.00"));
        List<String> lastNameData = mapTableData.get("Last Name");
        Assert.assertEquals(lastNameData, lastNameData.stream().sorted().collect(Collectors.toList()));

    }

}
