package login_bl_serv;

import VO.LoginResult;
import VO.UserLoginInfo;
import VO.UserVO;
import login_bl_servlmpl.LoginBlServImpl;

public interface LoginBlServ {

	public static LoginBlServ getInstance() {
		return new LoginBlServImpl();
	}
/**
 * test...
 * /
	/**
	 * 登录方法，如果没有这个用户，返回WRONG_ID
	 * 如果密码不正确，返回WRONG_PASSWORD
	 * 登录成功，返回SUCCESS
	 * 登录冲突，返回ALREADY_LOGIN
	 * 其他情况，返回EXCEPTION
	 * @param id 用户的id
	 * @param password 用户的密�?
     * @return 返回�?个登录结�?
     */
	public LoginResult login(String id, String password);

	/**
	 * 注册�?个用户，返回是否注册成功
	 * @param user 用户
	 * @return 注册结果
     */
	public boolean register(UserVO user, UserLoginInfo loginInfo);

	/**
	 * 得到用户信息
	 * 如果没登录或者没有这个id（不太可能出现）则返回null
	 * @param id 用户的id
	 * @return 返回用户的信�?
     */
	public UserVO getUserInfo(String id);

	/**
	 * 注销登录
	 * @return 返回是否成功
     */
	public boolean logout(String id);
}
