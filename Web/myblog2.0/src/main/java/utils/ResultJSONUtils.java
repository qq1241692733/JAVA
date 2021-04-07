package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/7
 * Time: 21:43
 */
public class ResultJSONUtils {

    public static void write(HttpServletResponse response, HashMap<String,Object> data) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        //Hashmap转JOSN
        ObjectMapper mapper = new ObjectMapper();
        writer.println(mapper.writeValueAsString(data));
    }

}
