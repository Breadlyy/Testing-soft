package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private static ArrayList<Item> cart = new ArrayList<Item>();
    private StandardItem item = new StandardItem(23,"Leather helmet", 100f, "Leather stuff", 30);
    @Test
    public void testConstructorOrderSuccess()
    {
        String customerName = "Billy";
        String customerAddress = "Gachi street 300";
        int state = 1;
        cart.add(item);
        ShoppingCart finalCart = new ShoppingCart(cart);
        Order order = new Order(finalCart, customerName, customerAddress, state);

        assertEquals(order.getItems(), finalCart.getCartItems());
        assertEquals(order.getCustomerName(), customerName);
        assertEquals(order.getCustomerAddress(), customerAddress);
        assertEquals(order.getState(), state);
    }
    @Test
    public void testConstructorOrderNull()
    {
        String customerName = "Van";
        String customerAdress = "Dungeon Street 228";
        int state = 2;

        Assertions.assertThrows(NullPointerException.class,
                () -> new Order(null, customerName, customerAdress),getMessageOfNull()
        );

    }

    private String getMessageOfNull()
    {
        return "Argument value cannot be null";
    }

}