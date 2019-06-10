package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	/**
	 * 부모타입에 기본생성자가 없기 떄문에 파라미터 생성자를 구현 강제화
	 * @param request wrapping 하고자 하는 객체
	 */
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	/**
	 * getParameter메소드 오버라이드
	 */
	@Override
	public String getParameter(String key) {
		String value = "";
		if(key != null &&(key.equals("userPwd") || key.equals("re_userPwd")) ) {
			System.out.println("암호화 전 : " + super.getParameter(key));
			
			value = getSha512(super.getParameter(key));
			System.out.println("암호화 후 : " + value);
		} else {
			value = super.getParameter(key);
		}
		
		return value;
	}
	
	public String getSha512(String password) {
		String encPwd = null;
		
		//암호화 객체 생성
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//전달받은 문자열 userPwd를 byte배열로 변환
		byte[] btes = password.getBytes(Charset.forName("utf-8"));
		
		//md객체에 byte배열을 전달해서 갱신
		md.update(btes);
		
		//java.util.Base64 인코더를 이용해서 암호화된 바이트배열로 인코딩
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;
	}
}
