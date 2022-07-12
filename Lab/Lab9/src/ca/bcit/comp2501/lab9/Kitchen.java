package ca.bcit.comp2501.lab9;

import java.util.ArrayList;
import java.util.List;

/**
 * The Kitchen class represents a kitchen that stores kitchen tools.
 * @author Chris Wu
 * @version 1.0
 */
public class Kitchen
{
    private final List<KitchenTool> kitchenTools;

    /**
     * The Kitchen constructor
     */
    public Kitchen()
    {
        this.kitchenTools = new ArrayList<>();
    }

    /**
     * @param tool is the  kitchen tool to be added
     */
    public void addKitchenTool(final KitchenTool tool)
    {
        kitchenTools.add(tool);
    }

    /**
     * @param tool is the kitchen tool to be removed
     */
    public void removeKitchenTool(final KitchenTool tool)
    {
        kitchenTools.remove(tool);
    }

    /**
     * display all kitchen tools' info
     */
    public void displayKitchenTools()
    {
        for(KitchenTool tool : kitchenTools)
        {
            if(tool != null)
            {
                System.out.println(tool);
            }
        }
    }

    /**
     * counts and prints the total number of kitchen tools in the kitchen
     */
    public void numOfTools()
    {
        int count;
        count = 0;

        for(KitchenTool tool : kitchenTools)
        {
            if(tool != null)
            {
                count++;
            }
        }
        System.out.println("\n\nCurrent number of kitchen tools: " + count);
    }
}
