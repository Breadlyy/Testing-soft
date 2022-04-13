package storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Item;
import shop.StandardItem;

import static org.junit.jupiter.api.Assertions.*;

class ItemStockTest {
    public static StandardItem item = new StandardItem(12, "latex gloves", 300,"leather stuff", 100);
    private static int countIncrease = 3;
    private static int countDecrease = 1;
    @Test
    public void testConstructorItemStock()
    {
        Item item1 = item;
        ItemStock itemStock = new ItemStock(item1);
        Assertions.assertEquals(itemStock.getItem(), item1);
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 2, 8, 1, 228, 29, 55})
    public void testIncreaseItemCount(int countIncrease)
    {
        Item item1 = item;
        ItemStock itemStock = new ItemStock(item1);
        int initCount = itemStock.getCount();

        itemStock.IncreaseItemCount(countIncrease);
        assertEquals(itemStock.getCount(), initCount + countIncrease);

    }

    @ParameterizedTest
    @ValueSource(ints = {63, 3, 86, 666, 32})
    public void testDecreaseItemCount(int countDecrease)
    {
        Item item1 = item;
        ItemStock itemStock = new ItemStock(item1);
        itemStock.IncreaseItemCount(5);
        int initCount = itemStock.getCount();

        itemStock.decreaseItemCount(countDecrease);
        Assertions.assertEquals(itemStock.getCount(),initCount - countDecrease);

    }

}