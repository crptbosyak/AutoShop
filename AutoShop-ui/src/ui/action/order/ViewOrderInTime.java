package ui.action.order;



import ui.api.IAction;
import ui.connect.Connect;
import ui.utils.TextWorker;

public class ViewOrderInTime implements IAction {
    @Override
    public void execute() {
        TextWorker textWorker=new TextWorker();
        System.out.println("enter time interval in format HH:mm dd/MM/yy \nfirst:");
        String firstTime = textWorker.getStringLine();
        System.out.println("second in format - HH:mm dd/MM/yy  ");
        String secondTime = textWorker.getStringLine();


        Connect.getInstance().send("viewOrderInTime",firstTime,secondTime);



    }
}
