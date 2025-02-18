import java.util.Arrays;
import java.util.Comparator;
class Item 
{
    int weight;
    int profit;
    double ratio;
    public Item(int weight, int value) 
    {
        this.weight = weight;
        this.profit = value;
        this.ratio = (double) value / weight;
    }
}
public class Knapsack {
    public static double getMaxValue(Item[] items, int capacity) 
    {
        Arrays.sort(items, new Comparator<Item>()
         {
            public int compare(Item a, Item b) 
            {
                return Double.compare(b.ratio, a.ratio);
            }
        });
        double totalValue = 0.0; 
        for (Item item : items) {
            if (capacity == 0) {
                break; 
            }
            if (item.weight <= capacity) 
            {
                totalValue += item.profit;
                capacity -= item.weight;
            } 
            else 
            {
                totalValue += item.profit * ((double) capacity / item.weight);
                break; 
            }
        }
        return totalValue; 
    }
    public static void main(String[] args) 
    {
        int[] profits = {10, 20, 30, 40, 50};
        int[] weights = {20, 30, 66, 40, 60};
         
        Item[] items = new Item[profits.length];
        for (int i = 0; i < profits.length; i++) 
        {
            items[i] = new Item(weights[i], profits[i]);
        }
        int capacity = 100; 
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack:  " + maxValue);
    }
}
