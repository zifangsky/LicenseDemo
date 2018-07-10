package cn.zifangsky.license;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * LicenseCheckInterceptor
 *
 * @author zifangsky
 * @date 2018/4/25
 * @since 1.0.0
 */
public class LicenseCheckInterceptor extends HandlerInterceptorAdapter{
    private static Logger logger = LogManager.getLogger(LicenseCheckInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LicenseVerify licenseVerify = new LicenseVerify();

        //校验证书是否有效
        boolean verifyResult = licenseVerify.verify();

        if(verifyResult){
            return true;
        }else{
            response.setCharacterEncoding("utf-8");
            Map<String,String> result = new HashMap<>(1);
            result.put("result","您的证书无效，请核查服务器是否取得授权或重新申请证书！");

            response.getWriter().write(JSON.toJSONString(result));

            return false;
        }
    }

}
