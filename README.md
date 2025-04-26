# Inventory Management System

A Java-based command-line application for managing inventory items.

## Features

- Add, view, update, and delete inventory items
- View all items in a formatted table
- Save inventory data to a file
- Load inventory data from a file
- Input validation to prevent crashes
- Sorting items by category and name

## How to Run

1. Compile the Java files:
   \`\`\`
   javac src/*.java
   \`\`\`

2. Run the application:
   \`\`\`
   java src.Main
   \`\`\`

## Usage Instructions

### Main Menu Options

1. **Add Item**: Add a new item to the inventory
2. **View Item**: View details of a specific item by ID
3. **Update Item**: Update an existing item's details
4. **Delete Item**: Remove an item from the inventory
5. **View All Items**: Display all items in a formatted table
6. **Save to File**: Save the current inventory to a file
7. **Load from File**: Load inventory data from a file
0. **Exit**: Exit the application

### Item Properties

- **Item ID**: Unique identifier for each item
- **Name**: Name of the item
- **Category**: Category the item belongs to
- **Quantity**: Number of items in stock
- **Price**: Price per unit
- **Supplier**: Name of the supplier

## Data Persistence

The application uses Java's serialization to save and load inventory data. Files are saved with a `.dat` extension.

## Project Structure

- `Main.java`: Entry point for the application
- `CLI.java`: Command-line interface for user interaction
- `InventoryManager.java`: Manages the collection of inventory items
- `InventoryItem.java`: Represents an individual inventory item
- `FileManager.java`: Handles file operations for saving and loading data
\`\`\`

```gitignore file=".gitignore"
# Compiled class files
*.class

# Log files
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs
hs_err_pid*
replay_pid*

# IDE specific files
.idea/
.vscode/
*.iml
*.iws
*.ipr
.classpath
.project
.settings/

# Data files
*.dat
