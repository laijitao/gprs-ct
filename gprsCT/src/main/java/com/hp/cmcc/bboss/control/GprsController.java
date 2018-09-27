package com.hp.cmcc.bboss.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hp.cmcc.bboss.service.CompareService;
import com.hp.cmcc.bboss.service.GprsService;

@RestController
public class GprsController {

    @Autowired
    GprsService gprsService;
    @Autowired
    CompareService compareService;

    /** 
     * @Title: handle 
     * @Description: TODO
     * @param @param date:文件名中的日期
     * @param @return    参数 
     * @return String    返回类型 
     * @throws 
     */ 
    @RequestMapping(value = "/handle/{date}", method = RequestMethod.GET)
    public String handle(@PathVariable(value = "date") String date) {
    	return compareService.handleCompare(date);
    }
    
}
