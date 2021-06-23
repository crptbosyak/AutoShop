import dao.BoxDao;

public class BoxService {
    private final BoxDao boxDao;

    public BoxService( ){
        this.boxDao=new BoxDao();
    }
    public String viewAllCarInBox(String boxId) {


        return boxDao.view(boxDao.viewCarinBox(Integer.parseInt(boxId)));
    }
    public synchronized String freeUpSpaceBox(String carId) {
      return   boxDao.freeUpSpaceBox(Integer.parseInt(carId));
    }

    public synchronized String modifyBoxCapacity(String boxId, String newCapacity) {
        boxDao.modifyBoxCapacity(Integer.parseInt(boxId),Integer.parseInt(newCapacity));
        return "successfully";
    }

    public String viewFreeBox(String boxId) {

        return String.valueOf(boxDao.viewFreeBox(Integer.parseInt(boxId)));

    }



}
