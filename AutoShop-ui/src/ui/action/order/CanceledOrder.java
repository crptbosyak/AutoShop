package ui.action.order;




import ui.api.IAction;
import ui.connect.Connect;
import ui.utils.TextWorker;


public class CanceledOrder implements IAction {

    @Override
    public void execute() {
        TextWorker textWorker = new TextWorker();
        Connect.getInstance().send("viewAllOrder");
        textWorker.println("enter order num");
        String num = textWorker.getStringLine();
        Connect.getInstance().send("canceledOrder", num);

    }
}
