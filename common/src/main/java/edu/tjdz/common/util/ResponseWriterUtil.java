package edu.tjdz.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ResponseWriterUtil {

    public static void write(ResultVO resultVO, HttpServletResponse response){
        PrintWriter writer =null;
        try {
            response.setContentType("application/json;charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            String str = null;
            str = objectMapper.writeValueAsString(resultVO);
           writer = response.getWriter();
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                writer.flush();
                writer.close();
            }

        }


    }
}
