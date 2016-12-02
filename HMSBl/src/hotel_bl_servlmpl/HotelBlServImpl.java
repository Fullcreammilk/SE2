package hotel_bl_servlmpl;

import PO.HotelPO;
import PO.HotelStrategyPO;
import PO.RoomPO;
import VO.*;
import hotel_bl_serv.HotelBlServ;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class HotelBlServImpl implements HotelBlServ {
    @Override
    public HotelVO getHotelInfo(String name) {
        HotelPO hotelPO = null;
        try {
            hotelPO = RemoteHelper.getInstance().getHotelDataServ().getHotel(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (hotelPO == null) {
                return null;
            }
        }
        String hotelName = hotelPO.getName();
        String CBD = hotelPO.getBC();
        String location = hotelPO.getAddress();
        ArrayList<String> comments = hotelPO.getComment();
        double star = hotelPO.getStars();
        String introduction = hotelPO.getINTRO();
        ArrayList<RoomPO> rooms = hotelPO.getRoom();
        ArrayList<String> cooperative = hotelPO.getCompanies();
        ArrayList<HotelStrategyPO> strategies = hotelPO.getStrategy();
        HotelVO hotelVO = new HotelVO(hotelName, CBD, location, stringToComment(comments), (int) star, introduction, changeRoomToVO(rooms), cooperative, changeStrategyToVO(strategies));
        return hotelVO;
    }

    @Override
    public boolean modifyHotelInfo(HotelVO hotel) {
        String hotelName = hotel.getName();
        String bc = hotel.getCBD();
        String intro = hotel.getIntro();
        String address = hotel.getLocation();
        double stars = hotel.getStarLevel();
        HotelPO hotelPO = new HotelPO(hotelName, bc, intro, address, stars);
        boolean success = false;
        try {
            success = RemoteHelper.getInstance().getHotelDataServ().modifiedHotel(hotelPO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Iterator<StrategyVO> getStrategyList(String hotelName) {
        HotelPO hotelPO;
        ArrayList<StrategyVO> strategyVOs = new ArrayList<>();
        try {
            hotelPO = RemoteHelper.getInstance().getHotelDataServ().getHotel(hotelName);
            ArrayList<HotelStrategyPO> hotelStrategyPOs = hotelPO.getStrategy();
            for (HotelStrategyPO hotelStrategyPO : hotelStrategyPOs) {
                strategyVOs.add(parseStrategyVO(hotelStrategyPO));
            }
//            hotelStrategyPOs.forEach(hotelStrategyPO -> strategyVOs.add(parseStrategyVO(hotelStrategyPO)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return strategyVOs.iterator();
    }

    @Override
    public Iterator<HotelVO> getAllHotel(String businessCircle) {
        ArrayList<HotelPO> hotelPOs;
        ArrayList<HotelVO> hotelVOs = new ArrayList<>();
        try {
            hotelPOs = RemoteHelper.getInstance().getHotelDataServ().getHotelList(businessCircle);
            hotelPOs.forEach(hotelPO -> hotelVOs.add(parseHotelVO(hotelPO)));
        }catch (RemoteException e) {
            e.printStackTrace();
        }
        return hotelVOs.iterator();
    }

    /**
     * 宸茬粡鍐欏ソ浜�
     * @param hotelPO
     * @return
     */
    private HotelVO parseHotelVO(HotelPO hotelPO) {
        HotelVO hotelVO;
        String name = hotelPO.getName();
        String CBD = hotelPO.getBC();
        String location = hotelPO.getAddress();
        ArrayList<CommentVO> comments = stringToComment(hotelPO.getComment());
        int starLevel = (int)hotelPO.getStars();
        String intro = hotelPO.getINTRO();
        ArrayList<RoomVO> rooms = changeRoomToVO(hotelPO.getRoom());
        ArrayList<String> cooperativeEnterprise = hotelPO.getCompanies();
        ArrayList<StrategyVO> strategies = changeStrategyToVO(hotelPO.getStrategy());
        hotelVO = new HotelVO(name,CBD,location,comments,starLevel,intro,rooms,cooperativeEnterprise,strategies);
        return hotelVO;
    }

    /**
     * 娌″啓瀹岋紝闇�瑕佹洿澶氭帴鍙�
     *
     * @param hotelStrategyPO
     * @return
     */
    private StrategyVO parseStrategyVO(HotelStrategyPO hotelStrategyPO) {
        String type = hotelStrategyPO.getType();
        StrategyVO strategyVO;
        String name = hotelStrategyPO.getStrategyName();
        double discount = hotelStrategyPO.getDiscount();
        switch(type) {
            case "birthday":
                strategyVO = new BirthdayStrategy(name,discount);
            case "double_eleven":
//                strategyVO = new DoubleElevenStrategy();
            case "room_number":
//                strategyVO = new RoomNumberStrategy();
            case "cooperative":
//                strategyVO = new CooperativeStrategy();
        }
        return null;
    }

    /**
     * 鍐欏ソ浜嗭紝鎶婂瓧绗︿覆鍨嬬殑璇勮杞寲鎴怌ommentVO
     * 灏嗘潵甯屾湜鍙互鏀规垚甯︽湁鐢ㄦ埛鍚嶇殑
     *
     * @param comment
     * @return
     */
    private ArrayList<CommentVO> stringToComment(ArrayList<String> comment) {
        ArrayList<CommentVO> commentVOs = new ArrayList<>();
        for (String oneComment : comment) {
            CommentVO commentVO = new CommentVO(oneComment);
            commentVOs.add(commentVO);
        }
        return commentVOs;
    }

    /**
     * 鍐欏ソ浜嗭紝鐢ㄦ潵鎶奝O鍙樻垚VO
     * 鍙嶆鏄鏈夋柟娉曢殢渚挎墦鎵撴敞閲婂簲璇ヤ笉浼氭鍚�
     *
     * @param rooms 瑕佸彉鐨凱O
     * @return
     */
    private ArrayList<RoomVO> changeRoomToVO(ArrayList<RoomPO> rooms) {
        ArrayList<RoomVO> roomVOs = new ArrayList<>();
        for (RoomPO roomPO : rooms) {
            String roomType = roomPO.getType();
            int price = (int) roomPO.getPrice();
            int total = roomPO.getTotel();
            int[] available = roomPO.getNum();
            RoomVO roomVO = new RoomVO(roomType, price, total, available);
            roomVOs.add(roomVO);
        }
        return roomVOs;
    }

    /**
     * 鍐欏ソ浜嗭紝鐢ㄦ潵鍚O鍙樻垚VO
     *
     * @param strategys 闇�瑕佸彉鐨勭瓥鐣ョ被鐨凱O
     * @return
     */
    private ArrayList<StrategyVO> changeStrategyToVO(ArrayList<HotelStrategyPO> strategys) {
        ArrayList<StrategyVO> strategyVOs = new ArrayList<>();
        for (HotelStrategyPO hotelStrategyPO : strategys) {
            StrategyVO strategyVO = parseStrategyVO(hotelStrategyPO);
            strategyVOs.add(strategyVO);
        }
        return strategyVOs;
    }
}
