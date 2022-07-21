package ca.bcit.comp2501.lab9;

/**
 * The Lab9Driver class is the driver class that
 * creates instances of all the item types you
 * and invoke all the methods of the Kitchen storage class.
 * @author Chris Wu & Ee Von Ng
 * @version 1.0
 */
public class Lab9Driver
{
    /**
     * THe entry point of the program
     * @param args the command line arguments (unused)
     */
    public static void main(final String[] args)
    {
        KitchenTool tool1, tool2, tool3, tool4, tool5, tool6, tool7, tool8, tool9, tool10;

        tool1 = new Spoon("Silver", 2000, 60, false, "circular", 19);
        tool2 = new Spoon("white", 2021, 38, false, "oval", 21);
        tool3 = new Chopstick("brown", 2015, 44, false, 24, "Chinese");
        tool4 = new Chopstick("tan", 2017, 44, false, 23, "Japanese");
        tool5 = new Mixer("white", 2020, 38, true, 3, 60);
        tool6 = new Mixer("white", 2022, 38, true, 5, 65);
        tool7 = new Oven("silver", 2009, 38, true, false, 200, 425);
        tool8 = new Oven("white", 2021, 38, true, true, 200, 455);
        tool9 = new Microwave("white", 2007, 38, true, "buttons", false);
        tool10 = new Microwave("white", 2019, 38, true, "knob", true);

        Kitchen kitchen;
        kitchen = new Kitchen();

        kitchen.addKitchenTool(tool1);
        kitchen.addKitchenTool(tool2);
        kitchen.addKitchenTool(tool3);
        kitchen.addKitchenTool(tool4);
        kitchen.addKitchenTool(tool5);
        kitchen.addKitchenTool(tool6);
        kitchen.addKitchenTool(tool7);
        kitchen.addKitchenTool(tool8);
        kitchen.addKitchenTool(tool9);
        kitchen.addKitchenTool(tool10);

        kitchen.displayKitchenTools();

        kitchen.removeKitchenTool(tool1);
        kitchen.removeKitchenTool(tool3);
        kitchen.removeKitchenTool(tool5);
        kitchen.removeKitchenTool(tool7);
        kitchen.removeKitchenTool(tool9);

        System.out.println("\n\n\nTools after removing one of each type of tool");
        kitchen.displayKitchenTools();

        kitchen.numOfTools();
    }
}
