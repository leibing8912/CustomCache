package cn.jianke.customcache.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: StringUtil
 * @classDescription: 字符串操作
 * @author: leibing
 * @createTime: 2016/08/26
 */
public class StringUtil {

	/**
	 * 判断是否为null或空字符串
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str
	 * @return
	 */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

	/**
	 * 判断是否不为null或不是空字符串
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str
	 * @return
	 */
    public static boolean isNotEmpty(String str){
		if (str == null || str.trim().equals(""))
			return false;
		return true;
    }

	/**
	 * 判断整型
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str
	 * @return
	 */
    public static boolean isNumber(String str) {
    	   return str.matches("[\\d]+");
    }

	/**
	 * //判断小数，与判断整型的区别在与d后面的小数点（红色）
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str
	 * @return
	 */
	public static boolean isFloatNumber(String str) {
	   return str.matches("[\\d.]+");
	}

	/**
	 * 验证手机号码是否合法
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param phoneNumber 手机号码
	 * @return
	 */
    public static boolean isPhoneNumber(String phoneNumber) {
        String reg = "1[3,4,5,7,8]{1}\\d{9}";
        return phoneNumber.matches(reg);
    }

	/**
	 * 合法密码，6位以上的数字和字母
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param password 密码
	 * @return
	 */
	public static boolean isPassword( String password ){
		Pattern p = Pattern.compile("^([0-9]|[a-zA-Z]){6,}$");                            
	    Matcher m = p.matcher(password); 
	    return m.matches();
	}

	/**
	 * 去掉空格换行符
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
	    String dest = "";
	    if (str!=null) {
	        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	        Matcher m = p.matcher(str);
	        dest = m.replaceAll("");
	    }
	    return dest;
	}

	/**
	 * 截取一定区间的字符串
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str 要截取的字符串
	 * @param start 截取开始位置
	 * @param end 截取结束的位置
	 * @return
	 */
	public static String substring(String str,int start,int end){
        if (isEmpty(str)) {
            return "";
        }
        int len = str.length();
        if (start > end) {
            return "";
        }
        if (start > len) {
            return "";
        }
        if (end > len) {
            return str.substring(start, len);
        }
        return str.substring(start,end);
    }

	/**
	 * 字符串转整型
	 * @author leibing
	 * @createTime 2016/08/26
	 * @lastModify 2016/08/26
	 * @param str
	 * @return
	 */
	public static int strToInt(String str){
		int i = 0;
		if(StringUtil.isNotEmpty(str)){
			try{
				i = Integer.parseInt(str);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return i;
	}
}
