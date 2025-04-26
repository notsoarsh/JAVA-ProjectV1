package src;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InventoryManager {

    private HashMap<String, InventoryItem> items;

    public InventoryManager() {
        items = new HashMap<>();
    }

    public void addItem(InventoryItem item) {
        items.put(item.getItemId(), item);
    }

    public InventoryItem viewItem(String id) {
        return items.get(id);
    }

    public boolean deleteItem(String id) {
        return items.remove(id) != null;
    }

    public void viewAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        
        // Convert HashMap values to a List for sorting
        List<InventoryItem> itemList = new ArrayList<>(items.values());
        
        // Sort items by category and then by name
        Collections.sort(itemList, new Comparator<InventoryItem>() {
            @Override
            public int compare(InventoryItem item1, InventoryItem item2) {
                int categoryComparison = item1.getCategory().compareTo(item2.getCategory());
                if (categoryComparison != 0) {
                    return categoryComparison;
                }
                return item1.getName().compareTo(item2.getName());
            }
        });
        
        // Display items in a formatted table
        System.out.println("\n------------------------------ INVENTORY ITEMS ------------------------------");
        System.out.printf("%-10s %-20s %-15s %-10s %-10s %-15s%n", 
                "ID", "NAME", "CATEGORY", "QUANTITY", "PRICE", "SUPPLIER");
        System.out.println("--------------------------------------------------------------------------");
        
        for (InventoryItem item : itemList) {
            System.out.printf("%-10s %-20s %-15s %-10d $%-9.2f %-15s%n", 
                    item.getItemId(), 
                    truncateString(item.getName(), 20),
                    truncateString(item.getCategory(), 15),
                    item.getQuantity(), 
                    item.getPrice(), 
                    truncateString(item.getSupplier(), 15));
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total Items: " + items.size());
    }
    
    // Helper method to truncate strings for display formatting
    private String truncateString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    public void saveToFile(String filename) {
        FileManager.writeToFile(filename, items);
    }

    public void loadFromFile(String filename) {
        HashMap<String, InventoryItem> loadedItems = FileManager.readFromFile(filename);
        if (loadedItems != null && !loadedItems.isEmpty()) {
            items = loadedItems;
            System.out.println("Loaded " + items.size() + " items from " + filename);
        }
    }

    public void updateItem(String id, InventoryItem newItem) {
        if (items.containsKey(id)) {
            items.put(id, newItem);
        }
    }
    
    // Get total inventory value
    public double getTotalInventoryValue() {
        double total = 0;
        for (InventoryItem item : items.values()) {
            total += (item.getPrice() * item.getQuantity());
        }
        return total;
    }
    
    // Get items by category
    public List<InventoryItem> getItemsByCategory(String category) {
        List<InventoryItem> categoryItems = new ArrayList<>();
        for (InventoryItem item : items.values()) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                categoryItems.add(item);
            }
        }
        return categoryItems;
    }
    
    // Get low stock items (items with quantity below threshold)
    public List<InventoryItem> getLowStockItems(int threshold) {
        List<InventoryItem> lowStockItems = new ArrayList<>();
        for (InventoryItem item : items.values()) {
            if (item.getQuantity() < threshold) {
                lowStockItems.add(item);
            }
        }
        return lowStockItems;
    }
}
