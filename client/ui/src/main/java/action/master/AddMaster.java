package action.master;


import api.IAction;
import connection.Connect;
import utility.TextWorker;


public class AddMaster implements IAction {
    @Override
    public void execute() {
        TextWorker worker=new TextWorker();
        Connect.getInstance().send("viewAllMaster");
        worker.println("enter master name");
        String name=worker.getStringInput();
        worker.println("enter Date of birth");
        String dateOfBirth=worker.getStringInput();
        worker.println("enter phone number");
        String phoneNumber=worker.getStringInput();
        worker.println("enter specialty");
        String specialty=worker.getStringInput();

        Connect.getInstance().send("addMaster",name,dateOfBirth,phoneNumber,specialty);

    }
}