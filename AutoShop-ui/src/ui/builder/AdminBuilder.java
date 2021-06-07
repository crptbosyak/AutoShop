package ui.builder;



import ui.action.Exit;
import ui.action.csv.*;
import ui.action.master.*;
import ui.action.order.*;
import ui.action.box.*;
import ui.action.work.*;

import ui.api.Build;
import ui.menu.Menu;
import ui.menu.item.MenuItem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AdminBuilder implements Build, Serializable {
    private final Menu mainMenu;
    private final Menu orderMenu;
    private final Menu masterMenu;
    private final Menu workMenu;
    private final Menu sortOrderMenu;
    private final Menu sortMasterMenu;
    private final Menu csvMenu;
    private Menu rootMenu;

    public AdminBuilder() {
        this.mainMenu = new Menu();
        this.orderMenu = new Menu();
        this.masterMenu = new Menu();
        this.sortOrderMenu = new Menu();
        this.sortMasterMenu = new Menu();
        this.rootMenu = new Menu();
        this.workMenu=new Menu();
        this.csvMenu=new Menu();
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }

    @Override
    public void buildMainMenu() {

        List<MenuItem> sortOrderMenuItems = new ArrayList<>();
        sortOrderMenu.setName("Order Sorting");
        sortOrderMenuItems.add(new MenuItem("Sort by Date Complete", new SortOrderDateComplete(), sortOrderMenu));
        sortOrderMenuItems.add(new MenuItem("Sort by Date Create", new SortOrderDateCreate(), sortOrderMenu));
        sortOrderMenuItems.add(new MenuItem("Sort by Price", new SortOrderPrice(), sortMasterMenu));
        sortOrderMenuItems.add(new MenuItem("Sort by Planed Start Date ", new SortOrderPlannedStarDate(), sortMasterMenu));
        sortOrderMenuItems.add(new MenuItem("Exit", new Exit(), sortOrderMenu));
        sortOrderMenu.setMenuItem(sortOrderMenuItems);

        List<MenuItem> orderMenuItems = new ArrayList<>();
        orderMenu.setName("Order Menu");
        orderMenuItems.add(new MenuItem("Add Order", new AddOrder(), orderMenu));
        orderMenuItems.add(new MenuItem("Canceled Order", new CanceledOrder(), orderMenu));
        orderMenuItems.add(new MenuItem("Close Order", new CloseOrder(), orderMenu));
        orderMenuItems.add(new MenuItem("Dell Order", new DellOrder(), orderMenu));
        orderMenuItems.add(new MenuItem("Copy and modify order",new CopyOrderAndModify(),orderMenu));
        orderMenuItems.add(new MenuItem("Progress Order", new ProgressOrder(), orderMenu));
        orderMenuItems.add(new MenuItem("Transfer the order to the master", new TransferTheOrderToTheMaster(), orderMenu));
        orderMenuItems.add(new MenuItem("Modify Order Planed Start Date", new ModifyPlannedStartDate(), orderMenu));
        orderMenuItems.add(new MenuItem("View all Order", new ViewAllOrders(), orderMenu));
        orderMenuItems.add(new MenuItem("View Order in Progress", new ViewOrderInProgress(), orderMenu));
        orderMenuItems.add(new MenuItem("View Order in Time", new ViewOrderInTime(), orderMenu));
        orderMenuItems.add(new MenuItem("Exit", new Exit(), orderMenu));
        orderMenu.setMenuItem(orderMenuItems);

        List<MenuItem> workMenuItems=new ArrayList<>();
        workMenu.setName("Work menu");
        workMenuItems.add(new MenuItem("Add work",new AddWork(),workMenu));
        workMenuItems.add(new MenuItem("Remove Work",new DellWork(),workMenu));
        workMenuItems.add(new MenuItem("View Work List",new ViewWorkList(),workMenu));
        workMenuItems.add(new MenuItem("Exit", new Exit(), workMenu));
        workMenu.setMenuItem(workMenuItems);

        List<MenuItem> sortMasterMenuItems = new ArrayList<>();
        sortMasterMenu.setName("Master Sort");
        sortMasterMenuItems.add(new MenuItem("Sort by Name", new SortMasterName(), sortMasterMenu));
        sortMasterMenuItems.add(new MenuItem("Sort by Busy", new SortMasterBusy(), sortMasterMenu));
        sortMasterMenuItems.add(new MenuItem("Exit", new Exit(), sortMasterMenu));
        sortMasterMenu.setMenuItem(sortMasterMenuItems);

        List<MenuItem> masterMenuItems = new ArrayList<>();
        masterMenu.setName("Master Menu");
        masterMenuItems.add(new MenuItem("Add Master", new AddMaster(), masterMenu));
        masterMenuItems.add(new MenuItem("Dell Master", new DellMaster(), masterMenu));
        masterMenuItems.add(new MenuItem("View All Master", new ViewAllMasters(), masterMenu));
        masterMenuItems.add(new MenuItem("View Master In Order", new ViewMasterInOrder(), masterMenu));
        masterMenuItems.add(new MenuItem("EXIT", new Exit(), masterMenu));
        masterMenu.setMenuItem(masterMenuItems);

        List<MenuItem> csvMenuItems=new ArrayList<>();
        csvMenu.setName("csv Menu");
        csvMenuItems.add(new MenuItem("Order read",new OrderRead(),csvMenu));
        csvMenuItems.add(new MenuItem("Order write",new OrderWrite(),csvMenu));
        csvMenuItems.add(new MenuItem("Work read",new WorkRead(),csvMenu));
        csvMenuItems.add(new MenuItem("Work write",new WorkWrite(),csvMenu));
        csvMenuItems.add(new MenuItem("Master read",new MasterRead(),csvMenu));
        csvMenuItems.add(new MenuItem("Master write",new MasterWrite(),csvMenu));

        List<MenuItem> mainMenuItems = new ArrayList<>();
        mainMenu.setName("Main menu");
        mainMenuItems.add(new MenuItem("Order Menu", null, orderMenu));
        mainMenuItems.add(new MenuItem("Order Sort", null, sortOrderMenu));
        mainMenuItems.add(new MenuItem("Master Menu", null, masterMenu));
        mainMenuItems.add(new MenuItem("Master Sort", null, sortMasterMenu));
        mainMenuItems.add(new MenuItem("Work menu",null,workMenu));
        mainMenuItems.add(new MenuItem("csv Menu",null,csvMenu));
        mainMenuItems.add(new MenuItem("View Free Place", new ViewFreeBox(), mainMenu));
        mainMenuItems.add(new MenuItem("Free up space in the BOX", new FreeUpSpaceBox(), mainMenu));
        mainMenuItems.add(new MenuItem("Modify BOX Capacity", new ModifyBoxCapacity(), mainMenu));
        mainMenuItems.add(new MenuItem("Exit", null, null));
        mainMenu.setMenuItem(mainMenuItems);
        this.rootMenu = mainMenu;

    }


    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

}
