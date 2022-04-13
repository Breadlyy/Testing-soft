package shop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.MatcherAssert.assertThat;
public class StandardItemTest  {
    private static StandardItem[] testItem() {
        return new StandardItem[] {
                new StandardItem(12, "latex gloves", 300,"leather stuff", 100) };
    }

private int loyaltyPoints;

    @Test
    public void testConstructorStandardItem()
    {
        int id = 12;
        String name = "leather shoes";
        int price = 20;
        String category = "leather stuff";
        int loyaltyPoints = 50;
        StandardItem item1 = new StandardItem(id, name, price,category, loyaltyPoints);
        Assertions.assertEquals(item1.getID(),id);
        Assertions.assertEquals(item1.getName(), name);
        Assertions.assertEquals(item1.getPrice(), price);
        Assertions.assertEquals(item1.getCategory(), category);
        Assertions.assertEquals(item1.getLoyaltyPoints(), loyaltyPoints);
    }

    @Test
    public void testCopyTrue() {
        StandardItem standartItem = new StandardItem(1, "Pants", 80, "leather stuff", 10);
        StandardItem copyItem = standartItem.copy();

        Assertions.assertEquals(copyItem.getID(), standartItem.getID());
        Assertions.assertEquals(copyItem.getName(), standartItem.getName());
        Assertions.assertEquals(copyItem.getPrice(), standartItem.getPrice());
        Assertions.assertEquals(copyItem.getCategory(), standartItem.getCategory());
        Assertions.assertEquals(copyItem.getLoyaltyPoints(), standartItem.getLoyaltyPoints());
    }
    @Test
    public void testCopyFalse()
    {
        StandardItem standartItem = new StandardItem(1, "Pants", 80, "leather stuff", 10);
        StandardItem standartItem2 = new StandardItem(12, "latex gloves", 300,"leather stuff", 100);
        StandardItem copyItem = standartItem.copy();

        Assertions.assertEquals(copyItem.getID(), standartItem2.getID());
        Assertions.assertEquals(copyItem.getName(), standartItem2.getName());
        Assertions.assertEquals(copyItem.getPrice(), standartItem2.getPrice());
        Assertions.assertEquals(copyItem.getCategory(), standartItem2.getCategory());
        Assertions.assertEquals(copyItem.getLoyaltyPoints(), standartItem2.getLoyaltyPoints());
    }

    @ParameterizedTest
    @MethodSource("testItem")
    public void testEqualsTrue(Object object) {
        StandardItem item1 = new StandardItem(12, "latex gloves", 300,"leather stuff", 100);
        Assertions.assertTrue(item1.equals(object));
    }

    @ParameterizedTest
    @MethodSource("testItem")
    public void testEqualsFalse(Object object) {
        StandardItem item1 = new StandardItem(228, "Vans Suit", 50000, "Legendary leather Stuff", 300);
        Assertions.assertFalse(item1.equals(object));
    }


}