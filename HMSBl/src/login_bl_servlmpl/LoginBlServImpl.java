package login_bl_servlmpl;

import PO.OrderPO;
import VO.*;
import helper.ParseHelper;
import login_bl_serv.LoginBlServ;
import PO.UserPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 棰濓紝鐧诲嚭鏆傛椂涓嶇煡閬撴�庝箞鎼�
 */
public class LoginBlServImpl implements LoginBlServ {

    @Override
    public LoginResult login(String id, String password) {
        UserPO userPO = null;
        LoginResult result = LoginResult.EXCEPTION;
        try {
            userPO = RemoteHelper.getInstance().getUserDataServ().getUser(id);
            if(userPO == null) {
                result = LoginResult.WRONG_ID;
            }else if(!userPO.getPassword().equals(password)) {
                result = LoginResult.WRONG_PASSWORD;
            }else if(userPO.getIsLogin() > 0) {
                result = LoginResult.ALREADY_LOGIN;
            }else {
                userPO.setIsLogin(1);
                RemoteHelper.getInstance().getUserDataServ().modifiedUser(userPO);
                result = LoginResult.SUCCESS;
            }
        }catch (RemoteException e) {
        	e.printStackTrace();
            result = LoginResult.EXCEPTION;
        }
        return result;
    }

    /**
     * @deprecated 涓嶇敤浜�
     * 鐧诲綍鏂规硶锛屽鏋滄病鏈夎繖涓敤鎴凤紝杩斿洖wrongId
     * 濡傛灉瀵嗙爜涓嶆纭紝杩斿洖wrongPassword
     * 鐧诲綍鎴愬姛锛岃繑鍥瀞uccess
     * 鐧诲綍鍐茬獊,杩斿洖alreadyLogin
     */
    public LoginResult oldLogin(String id, String password) {
        UserPO userPO = null;
        try {
            userPO = RemoteHelper.getInstance().getUserDataServ().getUser(id);
            if (userPO == null) {
                return LoginResult.WRONG_ID;
            }
            if (userPO.getIsLogin() > 0) {
                return LoginResult.ALREADY_LOGIN;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        boolean correct = password.equals(userPO.getPassword());
        if (correct) {
            userPO.setIsLogin(1);
            try {
                RemoteHelper.getInstance().getUserDataServ().modifiedUser(userPO);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return LoginResult.SUCCESS;
        } else {
            return LoginResult.WRONG_PASSWORD;
        }
    }

    @Override
    /**
     * 娉ㄥ唽涓�涓敤鎴凤紝鎴愬姛杩斿洖true
     * 澶辫触杩斿洖false
     */
    public boolean register(UserVO user, UserLoginInfo userLoginInfo) {
        UserPO userPO = parseUserPO(user, userLoginInfo);
        boolean success = false;
        try {
            success = RemoteHelper.getInstance().getUserDataServ().insertUser(userPO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    /**
     * 杩樻病瀹炵幇
     */
    public boolean logout(String id) {
        return false;
    }

    @Override
    public UserVO getUserInfo(String id) {
        UserPO userPO = null;
        try {
            userPO = RemoteHelper.getInstance().getUserDataServ().getUser(id);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        UserVO userVO = parseUserVO(userPO);
        return userVO;
    }

    /**
     * 鐢ㄤ簬灏哣O杞垚PO
     *
     * @param userVO
     * @return
     */
    private UserPO parseUserPO(UserVO userVO, UserLoginInfo info) {
        String id = info.getUserId();
        String password = info.getPassword();
        String contact = userVO.getContact();
        String name = userVO.getName();
        String specialInfo = userVO.getAdditionalInfo();
        int credit = userVO.getCredit();
        int vipLevel = userVO.getGrade();
        int isLogin = 0;
        String type = userVO.getType().toString(); //娌℃祴璇曪紝涔熻鏈夐棶棰�
        UserPO userPO = new UserPO(id, password, contact, name, specialInfo, credit, vipLevel, isLogin, type);
        return userPO;
    }

    /**
     * 杩樻病鍐欏ソ锛屽湪鑰冭檻鎬庝箞鎶婅鍗曞垪琛ㄥ姞杩涘幓锛屾垨鑰呯洿鎺ヤ笉瑕佷簡
     *
     * @param userPO
     * @return
     */
    private UserVO parseUserVO(UserPO userPO) {
        String name = userPO.getName();
        String contact = userPO.getContactInfo();
        int credit = userPO.getCreditTol();
        int grade = userPO.getVipLev();
        ArrayList<OrderVO> orderVOs = new ArrayList<>();
        UserType type = ParseHelper.stringToUserType(userPO.getType());
        String additionalInfo = userPO.getSpecialInfo();
        try {
            ArrayList<OrderPO> orderPOs = RemoteHelper.getInstance().getOrderDataServ().getOrders(userPO.getID());
            orderPOs.forEach(orderPO -> orderVOs.add(ParseHelper.toOrderVO(orderPO)));
        }catch (RemoteException e) {
            e.printStackTrace();
        }
        UserVO userVO = new UserVO(name,contact,credit,grade,orderVOs,type,additionalInfo);
        return userVO;
    }
}